# Tutorial: Build and Test a Serverless Application with AWS Lambda<a name="lambda-build-test-severless-app"></a>

You can build a serverless Lambda application by using an AWS Toolkit for Visual Studio template\. The Lambda project templates include one for an **AWS Serverless Application**, which is the AWS Toolkit for Visual Studio implementation of the [AWS Serverless Application Model \(AWS SAM\)](https://github.com/awslabs/serverless-application-model)\. Using this project type you can develop a collection of AWS Lambda functions and deploy them with any necessary AWS resources as a whole application, using AWS CloudFormation to orchestrate the deployment\.

For prerequisites and information about setting up the AWS Toolkit for Visual Studio, see [Using the AWS Lambda Templates in the AWS Toolkit for Visual Studio](lambda-index.md)\.

**Topics**
+ [Create a New AWS Serverless Application Project](#create-a-new-aws-serverless-application-project)
+ [Examine the Files in the Serverless Application](#examine-the-files-in-the-serverless-application)
+ [Deploy the Serverless Application](#deploy-the-serverless-application)
+ [Test the Serverless Application](#test-the-serverless-application)

## Create a New AWS Serverless Application Project<a name="create-a-new-aws-serverless-application-project"></a>

1. Open Visual Studio, and on the **File** menu, choose **New**, **Project**\.

1. **For Visual Studio 2017**:

   In the **New Project** dialog box, expand **Installed**, expand **Visual C\#**, and select **AWS Lambda**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/CreateNewProject-06-Serverless-Lambda-VS2017.png)

   **For Visual Studio 2019**:

   In the **New Project** dialog box, ensure that the **Language**, **Platform**, and **Project type** drop\-down boxes are set to "All \.\.\." and type *aws lambda* in the **Search** field\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/CreateNewProject-06-Serverless-Lambda-VS2019.png)

   There are two types of project to choose from:
   + AWS Lambda projects for creating a project to develop and deploy an individual Lambda function\.
   + AWS Serverless Applications projects for creating Lambda functions with a serverless AWS CloudFormation template\. AWS serverless applications enable you to define more than just the function\. For example, you can simultaneously create a database, add IAM roles, etc\., with serverless deployment\. AWS serverless applications also enable you to deploy multiple functions at one time\.

1. Select the **AWS Serverless Application with Tests \(\.NET Core \- C\#\)** template\.

1. **For Visual Studio 2017**:

   Enter "Blogger" for the **Name**, enter the desired **Location**, etc\., and then click **OK**\.

   **For Visual Studio 2019**:

   Click **Next**\. In the next dialog, enter "Blogger" for the **Name**, enter the desired **Location**, etc\., and then click **Create**\.

1. The **Select Blueprint** page shows several Lambda function templates\.  
![\[Blueprints for an AWS Lambda Serverless project\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/serverless-blueprints.png)

1. Choose the **Blog API using DynamoDB** blueprint, and then choose **Finish** to create the Visual Studio project\.

## Examine the Files in the Serverless Application<a name="examine-the-files-in-the-serverless-application"></a>

 **Blog\.cs** 

 `Blog.cs` is a simple class used to represent the blog items that are stored in Amazon DynamoDB\.

 **Functions\.cs** 

 `Functions.cs` defines the C\# functions to expose as Lambda functions\. There are four functions defined to manage a blog platform:
+  `GetBlogsAsync`: gets a list of all the blogs\.
+  `GetBlogAsync`: gets a single blog identified by the query parameter ID or by the ID added to the URL resource path\.
+  `AddBlogAsync`: adds a blog to DynamoDB table\.
+  `RemoveBlogAsync`: removes a blog from the DynamoDB table\.

Each of these functions accepts an [APIGatewayProxyRequest](https://github.com/aws/aws-lambda-dotnet/blob/master/Libraries/src/Amazon.Lambda.APIGatewayEvents/APIGatewayProxyRequest.cs) object and returns an [APIGatewayProxyResponse](https://github.com/aws/aws-lambda-dotnet/blob/master/Libraries/src/Amazon.Lambda.APIGatewayEvents/APIGatewayProxyResponse.cs)\.

You expose these Lambda functions as HTTP APIs by using Amazon API Gateway\. The `APIGatewayProxyRequest` contains all the information representing the HTTP request\. The `GetBlogAsync` task finds the blog ID in the resource path or query string\.

```
public async Task GetBlogAsync(APIGatewayProxyRequest request, ILambdaContext context)
{
    string blogId = null;
    if (request.PathParameters != null && request.PathParameters.ContainsKey(ID_QUERY_STRING_NAME))
        blogId = request.PathParameters[ID_QUERY_STRING_NAME];
    else if (request.QueryStringParameters != null && request.QueryStringParameters.ContainsKey(ID_QUERY_STRING_NAME))
        blogId = request?.QueryStringParameters[ID_QUERY_STRING_NAME];
    ...
}
```

The default constructor for this class passes the name of the DynamoDB table storing the blogs as an environment variable\. This environment variable is set when Lambda deploys the function\.

```
public Functions()
{
    // Check if a table name was passed in through environment variables and, if so,
    // add the table mapping
    var tableName = System.Environment.GetEnvironmentVariable(TABLENAME_ENVIRONMENT_VARIABLE_LOOKUP);
    if(!string.IsNullOrEmpty(tableName))
    {
        AWSConfigsDynamoDB.Context.TypeMappings[typeof(Blog)] = new Amazon.Util.TypeMapping(typeof(Blog), tableName);
    }

    var config = new DynamoDBContextConfig { Conversion = DynamoDBEntryConversion.V2 };
    this.DDBContext = new DynamoDBContext(new AmazonDynamoDBClient(), config);
}
```

 **serverless\.template** 

The `serverless.template` is the AWS CloudFormation template used to deploy the four functions\. The parameters for the template enable you to set the name of the DynamoDB table, and choose whether you want DynamoDB to create the table or to assume the table is already created\.

The template defines four resources of type `AWS::Serverless::Function`\. This is a special meta resource defined as part of the AWS SAM specification\. The specification is a transform that is applied to the template as part of the DynamoDB deployment\. The transform expands the meta resource type into the more concrete resources, like `AWS::Lambda::Function` and `AWS::IAM::Role`\. The transform is declared at the top of the template file, as follows\.

```
{
    "AWSTemplateFormatVersion" : "2010-09-09",
    "Transform" : "AWS::Serverless-2016-10-31",

    ...

}
```

The `GetBlogs` declaration is similar to the function declarations\.

```
"GetBlogs" : {
    "Type" : "AWS::Serverless::Function",
    "Properties": {
        "Handler": "Blogger::Blogger.Functions::GetBlogsAsync",
        "Runtime": "dotnetcore1.0",
        "CodeUri": "",
        "Description": "Function to get a list of blogs",
        "MemorySize": 256,
        "Timeout": 30,
        "Role": null,
        "Policies": [ "AWSLambdaFullAccess" ],
        "Environment" : {
            "Variables" : {
                "BlogTable" : { "Fn::If" : ["CreateBlogTable", {"Ref":"BlogTable"}, { "Ref" : "BlogTableName" } ] }
            }
        },
      "Events": {
          "PutResource": {
              "Type": "Api",
              "Properties": {
                  "Path": "/",
                  "Method": "GET"
              }
          }
      }
    }
}
```

Many of the fields are similar to those of a Lambda project deployment\. In the `Environment` property, the name of the DynamoDB table is passed in as an environment variable\. The `CodeUri` property tells DynamoDB where your application bundle is stored in Amazon S3\. Leave this property blank\. The toolkit fills it in during deployment, after it uploads the application bundle to S3 \(it won't change the template file on disk when it does so\)\. The `Events` section is where the HTTP bindings are defined for your Lambda function\. This is all the API Gateway setup you need for your function\. You can also set up other types of event sources in this section\.

![\[Add an event source\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/template-addeventsource.png)

One of the benefits of using AWS CloudFormation to manage the deployment is you can also add and configure any other AWS resources necessary for your application in the template, and let DynamoDB take care of creating and deleting the resources\.

![\[Add a resource\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/template-addresources.png)

## Deploy the Serverless Application<a name="deploy-the-serverless-application"></a>

Deploy the serverless application by right\-clicking the project and choosing **Publish to AWS Lambda**\.

![\[Publish the project\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/serverless-publishmenu.png)

This launches the deployment wizard, and because all the Lambda configuration was done in the `serverless.template` file, all you need to supply are the following:
+ The name of the CloudFormation stack, which will be the container for all the resources declared in the template\.
+ The S3 bucket to upload your application bundle to\.

These must exist in the same AWS Region\.

![\[Enter publish details\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/serverless-first-page.png)

Because the serverless template has parameters, an additional page is displayed in the wizard so you can specify the values for the parameters\. You can leave the `BlogTableName` property blank and let CloudFormation generate a unique name for the table\. You do need to set `ShouldCreateTable` to `true` so that DynamoDB will create the table\. To use an existing table, enter the table name and set the `ShouldCreateTable` parameter to `false`\. You can leave the other fields at their default values and choose **Publish**\.

![\[Edit template parameters\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/serverless-second-page.png)

Once the publish step is complete, the CloudFormation stack view is displayed in AWS Explorer\. This view shows the progress of the creation of all the resources declared in your serverless template\.

![\[CloudFormation stack view\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/serverless-stack-view.png)

## Test the Serverless Application<a name="test-the-serverless-application"></a>

When the stack creation is complete, the root URL for the API Gateway is displayed on the page\. If you click that link, it returns an empty JSON array because you haven't added any blogs to the table\. To get blogs in the table, you need to make an HTTP PUT method to this URL, passing in a JSON document that represents the blog\. You can do that in code or in any number of tools\. This example uses the Postman tool, which is a Chrome browser extension, but you can use any tool you like\. In this tool, you set the URL and change the method to PUT\. In the **Body** tab, you put in some sample content\. When you make the HTTP call, you can see the blog ID is returned\.

![\[Post the blog\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/procman-addpost.png)

Go back to the browser with the link to the AWS Serverless URL and you can see you are getting back the blog you just posted\.

![\[Get the blog\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/get-post.png)

Using the AWS Serverless Application template, you can manage a collection of Lambda functions and the application's other AWS resources\. Also, with the AWS SAM specification, you can use a simplified syntax to declare a serverless application in the DynamoDB template\.