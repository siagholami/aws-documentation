# Upload a document<a name="upload-documents"></a>

Use the following procedure to upload a document to Amazon WorkDocs\.

**To upload a document**

1. Create an instance of `AmazonWorkDocsClient` as follows:

   If you are using IAM user credentials, refer to [Connect to Amazon WorkDocs with IAM user credentials and query for users](connect-workdocs-iam.md)\. If you are assuming an IAM role, refer to [Connect to Amazon WorkDocs by assuming a role and browse a user’s root folder](connect-workdocs-role.md) for more details\.

   ```
   AWSCredentials longTermCredentials =
     new BasicAWSCredentials("accessKey", "secretKey");
   AWSStaticCredentialsProvider staticCredentialProvider =
     new AWSStaticCredentialsProvider(longTermCredentials);
   
   // Use the region specific to your WorkDocs site.
   AmazonWorkDocs amazonWorkDocsClient =
     AmazonWorkDocsClient.builder().withCredentials(staticCredentialProvider)
       .withRegion(Regions.US_WEST_2).build();
   ```

1. Get the signed URL for the upload as follows:

   ```
   InitiateDocumentVersionUploadRequest request = new InitiateDocumentVersionUploadRequest();
   request.setParentFolderId("parent-folder-id");
   request.setName("my-document-name");
   request.setContentType("application/octet-stream");
   InitiateDocumentVersionUploadResult result = amazonWorkDocsClient.initiateDocumentVersionUpload(request);
   UploadMetadata uploadMetadata = result.getUploadMetadata();
   String documentId = result.getMetadata().getId();
   String documentVersionId = result.getMetadata().getLatestVersionMetadata().getId();
   String uploadUrl = uploadMetadata.getUploadUrl();
   ```

1. Upload the document using the signed URL as follows:

   ```
   URL url = new URL(uploadUrl);
   HttpURLConnection connection = (HttpURLConnection) url.openConnection();
   connection.setDoOutput(true);
   connection.setRequestMethod("PUT");
   // Content-Type supplied here should match with the Content-Type set 
   // in the InitiateDocumentVersionUpload request.
   connection.setRequestProperty("Content-Type","application/octet-stream");
   connection.setRequestProperty("x-amz-server-side-encryption", "AES256");
   File file = new File("/path/to/file.txt");
   FileInputStream fileInputStream = new FileInputStream(file);
   OutputStream outputStream = connection.getOutputStream();
   com.amazonaws.util.IOUtils.copy(fileInputStream, outputStream);
   connection.getResponseCode();
   ```

1. Complete the upload process by changing the document status to `ACTIVE` as follows:

   ```
   UpdateDocumentVersionRequest request = new UpdateDocumentVersionRequest();
   request.setDocumentId("document-id");
   request.setVersionId("document-version-id");
   request.setVersionStatus(DocumentVersionStatus.ACTIVE);
   amazonWorkDocsClient.updateDocumentVersion(request);
   ```