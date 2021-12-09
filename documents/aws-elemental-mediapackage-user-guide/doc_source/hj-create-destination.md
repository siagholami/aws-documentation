# Destination<a name="hj-create-destination"></a>

The destination information defines how MediaPackage saves the live\-to\-VOD asset after it has been harvested from the live stream\.

1. For **IAM role**, enter the Amazon Resource Name \(ARN\) for the IAM role that provides MediaPackage access to read and write from your Amazon S3 bucket where the live\-to\-VOD asset will be stored\. This is the role that you created in [Allowing AWS Elemental MediaPackage to Access Other AWS Services](setting-up-create-trust-rel.md)\.

1. For **S3 bucket name**, enter the bucket where you want MediaPackage to store the live\-to\-VOD asset\.

1. For **Manifest key**, enter the path within the bucket to the live\-to\-VOD asset, including the file name for the parent manifest of the asset\. If the directory structure doesn't already exist in the bucket, MediaPackage creates it\. 
**Important**  
The manifest key must be unique\. When you use the same manifest key for multiple harvest jobs, the newest playlist for the asset overwrites existing playlists\. The only time you should reuse a manifest key is when you are harvesting the same content, such as if there was a problem with a previous harvest of the content\.