# Encryption of data at rest<a name="encryption-at-rest"></a>

The telemetry data that an Amazon Inspector agent generates during assessment runs is formatted in JSON files\. These files are delivered in near\-real\-time over TLS to Amazon Inspector, where they are encrypted with a per\-assessment\-run, ephemeral AWS KMS\-derived key\.

The files are securely stored in S3 buckets that are dedicated to Amazon Inspector\. The rules engine of Amazon Inspector does the following:
+ Accesses the encrypted telemetry data in the S3 bucket
+ Decrypts it in memory 
+ Processes the data against the configured assessment rules to generate findings