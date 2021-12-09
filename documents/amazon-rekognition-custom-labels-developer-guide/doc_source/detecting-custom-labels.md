# Analyzing an Image with a Trained Model<a name="detecting-custom-labels"></a>

To analyze an image with a trained Amazon Rekognition Custom Labels model, you call the [DetectCustomLabels](https://docs.aws.amazon.com/rekognition/latest/dg/API_DetectCustomLabels) API\. The result from `DetectCustomLabels` is a prediction that the image contains specific objects, scenes, or concepts\.

To call `DetectCustomLabels`, you specify the following:
+ The Amazon Resource Name \(ARN\) of the Amazon Rekognition Custom Labels model that you want to use\.
+ The image that you want the model to make a prediction with\. You can provide an input image as an image byte array \(base64\-encoded image bytes\), or as an Amazon S3 object\. For more information, see [Image](https://docs.aws.amazon.com/rekognition/latest/dg/API_Image)\.

Custom labels are returned in an array of [Custom Label](https://docs.aws.amazon.com/rekognition/latest/dg/API_CustomLabel) objects\. Each custom label represents a single object, scene, or concept found in the image\. A custom label includes:
+ A label for the object, scene, or concept found in the image\.
+ A bounding box for objects found in the image\. The bounding box coordinates show where the object is located on the source image\. The coordinate values are a ratio of the overall image size\. For more information, see [BoundingBox](https://docs.aws.amazon.com/rekognition/latest/dg/API_BoundingBox)\.
+ The confidence that Amazon Rekognition Custom Labels has in the accuracy of the label and bounding box\.

During training a model calculates a threshold value that determines if a prediction for a label is true\. By default, `DetectCustomLabels` doesn't return labels whose confidence value is below the model's calculated threshold value\. To filter labels that are returned, specify a value for `MinConfidence` that is higher than the model's calculated threshold\. You can get the model's calculated threshold from the model's training results shown in the Amazon Rekognition Custom Labels console\. To get all labels, regardless of confidence, specify a `MinConfidence` value of 0\. 

If you're finding the confidence values returned by `DetectCustomLabels` are too low, consider retraining the model\. For more information, see [Training an Amazon Rekognition Custom Labels Model](tm-train-model.md)\. You can restrict the number of custom labels returned from `DetectCustomLabels` by specifying the `MaxResults` input parameter\. The results are returned sorted from the highest confidence to the lowest\. 

For other examples that call `DetectCustomLabels`, see [Examples](examples.md)\.

For information about securing `DetectCustomLabels`, see [Securing DetectCustomLabels](sc-introduction.md#sc-detect-custom-labels)\.

**To detect custom labels \(API\)**

1. If you haven't already:

   1. Create or update an IAM user with `AmazonRekognitionFullAccess` and `AmazonS3ReadOnlyAccess` permissions\. For more information, see [Step 2: Create an IAM Administrator User and Group](su-account-user.md)\.

   1. Install and configure the AWS CLI and the AWS SDKs\. For more information, see [Step 2: Set Up the AWS CLI and AWS SDKs](su-awscli-sdk.md)\.

1. Train and deploy your model\. For more information, see [Getting Started with Amazon Rekognition Custom Labels](gs-introduction.md)\.

1. Ensure the IAM user calling `DetectCustomLabels` has access to the model you used in step 3\. For more information, see [Securing DetectCustomLabels](sc-introduction.md#sc-detect-custom-labels)\.

1. Upload an image that contains text to an S3 bucket\. 

   For instructions, see [Uploading Objects into Amazon S3](https://docs.aws.amazon.com/AmazonS3/latest/user-guide/UploadingObjectsintoAmazonS3.html) in the *Amazon Simple Storage Service Console User Guide*\.

1. Use the following examples to call the `DetectCustomLabels` operation\.

------
#### [ AWS CLI ]

   This AWS CLI command displays the JSON output for the `DetectCustomLabels` CLI operation\. Change the values of the following input parameters\. 
   + `bucket` with the name of Amazon S3 bucket that you used in step 4\. 
   + `image` with the name of the input image file you uploaded in step 4\.
   + `projectVersionArn` with the ARN of the model that you want to use\. 

   ```
   aws rekognition detect-custom-labels --project-version-arn "model_arn"\
      --image '{"S3Object":{"Bucket":"bucket","Name":"image"}}'\
      --min-confidence 70
   ```

------
#### [ Python ]

   The following example code displays bounding boxes around custom labels detected in an image\. Replace the following values: 
   + `bucket` with the name of Amazon S3 bucket that you used in step 4\. 
   + `image` with the name of the input image file you uploaded in step 4\.
   + `min_confidence` with the minimum confidence \(0\-100\)\. Objects detected with a confidence lower than this value are not returned\.
   + `model` with the ARN of the model that you want use with the input image\. 

   ```
   #Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
   #PDX-License-Identifier: MIT-0 (For details, see https://github.com/awsdocs/amazon-rekognition-developer-guide/blob/master/LICENSE-SAMPLECODE.)
   
   import boto3
   import io
   from PIL import Image, ImageDraw, ExifTags, ImageColor, ImageFont
   
   def show_custom_labels(model,bucket,photo, min_confidence):
        
   
       client=boto3.client('rekognition')
   
       # Load image from S3 bucket
       s3_connection = boto3.resource('s3')
   
       s3_object = s3_connection.Object(bucket,photo)
       s3_response = s3_object.get()
   
       stream = io.BytesIO(s3_response['Body'].read())
       image=Image.open(stream)
       
       #Call DetectCustomLabels 
       response = client.detect_custom_labels(Image={'S3Object': {'Bucket': bucket, 'Name': photo}},
           MinConfidence=min_confidence,
           ProjectVersionArn=model)
      
      
       imgWidth, imgHeight = image.size  
       draw = ImageDraw.Draw(image)  
   
          
       # calculate and display bounding boxes for each detected custom label       
       print('Detected custom labels for ' + photo)    
       for customLabel in response['CustomLabels']:
           print('Label ' + str(customLabel['Name'])) 
           print('Confidence ' + str(customLabel['Confidence'])) 
           if 'Geometry' in customLabel:
               box = customLabel['Geometry']['BoundingBox']
               left = imgWidth * box['Left']
               top = imgHeight * box['Top']
               width = imgWidth * box['Width']
               height = imgHeight * box['Height']
                 
               fnt = ImageFont.truetype('/Library/Fonts/Arial.ttf', 50)
               draw.text((left,top), customLabel['Name'], fill='#00d400', font=fnt) 
   
               print('Left: ' + '{0:.0f}'.format(left))
               print('Top: ' + '{0:.0f}'.format(top))
               print('Label Width: ' + "{0:.0f}".format(width))
               print('Label Height: ' + "{0:.0f}".format(height))
   
               points = (
                   (left,top),
                   (left + width, top),
                   (left + width, top + height),
                   (left , top + height),
                   (left, top))
               draw.line(points, fill='#00d400', width=5)
           
   
       image.show()
   
       return len(response['CustomLabels'])
   
   def main():
   
       bucket="bucket"
       photo="image"
       model='model_arn'
       min_confidence=95
       
       label_count=show_custom_labels(model,bucket,photo, min_confidence)
       print("Custom labels detected: " + str(label_count))
   
   
   if __name__ == "__main__":
       main()
   ```

------
#### [ Java ]

   The following example code displays bounding boxes around custom labels detected in an image\. Replace the following values: 
   + `bucket` with the name of Amazon S3 bucket that you used in step 4\. 
   + `photo` with the name of the input image file you uploaded in step 4\.
   + `minConfidence` with the minimum confidence \(0\-100\)\. Objects detected with a confidence lower than this value are not returned\.
   + `projectVersionArn` with the ARN of the model that you want use with the input image\. 

   ```
   //Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
   //PDX-License-Identifier: MIT-0 (For details, see https://github.com/awsdocs/amazon-rekognition-developer-guide/blob/master/LICENSE-SAMPLECODE.)
   
   package com.amazonaws.samples;
   
   //Import the basic graphics classes.
   import java.awt.*;
   import java.awt.image.BufferedImage;
   import java.util.List;
   import javax.imageio.ImageIO;
   import javax.swing.*;
   
   import com.amazonaws.services.rekognition.AmazonRekognition;
   import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
   
   import com.amazonaws.services.rekognition.model.BoundingBox;
   import com.amazonaws.services.rekognition.model.CustomLabel;
   import com.amazonaws.services.rekognition.model.DetectCustomLabelsRequest;
   import com.amazonaws.services.rekognition.model.DetectCustomLabelsResult;
   import com.amazonaws.services.rekognition.model.Image;
   import com.amazonaws.services.rekognition.model.S3Object;
   import com.amazonaws.services.s3.AmazonS3;
   import com.amazonaws.services.s3.AmazonS3ClientBuilder;
   import com.amazonaws.services.s3.model.S3ObjectInputStream;
   
   // Calls DetectFaces and displays a bounding box around each detected image.
   public class DisplayCustomLabels extends JPanel {
   
   
       private static final long serialVersionUID = 1L;
   
       BufferedImage image;
       static int scale;
       DetectCustomLabelsResult result;
   
       public  DisplayCustomLabels(DetectCustomLabelsResult labelsResult, BufferedImage bufImage) throws Exception {
           super();
           scale = 4; // increase to shrink image size.
   
           result = labelsResult;
           image = bufImage;
   
           
       }
       // Draws the bounding box around the detected faces.
       public void paintComponent(Graphics g) {
           float left = 0;
           float top = 0;
           int height = image.getHeight(this);
           int width = image.getWidth(this);
   
           Graphics2D g2d = (Graphics2D) g; // Create a Java2D version of g.
   
           // Draw the image.
           g2d.drawImage(image, 0, 0, width / scale, height / scale, this);
           g2d.setColor(new Color(0, 212, 0));
   
           // Iterate through faces and display bounding boxes.
           List<CustomLabel> customLabels = result.getCustomLabels();
           for (CustomLabel customLabel : customLabels) {
               
           	if (customLabel.getGeometry()!=null) {
           		BoundingBox box = customLabel.getGeometry().getBoundingBox();
           		left = width * box.getLeft();
           		top = height * box.getTop();
           		g2d.drawString(customLabel.getName(), left/scale, top/scale);
           		g2d.drawRect(Math.round(left / scale), Math.round(top / scale),
                       Math.round((width * box.getWidth()) / scale), Math.round((height * box.getHeight())) / scale);
           	}
               
           }
       }
   
   
       public static void main(String arg[]) throws Exception {
           		
           String photo = "image";
           String bucket = "bucket";
           String projectVersionArn ="model_arn";		
           float minConfidence=90;
           int height = 0;
           int width = 0;
   
           // Get the image from an S3 Bucket
           AmazonS3 s3client = AmazonS3ClientBuilder.defaultClient();
   
           com.amazonaws.services.s3.model.S3Object s3object = s3client.getObject(bucket, photo);
           S3ObjectInputStream inputStream = s3object.getObjectContent();
           BufferedImage image = ImageIO.read(inputStream);
           
           DetectCustomLabelsRequest request = new DetectCustomLabelsRequest()
           		.withProjectVersionArn(projectVersionArn)
                   .withImage(new Image().withS3Object(new S3Object().withName(photo).withBucket(bucket)))
                   .withMinConfidence(minConfidence);
   
           width = image.getWidth();
           height = image.getHeight();
   
           // Call DetectFaces    
           AmazonRekognition amazonRekognition = AmazonRekognitionClientBuilder.defaultClient();
           DetectCustomLabelsResult result = amazonRekognition.detectCustomLabels(request);
           
           //Show the bounding box info for each face.
           List<CustomLabel> customLabels = result.getCustomLabels();
           for (CustomLabel customLabel : customLabels) {
   
           	if (customLabel.getGeometry()!=null)
               {
           		BoundingBox box = customLabel.getGeometry().getBoundingBox();
               
           		float left = width * box.getLeft();
           		float top = height * box.getTop();
           		System.out.println("Custom Label:");
   
           		System.out.println("Left: " + String.valueOf((int) left));
           		System.out.println("Top: " + String.valueOf((int) top));
           		System.out.println("Label Width: " + String.valueOf((int) (width * box.getWidth())));
           		System.out.println("Label Height: " + String.valueOf((int) (height * box.getHeight())));
           		System.out.println();
               }
           }
   
           // Create frame and panel.
           JFrame frame = new JFrame("RotateImage");
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           DisplayCustomLabels panel = new DisplayCustomLabels(result, image);
           panel.setPreferredSize(new Dimension(image.getWidth() / scale, image.getHeight() / scale));
           frame.setContentPane(panel);
           frame.pack();
           frame.setVisible(true);
   
       }
   }
   ```

------

## DetectCustomLabels Operation Request<a name="detecttext-request"></a>

In the `DetectCustomLabels` operation, you supply an input image either as a base64\-encoded byte array or as an image stored in an Amazon S3 bucket\. The following example JSON request shows the image loaded from an Amazon S3 bucket\.

```
{
    "ProjectVersionArn": "string", 
     "Image":{ 
        "S3Object":{
            "Bucket":"string",
            "Name":"string",
            "Version":"string"
         }
    },
    "MinConfidence": 90,
    "MaxLabels": 10,
}
```

## DetectCustomLabels Operation Response<a name="text-response"></a>

The following JSON response from the `DetectCustomLabels` operation shows the custom labels that were detected in the following image\.

```
{
    "CustomLabels": [
        {
            "Name": "MyLogo",
            "Confidence": 77.7729721069336,
            "Geometry": {
                "BoundingBox": {
                    "Width": 0.198987677693367,
                    "Height": 0.31296101212501526,
                    "Left": 0.07924537360668182,
                    "Top": 0.4037395715713501
                }
            }
        }
    ]
}
```