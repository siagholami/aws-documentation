# Limits on the Number of Elastic Transcoder Pipelines, Jobs, and Presets<a name="limits"></a>

Elastic Transcoder pipelines, jobs, and presets are subject to the following limitations:
+ **Pipelines:** For each region, 4 pipelines per AWS account
+ **Maximum number of queued jobs:** 1,000,000 per pipeline
+ **Maximum number of outputs:** 30 per job
+ **Maximum number of jobs processed simultaneously by each pipeline:** 100 per pipeline
+ **Presets:** 50 user\-defined presets per AWS account \(Elastic Transcoder also includes predefined presets that don't count against the limit\.\)
+ **Maximum rate at which you can submit job requests:**
  + **Create Job:** You can submit two `Create Job` requests per second per AWS account at a sustained rate; brief bursts of 100 requests per second are allowed\.
  + **Read Job:** You can submit four `Read Job` requests per second per AWS account at a sustained rate; brief bursts of 50 requests per second are allowed\.

You can request higher limits at [https://console\.aws\.amazon\.com/support/home\#/case/create?issueType=service\-limit\-increase&limitType=service\-code\-elastic\-transcoders](https://console.aws.amazon.com/support/home#/case/create?issueType=service-limit-increase&limitType=service-code-elastic-transcoders)\.