# VOD Content Quotas<a name="limits-vod"></a>

This section describes the quotas for video on demand \(VOD\) content in AWS Elemental MediaPackage\. For information about requesting an increase to soft quotas, see [AWS Service Quotas](https://docs.aws.amazon.com/general/latest/gr/aws_service_limits.html)\. Hard quotas can't be changed\.

## VOD Soft Quotas<a name="soft-limits-vod"></a>

The following table describes quotas in AWS Elemental MediaPackage for VOD content that can be increased\. For information about changing quotas, see [AWS Service Quotas](https://docs.aws.amazon.com/general/latest/gr/aws_service_limits.html)\. 

For some customers, your account quota might be below these published quotas\. If you believe that you encountered a Resource limit exceeded error wrongfully, use the Service Quotas console to [request quota increases](https://console.aws.amazon.com/servicequotas/home?region=us-east-1#!/services/mediapackage/quotas)\.


| Resource | Default Quota | 
| --- | --- | 
| Maximum Packaging Groups | 10 Increasing your packaging group quota doesn't always mean that you also need to increase your assets or packaging configurations\. For example, if you need 14 groups and want to serve HLS, HLS encrypted, and DASH content from each asset, you need only 3 packaging configurations for each asset \(one for each output type\)\. You do need to increase your packaging group quota, but not the packaging configuration quota because you have fewer than 10 configurations per packaging group\.  | 
| Maximum Packaging Configurations per Packaging Group | 10This is a *per packaging group* quota\. Each packaging configuration represents the output package that you use\. If one packaging group has configurations for HLS, HLS encrypted, DASH, DASH encrypted, Microsoft Smooth, and Microsoft Smooth encrypted content, then that group has 6 packaging configurations and falls within the 10 configurations quota\. If you have 10 packaging groups set up this same way, then you still haven't exceeded the quota because each group uses only 6 configurations\. | 
| Maximum Assets per Packaging Group | 1000This is a *per packaging group* quota\. If you have 1100 assets spread out over multiple packaging groups, then you still haven't exceeded the quota if each group has no more than 1000 assets\. | 

## VOD Hard Quotas<a name="hard-limits-vod"></a>

The following table describes quotas within AWS Elemental MediaPackage for VOD content that can't be increased\.


| Resource or Operation | Quota | 
| --- | --- | 
| Input Stream Quotas | 30 streams per asset, and 10 tracks per stream | 
| Request Rates per Asset |  200 output requests per second  | 
| REST API Requests |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediapackage/latest/ug/limits-vod.html)  | 