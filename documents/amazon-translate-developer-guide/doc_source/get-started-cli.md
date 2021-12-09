# Step 4: Getting Started \(AWS CLI\)<a name="get-started-cli"></a>

In the following exercises, you use the AWS command line interface \(AWS CLI\) to translate text\. To complete these exercises, you need to be familiar with the CLI and have a text editor\. For more information, see [Step 2: Set Up the AWS Command Line Interface \(AWS CLI\)](setup-awscli.md)\.

There are two ways to use the CLI to translate text with Amazon Translate\. For short text, you can provide the text that you want to translate as a parameter of the `translate-text` command\. For longer text, you can provide the source language, target language, and text in a JSON file\.

To use Amazon Translate from the command line, you need to know the endpoint and region for the service\. For a list of available endpoints and regions, see [Amazon Translate Regions and Endpoints](https://docs.aws.amazon.com/general/latest/gr/rande.html#translate_region) in the *AWS General Reference*\.

## Translate Text Using the Command Line<a name="cli-command-line"></a>

The following example shows how to use the `translate-text` operation from the command line to translate text\. The example is formatted for Unix, Linux, and macOS\. For Windows, replace the backslash \(\\\) Unix continuation character at the end of each line with a caret \(^\)\. At the command line, type the following\. 

```
aws translate translate-text \
            --region region \
            --source-language-code "en" \
            --target-language-code "es" \
            --text "hello, world"
```

The response is the following JSON:

```
{
    "TargetLanguageCode": "es",
    "Text": "Hola, mundo",
    "SourceLanguageCode": "en"
}
```

## Translate Text Using a JSON File<a name="cli-json-file"></a>

This example shows how to use the `translate-text` operation to translate a longer text block from a JSON file\. You can specify the source and target language on the command line, but in this example, you specify them in the JSON file\.

**Note**  
The JSON file is formatted for readability\. Reformat the `"Text"` field to remove line breaks\.  
The example is formatted for Unix, Linux, and macOS\. For Windows, replace the backslash \(\\\) Unix continuation character at the end of each line with a caret \(^\)\.

**To translate text using a JSON file**

1. Copy the following text into a JSON file called `translate.json`:

   ```
   {
       "Text": "Amazon Translate translates documents between languages in 
       real time. It uses advanced machine learning technologies 
       to provide high-quality real-time translation. Use it to 
       translate documents or to build applications that work in 
       multiple languages.", 
       "SourceLanguageCode": "en", 
       "TargetLanguageCode": "fr"
   }
   ```

1. In the AWS CLI, run the following command:

   ```
   aws translate translate-text \
               --region region \
               --cli-input-json file://translate.json > translated.json
   ```

   The command outputs a JSON file that contains the following JSON text:

   ```
   {
       "TargetLanguageCode": "fr", 
       "Text": "Amazon Translate traduit les documents entre 
       les langue en temps réel. Il utilise des technologies 
       avancées d'apprentissage de la machine pour fournir 
       une traduction en temps réel de haute qualité. Utilisez-le 
       pour traduire des documents ou pour créer des applications 
       qui fonctionnent en plusieurs langues.", 
       "SourceLanguageCode": "en"
   }
   ```

## Next Step<a name="getting-started-next-examples"></a>

To see other ways to use Amazon Translate see [Examples](examples.md)\.