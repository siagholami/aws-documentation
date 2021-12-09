# Staging Bucket No Longer Exists When Using Athena with Amazon QuickSight<a name="troubleshoot-athena-missing-bucket"></a>

Use this section to help solve this error: "**The staging bucket for this query result no longer exists in the underlying data source\.**"

 When you create a data set using Athena, Amazon QuickSight creates an S3 bucket\. By default, this bucket has a name similar to "`aws-athena-query-results->region<->account-id<`"\. If you remove this bucket, then your next Athena query might fail with an error saying the staging bucket no longer exists\. 

 To fix this error, create a new bucket with the same name in the correct AWS Region\. 