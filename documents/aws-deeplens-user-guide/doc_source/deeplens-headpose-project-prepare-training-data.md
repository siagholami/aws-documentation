# Prepare Input Data for Training In Amazon SageMaker<a name="deeplens-headpose-project-prepare-training-data"></a>

The original [head pose image database \(HeadPoseImageDatabase\.tar\.gz file\)](http://www-prima.inrialpes.fr/perso/Gourier/Faces/HeadPoseImageDatabase.tar.gz) consists of a set of images \(\.jpeg files\) and labels \(\.txt files\) of head poses of 15 persons in a series of tilt and pan positions\. They must be transformed to a single \.pkl file as the input to an Amazon SageMaker training job\. 

To prepare the training data, you can use the preprocessing script \(preprocessingDataset\_py2\.py\) provided in the [Head Pose Sample Project on Github](deeplens-headpose-project-source-on-github.md)\. You can run this script on your computer locally or on the AWS Cloud through a Python Notebook instance\. In this section, you'll learn how to prepare the training data locally\. You'll learn how to do it in a Notebook instance in [Train a Head Pose Detection Model in Amazon SageMaker](deeplens-headpose-project-train-model-using-sagemaker.md)\.

1. Open a terminal and change directory to the directory where to you downloaded the [head pose sample project](deeplens-headpose-project-source-on-github.md)\.

1. Run the following Python \(version 2\.7\) command

   ```
   python preprocessingDataset_py2.py --num-data-aug 15 --aspect-ratio 1
   ```

   If you get an error stating that the `cv2` module is not found, run the following command to install the missing module:

   ```
   python -m pip install opencv-python
   ```

   Then, rerun the preprocessing script\. 

   The process takes 15\-20 hours to complete\. The preprocessing script outputs the results as the HeadPoseData\_trn\_test\_x15\_py2\.pkl file in the current working directory\. 

1. Upload the preprocessed training data \(HeadPoseData\_trn\_test\_x15\_py2\.pkl\) file into the `deeplens-sagemaker-models-<my-name>/headpose/datasets` folder in Amazon S3\. You can do this using the Amazon S3 console or, as shown as follows, using the following [AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-welcome.html) command: 

   ```
   aws s3 cp HeadPoseData_trn_test_x15_py2.pkl s3://deeplens-sagemaker-models-<my-name>/headpose/datasets 
   ```

**Note**  
Instead of running locally, you can prepare the input data on the AWS Cloud by a code cell in a Amazon SageMaker notebook instance, where `cv2` and Python 2\.7 \(`python2`\) are readily available, and run the commands in **Step 2** and **Step 3**, respectively, as follows:  

```
!python2 preprocessingDataset_py2.py --num-data-aug 15 --aspect-ratio 1
```
and   

```
!aws s3 cp HeadPoseData_trn_test_x15_py2.pkl s3://deeplens-sagemaker-models-<my-name>/headpose/datasets 
```
You notebook instance needs to run on a sufficiently powerful EC2 instance of, e\.g\., the `ml.p2.xlarge` type\.

Now that we have the input data prepared and stored in S3, we're ready to [train the model](deeplens-headpose-project-train-model-using-sagemaker.md)\.