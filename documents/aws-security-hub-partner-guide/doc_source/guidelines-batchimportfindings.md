# Guidelines for using the `BatchImportFindings` API<a name="guidelines-batchimportfindings"></a>

When using the [https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html](https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html) API operation to send findings to AWS Security Hub, use the following guidelines\.
+ Send the largest batch that you can\. Security Hub accepts up to 100 findings or 240 KB per batch, whichever comes first\.
+ The throttle rate limit is 10 TPS, with a burst of 30 TPS\.
+ You must implement a mechanism to retain the state of findings if throttling or network issues exist\. You also need the finding state so that you can submit finding updates as a finding moves in and out of compliance\.
+ For information about the maximum lengths of strings and other limitations, see [AWS Security Finding Format \(ASFF\)](https://docs.aws.amazon.com/securityhub/latest/userguide/securityhub-findings-format.html) in the *AWS Security Hub User Guide*\.