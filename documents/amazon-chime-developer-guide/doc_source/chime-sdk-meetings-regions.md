# Amazon Chime SDK media Regions<a name="chime-sdk-meetings-regions"></a>

We recommend specifying an AWS Region for your Amazon Chime SDK meeting using the `MediaRegion` parameter in the `CreateMeeting` API action\. Available media Regions for Amazon Chime SDK meetings include the following:
+ US East \(Ohio\) \(us\-east\-2\)
+ US East \(N\. Virginia\) \(us\-east\-1\)
+ US West \(N\. California\) \(us\-west\-1\)
+ US West \(Oregon\) \(us\-west\-2\)
+ Asia Pacific \(Singapore\) \(ap\-southeast\-1\)
+ Asia Pacific \(Sydney\) \(ap\-southeast\-2\)
+ Asia Pacific \(Tokyo\) \(ap\-northeast\-1\)
+ Canada \(Central\) \(ca\-central\-1\)
+ Europe \(Frankfurt\) \(eu\-central\-1\)
+ Europe \(Ireland\) \(eu\-west\-1\)
+ Europe \(London\) \(eu\-west\-2\)
+ Europe \(Paris\) \(eu\-west\-3\)
+ Europe \(Stockholm\) \(eu\-north\-1\)
+ South America \(São Paulo\) \(sa\-east\-1\)

For more information about available media Regions, see the `MediaRegion` definition for [CreateMeeting](https://docs.aws.amazon.com/chime/latest/APIReference/API_CreateMeeting.html#API_CreateMeeting_RequestBody) in the *Amazon Chime API Reference*\.

**Note**  
The preceding media Regions are used for hosting Amazon Chime SDK meetings\. This differs from the Amazon Chime API, which has a single endpoint\. For more information, see [Amazon Chime endpoints and quotas](https://docs.aws.amazon.com/general/latest/gr/chime.html) in the *Amazon Web Services General Reference*\.

## Choosing a media Region<a name="choose-chime-sdk-media-region"></a>

When choosing a media Region to use for your Amazon Chime SDK meeting, common factors to consider include the following:

**Regulatory requirements**  
If your Amazon Chime SDK meetings are subject to regulations requiring them to be hosted within a geopolitical border, consider hardcoding the meeting Region based on fixed application logic\.  
For example, a telemedicine application might require all meetings to be hosted within the medical practitioner's jurisdiction\. If the application supports clinics located in both Europe and the United States, you can use each clinic's address to select a Region within its jurisdiction\.

**Meeting quality**  
When an Amazon Chime SDK meeting is hosted in a media Region, each attendee's audio and video is sent and received from that Region\. As the distance between the attendee and the Region increases, meeting quality can be affected by network latency\. Specifying a Region for your Amazon Chime SDK meeting can help enhance the meeting quality for your attendees, whether they are located near each other or distributed geographically\.

You can use one of the following methods to choose a media Region for your Amazon Chime SDK meeting:

**Hardcode a media Region**  
Recommended if your Amazon Chime SDK meetings are all hosted within a specific AWS Region\.

**Choose the nearest media Region**  
Recommended if your Amazon Chime SDK meeting attendees are located in the same AWS Region, but your meetings are hosted in different Regions\.

For more details about choosing the nearest media Region, see the following topic\.

### Choosing the nearest media Region<a name="choose-chime-sdk-nearest-media-region"></a>

Call `https://nearest-media-region.l.chime.aws` to identify the nearest media Region that can host your Amazon Chime SDK meeting\. Make the call from the client application, not the server application\. Pass the call to the application before your attendees need to join the meeting, such as at the time that the application starts up\.

Your request returns a JSON object showing the AWS Region that is nearest to you\.

**Example : Call to `https://nearest-media-region.l.chime.aws`**  
The following example shows the contents of a request sent to `https://nearest-media-region.l.chime.aws` to identify the nearest media Region\.  

```
async getNearestMediaRegion(): Promise<string> {
    var nearestMediaRegion = '';
    const defaultMediaRegion = 'us-east-1';
    try {
      const nearestMediaRegionResponse = await fetch(
        `https://nearest-media-region.l.chime.aws`,
        {
          method: 'GET',
        }
      );
      const nearestMediaRegionJSON = await nearestMediaRegionResponse.json();
      this.log(nearestMediaRegionJSON.region);
      nearestMediaRegion = nearestMediaRegionJSON.region;
    } catch (error) {
      nearestMediaRegion = defaultMediaRegion;
      this.log('Default media region ' + defaultMediaRegion + ' selected: ' + error.message);
    } finally {
      return nearestMediaRegion;
    }
  }
```