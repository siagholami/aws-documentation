# Settings that You Specify When You Create an Elastic Transcoder Preset<a name="preset-settings"></a>

When you create a preset, you specify the following values\.

**Topics**
+ [General Settings](#preset-settings-general)
+ [Video Settings](#preset-settings-video)
+ [Watermark Settings](#preset-settings-watermarks)
+ [Audio Settings](#preset-settings-audio)
+ [Thumbnail Settings](#preset-settings-thumbnails)

## General Settings<a name="preset-settings-general"></a>

 **Start with Preset**  
The preset that you want to use as a starting point for your new preset\. Elastic Transcoder copies the values from the preset that you select into the fields for the new preset\. You can choose either one of the default Elastic Transcoder presets or a preset that you created\. 

 **Name**  
The name of the preset\. We recommend that the name be unique within the AWS account, but uniqueness is not enforced\. The maximum length is 40 characters\. 

 **Description**  
A description of the preset\. The maximum length is 255 characters\.

 **Container**  
The container type for the output file\. Valid values are **flac**, **flv**, **fmp4**, **gif**, **mp2**, **mp3**, **mp4**, **mpg**, **mxf**, **oga**, **ogg**, **ts**, **wav**, and **webm**\. The following table shows the supported codecs for containers\.      
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/preset-settings.html)

![\[General Settings screenshot.\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/)

## Video Settings<a name="preset-settings-video"></a>

 **Codec**  
The video codec for the output file\. Valid values are  **gif**, **H\.264**, **mpeg2**, **vp8**, and **vp9**\. The following table shows the available combinations of containers and video codecs\.      
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/preset-settings.html)
For more information about the H\.264 video\-compression format, go to the Wikipedia page on [H\.264/MPEG\-4 AVC](http://en.wikipedia.org/wiki/H.264/MPEG-4_AVC)\.  
For more information about VP8, go to [VP8](https://en.wikipedia.org/wiki/VP8)\. For more information about VP9, go to [VP9](https://en.wikipedia.org/wiki/VP9)\.

 **\(H\.264/VP8 Only\) Profile**  
The profile that you want to use for the output video\. When the video codec is **H\.264**, Elastic Transcoder supports the following profiles:  
+ **baseline:** The profile most commonly used for videoconferencing and for mobile applications\.
+ **main:** The profile used for standard\-definition digital TV broadcasts\.
+ **high:** The profile used for high\-definition digital TV broadcasts and for Blu\-ray discs\.
For more information about H\.264 profiles, see [Profiles](http://en.wikipedia.org/wiki/H.264/MPEG-4_AVC#Profiles) in the Wikipedia entry "H\.264/MPEG\-4 AVC\."  
When the video codec is **VP8**, Elastic Transcoder supports values of **0**, **1**, **2**, and **3**\.

 **\(H\.264 Only\) Level**  
The H\.264 level that you want to use for the output video\. Select the applicable value\.  
For more information about levels, see [Levels](http://en.wikipedia.org/wiki/H.264/MPEG-4_AVC#Levels) in the Wikipedia entry "H\.264/MPEG\-4 AVC\."

 **\(H\.264 Only\) Maximum Number of Reference Frames**  
The maximum number of previously decoded frames to use as a reference for decoding future frames\. If you enter a value greater than the recommended value based on the values that you specified for [Max Height](#preset-settings-video-max-height), [Max Height](#preset-settings-video-max-height), and [Level](#preset-settings-video-level), Elastic Transcoder displays a message that contains the recommended value\. For a detailed explanation, including the calculation that Elastic Transcoder performs, see MaxReferenceFrames in the topic [Create Preset](create-preset.md)\. 

 **\(Optional, H\.264/MPEG2/VP8/VP9 Only\) Maximum Bit Rate**  
The maximum number of kilobits per second in the output video\. Specify a value between 16 and 62,500, inclusive\.  
If you specify **auto** for **Bit Rate**, Elastic Transcoder uses the bit rate of the input video as the average bit rate of the output video\. **Maximum Bit Rate** allows you to cap the bit rate of the output video, which is useful when the maximum bit rate supported by a target device is lower than the bit rate of the input video\. Reducing the maximum bit rate might reduce the quality of the video\.

 **\(Optional, H\.264/MPEG2/VP8/VP9 Only\) Buffer Size**  
The maximum number of kilobits in any *x* seconds of the output video\. This window is commonly 10 seconds, the standard segment duration when you're using MPEG\-TS for the container type of the output video\. Specify an integer greater than 0\. If you specify **Maximum Bit Rate** and omit **Buffer Size**, Elastic Transcoder sets **Buffer Size** to 10 times the value of **Maximum Bit Rate**\.

 **\(Optional, H\.264/MPEG2 Only\) Interlaced Mode**  
The interlace mode for the output video\.  
Interlaced video is used to double the perceived frame rate for a video by interlacing two fields \(one field on every other line, the other field on the other lines\) so that the human eye registers multiple pictures per frame\. Interlacing reduces the bandwidth required for transmitting a video, but can result in blurred images and flickering\.  
The two sets of lines are known as fields, and an interlaced frame splits two images across the fields:  

![\[Interlace Fields.\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/)
Valid values are **Progressive** \(no interlacing, top to bottom\), **Top First** \(top field first\), **Bottom First** \(bottom field first\), and **Auto**\.  
If no **InterlaceMode** is specified, Elastic Transcoder uses **Progressive** for the output\. If **Auto** is specified, Elastic Transcoder interlaces the output\.  
For more information, go to the Wikipedia page [Interlaced video](http://en.wikipedia.org/wiki/Interlaced_video)\.

 **\(Optional, H\.264/MPEG2 Only\) Color Space Conversion Mode**  
The color space conversion Elastic Transcoder applies to the output video\. Color spaces are the algorithms used by the computer to store information about how to render color\. **Bt\.601** is the standard for standard definition video, while **Bt\.709** is the standard for high definition video\.  
Valid values are **None**, **Bt709toBt601**, **Bt601toBt709**, and **Auto**\.  
If you chose **Auto** for **ColorSpaceConversionMode** and your output is interlaced, your frame rate is one of `23.97`, `24`, `25`, `29.97`, `50`, or `60`, your **SegmentDuration** is null, and you are using one of the resolution changes from the graph below, Elastic Transcoder applies the following color space conversions:      
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/preset-settings.html)
Elastic Transcoder may change the behavior of the **ColorspaceConversionMode** **Auto** mode in the future\. All outputs in a playlist must use the same **ColorSpaceConversionMode**\.
If you do not specify a **ColorSpaceConversionMode**, Elastic Transcoder does not change the color space of a file\.  
If you are unsure what **ColorSpaceConversionMode** was applied to your output file, you can check the **AppliedColorSpaceConversion** parameter included in your job response\. If your job does not have an **AppliedColorSpaceConversion** in its response, no **ColorSpaceConversionMode** was applied\.  
For more information about color space, go to the Wikipedia page [Color space](http://en.wikipedia.org/wiki/Color_space)\. For more information about **Bt\.601** and **Bt\.709**, go to the Wikipedia pages [Rec\. 601](http://en.wikipedia.org/wiki/Rec._601) and [Rec\. 709](http://en.wikipedia.org/wiki/Rec._709)\.

 **\(MPEG2 Only\) Chroma Subsampling**  
The sampling pattern for the chroma \(color\) channels of the output video\. Valid values are **yuv420p** and **yuv422p**\.  
**yuv420p** samples the chroma information of every other horizontal and every other vertical line, **yuv422p** samples the color information of every horizontal line and every other vertical line\.  
To learn more about chroma subsampling, go to the Wikipedia page [Chroma subsampling](http://en.wikipedia.org/wiki/Chroma_subsampling)\.

 **\(Gif Only\) Loop Count**  
The number of times you want the output gif to loop\.  
Valid values are **Infinite** and integers between **0** and **100**, inclusive\.

 **\(H\.264/MPEG2/VP8 Only\) Maximum Number of Frames Between Keyframes **  
The maximum number of frames between key frames\. Not applicable for containers of type **gif**\. Key frames are fully encoded frames; the frames between key frames are encoded based, in part, on the content of the key frames\. The value is an integer formatted as a string; valid values are between 1 \(every frame is a key frame\) and 100000, inclusive\. A higher value results in higher compression but might also discernibly decrease video quality\.   
For Smooth outputs, the **Frame Rate** must have a constant ratio to the **Maximum Number of Frames Between Keyframes**\. This allows Smooth playlists to switch between different quality levels while the file is being played\.  
For example, an input file can have a **Frame Rate** of 30 with a **Maximum Number of Frames Between Keyframes** of 90\. The output file then needs to have a ratio of 1:3\. Valid outputs would have **Frame Rates** of 30, 25, and 10, and **Maximum Number of Frames Between Keyframes** of 90, 75, and 30 respectively\.  
Alternately, this can be achieved by setting **Frame Rate** to auto and having the same values for **Video Max Frame Rate** and **Maximum Number of Frames Between Keyframes**\.  
For more information about key frames, see the Wikipedia entry [Video compression picture types](http://en.wikipedia.org/wiki/Video_compression_picture_types)\.

 **\(H\.264/MPEG2/VP8 Only\) Fixed Number of Frames Between Keyframes **  
Whether to use a fixed value for [Fixed Number of Frames Between Keyframes](#preset-settings-video-fixed-gop):  
+ **Yes:** Elastic Transcoder uses the value of [Maximum Number of Frames Between Keyframes](#preset-settings-video-key-frames-max-dist) for the distance between key frames \(the number of frames in a group of pictures, or GOP\)\.
+ **No:** The distance between key frames can vary\.
**Fixed Number of Frames Between Keyframes** must be set to `true` for **fmp4** containers\.

 **Bit Rate**  
The bit rate of the video stream in the output video, in kilobits/second\. You can configure variable bit rate or constant bit rate encoding:  
+  **Variable bit rate encoding:** Specify **auto\. ** Elastic Transcoder optimizes the bit rate and maintains a consistent quality for each frame of the output\. 
+ **Constant bit rate encoding:** Specify the bit rate\.
Valid values for the video bit rate depend on the value that you chose for [Codec](#preset-settings-video-codec):  
+ **H\.264:** Valid values depend on the values of [Level](#preset-settings-video-level) and [Profile](#preset-settings-video-profile)\. We recommend that you specify a value less than or equal to the maximum H\.264\-compliant value listed in the following table for your level and profile:
+ **VP8:** do not use the following table; **Level** applies only when the video codec is H\.264\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/preset-settings.html)

 **Frame Rate**  
The frames per second for the video stream in the output video\. Select the applicable value\.  
If you specify **auto**, Elastic Transcoder uses the detected frame rate of the input source\. If you specify a frame rate, we recommend that you perform the following calculation:   
**Frame rate = maximum recommended decoding speed in luma samples/second / \(Video Max Width\) \* \(Video Max Height\)**  
where **maximum recommended decoding speed in luma samples/second** is less than or equal to the maximum value listed in the following table, based on the value that you specified for [Level](#preset-settings-video-level)\.  
If you enter a value greater than the recommended value based on the values that you specified for [Max Width](#preset-settings-video-max-width), [Max Height](#preset-settings-video-max-height), and [Level](#preset-settings-video-level), Elastic Transcoder displays a message that contains the recommended value\.
For Smooth outputs, the **Frame Rate** must have a constant ratio to the **Maximum Number of Frames Between Keyframes**\. For example, if you specify an input file with a **Frame Rate** of 30 and a **Maximum Number of Frames Between Keyframes** of 90, the **Frame Rate** and **Maximum Number of Frames Between Keyframes** of the outputs must also have a ratio of 1:3\.      
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/preset-settings.html)

 **Video Max Frame Rate**  
If you specify `auto` for **Frame Rate**, Elastic Transcoder uses the frame rate of the input video for the frame rate of the output video, up to the maximum frame rate\. If you do not specify a **Video Max Frame Rate**, Elastic Transcoder will use a default of `30`\.  
Specify the maximum frame rate that you want Elastic Transcoder to use when the frame rate of the input video is greater than either the desired maximum frame rate of the output video or the default maximum frame rate\.  
Elastic Transcoder uses the highest supported frame rate that meets both of the following criteria:  
+ The frame rate is less than or equal to the maximum frame rate\.
+ The frame rate divides into the input frame rate evenly, with no remainder\.
 For example, if you have an input file with a frame rate of 50 and specify a value of 30 for **Video Max Frame Rate**, Elastic Transcoder produces an output video for which the frame rate is 25 frames per second, because 25 is less than 30, and 50 divided by 25 is 2\.

 **Max Width**  
The maximum width of the output video in pixels\. If you specify **auto**, Elastic Transcoder uses 1920 \(Full HD\) as the default value\. If you specify a numeric value, enter an even integer between 128 and 4096\.  
For more information, see [Max Height](#preset-settings-video-max-height)\.

 **Max Height**  
The maximum height of the output video in pixels\. If you specify **auto**, Elastic Transcoder uses 1080 \(Full HD\) as the default value\. If you specify a numeric value, enter an even integer between 96 and 3072\.  
**If you specified **H\.264** for [Codec](#preset-settings-video-codec)** We recommend that you specify values for **Max Width** and **Max Height** so the product of the two values is less than or equal to the applicable value in the following table\.  
If you specified **VP8** for [Codec](#preset-settings-video-codec), do not use the following table; **Level** applies only when the video codec is H\.264\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/preset-settings.html)

 **Sizing Policy**  
Specify one of the following values to control scaling of the output video:  
+ **Fit:** Elastic Transcoder scales the output video so it matches the value that you specified in either **Max Width** or **Max Height** without exceeding the other value\.
+ **Fill:** Elastic Transcoder scales the output video so it matches the value that you specified in either **Max Width** or **Max Height** and matches or exceeds the other value\. Elastic Transcoder centers the output video and then crops it in the dimension \(if any\) that exceeds the maximum value\. 
+ **Stretch:** Elastic Transcoder stretches the output video to match the values that you specified for **Max Width** and **Max Height**\. If the relative proportions of the input video and the output video are different, the output video will be distorted\.
+ **Keep:** Elastic Transcoder does not scale the output video\. If either dimension of the input video exceeds the values that you specified for **Max Width** and **Max Height**, Elastic Transcoder crops the output video\.
+ **ShrinkToFit:** Elastic Transcoder scales the output video down so that its dimensions match the values that you specified for at least one of **Max Width** and **Max Height** without exceeding either value\. If you specify this option, Elastic Transcoder does not scale the video up\.
+ **ShrinkToFill:** Elastic Transcoder scales the output video down so that its dimensions match the values that you specified for at least one of **Max Width** and **Max Height** without dropping below either value\. If you specify this option, Elastic Transcoder does not scale the video up\.
The following table shows possible effects of **Sizing Policy** settings on the output video:      
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/preset-settings.html)

 **Padding Policy**  
When you set **PaddingPolicy** to **Pad**, Elastic Transcoder might add black bars to the top and bottom and/or left and right sides of the output video to make the total size of the output video match the values that you specified for **Max Width** and **Max Height**\. For more information, see the table at [Sizing Policy](#preset-settings-video-sizing-policy)\.

 **Display Aspect Ratio**  
The value that Elastic Transcoder adds to the metadata in the output video\. If you set **Display Aspect Ratio** to **auto**, Elastic Transcoder chooses an aspect ratio that ensures square pixels\. If you specify another option, Elastic Transcoder sets that value in the output video\. 

![\[Codec Options screenshot.\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/)

![\[Codec Parameters screenshot.\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/)

![\[General Settings screenshot.\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/)

![\[Gif Settings screenshot.\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/)

## Watermark Settings<a name="preset-settings-watermarks"></a>

Use the settings in this section to specify the size, position, scale, and opacity of graphics that you want Elastic Transcoder to overlay over videos that are transcoded using this preset\. You can specify settings for up to four watermarks\. Watermarks appear for the duration of the transcoded video\. 

Watermarks can be in \.png or \.jpg format\. If you want to display a watermark that is not rectangular, use the \.png format, which supports transparency\.

When you create a job that uses this preset, you specify the \.png or \.jpg graphics that you want Elastic Transcoder to include in the transcoded videos\. Elastic Transcoder does not require you to specify as many watermarks in each job output as you specified in the corresponding preset\. For example, you might specify settings for four watermarks in a preset and specify only one watermark in a job output\. 

To configure watermark settings so your graphic is not distorted, set the value of **Sizing Policy** to **Shrink to Fit**, and set the values of **Maximum Width** and **Maximum Height** to the same percentage\. If you want the graphic to appear in the same size as the original, set **Maximum Width** and **Maximum Height** to 100%\.

For more information, see [Watermarks](watermarks.md)\.

**Id**  
A unique identifier for the settings for one watermark\. The value of **Id** can be up to 40 characters long\.

**Maximum Width **  
The maximum width of the watermark in one of the following formats:  
+ *number of pixels* **px**: The minimum value is 16 pixels, and the maximum value is the value of **MaxHeight**\. 
+ *integer percentage* **%**: The range of valid values is 0 to 100\. Use the value of **Target** to specify whether you want Elastic Transcoder to include the black bars that are added by Elastic Transcoder, if any, in the calculation\.
If you specify the value in pixels, it must be less than or equal to the value of **MaxHeight**\.

**Maximum Height **  
The maximum height of the watermark in one of the following formats:  
+ *number of pixels* **px**: The minimum value is 16 pixels, and the maximum value is the value of **MaxHeight**\. 
+ *integer percentage* **%**: The range of valid values is 0 to 100\. Use the value of **Target** to specify whether you want Elastic Transcoder to include the black bars that are added by Elastic Transcoder, if any, in the calculation\.
If you specify the value in pixels, it must be less than or equal to the value of **MaxHeight**\.

**Sizing Policy **  
A value that controls scaling of the watermark:  
+ **Fit:** Elastic Transcoder scales the watermark so it matches the value that you specified in either **Maximum Width** or **Maximum Height** without exceeding the other value\.
+ **Stretch:** Elastic Transcoder stretches the watermark to match the values that you specified for **Maximum Width** and **Maximum Height**\. If the relative proportions of the watermark and the values of **Maximum Width** and **Maximum Height** are different, the watermark will be distorted\.
+ **Shrink to Fit:** Elastic Transcoder scales the watermark down so that its dimensions match the values that you specified for at least one of **Maximum Width** and **Maximum Height** without exceeding either value\. If you specify this option, Elastic Transcoder does not scale the watermark up\.

**Horizontal Alignment**  
The horizontal position of the watermark\. To position the watermark with respect to the left or right border, also specify a non\-zero value for **Horizontal Offset**:  
+ **Left:** The left edge of the watermark is aligned with the left border of the video\.
+ **Right:** The right edge of the watermark is aligned with the right border of the video\.
+ **Center:** The watermark is centered between the left and right borders\.

**Horizontal Offset **  
The amount by which you want the horizontal position of the watermark to be offset from the position specified by **Horizontal Alignment**:   
+ *number of pixels* **px**: The minimum value is 0 pixels, and the maximum value is the value of **MaxHeight**\. 
+ *integer percentage* **%**: The range of valid values is 0 to 100\.
For example, if you specify **Left** for **Horizontal Alignment** and **5px** for **Horizontal Offset**, the left side of the watermark appears 5 pixels from the left border of the output video\.  
**HorizontalOffset** is only valid when the value of **Horizontal Alignment** is **Left** or **Right**\.  
If you specify an offset that causes the watermark to extend beyond the left or right border and Elastic Transcoder has not added black bars, the watermark is cropped\. If Elastic Transcoder has added black bars, the watermark extends into the black bars\. If the watermark extends beyond the black bars, it is cropped\.  
Use the value of **Target** to specify whether you want Elastic Transcoder to include the black bars that are added by Elastic Transcoder, if any, in the offset calculation\.

**Vertical Alignment **  
The vertical position of the watermark\. To position the watermark with respect to the top or bottom border, also specify a non\-zero value for **Vertical Offset**:  
+ **Top:** The top edge of the watermark is aligned with the top border of the video\.
+ **Bottom:** The bottom edge of the watermark is aligned with the bottom border of the video\.
+ **Center:** The watermark is centered between the top and bottom borders\.

**Vertical Offset **  
The amount by which you want the vertical position of the watermark to be offset from the position specified by **Vertical Alignment**:   
+ *number of pixels* **px**: The minimum value is 0 pixels, and the maximum value is the value of **Maximum Height**\. 
+ *integer percentage* **%**: The range of valid values is 0 to 100\.
For example, if you specify **Top** for **Vertical Alignment** and **5px** for **Vertical Offset**, the top of the watermark appears 5 pixels from the top border of the output video\.  
**Vertical Offset** is only valid when the value of **Vertical Alignment** is **Top** or **Bottom**\.  
If you specify an offset that causes the watermark to extend beyond the top or bottom border and Elastic Transcoder has not added black bars, the watermark is cropped\. If Elastic Transcoder has added black bars, the watermark extends into the black bars\. If the watermark extends beyond the black bars, it is cropped\.  
Use the value of **Target** to specify whether you want Elastic Transcoder to include the black bars that are added by Elastic Transcoder, if any, in the offset calculation\.

**Opacity**  
A percentage that indicates how much you want a watermark to obscure the video in the location where it appears\. Valid values are 0 \(the watermark is invisible\) to 100 \(the watermark completely obscures the video in the specified location\)\.  
Elastic Transcoder supports transparent `.png` graphics\. If you use a transparent `.png`, the transparent portion of the video appears as if you had specified a value of 0 for **Opacity**\. The `.jpg` file format doesn't support transparency\.

**Target**  
A value that determines how Elastic Transcoder interprets values that you specified for the watermark settings **Horizontal Offset**, **Vertical Offset**, **Maximum Width**, and **Maximum Height**:   
+ **Content:** **Horizontal Offset** and **Vertical Offset** values are calculated based on the borders of the video **excluding** black bars added by Elastic Transcoder, if any\.

  In addition, **Maximum Width** and **Maximum Height**, if specified as a percentage, are calculated based on the borders of the video **excluding** black bars added by Elastic Transcoder, if any\.
+ **Frame:** **Horizontal Offset** and **Vertical Offset** values are calculated based on the borders of the video **including** black bars added by Elastic Transcoder, if any\.

  In addition, **Maximum Width** and **Maximum Height**, if specified as a percentage, are calculated based on the borders of the video **including** black bars added by Elastic Transcoder, if any\.

![\[Watermark Settings screenshot.\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/)

## Audio Settings<a name="preset-settings-audio"></a>

 **Codec**  
The audio codec for the output file\. Valid values are `AAC`, `flac`, `mp2`, `mp3`, `pcm`, and `vorbis`\. The following table shows the available combinations of containers and audio codecs\.      
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/preset-settings.html)

 **\(AAC Only\) Profile**  
If you specified **AAC** for **Audio:Codec**, choose the AAC profile for the output file\. Elastic Transcoder supports the following profiles:  
+ **auto**: If you specify **auto**, Elastic Transcoder selects the profile based on the bit rate selected for the output file\.
+ **AAC\-LC**: The most common AAC profile\. Use for bit rates larger than 64 kbps\. For more information, see [ Advanced Audio Coding\.](http://en.wikipedia.org/wiki/Advanced_Audio_Coding)
+ **HE\-AAC**: Not supported on some older players and devices\. Use for bit rates between 40 and 80 kbps\. For more information, see [ High\-Efficiency Advanced Audio Coding\.](http://en.wikipedia.org/wiki/HE-AAC)
+ **HE\-AACv2**: Not supported on some players and devices\. Use for bit rates less than 48 kbps\. For more information, see [High\-Efficiency Advanced Audio Coding\.](http://en.wikipedia.org/wiki/HE-AAC)\.
All outputs in a **Smooth** playlist must have the same value for **Profile**\.  
If you created any presets before AAC profiles were added, Elastic Transcoder will use the AAC\-LC profile for those presets\.
For more information about AAC, see [Audio Profiles](http://en.wikipedia.org/wiki/MPEG-4_Part_3#Audio_Profiles) in the Wikipedia entry "MPEG\-4 Part 3\."

 **\(Optional, FLAC/PCM Only\) Bit Depth**  
The bit depth of a sample is how many bits of information are included in the audio samples\. The higher the bit depth, the better the audio, but the larger the file\.  
Valid values for the **FLAC** codec are **16** and **24**\.  
Valid values for the **PCM** codec are **8**, **16**, **24**, and **32**\.

 **\(Optional, PCM Only\) PCM Bit Signing**  
Whether audio samples are represented with negative and positive numbers \(signed\) or only positive numbers \(unsigned\)\.  
Valid values are **Signed** and **Unsigned**\.  
The most common value is **Signed**\.

 **\(Optional, PCM Only\) PCM Bit Order**  
The order the bits of a PCM sample are stored in\.  
The supported value is **LittleEndian**\.

 **Sample Rate**  
The sample rate of the audio stream in the output file, in Hz\. If you want Elastic Transcoder to automatically detect the sample rate of the input file and use that value for the output file, select **auto**\. If you want to specify the sample rate, select the applicable value\.

 **Bit Rate**  
The bit rate of the audio stream in the output file, in kilobits/second\. Enter an integer between 64 and 320, inclusive\. 

 **Channels**  
The number of audio channels in the output file\. The following values are valid:  
`auto`, `0`, `1`, `2`  
One channel carries the information played by a single speaker\. For example, a stereo track with two channels sends one channel to the left hand speaker, and the other channel to the right hand speaker\. The output channels are organized into tracks\. If you want Elastic Transcoder to automatically detect the number of audio channels in the input file and use that value for the output file, select `auto`\.      
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/preset-settings.html)
For more information about how digital audio works, see [Digital Audio](audio.md)\. For more information about how Elastic Transcoder organizes channels and tracks, see [Audio Packing Mode](#preset-settings-audio-packing-mode)\.

 **\(MXF with PCM Only\) Audio Packing Mode**  
The method of organizing audio channels and tracks\. Use **Channels** to specify the number of channels in your output, and **Audio Packing Mode** to specify the number of tracks and their relation to the channels\. If you do not specify an audio packing mode, Elastic Transcoder uses `SingleTrack`\.  
The following values are valid:  
`SingleTrack`, `OneChannelPerTrack`, and `OneChannelPerTrackWithMosTo8Tracks`    
**Single Track**  
Elastic Transcoder creates a single track for your output\. The track can have up to eight channels\. Use `SingleTrack` for all non\-`mxf` containers\.      
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/preset-settings.html)  
**\(MXF Only\) One Channel Per Track**  
Elastic Transcoder creates a new track for every channel in your output\. Your output can have up to eight single\-channel tracks\.      
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/preset-settings.html)  
**\(MXF Only\) One Channel Per Track with MOS to Eight Tracks**  
Elastic Transcoder creates eight single\-channel tracks for your output\. All tracks that do not contain audio data from an input channel are MOS, or Mit Out Sound, tracks\.      
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/preset-settings.html)
For more information about channels and tracks, see [Digital Audio](audio.md)\.

![\[Audio Settings screenshot.\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/)

## Thumbnail Settings<a name="preset-settings-thumbnails"></a>

 **Format**  
The format of thumbnails, if any\. Valid formats are **jpg** and **png**\.   
You specify whether you want Elastic Transcoder to create thumbnails when you create a job\. For more information, see [Thumbnail Filename Pattern](job-settings.md#job-settings-thumbnail-pattern) in the topic [Settings that You Specify When You Create an Elastic Transcoder Job](job-settings.md)\.

 **Interval**  
The approximate number of seconds between thumbnails\. Specify an integer value\. The actual interval can vary by several seconds from one thumbnail to the next\.

 **Max Height**  
The maximum height of thumbnails in pixels\. If you specify **auto**, Elastic Transcoder uses 1080 \(Full HD\) as the default value\. If you specify a numeric value, enter an even integer between 32 and 3072\.

 **Max Width**  
The maximum width of thumbnails in pixels\. If you specify **auto**, Elastic Transcoder uses 1920 \(Full HD\) as the default value\. If you specify a numeric value, enter an even integer between 32 and 4096\.

 **Sizing Policy**  
Specify one of the following values to control scaling of thumbnails:  
+ **Fit:** Elastic Transcoder scales thumbnails so they match the value that you specified in thumbnail **Max Width** or **Max Height** settings without exceeding the other value\.
+ **Fill:** Elastic Transcoder scales thumbnails so they match the value that you specified in thumbnail **Max Width** or **Max Height** settings and matches or exceeds the other value\. Elastic Transcoder centers the image in thumbnails and then crops in the dimension \(if any\) that exceeds the maximum value\. 
+ **Stretch:** Elastic Transcoder stretches thumbnails to match the values that you specified for thumbnail **Max Width** and **Max Height** settings\. If the relative proportions of the input video and thumbnails are different, the thumbnails will be distorted\.
+ **Keep:** Elastic Transcoder does not scale thumbnails\. If either dimension of the input video exceeds the values that you specified for thumbnail **Max Width** and **Max Height** settings, Elastic Transcoder crops the thumbnails\.
+ **ShrinkToFit:** Elastic Transcoder scales thumbnails down so that their dimensions match the values that you specified for at least one of thumbnail **MaxWidth** and **MaxHeight** without exceeding either value\. If you specify this option, Elastic Transcoder does not scale thumbnails up\.
+ **ShrinkToFill:** Elastic Transcoder scales thumbnails down so that their dimensions match the values that you specified for at least one of **MaxWidth** and **MaxHeight** without dropping below either value\. If you specify this option, Elastic Transcoder does not scale thumbnails up\.
The following table shows possible effects of **Sizing Policy** settings on thumbnails:      
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/preset-settings.html)

 **Padding Policy**  
When you set **PaddingPolicy** to **Pad**, Elastic Transcoder might add black bars to the top and bottom and/or left and right sides of thumbnails to make the total size of the thumbnails match the values that you specified for thumbnail **Max Width** and **Max Height** settings\. For more information, see the table at [Sizing Policy](#preset-settings-thumbnails-sizing-policy)\.

![\[Thumbnail Settings screenshot.\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/)