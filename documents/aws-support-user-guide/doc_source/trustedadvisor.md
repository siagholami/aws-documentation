# Using Trusted Advisor as a web service<a name="trustedadvisor"></a>

The AWS Support service enables you to write applications that interact with [AWS Trusted Advisor](https://aws.amazon.com/premiumsupport/trustedadvisor/)\. This topic shows you how to get a list of Trusted Advisor checks, refresh one of them, and then get the detailed results from the check\. These tasks are demonstrated in Java\. For information about support for other languages, see [Tools for Amazon Web Services](http://aws.amazon.com/tools/)\.

**Topics**
+ [Get the list of available Trusted Advisor checks](#Get_TA_Checks)
+ [Refresh the list of available Trusted Advisor checks](#Request_TA_Data)
+ [Poll a Trusted Advisor check for status changes](#getcheckstatus)
+ [Request a Trusted Advisor check result](#requestcheck)
+ [Print details of a Trusted Advisor check](#printdetails)

## Get the list of available Trusted Advisor checks<a name="Get_TA_Checks"></a>

The following Java code snippet creates an instance of an AWS Support client that you can use to call all Trusted Advisor actions\. Next, the code gets the list of Trusted Advisor checks and their corresponding `CheckId` values by calling the `[DescribeTrustedAdvisorChecks](https://docs.aws.amazon.com/awssupport/latest/APIReference/API_DescribeTrustedAdvisorChecks.html)` action\. You can use this information to build user interfaces that enable users to select the check they want to run or refresh\.

```
private static AWSSupport createClient()
{
    return AWSSupportClientBuilder.defaultClient();
}
// Get the List of Available Trusted Advisor Checks
public static void getTAChecks() {
    // Possible language parameters: "en" (English), "ja" (Japanese), "fr" (French), "zh" (Chinese)
    DescribeTrustedAdvisorChecksRequest request = new DescribeTrustedAdvisorChecksRequest().withLanguage("en");
    DescribeTrustedAdvisorChecksResult result = createClient().describeTrustedAdvisorChecks(request);
    for (TrustedAdvisorCheckDescription description : result.getChecks()) {
        // Do something with check description.
        System.out.println(description.getId());
        System.out.println(description.getName());
    }
}
```

## Refresh the list of available Trusted Advisor checks<a name="Request_TA_Data"></a>

The following Java code snippet creates an instance of an AWS Support client that you can use to refresh Trusted Advisor data\.

```
// Refresh a Trusted Advisor Check
// Note: Some checks are refreshed automatically, and they cannot be refreshed by using this operation.
// Specifying the check ID of a check that is automatically refreshed causes an InvalidParameterValue error.
public static void refreshTACheck(final String checkId) {
    RefreshTrustedAdvisorCheckRequest request = new RefreshTrustedAdvisorCheckRequest().withCheckId(checkId);
    RefreshTrustedAdvisorCheckResult result = createClient().refreshTrustedAdvisorCheck(request);
    System.out.println("CheckId: " + result.getStatus().getCheckId());
    System.out.println("Milliseconds until refreshable: " + result.getStatus().getMillisUntilNextRefreshable());
    System.out.println("Refresh Status: " + result.getStatus().getStatus());
}
```

## Poll a Trusted Advisor check for status changes<a name="getcheckstatus"></a>

After you submit the request to run a Trusted Advisor check to generate the latest status data, you use the `[DescribeTrustedAdvisorCheckRefreshStatuses](https://docs.aws.amazon.com/awssupport/latest/APIReference/API_DescribeTrustedAdvisorCheckRefreshStatuses.html)` action to request the progress of the check's run, and when new data is ready for the check\. 

The following Java code snippet gets the status of the check requested in the following section, using the value corresponding in the `CheckId` variable\. In addition, the code demonstrates several other uses of the Trusted Advisor service:

1. You can call `getMillisUntilNextRefreshable` by traversing the objects contained in the `DescribeTrustedAdvisorCheckRefreshStatusesResult` instance\. You can use the value returned to test whether you want your code to proceed with refreshing the check\.

1. If `timeUntilRefreshable` equals zero, you can request a refresh of the check\.

1. Using the status returned, you can continue to poll for status changes; the code snippet sets the polling interval to a recommended ten seconds\. If the status is either `enqueued` or `in_progress`, the loop returns and requests another status\. If the call returns `successful`, the loop terminates\.

1. Finally, the code returns an instance of a `DescribeTrustedAdvisorCheckResultResult` data type that you can use to traverse the information produced by the check\.

**Note:** Use a single refresh request before polling for the status of the request\.

```
// Retrieves TA refresh statuses. Multiple checkId's can be submitted.
public static List<TrustedAdvisorCheckRefreshStatus> getTARefreshStatus(final String... checkIds) {
    DescribeTrustedAdvisorCheckRefreshStatusesRequest request =
            new DescribeTrustedAdvisorCheckRefreshStatusesRequest().withCheckIds(checkIds);
    DescribeTrustedAdvisorCheckRefreshStatusesResult result =
            createClient().describeTrustedAdvisorCheckRefreshStatuses(request);
    return result.getStatuses();
}
// Retrieves a TA check status, and checks to see if it has finished processing.
public static boolean isTACheckStatusInTerminalState(final String checkId) {
    // Since we only submitted one checkId to getTARefreshStatus, just retrieve the only element in the list.
    TrustedAdvisorCheckRefreshStatus status = getTARefreshStatus(checkId).get(0);
    // Valid statuses are:
    // 1. "none", the check has never been refreshed before.
    // 2. "enqueued", the check is waiting to be processed.
    // 3. "processing", the check is in the midst of being processed.
    // 4. "success", the check has succeeded and finished processing - refresh data is available.
    // 5. "abandoned", the check has failed to process.
    return status.getStatus().equals("abandoned") || status.getStatus().equals("success");
}
// Enqueues a Trusted Advisor check refresh. Periodically polls the check refresh status for completion.
public static TrustedAdvisorCheckResult getFreshTACheckResult(final String checkId) throws InterruptedException {
    refreshTACheck(checkId);
    while(!isTACheckStatusInTerminalState(checkId)) {
        Thread.sleep(10000);
    }
    return getTACheckResult(checkId);
}
// Retrieves fresh TA check data whenever possible.
// Note: Some checks are refreshed automatically, and they cannot be refreshed by using this operation. This method
// is only functional for checks that can be refreshed using the RefreshTrustedAdvisorCheck operation.
public static void pollForTACheckResultChanges(final String checkId) throws InterruptedException {
    String checkResultStatus = null;
    do {
        TrustedAdvisorCheckResult result = getFreshTACheckResult(checkId);
        if (checkResultStatus != null && !checkResultStatus.equals(result.getStatus())) {
            break;
        }
        checkResultStatus = result.getStatus();
        // The rule refresh has completed, but due to throttling rules the checks may not be refreshed again
        // for a short period of time.
        // Since we only submitted one checkId to getTARefreshStatus, just retrieve the only element in the list.
        TrustedAdvisorCheckRefreshStatus refreshStatus = getTARefreshStatus(checkId).get(0);
        Thread.sleep(refreshStatus.getMillisUntilNextRefreshable());
    } while(true);
    // Signal that a TA check has changed check result status here.
}
```

## Request a Trusted Advisor check result<a name="requestcheck"></a>

After you select the check for the detailed results that you want, you submit a request by using the `[DescribeTrustedAdvisorCheckResult](https://docs.aws.amazon.com/awssupport/latest/APIReference/API_DescribeTrustedAdvisorCheckResult.html)` action\.

The following Java code snippet uses the `DescribeTrustedAdvisorChecksResult` instance referenced by the variable `result`, which was obtained in the preceding code snippet\. Rather than defining a check interactively through a user interface, After you submit the request to run the snippet submits a request for the first check in the list to be run by specifying an index value of 0 in each `result.getChecks().get(0)` call\. Next, the code defines an instance of `DescribeTrustedAdvisorCheckResultRequest`, which it passes to an instance of `DescribeTrustedAdvisorCheckResultResult` called `checkResult`\. You can use the member structures of this data type to view the results of the check\.

```
// Request a Trusted Advisor Check Result
public static TrustedAdvisorCheckResult getTACheckResult(final String checkId) {
    DescribeTrustedAdvisorCheckResultRequest request = new DescribeTrustedAdvisorCheckResultRequest()
            // Possible language parameters: "en" (English), "ja" (Japanese), "fr" (French), "zh" (Chinese)
            .withLanguage("en")
            .withCheckId(checkId);
    DescribeTrustedAdvisorCheckResultResult requestResult = createClient().describeTrustedAdvisorCheckResult(request);
    return requestResult.getResult();
}
```

**Note:** Requesting a Trusted Advisor Check Result doesn't generate updated results data\.

## Print details of a Trusted Advisor check<a name="printdetails"></a>

The following Java code snippet iterates over the `DescribeTrustedAdvisorCheckResultResult` instance returned in the previous section to get a list of resources flagged by the Trusted Advisor check\.

```
// Print ResourceIds for flagged resources. 
for (TrustedAdvisorResourceDetail flaggedResource : 
    result1.getResult().getFlaggedResources())
{
    System.out.println(
        "The resource for this ResourceID has been flagged: " + 
        flaggedResource.getResourceId());
}
```