# Managing the scope time used on finding and entity profiles<a name="scope-time-managing"></a>

The charts, timelines, and other data displayed on finding and entity profiles are all based on the current scope time, which appears at the top right of each profile\. The data displayed on those charts, timelines, and other visualizations is based on the scope time\. For some profile panels, additional time is added before and after the scope time to provide context\. All times are displayed in UTC\.

Detective analytics use the scope time when checking for unusual activity\. The analytics process gets the activity during the scope time, then compares it to the activity during the 45 days before the scope time\. It also uses that 45\-day timeframe to generate baselines of activity\. 

As you work through an investigation, you can adjust the scope time\. For example, if the original analysis was based on activity from a single day, you might want to expand that to a week or a month\. The expanded period could help you get a better sense of whether the activity fits a normal pattern or is indeed unusual\.

When you change the scope time, Detective repeats its analysis and updates the displayed data based on the new scope time\.

The scope time cannot be shorter than one hour nor longer than one year\. The start and end time must be on an hour\.

## Setting specific start and end dates and times<a name="scope-time-select-date"></a>

You can set the scope time start and end dates from the Detective console\.

**To set specific start and end times for the new scope time**

1. On a finding or entity profile, choose the scope time\.

1. On the **Edit scope time** panel, under **Start**, choose the new start date and time for the scope time\. For the new start time, you choose the hour only\.

   Remember that in Detective, all times are in UTC\.

1. Under **End**, choose the new end date and time for the scope time\. For the new end time, you choose the hour only\. The end time must be at least an hour later than the start time\.

1. When you're finished editing, to save the changes and update the displayed data, choose **Update scope time**\.

## Selecting a length of time from the current time<a name="scope-time-select-length"></a>

When you set a scope time length, Detective sets the scope time to that amount of time from the current time\.

**To set the scope time length**

1. From a finding or entity profile, choose the scope time\.

1. On the **Edit scope time** panel, next to **Historical**, choose the length of time for the scope time\.

   Specifying a time range updates the **Start** and **End** settings\.

1. When you're finished editing, to save the changes and update the displayed data, choose **Update scope time**\.

## Setting the scope time to the finding time window<a name="scope-time-align-to-finding"></a>

Each finding has an associated time window, which reflects the first and last times the finding was observed\. When you navigate to a finding profile, if the current scope time does not match the finding time window, a warning is displayed\.

When you edit the scope time from a finding profile, you can align the scope time to the finding time window\.

**To align the scope time to the finding time window**

1. On a finding profile, choose the scope time\.

1. On the **Edit scope time** panel, choose **Align scope time to start and end of current finding**\.

1. When you're finished editing, to save the changes and update the displayed data, choose **Update scope time**\.