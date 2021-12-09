# Using Custom Terminologies<a name="using-ct"></a>

 When using a Custom Terminology when translating text using the [TranslateText](API_TranslateText.md) operation, the process is similar to when you translate text without one\. The difference is that when you call the operation with the Custom Terminology, you also include the optional `TerminologyNames` parameter\. 

For example, if you have the following terminology file called `Amazon_Family.csv` attached to your account:

```
     en,fr
     Amazon Family,Amazon Famille
```

You can use the following to call the Custom Terminology to translate your text using the CLI:

**Note**  
This example is formatted for Unix, Linux, and macOS\. For Windows, replace the backslash \(\\\) Unix continuation character at the end of each line with a caret \(^\)\.

```
aws translate translate-text \
     --region region \
     --source-language-code "en" \
     --target-language-code "fr" \
     --terminology-names "Amazon_Family" \
     --text "Have you ever shopped with Amazon Family?"
```

This uses the selected Custom Terminology to translate this text as "Avez\-vous déjà fait des achats avec Amazon Famille?" instead of the direct \(but undesirable\) translation "Avez\-vous déjà fait des achats avec Famille Amazon?"

Using Python, the same task can be seen with the following:

```
import boto3
     
translate = boto3.client(service_name='translate')
  
print("Translating 'Have you ever shopped with Amazon Family?' from English to French with the 'Amazon_Family' custom terminology...")
response = translate.translate_text(Text="Have you ever shopped with Amazon Family?", TerminologyNames=["Amazon_Family"], SourceLanguageCode="en", TargetLanguageCode="fr")
print("Translated text: " + response.get('TranslatedText'))
print("\n")
```

For more information on using the Amazon Translate operations with Custom Terminologies, see [Actions](API_Operations.md)\. 