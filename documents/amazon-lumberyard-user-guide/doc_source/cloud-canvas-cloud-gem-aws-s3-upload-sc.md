# Uploading a File to Amazon S3 with Script Canvas<a name="cloud-canvas-cloud-gem-aws-s3-upload-sc"></a>

You can use the **AWSBehaviorS3Upload** node in Script Canvas to upload a file from your computer to the Amazon S3 bucket that you specify\. If the object that you specify already exists, it is overwritten\.

**Topics**
+ [Step 1: Add Nodes that Upload a File to Amazon S3](#cloud-canvas-cloud-gem-aws-s3-upload-sc-add-nodes)
+ [Step 2: Add Nodes to Display the Result](#cloud-canvas-cloud-gem-aws-s3-upload-sc-display-result)
+ [Step 3: Test Upload a File to Amazon S3](#cloud-canvas-cloud-gem-aws-s3-upload-sc-test)
+ [Step 4: Verify the Upload](#cloud-canvas-cloud-gem-aws-s3-upload-sc-verify)

## Step 1: Add Nodes that Upload a File to Amazon S3<a name="cloud-canvas-cloud-gem-aws-s3-upload-sc-add-nodes"></a>

The following procedure shows you how to create a Script Canvas graph that uploads a file to Amazon S3\. The example uses the file `lumberyard_version\dev\Cache\CloudGemSamples\pc\cloudgemsamples\levels\awsbehaviorexamples\testdata\s3example.txt` that is included with Lumberyard\.

**To upload a file to Amazon S3**

1. In Lumberyard Editor, choose **Tools**, **Script Canvas**\.

1. In the **Node Palette**, expand **Utilities** and drag **On Graph Start** to the canvas\.

1. On the right, in **Variable Manager**, click **Create Variable**\.

1. In the **Variable Type** search box, enter **AWSBehaviorS3Upload**, or scroll down to **AWSBehaviorS3Upload**\.

1. Click **AWSBehaviorS3Upload**\. In **Node Inspector**, **AWSBehaviorS3Upload** **Variable** appears\. The default name of the variable is **Variable 1**\.

1. In **Node Inspector**, expand **AWSBehaviorS3Upload** to show the input fields\. Type the values in the following table into the corresponding boxes\. `KeyName` is the name that the file will have on Amazon S3\.  
****    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/cloud-canvas-cloud-gem-aws-s3-upload-sc.html)

1. From the **Variable Manager**, press **Shift** and drag **Variable 1 AWSBehaviorS3Upload** to the canvas to create the **Get Variable 1** node\. \(You can also drag **AWSBehaviorS3Upload** to the canvas and then select **Get Variable** from the drop\-down menu\.\)

1. Connect the **Out** pin of the **On Graph Start** node to the **In** pin of the **Get Variable 1** node\.

1. In the **Node Palette**, expand **AWS**, **AWSBehaviorS3Upload**\.

1. Drag the **Upload** node to the right of the **Get Variable 1** node on the canvas\.

1. Connect the **Out** pin of the **Get Variable 1** node to the **In** pin of the **Upload** node\.

1. Connect the **AWSBehaviorS3Upload** pin of the **Get Variable 1** node to the **AWSBehaviorS3Upload:0** pin of the **Upload** node\.

## Step 2: Add Nodes to Display the Result<a name="cloud-canvas-cloud-gem-aws-s3-upload-sc-display-result"></a>

Next, to see the success or failure of the operation, add **AWSBehaviorS3UploadNotificationBus** nodes and a **Print** node to the graph\. The nodes monitor for `AWSBehaviorS3UploadNotificationBus` events and show you the result in the Lumberyard console window\.

**To display the success or failure of the upload operation in the console window**

1. In the **Node Palette**, expand **AWS, AWSBehaviorS3UploadNotificationBus**\.

1. Drag **OnError** to the canvas\. Place the node under the three nodes that are already connected\.

1. Drag **OnSuccess** to the canvas and place it under the **OnError** node\.

1. In the **Node Palette**, expand **Utilities**, **Debug** and drag **Print** to the right of the two **AWSBehaviorS3UploadNotificationBus** nodes on the canvas\. The **Print** node displays messages in the Lumberyard Editor console\.

1. Connect the **Out** pins of the **AWSBehaviorS3UploadNotificationBus OnError** and **OnSuccess** nodes to the **In** pin of the **Print** node\.

1. Connect the **String** pins of the **AWSBehaviorS3UploadNotificationBus OnError** and **OnSuccess** nodes to the **Value** pin on the **Print** node\. Your canvas should look similar to the following image:  
![\[A Script Canvas graph that uploads a file to Amazon S3\]](http://docs.aws.amazon.com/lumberyard/latest/userguide/images/cloud_canvas/cloud-canvas-cloud-gem-aws-s3-upload-sc-1.png)

1. Save the canvas with a name like `MyS3UploadTest.scriptcanvas`\. The default file location is the `lumberyard_version\dev\project_name\scriptcanvas` directory\.

1. Exit the Script Canvas editor\.

## Step 3: Test Upload a File to Amazon S3<a name="cloud-canvas-cloud-gem-aws-s3-upload-sc-test"></a>

Now you are ready to attach the script canvas to an entity and test the script\.

**To test uploading to Amazon S3**

1. In Lumberyard Editor, right\-click the viewport and choose **Create entity**\.

1. In **Entity Inspector**, click **Add Component**\.

1. Under **Scripting**, click **Script Canvas** to add a **[Script Canvas](component-script-canvas.md)** component to the entity\.

1. Under **Script Canvas**, click the browse button \(**\.\.\.**\)\.

1. In the **Pick Script Canvas** dialog box, choose the canvas that you created ??? for example, **mys3uploadtest \(Script Canvas\)**, and then click **OK**\.

1. If the Lumberyard console window is not already open, press **`** or choose **Tools**, **Console** to open the console window\. If the console window is already open and you want to clear it, press **Ctrl\+Shift\+C**\.

1. Press **Ctrl\+G** to start the level\. The console reports the success of the operation, as in the following example\.

   ```
   general.enter_game_mode
   Returned:
   (Found resource management based identity pool %s.) - us-east-1:guid
   (Found resource management based identity pool %s for authenticated access.) - us-east-1:guid
   (CloudCanvas) - Anonymous Credentials pulled successfully for identity pool us-east-1:guid.
   Disable Accelerators
   (Script Canvas) - File Uploaded
   general.exit_game_mode
   ```

## Step 4: Verify the Upload<a name="cloud-canvas-cloud-gem-aws-s3-upload-sc-verify"></a>

To verify that the file has been uploaded to Amazon S3, you can use the AWS Management Console\.

**To verify that the test file has been uploaded to Amazon S3**

1. In a text editor, open the `lumberyard_version\dev\Cache\CloudGemSamples\pc\user\AWS\user-settings.json` file\.

1. In the `user-settings.json` file, locate the Amazon S3 name for the `CloudGemAWSScriptBehaviors.s3nodeexamples` bucket\. The Amazon S3 bucket name is in the string for the `PhysicalResourceId` attribute, as in the following example:

   ```
   "CloudGemAWSScriptBehaviors.s3nodeexamples": {
       "PhysicalResourceId": "cgsamples14-221-cgsamples14-221dep-s3nodeexamples-16ud5gt53zjx7", 
       "ResourceType": "AWS::S3::Bucket"
   ```

1. In Lumberyard Editor, choose **AWS**, **Open AWS Console**, **S3**\.

1. In the Amazon S3 management console, open the bucket that you identified in step 2\.

1. The `s3uploadtest.txt` file appears in the bucket\.