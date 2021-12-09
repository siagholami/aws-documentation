# Tracking Open and Click Events in Email<a name="channels-email-open-click-tracking"></a>

Amazon Pinpoint automatically tracks how many of your emails were opened or clicked by their recipients\. In order to track the number of opens and clicks, Amazon Pinpoint makes minor changes to the emails that you send\.

First, Amazon Pinpoint adds a tiny, transparent image to the end of each email that you send\. This image is hosted on an AWS server\. The file name of this image is unique for each recipient\. When a recipient opens an email, their email client downloads this file from our servers\. When an email client downloads a tracking image from our servers, we count it as an open event\.

Second, Amazon Pinpoint replaces all links in your emails with links that refer to a domain that is hosted by AWS\. This link includes a parameter that is unique for each recipient\. When a recipient clicks one of these links, they are first sent to the AWS\-hosted domain, and then immediately redirected to their intended destination\. When a recipient visits one of these redirect links, we count it as a click event\.

If a user opens an email multiple times or clicks the same link in an email multiple times, we count each open or click separately\. In other words, if a recipient opens an email three times, we count three separate open events\.

In order to view open and click events, you have to set up event streaming\. For more information about creating event streams, see [Event Stream Settings](settings-event-streams.md)\.