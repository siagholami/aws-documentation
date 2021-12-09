# TestWindowSummary<a name="API_TestWindowSummary"></a>

The status, start time, and end time of a backtest, as well as a failure reason if applicable\.

## Contents<a name="API_TestWindowSummary_Contents"></a>

 **Message**   <a name="forecast-Type-TestWindowSummary-Message"></a>
If the test failed, the reason why it failed\.  
Type: String  
Required: No

 **Status**   <a name="forecast-Type-TestWindowSummary-Status"></a>
The status of the test\. Possible status values are:  
+  `ACTIVE` 
+  `CREATE_IN_PROGRESS` 
+  `CREATE_FAILED` 
Type: String  
Length Constraints: Maximum length of 256\.  
Required: No

 **TestWindowEnd**   <a name="forecast-Type-TestWindowSummary-TestWindowEnd"></a>
The time at which the test ended\.  
Type: Timestamp  
Required: No

 **TestWindowStart**   <a name="forecast-Type-TestWindowSummary-TestWindowStart"></a>
The time at which the test began\.  
Type: Timestamp  
Required: No

## See Also<a name="API_TestWindowSummary_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/TestWindowSummary) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/TestWindowSummary) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/TestWindowSummary) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/TestWindowSummary) 