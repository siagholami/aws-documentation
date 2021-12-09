--------

--------

# Adding questions and answers<a name="in-creating-faq"></a>

You add questions and answers \(FAQs\) to your index using the console or the [CreateFaq](API_CreateFaq.md) operation\. The data for the FAQ comes from a comma\-separated values \(csv\) document stored in an Amazon S3 bucket\. The file contains a list of questions, answers, and optionally the URI of a document that contains more information\. You can provide one or more questions for each answer\. 

The following is a csv file that provides answers to questions about the height of buildings in Seattle\.

```
What is the height of the Space Needle?, 605 feet, https://www.spaceneedle.com/
How tall is the Space Needle?, 605 feet, https://www.spaceneedle.com/
What is the height of the Smith Tower?, 484 feet, https://www.smithtower.com
How tall is the Smith Tower, 484 feet, https://www.smithtower.com/
```

Once you store your FAQ input file in an Amazon S3 bucket, you use the console or the `CreateFaq` operation to put the questions and answers into your index\. You must provide an IAM role that has access to the bucket containing your source files\. You specify the role in the console or in the `RoleArn` parameter\. The following is a program that adds an FAQ file to an index\.

------
#### [ Python ]

```
import boto3


kendra = boto3.client('kendra')

index_id = '${indexId}'
role_arn = 'arn:aws:iam::${accountId}:role/${roleName}'

faq_path = {
    'Bucket': '${bucketName}',
    'Key': 'SeattleBuildings.csv'
}

response = kendra.create_faq(
    S3Path =  faq_path,
    Name = 'SeattleBuildings',
    IndexId = index_id,
    RoleArn = role_arn
)

print(response)
```

------
#### [ Java ]

```
package com.amazonaws.kendra;

import software.amazon.awssdk.services.kendra.KendraClient;
import software.amazon.awssdk.services.kendra.model.CreateFaqRequest;
import software.amazon.awssdk.services.kendra.model.CreateFaqResponse;
import software.amazon.awssdk.services.kendra.model.S3Path;

public class AddFaqExample {
    public static void main(String[] args) {
        KendraClient kendra = KendraClient.builder().build();

        String indexId = "yourIndexId";
        String roleArn = "your role for accessing S3 files";

        CreateFaqRequest createFaqRequest = CreateFaqRequest
            .builder()
            .indexId(indexId)
            .name("SeattleBuildings")
            .roleArn(roleArn)
            .s3Path(
                S3Path
                    .builder()
                    .bucket("an-aws-kendra-test-bucket")
                    .key("SeattleBuildings.csv")
                    .build())
            .build();

        CreateFaqResponse response = kendra.createFaq(createFaqRequest);

        System.out.println(String.format("The result of creating FAQ: %s", response));

    }
}
```

------