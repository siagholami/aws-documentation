# Step 2: Create a Packaging Group<a name="gs-create-grp"></a>

A packaging group holds one or more packaging configurations\. The packaging configurations enable you to define what kind of VOD outputs you want\. To apply these output definitions, associate a packaging group to multiple assets\.

**Example**  
 You have 15 pieces of source content\. You want to serve them all as DASH, HLS, and encrypted HLS outputs\. To do this, you define one packaging group with DASH, HLS, and encrypted HLS packaging configurations\. You then associate that group to the asset resources that represent these pieces of content\. You don't have to create new configurations for each asset\.

AWS Elemental MediaPackage does not require that you supply any customer data\. There are no fields in packaging groups where there is an expectation that you will provide customer data\.

**To create a packaging group**

1. On the AWS Elemental MediaPackage **Packaging groups** page, choose **Create**\.

1. For **ID**, enter a name that describes the group, such as **gamehighlights** \. The ID is the primary identifier for the group, and must be unique for your account in this AWS Region\. Supported characters are letters, numbers, underscore \(\_\), and dash \(\-\)\. You can't use spaces in the ID\.

1. Choose **Create**\.