# Getting started with AWS Elemental MediaStore<a name="getting-started"></a>

This Getting Started tutorial shows you how to use AWS Elemental MediaStore to create a container and upload an object\.

**Topics**
+ [Step 1: Access AWS Elemental MediaStore](#gs-console-access)
+ [Step 2: Create a container](#gs-containers-create)
+ [Step 3: Upload an object](#gs-objects-upload)
+ [Step 4: Access an object](#gs-objects-access)

## Step 1: Access AWS Elemental MediaStore<a name="gs-console-access"></a>

Once you have set up your AWS account and created IAM users and roles, you sign in to the console for AWS Elemental MediaStore\.

**To access AWS Elemental MediaStore**
+ Sign in to the AWS Management Console and open the MediaStore console at [https://console\.aws\.amazon\.com/mediastore/](https://console.aws.amazon.com/mediastore/)\.
**Note**  
You can login using any of the IAM credentials you have created for this account\. For information about creating IAM credentials, see [Setting up AWS Elemental MediaStore](setting-up.md)\.

## Step 2: Create a container<a name="gs-containers-create"></a>

You use containers in AWS Elemental MediaStore to store your folders and objects\. You can use containers to group related objects in the same way that you use a directory to group files in a file system\. You aren’t charged when you create containers; you are charged only when you upload an object to a container\. 

**To create a container**

1. On the **Containers** page, choose **Create container**\.

1. For **Container name**, type a name for your container\. For more information, see [Rules for container names](containers-rules-for-names.md)\. 

1. Choose **Create container**\. AWS Elemental MediaStore adds the new container to a list of containers\. Initially, the status of the container is **Creating**, and then it changes to **Active**\.

## Step 3: Upload an object<a name="gs-objects-upload"></a>

You can upload objects \(up to 25 MB each\) to a container or to a folder within a container\. To upload an object to a folder, you specify the path to the folder\. If the folder already exists, AWS Elemental MediaStore stores the object in the folder\. If the folder doesn’t exist, the service creates it, and then stores the object in the folder\. 

**Note**  
Object file names can contain only letters, numbers, periods \(\.\), underscores \(\_\), tildes \(\~\), and hyphens \(\-\)\.

**To upload an object**

1. On the **Containers** page, choose the name of the container that you just created\. The details page for the container appears\.

1. Choose **Upload object**\.

1. For **Target path**, type a path for the folders\. For example, `premium/canada`\. If any of the folders in the path don’t exist yet, AWS Elemental MediaStore creates them automatically\.

1. For **Object**, choose **Browse**\.

1. Navigate to the appropriate folder, and choose one object to upload\.

1. Choose **Open**, and then choose **Upload**\.

## Step 4: Access an object<a name="gs-objects-access"></a>

You can download your objects to a specified endpoint\.

1. On the **Containers** page, choose the name of the container that has the object that you want to download\.

1. If the object that you want to download is in a subfolder, continue choosing the folder names until you see the object\.

1. Choose the name of the object\.

1. On the details page for the object, choose **Download**\.