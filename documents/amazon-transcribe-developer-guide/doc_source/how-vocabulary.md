# Custom Vocabularies<a name="how-vocabulary"></a>

**Topics**
+ [Create a Custom Vocabulary Using a List](#create-vocabulary-list)
+ [Create a Custom Vocabulary Using a Table](#create-vocabulary-table)
+ [Character Sets for Custom Vocabularies](#charsets)

You can give Amazon Transcribe more information about how to process speech in your input file by creating a custom vocabulary\. A *custom vocabulary* is a list of specific words that you want Amazon Transcribe to recognize in your audio input\. These are generally domain\-specific words and phrases, words that Amazon Transcribe isn't recognizing, or proper nouns\.

Custom vocabularies work best when used to target specific words or phrases\. We recommend that you create separate small vocabularies tailored to specific audio recordings instead of creating a single vocabulary with many terms to use for all of your recordings\. You can have up to 100 vocabularies in your account\. The size limit for a custom vocabulary is 50 Kb\.

You specify the custom vocabulary in a text file\. You can specify either a list of words in the vocabulary, or a four\-column table that gives you more control over the input and output of the words in the custom vocabulary\.

For more information about creating a custom vocabulary, see [Create a Custom Vocabulary Using a List](#create-vocabulary-list) and [Create a Custom Vocabulary Using a Table](#create-vocabulary-table)\.

To create a custom vocabulary, use the [CreateVocabulary](API_CreateVocabulary.md) operation or the [Amazon Transcribe console](https://console.aws.amazon.com/transcribe/)\. After you submit the `CreateVocabulary` request, Amazon Transcribe processes the vocabulary\. To see the processing status of the vocabulary, use the console or the [GetVocabulary](API_GetVocabulary.md) operation\.

**Note**  
If you are uploading the custom vocabulary using the Amazon Transcribe console, you must use vocabulary list instead of a vocabulary table\. To use the console to create a custom vocabulary using a vocabulary table, the source file must be in an Amazon S3 bucket\.

To use the custom vocabulary, set the `VocabularyName` field of the `Settings` field when you call the [StartTranscriptionJob](API_StartTranscriptionJob.md) operation or choose the vocabulary in the console when you create the transcription job\. 

## Create a Custom Vocabulary Using a List<a name="create-vocabulary-list"></a>

You can create a custom vocabulary using a list of words or phrases in a text file\. You can place each word on its own line, or you can put multiple words on a single line, separating the words or phrases from each other with a comma\. 

Each entry must contain:
+ Fewer than 256 characters, including hyphens
+ Only characters from the allowed character set

For valid character sets, see [Character Sets for Custom Vocabularies](#charsets)\.

If an entry is the list is a phrase, separate the words of the phrase with a hyphen\. For example, if the phrase is **Los Angeles**, you would enter it in the file as **Los\-Angeles**\.

Enter acronyms or other words whose letters should be pronounced individually as single letters separated by dots, such as **A\.B\.C\.** or **F\.B\.I\.**\. To enter the plural form of an acronym, such as "ABCs", separate the "s" from the acronym with a hyphen: **A\.B\.C\.\-s**\. You can use either upper or lower case letters to enter an acronym\. Acronyms are supported in the following languages:
+ Dutch
+ All English variants
+ All French variants
+ All German variants
+ Hindi
+ Indonesian
+ Italian
+ Malay
+ All Portuguese variants
+ All Spanish variants
+ Turkish

The following example shows an input file with the vocabulary words and phrases on separate lines:

```
Los-Angeles
F.B.I.
Etienne
```

The following example shows an input file with the vocabulary words and phrases on a single line, separated by commas:

```
Los-Angeles,F.B.I.,Etienne
```

## Create a Custom Vocabulary Using a Table<a name="create-vocabulary-table"></a>

You can create a custom vocabulary by creating a table in a text file\. Each row in the table is a word or phrase followed by the optional `IPA`, `SoundsLike`, and `DisplayAs` fields\. Each field must contain:
+ Fewer than 256 characters, including hyphens
+ Only characters from the allowed character set

For valid character sets, see [Character Sets for Custom Vocabularies](#charsets)

Place each word or phrase in your text file on a separate line\. Separate the fields with TAB characters\. Save the file with the extension `.txt` in an Amazon S3 bucket in the same region that you are calling the API\. 

The following examples are input files in text format\. The examples use spaces to align the columns\. Your input files should use TAB characters to separate the columns\. Include spaces only in the `IPA` and `DisplayAs` columns\. If you copy these examples, remove the extra spaces between columns and replace "\[TAB\]" with a TAB character\.

```
Phrase     [TAB]IPA       [TAB]SoundsLike[TAB]DisplayAs
Los-Angeles[TAB]          [TAB]          [TAB]Los Angeles
F.B.I.     [TAB]?? f b i a??[TAB]          [TAB]FBI
Etienne    [TAB]          [TAB]eh-tee-en [TAB]
```

Columns can be entered in any order\. The following are also valid structures for the custom vocabulary input file\.

```
Phrase     [TAB]SoundsLike[TAB]IPA       [TAB]DisplayAs
Los-Angeles[TAB]          [TAB]          [TAB]Los Angeles
F.B.I      [TAB]          [TAB]?? f b i a??[TAB]FBI
Etienne    [TAB]eh-tee-en [TAB]          [TAB]
```

```
DisplayAs  [TAB]SoundsLike[TAB]IPA       [TAB]Phrase
Los Angeles[TAB]          [TAB]          [TAB]Los-Angeles
FBI        [TAB]          [TAB]?? f b i a??[TAB]F.B.I.
           [TAB]eh-tee-en [TAB]          [TAB]Etienne
```
+ **Phrase** ??? The word or phrase that should be recognized\. 

  If the entry is a phrase, separate the words with a hyphen \(\-\)\. For example, you type **Los Angeles** as **Los\-Angeles**\.

  Enter acronyms or other words whose letters should be pronounced individually as single letters followed by dots, such **A\.B\.C\.** or **F\.B\.I\.**\. To enter the plural form of an acronym, such as "ABCs," separate the "s" from the acronym with a hyphen: "**A\.B\.C\.\-s**"\. You can use either upper\- or lower\-case letters to enter an acronym\. For a list of languages that support acronyms, see [Create a Custom Vocabulary Using a List](#create-vocabulary-list)\.

  The `Phrase` field is required\. You can use any of the allowed characters for the input language\. For the list of allowed characters, see the individual languages\. If you do not specify the `DisplayAs` field, Amazon Transcribe uses the contents of the `Phrase` field in the output file\.
+ **IPA** ??? To specify the pronunciation of your word or phrase, you can include characters in the [International Phonetic Alphabet \(IPA\)](https://en.wikipedia.org/wiki/International_Phonetic_Alphabet) in this field\. The `IPA` field can't contain leading or trailing spaces, and you must use a single space to separate each phoneme in the input\. For example, in English you would enter the phrase **Los\-Angeles** as **l??????s??????n??????????l??????s**\. You would enter the phrase **F\.B\.I\.** as **????f??b??i??a??**\.

  If you don't specify the contents of the `IPA` field, you must include a blank `IPA` field\. If you specify the `IPA` field, you can't specify the `SoundsLike` field\.

  For a list of allowed IPA characters for a specific language, see the table for individual languages\.
+ **SoundsLike** ??? You can break a word or phrase down into smaller pieces and provide a pronunciation for each piece using the standard orthography of the language to mimic the way that the word sounds\. For example, in English you can provide pronunciation hints for the phrase **Los\-Angeles** like this: **loss\-ann\-gel\-es**\. The hint for the word **Etienne** would look like this: **eh\-tee\-en**\. You separate each part of the hint with a hyphen \(\-\)\. 

  If you don't specify the `SoundsLike` field you must include a blank `SoundsLike` field\. If you specify the `SoundsLike` field you can't specify the `IPA` field\.

  You can use any of the allowed characters for the input language\. For the list of allowed characters, see the individual languages\.
+ **DisplayAs** ??? Defines the how the word or phrase looks when it's output\. For example, if the word or phrase is **Los\-Angeles**, you can specify the display form as "Los Angeles" so that the hyphen is not present in the output\.

  If you don't specify the `DisplayAs` field, Amazon Transcribe uses the `Phrase` field from the input file in the output\.

  You can use any UTF\-8 character in the `DisplayAs` field\.

## Character Sets for Custom Vocabularies<a name="charsets"></a>

 Amazon Transcribe limits the characters that you can use to create custom vocabularies\. You can use the following character sets for each language\.

**Topics**
+ [Arabic Character Set](#char-arabic)
+ [Chinese Character Set](#char-chinese)
+ [Dutch Character Set](#char-dutch)
+ [English Character Set](#char-english)
+ [Farsi Character Set](#char-farsi)
+ [French Character Set](#char-french)
+ [German Character Set](#char-german)
+ [Hebrew Character Set](#char-hebrew)
+ [Hindi Character Set](#char-hindi)
+ [Indonesian Character Set](#char-indonesian)
+ [Italian Character Set](#char-italian)
+ [Japanese Character Set](#char-japanese)
+ [Korean Character Set](#char-korean)
+ [Malay Character Set](#char-malay)
+ [Portuguese Character Set](#char-portuguese)
+ [Russian Character Set](#char-russian)
+ [Spanish Character Set](#char-spanish)
+ [Tamil Character Set](#char-tamil)
+ [Telugu Character Set](#char-telugu)
+ [Turkish Character Set](#char-turkish)

### Arabic Character Set<a name="char-arabic"></a>

For Arabic custom vocabularies, you can use the following Unicode characters in the `Phrase` and `SoundsLike` fields\. You can also use the hypen \(\-\) character to separate words\.


| Character | Code | Character | Code | 
| --- | --- | --- | --- | 
| ?? | 0621 | ?? | 0633 | 
| ?? | 0622 | ?? | 0634 | 
| ?? | 0623 | ?? | 0635 | 
| ?? | 0624 | ?? | 0636 | 
| ?? | 0625 | ?? | 0637 | 
| ?? | 0626 | ?? | 0638 | 
| ?? | 0627 | ?? | 0639 | 
| ?? | 0628 | ?? | 063A | 
| ?? | 0629 | ?? | 0641 | 
| ?? | 062A | ?? | 0642 | 
| ?? | 062B | ?? | 0643 | 
| ?? | 062C | ?? | 0644 | 
| ?? | 062D | ?? | 0645 | 
| ?? | 062E | ?? | 0646 | 
| ?? | 062F | ?? | 0647 | 
| ?? | 0630 | ?? | 0648 | 
| ?? | 0631 | ?? | 0649 | 
| ?? | 0632 | ?? | 064A | 

You can use the following International Phonetic Alphabet characters in the `IPA` field of the vocabulary input file:


| Character | Code | Character | Code | 
| --- | --- | --- | --- | 
| a | 0061 | t?? | 0074 02E4 | 
| a?? | 0061 02D0 | u | 0075 | 
| b | 0062 | u?? | 0075 02D0 | 
| d | 0064 | v | 0076 | 
| d?? | 0064 02E4 | w | 0077 | 
| f | 0066 | x | 0078 | 
| h | 0068 | z | 007A | 
| i | 0069 | z?? | 007A 02E4 | 
| i?? | 0069 02D0 | ?? | 00F0 | 
| j | 006A | ???? | 00F0 02E4 | 
| k | 006B | ?? | 0127 | 
| l | 006C | ?? | 0263 | 
| m | 006D | ?? | 026A | 
| n | 006E | ?? | 026B | 
| p | 0070 | ?? | 0283 | 
| q | 0071 | ?? | 0292 | 
| r | 0072 | ?? | 0294 | 
| s | 0073 | ?? | 0295 | 
| s?? | 0073 02E4 | ?? | 03B8 | 
| t | 0074 | ?? | 03C7 | 

### Chinese Character Set<a name="char-chinese"></a>

 For Chinese custom vocabularies, the `Phrase` field can use any of the characters listed in the following file on GitHub\.
+ [chinese\-character\-set\.txt](https://github.com/awsdocs/amazon-transcribe-developer-guide/blob/master/doc_source/chinese-character-set.txt) 

The `SoundsLike` field can contain the pinyin syllables listed in the following file on GitHub\.
+ [pinyin\-set\.txt](https://github.com/awsdocs/amazon-transcribe-developer-guide/blob/master/doc_source/pinyin-set.txt) 

When you use pinyin syllables in the `SoundsLike` field, separate the syllables with a hyphen \(\-\)\.

Amazon Transcribe represents the four tones in Mandarin Chinese using numbers\. The following table shows how tone marks are mapped for the word "ma\."


| Tone | Tone Mark | Tone Number | 
| --- | --- | --- | 
| Tone 1 | ma?? | ma1 | 
| Tone 2 | ma?? | ma2 | 
| Tone 3 | ma?? | ma3 | 
| Tone 4 | ma?? | ma4 | 

Chinese custom vocabularies don't use the `IPA` field, but you must still include the `IPA` header in the vocabulary table\. 

The following example is an input file in text format\. The example uses spaces to align the columns\. Your input files should use TAB characters to separate the columns\. Include spaces only in the `DisplayAs` column\.

```
Phrase     SoundsLike               IPA  DisplayAs
??????        kang1-jian4
??????        qian3-ze2
????????????    guo2-fang2-da4-chen2
???????????????  shi4-jie4-bo4-lan3-hui4       ?????????
```

### Dutch Character Set<a name="char-dutch"></a>

For Dutch custom vocabularies, you can use the following characters in the `Phrase` and `SoundsLike` fields:
+ a \- z
+ A \- Z
+ ' \(apostrophe\)
+ \- \(hyphen\)
+ \. \(period\)

You can also use the following Unicode characters in the `Phrase` and `SoundsLike` fields:


| Character | Code | Character | Code | 
| --- | --- | --- | --- | 
| ?? | 00E0 | ?? | 00EE | 
| ?? | 00E1 | ?? | 00EF | 
| ?? | 00E2 | ?? | 00F1 | 
| ?? | 00E4 | ?? | 00F2 | 
| ?? | 00E7 | ?? | 00F3 | 
| ?? | 00E8 | ?? | 00F4 | 
| ?? | 00E9 | ?? | 00F6 | 
| ?? | 00EA | ?? | 00F9 | 
| ?? | 00EB | ?? | 00FA | 
| ?? | 00EC | ?? | 00FB | 
| ?? | 00ED | ?? | 00FC | 

You can use the following International Phonetic Alphabet characters in the `IPA` field of the vocabulary input file:


| Character | Code | Character | Code | 
| --- | --- | --- | --- | 
| a: | 0061 003A | z | 007A | 
| b?? | 0062 02D0 | ??: | 00F8 003A | 
| b | 0062 | ?? | 014B | 
| d | 0064 | ??y | 0153 0079 | 
| e?? | 0065 02D0 | ???? | 0153 02D0 | 
| f | 0066 | ?? | 0251 | 
| g | 0067 | ?? | 0254 | 
| i | 0069 | ??u | 0254 0075 | 
| j | 006A | ???? | 0254 02D0 | 
| k | 006B | ?? | 0259 | 
| l | 006C | ?? | 025B | 
| m | 006D | ??: | 025B 003A | 
| n | 006E | ??i | 025B 0069 | 
| o?? | 006F 02D0 | ?? | 0266 | 
| p | 0070 | ?? | 026A | 
| s | 0073 | ?? | 0272 | 
| t | 0074 | ?? | 027E | 
| u | 0075 | ?? | 0283 | 
| v | 0076 | ?? | 028F | 
| w | 0077 | ?? | 0292 | 
| y | 0079 | ?? | 03C7 | 

### English Character Set<a name="char-english"></a>

For English custom vocabularies, you can use the following characters in the `Phrase` and `SoundsLike` fields:
+ a \- z
+ A \- Z
+ ' \(apostrophe\)
+ \- \(hyphen\)
+ \. \(period\)

You can use the following International Phonetic Alphabet characters in the `IPA` field of the vocabulary input file:


| Character | Code | Character | Code | 
| --- | --- | --- | --- | 
| a?? | 0061 028A | w | 0077 | 
| a?? | 0061 026A | z | 007A | 
| b | 0062 | ?? | 00E6 | 
| d | 0064 | ?? | 00F0 | 
| e?? | 0065 026A | ?? | 014B | 
| f | 0066 | ?? | 0251 | 
| g | 0067 | ?? | 0254 | 
| h | 0068 | ???? | 0254 026A | 
| i | 0069 | ?? | 0259 | 
| j | 006A | ?? | 025B | 
| k | 006B | ?? | 025D | 
| l | 006C | ?? | 0261 | 
| l?? | 006C 0329 | ?? | 026A | 
| m | 006D | ?? | 0279 | 
| n | 006E | ?? | 0283 | 
| n?? | 006E 0329 | ?? | 028A | 
| o?? | 006F 028A | ?? | 028C | 
| p | 0070 | ?? | 028D | 
| s | 0073 | ?? | 0292 | 
| t | 0074 | ?? | 02A4 | 
| u | 0075 | ?? | 02A7 | 
| v | 0076 | ?? | 03B8 | 

### Farsi Character Set<a name="char-farsi"></a>

For Farsi custom vocabularies, you can use the following characters in the `Phrase` and `SoundsLike` fields\.


| Character | Code | Character | Code | 
| --- | --- | --- | --- | 
| ?? | 0621 | ?? | 0638 | 
| ?? | 0622 | ?? | 0639 | 
| ?? | 0623 | ?? | 063A | 
| ?? | 0624 | ?? | 0641 | 
| ?? | 0626 | ?? | 0642 | 
| ?? | 0627 | ?? | 0644 | 
| ?? | 0628 | ?? | 0645 | 
| ?? | 062A | ?? | 0646 | 
| ?? | 062B | ?? | 0647 | 
| ?? | 062C | ?? | 0648 | 
| ?? | 062D | ?? | 064E | 
| ?? | 062E | ?? | 064F | 
| ?? | 062F | ?? | 0650 | 
| ?? | 0630 | ?? | 0651 | 
| ?? | 0631 | ?? | 067E | 
| ?? | 0632 | ?? | 0686 | 
| ?? | 0633 | ?? | 0698 | 
| ?? | 0634 | ?? | 06A9 | 
| ?? | 0635 | ?? | 06AF | 
| ?? | 0636 | ?? | 06CC | 
| ?? | 0637 | ?? | ?? | 

You can use the following International Phonetic Alphabet in the `IPA` field of your vocabulary file:


| Character | Code | Character | Code | 
| --- | --- | --- | --- | 
| b | 0062 | u | 0075 | 
| d | 0064 | v | 0076 | 
| f | 0066 | z | 007A | 
| g | 0067 | ?? | 00E6 | 
| h | 0068 | ?? | 0252 | 
| i | 0069 | ?? | 025B | 
| j | 006A | ?? | 027E | 
| k | 006B | ?? | 0281 | 
| l | 006C | ?? | 0283 | 
| m | 006D | ?? | 0292 | 
| n | 006E | ?? | 0294 | 
| o | 006F | ?? | 0294 | 
| p | 0070 | ?? | 02A4 | 
| s | 0073 | ?? | 02A7 | 
| t | 0074 | ?? | 03C7 | 

### French Character Set<a name="char-french"></a>

For French custom vocabularies, you can use the following characters in the `Phrase` and `SoundsLike` fields:
+ a \- z
+ A \- Z
+ ' \(apostrophe\)
+ \- \(hyphen\)
+ \. \(period\)

You can also use the following Unicode characters in the `Phrase` and `SoundsLike` fields:


| Character | Code | Character | Code | 
| --- | --- | --- | --- | 
| ?? | 00C0 | ?? | 00E0 | 
| ?? | 00C2 | ?? | 00E2 | 
| ?? | 00C7 | ?? | 00E7 | 
| ?? | 00C8 | ?? | 00E8 | 
| ?? | 00C9 | ?? | 00E9 | 
| ?? | 00CA | ?? | 00EA | 
| ?? | 00CB | ?? | 00EB | 
| ?? | 00CE | ?? | 00EE | 
| ?? | 00CF | ?? | 00EF | 
| ?? | 00D4 | ?? | 00F4 | 
| ?? | 00D6 | ?? | 00F6 | 
| ?? | 00D9 | ?? | 00F9 | 
| ?? | 00DB | ?? | 00FB | 
| ?? | 00DC | ?? | 00FC | 

You can use the following International Phonetic Alphabet in the `IPA` field of your vocabulary file:


| Character | Code | Character | Code | 
| --- | --- | --- | --- | 
| a | 0061 | z | 007A | 
| b | 0062 | ?? | 00E3 | 
| d | 0064 | ?? | 00F5 | 
| e | 0065 | ?? | 00F8 | 
| f | 0066 | ?? | 014B | 
| i | 0069 | ?? | 0153 | 
| j | 006A | ???? | 0153 0303 | 
| k | 006B | ?? | 0250 | 
| l | 006C | ?? | 0254 | 
| m | 006D | ?? | 0259 | 
| n | 006E | ?? | 025B | 
| o | 006F | ?? | 0261 | 
| p | 0070 | ?? | 0265 | 
| s | 0073 | ?? | 0272 | 
| t | 0074 | ?? | 0281 | 
| u | 0075 | ?? | 0283 | 
| v | 0076 | ?? | 0292 | 
| w | 0077 | ??? | 1EBD | 
| y | 0079 | ?? | ?? | 

### German Character Set<a name="char-german"></a>

For German custom vocabularies, you can use the following characters in the `Phrase` and `SoundsLike` fields:
+ a \- z
+ A \- Z
+ ' \(apostrophe\)
+ \- \(hyphen\)
+ \. \(period\)

You can also use the following Unicode characters in the `Phrase` and `SoundsLike` fields:


| Character | Code | Character | Code | 
| --- | --- | --- | --- | 
| ?? | 00E4 | ?? | 00C4 | 
| ?? | 00F6 | ?? | 00D6 | 
| ?? | 00FC | ?? | 00DC | 
| ?? | 00DF | ?? | ?? | 

You can use the following International Phonetic Alphabet characters in the `IPA` field of the vocabulary input file:


| Character | Code | Character | Code | 
| --- | --- | --- | --- | 
| a | 0061 | ts | 0074 0073 | 
| a?? | 0061 026A | u?? | 0075 02D0 | 
| a?? | 0061 028A | v | 0076 | 
| a?? | 0061 02D0 | x | 0078 | 
| b | 0062 | z | 007A | 
| d | 0064 | y?? | 0079 02D0 | 
| e?? | 0065 02D0 | ?? | 00E3 | 
| f | 0066 | ?? | 00E7 | 
| g | 0067 | ???? | 00F8 02D0 | 
| h | 0068 | ?? | 014B | 
| i?? | 0069 02D0 | ?? | 0153 | 
| j | 006A | ???? | 0250 032F | 
| k | 006B | ?? | 0254 | 
| l | 006C | ???? | 0254 028F | 
| l?? | 006C 0329 | ?? | 0259 | 
| m | 006D | ?? | 025B | 
| m?? | 006D 0329 | ???? | 025B 02D0 | 
| n | 006E | ?? | 026A | 
| n?? | 006E 0329 | ?? | 0281 | 
| o?? | 006F 02D0 | ?? | 0283 | 
| p | 0070 | ?? | 028A | 
| pf | 0070 0066 | ?? | 028F | 
| s | 0073 | ?? | 02A7 | 
| t | 0074 | ?? | ?? | 

### Hebrew Character Set<a name="char-hebrew"></a>

For Hebrew custom vocabularies, you can use the following Unicode characters in the `Phrase` and `SoundsLike` fields:


| Character | Code | Character | Code | 
| --- | --- | --- | --- | 
| \- | 002D | ?? | 05DD | 
| ?? | 05D0 | ?? | 05DE | 
| ?? | 05D1 | ?? | 05DF | 
| ?? | 05D2 | ?? | 05E0 | 
| ?? | 05D3 | ?? | 05E1 | 
| ?? | 05D4 | ?? | 05E2 | 
| ?? | 05D5 | ?? | 05E3 | 
| ?? | 05D6 | ?? | 05E4 | 
| ?? | 05D7 | ?? | 05E5 | 
| ?? | 05D8 | ?? | 05E6 | 
| ?? | 05D9 | ?? | 05E7 | 
| ?? | 05DA | ?? | 05E8 | 
| ?? | 05DB | ?? | 05E9 | 
| ?? | 05DC | ?? | 05EA | 

You can use the following International Phonetic Alphabet characters in the `IPA` field of the vocabulary input file:


| Character | Code | Character | Code | 
| --- | --- | --- | --- | 
| a | 0061 | p | 0070 | 
| b | 0062 | s | 0073 | 
| d | 0064 | t | 0074 | 
| e | 0065 | u | 0075 | 
| f | 0066 | v | 0076 | 
| g | 0067 | w | 0077 | 
| h | 0068 | z | 007A | 
| i | 0069 | ?? | 014B | 
| j | 006A | ?? | 0263 | 
| k | 006B | ?? | 0283 | 
| l | 006C | ?? | 0292 | 
| m | 006D | ?? | 0294 | 
| n | 006E | ?? | 03C7 | 
| o | 006F | ?? | ?? | 

### Hindi Character Set<a name="char-hindi"></a>

For Hindi custom vocabularies, you can use the following Unicode characters in the `Phrase` and `SoundsLike` fields:


| Character | Code | Character | Code | 
| --- | --- | --- | --- | 
| \- | 002D | ??? | 0925 | 
| \. | 002E | ??? | 0926 | 
| ??? | 0901 | ??? | 0927 | 
| ??? | 0902 | ??? | 0928 | 
| ??? | 0903 | ??? | 092A | 
| ??? | 0905 | ??? | 092B | 
| ??? | 0906 | ??? | 092C | 
| ??? | 0907 | ??? | 092D | 
| ??? | 0908 | ??? | 092E | 
| ??? | 0909 | ??? | 092F | 
| ??? | 090A | ??? | 0930 | 
| ??? | 090B | ??? | 0932 | 
| ??? | 090F | ??? | 0935 | 
| ??? | 0910 | ??? | 0936 | 
| ??? | 0911 | ??? | 0937 | 
| ??? | 0913 | ??? | 0938 | 
| ??? | 0914 | ??? | 0939 | 
| ??? | 0915 | ??? | 093E | 
| ??? | 0916 | ??? | 093F | 
| ??? | 0917 | ??? | 0940 | 
| ??? | 0918 | ??? | 0941 | 
| ??? | 0919 | ??? | 0942 | 
| ??? | 091A | ??? | 0943 | 
| ??? | 091B | ??? | 0945 | 
| ??? | 091C | ??? | 0947 | 
| ??? | 091D | ??? | 0948 | 
| ??? | 091E | ??? | 0949 | 
| ??? | 091F | ??? | 094B | 
| ??? | 0920 | ??? | 094C | 
| ??? | 0921 | ??? | 094D | 
| ??? | 0922 | ??? | 095B | 
| ??? | 0923 | ??? | 095C | 
| ??? | 0924 | ??? | 095D | 

Amazon Transcribe maps the following characters:


| Character | Mapped to | 
| --- | --- | 
| ??? \(0929\) | ??? \(0928\) | 
| ??? \(0931\) | ??? \(0930\) | 
| ??? \(0958\) | ??? \(0915\) | 
| ??? \(0959\) | ??? \(0916\) | 
| ??? \(095A\) | ??? \(0917\) | 
| ??? \(095E\) | ??? \(092B\) | 
| ??? \(095F\) | ??? \(092F\) | 

You can use the following International Phonetic Alphabet characters in the `IPA` field of your input file:


| Character | Code | Character | Code | 
| --- | --- | --- | --- | 
| a?? | 0097 0720 | ?? | 0331  | 
| b | 0098  | ?? | 0598  | 
| b?? | 0098 0689 | ???? | 0596 0720 | 
| d | 0100  | ???? | 0598 0689 | 
| d?? | 0100 0689 | ?? | 0601  | 
| e?? | 0101 0720 | ???? | 0603 0720 | 
| f | 0102  | ?? | 0609  | 
| i?? | 0105 0720 | ???? | 0609 0689 | 
| j | 0106  | ?? | 0614  | 
| k | 0107  | ?? | 0618  | 
| k?? | 0107 0688 | ?? | 0626  | 
| l | 0108  | ?? | 0627  | 
| m | 0109  | ?? | 0638  | 
| n | 0110  | ?? | 0642  | 
| o?? | 0111 0720 | ?? | 0643  | 
| p | 0112  | ?? | 0648  | 
| p?? | 0112 0688 | ???? | 0648 0688 | 
| r | 0114  | ?? | 0650  | 
| s | 0115  | ?? | 0651  | 
| t | 0116  | ?? | 0676  | 
| t?? | 0116 0688 | ???? | 0676 0689 | 
| u?? | 0117 0720 | ?? | 0679  | 
| z | 0122  | ???? | 0679 0688 | 

### Indonesian Character Set<a name="char-indonesian"></a>

For Indonesian custom vocabularies, you can use the following characters in the `Phrase` and `SoundsLike` fields:
+ a \- z
+ A \- Z
+ ' \(apostrophe\)
+ \- \(hyphen\)
+ \. \(period\)

You can use the following International Phonetic Alphabet characters in the `IPA` field of your input file:


| Character | Code | Character | Code | 
| --- | --- | --- | --- | 
| a | 0061 | r | 0072 | 
| ai | 0061 0069 | s | 0073 | 
| au | 0061 0075 | t | 0074 | 
| b | 0062 | t?? | 0074 0283 | 
| d | 0064 | u | 0075 | 
| d | 0064 | v | 0076 | 
| e | 0065 | w | 0077 | 
| f | 0066 | x | 0078 | 
| h | 0068 | y | 0079 | 
| i | 0069 | ?? | 014B | 
| j | 006A | ?? | 0254 | 
| k | 006B | ?? | 0259 | 
| l | 006C | ?? | 025B | 
| m | 006D | ?? | 0261 | 
| n | 006E | ?? | 0263 | 
| o | 006F | ?? | 026A | 
| oi?? | 006F 0069 032F | ?? | 0272 | 
| p | 0070 | ?? | 0283 | 
| q | 0071 | ?? | 028A | 

### Italian Character Set<a name="char-italian"></a>

For Italian custom vocabularies, you can use the following characters in the `Phrase` and `SoundsLike` fields:
+ a \- z
+ A \- Z
+ ' \(apostrophe\)
+ \- \(hyphen\)
+ \. \(period\)

You can also use the following Unicode characters in the `Phrase` and `SoundsLike` fields:


| Character | Code | Character | Code | 
| --- | --- | --- | --- | 
| ?? | 00C0 | ?? | 00E0 | 
| ?? | 00C4 | ?? | 00E4 | 
| ?? | 00C7 | ?? | 00E7 | 
| ?? | 00C8 | ?? | 00E8 | 
| ?? | 00C9 | ?? | 00E9 | 
| ?? | 00CA | ?? | 00EA | 
| ?? | 00CB | ?? | 00EB | 
| ?? | 00CC | ?? | 00EC | 
| ?? | 00D2 | ?? | 00F2 | 
| ?? | 00D9 | ?? | 00F9 | 
| ?? | 00DC | ?? | 00FC | 

You can use the following International Phonetic Alphabet characters in the `IPA` field of your input file:


| Character | Code | Character | Code | 
| --- | --- | --- | --- | 
| a | 0061 | ss | 0073 0073 | 
| b | 0062 | t | 0074 | 
| bb | 0062 0062 | tt | 0074 0074 | 
| d | 0064 | u | 0075 | 
| dd | 0064 0064 | v | 0076 | 
| e | 0065 | vv | 0076 0076 | 
| f | 0066 | w | 0077 | 
| ff | 0066 0066 | z | 007A | 
| gg | 0067 0067 | ?? | 0254 | 
| i | 0069 | ?? | 025B | 
| j | 006A | ?? | 0261 | 
| k | 006B | ?? | 0272 | 
| kk | 006B 006B | ???? | 0272 0272 | 
| l | 006C | ?? | 0283 | 
| ll | 006C 006C | ???? | 0283 0283 | 
| m | 006D | ?? | 028E | 
| mm | 006D 006D | ???? | 028E 028E | 
| n | 006E | ?? | 02A3 | 
| nn | 006E 006E | ???? | 02A3 02A3 | 
| o | 006F | ?? | 02A4 | 
| p | 0070 | ???? | 02A4 02A4 | 
| pp | 0070 0070 | ?? | 02A6 | 
| r | 0072 | ???? | 02A6 02A6 | 
| rr | 0072 0072 | ?? | 02A7 | 
| s | 0073 | ???? | 02A7 02A7 | 

### Japanese Character Set<a name="char-japanese"></a>

For Japanese custom vocabularies, the `Phrase` and `DisplayAs` fields can use any of the characters listed in the following file on GitHub\.
+ [ japanese\-character\-set\.txt](https://github.com/awsdocs/amazon-transcribe-developer-guide/blob/master/doc_source/japanese-character-set.txt) 

Amazon Transcribe supports Romaji characters in the `SoundsLike` field\. You can use the following lower\-case characters:
+ a \- k
+ m \- p
+ r \- w
+ y \- z

Represent long vowels by doubling the vowel:


| Vowel | Representation | 
| --- | --- | 
| ?? | aa | 
| ?? | ee | 
| ?? | ii | 
| ?? | oo | 
| ?? | uu | 

You can use the following International Phonetic Alphabet characters in the `IPA` field of your input file:


| Character | Code | Character | Code | 
| --- | --- | --- | --- | 
| a | 0061 | p | 0070 | 
| a?? | 0061 02D0 | s | 0073 | 
| b | 0062 | t | 0074 | 
| d | 0064 | ts | 0074 0073 | 
| dz | 0064 007A | t?? | 0074 0255 | 
| d?? | 0064 0291 | w | 0077 | 
| e | 0065 | z | 007A | 
| e?? | 0065 02D0 | ?? | 00E7 | 
| g | 0067 | ?? | 014B | 
| h | 0068 | ?? | 0255 | 
| i | 0069 | ?? | 026F | 
| i?? | 0069 02D0 | ???? | 026F 02D0 | 
| j | 006A | ?? | 0274 | 
| k | 006B | ?? | 0278 | 
| m | 006D | ?? | 027E | 
| n | 006E | ?? | 0291 | 
| o | 006F | ?? | 0294 | 
| o?? | 006F 02D0 | ?? | ?? | 

### Korean Character Set<a name="char-korean"></a>

For Korean custom vocabularies, you can use any of the Hangul syllables in the `Phrase` and `SoundsLike` fields\. For more information, see [Hangul Syllables](https://en.wikipedia.org/wiki/Hangul_Syllables) on Wikipedia\.

You can use the following International Phonetic Alphabet characters in the `IPA` field of your input file:


| Character | Code | Character | Code | 
| --- | --- | --- | --- | 
| a | 00061 | s?? | 0073 0348 | 
| e | 00065 | t | 0074 | 
| h | 00068 | t?? | 0074 0255 | 
| i | 00069 | t???? | 0074 0255 02B0 | 
| je | 006A 0065 | t?? | 0074 02B0 | 
| jo | 006A 006F | t?? | 0074 0348 | 
| ju | 006A 0075 | t???? | 0074 0348 0255 | 
| j?? | 006A 025B | u | 0075 | 
| j?? | 006A 028C | we | 0077 0065 | 
| ja | 006A 0061 | wi | 0077 0069 | 
| k | 006B | w?? | 0077 025B | 
| k?? | 006B 02B0 | w?? | 0077 028C | 
| k?? | 006B 0348 | wa | 0077 0061 | 
| l | 006C | ?? | 00F8 | 
| m | 006D | ?? | 0014B | 
| n | 006E | ?? | 0025B | 
| o | 006F | ?? | 026F | 
| p | 0070 | ??i | 006F 0069 | 
| p?? | 0070 02B0 | ?? | 027E | 
| p?? | 0070 0348 | ?? | 028C | 
| s | 0073 | ?? | ?? | 

### Malay Character Set<a name="char-malay"></a>

For Malay custom vocabularies, you can use the following characters in the `Phrase` and `SoundsLike` fields:
+ a \- z
+ A \- Z
+ ' \(apostrophe\)
+ \- \(hyphen\)
+ \. \(period\)

You can use the following International Phonetic Alphabet characters in the `IPA` field of your input file:


| Character | Code | Character | Code | 
| --- | --- | --- | --- | 
| F | 0046 | r | 0072 | 
| a | 0061 | s | 0073 | 
| ai | 0061 0069 | t | 0074 | 
| au | 0061 0075 | t?? | 0074 0283 | 
| b | 0062 | v | 0076 | 
| d | 0064 | w | 0077 | 
| d?? | 0064 0292 | x | 0078 | 
| e | 0065 | y | 0079 | 
| h | 0068 | ?? | 014B | 
| i | 0069 | ?? | 0254 | 
| j | 006A | ?? | 0259 | 
| k | 006B | ?? | 025B | 
| l | 006C | ?? | 0261 | 
| m | 006D | ?? | 0263 | 
| n | 006E | ?? | 026A | 
| o | 006F | ?? | 0272 | 
| oi?? | 006F 0069 32F | ?? | 0283 | 
| p | 0070 | ?? | 028A | 
| q | 0071 | ??i | 028A 0069 | 

### Portuguese Character Set<a name="char-portuguese"></a>

For Portuguese custom vocabularies, you can use the following characters in the `Phrase` and `SoundsLike` fields:
+ a \- z
+ A \- Z
+ ' \(apostrophe\)
+ \- \(hyphen\)
+ \. \(period\)

You can also use the following Unicode characters in the `Phrase` and `SoundsLike` fields:


| Character | Code | Character | Code | 
| --- | --- | --- | --- | 
| ?? | 00C0 | ?? | 00E0 | 
| ?? | 00C1 | ?? | 00E1 | 
| ?? | 00C2 | ?? | 00E2 | 
| ?? | 00C3 | ?? | 00E3 | 
| ?? | 00C4 | ?? | 00E4 | 
| ?? | 00C7 | ?? | 00E7 | 
| ?? | 00C8 | ?? | 00E8 | 
| ?? | 00C9 | ?? | 00E9 | 
| ?? | 00CA | ?? | 00EA | 
| ?? | 00CB | ?? | 00EB | 
| ?? | 00CD | ?? | 00ED | 
| ?? | 00D1 | ?? | 00F1 | 
| ?? | 00D3 | ?? | 00F3 | 
| ?? | 00D4 | ?? | 00F4 | 
| ?? | 00D5 | ?? | 00F5 | 
| ?? | 00D6 | ?? | 00F6 | 
| ?? | 00DA | ?? | 00FA | 
| ?? | 00DC | ?? | 00FC | 

You can use the following International Phonetic Alphabet characters in the `IPA` field of your input file:


| Character | Code | Character | Code | 
| --- | --- | --- | --- | 
| a | 0061 | v | 0076 | 
| b | 0062 | w | 0077 | 
| d | 0064 | w?? | 0077 0303 | 
| e | 0065 | z | 007A | 
| f | 0066 | ?? | 00F5 | 
| g | 0067 | ?? | 00129 | 
| i | 0069 | ?? | 00169 | 
| j | 006A | ???? | 0250 0303 | 
| k | 006B | ?? | 0254 | 
| l | 006C | ?? | 025B | 
| m | 006D | ?? | 0272 | 
| n | 006E | ?? | 027E | 
| o | 006F | ?? | 0281 | 
| p | 0070 | ?? | 0283 | 
| s | 0073 | ?? | 028E | 
| t | 0074 | ?? | 0292 | 
| t?? | 0074 0283 | ?? | 02A4 | 
| u | 0075 | ??? | 1EBD | 

### Russian Character Set<a name="char-russian"></a>

For Russian custom vocabularies, you can use the following characters in the `Phrase` and `SoundsLike` fields:


| Character | Code | Character | Code | 
| --- | --- | --- | --- | 
| ' | 0027 | ?? | 043F | 
| \- | 002D | ?? | 0440 | 
| \. | 002E | ?? | 0441 | 
| ?? | 0430 | ?? | 0442 | 
| ?? | 0431 | ?? | 0443 | 
| ?? | 0432 | ?? | 0444 | 
| ?? | 0433 | ?? | 0445 | 
| ?? | 0434 | ?? | 0446 | 
| ?? | 0435 | ?? | 0447 | 
| ?? | 0436 | ?? | 0448 | 
| ?? | 0437 | ?? | 0449 | 
| ?? | 0438 | ?? | 044A | 
| ?? | 0439 | ?? | 044B | 
| ?? | 043A | ?? | 044C | 
| ?? | 043B | ?? | 044D | 
| ?? | 043C | ?? | 044E | 
| ?? | 043D | ?? | 044F | 
| ?? | 043E | ?? | 0451 | 

You can use the following International Phonetic Alphabet characters in the IPA field of your input file:


| Character | Code | Character | Code | 
| --- | --- | --- | --- | 
| b | 0062 | t | 0074 | 
| b?? | 0062 02B2 | t?? | 0074 0283 | 
| d | 0064 | t?? | 0074 02B2 | 
| d?? | 0064 02B2 | u | 0075 | 
| f | 0066 | v | 0076 | 
| f?? | 0066 02B2 | v?? | 0076 02B2 | 
| g | 0067 | x | 0078 | 
| g?? | 067 02B2 | x?? | 0078 02B2 | 
| i | 0069 | z | 007A | 
| j | 006A | z?? | 007A 02B2 | 
| k | 006B | ?? | 00E6 | 
| k?? | 006B 02B2 | ?? | 0259 | 
| l | 006C | ?? | 025B | 
| l?? | 006C 02B2 | ?? | 0268 | 
| m | 006D | ?? | 0283 | 
| m?? | 006D 02B2 | ???? | 0283 02B2 | 
| n | 006E | ?? | 028A | 
| n?? | 006E 02B2 | ?? | 028C | 
| p | 0070 | ?? | 0292 | 
| p?? | 0070 02B2 | ??i | 02C8 0069 | 
| r | 0072 | ??o | 02C8 006F | 
| r?? | 0072 02B2 | ??v | 02C8 0075 | 
| s | 0073 | ???? | 02C8 025B | 
| s?? | 0073 02B2 | ???? | 02C8 0268 | 
| ts | 0074 0073 | ??a | 02C8 0061 | 

### Spanish Character Set<a name="char-spanish"></a>

For Spanish custom vocabularies, you can use the following characters in the `Phrase` and `SoundsLike` fields:
+ a \- z
+ A \- Z
+ ' \(apostrophe\)
+ \- \(hyphen\)
+ \. \(period\)

You can also use the following Unicode characters in the `Phrase` and `SoundsLike` fields:


| Character | Code | Character | Code | 
| --- | --- | --- | --- | 
| ?? | 00C1 | ?? | 00E1 | 
| ?? | 00C9 | ?? | 00E9 | 
| ?? | 00CD | ?? | 00ED | 
| ?? | 00D3 | ?? | 0XF3 | 
| ?? | 00DA | ?? | 00FA | 
| ?? | 00D1 | ?? | 0XF1 | 
| ?? | 00FC | ?? | ?? | 

You can use the following International Phonetic Alphabet characters in the `IPA` field of your input file:


| Character | Code | Character | Code | 
| --- | --- | --- | --- | 
| a | 0061 | r | 0072 | 
| b | 0062 | s | 0073 | 
| d | 0064 | t | 0074 | 
| e | 0065 | u | 0075 | 
| f | 0066 | v | 0076 | 
| g | 0067 | w | 0077 | 
| h | 0068 | x | 0078 | 
| i | 0069 | z | 007A | 
| j | 006A | ?? | 014B | 
| k | 006B | ?? | 0272 | 
| l | 006C | ?? | 027E | 
| m | 006D | ?? | 0283 | 
| n | 006E | ?? | 029D | 
| o | 006F | ?? | 02A7 | 
| p | 0070 | ?? | 03B8 | 

### Tamil Character Set<a name="char-tamil"></a>

For Tamil custom vocabularies, you can use the following characters in the `Phrase` and `SoundsLike` fields:


| Character | Code | Character | Code | 
| --- | --- | --- | --- | 
| ??? | 0B85 | ??? | 0BB0 | 
| ??? | 0B86 | ??? | 0BB2 | 
| ??? | 0B87 | ??? | 0BB5 | 
| ??? | 0B88 | ??? | 0BB4 | 
| ??? | 0B89 | ??? | 0BB3 | 
| ??? | 0B8A | ??? | 0BB1 | 
| ??? | 0B8E | ??? | 0BA9 | 
| ??? | 0B8F | ??? | 0B9C | 
| ??? | 0B90 | ??? | 0BB6 | 
| ??? | 0B92 | ??? | 0BB7 | 
| ??? | 0B93 | ??? | 0BB8 | 
| ??? | 0B94 | ??? | 0BB9 | 
| ??? | 0B83 | ??? | 0BCD | 
| ??? | 0B95 | ??? | 0BBE | 
| ??? | 0B99 | ??? | 0BBF | 
| ??? | 0B9A | ??? | 0BC0 | 
| ??? | 0B9E | ??? | 0BC1 | 
| ??? | 0B9F | ??? | 0BC2 | 
| ??? | 0BA3 | ??? | 0BC6 | 
| ??? | 0BA4 | ??? | 0BC7 | 
| ??? | 0BA8 | ??? | 0BC8 | 
| ??? | 0BAA | ??? | 0BCA | 
| ??? | 0BAE | ??? | 0BCB | 
| ??? | 0BAF | ??? | 0BCC | 

You can use the following International Phonetic Alphabet characters in the `IPA` field of your input file:


| Character | Code | Character | Code | 
| --- | --- | --- | --- | 
| a | 0061 | v | 0076 | 
| a?? | 0061 02D0 | w | 0077 | 
| b | 0062 | z | 007A | 
| d | 0064 | ?? | 00E6 | 
| d?? | 0064 0292 | ?? | 00F0 | 
| e | 0065 | ?? | 014B | 
| f | 0066 | ?? | 0251 | 
| g | 0067 | ?? | 0254 | 
| h | 0068 | ?? | 0259 | 
| i | 0069 | ?? | 025B | 
| i?? | 0069 02D0 | ?? | 0261 | 
| j | 006A | ?? | 026A | 
| k | 006B | ?? | 026D | 
| l | 006C | ?? | 0272 | 
| m | 006D | ?? | 0273 | 
| n | 006E | ?? | 0279 | 
| n?? | 006E 032A | ?? | 0279 | 
| o | 006F | ???? | 0279 0329 | 
| o?? | 006F 02D0 | ?? | 027E | 
| p | 0070 | ?? | 0282 | 
| r | 0072 | ?? | 0283 | 
| s | 0073 | ?? | 0288 | 
| t | 0074 | ?? | 028A | 
| t?? | 0074 032A | ?? | 028B | 
| t?? | 0074 0283 | ?? | 028C | 
| u | 0075 | ?? | 0292 | 
| u?? | 0075 02D0 | ?? | 03B8 | 

### Telugu Character Set<a name="char-telugu"></a>

For Telugu custom vocabularies, you can use the following characters in the `Phrase` and `SoundsLike` fields:


| Character | Code | Character | Code | 
| --- | --- | --- | --- | 
| \- | 002D | ??? | 0C24 | 
| ??? | 0C01 | ??? | 0C25 | 
| ??? | 0C02 | ??? | 0C26 | 
| ??? | 0C03 | ??? | 0C27 | 
| ??? | 0C05 | ??? | 0C28 | 
| ??? | 0C06 | ??? | 0C2A | 
| ??? | 0C07 | ??? | 0C2B | 
| ??? | 0C08 | ??? | 0C2C | 
| ??? | 0C09 | ??? | 0C2D | 
| ??? | 0C0A | ??? | 0C2E | 
| ??? | 0C0B | ??? | 0C2F | 
| ??? | 0C0C | ??? | 0C30 | 
| ??? | 0C0E | ??? | 0C31 | 
| ??? | 0C0F | ??? | 0C32 | 
| ??? | 0C10 | ??? | 0C33 | 
| ??? | 0C12 | ??? | 0C35 | 
| ??? | 0C13 | ??? | 0C36 | 
| ??? | 0C14 | ??? | 0C37 | 
| ??? | 0C15 | ??? | 0C38 | 
| ??? | 0C16 | ??? | 0C39 | 
| ??? | 0C17 | ??? | 0C3E | 
| ??? | 0C18 | ??? | 0C3F | 
| ??? | 0C19 | ??? | 0C40 | 
| ??? | 0C1A | ??? | 0C41 | 
| ??? | 0C1B | ??? | 0C42 | 
| ??? | 0C1C | ??? | 0C43 | 
| ??? | 0C1D | ??? | 0C44 | 
| ??? | 0C1E | ??? | 0C47 | 
| ??? | 0C1F | ??? | 0C48 | 
| ??? | 0C20 | ??? | 0C4A | 
| ??? | 0C21 | ??? | 0C4B | 
| ??? | 0C22 | ??? | 0C4C | 
| ??? | 0C23 | ??? | 0C4D | 

You can use the following International Phonetic Alphabet characters in the `IPA` field of your input file:


| Character | Code | Character | Code | 
| --- | --- | --- | --- | 
| d?? | 0064 032A | ?? | 00F0 | 
| d???? | 0064 032A 0324 | ?? | 014B | 
| d?? | 0064 0292 | ?? | 0251 | 
| d???? | 0064 0292 0324 | ?? | 0254 | 
| e | 0065 | ?? | 0256 | 
| e?? | 0065 02D0 | ???? | 0256 0324 | 
| f | 0066 | ?? | 0259 | 
| h | 0068 | ?? | 025B | 
| i | 0069 | ?? | 0261 | 
| i?? | 0069 0290 | ???? | 0261 0324 | 
| j | 006A | ?? | 026A | 
| k | 006B | ?? | 026D | 
| k?? | 006B 02B0 | ?? | 0272 | 
| l | 006C | ?? | 0273 | 
| m | 006D | ?? | 0279 | 
| n | 006E | ???? | 0279 0329 | 
| o | 006F | ?? | 027D | 
| o?? | 006F 02D0 | ?? | 0282 | 
| p | 0070 | ?? | 0283 | 
| p?? | 0070 02B0 | ?? | 0288 | 
| r | 0072 | ???? | 0288 02B0 | 
| s | 0073 | ?? | 028A | 
| t | 0074 | ?? | 028B | 
| t?? | 0074 032A | ?? | 028C | 
| t???? | 0074 032A 02B0 | ?? | 0292 | 
| t | 0074 | ?? | 03B8 | 
| t???? | 0074 0283 02B0 | ?? | ?? | 

### Turkish Character Set<a name="char-turkish"></a>

For Turkish custom vocabularies, you can use the following characters in the `Phrase` and `SoundsLike` fields:
+ a \- z
+ A \- Z
+ ' \(apostrophe\)
+ \- \(hyphen\)
+ \. \(period\)

You can also use the following Unicode characters in the `Phrase` and `SoundsLike` fields:


| Character | Code | Character | Code | 
| --- | --- | --- | --- | 
| ?? | 00C7 | ?? | 00F6 | 
| ?? | 00D6 | ?? | 00FB | 
| ?? | 00DC | ?? | 00FC | 
| ?? | 00E2 | ?? | 011E | 
| ?? | 00E4 | ?? | 011F | 
| ?? | 00E7 | ?? | 0130 | 
| ?? | 00E8 | ?? | 0131 | 
| ?? | 00E9 | ?? | 015E | 
| ?? | 00EA | ?? | 015F | 
| ?? | 00ED | ?? | 0161 | 
| ?? | 00EE | ?? | 017E | 
| ?? | 00F3 | ?? | ?? | 

You can use the following International Phonetic Alphabet characters in the `IPA` field of your input file:


| Character | Code | Character | Code | 
| --- | --- | --- | --- | 
| a | 0061 | u | 0075 | 
| a?? | 0061 02D0 | u?? | 0075 02D0 | 
| b | 0062 | v | 0076 | 
| c | 0063 | w | 0077 | 
| d | 0064 | y | 0079 | 
| e | 0065 | y?? | 0079 02D0 | 
| e?? | 0065 02D0 | z | 007A | 
| f | 0066 | ?? | 00F8 | 
| g | 0067 | ???? | 00F8 02D0 | 
| h | 0068 | ?? | 014B | 
| i | 0069 | ?? | 025F | 
| i?? | 0069 02D0 | ?? | 0263 | 
| j | 006A | ?? | 026B | 
| k | 006B | ?? | 026F | 
| l | 006C | ???? | 026F 02D0 | 
| m | 006D | ?? | 027E | 
| n | 006E | ?? | 0283 | 
| o | 006F | ?? | 0292 | 
| o?? | 006F 02D0 | ?? | 0294 | 
| p | 0070 | ?? | 02A4 | 
| s | 0073 | ?? | 02A7 | 
| t | 0074 | ?? | ?? | 