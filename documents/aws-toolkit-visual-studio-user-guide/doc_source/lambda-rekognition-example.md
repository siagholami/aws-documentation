# Tutorial: Creating an Amazon Rekognition Lambda Application<a name="lambda-rekognition-example"></a>

This tutorial shows you how to create an Lambda application that uses Amazon Rekognition to tag Amazon S3 objects with detected labels\.

For prerequisites and information about setting up the AWS Toolkit for Visual Studio, see [Using the AWS Lambda Templates in the AWS Toolkit for Visual Studio](lambda-index.md)\.

## Create a Visual Studio \.NET Core Lambda Image Rekognition Project<a name="create-a-visual-studio-net-core-lam-image-rekognition-project"></a>

1. Open Visual Studio, and on the **File** menu, choose **New**, **Project**\.

1. **For Visual Studio 2017**:

   In the **New Project** dialog box, expand **Installed**, expand **Visual C\#**, and select **AWS Lambda**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/CreateNewProject-07-Lambda-Rekognition-VS2017.png)

   **For Visual Studio 2019**:

   In the **New Project** dialog box, ensure that the **Language**, **Platform**, and **Project type** drop\-down boxes are set to "All \.\.\." and type *aws lambda* in the **Search** field\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/CreateNewProject-07-Lambda-Rekognition-VS2019.png)

