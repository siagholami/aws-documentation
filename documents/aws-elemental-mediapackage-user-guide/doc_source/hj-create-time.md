# Start and End Date and Time<a name="hj-create-time"></a>

The start and end date and time information defines the time range for the harvest job\. Times are based on the program date time \(PDT\) from the encoder\.

**Note**  
The live\-to\-VOD asset timing is accurate up to the segment\. This means that if you indicate a start or end time that falls within a segment, MediaPackage includes the entire segment in the asset\. If you have a 3\-second segment and that start time falls on the third second in the segment, the asset will begin two seconds earlier, at the start of the segment\.

1. For **Date and time format**, choose the format that you're using to indicate the start and end times of the live\-to\-VOD asset\. These are the available options:
   + **Local time**: the date and time is formatted according to the settings of your current browser session\. Local time uses a 24\-hour clock\.
   + **Epoch seconds**: the date and time is formatted in seconds since the epoch\.
   + **ISO\-8601**: the date and time is formatted according to the ISO\-8601 standard\.

1. For **Start date and time**, specify when the live\-to\-VOD asset begins\. The asset's begin time must be at the same time or after the live event started\. The start time must also be within the startover window on the endpoint\. If the endpoint has a window of 5 hours and the start time is 6 hours ago, the harvest job fails\.

1. For **End date and time**, specify when the live\-to\-VOD asset ends\. The length of the asset can't exceed the startover window on the endpoint\. If the endpoint has a window of 5 hours and your start time is 2019/07/29 07:15:00, the end time can't be after 2019/07/29 12:15:00\. The end time must also be in the past\.