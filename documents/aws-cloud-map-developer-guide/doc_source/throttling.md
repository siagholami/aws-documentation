# AWS Cloud Map API request throttling quota<a name="throttling"></a>

AWS Cloud Map throttles `DiscoverInstances` API requests for each AWS account on a per\-Region basis\. Throttling helps improve the performance of the service and helps provide fair usage for all AWS Cloud Map customers\. Throttling ensures that calls to the AWS Cloud Map `DiscoverInstances` API do not exceed the maximum allowed `DiscoverInstances` API request quotas\. `DiscoverInstances` API calls originating from any of the following sources are subject to the request quotas:
+ A third\-party application
+ A command line tool
+ The AWS Cloud Map console

If you exceed an API throttling quota, you get the `RequestLimitExceeded` error code\. For more information, see [Request rate limiting](#throttling-rate-based)\.

**Topics**
+ [How throttling is applied](#throttling-how)
+ [Adjusting API throttling quotas](#throttling-increase)

## How throttling is applied<a name="throttling-how"></a>

AWS Cloud Map uses the [token bucket algorithm](https://en.wikipedia.org/wiki/Token_bucket) to implement API throttling\. With this algorithm, your account has a *bucket* that holds a specific number of *tokens*\. The number of tokens in the bucket represents your throttling quota at any given second\.

### Request rate limiting<a name="throttling-rate-based"></a>

Throttling limits the number of `DiscoverInstances` API requests that you can make\. Each request removes one token from the bucket\. For example, the bucket size for the `DiscoverInstances` API operationis 2000 tokens, so you can make up to 2000 `DiscoverInstances` requests in one second\. If you exceed 2000 requests in one second, you are throttled and the remaining requests within that second fail\.

Buckets automatically refill at a set rate\. If the bucket is below its maximum capacity, a set number of tokens is added back to it every second until it reaches its maximum capacity\. If the bucket is full when refill tokens arrive, they are discarded\. The bucket size for the `DiscoverInstances` API operationis 2000 tokens, and the refill rate is 1000 tokens per second\. If you make 2000 `DiscoverInstances` API requests in a second, the bucket is immediately reduced to zero \(0\) tokens\. The bucket is then refilled by up to 1000 tokens every second until it reaches its maximum capacity of 2000 tokens\.

You can use tokens as they are added to the bucket, without waiting for the bucket to be completely full before you make API requests\. If you deplete the bucket by making 2000 `DiscoverInstances` API requests in one second, you can continue to make up to 1000 `DiscoverInstances` API requests per second after that for as long as needed\. This means that you can immediately use the refill tokens as they are added to your bucket\. The bucket only starts to refill to the maximum capacity when you make fewer API requests per second than the refill rate\.

### Retries or batch processing<a name="retries"></a>

If an API request fails, your application might need to retry the request\. To reduce the number of API requests, use an appropriate sleep interval between successive requests\. For best results, use an increasing or variable sleep interval\.

### Calculating the sleep interval<a name="calculate_delay_interval"></a>

When you have to poll or retry an API request, we recommend using an exponential backoff algorithm to calculate the sleep interval between API calls\. Progressively longer wait times between retries for consecutive error responses reduces the number of failed requests\. For more information, and implementation examples of this algorithm, see [Error Retries and Exponential Backoff in AWS](https://docs.aws.amazon.com/general/latest/gr/api-retries.html)\.

## Adjusting API throttling quotas<a name="throttling-increase"></a>

You can request an increase to API throttling quotas for your AWS account\. To request a quota adjustment, contact the [AWS Support Center](https://console.aws.amazon.com/support/home#/)\.