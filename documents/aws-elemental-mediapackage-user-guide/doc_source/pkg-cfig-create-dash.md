# Creating a DASH Packaging Configuration<a name="pkg-cfig-create-dash"></a>

Create a packaging configuration that formats content for devices that support DASH\-ISO\.

**To create a DASH\-ISO packaging configuration \(console\)**

1. Open the MediaPackage console at [https://console\.aws\.amazon\.com/mediapackage/](https://console.aws.amazon.com/mediapackage/)\.

1. In the navigation pane, under **Video on demand**, choose **Packaging groups**\.

1. On the **Packaging groups** page, choose the group that will contain the configuration that you're creating\.

1. On the details page for the packaging group, in the **Packaging configurations** section, choose **Add or remove configs**\.

1. On the **Add or remove packaging configurations** page, in the **Packaging configurations** section, choose **Add** and **New config**\.

1. Complete the fields as described in the following topics:
   + [General Settings Fields](cfigs-dash-new.md)
   + [Manifest Settings Fields](cfigs-dash-manset.md)
   + [Stream Selection Fields](cfigs-dash-include-streams.md)
   + [Encryption Fields](cfigs-dash-encryption.md)

1. Choose **Save**\.

If you exceed the quotas for your account when you're creating a packaging configuration, you get an error\. If you get an error similar to Too many requests, please try again\. Resource limit exceeded, either you have exceeded the API request quotas, or you have already reached the maximum number of packaging groups allowed on your account\. If this is your first group, or if you think you mistakenly received this error, use the Service Quotas console to [request quota increases](https://console.aws.amazon.com/servicequotas/home?region=us-east-1#!/services/mediapackage/quotas)\. For more information about quotas in MediaPackage, see [Quotas in AWS Elemental MediaPackage](limits.md)\.