# Use case and marketing information<a name="manifest-use-case-marketing"></a>

The following use cases can help you configure AWS Security Hub for different purposes\.

## Finding providers and consumers use case<a name="manfiest-use-case-finding-providers-consumers"></a>

Required for independent software vendors \(ISV\)\.

To describe your use case around your integration with AWS Security Hub, answer the following questions\. If you do not plan to either send or receive findings, note that in this section and then complete the next section\.

The following information must be reflected in your documentation\.
+ Will you send findings, receive findings, or both?
+ If you plan to send findings, what types of findings will you send? Will you send all findings or a specific subset of findings?
+ If you plan to receive findings, what will you do with those findings? What types of findings will you receive? For example, will you receive all findings, findings of a certain type, or only specific findings that a customer selects?
+ Do you plan to update findings? If so, which fields will you update? Security Hub recommends that you update findings instead of always creating new ones\. Updating existing findings helps decrease the finding noise for customers\.

  To update a finding, you send a finding with a finding ID that is assigned to a finding that you already sent\.

To get early feedback on your use case and datasets, contact the APN Partner or Security Hub team\.

## Consulting Partner \(CP\) use case<a name="manifiest-use-case-consulting-partner"></a>

Required if you are a Security Hub Consulting Partner\.

Provide two customer use cases for your work with Security Hub\. These can be private use cases\. The Security Hub team does not advertise them anywhere\. They should describe either or both of the following actions\.
+ How do you help customers bootstrap Security Hub? For example, have you helped customers use professional services, a Terraform module, or an AWS CloudFormation template?
+ How do you help customers operationalize and extend Security Hub? For example, have you provided response or remediation templates, built custom integrations, or used business intelligence tools to set up an executive dashboard?

## Datasets<a name="manifest-datasets"></a>

Required if you send findings to Security Hub\.

For the findings that you will send to Security Hub, provide the following information\.
+ The findings in their native format, such as JSON or XML
+ An example of how you will convert the findings to the AWS Security Finding Format \(ASFF\)

Let the Security Hub team know if you need any updates to the ASFF to support your integration\.

## Architecture<a name="manifest-architecture"></a>

Required if you send findings to or receive findings from Security Hub\.

Describe how you will integrate with Security Hub\. This information also must be reflected in your documentation\.

You must provide architecture diagrams\. When preparing your architecture diagrams, consider the following:
+ What AWS services, operating system agents, and so on will you use?
+ If you will send findings to Security Hub, will you send findings from the customer AWS account or from your own AWS account?
+ If you will receive findings, how will you use the CloudWatch Events integration?
+ How will you convert findings to ASFF?
+ How will you batch findings, track the finding state, and avoid throttling limits?

## Configuration<a name="manifest-configuration"></a>

Required if you send findings to or receive findings from Security Hub\.

Describe how a customer will configure your integration with Security Hub\.

At a minimum, you must use AWS CloudFormation templates or a similar infrastructure such as code templates\. Some partners have provided a user interface to support one\-click integration\.

Configuration should take no more than 15 minutes\. Your product documentation must also provide configuration guidance for your integration\.

## Average findings per day per customer<a name="manifest-findings-per-day"></a>

Required if you send findings to Security Hub\.

How many finding updates per month \(average and maximum\) do you expect to send to Security Hub across your customer base? Orders of magnitude estimates are acceptable\. 

## Latency<a name="manifest-latency"></a>

Required if you send findings to Security Hub\.

How quickly will you batch and send findings to Security Hub? In other words, what is the latency from when the finding is created in your product to when it is sent to Security Hub?

This information must be reflected in your product documentation for your integration\. It is a common question from customers\.

## Company and product description<a name="manifest-company-product-description"></a>

Required for all integrations with Security Hub\.

Briefly describe your company and product, with a specific emphasis on the nature of your Security Hub integration\. We use this on our Security Hub partners page\.

If you are integrating multiple products with Security Hub, you can provide a separate description for each product, but we will combine them into a single entry on the partner page\.

Each description can be no more than 700 characters with spaces\.

## Partner website assets<a name="manifest-website-assets"></a>

Required for all integrations with Security Hub\.

At a minimum, you must provide a URL to use for the **Learn More** hyperlink on the Security Hub partners page\. It should be a marketing landing page that describes the integration between your product and Security Hub\.

If you integrate multiple products with Security Hub, you can have a single landing page for them\. Security Hub recommends that this landing page include a link to your configuration instructions\.

You can also provide links to other resources such as blogs, webinars, demo videos, or whitepapers\. Security Hub will also link to those from their partners page\.

## Logo for partners page<a name="manifest-partners-page-logo"></a>

Required for all Security Hub integrations\.

Provide a URL to a logo to display on the Security Hub partners page\. The logo must meet the following criteria:
+ Size: 600 x 300 pixels
+ Cropping: tight with no padding
+ Background: transparent
+ Format: PNG

## Logo for Security Hub console<a name="manifest-sechub-console-logo"></a>

Required for all integrations\.

Provide a URL to a logo to display on the Security Hub console\. The logo must meet the following criteria:
+ Size: 175 x 40 pixels
+ Cropping: tight no padding
+ Background: transparent
+ Format: PNG

For detailed guidelines for the small logo, see [Guidelines for the logo to display on the AWS Security Hub console](guidelines-console-logo.md)\.

## Finding types<a name="manifest-finding-types"></a>

Required if you send findings to Security Hub\.

Provide a table that documents the ASFF\-formatted finding types that you use and how they align to your native finding types\. For details on finding types in ASFF, see [Types taxonomy for ASFF](https://docs.aws.amazon.com/securityhub/latest/userguide/securityhub-findings-format.html#securityhub-findings-format-type-taxonomy) in the *AWS Security Hub User Guide*\.

We recommend that you also include this information in your product documentation\.

## Hotline<a name="manifest-hotline"></a>

Required for all integrations with Security Hub\.

Provide an email address and phone number or pager number for a technical point of contact\. Security Hub will communicate with this contact regarding any technical issues, such as when an integration no longer works\.

Also provide a 24/7 point of contact for high severity technical issues\.

## Heartbeat finding<a name="manifest-heartbeat-finding"></a>

Recommended if you sending findings to Security Hub\.

Can you send Security Hub a "heartbeat" finding every five minutes that indicates that your integration with Security Hub is functional?

If you can, then do so using the finding type `Heartbeat`\.