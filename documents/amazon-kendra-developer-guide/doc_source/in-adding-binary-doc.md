--------

--------

# Adding documents with the API<a name="in-adding-binary-doc"></a>

The following example adds text to an index by calling the [BatchPutDocument](API_BatchPutDocument.md) operation\.

You can use the `BatchPutDocument` operation to add documents in the following formats:
+ DOC
+ HTML
+ PDF
+ Plain text
+ PPT

Files added to the index must be in a UTF\-8 encoded byte stream\. The following example adds UTF\-8 encoded text to the index\.

------
#### [ Python ]

```
import boto3

kendra = boto3.client('kendra')

index_id = '${indexID}'

title = 'Information about Amazon.com'
text = 'Amazon.com is an online retailer.'

document = {
    "Id": "1",
    "Blob": text,
    "ContentType": "PLAIN_TEXT",
    "Title": title
}

documents = [
    document
]

result = kendra.batch_put_document(
    IndexId = index_id,
    Documents = documents
)

print(result)
```

------
#### [ Java ]

```
package com.amazonaws.kendra;

import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.kendra.KendraClient;
import software.amazon.awssdk.services.kendra.model.BatchPutDocumentRequest;
import software.amazon.awssdk.services.kendra.model.BatchPutDocumentResponse;
import software.amazon.awssdk.services.kendra.model.ContentType;
import software.amazon.awssdk.services.kendra.model.Document;

public class AddDocumentsViaAPIExample {
    public static void main(String[] args) {
        KendraClient kendra = KendraClient.builder().build();

        String indexId = "yourIndexId";

        Document testDoc = Document
            .builder()
            .title("The title of your document")
            .id("a_doc_id")
            .blob(SdkBytes.fromUtf8String("your text content"))
            .contentType(ContentType.PLAIN_TEXT)
            .build();

        BatchPutDocumentRequest batchPutDocumentRequest = BatchPutDocumentRequest
            .builder()
            .indexId(indexId)
            .documents(testDoc)
            .build();

        BatchPutDocumentResponse result = kendra.batchPutDocument(batchPutDocumentRequest);

        System.out.println(String.format("BatchPutDocument Result: %s", result));
    }
}
```

------