1. Select the **AWS Lambda Project with Tests \(\.NET Core \- C\#\)** template\.

1. **For Visual Studio 2017**:

   Name the project "ImageRekognition", enter the desired **Location**, etc\., and then click **OK**\.

   **For Visual Studio 2019**:

   Click **Next**\. In the next dialog, enter "ImageRekognition" for the **Name**, enter the desired **Location**, etc\., and then click **Create**\.

1. Choose a blueprint\. Blueprints provide starting code to help you write your Lambda functions\. For this example, choose the **Detect Image Labels** blueprint\.

   This blueprint provides code for listening to Amazon S3 events and uses Amazon Rekognition to detect labels and add them to the S3 object as tags\.  
![\[Blueprints for an AWS Lambda project\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/lambda-blueprints.png)

1. Choose the type of Lambda function you want to develop, and then choose **Finish** to create the Visual Studio project\.

When the project is complete, you have a solution with two projects, as shown: the source project that contains your Lambda function code to deploy to Lambda, and a test project using xUnit for testing your function locally\.

![\[Blueprints for an AWS Lambda project\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/lambda-solution-explorer.png)

You might notice when you first create your projects that Visual Studio doesn't find all the NuGet references\. This happens because these blueprints require dependencies that must be retrieved from NuGet\. When new projects are created, Visual Studio only pulls in local references and not remote references from NuGet\. You can fix this easily by right\-clicking your references and choosing **Restore Packages**\.

## Examine the Files<a name="examine-the-files"></a>

1. Open the `Function.cs` file and look at the code that came with the blueprint\. The first segment of code is the assembly attribute that is added to the top of the file\.

   ```
   // Assembly attribute to enable the Lambda function's JSON input to be converted into a .NET class.
   [assembly: LambdaSerializerAttribute(typeof(Amazon.Lambda.Serialization.Json.JsonSerializer))]
   ```

   By default, Lambda accepts only input parameters and return types of type `System.IO.Stream`\. To use typed classes for input parameters and return types, you have to register a serializer\. This assembly attribute is registering the Lambda JSON serializer, which uses `Newtonsoft.Json` to convert the streams to typed classes\. You can set the serializer at the assembly or method level\.

   The class has two constructors\. The first is a default constructor that is used when Lambda invokes your function\. This constructor creates the S3 and Rekognition service clients, and gets the AWS credentials for these clients from the IAM role you assign to the function when you deploy it\. The AWS Region for the clients is set to the region your Lambda function is running in\. In this blueprint, you only want to add tags to the S3 object if the Rekognition service has a minimum level of confidence about the label\. This constructor checks the environment variable `MinConfidence` to determine the acceptable confidence level\. You can set this environment variable when you deploy the Lambda function\.

   ```
   public Function()
   {
       this.S3Client = new AmazonS3Client();
       this.RekognitionClient = new AmazonRekognitionClient();
   
       var environmentMinConfidence = System.Environment.GetEnvironmentVariable(MIN_CONFIDENCE_ENVIRONMENT_VARIABLE_NAME);
       if(!string.IsNullOrWhiteSpace(environmentMinConfidence))
       {
           float value;
           if(float.TryParse(environmentMinConfidence, out value))
           {
               this.MinConfidence = value;
               Console.WriteLine($"Setting minimum confidence to {this.MinConfidence}");
           }
           else
           {
               Console.WriteLine($"Failed to parse value {environmentMinConfidence} for minimum confidence. Reverting back to default of {this.MinConfidence}");
           }
       }
       else
       {
           Console.WriteLine($"Using default minimum confidence of {this.MinConfidence}");
       }
   }
   ```

   You can use the second constructor for testing\. The test project configures its own S3 and Rekognition clients and passes them in\.

   ```
   public Function(IAmazonS3 s3Client, IAmazonRekognition rekognitionClient, float minConfidence)
   {
       this.S3Client = s3Client;
       this.RekognitionClient = rekognitionClient;
       this.MinConfidence = minConfidence;
   }
   ```

    `FunctionHandler` is the method Lambda calls after it constructs the instance\. Notice that the input parameter is of type `S3Event` and not a `Stream`\. You can do this because of the registered Lambda JSON serializer\. The `S3Event` contains all the information about the event triggered in Amazon S3\. The function loops through all the S3 objects that were part of the event and tells Rekognition to detect labels\. After the labels are detected, they are added as tags to the S3 object\.

   ```
   public async Task FunctionHandler(S3Event input, ILambdaContext context)
   {
       foreach(var record in input.Records)
       {
           if(!SupportedImageTypes.Contains(Path.GetExtension(record.S3.Object.Key)))
           {
               Console.WriteLine($"Object {record.S3.Bucket.Name}:{record.S3.Object.Key} is not a supported image type");
               continue;
           }
   
           Console.WriteLine($"Looking for labels in image {record.S3.Bucket.Name}:{record.S3.Object.Key}");
           var detectResponses = await this.RekognitionClient.DetectLabelsAsync(new DetectLabelsRequest
           {
               MinConfidence = MinConfidence,
               Image = new Image
               {
                   S3Object = new Amazon.Rekognition.Model.S3Object
                   {
                       Bucket = record.S3.Bucket.Name,
                       Name = record.S3.Object.Key
                   }
               }
           });
   
           var tags = new List();
           foreach(var label in detectResponses.Labels)
           {
               if(tags.Count < 10)
               {
                   Console.WriteLine($"\tFound Label {label.Name} with confidence {label.Confidence}");
                   tags.Add(new Tag { Key = label.Name, Value = label.Confidence.ToString() });
               }
               else
               {
                   Console.WriteLine($"\tSkipped label {label.Name} with confidence {label.Confidence} because maximum number of tags reached");
               }
           }
   
           await this.S3Client.PutObjectTaggingAsync(new PutObjectTaggingRequest
           {
               BucketName = record.S3.Bucket.Name,
               Key = record.S3.Object.Key,
               Tagging = new Tagging
               {
                   TagSet = tags
               }
           });
       }
       return;
   }
   ```

   Notice that the code contains calls to `Console.WriteLine()`\. When the function is running in Lambda, all calls to `Console.WriteLine()` redirect to Amazon CloudWatch Logs\.

1. Open the `aws-lambda-tools-defaults.json` file that the blueprint created\. This file contains default values that the blueprint has set to help prepopulate some of the fields in the deployment wizard\. It's also helpful in setting command line options with our integration with the new \.NET Core CLI\. To use it, navigate to the function's project directory and type *dotnet lambda help*\.

An important field is the function handler\. This indicates to Lambda the method to call in the code in response to the function we're invoking\. The format of this field is `<assembly-name>::<full-type-name>::<method-name>`\. Be sure to include the namespace with the type name\.

## Deploy the Function<a name="deploy-the-function"></a>

1. Right\-click the Lambda project, and then choose **Publish to AWS Lambda**\. This starts the deployment wizard\. Notice that many of the fields are already set\. These values come from the `aws-lambda-tools-defaults.json` file described earlier\.

1. Enter a function name\. For this example, use `ImageRekognition`, and then choose **Next**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/lambda-deployment-wizard-page1.png)

1. On the **Advanced Function Details** page, select an IAM role that gives permission for your code to access S3 and Rekognition\. To keep this post short, select the **Power User managed policy**\. The tools create a role based on this policy\.

1. Finally, set the environment variable `MinConfidence` to 60, and then choose **Upload**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/lambda-deployment-wizard-page2.png)

   This launches the deployment process, which builds and packages the Lambda project and then creates the Lambda function\. Once publishing is complete, the **Function** view in the **AWS Explorer** window is displayed\. From here, you can invoke a test function, view CloudWatch Logs for the function, and configure event sources\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/lambda-function-view.png)

1. With your function deployed, you need to configure Amazon S3 to send its events to your new function\. On the **Event Sources** tab, choose **Add**\. Then choose Amazon S3 and the bucket you want to connect to your Lambda function\. The bucket must be in the same region as the region where the Lambda function is deployed\.

## Test the Function<a name="test-the-function"></a>

Now that the function is deployed and an S3 bucket is configured as an event source for it, open the S3 bucket browser from the **AWS Explorer** for the bucket you selected\. Then upload some images\.

When the upload is complete, you can confirm that your function ran by looking at the logs from your function view\. Or, right\-click the images in the bucket browser and choose **Properties**\. On the **Tags** tab, you can view the tags that were applied to your object\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/lambda-object-properties.png)