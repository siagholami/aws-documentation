# Location and IP address ranges of Global Accelerator edge servers<a name="introduction-ip-ranges"></a>

For a list of Global Accelerator edge server locations, see the *Where is AWS Global Accelerator deployed today?* section on the [ AWS Global Accelerator FAQs](https://aws.amazon.com/global-accelerator/faqs/) page\.

AWS publishes its current IP address ranges in JSON format\. To view the current ranges, download [ ip\-ranges\.json](https://ip-ranges.amazonaws.com/ip-ranges.json)\. For more information, see [AWS IP Address Ranges](https://docs.aws.amazon.com/general/latest/gr/aws-ip-ranges.html) in the *Amazon Web Services General Reference*\.

To find the IP address ranges that are associated with AWS Global Accelerator edge servers, search `ip-ranges.json` for the following string:

`"service": "GLOBALACCELERATOR"`

Global Accelerator entries that include `"region": "GLOBAL"` refer to the static IP addresses that are allocated to customer accelerators\. If you want to filter for traffic through your accelerator that comes from points of presence \(POPs\) in one area, filter for entries that include a specific geographical area, such as `us-*` or `eu-*`\. So, for example, if you filter for `us-*`, you will see only traffic coming through POPs in the United States \(U\.S\.\)\.