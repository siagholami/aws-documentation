# Quotas in AWS Elemental MediaConnect<a name="quotas"></a>

The following table describes quotas, formerly referred to as *limits*, in AWS Elemental MediaConnect\. For information about quotas that can be changed, see [AWS Service Quotas](https://docs.aws.amazon.com/general/latest/gr/aws_service_limits.html)\.


| Resource | Default Quota | Comments | 
| --- | --- | --- | 
| Entitlements | 50 per flow | The maximum number of entitlements that you can grant on a flow\. | 
| Flows | 20 per AWS Region |  The maximum number of flows that you can create in each AWS Region\. You can [request a quota increase](https://console.aws.amazon.com/servicequotas/home?region=us-east-1#!/services/mediaconnect/quotas)\.  | 
| Outputs | 50 per flow | The maximum number of outputs that a flow can have\. | 
| Sources | 2 per flow | The maximum number of sources that a flow can have\. | 
| VPC interfaces | 2 per flow | The maximum number of VPC interfaces that a flow can have\. | 

**Note**  
To optimize performance, we recommend that you set up your workflow for an aggregate output bandwidth of 400 Mb/s or less\. For more information, see [Best practices](best-practices.md)\.