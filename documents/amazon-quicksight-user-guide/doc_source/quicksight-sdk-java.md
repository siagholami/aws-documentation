# Amazon QuickSight Java SDK<a name="quicksight-sdk-java"></a>

Use the following procedure to set up a Java app that interacts with Amazon QuickSight\. 

1. To get started, create a Java project in your IDE\.

1. Import the Amazon QuickSight SDK into your new project, for example: `AWSQuickSightJavaClient-1.11.x.jar`

1. Once your IDE indexes the Amazon QuickSight SDK, you should be able to add an import line as follows: 

   ```
   import com.amazonaws.services.quicksight.AmazonQuickSight;
   ```

   If you IDE doesn't recognize this as valid, verify that you imported the SDK\.

1. Like other AWS SDKs, Amazon QuickSight SDK requires external dependencies to perform many of its functions\. You need to download and import those into the same project\. The following dependencies are required:
   + `aws-java-sdk-1.11.402.jar` \(AWS Java SDK and credentials setup\) — See [ Set up the AWS SDK for Java ](https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/setup-install.html) 
   + `commons-logging-1.2.jar` — See [ https://commons\.apache\.org/proper/commons\-logging/download\_logging\.cgi ](https://commons.apache.org/proper/commons-logging/download_logging.cgi) 
   + `jackson-annotations-2.9.6.jar`, `jackson-core-2.9.6.jar`, and `jackson-databind-2.9.6.jar` — See [ http://repo1\.maven\.org/maven2/com/fasterxml/jackson/core/ ](http://repo1.maven.org/maven2/com/fasterxml/jackson/core/) 
   + `httpclient-4.5.6.jar`, `httpcore-4.4.10.jar` — See [ https://hc\.apache\.org/downloads\.cgi ](https://hc.apache.org/downloads.cgi) 
   + `joda-time-2.1.jar` — See [ https://mvnrepository\.com/artifact/joda\-time/joda\-time/2\.1 ](https://mvnrepository.com/artifact/joda-time/joda-time/2.1) 

1. Now, you are ready to create an Amazon QuickSight client\. You can use a default public endpoint that the client can communicate with or you can reference the endpoint explicitly\. There are multiple ways to provide your AWS credentials\. In the following example, we provide a direct, simple approach\. The following client method is used to make all the API calls that follow:

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

1. Now, we can use the above client to list all the users in our Amazon QuickSight account\. 
**Note**  
You have to provide the AWS account ID that you used to subscribe to Amazon QuickSight\. This must match the AWS account ID of the caller’s identity\. Cross\-account calls aren't supported at this time\. Furthermore, the required parameter `namespace` should always be set to *default*\. 

   ```
   getClient().listUsers(new ListUsersRequest()
           .withAwsAccountId("relevant_AWS_account_ID")
           .withNamespace("default"))
           .getUserList().forEach(user -> {
               System.out.println(user.getArn());
           });
   ```

1. To see a list of all possible API operations and the request objects they use, you can **CTRL\-click** on the client object in your IDE in order to view the Amazon QuickSight interface\. Alternatively, find it within the `com.amazonaws.services.quicksight` package in the Amazon QuickSight JavaClient JAR file\.