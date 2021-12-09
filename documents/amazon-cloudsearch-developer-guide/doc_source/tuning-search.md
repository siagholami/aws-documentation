# Tuning Search Request Performance in Amazon CloudSearch<a name="tuning-search"></a>

Search requests can become very resource intensive to process, which can have an impact on the performance and cost of running your search domain\. In general, searches that return a large volume of hits and complex structured queries are more resource intensive than simple text queries that match a small percentage of the documents in your search domain\. 

If you experience slow response times, frequently encounter internal server errors \(typically 507 or 509 errors\), or see the number of instance hours your search domain consumes increase without a substantial increase in the volume of data you're searching, you can fine\-tune your search requests to help reduce the processing overhead\. This section reviews what to look for and steps you can take to tune your search requests\.

## Analyzing Query Latency<a name="tuning-search-latency"></a>

Before you can tune your requests, you must analyze your current search performance\. Log your search requests and response times so that you can see which requests take the longest to process\. Slow searches can disproportionally affect overall performance by tying up your search domain's resources\. Optimizing the slowest search requests speeds up *all* of your searches\.

**Topics**
+ [Reducing the Number of Hits](#tuning-search-numdocs)
+ [Simplifying Structured Queries](#simplifying-structured-queries)

### Reducing the Number of Hits<a name="tuning-search-numdocs"></a>

Query latency is directly proportional to the number of matching documents\. Searches that match the most documents are generally the slowest\. 

Eliminating two types of searches that commonly result in a huge number of matching documents can significantly improve overall performance:
+ Queries that match every document in your corpus \(`matchall`\)\. While this can be a convenient way to list all the documents in your domain, it's a resource intensive query\. If you have a lot of documents, not only can it cause other requests to time out, it's likely to time out itself\. 
+ Prefix \(wildcard\) searches with only one or two characters specified\. If you're using this type of search to provide instant results as the user types, wait until the user has entered at least two characters before you start submitting requests and displaying the possible matches\.

To reduce the number of documents that match your requests, you can also do the following:
+ Eliminate irrelevant words from your corpus so they aren't using for matching\. The easiest way to do this is to add them to the stopwords list dictionary for the analysis scheme\(s\) you're using\. Alternatively, you can preprocess your data to strip out irrelevant words\. Eliminating irrelevant words also has the benefit of reducing the size of your index, which can help reduce costs\.
+ Explicitly filter the results based on the value of a particular field using the `fq` parameter\.

If you still have requests that match a lot of documents, you can reduce latency by minimizing the amount of processing to be done on the result set:
+ Minimize the facet information that you request\. Generating the facet counts adds to the time it takes to process the request and increases the likelihood that other requests will time out\. If you do request facet information, keep in mind that the more facets you specify, the longer it takes to process the request\.
+ Avoid using your own expressions for sorting\. The additional processing required to sort the results increases the likelihood that requests will time out\. If you must customize how the results are sorted, it is generally faster to use a field than to use an expression\. 

Keep in mind that returning a large amount of data in the search results can increase the transport time and affect query latency\. Minimize the number of return fields you use to improve performance and reduce the size of your index\. 

### Simplifying Structured Queries<a name="simplifying-structured-queries"></a>

The more clauses there are in the query criteria, the longer it takes to process the query\. 

If you have complex structured queries that don't perform well, you need to find a way to reduce the number of clauses\. In some cases, you might simply be able to set a limit or reformulate the query\. In others, you might need to modify your domain configuration to accommodate simpler queries\. 