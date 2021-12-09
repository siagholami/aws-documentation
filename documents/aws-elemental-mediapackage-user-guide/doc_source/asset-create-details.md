# Asset Details Fields<a name="asset-create-details"></a>

The following fields describe the source content that this asset uses\.

If you have multiple sources for this asset, choose **Add asset** and complete the fields\. Do this for all source contents\.

**Important**  
Source content must be in a \.smil \(MP4\) or \.m3u8 \(HLS/TS\) file format\.

****Filename****  
The filename identifies the source content\.   
Enter the path to the file within your Amazon S3 bucket, including the name of the source content\.  

**Example**  
If your content is called` lion_movie.m3u8` and is in a subdirectory called `thursday_night` in a bucket called `movies`, you would enter the following in the **Filename** field:  

```
thursday_night/lion_movie.m3u8
```
You don't need to enter the bucket name because you chose it in **S3 bucket name** field\.

****ID****  
The ID is the primary identifier for the asset, and must be unique for your account in this Region\.  
Enter a name that describes the asset\.

****Resource ID****  
When you're using SPEKE, the resource ID is the identifier that your key server uses to reference the content\. AWS Elemental MediaPackage sends the ID to the key server to identify the current asset\. How unique you make the ID depends on the level of access controls you need\. The service doesn't allow you to use the same ID for two simultaneous encryption processes\. The resource ID is also known as the content ID\.  
Enter an identifier for the content\.  

**Example**  

```
MovieNight20171126093045
```