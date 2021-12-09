# Amazon SES email sending metrics FAQs<a name="faqs-metrics"></a>

Amazon SES collects several metrics about the emails you send\. These metrics enable you to analyze the effectiveness of your email program and monitor important statistics, such as your bounce and complaint rates\.

**Topics**
+ [General Questions](#faqs-metrics-general)
+ [Open Tracking](#faqs-metrics-opens)
+ [Click Tracking](#faqs-metrics-clicks)

## General Questions<a name="faqs-metrics-general"></a>

### Q1\. After an email is delivered, how long does Amazon SES continue to collect open and click metrics?<a name="sending-metric-faqs-general-q1"></a>

Amazon SES collects open and click metrics for 60 days after each email is sent\.

### Q2\. If a user opens an email multiple times, or clicks a link in an email multiple times, is each of those events tracked separately?<a name="sending-metric-faqs-general-q2"></a>

If a recipient opens an email multiple times, Amazon SES counts each open as a unique open event\. Similarly, if a recipient clicks the same link multiple times, Amazon SES counts each click as a unique click event\.

### Q3\. Are open and click metrics aggregated, or can they be measured down to the recipient level?<a name="sending-metric-faqs-general-q3"></a>

Opens and clicks are tracked at the recipient level\. With open and click tracking, you can determine which recipients opened an email or clicked a link in an email\.

### Q4\. Can I retrieve open and click metrics using the Amazon SES API?<a name="sending-metric-faqs-general-q4"></a>

The Amazon SES API does not provide a method for retrieving open and click metrics\. However, you can retrieve open and click metrics for Amazon SES using the CloudWatch API\. For example, you can use the AWS CLI to retrieve click metrics using the CloudWatch API by issuing the following command:

```
1. aws cloudwatch get-metric-statistics --namespace AWS/SES --metric-name Click \
2.   --statistics Sum --period 86400 --start-time 2017-01-01T00:00:00Z \
3.   --end-time 2017-12-31T23:59:59Z
```

The command shown above retrieves the total number of click events for each day in 2017\. To retrieve open metrics change the value of the `metric-name` parameter to `Open`\. You can also modify the `start-time` and `end-time` parameters to change the analysis period, or change the `period` parameter for more fine\-grained analysis\.

## Open Tracking<a name="faqs-metrics-opens"></a>

### Q1\. How does open tracking work?<a name="sending-metric-faqs-opens-q1"></a>

At the bottom of each email sent through Amazon SES, we insert a 1 pixel by 1 pixel transparent GIF image\. Each email includes a unique reference to this image file; when the image is opened, Amazon SES can tell exactly which message was opened and by whom\.

The addition of this tracking pixel does not change the appearance of your email\.

### Q2\. Is open tracking enabled by default?<a name="sending-metric-faqs-opens-q2"></a>

Open tracking is available to all Amazon SES users by default\. To use open tracking, you must do the following:

1. Create a configuration set\.

1. In the configuration set, create an event destination\.

1. Configure the event destination to publish open event notifications to a destination\.

1. In every email for which you want to track opens, specify the configuration set that you created in step 1\.

For a more detailed explanation of this process, see [Monitor email sending using Amazon SES event publishing](monitor-using-event-publishing.md)\.

### Q3\. Can I omit the open tracking pixel from certain emails?<a name="sending-metric-faqs-opens-q3"></a>

There are two ways to omit the open tracking pixel from your emails\. The first method is to send the email without specifying a configuration set\. Alternatively, you can specify a configuration set that is not configured to publish data about open events\.

### Q4\. Do you track opens for plaintext emails?<a name="sending-metric-faqs-opens-q4"></a>

Open tracking only works with HTML emails\. Because open tracking relies on the inclusion of an image, it is not possible to collect open metrics for users who open emails using a text\-only \(non\-HTML\) email client\.

## Click Tracking<a name="faqs-metrics-clicks"></a>

### Q1\. How does click tracking work?<a name="sending-metric-faqs-clicks-q1"></a>

To track clicks, Amazon SES modifies each link in the body of the email\. When recipients click a link, they are sent to an Amazon SES server, and are immediately forwarded to the destination address\. As with open tracking, each redirect link is unique\. This enables Amazon SES to determine which recipient clicked the link, when they clicked it, and the email from which they arrived at the link\.

**Important**  
If you send a single message to multiple recipients, each recipient will save the same click tracking link\. To track individual recipients' click activity, send email to one recipient per send operation\.

### Q2\. Can I disable click tracking?<a name="sending-metric-faqs-clicks-q2"></a>

You can disable click tracking for individual links by adding an attribute, `ses:no-track`, to the anchor tags in the HTML body of your email\. For example, if you link to the AWS home page, a normal anchor link resembles the following:

```
<a href="https://aws.amazon.com">Amazon Web Services</a>
```

To disable click tracking for that link, modify it to resemble the following:

```
<a ses:no-track href="aws.amazon.com">Amazon Web Services</a>
```

Because `ses:no-track` isn't a standard HTML attribute, Amazon SES automatically removes it from the version of the email that arrives in your recipients' inboxes\.

You can also disable click tracking for all messages that you send using a specific configuration set\. To disable click tracking, modify the configuration set event destination so that it doesn't capture click events\. For more information, see [Managing Amazon SES Event Destinations](event-publishing-managing-event-destinations.md)\.

### Q3\. How many links can be tracked in each email?<a name="sending-metric-faqs-clicks-q3"></a>

The click tracking system can track a maximum of 250 links\.

### Q4\. Are click metrics collected for links in plain text emails?<a name="sending-metric-faqs-clicks-q4"></a>

It's only possible to track clicks in HTML emails\.

### Q5\. Can I tag links with unique identifiers?<a name="sending-metric-faqs-clicks-q5"></a>

You can add an unlimited number of tags, as key\-value pairs, to links in your email by using the `ses:tags` attribute\. When you use this attribute, specify the keys and values using the same format that you would use to pass inline CSS properties: type the key, followed by a colon \(:\), followed by the value\. If you need to pass several key\-value pairs, separate each pair with a semicolon \(;\)\.

For example, assume you want to add the tags `product:book, genre:fiction, subgenre:scifi, type:newrelease` to a link\. The resulting link resembles the following:

```
<a ses:tags="product:book;genre:fiction;subgenre:scifi;type:newrelease;" 
    href="http://www.amazon.com/…/">New Releases in Science Fiction</a>
```

These tags are passed through to your event publishing destination so that you can perform additional analysis on the specific links that your users clicked\.

**Note**  
Link tags can include the numbers 0–9, the letters A–Z \(both uppercase and lowercase\), hyphens \(\-\), and underscores \(\_\)\.

### Q6\. Do tracked links use the HTTP or HTTPS protocol?<a name="sending-metric-faqs-clicks-q6"></a>

Tracking links use the same protocol as the original links in your email\.

For example, if your email includes a link to `https://www.amazon.com`, the link is replaced with a tracking link that uses the HTTPS protocol\. If your email includes a link to `http://www.example.com`, the link is replaced with a tracking link that uses HTTP\. If your email includes both of the previously mentioned links, the HTTPS link is replaced with a tracking link that uses the HTTPS protocol, and the HTTP link is replaced with a tracking link that uses the HTTP protocol\.

### Q7\. A link in my email isn't being tracked\. Why not?<a name="sending-metric-faqs-clicks-q7"></a>

Amazon SES expects the links in your emails to contain properly encoded URLs\. Specifically, URLs in your links must comply with [RFC 3986](https://tools.ietf.org/html/rfc3986)\. If a link in an email isn't properly encoded, recipients will still see the link in the email, but Amazon SES won't track click events for that link\.

Issues related to improper encoding typically occur in URLs that contain query strings\. For example, if the URL of a link in your email contains a non\-encoded space character in the query string \(such as the space between "John" and "Doe" in the following example: *http://www\.example\.com/path/to/page?name=John Doe*\), Amazon SES won't track that link\. However, if the URL uses an encoded space character instead \(such as "%20" in the following example: *http://www\.example\.com/path/to/page?name=John%20Doe*\), Amazon SES tracks it as expected\.