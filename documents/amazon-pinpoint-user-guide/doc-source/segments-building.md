# Building Segments<a name="segments-building"></a>

Dynamic segments are based on the data that your apps provide to Amazon Pinpoint, after you integrate your apps with Amazon Pinpoint\. When you create a dynamic segment, you choose the criteria that define that segment\. For example, you could specify all customers who use version 2\.0 of your app on an Android device, and who have used your app within the past 30 days\. Amazon Pinpoint continuously re\-evaluates your segments as your app records new customer interactions\. As a result, the size and membership of each segment changes over time\. For information about integrating your apps with Amazon Pinpoint, see [Integrating Amazon Pinpoint with Your Application](https://docs.aws.amazon.com/pinpoint/latest/developerguide/integrate.html) in the *Amazon Pinpoint Developer Guide*\.

## Segment Groups<a name="segments-building-groups"></a>

When you create a dynamic segment, you create one or more *segment groups*\. A segment group consists of two components:
+ **Base segments** – The segments that define the initial user population\. You can specify a single base segment, several base segments, or all of the segments in your Amazon Pinpoint project\.
+ **Filters** – Criteria that you apply on top of the base segments\. In most cases, adding a filter reduces the number of endpoints who belong to the segment\. You can add as many filters as you want in order to tailor the segment to your needs\.

You have to create at least one segment group, but you can optionally create two segment groups\. If you add a second segment group to your segment, you can choose how the two segment groups are connected\. There are two ways to connect the two segment groups in your segment:
+ **By using AND logic** – If you use AND logic to connect two segment groups, your segment contains all endpoints who meet all of the criteria in both of the segment groups\.
+ **By using OR logic** – If you use OR logic to connect two segment groups, your segment contains all endpoints who meet all of the criteria in either one of the segment groups\.

## Creating a Dynamic Segment<a name="segments-building-procedure"></a>

There are two steps involved in creating a dynamic segment\. First, you set up the segment\. Next, you set up the segment groups for the segment\.

### Step 1: Set Up the Segment<a name="segment-building-procedure-step-1"></a>

**To create a segment**

1. Sign in to the AWS Management Console and open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. On the **All projects** page, choose the project to which you want to add the segment\.

1. In the navigation pane, choose **Segments**\. The **Segments** page opens and displays segments that you previously defined\.

1. Choose **Create a segment**\.

1. Under **Create a segment**, choose **Build a segment**\.  
![\[The Create a segment page with the Build segment option selected.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/segments_build.png)![\[The Create a segment page with the Build segment option selected.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/)![\[The Create a segment page with the Build segment option selected.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/)

1. For **Segment name**, type a name for the segment to make it easy to recognize later\.

### Step 2: Configure Segment Groups<a name="segment-building-procedure-step-2"></a>

1. Under **Segment group 1**, next to **Include endpoints that are in**, choose one of the following options:
   + **any** – If you use more than one segment as a base segment, your new segment contains endpoints that are in at least one of the segments you select\.
   + **all** – If you use more than one segment as a base segment, your new segment only contains endpoints that are in all of the selected segments\.

1. Next to **of the following segments**, choose the segment or segments that you want to use as base segments, as shown in the following image\.
**Tip**  
The menu doesn't close when you select the first base segment\. If you want to use several base segments, you can continue to select segments as necessary\. When you're done choosing segments, choose an area outside the menu to close it\.  
![\[The Segment group 1 section with two base segments selected.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/segments_groups.png)![\[The Segment group 1 section with two base segments selected.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/)![\[The Segment group 1 section with two base segments selected.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/)

1. For **Add a filter**, choose the type of filter you want to add to the segment\. You can choose from the following options:
   + **Filter by channel** – Use this option to filter the segment based on the channel of the recipient's endpoint\. For example, when you choose **EMAIL**, your segment only contains endpoints that can receive email\.
   + **Filter by endpoint** – Use this option to filter by endpoint\-specific attributes\. When you select this option, you specify how recently the endpoint was active, or how long it's been inactive\. After that, you can optionally specify additional attributes associated with that endpoint\. For example, this filter could include all customers who were active within the past 7 days who used an iPhone to access your app, as shown in the following image\.  
![\[An Endpoint filter that is set up to include all customers who were active within the past 7 days and who use iPhones.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/segments_filter_endpoint.png)![\[An Endpoint filter that is set up to include all customers who were active within the past 7 days and who use iPhones.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/)![\[An Endpoint filter that is set up to include all customers who were active within the past 7 days and who use iPhones.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/)

     You can add several attributes to this filter\. To add another attribute, choose **Add an attribute**\.
   + **Filter by user** – Use this option to filter the segment based on user attributes\. User attributes are those attributes that are specific to the actual customers, as opposed endpoint attributes, which focus more on the specific endpoints that customers use to interact with your app\. For example, you could set up this filter to include all users who are female, as shown in the following image\.  
![\[A User filter that is set up to include all female users.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/segments_filter_user.png)![\[A User filter that is set up to include all female users.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/)![\[A User filter that is set up to include all female users.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/)

     You can add several attributes to this filter\. To add another attribute, choose **Add an attribute**\. 

   You can add several filters to a single segment group, and each filter can include several attributes\.

   If the segment group includes more than one filter, you can specify how the filters are related to each other\. For example, you can set up the filter section to include customers who meet any of the filter criteria you specified, or to only include those customers who meet *all* of the specified criteria, or even to include only those customers who meet *none* of the specified criteria\. To change this setting, change the value next to **Endpoints who match**, as shown in the following image\.  
![\[A menu that shows the ways that you can connect multiple filters. The options are ALL, ANY, and NONE.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/segments_filter_logic.png)![\[A menu that shows the ways that you can connect multiple filters. The options are ALL, ANY, and NONE.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/)![\[A menu that shows the ways that you can connect multiple filters. The options are ALL, ANY, and NONE.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/)

1. If you want to add another segment group to the segment, choose **Add another segment group**\. When you add another segment group, you have to specify how it relates to the first segment group, as shown in the following image\.
**Note**  
If you use an imported segment as the base segment for your first segment group, you can't create a second segment group\.  
![\[A menu that shows the ways that you can connect multiple segment groups. The options are AND and OR.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/segments_groups_logic.png)![\[A menu that shows the ways that you can connect multiple segment groups. The options are AND and OR.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/)![\[A menu that shows the ways that you can connect multiple segment groups. The options are AND and OR.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/)

   If you select **AND**, the segment contains only those customers who meet the criteria for both segment groups\. If you select **OR**, the segment contains those customers who meet the criteria in either one of the segment groups\.
**Note**  
When you create a segment by using the Amazon Pinpoint console, you can add a maximum of two segment groups\.

1. When you finish setting up the segment, choose **Create segment**\.