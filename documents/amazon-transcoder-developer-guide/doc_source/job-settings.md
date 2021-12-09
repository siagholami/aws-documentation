# Settings that You Specify When You Create an Elastic Transcoder Job<a name="job-settings"></a>

When you create a job using the Elastic Transcoder console, you can specify the following values\. 

**Note**  
You can configure Elastic Transcoder to notify you when the status of a job changes, including when Elastic Transcoder starts and finishes processing a job, and when Elastic Transcoder encounters a warning or error condition\. For more information, see [Notifications of Job Status](notifications.md)\.

**Topics**
+ [Region](#job-settings-region)
+ [General Settings](#job-settings-general)
+ [Input Details, Part 1](#job-settings-input-details)
+ [Input Details, Part 2, Clip and Caption Settings](#job-settings-input-details-part-2)
+ [Output Details, Part 1](#job-settings-output-details)
+ [Output Details, Part 2](#job-settings-output-details-part-3)
+ [Output Details, Part 3, Caption Settings](#job-settings-output-details-part-2)
+ [\(Optional\) Output Encryption](#job-encryption-settings)
+ [\(Video/Thumbnails Only\) Watermarks](#job-settings-watermarks)
+ [\(FLAC/MP3/MP4 Only\) Album Art](#job-settings-album-art)
+ [\(Optional\) User Metadata](#job-settings-user-metadata)
+ [\(Fragmented MP4/MPEG\-TS Outputs Only\) Playlist](#job-settings-playlist)
+ [\(Fragmented MP4/MPEG\-TS Outputs Only, Optional\) HLS Content Protection](#job-settings-hls-cp)
+ [\(HLSv3 and Smooth Playlists Only, Optional\) Digital Rights Management](#job-settings-drm)

## Region<a name="job-settings-region"></a>

Elastic Transcoder creates your job in the region you are in\.

## General Settings<a name="job-settings-general"></a>

 **Pipeline**  
The name of the pipeline that you want Elastic Transcoder to use for transcoding\. The pipeline determines several settings, including the Amazon S3 bucket from which Elastic Transcoder gets the files to transcode and the bucket into which Elastic Transcoder puts the transcoded files\.

 **Output Key Prefix**  
The value, if any, that you want Elastic Transcoder to prepend to the names of all files that this job creates, including output files, thumbnails, and playlists\. If you specify a value, it must contain a **/** somewhere after the first character, which simplifies Amazon S3 file management\.

![\[General Settings screenshot.\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/)

## Input Details, Part 1<a name="job-settings-input-details"></a>

Use the settings in this section to specify information about the input files\. If you provide more than one input file, Elastic Transcoder transcodes them and then stitches them together into one output file\. For more information, see [Clip Stitching](clip-stitching.md)\.

 **Input Key**  
The name of the files that you want to transcode\. To determine from which Amazon S3 bucket to get the file, Elastic Transcoder refers to the **Input Bucket** field in the pipeline that you specified for this job\.   
If a file name includes a prefix—for example, `cooking/lasagna.mpg`—include the prefix in the key\. If the file isn't in the specified bucket, Elastic Transcoder returns an error\.

 **Input Decryption**  
The encryption settings, if any, that are used for decrypting your input files\. If your input file is encrypted, you must specify the mode that Elastic Transcoder will use to decrypt your file\.

 **Decryption Mode \(Required for Decryption\)**  
The specific encryption mode that you want Elastic Transcoder to use when decrypting your files\.  
Elastic Transcoder supports the following options:  
+ **Amazon S3 Server\-Side Encryption:** Amazon S3 handles the encryption and decryption of your files\. As long as Elastic Transcoder has access permissions to your Amazon S3 bucket, you don't need to take any action\.

  For more information, see [Protecting Data Using Server\-Side Encryption](https://docs.aws.amazon.com/AmazonS3/latest/dev/serv-side-encryption.html) in the *Amazon Simple Storage Service Developer Guide*\.
+ **Client\-Side Encryption Using Customer\-Provided Keys:** Elastic Transcoder supports three types of encryption using customer\-provided keys:
  + **aes\-cbc\-pkcs7:** A padded cipher\-block mode of operation\.
  + **aes\-ctr:** AES Counter Mode\.
  + **aes\-gcm:** AES Galois Counter Mode, a mode of operation that is an authenticated encryption format, meaning that a file, key, or initialization vector that has been tampered with will fail the decryption process\.

  If you chose one of the AES\-encryption modes, you must also specify the following three values \(all three must be base64\-encoded\):
  + **Encryption Key**
  + **Encryption Key MD5**
  + **Encryption Initialization Vector**

 **Decryption Key \(Required for AES Decryption\)**  
The data encryption key used to encrypt your file\. The key must be base64\-encoded and it must be one of the following bit lengths before being base64\-encoded:  
`96` \(AES\-GCM only\), `128`, `192`, or `256`\.   
The key must also be encrypted by using AWS KMS\. For more information, see [Encrypting and Decrypting Data](https://docs.aws.amazon.com/kms/latest/developerguide/programming-encryption.html) in the *AWS Key Management Service Developer Guide*\.

 **Decryption Key MD5 \(Required for AES Decryption\)**  
The MD5 digest of the key used to encrypt your input file, and that you want Elastic Transcoder to use as a checksum to make sure your key was not corrupted in transit\. The key MD5 must be base64\-encoded, and it must be exactly 16 bytes before being base64\-encoded\.

 **Decryption Initialization Vector \(Required for AES Decryption\)**  
The series of random bits created by a random bit generator, unique for every encryption operation, that you used to encrypt your input files\. The initialization vector must be base64\-encoded, and it must be exactly 16 bytes before being base64\-encoded\.  
For more information, go to [Initialization Vector](http://en.wikipedia.org/wiki/Initialization_vector)\.

![\[Input Settings screenshot.\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/)

## Input Details, Part 2, Clip and Caption Settings<a name="job-settings-input-details-part-2"></a>

Use the settings in this section to specify information about clips and captions for the input files\. These settings are available only when you provide multiple inputs\.

For more information on captions, see [Captions](captions.md)

 **\(Optional\) Clip Start Time**  
You can create an output file that contains an excerpt from the input file\. **Clip Start Time** indicates the place in the input file where you want a clip to start\. The format can be either HH:mm:ss\.SSS \(maximum value: 23:59:59\.999; SSS is thousandths of a second\) or sssss\.SSS \(maximum value: 86399\.999\)\. If you don't specify a value, Elastic Transcoder starts at the beginning of the input file\.

 **\(Optional\) Clip Duration**  
The duration of your excerpt clip\. The format can be either HH:mm:ss\.SSS \(maximum value: 23:59:59\.999; SSS is thousandths of a second\) or sssss\.SSS \(maximum value: 86399\.999\)\. If you don't specify a value, Elastic Transcoder clips from **Clip Start Time** to the end of the file\.  
If you specify a value longer than the duration of the input file, Elastic Transcoder transcodes from **Clip Start Time** to the end of the file and returns a warning message\.

 **\(Video Only\) Captions Merge Policy**  
A policy that determines how Elastic Transcoder handles the existence of multiple captions\.  
+ **MergeOverride:** Elastic Transcoder transcodes both embedded and sidecar captions into outputs\. If captions for a language are embedded in the input file and also appear in a sidecar file, Elastic Transcoder uses the sidecar captions and ignores the embedded captions for that language\.
+ **MergeRetain:** Elastic Transcoder transcodes both embedded and sidecar captions into outputs\. If captions for a language are embedded in the input file and also appear in a sidecar file, Elastic Transcoder uses the embedded captions and ignores the sidecar captions for that language\. If **Caption Source** is empty, Elastic Transcoder omits all sidecar captions from the output files\.
+ **Override:** Elastic Transcoder transcodes only the sidecar captions that you specify in **Caption Source**\.

 **\(Video Only, Optional\) Input Key**  
The name of the sidecar caption file that you want Elastic Transcoder to transcode and include with the outputs\.

 **\(Video Only\) Language**  
A string that specifies the language of the caption in one of the following formats:  
+ 2\-character ISO 639\-1 code, for example, **en** for English
+ 3\-character ISO 639\-2 code, for example, **eng** for English
For more information on ISO language codes, see [List of ISO 639\-1 codes](http://en.wikipedia.org/wiki/List_of_ISO_639-2_codes)\.

 **\(Video Only, Optional\) TimeOffset**  
For clip generation or captions that do not start at the same time as the associated video file, the **TimeOffset** tells Elastic Transcoder how much of the video to encode before including captions\.  
Specify the TimeOffset in the form \[\+\-\]SS\.sss or \[\+\-\]HH:mm:SS\.ss\.

 **\(Video Only, Optional\) Label**  
The label of the caption shown in the player when choosing a language\. We recommend that you put the caption language name here, in the language of the captions\.

![\[Input clip and captions screenshot.\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/)

## Output Details, Part 1<a name="job-settings-output-details"></a>

Use the settings in this section to specify information about the output files\.

 **Preset**  
The preset that you want to use for this output\. The preset determines the audio, video, and thumbnail settings that Elastic Transcoder uses for transcoding\.

 **\(Fragmented MP4/MPEG\-TS Outputs Only\) Segment Duration**  
If you specify a preset for the current output for which the value of **Container** is either **ts** \(MPEG\-TS\) or **fmp4** \(Fragmented MP4\), **Segment Duration** is the target maximum duration of each segment in seconds\. For **HLSv3** format playlists, each media segment is stored in a separate `.ts` file\. For **HLSv4**, **MPEG\-DASH**, and **Smooth** playlists, all media segments for an output are stored in a single file\. Each segment is approximately the length of the **Segment Duration**, though individual segments might be shorter or longer\.   
The range of valid values is 1 to 60 seconds\. If the duration of the video is not evenly divisible by **Segment Duration**, the duration of the last segment is the remainder of:  
`total length/Segment Duration`  
Elastic Transcoder creates an output\-specific playlist for each **HLS** output that you specify in **Output Keys**\. To add an output to a master playlist for this job, include it in [Outputs in Master Playlist](#job-settings-playlist-outputs)\.  
Elastic Transcoder applies this segmenting to any captions associated with the output video\.  
For more information, see [HTTP Live Streaming](http://en.wikipedia.org/wiki/HTTP_Live_Streaming) or [ Smooth Streaming Technical Overview](http://www.iis.net/learn/media/on-demand-smooth-streaming/smooth-streaming-technical-overview)\.

 **Output Key**  
The name that you want Elastic Transcoder to assign to the transcoded file and playlist\. Elastic Transcoder saves the file or files in the Amazon S3 bucket specified by the **Bucket** field in the pipeline that you specify in [Pipeline](#job-settings-pipeline-id)\. If the bucket already contains a file that has the specified name, the output fails\. However, other outputs in the same job might succeed\.  
The format for file names depends on the container type and whether the segment duration is set\. If the container type is not `ts` or the segment duration is not provided, the name of the output file is a concatenation of **Output Key Prefix** and **Output Key**\.  
If the container type is `ts` and segment duration is provided, Elastic Transcoder uses the value of **Output Key** to name both the playlist for the output and the `.ts` files:  
+ **Playlist:**
  + **HLSv3:** The file name is a concatenation of **Output Key Prefix** and **Output Key** plus the file name extension **\.m3u8**:

    Output Key Prefix**Output Key**\.m3u8
  + **HLSv4:** The file name is a concatenation of **Output Key Prefix** and **Output Key** plus the file name extension **\_v4\.m3u8**\. Video outputs create a second file with a file name that is a concatenation of **Output Key Prefix** and **Output Key** plus the file name extension **\_iframe\.m3u8**:

    Output Key Prefix**Output Key**\_v4\.m3u8

    Output Key Prefix**Output Key**\_iframe\.m3u8 \(Video only\)
+ **Segment \(\.ts\) files:**
  + **HLSv3:** The file name is a concatenation of **Output Key Prefix** and **Output Key**, plus a five\-digit sequential counter beginning with **00000**, and the file name extension **\.ts**:

    Output Key Prefix**Output Key**00000\.ts
  + **HLSv4:** The file name is a concatenation of **Output Key Prefix** and **Output Key** plus the file name extension **\.ts**:

    Output Key Prefix**Output Key**\.ts
If a segmented `ts` output is not included in a master playlist, Elastic Transcoder treats the output as **HLSv3**\.  
Elastic Transcoder automatically appends the relevant file extension to outputs in an **HLSv3** or **HLSv4** playlist\. If you include a file extension in the **Output Key** for **HLSv3** or **HLSv4** playlist outputs, the filename will have two extensions\.
**Output Key Prefix** groups all of the files for a job together in your Amazon S3 bucket\. If you want to group the files for each output within a job, you can include a prefix in the value of **Output Key**, for example:  
OutputKeyPrefix**iPhone/Key**00000\.ts  
OutputKeyPrefix**KindleFireHD/Key**00000\.ts

 **Segment Filename Preview**  
The name of the first segment file, based on the value that you entered for Output Key\.

![\[Output Details, Part 1 screenshot.\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/)

## Output Details, Part 2<a name="job-settings-output-details-part-3"></a>

Use the settings in this section to specify information about the output files\.

 **\(Video Only\) Create Thumbnails**  
If you want Elastic Transcoder to create thumbnails for your videos, select **Yes**, and specify the format for the file names in the **Thumbnail Filename Pattern** field\. 

 **\(Video Only\) Thumbnail Filename Pattern**  
If you selected **Yes** for **Thumbnail Filename Pattern**, specify the format for the file names\. You can specify the following values in any sequence:  
+ **\{count\} \(Required\):** A five\-digit number beginning with **00001** that indicates where a given thumbnail appears in the sequence of thumbnails for a transcoded file\. You must include **\{count\}** somewhere in the field\. If you omit it, Elastic Transcoder automatically appends the count to the end of the file name, immediately before the file name extension \(\.jpg or \.png\)\. 
+ **\(Optional\) Literal values:** You can specify literal values anywhere in the field, for example, as a file name prefix or as a delimiter between `{resolution}` and `{count}`\.
+ \(Optional\) **\{resolution\}:** If you want Elastic Transcoder to include the resolution in the file name, include `{resolution}` in the field\. 
The **Thumbnail Filename Preview** field displays a sample of file names for thumbnails based on the value that you entered in **Thumbnail Filename Pattern**\.  
When creating thumbnails, Elastic Transcoder automatically saves the files in the format \(\.jpg or \.png\) that appears in the preset that you specified in [Preset](#job-settings-preset-id)\. Elastic Transcoder also appends the applicable file name extension\.

 **\(Video/Thumbnails Only, Optional\) Output Rotation**  
The number of degrees clockwise by which you want Elastic Transcoder to rotate the output relative to the input\. If you want Elastic Transcoder to automatically detect whether the input file is rotated, select **auto**\. Note, however, that Elastic Transcoder generally can only detect whether the output needs to be rotated if the file that you're transcoding contains rotation metadata\. 

![\[Output Details, Part 3 screenshot.\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/)

## Output Details, Part 3, Caption Settings<a name="job-settings-output-details-part-2"></a>

Use the settings in this section to specify information about captions for the output files\.

For more information on captions, see [Captions](captions.md)\.

 **\(Video Only\) Caption Format**  
The format you specify determines whether Elastic Transcoder generates an embedded or sidecar caption for this output\. If you leave this value blank, Elastic Transcoder returns an error\.  
+ **Embedded Caption Formats:** For MP4 containers, mov\-text and CEA\-708 are supported\. For MPEG\-TS containers, CEA\-708 is supported\. For other container types, no embedded caption formats are supported\.

  CEA\-708 captions are embedded in the H\.264 SEI user data of the stream\. Elastic Transcoder supports a maximum of one embedded format per output\.
+ **Sidecar Caption Formats:** Elastic Transcoder supports dfxp, scc, srt, and webvtt\. Fmp4 containers with Smooth playlists support only dfxp, and Elastic Transcoder creates a file with the extension `.ismt`\. Fmp4 containers with MPEG\-DASH playlists support only webvtt, and Elastic Transcoder creates a file with the extension `.vtt`\. If you want ttml or smpte\-tt compatible captions, specify dfxp as your output format\.

 **\(Video Only\) Captions Filename Pattern**  
The prefix for caption filenames, in the form *description*\-`{language}`, where:  
+ *description* is a description of the video\.
+ `{language}` is a literal value that Elastic Transcoder replaces with the two\- or three\-letter code for the language of the caption in the output file names\.
If you don't include `{language}` in the file name pattern, Elastic Transcoder automatically appends "`{language}`" to the value that you specify for the *description*\. In addition, Elastic Transcoder automatically appends the count to the end of the segment files\.  
For example, suppose you're transcoding into srt format\. When, you enter "Sydney\-\{language\}\-sunrise", and the language of the captions is English \(en\), the name of the first caption file will be `Sydney-en-sunrise00000.srt`\.

 **\(Video Only\) Captions Filename Preview**  
The name of the first caption file, based on the value that you entered for **Captions Filename Pattern**\. The preview uses the English ISO code "en" to show how `{language}` will look in your file name\.

![\[Output Details, Part 2 screenshot.\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/)

## \(Optional\) Output Encryption<a name="job-encryption-settings"></a>

You can specify encryption settings for any output files that you want to use for a transcoding job\. This includes the output file and any watermarks, thumbnails, album art, or captions that you want to use\. You must specify encryption settings for each file individually\.

 **Output Encryption**  
The encryption settings, if any, that you want Elastic Transcoder to apply to your output files\. If you choose to use encryption, you must specify a mode to use\. If you choose not to use encryption, Elastic Transcoder will write an unencrypted file to your Amazon S3 bucket\.

 **\(Required for file\-level Encryption\) Encryption Mode**  
The specific encryption mode that you want Elastic Transcoder to use when encrypting your output files individually\. Elastic Transcoder supports the following **Encryption Mode** options:  
+ **s3:** Amazon S3 creates and manages the keys used for encrypting your files\.

  For more information, see [Protecting Data Using Server\-Side Encryption](https://docs.aws.amazon.com/AmazonS3/latest/dev/serv-side-encryption.html) in the *Amazon Simple Storage Service Developer Guide*\.
+ **s3\-aws\-kms:** Amazon S3 calls AWS KMS, which creates and manages the keys that are used for encrypting your files\. If you specify **s3\-aws\-kms** and you don't want to use the default key, you must add the AWS\-KMS key that you want to use to your pipeline\.

  For more information, see [Protecting Data Using Server\-Side Encryption with AWS KMS\-Managed Keys ](https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingKMSEncryption.html) in the *Amazon Simple Storage Service Developer Guide*\.
+ **aes\-cbc\-pkcs7:** A padded cipher\-block mode of operation\.
+ **aes\-ctr:** AES Counter Mode\.
+ **aes\-gcm:** AES Galois Counter Mode, a mode of operation that is an authenticated encryption format, meaning that a file, key, or initialization vector that has been tampered with will fail the decryption process\.
If you chose one of the AES\-encryption modes, you must also specify the following three values \(all three must be base64\-encoded\):  
+ **Encryption Key**
+ **Encryption Key MD5**
+ **Encryption Initialization Vector**
If you chose one of the AES\-encryption modes, and you want Elastic Transcoder to generate a `128`\-bit AES encryption key for you, do not specify values for the **Encryption Key**, **Encryption Key MD5**, or **Encryption Initialization Vector**\. Once Elastic Transcoder has generated the key, you can retrieve the key by calling `ReadJob`\. The key is not included in the `CreateJobResponse` object\.  
For the AES modes, your media\-specific private encryption keys and your unencrypted data are never stored by AWS; therefore, it is important that you safely manage your encryption keys\. If you lose them, you won't be able to decrypt your data\.

 **\(Optional\) Encryption Key**  
If you want Elastic Transcoder to generate a key for you, leave this field blank\. Once Elastic Transcoder has generated the key, you can retrieve the key by calling **Read Job**\. The key is not included in the **Create Job Response** object\.  
If you choose to supply your own key, you must encrypt the key by using AWS KMS\. The key must be base64\-encoded, and it must be one of the following bit lengths before being base64\-encoded:  
`96` \(AES\-GCM only\), `128`, `192`, or `256`\.   
If you configured Elastic Transcoder to generate a key for you, Elastic Transcoder leaves this field blank in the **Create Job** response\. To retrieve your generated data encryption key, submit a **Read Job** request\.  
For more information about encrypting your key with AWS KMS, see [Encrypting and Decrypting Data](https://docs.aws.amazon.com/kms/latest/developerguide/programming-encryption.html) in the *AWS Key Management Service Developer Guide*\.

 **\(Required if an Encryption Key is supplied\) Encryption Key MD5**  
The MD5 digest of the key that you want Elastic Transcoder to use to encrypt your output file, and that you want Elastic Transcoder to use as a checksum to make sure your key was not corrupted in transit\. The key MD5 must be base64\-encoded, and it must be exactly 16 bytes before being base64\-encoded\.  
If Elastic Transcoder is generating your key for you, you must leave this field blank\.

 **\(Required if an Encryption Key is supplied\) Encryption Initialization Vector**  
The series of random bits created by a random bit generator, unique for every encryption operation, that you want Elastic Transcoder to use to encrypt your output files\. The initialization vector must be base64\-encoded, and it must be exactly 16 bytes before being base64\-encoded\.  
If Elastic Transcoder is generating your key for you, you must leave this field blank\.  
For more information, go to [Initialization Vector](http://en.wikipedia.org/wiki/Initialization_vector)\.

![\[Outputs Encryption screenshot.\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/)

## \(Video/Thumbnails Only\) Watermarks<a name="job-settings-watermarks"></a>

Information about the watermarks that you want Elastic Transcoder to add to the video during transcoding\. You can specify up to four watermarks for each output\. Settings for each watermark must be defined in the preset that you specify in **Preset** for the current output\.

Watermarks are added to the output video in the sequence in which you list them in the job output—the first watermark in the list is added to the output video first, the second watermark in the list is added next, and so on\. As a result, if the settings in a preset cause Elastic Transcoder to place all watermarks in the same location, the second watermark that you add will cover the first one, the third one will cover the second, and the fourth one will cover the third\.

For more information about watermarks, see [Watermarks](watermarks.md)\.

 **Preset Watermark ID**  
The ID of the watermark settings that Elastic Transcoder uses to add watermarks to the video during transcoding\. The settings are in the preset specified by **Preset** for the current output\. In that preset, the value of **Watermarks Id** tells Elastic Transcoder which settings to use\. 

 **Input Key for Preset Watermark Id**  
The name of the \.png or \.jpg file that you want to use for the watermark\. To determine which Amazon S3 bucket contains the specified file, Elastic Transcoder checks the pipeline specified by **Pipeline**; the **Input Bucket** object in that pipeline identifies the bucket\.  
If the file name includes a prefix, for example, **logos/128x64\.png**, include the prefix in the key\. If the file isn't in the specified bucket, Elastic Transcoder returns an error\.

![\[Watermarks screenshot.\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/)

## \(FLAC/MP3/MP4 Only\) Album Art<a name="job-settings-album-art"></a>

The album art to be associated with the output file, if any\.

To remove artwork or leave the artwork empty, you can either set **Artwork** to null, or set the **Merge Policy** to "Replace" and use an empty **Artwork** array\.

To pass through existing artwork unchanged, set the **Merge Policy** to "Prepend", "Append", or "Fallback", and use an empty **Artwork** array\.

**Note**  
Album art is available for audio\-only outputs in `flac`, `mp3`, or `mp4` containers\.

 **Album Art Merge Policy**  
A policy that determines how Elastic Transcoder will handle the existence of multiple album artwork files\.  
+ **Replace:** The specified album art will replace any existing album art\.
+ **Prepend:** The specified album art will be placed in front of any existing album art\.
+ **Append:** The specified album art will be placed after any existing album art\. 
+ **Fallback:** If the input file contains artwork, Elastic Transcoder will use that artwork for the output\. If the input does not contain artwork, Elastic Transcoder will use the specified album art file\.

 **Album Art Artwork**  
The file to be used as album art\. There can be multiple artworks associated with an audio file, to a maximum of 20\.

 **Album Art Input Key**  
The name of the file to be used as album art\. To determine which Amazon S3 bucket contains the specified file, Elastic Transcoder checks the pipeline specified by **PipelineId**; the **InputBucket** object in that pipeline identifies the bucket\.  
If the file name includes a prefix, for example, `cooking/pie.jpg`, include the prefix in the key\. If the file isn't in the specified bucket, Elastic Transcoder returns an error\.

 **Album Art Format**  
The format of album art, if any\. Valid formats are `jpg` and `png`\.

 **Album Art Max Width**  
The maximum width of the output album art in pixels\. If you specify `auto`, Elastic Transcoder uses 600 as the default value\. If you specify a numeric value, enter an even integer between 32 and 4096, inclusive\.

 **Album Art Max Height**  
The maximum height of the output album art in pixels\. If you specify `auto`, Elastic Transcoder uses 600 as the default value\. If you specify a numeric value, enter an even integer between 32 and 3072, inclusive\.

 **Album Art Sizing Policy**  
A value that controls scaling of the output album art:  
+ **Fit:** Elastic Transcoder scales the output art so it matches the value that you specified in either **MaxWidth** or **MaxHeight** without exceeding the other value\.
+ **Fill:** Elastic Transcoder scales the output art so it matches the value that you specified in either **MaxWidth** or **MaxHeight** and matches or exceeds the other value\. Elastic Transcoder centers the output art and then crops it in the dimension \(if any\) that exceeds the maximum value\. 
+ **Stretch:** Elastic Transcoder stretches the output art to match the values that you specified for **MaxWidth** and **MaxHeight**\. If the relative proportions of the input art and the output art are different, the output art will be distorted\.
+ **Keep:** Elastic Transcoder does not scale the output art\. If either dimension of the input art exceeds the values that you specified for **MaxWidth** and **MaxHeight**, Elastic Transcoder crops the output art\.
+ **ShrinkToFit:** Elastic Transcoder scales the output art down so that its dimensions match the values that you specified for at least one of **MaxWidth** and **MaxHeight** without exceeding either value\. If you specify this option, Elastic Transcoder does not scale the art up\.
+ **ShrinkToFill:** Elastic Transcoder scales the output art down so that its dimensions match the values that you specified for at least one of **MaxWidth** and **MaxHeight** without dropping below either value\. If you specify this option, Elastic Transcoder does not scale the art up\.
The following table shows possible effects of **SizingPolicy** settings on the output album art:      
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/job-settings.html)

 **Album Art Padding Policy**  
When you set **PaddingPolicy** to `Pad`, Elastic Transcoder might add white bars to the top and bottom and/or left and right sides of the output album art to make the total size of the output art match the values that you specified for **MaxWidth** and **MaxHeight**\. For more information, see the table at `AlbumArt:Art:SizingPolicy`\.

![\[Artwork screenshot.\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/)

![\[Artwork Encryption screenshot.\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/)

## \(Optional\) User Metadata<a name="job-settings-user-metadata"></a>

User\-defined metadata that you want to associate with an Elastic Transcoder job\.  You specify metadata in `key/value` pairs\. You can use the `key/value` pairs to track details about a file, for example, `Season 1: Episode 3`\.

You can add up to 10 key/value pairs to each job\. Elastic Transcoder does not guarantee that `key/value` pairs are returned in the same order in which you specify them\.

**Metadata Key**  
The key of the metadata `key/value` pair that you want returned with the output file\. Each key must be a unique string between `1-128` characters, and must use only characters from the following list:  
+ `0-9`
+ `A-Z` and `a-z`
+ `Space`
+ The following symbols: `_.:/=+-%@`
You can use keys as a numbering system for organizing your metadata, for storing an extra 128 characters of metadata, or for labeling the metadata stored in the **value**\. If you want to use only value metadata, you can put throw\-away strings in your keys such as `key1`, and ignore the keys when you retrieve your metadata from Elastic Transcoder\.   
You must specify unique strings for all of the keys in a job\. If the same string is used for more than one key in a job, Elastic Transcoder returns only one of the key/value pairs that use that key\. There is no way to guarantee which value is returned\.

**Metadata Value**  
The value of the metadata `key/value` pair that you want returned with your job\. Each value must be a string between `0-256` characters, and must use only characters from the following list:   
+ `0-9`
+ `A-Z` and `a-z`
+ `Space`
+ The following symbols: `_.:/=+-%@`

![\[User Metadata screenshot.\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/)

## \(Fragmented MP4/MPEG\-TS Outputs Only\) Playlist<a name="job-settings-playlist"></a>

If you choose a preset in the **Preset** list for which the value of **Container** is either **ts** \(MPEG\-TS\) or **fmp4** \(Fragmented MP4\), use the settings in this section to specify information about the master playlists that you want Elastic Transcoder to create\. We recommend that you create at most one master playlist per playlist format\. 

 **Master Playlist Name**  
The name that you want Elastic Transcoder to assign to a master playlist\. If the name includes a `/` character, the section of the name before the last **/** must be identical for all **Playlist Names**\. If you create more than one master playlist, each must have a unique name\.  
Elastic Transcoder automatically appends the relevant file extension to the file name \(**\.m3u8** for **HLSv3** and **HLSv4** playlists, **\.mpd** for **MPEG\-DASH** playlists, and **\.ism** and **\.ismc** for **Smooth** playlists\)\. If you include a file extension in **Master Playlist Name**, the file name will have two extensions\.
Any segment duration settings, clip settings, or caption settings must be the same for all outputs in the playlist\. For **Smooth** playlists, the **Audio:Profile**, **Video:Profile**, and **Frame Rate** to **Maximum Number of Frames Between Keyframes** ratio must be the same for all outputs\.

 **Playlist Format**  
The format for the playlist\. Valid formats include **HLSv3**, **HLSv4**, **MPEG\-DASH**, and **Smooth**\.

 **Outputs in Master Playlist**  
For each output in this job that you want to include in a master playlist, the value of the **Output Key** field\. If you include more than one output in a playlist, the value of **Segment Duration** for all of the outputs must be the same\.  
For **HLSv4** master playlists, Elastic Transcoder chooses which combinations of audio and video inputs will be linked in the output playlists\. The first audio and video inputs will be linked and rendered as the default playback experience, allowing you to choose your preferred playback default\. For other individual playlists in the master playlist, Elastic Transcoder chooses which audio and video bit rate combinations will provide the best playback\.

![\[Playlist screenshot.\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/)

## \(Fragmented MP4/MPEG\-TS Outputs Only, Optional\) HLS Content Protection<a name="job-settings-hls-cp"></a>

**Note**  
HLS content protection encrypts each individual segment of a file, and Elastic Transcoder does not support HLS content protection combined with file\-level encryption\.

If you choose a preset in the **Preset** list for which the value of **Container** is either **ts** \(MPEG\-TS\) or **fmp4** \(Fragmented MP4\) with a **Smooth** playlist, you can specify encryption settings for streaming your file\. You cannot combine data stream encryption with file or caption encryption\. If you choose to encrypt your data stream, use the settings in this section to specify information about the data stream encryption\.

To use HLS content protection, you must have a web server that can authenticate sessions \(such as Amazon Elastic Compute Cloud\), a way to distribute your streamed media files \(such as Amazon CloudFront\), and a way to play encrypted streamed media \(such as a player\-enabled browser\)\.

**Method**  
The content protection method for your output\. The only valid value is:  
`aes-128`\.  
This value will be written into the `method` attribute of the `EXT-X-KEY` metadata tag in the output playlist\.

**Key**  
If you want Elastic Transcoder to generate a key for you, leave this field blank\. Once Elastic Transcoder has generated the key, you can retrieve the key by calling `ReadJob`\. The key is not included in the `CreateJobResponse` object\.  
If you choose to supply your own key, you must encrypt the key by using AWS KMS\. The key must be base64\-encoded, and it must be one of the following bit lengths before being base64\-encoded:  
`96` \(AES\-GCM only\), `128`, `192`, or `256`\.   
If you configured Elastic Transcoder to generate a key for you, Elastic Transcoder leaves this field blank in the `CreateJob` response\. To retrieve your generated data encryption key, submit a `ReadJob` request\.  
For more information about encrypting your key with AWS KMS, see [Encrypting and Decrypting Data](https://docs.aws.amazon.com/kms/latest/developerguide/programming-encryption.html) in the *AWS Key Management Service Developer Guide*\.  
If you choose an HLS content protection method of `aes-128`, the key must be `128` bits\. If you have a `relative` **KeyStoragePolicy** set, Elastic Transcoder writes your key to an Amazon S3 bucket with Amazon S3 server\-side encryption\.

** Key MD5 \(Required if an Encryption Key is supplied\)**  
The MD5 digest of the key that you want Elastic Transcoder to use to encrypt your output file, and that you want Elastic Transcoder to use as a checksum to make sure your key was not corrupted in transit\. The key MD5 must be base64\-encoded, and it must be exactly 16 bytes before being base64\-encoded\.  
If Elastic Transcoder is generating your key for you, you must leave this field blank\.

**Initialization Vector \(Required if an Encryption Key is supplied\)**  
The series of random bits created by a random bit generator, unique for every encryption operation, that you want Elastic Transcoder to use to encrypt your output files\. The initialization vector must be base64\-encoded, and it must be exactly 16 bytes before being base64\-encoded\.  
If Elastic Transcoder is generating your key for you, you must leave this field blank\.  
For more information, go to [Initialization Vector](http://en.wikipedia.org/wiki/Initialization_vector)\.

**License Acquisition URL**  
The location of the license key required to decrypt your HLS playlist\. The URL must be an absolute path, and is referenced in the URI attribute of the EXT\-X\-KEY metadata tag in the playlist file\. For example:  

```
https://www.example.com/exampleKey/
```

**Key Storage Policy**  
Specify whether you want Elastic Transcoder to write your HLS license key to an Amazon S3 bucket\. If you choose `WithVariantPlaylists`, Elastic Transcoder will write your encrypted key into the same Amazon S3 bucket as the associated playlist\.  
If you chose `NoStore`, Elastic Transcoder will not store your key\. You are responsible for storing it and providing it to your users by giving them the **License Acquisition URL** where you are storing the key\.

![\[Playlist HLS Content Protection screenshot.\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/)

## \(HLSv3 and Smooth Playlists Only, Optional\) Digital Rights Management<a name="job-settings-drm"></a>

If you choose a preset in the **Preset** list for which the value of **Container** is either **fmp4** \(Fragmented MP4\) or **ts** \(MPEG\-TS\), and your **Playlist** is of type **HLSv3** or **Smooth**, you can specify DRM settings for your file\. If you choose to use DRM to protect your files, use the settings in this section to specify information about your DRM settings\.

To use DRM, you must have a license provider server that can track and grant licenses, a web server that can authenticate users, a package server to encrypt your files with DRM \(such as Elastic Transcoder\), a way to distribute your media files \(such as Amazon CloudFront\), and a way to play DRM\-protected media \(such as a DRM\-enabled player\)\.

**Note**  
PlayReady DRM, HLS content protection, and output encryption are mutually exclusive options\.

 **\(Optional\) PlayReady DRM**  
The DRM settings used to restrict who can watch your files\. This is done by including a PlayReady DRM header in your output playlist\. This is not usable for artwork, captions, thumbnails, or watermarks\. PlayReady DRM encrypts your media files using `aes-ctr` encryption\.  
If you use DRM for an **HLSv3** playlist, your outputs must have a master playlist\.  
For more information, see [Digital Rights Management](drm.md)\.

 **\(Required for DRM protection\) DRM Format**  
The DRM format for your output playlist\. Valid formats are `discretix-3.0` and `microsoft`\.  
For playlists of type **Smooth**, specify `microsoft`\. For playlists of type **HLSv3**, specify `discretix-3.0`\.

 **\(Required for DRM protection\) DRM Key**  
The DRM key for your file, provided by your DRM license provider\. The key must be base64\-encoded, and it must be one of the following bit lengths before being base64\-encoded:  
`128`, `192`, or `256`\.   
The key must also be encrypted by using AWS KMS\. For more information, see [Encrypting and Decrypting Data](https://docs.aws.amazon.com/kms/latest/developerguide/programming-encryption.html) in the *AWS Key Management Service Developer Guide*\.

 **\(Required for DRM protection\) DRM Key Id**  
The ID for your DRM key, so that your DRM license provider knows which key to provide\.  
The key ID must be provided in big endian, and Elastic Transcoder will convert it to little endian before inserting it into the PlayReady DRM headers\. If you are unsure whether your license server provides your key ID in big or little endian, check with your DRM provider\.

 **\(Required for DRM protection\) DRM Key MD5**  
The MD5 digest of the key used for DRM on your file, and that you want Elastic Transcoder to use as a checksum to make sure your key was not corrupted in transit\. The key MD5 must be base64\-encoded, and it must be exactly 16 bytes before being base64\-encoded\.

 **\(Required for DRM protection\) DRM Initialization Vector**  
The series of random bits created by a random bit generator, unique for every encryption operation, that you want Elastic Transcoder to use to encrypt your files\. The initialization vector must be base64\-encoded, and it must be exactly 8 bytes long before being base64\-encoded\. If no initialization vector is provided, Elastic Transcoder generates one for you\.  
For more information, go to [Initialization Vector](http://en.wikipedia.org/wiki/Initialization_vector)\.

 **\(Required for DRM protection\) DRM License Acquisition Url**  
The location of the license key required to play DRM content\. The URL must be an absolute path, and is referenced by the PlayReady header\. The PlayReady header is referenced in the protection header of the client manifest for Smooth Streaming outputs, and in the EXT\-X\-DXDRM and EXT\-XDXDRMINFO metadata tags for HLS playlist outputs\. An example URL looks like this:  

```
https://www.example.com/exampleKey/
```

![\[Playlist Digital Rights Management screenshot.\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/)