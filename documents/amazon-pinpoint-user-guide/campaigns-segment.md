# Step 2: Specify the Audience for the Campaign<a name="campaigns-segment"></a>

When you create a campaign, you choose a *segment* to send that campaign to\. A segment is a group of your customers that share certain attributes\. For example, a segment might contain all of your customers who use version 2\.0 of your app on an Android device, or all customers who live in the city of Los Angeles\. 

**Prerequisite**  
Before you begin, complete [Step 1: Create a Campaign](campaigns-begin.md)\.

**To specify a segment**

1. On the **Choose a segment** page, choose one of the following options:
   + **Use an existing segment** – Choose this option if you've already created a segment and you're ready to send your campaign to it\.
   + **Create a segment** – Choose this option if you haven't created any segments yet, or if you want to create a new segment for this campaign\. If you choose this option, create a segment by completing the procedures in [Building Segments](segments-building.md)\.
**Note**  
If you want to send your campaign when certain events occur \(as opposed to sending it at a specific time\), you have to use a dynamic segment \(as opposed to an imported segment\)\. To learn more, see [Building Segments](segments-building.md)\.

1. \(Optional\) Under **Segment hold\-out**, specify the percentage of segment members who shouldn't receive this campaign\. Amazon Pinpoint chooses the appropriate number of segment members at random, and omits them from the campaign\. 

   You can use this feature to perform hold\-out testing\. In a hold\-out test, you omit a sample group of random recipients, and then compare their behaviors \(for example, the number of purchases they make\) against the behaviors of the customers who received the campaign\. In this way, you can determine the effectiveness of your campaigns\. 

**Next**  
[Step 3: Write the Message](campaigns-message.md)