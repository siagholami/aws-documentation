# Ad Transcoding<a name="manifest-transcoding"></a>

When AWS Elemental MediaTailor stitches in the ads that are specified by the ad decision server \(ADS\) in the VAST response, it checks whether the ads have already been transcoded: 
+ If an ad has been transcoded, MediaTailor uses the ad in the ad avail\. 
+ If it hasn't been transcoded, MediaTailor transcodes it for future use, but doesn't use it for the current request\. 

If there are multiple ads in the VAST response, AWS Elemental MediaTailor evaluates them sequentially and uses the ones that are already transcoded\. If no ads are transcoded yet, MediaTailor plays the underlying content \(or ad slate\) instead of the ad\.