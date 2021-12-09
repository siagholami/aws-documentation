# Java Example of Embedding a Dashboard with Amazon QuickSight<a name="embedded-dashboards-example-java"></a>

The following example shows the Java code you can use to get the URL to display an embedded dashboard\.

**Example**  

```
final String dashboardId = "1c1fe111-e2d2-3b30-44ef-a0e111111cde";
final String awsAccountId = "111122223333";
final GetDashboardEmbedUrlResult dashboardEmbedUrlResult =
        client.getDashboardEmbedUrl(new GetDashboardEmbedUrlRequest()
            .withDashboardId(dashboardId)
            .withAwsAccountId(awsAccountId)
            .withIdentityType(IdentityType.IAM)
            .withResetDisabled(true)
            .withSessionLifetimeInMinutes(100l)
            .withUndoRedoDisabled(false)
);
```

The following example shows a sample response\.

**Example**  

```
//The URL returned is over 900 characters. For this example, we've shortened the string for readability and added ellipsis to indicate that it's incomplete.
https://spaceneedle-alpha.amazon.com/embed/d11facd655b645878350470a1895d9fc…
System.out.println(dashboardEmbedUrlResult.getEmbedUrl());
```

The following example shows the Java code you can use to create the client:

**Example**  

```
	private static AmazonQuickSight getClient() {
	
	final AWSCredentialsProvider credsProvider = new AWSCredentialsProvider() {
	@Override
	public AWSCredentials getCredentials() {
	// provide actual IAM access key and secret key here
	return new BasicAWSCredentials("access-key", "secret-key");
	}
	
	@Override
	public void refresh() {}
	};
	
	return AmazonQuickSightClientBuilder
	.standard()
	.withRegion(Regions.US_EAST_1.getName())
	.withCredentials(credsProvider)
	.build();
	}
```