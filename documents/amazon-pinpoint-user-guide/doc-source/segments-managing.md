# Managing Segments<a name="segments-managing"></a>

You can use the Amazon Pinpoint console to create, view, copy, and perform other management tasks for a project's segments\. If you open a segment to view its settings, you can also quickly create a campaign that uses the segment\.

**To manage a segment**

1. Sign in to the AWS Management Console and open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. On the **All projects** page, choose the project that contains the segment that you want to manage\.

1. In the navigation pane, choose **Segments**\.

1. In the list of segments, select the segment that you want to manage\.

1.  On the **Actions** menu, choose one of the following options:
   + **View details** – Choose this option to show information about the segment, including the date and time when the segment was created, and the date and time when the segment was last updated\.

     When you view the details of a dynamic segment, you also see the approximate number of endpoints that meet the segment criteria, and the segment groups and filters that define the segment\. When you view the details of an imported segment, you also see the number of records that were imported for the segment\. If you imported the segment from an Amazon S3 location, you also see details about that location and the name of the IAM role that was used to import the segment from that location\.
   + **Edit** – Choose this option to change the settings for a dynamic segment or a segment that you imported from an Amazon S3 location\. If you edit a dynamic segment, you can change the segment groups that define the segment\. If you edit an imported segment, you can change the Amazon S3 location that the segment is imported from, and the IAM role that's used to import the segment\.
   + **Copy to new** – Choose this option to create a new segment that's a copy of the selected segment\. You can then modify any settings in the new segment, without changing the original segment\.
   + **Export** – Choose this option to export the segment to a file on your computer\. For more information, see [Exporting Segments](segments-exporting.md)\.
   + **Delete** – Choose this option to delete the segment permanently\. You can't recover a segment after you delete it\.
**Important**  
If you delete a segment, any active campaigns that use the segment will fail and stop running\. Similarly, any active journeys that use the segment might fail and stop running\. If a journey does continue to run, any participants who were part of the segment might be removed from the journey prematurely\. Before you delete a segment, it's a good idea to first verify that a segment isn't being used by any active campaigns or journeys\. 