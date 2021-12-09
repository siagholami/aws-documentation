# Changing Provisioned Product Owner<a name="change-pp-owner"></a>

 You can change the owner of a provisioned product anytime\. You need to know the ARN of the user or role you want to set as the new owner\. 

 By default, this feature is available to administrators using the **AWSServiceCatalogAdminFullAccess** managed policy\. You can enable it for end users by granting them the **servicecatalog:UpdateProvisionedProductProperties** permission in AWS Identity and Access Management \(IAM\)\. 

**To change the owner of a provisioned product**

1.  In the AWS Service Catalog console, choose **Provisioned products list**\. 

1.  Locate the provisioned product you want to update, then choose the three dots beside it and choose **Change provisioned product owner**\. You can also find the **Change owner** option on the provisioned product's detail page, in the **Actions** menu\. 

1.  In the dialog box, enter the ARN of the user or role you want to set as the new owner\. An ARN begins with `arn:` and includes other information separated by colons or slashes, for example, `arn:aws:iam::123456789012:user/NewOwner`\. 

1.  Choose **Submit**\. You will see a success message when the owner has been updated\. 

## See Also<a name="change-pp-owner-see-also"></a>
+  [UpdateProvisionedProductProperties](https://docs.aws.amazon.com/servicecatalog/latest/dg/API_UpdateProvisionedProductProperties.html) 