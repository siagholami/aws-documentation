# Sending Reports by Email<a name="sending-reports"></a>

In Enterprise edition, you can send a dashboard in report form either once or on a schedule \(daily, weekly, or monthly\)\. You can email the reports to users or groups who share your Amazon QuickSight subscription\. To receive email reports, the users or group members must meet the following conditions: 
+ They are part of your Amazon QuickSight subscription\.
+ You already shared the dashboard with them\.
+ They have completed sign\-up process to activate their subscription as Amazon QuickSight readers, authors, or admins\.

Subscribers who are readers see an option for **Reports** on the dashboard when an email report is available for that dashboard\. They can use the **Reports** option to subscribe to or unsubscribe from the emails\. They can also change their preferred report layout\. For more information, see [Subscribing to Reports](subscribing-to-reports.md)\.

**Note**  
Email reports use only the static default value for parameters\. Any dynamic default values for parameter controls are ignored\.   
You can't create email reports for dashboards with data sets that use row\-level security \(RLS\)\. If RLS is later enabled on the dashboard, the report email isn't sent out\. Users can access RLS\-based dashboards by using the Amazon QuickSight app\.   
Geospatial \(map\) charts aren't supported for email reports\.

## How billing works for email reports<a name="sending-reports-billing-info"></a>

Authors and admins can receive any number of email reports at no extra charge\.

For readers \(users in the reader role\), it costs one session per report, up to the monthly maximum\. After receiving an email report, the reader gets a session credit to access the interactive dashboard at no additional cost during the same month\. Reader session credits don't carry over to the next billing month\. 

For a reader, charges for email reports and interactive sessions both accrue up to the monthly maximum charge\. For readers who hit the monthly max charge, there are no further charges, and they can receive as many additional email reports as they need\. 

## Emailing Reports from a Dashboard<a name="email-reports-from-dashboard"></a>

You can set up or alter emailed reports by choosing **Share** and **Email report** from your dashboard screen\. The settings include the following:
+ Schedule for sending the report \(once only, daily, weekly, or monthly\)
+ Report title
+ Email subject line
+ Email body text
+ Option to view optimized for mobile
+ Recipients

  You can automatically send the report to selected recipients or to all users who have access to the dashboard\. Readers can also choose to subscribe from the dashboard\.

Before you save your report settings, you can choose **View dataset** list to see which data sets are used in the report\. You can also choose to send a sample of the report by choosing **Send test report**\.

Use the following procedure to email reports from a dashboard in Enterprise edition\. The same procedure applies to both creating new and editing existing reports\.

1. Make sure that you are using Amazon QuickSight Enterprise edition and that you have shared the dashboard with the users or group members you want to schedule email reports for\.

   To enable, edit, or delete emailed reports, you must be a co\-owner of the dashboard\.

1. Open the dashboard that you want to send out\. Then choose **Email report** from the **Share** icon on the application bar at the top of the screen\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/email-report-1.png)

1. Choose **Schedule** to set the schedule for the report, and then choose the frequency for the report:
   + **Send once \(Does not repeat\)** – sends the report only once at the date and time that you choose\.
   + **Repeat once a day** – reports daily at the same time\.
   + **Repeat once a week** – reports each week on the same day at the same time\. 
   + **Repeat once a month** – repeats on the same day of the month at the same time\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/email-report-schedule.png)

   For **Send first report on**, choose the date and time that you want the first report to be sent\. If you choose to repeat the report, the schedule recurs at the same time and day based on the interval you select\. For example, suppose that you choose to send your first report August 1 at 9 a\.m\., and you choose that the report repeat once a month\. In this case, the second report is sent September 1 at 9 a\.m\. If you choose once a week, the day of the week August 1 falls on is the day the report repeats, at the same time the first one sends\. 

   For **Time Zone**, choose the time zone that applies to this schedule\.

   If you are editing an existing report, the **Pause this report** button appears\. Using this option, you can pause the current schedule without deleting it\. If the report has already been paused, the **Resume this report** button appears instead, so you can continue with the existing schedule\. The schedule is paused or resumed after you save your changes by choosing to update the report \(at the bottom of the screen\)\.

1. Customize the email title, subject line, and body text\.

   For **Report title**, enter a title for the report\. By default, this is the same as the dashboard title\.

   Optionally, you can enter a customized subject line in **E\-mail subject line**, and the text for your email in **E\-mail body text**\. 

1. For **Optimize report for**, choose one of the following options:
   + **Viewing on a desktop** – send your report as it appears in your dashboard\.
   + **Viewing on a mobile device** – stack visuals into a single column\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/email-report-2.png)

1. Choose recipients for your report: 
   + Enable the option for **Send email report to all users with access to dashboard** to send your report to people that you shared the dashboard with\. When you add new users to the dashboard, they automatically start receiving the email reports also\.
   + Choose recipients from the provided list to specify and maintain a list of people you want to email reports to\. You can use the search box to locate people by email or group name\.

   People who have access to the dashboard can choose to subscribe or unsubscribe themselves from the emailed version of the dashboard\. For more information on subscribing, see [Subscribing to Reports](subscribing-to-reports.md)\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/email-report-3.png)

1. \(Optional\) To view a list of the data sets used by this report, choose **View dataset list** at the bottom of the screen\. 

1. If you are creating a new report, choose **Save report** to confirm your choices\. A "**Report scheduled**" message briefly appears at upper right\. 

   If you are editing a report, choose one of the following options: 
   + To save changes and close the screen, choose **Update report**\.
   + To save changes and immediately send out a report, choose **Update & send a report now**\. If you choose to send the report now, it's sent out immediately, even when your schedule's start date is in the future\.