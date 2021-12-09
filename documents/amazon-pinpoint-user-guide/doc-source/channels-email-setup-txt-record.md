# Domain Verification TXT Records<a name="channels-email-setup-txt-record"></a>

Your domain is associated with a set of Domain Name System \(DNS\) records that you manage through your DNS provider\. A TXT record is a type of DNS record that provides additional information about your domain\. Each TXT record consists of a name and a value\.

When you initiate domain verification using the Amazon Pinpoint console or API, Amazon Pinpoint gives you the name and value to use for the TXT record\. For example, if your domain is *example\.com*, the TXT record settings that Amazon Pinpoint generates look similar to the following example\.


| Name | Type | Value | 
| --- | --- | --- | 
|  \_amazonses\.example\.com  |  TXT  |  pmBGN/7MjnfhTKUZ06Enqq1PeGUaOkw8lGhcfwefcHU=  | 

Add a TXT record to your domain's DNS server using the specified **Name** and **Value**\. Amazon Pinpoint domain verification is complete when Amazon Pinpoint detects the existence of the TXT record in your domain's DNS settings\.

If your DNS provider does not allow DNS record names to contain underscores, you can omit *\_amazonses* from the **Name**\. In that case, for the preceding example, the TXT record name would be *example\.com* instead of *\_amazonses\.example\.com*\. To make the record easier to recognize and maintain, you can optionally prefix the **Value** with *amazonses:*\. In the previous example, the value of the TXT record would therefore be *amazonses:pmBGN/7MjnfhTKUZ06Enqq1PeGUaOkw8lGhcfwefcHU=*\.