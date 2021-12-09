# Create the Segment<a name="tutorials-create-a-segment-build"></a>

There are two steps involved in creating a dynamic segment\. First, you set up the segment\. Next, you set up the segment groups for the segment\.

## Step 1: Set Up the Segment<a name="tutorials-create-a-segment-build-step-1"></a>

To start building your segment, you first create a new segment and give it a name\. You also have to choose whether you're creating a dynamic segment or importing one\. In this tutorial, you create a new dynamic segment\.

**To create a segment**

1. Sign in to the AWS Management Console and open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. On the **All projects** page, choose the project that you want to create the segment in\.

1. In the navigation pane, choose **Segments**\.

1. Choose **Create a segment**\.

1. Under **Create a segment**, choose **Build a segment**\.  
![\[The Create a segment page with the Build a segment option selected.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/segments_build.png)![\[The Create a segment page with the Build a segment option selected.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/)![\[The Create a segment page with the Build a segment option selected.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/)

1. For **Name**, enter a name for the segment to make it easy to recognize later\.

## Step 2: Add the First Segment Group<a name="segment-building-procedure-step-2"></a>

Now that you've created your segment, you can add the first segment group to it\. The first segment group should contain all of the customers who should be eligible for the segment\. In the section after this, you'll specify your blacklist segment in order to exclude certain recipients\.

1. Under **Segment Group 1**, next to **Include endpoints that are in**, choose one of the following options:
   + **any** – If you use more than one segment as a base segment, your new segment contains endpoints that are in at least one of the segments you select\.
   + **all** – If you use more than one segment as a base segment, your new segment only contains endpoints that are in all of the selected segments\.

1. Next to **of the following segments**, choose the segment or segments that you want to use as base segments, as shown in the following image\.
**Tip**  
The menu doesn't close when you select the first base segment\. If you want to use several base segments, you can continue to select segments as necessary\. When you're done choosing segments, choose an area outside the menu to close it\.  
![\[The Segment group 1 section with two base segments selected.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/segments_groups.png)![\[The Segment group 1 section with two base segments selected.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/)![\[The Segment group 1 section with two base segments selected.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/)

1. For **Add a filter**, choose the type of filter that you want to add to the segment\. You can choose from the following options:
   + **Filter by channel** – Use this option to filter the segment based on the channel of the recipient's endpoint\. For example, when you choose **EMAIL**, your segment only contains endpoints that can receive email\.
   + **Filter by endpoint** – Use this option to filter by endpoint\-specific attributes\. When you select this option, you specify how recently the endpoint was active, or how long it's been inactive\. After that, you can optionally specify additional attributes associated with that endpoint\. For example, this filter could include all customers who were active within the past 7 days and used an iPhone to access your app, as shown in the following image\.  
![\[An Endpoint filter that is set up to include all customers who were active within the past 7 days and who use iPhones.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/segments_filter_endpoint.png)![\[An Endpoint filter that is set up to include all customers who were active within the past 7 days and who use iPhones.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/)![\[An Endpoint filter that is set up to include all customers who were active within the past 7 days and who use iPhones.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/)

     You can add several attributes to this filter\. To add another attribute, choose **Choose an endpoint attribute**\.
   + **Filter by user** – Use this option to filter the segment based on user attributes\. User attributes are those attributes that are specific to the actual customers, as opposed to endpoint attributes, which focus more on the specific endpoints that customers use to interact with your app\. For example, you could set up this filter to include all users who are female, as shown in the following image\.  
![\[A User filter that is set up to include all female users.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/segments_filter_user.png)![\[A User filter that is set up to include all female users.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/)![\[A User filter that is set up to include all female users.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/)

     You can add several attributes to this filter\. To add another attribute, choose **Choose a user attribute**\. 

   You can add several filters to a single segment group, and each filter can include several attributes\.

   If the segment group includes more than one filter, you can specify how the filters are related to each other\. For example, you can set up the filter section to include customers who meet any of the filter criteria you specified, or to include only those customers who meet *all* of the specified criteria, or even to include only those customers who meet *none* of the specified criteria\. To change this setting, change the value next to **Endpoints that match**, as shown in the following image\.  
![\[A menu that shows the ways that you can connect multiple filters. The options are all, any, and none.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/segments_filter_logic.png)![\[A menu that shows the ways that you can connect multiple filters. The options are all, any, and none.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/)![\[A menu that shows the ways that you can connect multiple filters. The options are all, any, and none.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/)

## Step 3: Add the Blacklist Segment Group<a name="segment-building-procedure-step-3"></a>

Now that you've specified which customers should be added to the segment, you can create another segment that excludes your blacklist\.

**Note**  
If you use an imported segment as the base segment for your first segment group, you can't create a second segment group\.

1. When you finish setting up the first segment group, choose **Add another segment group**\. When you add another segment group, you have to specify how it relates to the first segment group, as shown in the following image\. For this example, choose **AND**, as shown in the following image\.  
![\[A menu that shows the ways that you can connect multiple segment groups. The options are AND and OR. AND is highlighted.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/segments_groups_logic.png)![\[A menu that shows the ways that you can connect multiple segment groups. The options are AND and OR. AND is highlighted.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/)![\[A menu that shows the ways that you can connect multiple segment groups. The options are AND and OR. AND is highlighted.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/)

1. Next to **Include endpoints that are in**, choose **none**\. Then, next to **of the following segments**, choose the segment that you want to exclude\. These steps are shown in the following image\.  
![\[The second segment group, configured to exclude all members of a specific segment.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/segments_blacklist_exclude.png)![\[The second segment group, configured to exclude all members of a specific segment.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/)![\[The second segment group, configured to exclude all members of a specific segment.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/)

1. Choose **Create segment**\.