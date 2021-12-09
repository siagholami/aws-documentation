# Archiving build artifacts to AWS<a name="tutorial-s3"></a>

The following tutorial demonstrates how to use the *AWS S3 Upload* task to upload archival data to an Amazon Simple Storage Service \(Amazon S3\) bucket from an Azure DevOps build definition\.

## Prerequisites<a name="prerequisites"></a>
+ The AWS Toolkit for Azure DevOps installed in Azure DevOps or an on\-premises Azure DevOps server\.
+ An AWS account and preferably an associated IAM user account\.
+ An existing S3 bucket or a unique S3 bucket name to use during this procedure\.
+ A code project for an *ASP\.NET Core Web Application*, which you will push to your Azure DevOps project\.

## Archiving build artifacts with the AWS S3 Upload task<a name="archiving-build-artifacts-with-the-aws-s3-upload-task"></a>

Create a new Azure DevOps project and add a new pipeline to the project based on the *ASP\.NET Core* template\. To follow along with the screenshots shown below, use the classic editor \(that is, without YAML\)\.

![\[New build pipeline using classic editor\]](http://docs.aws.amazon.com/vsts/latest/userguide/images/use-classic-editor.png)

![\[New build pipeline based on ASP.NET Core template\]](http://docs.aws.amazon.com/vsts/latest/userguide/images/select-template-s3.png)

The build process page for this pipeline contains the following default tasks\.

![\[New build pipeline\]](http://docs.aws.amazon.com/vsts/latest/userguide/images/startingbuilddefinition.png)

### Add the S3 Upload task to the build definition<a name="add-the-s3-upload-task-to-the-build-definition"></a>

To capture the build output produced by the *Publish* task and upload it to Amazon S3 you need to add the *Amazon S3 Upload* task between the existing *Publish* and *Publish Artifact* tasks\.

Select the **"\+" icon** at the top of the task list\. In the right hand panel, optionally enter something in the search box, for example "Amazon", and scroll through the available tasks until you see the *Amazon S3 Upload* task\. Select the **Add** button to add it to the build definition\.

![\[AWS S3 Upload Task\]](http://docs.aws.amazon.com/vsts/latest/userguide/images/tasklist-s3.png)

If the new task was not added immediately after the *Publish* task, drag it into that position\.

Click on the new task to see its properties in the right pane\.

![\[AWS S3 Upload Task in Position\]](http://docs.aws.amazon.com/vsts/latest/userguide/images/s3taskstart.png)

### Configure the task properties<a name="configure-the-task-properties"></a>
+ **AWS Credentials**

  If you have already configured AWS credentials for your project, you can select them from the dropdown list\. If not, you can add credentials for this task by choosing the **New** button next to the **AWS Credentials** field\. For information about filling out the resulting **Add AWS service connection** form, see the topic on [Supply task credentials using a service connection](getting-started.md#service-connection)\.

  This task requires credentials for a user with a policy enabling the user to put objects to S3\. If the **Create S3 bucket** option is enabled \(see the following\) the user also needs permission to create a bucket\.
**Note**  
We recommend that you do not use your account's root credentials\. Instead, create one or more IAM users, and then use those credentials\. For more information, see [Best practices for managing AWS access keys](https://docs.aws.amazon.com/general/latest/gr/aws-access-keys-best-practices.html) in the [Amazon Web Services General Reference](https://docs.aws.amazon.com/general/latest/gr/)\.
+ **AWS Region**

  Set the AWS Region in which the bucket exists or will be created; for example, us\-east\-1, us\-west\-2, and so on\.
+ **Bucket Name**

  Enter the name of the bucket\. Bucket names must be globally unique\.
+ **Source Folder**

  This field points to a folder in your build area that contains the content to be uploaded\. For this tutorial, use the variable "`$(Build.ArtifactStagingDirectory)`" \(without the quotation marks\)\. This is the same variable that is specified by default in the *Publish* task \(the `--output` argument\), as well as in other tasks\.
**Note**  
Azure DevOps provides a [number of variables](https://go.microsoft.com/fwlink/?LinkID=550988) that you can use to avoid hard\-coded paths\.
+ **Filename Patterns**

  This field can contain one or more globbing patterns used to select files under the **Source Folder** for upload\. The default value "\*\*" selects all files recursively\. Multiple patterns can be specified, one per line\. For this tutorial, the *Publish* task, which precedes the *S3 Upload* task, emits a `.zip` file that contains the build\. This is the file that will be uploaded\.
+ **Target Folder**

  This is the *key prefix* in the bucket that will be applied to all of the uploaded files\. You can think of this as a folder path\. If no value is given, the files are uploaded to the root of the bucket\. Note that by default the relative folder hierarchy is preserved\.
+ **Create S3 bucket if it does not exist**

  Select this check box if the target bucket doesn't exist\. The task will fail if the bucket cannot be created for some reason \(for example, not a unique name, lack of permissions\)\.
+ **Overwrite** \(in the **Advanced** section\)

  Changing this check box has no effect\. If a file with the same name already exists in the Amazon S3 bucket, it will always be overwritten\.
+ **Flatten folders** \(in the **Advanced** section\)

  Select this check box if you want to flatten the folder structure\. All files will be placed into the specified target folder in the bucket, removing their relative paths to the source folder\.

### Run the build<a name="run-the-build"></a>

With the new task configured, you are ready to run the build\. Choose **Save & queue**\.

![\[Save and Queue the Build\]](http://docs.aws.amazon.com/vsts/latest/userguide/images/s3taskfinal.png)

During the build you can view the log by clicking the build number in the queue message\.

![\[Save and Queue the Build\]](http://docs.aws.amazon.com/vsts/latest/userguide/images/click-on-build-number-to-view-log.png)

When the build has completed, you will be able to see S3 upload logs similar to the following\.

![\[Task Log\]](http://docs.aws.amazon.com/vsts/latest/userguide/images/tasklog.png)