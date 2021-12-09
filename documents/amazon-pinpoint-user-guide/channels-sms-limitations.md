# SMS Limits and Restrictions in Amazon Pinpoint<a name="channels-sms-limitations"></a>

The SMS protocol is subject to several limitations and restrictions\. For example, there are technical limitations that limit the length of each SMS message\. There are also restrictions on the type of content that you can send using SMS\. This topic discusses several of these limitations and restrictions\. 

When you send SMS messages using Amazon Pinpoint, you should consider these limitations and restrictions\. For best results, you should also implement the techniques discussed in [SMS Best Practices](channels-sms-best-practices.md)\.

## Character Limits<a name="channels-sms-limitations-characters"></a>

A single SMS message can contain up to 140 bytes of information\. The number of characters you can include in a single SMS message depends on the type of characters the message contains\.

If your message only uses [characters in the GSM 03\.38 character set](#channels-sms-limitations-characters-gsm-alphabet), also known as the GSM 7\-bit alphabet, it can contain up to 160 characters\. If your message contains any characters that are outside the GSM 03\.38 character set, it can have up to 70 characters\. When you send an SMS message, Amazon Pinpoint automatically determines the most efficient encoding to use\.

When a message contains more than the maximum number of characters, the message is split into multiple parts\. When messages are split into multiple parts, each part contains additional information about the message part that precedes it\. When the recipient's device receives message parts that are separated in this way, it uses this additional information to ensure that all of the message parts are displayed in the correct order\. Depending on the recipient's mobile carrier and device, multiple messages might be displayed as a single message, or as a sequence of separate messages\. As a result of  number of characters in each message part is reduced to 153 \(for messages that only contain GSM 03\.38 characters\) or 67 \(for messages that contain other characters\)\. You can estimate how many message parts your message contains before you send it by using SMS length calculator tools, several of which are available online\. 

To view the number of message parts for each message that you send, you should first enable [event streaming](settings-event-streams.md)\. When you do, Amazon Pinpoint produces an `_SMS.SUCCESS` event when the message is delivered to the recipient's mobile provider\. The `_SMS.SUCCESS` event record contains an attribute called `attributes.number_of_message_parts`\. This attribute specifies the number of message parts that the message contained\.

**Important**  
When you send a message that contains more than one message part, you're charged for the number of message parts contained in the message\.

### GSM 03\.38 Character Set<a name="channels-sms-limitations-characters-gsm-alphabet"></a>

The following table lists all of the characters that are present in the GSM 03\.38 character set\. If you send a message that only includes the characters shown in the following table, then the message can contain up to 160 characters\.


| GSM 03\.38 Standard Characters | 
| --- | 
| A | B | C | D | E | F | G | H | I | J | K | L | M | 
| N | O | P | Q | R | S | T | U | V | W | X | Y | Z | 
| a | b | c | d | e | f | g | h | i | j | k | l | m | 
| n | o | p | q | r | s | t | u | v | w | x | y | z | 
| à | Å | å | Ä | ä | Ç | É | é | è | ì | Ñ | ñ | ò | 
| Ø | ø | Ö | ö | ù | Ü | ü | Æ | æ | ß | 0 | 1 | 2 | 
| 3 | 4 | 5 | 6 | 7 | 8 | 9 | & | \* | @ | : | , | ¤ | 
| $ | = | \! | > | \# | \- | ¡ | ¿ | \( | < | % | \. | \+ | 
| £ | ? | " | \) | § | ; | ' | / | \_ | ¥ | Δ | Φ | Γ | 
| Λ | Ω | Π | Ψ | Σ | Θ | Ξ |  |  |  |  |  |  | 

The GSM 03\.38 character set includes several symbols in addition to those shown in the preceding table\. However, each of these characters is counted as two characters because it also includes an invisible escape character:
+ ^
+ \{
+ \}
+ \\
+ \[
+ \]
+ \~
+ \|
+ €

Finally, the GSM 03\.38 character set also includes the following non\-printed characters:
+ A space character\.
+ A line feed control, which signifies the end of one line of text and the beginning of another\.
+ A carriage return control, which moves to the beginning of a line of text \(usually following a line feed character\)\.
+ An escape control, which is automatically added to the characters in the preceding list\.

### Example Messages<a name="channels-sms-limitations-characters-example-messages"></a>

This section contains several example SMS messages\. For each example, this section shows the total number of characters, as well as the number of message parts for the message\.

**Example 1: A long message that only contains characters in the GSM 03\.38 alphabet**  
The following message only contains characters that are in the GSM 03\.38 alphabet\.

`Hello Carlos. Your Example Corp. bill of $100 is now available. Autopay is scheduled for next Thursday, April 9. To view the details of your bill, go to https://example.com/bill1.`

The preceding message contains 180 characters, so it has to be split into multiple message parts\. When a message is split into multiple message parts, each part can contain 153 GSM 03\.38 characters\. As a result, this message is sent as 2 message parts\.

**Example 2: A message that contains multi\-byte characters**  
The following message contains several Chinese characters, all of which are outside of the GSM 03\.38 alphabet\. 

`亚马逊公司是一家总部位于美国西雅图的跨国电子商务企业，业务起始于线上书店，不久之后商品走向多元化。杰夫·贝佐斯于1994年7月创建了这家公司。`

The preceding message contains 71 characters\. However, because almost all of the characters in the message are outside of the GSM 03\.38 alphabet, it's sent as two message parts\. Each of these message parts can contain a maximum of 67 characters\.

**Example 3: A message that contains a single non\-GSM character**  
The following message contains a single character that isn't part of the GSM 03\.38 alphabet\. In this example, the character is a closing single quote \(’\), which is a different character from a regular apostrophe \('\)\. Word processing applications such as Microsoft Word often automatically replace apostrophes with closing single quotes\. If you draft your SMS messages in Microsoft Word and paste them into Amazon Pinpoint, you should remove these special characters and replace them with apostrophes\.

