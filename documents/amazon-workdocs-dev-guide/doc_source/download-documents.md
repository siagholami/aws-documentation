# Download a document<a name="download-documents"></a>

To download a document from Amazon WorkDocs, get a URL for the download as follows, and then use the API actions provided by your development platform to download the file using the URL\.

```
GetDocumentVersionRequest request = new GetDocumentVersionRequest();
request.setDocumentId("document-id");
request.setVersionId("document-version-id");
request.setFields("SOURCE");
GetDocumentVersionResult result = amazonWorkDocsClient.getDocumentVersion(request);
String downloadUrl = result.getMetadata().getSource().get(DocumentSourceType.ORIGINAL.name());
```