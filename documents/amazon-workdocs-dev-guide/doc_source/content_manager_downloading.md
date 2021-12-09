# Downloading a document<a name="content_manager_downloading"></a>

Developers can use Amazon WorkDocs Content Manager to download a specific version or the latest version of a document from Amazon WorkDocs\. The following examples demonstrate how to download a specific version of a document using Java and C\#\.

**Note**  
To download the latest version of a document, do not specify the `VersionId` when constructing the `GetDocumentStream` request\.

Java

```
ContentManager contentManager = ContentManagerBuilder.standard().withWorkDocsClient(client).withAuthenticationToken("auth-token").build();

// Download document.
GetDocumentStreamRequest request = new GetDocumentStreamRequest();
request.setDocumentId("document-id");
request.setVersionId("version-id");

// stream contains the content of the document version.
InputStream stream = contentManager.getDocumentStream(request).getStream();
```

C\#

```
ContentManager contentManager = ContentManagerBuilder.standard().withWorkDocsClient(client).withAuthenticationToken("auth-token").build();

// Download document.
GetDocumentStreamRequest request = new GetDocumentStreamRequest();
request.setDocumentId("document-id");
request.setVersionId("version-id");

// stream contains the content of the document version.
InputStream stream = contentManager.getDocumentStream(request).getStream();
```