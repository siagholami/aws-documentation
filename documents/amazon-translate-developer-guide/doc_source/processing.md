# Translation Processing Modes<a name="processing"></a>

When translating documents, you can use two different translation processing modes: real\-time translation or asynchronous batch processing\. The mode you use is based on the size and type of the target documents and affects how you submit the translation job and view its results\.
+ [Real\-time translation](sync.md) – You call Amazon Translate on a small field of text and a synchronous response is immediately sent to your application\.
+ [Asynchronous batch processing](async.md) – You put a collection of documents in an Amazon Simple Storage Service \(Amazon S3\) bucket and start an asynchronous processing job to translate them\. Amazon Translate sends the translated output document to a specified Amazon S3 bucket\.