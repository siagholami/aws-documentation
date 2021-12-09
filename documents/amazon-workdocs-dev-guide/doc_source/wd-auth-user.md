# Authentication and access control for user applications<a name="wd-auth-user"></a>

Amazon WorkDocs user level applications are registered and managed through the Amazon WorkDocs console\. Developers should register their applications on the `My Applications` page on the Amazon WorkDocs console which will provide unique IDs for each application\. During registration, developers should specify redirect URIs where they will receive access tokens as well as application scopes\.

Currently, applications can only access Amazon WorkDocs sites within the same AWS account where they are registered\.

**Topics**
+ [Create an application](#wd-app-create-app)
+ [Application scopes](#wd-app-scopes)
+ [Authorization](#wd-authorization)
+ [Invoking Amazon WorkDocs APIs](#wd-auth-invoke)

## Create an application<a name="wd-app-create-app"></a>

As an Amazon WorkDocs administrator, create your application using the following steps\.

**To create an application**

1. Open the Amazon WorkDocs console at [https://console\.aws\.amazon\.com/zocalo/](https://console.aws.amazon.com/zocalo/)\.

1. Choose **My Applications**, **Create an Application**\.

1. Enter the following values:  
**Application Name**  
Name for the application\.  
**Email**  
Email address to associate with the application\.  
**Application Description**  
Description for the application\.  
**Redirect URIs**  
The location that you want Amazon WorkDocs to redirect traffic to\.  
**Application Scopes**  
The scope, either read or write, that you wish your application to have\. For more details, see [Application scopes](#wd-app-scopes)\.

1. Choose **Create**\.

## Application scopes<a name="wd-app-scopes"></a>

Amazon WorkDocs supports the following application scopes:
+ Content Read \(`workdocs.content.read`\), which gives your application access to the following Amazon WorkDocs APIs:
  + Get\*
  + Describe\*
+ Content Write \(`workdocs.content.write`\), which gives your application access to the following Amazon WorkDocs APIs:
  + Create\*
  + Update\*
  + Delete\*
  + Initiate\*
  + Abort\*
  + Add\*
  + Remove\*

## Authorization<a name="wd-authorization"></a>

After application registration is complete, an application can request authorization on behalf of any Amazon WorkDocs user\. To do this, the application should visit the Amazon WorkDocs OAuth endpoint, `https://auth.amazonworkdocs.com/oauth`, and provide the following query parameters:
+ \[Required\] `app_id`—Application ID generated when an application is registered\.
+ \[Required\] `auth_type`—The OAuth type for the request\. Supported value is `ImplicitGrant`\.
+ \[Required\] `redirect_uri`—The redirect URI registered for an application to receive an access token\.
+ \[Optional\] `scopes`—A comma\-deliminated list of scopes\. If not specified, the list of scopes selected during registration will be used\.
+ \[Optional\] `state`—A string which is returned along with an access token\.

A sample GET request to initiate the OAuth flow to obtain an access token:

```
GET https://auth.amazonworkdocs.com/oauth?app_id=my-app-id&auth_type=ImplicitGrant&redirect_uri=https://myapp.com/callback&scopes=workdocs.content.read&state=xyz
```

The following takes place during the OAuth authorization flow:

1. The application user is prompted to enter the Amazon WorkDocs site name\.

1. The user is redirected to the Amazon WorkDocs authentication page to enter their credentials\.

1. After successful authentication, the user is presented with the consent screen that allows the user to either grant or deny your application the authorization to access Amazon WorkDocs\.

1. After the user chooses `Accept` on the consent screen, their browser is redirected to your application's callback URL along with the access token and region information as query parameters\.

A sample GET request from Amazon WorkDocs:

```
GET https://myapp.com/callback?acessToken=accesstoken&region=us-east-1&state=xyz
```

In addition to the access token, the Amazon WorkDocs OAuth service also returns `region` as a query parameter for the selected Amazon WorkDocs site\. External applications should use the `region` parameter to determine the Amazon WorkDocs service endpoint\.

## Invoking Amazon WorkDocs APIs<a name="wd-auth-invoke"></a>

After obtaining the access token, your application can make API calls to Amazon WorkDocs services\.

A sample curl GET request to obtain the metadata of a document:

```
Curl "https://workdocs.us-east-1.amazonaws.com/api/v1/documents/{document-id}" -H "Accept: application/json" -H "Authentication: Bearer accesstoken"
```

A sample JavaScript function to describe a user's root folders:

```
function printRootFolders(accessToken, siteRegion) {
    var workdocs = new AWS.WorkDocs({region: siteRegion});
    workdocs.makeUnauthenticatedRequest("describeRootFolders", {AuthenticationToken: accessToken}, function (err, folders) {
        if (err) console.log(err);
        else console.log(folders);
    });     
}
```

A sample Java\-based API invocation is described below:

```
AWSCredentialsProvider credentialsProvider = new AWSCredentialsProvider() {
  @Override
  public void refresh() {}

  @Override
  public AWSCredentials getCredentials() {
    new AnonymousAWSCredentials();
  }
};

// Set the correct region obtained during OAuth flow.
workDocs =
    AmazonWorkDocsClient.builder().withCredentials(credentialsProvider)
        .withRegion(Regions.US_EAST_1).build();

DescribeRootFoldersRequest request = new DescribeRootFoldersRequest();
request.setAuthenticationToken("access-token-obtained-through-workdocs-oauth");
DescribeRootFoldersResult result = workDocs.describeRootFolders(request);

for (FolderMetadata folder : result.getFolders()) {
  System.out.printf("Folder name=%s, Id=%s \n", folder.getName(), folder.getId());
}
```