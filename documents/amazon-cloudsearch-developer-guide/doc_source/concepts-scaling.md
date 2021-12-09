# Automatic Scaling in Amazon CloudSearch<a name="concepts-scaling"></a>

A search domain has one or more search instances, each with a finite amount of RAM and CPU resources for indexing data and processing requests\. How many search instances a domain needs depends on the documents in your collection and the volume and complexity of your search requests\.

Amazon CloudSearch can determine the size and number of search instances required to deliver low latency, high throughput search performance\. When you upload your data and configure your index, Amazon CloudSearch builds an index and picks the appropriate initial search instance type\. As you use your search domain, Amazon CloudSearch can scale to accommodate the amount of data uploaded to the domain and the volume and complexity of search requests\.

When you create a search domain, a single instance is deployed for the domain\. As the following illustration shows, you always have at least one instance for your domain\. Amazon CloudSearch automatically scales the domain by adding instances as the volume of data or traffic increases\. 

![\[Scaling for Data and Traffic\]](http://docs.aws.amazon.com/cloudsearch/latest/developerguide/images/cloudsearch-scaling-diagram.png)

## Scaling for Data<a name="w3aab5c29c13"></a>

When the amount of data you add to your domain exceeds the capacity of the initial search instance type, Amazon CloudSearch scales your search domain to a larger search instance type\. After a domain exceeds the capacity of the largest search instance type, Amazon CloudSearch partitions the search index across multiple search instances\. \(The number of search instances required to hold the index partitions is sometimes referred to as the domain's *width*\.\) 

When the volume of data in your domain shrinks, Amazon CloudSearch scales down your domain to fewer search instances or a smaller search instance type to minimize costs\.

**Note**  
If your domain has scaled up to accommodate your index size and you delete a large number of documents, the domain scales down the next time the full index is rebuilt\. Although the index is automatically rebuilt periodically, to scale down as quickly as possible you can explicitly [run indexing](indexing.md) when you are done deleting documents\. 

## Scaling for Traffic<a name="w3aab5c29c15"></a>

As your search request volume or complexity increases, it takes more processing power to handle the load\. A high volume of document uploads also increases the load on a domain's search instances\. When a search instance nears its maximum load, Amazon CloudSearch deploys a duplicate search instance to provide additional processing power\. \(The number of duplicate search instances is sometimes referred to as the domain's* depth*\.\) 

When traffic drops, Amazon CloudSearch removes search instances to minimize costs\. For example, a new domain might scale up to handle the initial influx of documents, and scale back down after you have finished uploading your data and are only submitting updates\.

If your domain experiences a sudden surge in traffic, Amazon CloudSearch deploys additional search instances\. It takes a few minutes to set up the new instances, however, so you might see an increase in 5xx errors until the new instances can start processing requests\. For more information about handling 5xx errors, see [Handling Errors](error-handling.md)\. 

Keep in mind that the type and complexity of your search requests affect overall search performance and in some cases increase the number of search instances required to operate your domain\. Submitting a high volume of small or single\-document batches can affect your search domain's performance\. For more information, see [Tuning Search Request Performance in Amazon CloudSearch](tuning-search.md)\.