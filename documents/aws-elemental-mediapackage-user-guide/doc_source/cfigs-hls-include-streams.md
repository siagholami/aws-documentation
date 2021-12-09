# Stream Selection Fields<a name="cfigs-hls-include-streams"></a>

Limit what incoming bitrates are available for playback and sort the streams in the output of an asset that uses this packaging configuration\. 

The minimum and maximum values take into account only the video bitrates\. If the video bitrate is *below the minimum* specified rate, it is *not* included in the output, regardless of the sum of the bitrates for other tracks\. Likewise, if the video bitrate is *below the maximum *specified rate, it *is* included in the output, regardless of the sum of the bitrates for other tracks\.

To set minimum and maximum bitrates and sort the output, choose **Stream selection** and complete the additional fields as follows:

1. \(Optional\) For **Bitrate order**, choose from the following:
   + **Original** to sort the output streams in the same order that the incoming source uses\.
   + **Ascending** to sort the output streams starting with the lowest bitrate and ending with the highest\.
   + **Descending** to sort the output streams starting with the highest bitrate and ending with the lowest\.

1. \(Optional\) To ensure tracks are *at least* a certain bitrate, choose **Min video bitrate** and enter the minimum bitrate threshold that video tracks must meet to be available for playback from this endpoint\.

1. \(Optional\) To ensure tracks are *no more than* a certain bitrate, choose **Max video bitrate** and enter the maximum bitrate threshold that video tracks must meet to be available for playback from this endpoint\.