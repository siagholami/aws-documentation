--------

This guide is for the Snowball \(50 TB or 80 TB of storage space\)\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\.

--------

# Using Export Ranges<a name="ranges"></a>

When you create an export job in the [AWS Snowball Management Console](https://console.aws.amazon.com/importexport/home?region=us-west-2), you can choose to export an entire Amazon S3 bucket or a specific range of objects keys\. Object key names uniquely identify objects in a bucket\. If you choose to export a range, you define the length of the range by providing either an inclusive range beginning, an inclusive range ending, or both\. 

Ranges are UTF\-8 binary sorted\. UTF\-8 binary data is sorted in the following way:
+ The numbers 0\-9 come before both uppercase and lowercase English characters\.
+ Uppercase English characters come before all lowercase English characters\.
+ Lowercase English characters come last when sorted against uppercase English characters and numbers\.
+ Special characters are sorted among the other character sets\.

For more information on the specifics of UTF\-8 sort order, see [https://en\.wikipedia\.org/wiki/UTF\-8](https://en.wikipedia.org/wiki/UTF-8)\.

## Export Range Examples<a name="range-examples"></a>

Assume you have a bucket containing the following objects, sorted in UTF\-8 binary order\.
+ 01
+ Aardvark
+ Aardwolf
+ Aasvogel/apple
+ Aasvogel/banana
+ Aasvogel/cherry
+ Banana
+ Car


| Specified Range Beginning | Specified Range Ending | Objects in the Range That Will Be Exported | 
| --- | --- | --- | 
| \(none\) | \(none\) | All of the objects in your bucket | 
| \(none\) | Aasvogel |  01 Aardvark Aardwolf Aasvogel/apple Aasvogel/banana Aasvogel/cherry  | 
| \(none\) | Aasvogel/banana |  01 Aardvark Aardwolf Aasvogel/apple Aasvogel/banana | 
| Aasvogel | \(none\) |  Aasvogel/apple Aasvogel/banana Aasvogel/cherry Banana Car | 
| Aardwolf | \(none\) | Aardwolf Aasvogel/apple Aasvogel/banana Aasvogel/cherry Banana Car | 
| Aar | \(none\) | Aardvark Aardwolf Aasvogel/apple Aasvogel/banana Aasvogel/cherry Banana Car | 
| car | \(none\) | No objects will be exported, and you’ll get an error message when you try to create the job\. Note that car is sorted below Car according to UTF\-8 binary values\. | 
| Aar | Aarrr | Aardvark Aardwolf | 