# Configuring Text Analysis Schemes for Amazon CloudSearch<a name="configuring-analysis-schemes"></a>

Amazon CloudSearch enables you to configure a language\-specific analysis scheme for each `text` and `text-array` field\. An analysis scheme controls how the contents of the field are processed during indexing\. Although the defaults for each language work well in many cases, fine\-tuning the analysis options enables you to optimize the search results based on your knowledge of the data you are searching\. For a list of supported languages, see [Supported Languages](supported-languages.md)\.

An analysis scheme specifies the language of the text to be processed and the following analysis options: 
+ **Algorithmic stemming**—specifies the level of algorithmic stemming to perform\. The available stemming levels vary depending on the language\.
+ **Japanese Tokenization Dictionary**—specifies overrides of the algorithmic tokenization when processing Japanese\. The dictionary specifies how particular sets of characters should be grouped into words\.
+ **Stemming dictionary**—specifies overrides for the results of the algorithmic stemming\. The dictionary maps specific related words to a common root word or stem\.
+ **Stopwords**—specifies words that should be ignored during indexing and searching\.
+ **Synonyms**—specifies words that have the same meaning as words that occur in your data and should produce the same search results\.

During text processing, field values and search terms are converted to lowercase \(case\-folded\), so stopwords, stems, and synonyms are not case\-sensitive\. For more information about how Amazon CloudSearch processes text during indexing and when handling search requests, see [Text Processing in Amazon CloudSearch](text-processing.md)\.