`John: Your appointment with Dr. Salazar’s office is scheduled for next Thursday at 4:30pm. Reply YES to confirm, NO to reschedule.`

The preceding message contains 130 characters\. However, because it contains the closing single quote character, which isn't part of the GSM 03\.38 alphabet, it's sent as two message parts\.

If you replace the closing single quote character in this message with an apostrophe \(which is part of the GSM 03\.38 alphabet\), then the message is sent as a single message part\.

## Restrictions for Specific Countries or Regions<a name="channels-sms-limitations-country-specific"></a>

Amazon Pinpoint is currently unable to send SMS messages to a small number of countries, including Cuba, Iran, North Korea, Syria, and Sudan\. For a complete list of countries and regions that you can send SMS messages to, see [Supported Countries and Regions \(SMS Channel\)](channels-sms-countries.md)\.

Most countries and regions place restrictions on the type of content that you can send using SMS\. These restrictions vary, but the following types of content are restricted in most countries or regions:
+ Pornographic content
+ Content that is profane or hateful
+ Content that depicts or endorses violence
+ Content that endorses illegal drugs

In many countries and regions, if a customer receives restricted content and complains to a mobile carrier or regulatory agency, the sender might be subject to fines and penalties\. Governments of a few countries and regions actively filter all incoming messages to remove content that they deem offensive or inappropriate\. Always familiarize yourself with the laws and regulations about sending commercial SMS messages for the countries and regions where your customers are located\.

## Originating Numbers<a name="channels-sms-limitations-originating-numbers"></a>

In Amazon Pinpoint, an *originating number* or *originating ID* is the phone number or sender ID that appears on customers' devices when they receive messages from you\. You can use Amazon Pinpoint to send SMS messages from the following types of originating IDs: short codes, long codes, and sender IDs\. The appropriate type of originating ID to use depends on the rules related to sending commercial SMS messages in the countries and regions where your customers are located\. For more information about originating IDs, see [Originating Identities for SMS Messages](channels-sms-originating-identities.md)\.

Each country or region has different rules related to the originating number or ID that commercial senders use when sending SMS messages\. For example, in the United States and Canada, application\-to\-person \(A2P\) messages must be sent using a short code\. In India, A2P messages must be sent using a six\-digit sender ID that's preregistered with mobile carriers\.