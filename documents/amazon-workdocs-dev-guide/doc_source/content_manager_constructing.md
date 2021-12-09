# Constructing Amazon WorkDocs Content Manager<a name="content_manager_constructing"></a>

Amazon WorkDocs Content Manager can be used for both administrative and user applications\.

For user applications, a developer must construct Amazon WorkDocs Content Manager with anonymous AWS credentials and an authentication token\.

For administrative applications, the Amazon WorkDocs client must be initialized with AWS Identity and Access Management \(IAM\) credentials\. In addition, the authentication token must be omitted in subsequent API calls\.

The following code demonstrates how to initialize Amazon WorkDocs Content Manager for user applications using Java or C\#\.

Java:

```
AWSStaticCredentialsProvider credentialsProvider = new AWSStaticCredentialsProvider(new AnonymousAWSCredentials());

AmazonWorkDocs client = AmazonWorkDocsClient.builder().withCredentials(credentialsProvider).withRegion("region").build();

ContentManager contentManager = ContentManagerBuilder.standard().withWorkDocsClient(client).withAuthenticationToken("token").build();
```

C\#:

```
AmazonWorkDocsClient client = new AmazonWorkDocsClient(new AnonymousAWSCredentials(), "region");
ContentManagerParams params = new ContentManagerParams
{
WorkDocsClient = client,
AuthenticationToken = "token"
};
IContentManager workDocsContentManager = new ContentManager(param);
```