You must specify a language for each analysis scheme and configure an analysis scheme for each `text` and `text-array` field\. When you configure fields through the Amazon CloudSearch console, the analysis scheme defaults to the `_en_default_` analysis scheme\. If you do not specify analysis options for an analysis scheme, Amazon CloudSearch uses the default options for the specified language\. For information about the defaults for each language, see [Language Specific Settings](text-processing.md#text-processing-settings)\.

The easiest way to define analysis schemes is through the **Analysis Schemes** page in the Amazon CloudSearch console\. You must apply an analysis scheme to a field for it to take effect\. You can apply an analysis scheme to a field from the **Indexing Options** page\. You can also define analysis schemes and configure an analysis scheme for each field through the command line tools and AWS SDKs\.

When you apply a new analysis scheme to an index field or modify an analysis scheme that's in use, you must explicitly [rebuild the index](indexing.md) for the changes to be reflected in search results\.

**Topics**
+ [Stemming in Amazon CloudSearch](#word-stemming)
+ [Stopwords in Amazon CloudSearch](#stopwords)
+ [Synonyms in Amazon CloudSearch](#synonyms)
+ [Configuring Analysis Schemes Using the Amazon CloudSearch Console](#configuring-analysis-schemes-console)
+ [Configuring Analysis Schemes Using the AWS CLI](#configuring-analysis-schemes-clt)
+ [Configuring Analysis Schemes Using the AWS SDKs](#configuring-analysis-schemes-sdk)
+ [Indexing Bigrams for Chinese, Japanese, and Korean in Amazon CloudSearch](#processing-cjk-fields)
+ [Customizing Japanese Tokenization in Amazon CloudSearch](#customizing-japanese-tokenization)

## Stemming in Amazon CloudSearch<a name="word-stemming"></a>

Stemming is the process of mapping related words to a common stem\. A stem is typically the root or base word from which variants are derived\. For example, *run* is the stem of *running* and *ran*\. Stemming is performed during indexing as well as at query time\. Stemming reduces the number of terms that are included in the index, and facilitates matches when the search term is a variant of a term that occurs in the content being searched\. For example, if you map the term *running* to the stem *run* and then search for *running*, the request matches documents that contain *run* as well as *running*\. 

 Amazon CloudSearch supports both algorithmic stemming and explicit stemming dictionaries\. You configure algorithmic stemming by specifying the level of stemming that you want to use\. The available levels of algorithmic stemming vary depending on the language:
+ none—disable algorithmic stemming
+ minimal—perform basic stemming by removing plural suffixes
+ light—target the most common noun/adjective inflections and derived suffixes
+ full—aggressively stem inflections and suffixes

In addition to controlling the degree of algorithmic stemming that's performed, you can specify a stemming dictionary that maps specific related words to a common stem\. You specify the dictionary as a JSON object that contains a collection of string:value pairs that map a term to its stem, for example, `{"term1": "stem1", "term2": "stem2", "term3": "stem3"}`\. The stemming dictionary is applied in addition to any algorithmic stemming\. This enables you to override the results of the algorithmic stemming to correct specific cases of overstemming or understemming\. The maximum size of a stemming dictionary is 500 KB\. Stemming dictionary entries must be lowercase\.

You use the `StemmingDictionary` key to define a custom stemming dictionary in an analysis scheme\. Because you pass the dictionary to Amazon CloudSearch as a string, you must escape all double quotes within the string\. For example, the following analysis scheme defines stems for *running* and *jumping*:

```
{
    "AnalysisSchemeName": "myscheme",
    "AnalysisSchemeLanguage": "en",
    "AnalysisOptions": {
        "AlgorithmicStemming": "light",
        "StemmingDictionary": "{\"running\": \"run\",\"jumping\": \"jump\"}"
    }
}
```

If you do not specify the level of algorithmic stemming or a stemming dictionary in your analysis scheme, Amazon CloudSearch uses the default algorithmic stemming level for the specified language\. While stemming can help users find relevant documents that might otherwise be excluded from the search results, overstemming can result in too many matches with questionable relevance\. The default level of algorithmic stemming configured for each language works well for most use cases\. In general, it's best to start with the default and then make adjustments to optimize the relevance of the search results for your use case\. For information about the defaults for each language, see [Language Specific Settings](text-processing.md#text-processing-settings)\.

## Stopwords in Amazon CloudSearch<a name="stopwords"></a>

 Stopwords are words that should typically be ignored both during indexing and at search time because they are either insignificant or so common that including them would result in a massive number of matches\. 

 During indexing, Amazon CloudSearch uses the stopword dictionary when it processes `text` and `text-array` fields\. In most cases, stopwords are not included in the index\. The stopword dictionary is also used to filter search requests\. 

A stopwords dictionary is a JSON array of terms, for example, `["a", "an", "the", "of"]`\. The stopwords dictionary must explicitly list each word that you want to ignore\. Wildcards and regular expressions are not supported\. 

You use the `Stopwords` key to define a custom stopwords dictionary in an analysis scheme\. Because you pass the dictionary to Amazon CloudSearch as a string, you must escape all double quotes within the string\. For example, the following analysis scheme configures the stopwords *a*, *an*, and *the*:

```
{
    "AnalysisSchemeName": "myscheme",
    "AnalysisSchemeLanguage": "en",
    "AnalysisOptions": {
        "Stopwords": "[\"a\",\"an\",\"the\"]"
    }
}
```

If you do not specify a stopwords dictionary in your analysis scheme, Amazon CloudSearch uses the default stopword dictionary for the specified language\. The default stopwords configured for each language work well for most use cases\. In general, it's best to start with the default and then make adjustments to optimize the relevance of the search results for your use case\. For information about the defaults for each language, see [Language Specific Settings](text-processing.md#text-processing-settings)\.

## Synonyms in Amazon CloudSearch<a name="synonyms"></a>

You can configure synonyms for terms that appear in the data that you are searching\. That way, if a user searches for the synonym rather than the indexed term, the results will include documents that contain the indexed term\. For example, you might define custom synonyms to do the following:
+ Map common misspellings to the correct spelling 
+ Define equivalent terms, such as `film` and `movie`
+ Map a general term to a more specific one, such as `fish` and `barracuda`
+ Map multiple words to a single word or vice versa, such as `tool box` and `toolbox`

When you define a synonym, the synonym is added to the index everywhere the base token occurs\. For example, if you define `fish` as a synonym of `barracuda`, the term `fish` is added to every document that contains the term `barracuda`\. Adding a large number of synonyms can increase the size of the index as well as query latency—synonyms increase the number of matches and the more matches, the longer it takes to process the results\. 

The synonym dictionary is used during indexing to configure mappings for terms that occur in text fields\. No synonym processing is done on search requests\. By default, Amazon CloudSearch does not define any synonyms\. 

You can specify synonyms in two ways:
+ As a *conflation group* where each term in the group is considered a synonym of every other term in the group\.
+ As an *alias* for a specific term\. An alias is considered a synonym of the specified term, but the term is not considered a synonym of the alias\. 

A synonym dictionary is specified as a JSON object that defines the synonym groups and aliases\. The `groups` value is an array of arrays, where each sub\-array is a conflation group\. The `aliases` value is an object that contains a collection of string:value pairs where the string specifies a term and the array of values specifies each of the synonyms for that term\. The following example includes both conflation groups and aliases:

```
{
    "groups": [["1st", "first", "one"], ["2nd", "second", "two"]],
    "aliases": { "youth": ["child", "kid", "boy", "girl"], 
                 "adult": ["men", "women"] }
}
```

Both groups and aliases support multiword synonyms\. In the following example, multiword synonyms are used in a conflation group as well as an alias:

```
{
    "groups": [["tool box", "toolbox"], ["band saw", "bandsaw"]],
    "aliases": { "workbench": ["work bench"]}
}
```

You use the `Synonyms` key to define a custom synonym dictionary in an analysis scheme\. Because you pass the dictionary to Amazon CloudSearch as a string, you must escape all double quotes within the string\. For example, the following analysis scheme configures aliases for the term *youth*:

```
{
    "AnalysisSchemeName": "myscheme",
    "AnalysisSchemeLanguage": "en",
    "AnalysisOptions": {
        "Synonyms": "{\"aliases\": {\"youth\": [\"child\",\"kid\"]}}"
    }
}
```

## Configuring Analysis Schemes Using the Amazon CloudSearch Console<a name="configuring-analysis-schemes-console"></a>

You can define analysis schemes from the **Analysis Schemes** pane in the Amazon CloudSearch console\.

**To define an analysis scheme**

1. Sign in to the AWS Management Console and open the Amazon CloudSearch console at [https://console\.aws\.amazon\.com/cloudsearch/home](https://console.aws.amazon.com/cloudsearch/home)\.

1. In the **Navigation** pane, click the name of the domain, and then click the domain's **Analysis Schemes** link\.

1. In the **Analysis Schemes** pane, click **Add Analysis Scheme**\.

1. Specify a name for the analysis scheme, select a language, and configure the scheme's text stopword, stemming, and synonym options\. You can configure individual stopwords, stems, and synonyms, or edit the displayed dictionaries directly\. The dictionaries are formatted in JSON\. Stopwords are specified as an array of strings\. Stems are specified as an object that contains one or more key:value pairs\. Synonym aliases are also specified as a JSON object with one or move key:value pairs, where the alias values are specified as an array of strings\. A synonym group is specified as a JSON array\. \(The synonym dictionary is an array of arrays\.\) 

   If you select Japanese as the language, you also have the option of specifying a custom tokenization dictionary that overrides the default tokenization of specific phrases\. For more information, see [Customizing Japanese Tokenization](#customizing-japanese-tokenization)\.

1. Click **Create** to save your changes\.

**Important**  
To use an analysis scheme, you must apply it to one or more `text` or `text-array` fields and rebuild the index\. You can configure a field's analysis scheme from the **Indexing Options** page\. To rebuild your index, click the **Run Indexing** button\.

## Configuring Analysis Schemes Using the AWS CLI<a name="configuring-analysis-schemes-clt"></a>

You use the `aws cloudsearch define-analysis-scheme` command to define language\-specific text processing options, including stemming options, stopwords, and synonyms\. For information about installing and setting up the AWS CLI, see the [AWS Command Line Interface User Guide](https://docs.aws.amazon.com/cli/latest/userguide/)\. 

You specify an analysis scheme as part of the configuration of each `text` or `text-array` field\. For more information, see [Configuring Index Fields](configuring-index-fields.md)\.

**To define an analysis scheme**
+ Run the `aws cloudsearch define-analysis-scheme` command and specify the `--analysis-scheme` option and a JSON object that contains your analysis options\. The analysis scheme must be valid JSON\. The analysis option key and value pairs must be enclosed in quotes, and all quotes within the option values must be escaped with a backslash\. For the format of the analysis options, see [define\-analysis\-scheme](https://docs.aws.amazon.com/cli/latest/reference/cloudsearch/define-analysis-scheme.html) in the AWS CLI Command Reference\. See [Configuring Analysis Schemes](#configuring-analysis-schemes) for more information about specifying stemming, stopword, and synonym options\.

  If you specify Japanese \(`ja`\) as the language, you also have the option of specifying a custom tokenization dictionary that overrides the default tokenization of specific phrases\. For more information, see [Customizing Japanese Tokenization](#customizing-japanese-tokenization)\.
**Tip**  
The easiest way to configure an analysis scheme with the AWS CLI is to store the analysis scheme in a text file and specify that file as the `--analysis-scheme` value\. This enables you to format the scheme so that it's easier to read\. For example, the following scheme defines an English analysis scheme called `myscheme` that uses light algorithmic stemming and configures two stopwords:  

  ```
  {
      "AnalysisSchemeName": "myscheme",
      "AnalysisSchemeLanguage": "en",
      "AnalysisOptions": {
          "AlgorithmicStemming": "light",
          "Stopwords": "[\"a\", \"the\"]"     
      }
  }
  ```
If you save this scheme in a text file called `myscheme.txt`, you can pass the file in as the value of the `--analysis-scheme` parameter:  

  ```
  aws cloudsearch define-analysis-scheme --region us-east-1 --domain-name movies --analysis-scheme file://myscheme.txt
  ```

**Important**  
To use an analysis scheme, you must apply it to one or more `text` or `text-array` fields and rebuild the index\. You can configure a field's analysis scheme with the `aws cloudsearch define-index-field` command\. To rebuild the index, call `aws cloudsearch index-documents`\.

## Configuring Analysis Schemes Using the AWS SDKs<a name="configuring-analysis-schemes-sdk"></a>

The AWS SDKs \(except the Android and iOS SDKs\) support all of the Amazon CloudSearch actions defined in the Amazon CloudSearch Configuration API, including `[DefineAnalysisScheme](API_DefineAnalysisScheme.md)`\. For more information about installing and using the AWS SDKs, see [AWS Software Development Kits](http://aws.amazon.com/code)\.

**Important**  
To use an analysis scheme, you must apply it to one or more `text` or `text-array` fields and rebuild the index\. You can configure a field's analysis scheme with the define index field method\. To rebuild your index, you use the index documents method\.

## Indexing Bigrams for Chinese, Japanese, and Korean in Amazon CloudSearch<a name="processing-cjk-fields"></a>

Chinese, Japanese, and Korean do not have explicit word boundaries\. Simply indexing individual characters \(unigrams\) can result in matches that aren't very relevant to a search query\. One solution is to index *bigrams*\. A bigram is every sequence of two adjacent characters in a string\. For example, the following example shows bigrams for the string :

While indexing bigrams can improve search result quality, keep in mind that it can significantly increase the size of your index\. 

**To index bigrams for Chinese, Japanese, and Korean**

1. Create a text analysis scheme and set the language to multiple languages \(`mul`\)\.

1. Configure the index field that contains the CJK data to use your multi\-language analysis scheme\. 

When you assign an analysis scheme that sets a field's language to `mul`, Amazon CloudSearch automatically generates bigrams for all Chinese, Japanese, and Korean text within the field\.

For more information about creating and using analysis schemes, see [Configuring Analysis Schemes](#configuring-analysis-schemes)\. 

If you are indexing Japanese content, you might also be interested in using a custom tokenization dictionary with the standard Japanese language processor\. For more information, see [Customizing Japanese Tokenization](#customizing-japanese-tokenization)\.

## Customizing Japanese Tokenization in Amazon CloudSearch<a name="customizing-japanese-tokenization"></a>

If you need more control over how Amazon CloudSearch tokenizes Japanese, you can add a custom Japanese tokenization dictionary to your analysis scheme\. Configuring a custom tokenization dictionary enables you to override how specific entries are tokenized by the standard Japanese language processor\. This can improve search result accuracy in some cases, particularly when you need to index and retrieve domain\-specific phrases\.

A tokenization dictionary is a collection of entries where each entry specifies a set of characters, how the characters should be tokenized, how each token should be pronounced \(readings\), and a part\-of\-speech tag\. You specify the dictionary as an array, and each dictionary entry is an array of strings\. The entries are of the following form:

```
["<text>","<token 1> ... <token n>","<reading 1> ... <reading n>","<part-of-speech tag>"]
```

You must specify a reading for each token and the part\-of\-speech tag for the entry\. See [Japanese Part\-of\-Speech Tags](#ja_part_of_speech_tags) for the part of speech tags that are treated as stopwords\. 

You use the `JapaneseTokenizationDictionary` key to define a custom tokenization dictionary in an analysis scheme\. Because you pass the tokenization dictionary to Amazon CloudSearch as a string, you must escape all double quotes within the string\. For example, the dictionary in the following analysis scheme specifies segmentation overrides for Kanji and Katakana compounds, and a custom reading for a proper name: 

When configuring an analysis scheme with the AWS CLI, you can store the analysis scheme in a text file and specify that file as the `--analysis-scheme` value\. This enables you to format the scheme so that it's easier to read\. For example, if you store the `jascheme` analysis scheme in a file called `jascheme.txt`, you can pass that file in when you call `aws cloudsearch define-analysis-scheme`:

```
aws cloudsearch define-analysis-scheme --region us-east-1 --domain-name
mydomain --analysis-scheme file://jascheme.txt
```

For more information about creating and using analysis schemes, see [Configuring Analysis Schemes](#configuring-analysis-schemes)\. 

### Japanese Part\-of\-Speech Tags in Amazon CloudSearch<a name="ja_part_of_speech_tags"></a>

When you use a custom tokenization dictionary for Japanese, you specify a part\-of\-speech tag for each entry\. If the part\-of\-speech tag matches one of the tags configured as a stop tag, the entry is treated as a stopword\. 

The following table shows the part of speech tags configured as stop tags in Amazon CloudSearch\.


**Stop Tags**  

| Tag | Part\-of\-Speech | Description | 
| --- | --- | --- | 
| Auxiliary\-verb | A verb that adds functional or grammatical meaning to the clause in which it appears\. | 
| Conjunction | Conjunctions that can occur independently\. | 
| Filler | Aizuchi that occurs during a conversation or sounds inserted as filler\. | 
| Non\-verbal | Non\-verbal sound\. | 
| Other\-interjection | Words that are hard to classify as noun\-suffixes or sentence\-final particles\. | 
| Particle\-adnominalizer | The "ni" and "to" that appear following nouns and adverbs\. | 
| Particle\-adnominalizer | The "no" that attaches to nouns and modifies non\-inflectional words\. | 
| Particle\-adverbial | An adverb used to show position, direction of movement, and so on\. | 
| Particle\-adverbial/conjunctive/final |  The particle "ka" when unknown whether it is adverbial, conjunctive, or sentence final\.  | 
| Particle\-case\-compound | Compounds of particles and verbs that mainly behave like case particles\. | 
| Particle\-case\-misc | Case particles\. | 
| Particle\-case\-quote | The "to" that appears after nouns, a person’s speech, quotation marks, expressions of decisions from a meeting, reasons, judgements, conjectures, and so on\. | 
| Particle\-case  | Case particles where the subclassification is undefined\. | 
| Particle\-conjunctive | Conjunctive particles\. | 
| Particle\-coordinate | Coordinate particles\. | 
| Particle\-dependency | Dependency particles\. | 
| Particle\-final | Final particles\. | 
| Particle\-interjective | Particles with interjective grammatical roles\. | 
| Particle\-special | A particle that does not fit into any of the other classifications\. This includes particles that are used in Tanka, Haiku, and other poetry\. | 
| Particle | Unclassified particles\. | 
| Symbol\-close\_bracket | Close bracket: \]\. | 
| Symbol\-comma | Comma: ,\. | 
| Symbol\-misc | A general symbol not in one of the other categories\. | 
| Symbol\-open\_bracket | Open bracket: \[\. | 
| Symbol\-period | Periods and full stops\. | 
| Symbol\-space | Full\-width whitespace\. | 
| Symbol | Unclassified symbols\. | 