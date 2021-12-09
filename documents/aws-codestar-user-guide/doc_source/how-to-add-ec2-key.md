# Add a Public Key to Your AWS CodeStar User Profile<a name="how-to-add-ec2-key"></a>

You can upload a public SSH key as part of the public\-private key pair you create and manage\. You use this SSH public\-private key pair to access Amazon EC2 instances running Linux\. If a project owner has granted you remote access permission, you can access only those instances associated with the project\. You can use the AWS CodeStar console or AWS CLI to manage your public key\.

**Important**  
An AWS CodeStar project owner can grant project owners, contributors, and viewers SSH access to Amazon EC2 instances for the project, but only the individual \(owner, contributor, or viewer\) can set the SSH key\. To do this, the user must be signed in as the individual owner, contributor, or viewer\.   
AWS CodeStar does not manage SSH keys for AWS Cloud9 environments\.

**Topics**
+ [Manage Your Public Key \(Console\)](#how-to-add-ec2-key-console)
+ [Manage Your Public Key \(AWS CLI\)](#how-to-add-ec2-key-cli)
+ [Connect to Amazon EC2 Instance with Your Private Key](#how-to-add-ec2-key-connect)

## Manage Your Public Key \(Console\)<a name="how-to-add-ec2-key-console"></a>

Although you cannot generate a public\-private key pair in the console, you can create one locally and then add or manage it as part of your user profile through the AWS CodeStar console\.

**To manage your public SSH key**

1. From a terminal or Bash emulator window, run the ssh\-keygen command to generate an SSH public\-private key pair on your local computer\. You can generate a key in any format allowed by Amazon EC2\. For information about acceptable formats, see [Importing Your Own Public Key to Amazon EC2](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-key-pairs.html#how-to-generate-your-own-key-and-import-it-to-aws)\. Ideally, generate a key that is SSH\-2 RSA, in OpenSSH format, and contains 2048 bits\. The public key is stored in a file with the \.pub extension\. 

1. Open the AWS CodeStar console at [https://console\.aws\.amazon\.com/codestar/](https://console.aws.amazon.com/codestar/)\.

   Choose a project where you are a team member\.

1. In the navigation bar for the project, choose **Team**\.

1. On the **Team members** page, find the name of your IAM user \(the team member that has your IAM name in parentheses and **\[You\]** in brackets next to the display name\), and then choose **Add Public SSH key**\.  
![\[Adding an SSH public key to your user in AWS CodeStar\]](http://docs.aws.amazon.com/codestar/latest/userguide/images/adh-team-sshkey.png)

1. In **Manage your public SSH key**, paste the public key, and then choose **Save**\.
**Note**  
You can change your public key by deleting the old key in this field and pasting in a new one\. You can delete a public key by deleting the contents of this field, and then choosing **Save**\.

   When you change or delete a public key, you are changing your user profile\. It is not a per\-project change\. Because your key is associated with your profile, it changes \(or is deleted\) in all projects where you have been granted remote access\.

   Deleting your public key removes your access to Amazon EC2 instances running Linux in all projects where you were granted remote access\. However, it does not close any open SSH sessions using that key\. Make sure that you close any open sessions\.

## Manage Your Public Key \(AWS CLI\)<a name="how-to-add-ec2-key-cli"></a>

You can use the AWS CLI to manage your SSH public key as part of your user profile\. 

**To manage your public key**

1. From a terminal or Bash emulator window, run the ssh\-keygen command to generate an SSH public\-private key pair on your local computer\. You can generate a key in any format allowed by Amazon EC2\. For information about acceptable formats, see [Importing Your Own Public Key to Amazon EC2](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-key-pairs.html#how-to-generate-your-own-key-and-import-it-to-aws)\. Ideally, generate a key that is SSH\-2 RSA, in OpenSSH format, and contains 2048 bits\. The public key is stored in a file with the \.pub extension\. 

1. To add or change your SSH public key in your AWS CodeStar user profile, run the update\-user\-profile command with the `--ssh-public-key` parameter\. For example:

   ```
   aws codestar update-user-profile --user-arn arn:aws:iam:111111111111:user/Jane_Doe --ssh-key-id EXAMPLE1
   ```

   This command returns output similar to the following:

   ```
   {
   	"createdTimestamp":1.491439687681E9,
   	"displayName":"Jane Doe",
   	"emailAddress":"jane.doe@example.com",
   	"lastModifiedTimestamp":1.491442730598E9,
   	"sshPublicKey":"EXAMPLE1",
   	"userArn":"arn:aws:iam::111111111111:user/Jane_Doe"
   }
   ```

## Connect to Amazon EC2 Instance with Your Private Key<a name="how-to-add-ec2-key-connect"></a>

Make sure that you have created an Amazon EC2 key pair\. Add your public key to your user profile in AWS CodeStar\. To create a key pair, see [Step 4: Create an Amazon EC2 Key Pair for AWS CodeStar Projects](setting-up.md#setting-up-create-ec2-key)\. To add your public key to your user profile, see the instructions earlier in this topic\.

**To connect to an Amazon EC2 Linux instance by using your private key**

1. With your project open in the AWS CodeStar console, in the navigation pane, choose **Project**\.

1. In **Project Resources**, choose the **ARN** link in the row where **Type** is **Amazon EC2** and **Name** starts with **instance**\.

1. In the Amazon EC2 console, choose **Connect**\. 

1. Follow the instructions in the **Connect To Your Instance** dialog box\.

   For the user name, use `ubuntu` for projects based on the ASP\.NET Core project template, because those instances use Ubuntu\. For all other projects, use `ec2-user` for the user name, because those instances use Amazon Linux\. If you use the wrong user name, you cannot connect to the instance\.

For more information, see the following resources in the *Amazon EC2 User Guide for Linux Instances*\.
+ [Connecting to Your Linux Instance Using SSH](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/AccessingInstancesLinux.html)
+ [Connecting to Your Linux Instance from Windows Using PuTTY](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/putty.html)
+ [Connecting to Your Linux Instance Using MindTerm](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/mindterm.html)