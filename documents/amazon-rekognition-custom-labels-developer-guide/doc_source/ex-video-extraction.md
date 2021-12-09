# Video Analysis<a name="ex-video-extraction"></a>

The following example shows how you can use `DetectCustomLabels` with frames extracted from a video\. The code has been tested with video files in *mov* and *mp4* format\.

**Using `DetectCustomLabels` with captured frames**

1. If you haven't already:

   1. Create or update an IAM user with `AmazonRekognitionFullAccess` and `AmazonS3ReadOnlyAccess` permissions\. For more information, see [Step 2: Create an IAM Administrator User and Group](su-account-user.md)\.

   1. Install and configure the AWS CLI and the AWS SDKs\. For more information, see [Step 2: Set Up the AWS CLI and AWS SDKs](su-awscli-sdk.md)\.

1. Use the following example code\. Change the value of `videoFile` to the name of a video file\. Change the value of `projectVersionArn` to the Amazon Resource Name \(ARN\) of your Amazon Rekognition Custom Labels model\. 

   ```
   #Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
   #PDX-License-Identifier: MIT-0 (For details, see https://github.com/awsdocs/amazon-rekognition-developer-guide/blob/master/LICENSE-SAMPLECODE.)
   
   import json
   import boto3
   import cv2
   import math
   import io
   
   def analyzeVideo():
       videoFile = "video file"
       projectVersionArn = "project arn"
   
       rekognition = boto3.client('rekognition')        
       customLabels = []    
       cap = cv2.VideoCapture(videoFile)
       frameRate = cap.get(5) #frame rate
       while(cap.isOpened()):
           frameId = cap.get(1) #current frame number
           print("Processing frame id: {}".format(frameId))
           ret, frame = cap.read()
           if (ret != True):
               break
           if (frameId % math.floor(frameRate) == 0):
               hasFrame, imageBytes = cv2.imencode(".jpg", frame)
   
               if(hasFrame):
                   response = rekognition.detect_custom_labels(
                       Image={
                           'Bytes': imageBytes.tobytes(),
                       },
                       ProjectVersionArn = projectVersionArn
                   )
               
               for elabel in response["CustomLabels"]:
                   elabel["Timestamp"] = (frameId/frameRate)*1000
                   customLabels.append(elabel)
       
       print(customLabels)
   
       with open(videoFile + ".json", "w") as f:
           f.write(json.dumps(customLabels)) 
   
       cap.release()
   
   analyzeVideo()
   ```