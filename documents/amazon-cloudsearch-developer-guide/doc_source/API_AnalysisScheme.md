# AnalysisScheme<a name="API_AnalysisScheme"></a>

## Description<a name="API_AnalysisScheme_Description"></a>

Configuration information for an analysis scheme\. Each analysis scheme has a unique name and specifies the language of the text to be processed\. The following options can be configured for an analysis scheme: `Synonyms`, `Stopwords`, `StemmingDictionary`, `JapaneseTokenizationDictionary` and `AlgorithmicStemming`\.

## Contents<a name="API_AnalysisScheme_Contents"></a>

 **AnalysisOptions**   
Synonyms, stopwords, and stemming options for an analysis scheme\. Includes tokenization dictionary for Japanese\.  
Type: [AnalysisOptions](API_AnalysisOptions.md)   
 Required: No 

 **AnalysisSchemeLanguage**   
An [IETF RFC 4646](http://tools.ietf.org/html/rfc4646) language code or `mul` for multiple languages\.  
Type: String  
 Valid Values: `ar | bg | ca | cs | da | de | el | en | es | eu | fa | fi | fr | ga | gl | he | hi | hu | hy | id | it | ja | ko | lv | mul | nl | no | pt | ro | ru | sv | th | tr | zh-Hans | zh-Hant`   
 Required: Yes 

 **AnalysisSchemeName**   
Names must begin with a letter and can contain the following characters: a\-z \(lowercase\), 0\-9, and \_ \(underscore\)\.  
Type: String  
 Length constraints: Minimum length of 1\. Maximum length of 64\.   
 Required: Yes 