# Step 3: Create a Packaging Configuration<a name="gs-create-cfig"></a>

A packaging configuration specifies how the output manifest is configured, such as stream selection limitations and ordering\.

AWS Elemental MediaPackage does not require that you supply any customer data\. There are no fields in packaging configurations where there is an expectation that you will provide customer data\.

**To create a packaging configuration**

1. On the **Packaging groups** page, choose the group that you just created\.

1. On the details page for the packaging group, choose either **Add or remove configuration** or **Add configuration** if there are no existing packaging configurations\.

1. On the **Add packaging configurations** page, choose **Add**, and then choose **New configuration**\.

1. For **ID**, enter a name that describes the configuration, such as **hls\_highlights**\. The ID is the primary identifier for the configuration, and must be unique for your account in this AWS Region\. Supported characters are letters, numbers, underscore \(\_\), and dash \(\-\)\. You can't use spaces in the ID\.

1. Keep the defaults for the remaining fields, and then choose **Save**\.