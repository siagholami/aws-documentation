# I Can't Add a Visual to My Analysis<a name="troubleshoot-adding-visuals"></a>

If you are editing an analysis for a selected data source, and the connection to the data source terminates unexpectedly, this error state can prevent further changes to the analysis\. In this case, you can't add more visuals to the analysis\.

To fix this issue, do the following:
+ Verify that you still have access to the data source\.
+ Add exceptions to your ad blocker for `*.aws.amazon.com`, `amazonaws.com`, and `https://mobileanalytics.*.amazonaws.com`\.
+ If you are using a proxy server, verify that `*.quicksight.aws.amazon.com` is added to the list of approved domains \(allowlist\)\.