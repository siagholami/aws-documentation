# Understanding Amazon CloudSearch Limits<a name="limits"></a>

This table shows naming and size restrictions within Amazon CloudSearch\. You can [submit a request](https://console.aws.amazon.com/support/home#/case/create?issueType=service-limit-increase&limitType=service-code-cloudsearch-partitions-and-instances) if you need to increase the maximum number of partitions for a search domain\. For information about increasing other limits such as the maximum number of search domains, contact Amazon CloudSearch\.

The current Amazon CloudSearch limits are summarized in the following table\. 


| Item | Limit | 
| --- | --- | 
| Batch size | The maximum batch size is 5 MB\. | 
| Data loading volume | You can load one document batch every 10 seconds \(approximately 10,000 batches every 24 hours\), with each batch size up to 5 MB\.Exceeding this limit significantly increases the latency of document updates and could result in throttling\. To mitigate this risk, you can increase your update capacity by selecting a larger instance type\. For more information, see [Creating Document Batches](preparing-data.md#creating-document-batches)\.  No matter which instance type you select, Amazon CloudSearch does not guarantee the ordering of documents received in the same second\. For example, if you send three updates with a tenth of a second between them, the final update might not be the last one applied\. Preserving update order is yet another reason to adhere to this limit\.  | 
| Document size | The maximum document size is 1 MB\. | 
| Document fields | Documents can have no more than 200 fields\. | 
| Expressions | [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/cloudsearch/latest/developerguide/limits.html)  | 
| Highlighting | [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/cloudsearch/latest/developerguide/limits.html)  | 
| Index fields | [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/cloudsearch/latest/developerguide/limits.html) | 
| Naming conventions | [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/cloudsearch/latest/developerguide/limits.html)  | 
| Policy document size | The maximum size of an Amazon CloudSearch policy document is 100 KB\. | 
| Region restriction | The ap\-northeast\-2 region supports only m4 instance types\. | 
| \_score | A document's text relevance score is a positive floating point value\. | 
| Search domains | Each AWS account can create up to 100 search domains\.  | 
| Search partitions | A search index can be split across a maximum of 10 partitions\. You can [submit a request](https://console.aws.amazon.com/support/home#/case/create?issueType=service-limit-increase&limitType=service-code-cloudsearch-partitions-and-instances) if you need to increase this limit\. To avoid search query failures, Amazon CloudSearch domains can grow beyond this maximum partition limit, but new document additions are rejected\. If you encounter this scenario, delete documents and trigger the IndexDocuments API\. Alternately, request a limit increase\. You can monitor the Amazon CloudWatch `IndexUtilization` and `Partitions` metrics to take action before exceeding the maximum partition limit\. | 
| Search replicas | Each search partition can have up to 5 replicas\.  Enabling Multi\-AZ doubles the number of replicas\.  | 
| Search requests |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/cloudsearch/latest/developerguide/limits.html)  | 
| Suggesters |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/cloudsearch/latest/developerguide/limits.html) | 
| Synonym dictionary size | The maximum size of a Amazon CloudSearch synonym dictionary is 100 KB\. | 