# Support Vector Machine–Based Classifier<a name="macie-classify-objects-classifier"></a>

Another method that Macie uses to classify your S3 objects is the Support Vector Machine \(SVM\) classifier\. It classifies content inside your S3 objects \(text, token n\-grams, and character n\-grams\) that Macie monitors and their metadata features \(document length, extension, encoding, headers\) to accurately classify documents based on content\. This classifier, managed by Macie, was trained against a large corpus of training data of various types and has been optimized to support accurate detection of various content types, including source code, application logs, regulatory documents, and database backups\. The classifier can also generalize its detections\. For example, if it detected a new kind of source code that doesn't match any of the types of source code that it is trained to recognize, it can generalize the detection as being "source code\."

**Note**  
This data classification method isn't surfaced in the **Settings** page\. Macie manages the following list of artifacts\. You can't edit, enable, or disable them\.

The SVM classifier in Macie is trained to detect the following content types:
+ E\-books
+ Email
+ Generic encryption keys
+ Financial
  + SEC regulatory forms
+ JSON
  + AWS CloudTrail logs
  + Jupyter notebooks
+ Application logs
  + Apache format
  + Amazon S3 server logs
  + Linux syslog
+ Database
  + MongoDB backup
  + MySQLbackup
  + MySQL script
+ Source code
  + F\#
  + VimL
  + ActionScript
  + Assembly
  + Bash
  + Batchfile
  + C
  + Clojure
  + Cobol
  + CoffeeScript
  + CUDA
  + Erlang
  + Fortran
  + Go
  + Haskell
  + Java
  + JavaScript
  + LISP
  + Lua
  + Matlab
  + ObjectiveC
  + Perl
  + PHP
  + PowerShell
  + Processing
  + Python
  + R
  + Ruby
  + Scala
  + Swift
  + VHDL
+ Web languages
  + CSS
  + HTML
  + XML