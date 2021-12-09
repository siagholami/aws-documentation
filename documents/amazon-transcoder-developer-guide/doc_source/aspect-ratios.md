# Sizing Policy and Aspect Ratios<a name="aspect-ratios"></a>

The **Sizing Policy** that you choose affects the scaling that Elastic Transcoder applies to your output image, as shown in the following table\.


| Sizing Policy | Output Image Might Be Scaled Up | Output Image Might Be Padded When Padding Policy Is "Pad" | Output Image Might Have a Different Pixel Aspect Ratio than Input Image | Output Image Might Be Cropped | 
| --- | --- | --- | --- | --- | 
| **Fit** | Yes | Yes |   |   | 
| **Fill** | Yes |   |   | Yes | 
| **Stretch** | Yes |   | Yes |   | 
| **Keep** |   | Yes |   | Yes | 
| **ShrinkToFit** |   | Yes |   |   | 
| **ShrinkToFill** |   | Yes |   | Yes | 

## Aspect Ratio Thumbnails<a name="ratio-thumbnails"></a>

The following tables show how the **Sizing Policy**, **Padding Policy**, **Max Height**, and **Max Width** interact to change the output image\.

**Topics**
+ [Fit](#fit-ratio)
+ [Fill](#fill-ratio)
+ [Stretch](#stretch-ratio)
+ [Keep](#keep-ratio)
+ [Shrink to Fit](#shrink-to-fit-ratio)
+ [Shrink to Fill](#shrink-to-fill-ratio)

### Fit<a name="fit-ratio"></a>

If you choose **Fit** for your **Sizing Policy**, Elastic Transcoder scales your input file until it fits inside the dimensions of your output image, without exceeding the dimensions of your output image\. 

For example, if your input file is `200` pixels by `200` pixels and you want an output image that is `300` pixels by `400` pixels, Elastic Transcoder increases the size of your file to `300` pixels by `300` pixels, and applies your padding policy to the sides of your file\. If you choose **Unpadded** for your **Padding Policy**, Elastic Transcoder returns the `300` pixel by `300` pixel file as your output\. If you choose **Padded**, Elastic Transcoder adds `50` pixels of padding on either side of your output, and returns a `300` pixel by `400` pixel file\.

You can download larger versions of the pictures [here](https://s3.amazonaws.com/etscodesamples/AspectRatios/Fit.zip)\.

**Key**

![\[Aspect Ratio Key\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/)


| Condition | Input | Output: NoPad | Output: Pad | 
| --- | --- | --- | --- | 
| Input width **<** Max output width Input height **<** Max output height | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | 
| Input width **<** Max output width Input height **>** Max output height | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | 
| Input width **>** Max output width Input height **<** Max output height | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | 
| Input width **>** Max output width Input height **>** Max output height | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | 

### Fill<a name="fill-ratio"></a>

If you choose **Fill** for your **Sizing Policy**, Elastic Transcoder scales your input file until it fills the dimensions of your output image, and crops anything that exceeds the dimensions of your output image\.

For example, if your input file is `200` pixels by `200` pixels and you want an output image that is `300` pixels by `400` pixels, Elastic Transcoder increases the size of your input to `400` pixels by `400` pixels, crops off the top and bottom `50` pixels, and returns a `300` pixel by `400` pixel file\. Elastic Transcoder does not use padding for the **Fill** policy\.

You can download larger versions of the pictures [here](https://s3.amazonaws.com/etscodesamples/AspectRatios/Fill.zip)\.

**Key**

![\[Aspect Ratio Key\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/)


| Condition | Input | Output: NoPad | Output: Pad | 
| --- | --- | --- | --- | 
| Input width **<** Max output width Input height **<** Max output height | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | 
| Input width **<** Max output width Input height **>** Max output height | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | 
| Input width **>** Max output width Input height **<** Max output height | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | 
| Input width **>** Max output width Input height **>** Max output height | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | 

### Stretch<a name="stretch-ratio"></a>

If you choose **Stretch** for your **Sizing Policy**, Elastic Transcoder stretches or shrinks your input file until it matches the dimensions of your output file\.

For example, if your input file is `200` pixels by `200` pixels and you want an output image that is `300` pixels by `400` pixels, Elastic Transcoder increases the size of your input to `300` pixels by `400` pixels, distorting the proportions of your output image\. Elastic Transcoder does not use padding or cropping for the **Stretch** policy\.

You can download larger versions of the pictures [here](https://s3.amazonaws.com/etscodesamples/AspectRatios/Stretch.zip)\.

**Key**

![\[Aspect Ratio Key\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/)


| Condition | Input | Output: NoPad | Output: Pad | 
| --- | --- | --- | --- | 
| Input width **<** Max output width Input height **<** Max output height | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | 
| Input width **<** Max output width Input height **>** Max output height | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | 
| Input width **>** Max output width Input height **<** Max output height | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | 
| Input width **>** Max output width Input height **>** Max output height | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | 

### Keep<a name="keep-ratio"></a>

If you choose **Keep** for your **Sizing Policy**, Elastic Transcoder does not scale your input file\. Elastic Transcoder crops or pads your input file until it matches the dimensions of your output image\.

For example, if your input file is `400` pixels by `200` pixels and you want an output image that is `300` pixels by `300` pixels, Elastic Transcoder crops `100` pixels off of the top and bottom, and applies your padding policy to the sides\. If you choose **Unpadded** for your **Padding Policy**, Elastic Transcoder returns a `300` pixel by `200` pixel output file\. If you choose **Padded**, Elastic Transcoder returns a `300` pixel by `300` pixel file\.

You can download larger versions of the pictures [here](https://s3.amazonaws.com/etscodesamples/AspectRatios/Keep.zip)\.

**Key**

![\[Aspect Ratio Key\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/)


| Condition | Input | Output: NoPad | Output: Pad | 
| --- | --- | --- | --- | 
| Input width **<** Max output width Input height **<** Max output height | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | 
| Input width **<** Max output width Input height **>** Max output height | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | 
| Input width **>** Max output width Input height **<** Max output height | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | 
| Input width **>** Max output width Input height **>** Max output height | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | 

### Shrink to Fit<a name="shrink-to-fit-ratio"></a>

If you choose **Shrink to Fit** for your **Sizing Policy**, Elastic Transcoder decreases the size of your input file until it fits inside the dimensions of your output file, without going over any of the dimensions of your output image\. If your input file is smaller than your output image, Elastic Transcoder does not increase the size of your file\.

For example, if your input file is `400` pixels by `400` pixels and you want an output image that is `200` pixels by `300` pixels, Elastic Transcoder shrinks your input to `200` pixels by `200` pixels, and applies your padding policy\. If you choose **Unpadded** for your **Padding Policy**, Elastic Transcoder returns the `200` by `200` pixel file as your output\. If you choose **Padded**, Elastic Transcoder adds `50` pixels of padding on either side of your output, and returns a `300` pixel by `300` pixel file\.

You can download larger versions of the pictures [here](https://s3.amazonaws.com/etscodesamples/AspectRatios/Shrink%20to%20Fit.zip)\.

**Key**

![\[Aspect Ratio Key\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/)


| Condition | Input | Output: NoPad | Output: Pad | 
| --- | --- | --- | --- | 
| Input width **<** Max output width Input height **<** Max output height | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | 
| Input width **<** Max output width Input height **>** Max output height | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | 
| Input width **>** Max output width Input height **<** Max output height | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | 
| Input width **>** Max output width Input height **>** Max output height | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | 

### Shrink to Fill<a name="shrink-to-fill-ratio"></a>

If you choose **Shrink to Fill** for your **Sizing Policy**, Elastic Transcoder decreases the size of your input file until it fills the dimensions of your output image, crops anything that does not fit inside your output image, and applies your padding policy\. If your output image is larger than your input file, Elastic Transcoder does not increase the size of your file\.

For example, if your input file is `400` pixels by `200` pixels and you want an output image that is `200` pixels by `300` pixels, Elastic Transcoder  crops `100` pixels from the sides, and applies your padding policy to the top and bottom of your file\. If you choose **Unpadded** for your **Padding Policy**, Elastic Transcoder returns a `200` pixel by `200` pixel output file\. If you choose **Padded**, Elastic Transcoder returns a `200` pixel by `300` pixel file\.

You can download larger versions of the pictures [here](https://s3.amazonaws.com/etscodesamples/AspectRatios/Shrink%20to%20Fill.zip)\.

**Key**

![\[Aspect Ratio Key\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/)


| Condition | Input | Output: NoPad | Output: Pad | 
| --- | --- | --- | --- | 
| Input width **<** Max output width Input height **<** Max output height | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | 
| Input width **<** Max output width Input height **>** Max output height | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | 
| Input width **>** Max output width Input height **<** Max output height | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | 
| Input width **>** Max output width Input height **>** Max output height | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | ![\[\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/) | 