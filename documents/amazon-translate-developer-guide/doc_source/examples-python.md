# Translating Text Using the AWS SDK for Python \(Boto\)<a name="examples-python"></a>

The following example demonstrates using the [TranslateText](API_TranslateText.md) operation in Python\. To run it, you must first install Amazon Translate via the AWS CLI\. For instructions, see [Step 2: Set Up the AWS Command Line Interface \(AWS CLI\)](setup-awscli.md)\.

```
import boto3

translate = boto3.client(service_name='translate', region_name='region', use_ssl=True)

result = translate.translate_text(Text="Hello, World", 
            SourceLanguageCode="en", TargetLanguageCode="de")
print('TranslatedText: ' + result.get('TranslatedText'))
print('SourceLanguageCode: ' + result.get('SourceLanguageCode'))
print('TargetLanguageCode: ' + result.get('TargetLanguageCode'))
```

For a list of supported language codes, see [Supported Languages and Language Codes](what-is.md#what-is-languages)

**Custom Terminology**

Another example, this one demonstrating using the Custom Terminology operations in Python:

```
    #!/usr/bin/env python
    # -*- coding: utf-8 -*-
     
    import boto3
     
    translate = boto3.client(service_name='translate')
     
    # The terminology file 'my-first-terminology.csv' has the following contents:
    '''
    en,fr
    Amazon Family,Amazon Famille
    '''
     
    # Read the terminology from a local file
    with open('/tmp/my-first-terminology.csv', 'rb') as f:
        data = f.read()
     
    file_data = bytearray(data)
     
    print("Importing the terminology into Amazon Translate...")
    response = translate.import_terminology(Name='my-first-terminology', MergeStrategy='OVERWRITE', TerminologyData={"File": file_data, "Format": 'CSV'})
    print("Terminology imported: "),
    print(response.get('TerminologyProperties'))
    print("\n")
     
    print("Getting the imported terminology...")
    response = translate.get_terminology(Name='my-first-terminology', TerminologyDataFormat='CSV')
    print("Received terminology: "),
    print(response.get('TerminologyProperties'))
    print("The terminology data file can be downloaded here: " + response.get('TerminologyDataLocation').get('Location'))
    print("\n")
     
    print("Listing the first 10 terminologies for the account...")
    response = translate.list_terminologies(MaxResults=10)
    print("Received terminologies: "),
    print(response.get('TerminologyPropertiesList'))
    print("\n")
     
    print("Translating 'Amazon Family' from English to French with no terminology...")
    response = translate.translate_text(Text="Amazon Family", SourceLanguageCode="en", TargetLanguageCode="fr")
    print("Translated text: " + response.get('TranslatedText'))
    print("\n")
     
    print("Translating 'Amazon Family' from English to French with the 'my-first-terminology' terminology...")
    response = translate.translate_text(Text="Amazon Family", TerminologyNames=["my-first-terminology"], SourceLanguageCode="en", TargetLanguageCode="fr")
    print("Translated text: " + response.get('TranslatedText'))
    print("\n")
     
    # The terminology file 'my-updated-terminology.csv' has the following contents:
    '''
    en,fr
    Amazon Family,Amazon Famille
    Prime Video, Prime Video
    '''
     
    # Read the terminology from a local file
    with open('/tmp/my-updated-terminology.csv', 'rb') as f:
        data = f.read()
     
    file_data = bytearray(data)
     
    print("Updating the imported terminology in Amazon Translate...")
    response = translate.import_terminology(Name='my-first-terminology', MergeStrategy='OVERWRITE', TerminologyData={"File": file_data, "Format": 'CSV'})
    print("Terminology updated: "),
    print(response.get('TerminologyProperties'))
    print("\n")
     
    print("Translating 'Prime Video' from English to French with no terminology...")
    response = translate.translate_text(Text="Prime Video", SourceLanguageCode="en", TargetLanguageCode="fr")
    print("Translated text: " + response.get('TranslatedText'))
    print("\n")
     
    print("Translating 'Prime Video' from English to French with the 'my-first-terminology' terminology...")
    response = translate.translate_text(Text="Prime Video", TerminologyNames=["my-first-terminology"], SourceLanguageCode="en", TargetLanguageCode="fr")
    print("Translated text: " + response.get('TranslatedText'))
    print("\n")
     
    print("Cleaning up by deleting 'my-first-terminology'...")
    translate.delete_terminology(Name="my-first-terminology")
    print("Terminology deleted.")
```