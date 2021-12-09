# `awscam.getLastFrame` Function<a name="deeplens-device-library-awscam-model-get-last-frame"></a>

 Retrieves the latest frame from the video stream\. The video streaming runs constantly when the AWS DeepLens is running\. 

**Request Syntax**

```
import awscam
ret, video_frame = awscam.getLastFrame()
```

**Parameters**
+ None

**Return Type**
+ `ret`—A Boolean value \(true or false\) that indicates whether the call was successful\.
+ `video_frame`—A numpy\.ndarray that represents a video frame\.