# \.NET/C\# Example of Embedding a Dashboard with Amazon QuickSight<a name="embedded-dashboards-example-csharp"></a>

The following example shows the \.NET/C\# code you can use to get the URL to display an embedded dashboard\.

**Example**  

```
var client = new AmazonQuickSightClient(
    AccessKey,
    SecretAccessKey,
    sessionToken,
    Amazon.RegionEndpoint.USEast1);
try
{
    Console.WriteLine(
        client.GetDashboardEmbedUrlAsync(new GetDashboardEmbedUrlRequest
        {
            AwsAccountId = 111122223333,
            DashboardId = "1c1fe111-e2d2-3b30-44ef-a0e111111cde",
            IdentityType = IdentityType.IAM,
            ResetDisabled = true,
            SessionLifetimeInMinutes = 100,
            UndoRedoDisabled = false
        }).Result.EmbedUrl
    );
} catch (Exception ex) {
    Console.WriteLine(ex.Message);
}
```