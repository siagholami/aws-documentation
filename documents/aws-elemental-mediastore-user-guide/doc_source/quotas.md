# Quotas in AWS Elemental MediaStore<a name="quotas"></a>

The Service Quotas console provides information about AWS Elemental MediaStore quotas\. Along with viewing the default quotas, you can use the Service Quotas console to [request quota increases](https://console.aws.amazon.com/servicequotas/home?region=us-east-1#!/services/mediastore/quotas) for adjustable quotas\.

The following table describes quotas, formerly referred to as *limits*, in AWS Elemental MediaStore\. 


****  

|  Resource or Operation  |  Default Quota  |  Comments  | 
| --- | --- | --- | 
| Containers | 100 | The maximum number of containers that you can create in this account\. | 
|  [DeleteObject](https://docs.aws.amazon.com/mediastore/latest/apireference/API_objstore_DeleteObject.html)  |  100 transactions per second \(TPS\)  |  The maximum number of operation requests that you can make per second\. Additional requests are throttled\. You can [request a quota increase](https://console.aws.amazon.com/servicequotas/home?region=us-east-1#!/services/mediastore/quotas)\.  | 
|  [DescribeObject](https://docs.aws.amazon.com/mediastore/latest/apireference/API_objstore_DescribeObject.html)  |  1,000 TPS  |  The maximum number of operation requests that you can make per second\. Additional requests are throttled\. You can [request a quota increase](https://console.aws.amazon.com/servicequotas/home?region=us-east-1#!/services/mediastore/quotas)\.  | 
| Folder Levels | 10 | The maximum number of folder levels that you can create in a container\. You can create as many folders as you want, as long as they are not nested more than 10 levels within a container\. | 
| Folders | Unlimited | You can create as many folders as you want, as long as they are not nested more than 10 levels within a container\. | 
|  [GetObject](https://docs.aws.amazon.com/mediastore/latest/apireference/API_objstore_GetObject.html) – Standard Upload Availability  |  1,000 TPS  |  The maximum number of operation requests that you can make per second\. Additional requests are throttled\. You can [request a quota increase](https://console.aws.amazon.com/servicequotas/home?region=us-east-1#!/services/mediastore/quotas)\.  | 
|  [GetObject](https://docs.aws.amazon.com/mediastore/latest/apireference/API_objstore_GetObject.html) – Streaming Upload Availability  |  25 TPS  |  The maximum number of operation requests that you can make per second\. Additional requests are throttled\. You can [request a quota increase](https://console.aws.amazon.com/servicequotas/home?region=us-east-1#!/services/mediastore/quotas)\.  | 
|  [ListItems](https://docs.aws.amazon.com/mediastore/latest/apireference/API_objstore_ListItems.html)  |  5 TPS  |  The maximum number of operation requests that you can make per second\. Additional requests are throttled\. You can [request a quota increase](https://console.aws.amazon.com/servicequotas/home?region=us-east-1#!/services/mediastore/quotas)\.  | 
| Object Size | 25 MB | The maximum file size of a single object\. | 
| Objects | Unlimited | You can upload as many objects as you want to a folder or container in your account\. | 
|  [PutObject](https://docs.aws.amazon.com/mediastore/latest/apireference/API_objstore_PutObject.html) – Standard Upload Availability  |  100 TPS  |  The maximum number of operation requests that you can make per second\. Additional requests are throttled\. You can [request a quota increase](https://console.aws.amazon.com/servicequotas/home?region=us-east-1#!/services/mediastore/quotas)\. In the request, specify the requested TPS and average object size\.  | 
| [PutObject](https://docs.aws.amazon.com/mediastore/latest/apireference/API_objstore_PutObject.html) – Streaming Upload Availability | 10 TPS |  The maximum number of operation requests that you can make per second\. Additional requests are throttled\. You can [request a quota increase](https://console.aws.amazon.com/servicequotas/home?region=us-east-1#!/services/mediastore/quotas)\. In the request, specify the requested TPS and average object size\.  | 
| Rules in an Object Lifecycle Policy | 10 | The maximum number of rules that you can include in an object lifecycle policy\. | 
| Rules in a Metric Policy | 5 | The maximum number of rules that you can include in a metric policy\. You can [request a quota increase](https://console.aws.amazon.com/servicequotas/home?region=us-east-1#!/services/mediastore/quotas)\. | 