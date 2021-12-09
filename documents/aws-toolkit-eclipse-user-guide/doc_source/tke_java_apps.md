# Building an AWS Java Application<a name="tke_java_apps"></a>

In this section, we’ll use the AWS Toolkit for Eclipse to build and run a local Java application that accesses AWS resources\.

The AWS Toolkit for Eclipse includes the AWS SDK for Java and a number of Java sample programs\. The AWS Toolkit for Eclipse makes it easy to build and run any of these samples\. To demonstrate how the AWS Toolkit for Eclipse can help you build and run AWS applications in Java, we’ll use the *AmazonSimpleQueueService* sample as an example\. The AWS Explorer that is provided with the AWS Toolkit for Eclipse can be used to view the running Amazon SQS queue\.

**Note**  
The AWS SDK for Java samples are provided in the `samples` directory in the SDK download, and can also be viewed on [GitHub](https://github.com/aws/aws-sdk-java/tree/master/src/samples)\. For more information about the AWS SDK for Java itself, view the [AWS SDK for Java Developer Guide](https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/)\.

## Build and Run the Amazon Simple Queue Service Sample<a name="buid-run-sqs-sample"></a>

 **To build and run the Amazon Simple Queue Service sample** 

1. Click the AWS icon on the Eclipse toolbar, and then click **New AWS Java Project**\.

1. In the dialog box that appears, type a name for the project in the **Project name** box and select **Amazon Simple Queue Service Sample**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/tke-aws-java-project.png)

1. Click **Finish**\.

1. The sample application appears in **Project Explorer**\. Expand the tree view for this project\.

1. Beneath the **src** node, double\-click the `SimpleQueueService.java` source file to open it in the editor pane\. Locate the following line:

   ```
   System.out.println("Receiving messages from MyQueue.\n");
   ```

1. Right\-click in the left margin of the editor pane, and select **Toggle Breakpoint**\.

1. Right\-click the project node in **Project Explorer**—in our example, this would be the node named `myJavaSqsApp`—then click **Debug As** > **Java Application**\.

1. In the **Select Java Application** dialog box, select the SQS application and then click **OK**\.

1. When the application stops at the breakpoint, Eclipse will ask if it should switch to the Debug perspective\. Click **No** \(the Debug perspective does not include AWS Explorer\)\.

1. Go to **AWS Explorer** and expand the **Amazon SQS** node\.

1. Double\-click **MyQueue** and view the contents of the queue that was created by the Java client application\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/tke-aws-explorer-sqs-queue.png)

1. Press `F8`\. The Java client application will continue running and terminate normally\.

1. Refresh the view in **AWS Explorer**\. You will see that the **MyQueue** queue is no longer present; the application deletes the queue before the application exits\.

**Note**  
If you run this sample application repeatedly, you should wait at least 60 seconds between subsequent runs\. Amazon SQS requires that at least 60 seconds elapse after deleting a queue before creating a queue with the same name\.