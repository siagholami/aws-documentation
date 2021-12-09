# Document History for AWS Elemental MediaTailor<a name="document-history"></a>

The following table describes important changes to this documentation\. 

| Change | Description | Date | 
| --- |--- |--- |
| [DASH VOD manifests](manifest-dash.md) | Added support for video on demand \(VOD\) DASH manifests from the origin server, with multi\-period manifest output\. | December 23, 2019 | 
| [Console support for transcode profile name](configurations-create.md) | Added description for transcode profile name in the configuration\. | December 23, 2019 | 
| [Updated limits tables](limits.md) | Updated limits for ADS redirects and ADS timeouts\. | December 18, 2019 | 
| [CDN best practices](cdn-bp.md) | Added a section about content distribution network \(CDN\) best practices for personalized manifests\.  | December 13, 2019 | 
| [Document live pre\-roll behaviors](ad-behavior-live.md#ad-behavior-preroll) | Added *Pre\-Roll Ad Insertion* section to describe how live pre\-roll ads work with AWS Elemental MediaTailor\. | November 26, 2019 | 
| [Support for live pre\-roll ads](configurations-create.md) | Added support for inserting pre\-roll ads at the beginning of a live stream\. | September 11, 2019 | 
| [Analyzing ADS Logs in Amazon CloudWatch Logs Insights](monitor-cloudwatch-ads-logs.md) | Added information for using the AWS Elemental MediaTailor ADS logs and CloudWatch Logs Insights to analyze your MediaTailor sessions\. | August 13, 2019 | 
| [New security chapter](security.md) | Added a security chapter to enhance and standardize coverage\. | May 23, 2019 | 
| [DASH single\-period manifests](manifest-dash.md) | Added support for single\-period DASH manifests from the origin server, with multi\-period manifest output\. | April 4, 2019 | 
| [Support for SCTE\-35 UPIDs in the ADS URL](variables-session.md) | Added support for including a unique program ID \(UPID\) in the ad decision server \(ADS\) URL\. This allows the ADS to provide program\-level ad targeting within a live linear stream\.  | March 28, 2019 | 
| [Client\-side reporting supports companion ads](ad-reporting-client-side.md) | For client\-side reporting, the AWS Elemental MediaTailor tracking URL response now includes companion ad metadata\.  | March 28, 2019 | 
| [HLS ad marker documentation](hls-ad-markers.md) | Added a section that describes supported HLS ad markers\. | March 1, 2019 | 
| [Tagging support](tagging.md) | Added support for tagging of configuration resources in AWS Elemental MediaTailor\. Tagging allows you to identify and organize your AWS resources and control access to them and to track your AWS costs\. | February 14, 2019 | 
| [Added AWS CloudTrail logging information](logging-using-cloudtrail.md) | Added topic about using CloudTrail to log actions in the AWS Elemental MediaTailor API\. | February 11, 2019 | 
| [Added section on playback errors](playback-errors.md) | Added information about the errors that might be returned by MediaTailor during playback, in response to requests from a player or a content delivery network \(CDN\)\. | February 4, 2019 | 
| [DASH base64\-encoded binary](manifest-dash.md) | Added support for providing splicing information in manifests in base64\-encoded binary, inside `<scte35:Signal>` `<scte35:Binary>` markers\. | January 4, 2019 | 
| [DASH time signal](manifest-dash.md) | Added support for providing splicing information in manifests inside `<scte35:TimeSignal>` markers\. | December 5, 2018 | 
| [DASH location support](dash-location-feature.md) | Added support for the MPEG\-DASH `<Location>` tag\. | December 4, 2018 | 
| [DASH support](manifest-dash.md) | Added support for MPEG\-DASH manifests\. | November 14, 2018 | 
| [Updated limits tables](limits.md) | Updated limits for configurations and manifest size\. | October 13, 2018 | 
| [New and updated metrics](monitoring-cloudwatch-metrics.md) | Added metrics for ad decision server \(ADS\) and origin timeouts, and updated the ADS and origin error definitions to include timed\-out responses\.  | October 13, 2018 | 
| [Better documentation coverage for server\-side and client\-side ad insertion use cases](variables.md) | Expanded description and examples to cover the use of dynamic ad variables for server\-side ad insertion and for client\-side ad insertion\.  | October 1, 2018 | 
| [New Regions](what-is.md#regions-endpoints) | Added support for the PDX and FRA Regions\. | July 18, 2018 | 
| [VAST/VPAID](vast.md) | Added information about VAST and VPAID\.  | March 16, 2018 | 
| [CloudWatch](monitoring.md) | Added information about available CloudWatch metrics, namespaces, and dimensions\.  | March 16, 2018 | 
| [New Regions](what-is.md#regions-endpoints) | Added support for the Asia Pacific \(Singapore\), Asia Pacific \(Sydney\), and Asia Pacific \(Tokyo\) Regions\. | February 8, 2018 | 
| [Default Amazon CloudFront distribution paths](integrating-cdn-standard.md) | Added the list of paths for the Amazon CloudFront distribution where AWS Elemental MediaTailor stores ads\.  | February 6, 2018 | 
| [IAM policy information](setting-up.md) | Added IAM policy information specific to AWS Elemental MediaTailor\. Added instructions for creating non\-admin roles with limited permissions\.  | January 3, 2018 | 
| [First release](what-is.md) | First release of this documentation\. | November 27, 2017 | 

**Note**  
The AWS Media Services are not designed or intended for use with applications or in situations requiring fail‐safe performance, such as life safety operations, navigation or communication systems, air traffic control, or life support machines in which the unavailability, interruption or failure of the services could lead to death, personal injury, property damage or environmental damage\.