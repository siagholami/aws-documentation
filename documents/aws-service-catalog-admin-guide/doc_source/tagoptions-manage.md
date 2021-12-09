# Managing TagOptions<a name="tagoptions-manage"></a>

As an administrator, you can create, remove, and edit TagOptions, and associate and disassociate TagOptions with a portfolio or product\.

**To create a TagOption \(console\)**

1. Open the AWS Service Catalog console at [https://console\.aws\.amazon\.com/servicecatalog/](https://console.aws.amazon.com/servicecatalog/)\.

1. Choose **TagOption library**\.

1. Either type a new value for one of the key groupings or choose **Create new TagOption** and type a new key and value\.

After the new TagOption has been created, it's grouped by key\-value pair and sorted alphabetically\. You can delete a newly created TagOption by choosing **Delete from library**\. This deletion feature is available only for newly created TagOptions\. It's designed for quick management of mistyped TagOptions\.

To create a TagOption using the AWS Service Catalog API, see [CreateTagOption](https://docs.aws.amazon.com/servicecatalog/latest/dg/API_CreateTagOption.html)\.

**To associate a TagOption with a portfolio or product \(console\)**

1. Open the AWS Service Catalog console at [https://console\.aws\.amazon\.com/servicecatalog/](https://console.aws.amazon.com/servicecatalog/)\.

1. Choose **TagOption**, select a TagOption, and select the portfolio or product to associate the TagOption with\.

   Alternatively, from a portfolio or product detail page, choose **Add TagOption** and select the TagOption to associate the TagOption with\.

1. Choose **Save**\.

To associate a TagOption with a portfolio or product using the AWS Service Catalog API, see [AssociateTagOptionWithResource](https://docs.aws.amazon.com/servicecatalog/latest/dg/API_AssociateTagOptionWithResource.html)\.

**To remove \(disassociate\) a TagOption from a portfolio or product \(console\)**

1. Open the AWS Service Catalog console at [https://console\.aws\.amazon\.com/servicecatalog/](https://console.aws.amazon.com/servicecatalog/)\.

1. Choose **TagOption**, select a **TagOption**, and open the **Detail** page\.

1. Select the small **x** to the right of the portfolio or product from which you want to remove the association\.

   Alternatively, from a portfolio or product **Detail** page, choose the small **x** to the right of the TagOption that you want to remove\.

To remove a TagOption using the AWS Service Catalog API, see [DisassociateTagOptionFromResource](https://docs.aws.amazon.com/servicecatalog/latest/dg/API_DisassociateTagOptionFromResource.html)\.

**To edit a TagOption**

1. Open the AWS Service Catalog console at [https://console\.aws\.amazon\.com/servicecatalog/](https://console.aws.amazon.com/servicecatalog/)\.

1. Choose **TagOption library**, select a **TagOption**, and edit the key or value\.

1. Choose **Save**\.