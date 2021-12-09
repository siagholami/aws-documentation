--------

--------

# Getting started with a Microsoft OneDrive for Business data source \(Console\)<a name="getting-started-onedrive"></a>

You can use the Amazon Kendra console to get started indexing a Microsoft OneDrive for Business site\. When you use the console you can specify all of the connection information that you need to index the contents of a OneDrive site\. For more information, see [Using a Microsoft OneDrive data source](data-source-onedrive.md)\.

Use the following procedure to create a basic OneDrive data source using the default configuration\. The procedure assumes that you have already created an index following the steps in step 1 of [Getting started with an S3 bucket \(Console\)](gs-console.md)\.

Before you can create a OneDrive data source, you must register an Azure Active Directory application\. Use the following procedure to register the application\.

**Step 1: To register an Azure AD application**

1. Log into the [Azure Management Portal](https://portal.azure.com/)\.

1. Choose **Azure Active Directory** and then choose **App registrations**

1. Choose **New registration**\.

1. Create the application with the following values\.
   + **Name** Enter the name for your application\.
   + **Application type** **Web app/API**
   + **Sign\-on URL** Any valid URL\. The URL doesn't need to exist\.

1. Choose **Register**\.

1. Choose the application name in the list of applications to open the application settings\.

1. Choose **Overview** and then copy the **Application ID** value\.

The application requires permission to access OneDrive data\. Use the following procedure to assign permissions to the application\. This procedure starts where the previous procedure left off\.

**Step 2: To assign permissions to the Azure AD application**

1. From the application settings, choose **API Permission**\.

1. Choose **Add**, and choose the **Microsoft Graph** option, and then choose **Add**\.

1. From the **Application permissions**, choose the following\.
   + Read files in all site collections \(Files\.Read\.All\)
   + Read all users' full profiles \(User\.Read\.All\)
   + Read directory data \(Directory\.Read\.All\)
   + Read all groups \(Group\.Read\.All\)
   + Read items in all site collections \(Sites\.Read\.All\)

1. Choose **Save** and then choose **Grant permissions**\. Choose **Yes** when prompted\.

Next you create an application key that Amazon Kendra uses to identify itself with the OneDrive site\. This procedure starts where the previous procedure left off\.

**Step 3: To create an application key**

1. From the **Application settings**, choose **Keys**\.

1. Add the following information to the key\.
   + **Description** Add a description for your key\.
   + **Expires** Choose a duration based on your company policy\. When the application key is rotated, you must update the key in the Amazon Kendra data source\.

1. Choose **Save** to generate the key value\. Copy this value to use in the next step\.

Once you have created the Azure AD application and generated a secret key for the application, you are ready to create a OneDrive data source\.

**Step 4: To create a OneDrive data source using the Amazon Kendra console**

1. Sign into the AWS Management Console and open the Amazon Kendra console at [https://console\.aws\.amazon\.com/kendra/home](https://console.aws.amazon.com/kendra/home)\.

1. From the list of indexes, choose the index that you want to add the data source to\.

1. Choose **Add data sources**\.

1. From the list of data source connectors, choose **OneDrive**\.

1. On the **Define attributes** page, give your data source a name and optionally a description\. Leave the **Tags** field blank\. Choose **Next** to continue\.

1. On the **Define targets** page, enter the domain name of your OneDrive site\. Enter the name without the protocol \("https://"\)\.

1. In the **IAM role** field choose **Create a new role\.** Enter a name for the role in the **Role name** field\. Choose **Next** to continue\.

1. In the **Type of authentication** field, choose **New**\. This tells the console to create a new AWS Secrets Manager secret to contain credentials for your OneDrive data source\.

1. In the **New secret container name** field enter a name to identify the Secrets Manager secret\.

1. In the **Application ID** and **Application password** fields enter the ID and password for the Active Directory application that you created for the data source\. Choose **Save authentication** to save the credentials for your OneDrive site\.

1. In the **Add OneDrive users** section, choose **Names list**\. Add the email addresses of up to 10 users whose documents you want to index\.

1. In the **Set sync run schedule** section, choose **Run on demand** in the **Frequency** field\.

1. In the **OneDrive field mapping** section, leave the default fields selected and then choose **Next**\.

1. On the **Review and create** page review the details of your OneDrive data source\. If you want to make changes, choose the **Edit** button next to the item that you want to change\. When you are satisfied with your choices, choose **Create** to create your OneDrive data source\.

After you choose **Create**, Amazon Kendra starts creating the data source\. It can take several minutes for the data source to be created\. When it is finished, the status of the data source changes from **Creating** to **Active**\.

After creating the data source, you need to sync the Amazon Kendra index with the data source\. Choose **Sync now** to start the sync process\. It can take several minutes to several hours to synchronize the data source, depending on the number and size of the documents\.