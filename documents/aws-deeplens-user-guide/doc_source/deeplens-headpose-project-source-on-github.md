# Get the AWS Sample Project on GitHub<a name="deeplens-headpose-project-source-on-github"></a>

This tutorial is based on the [head pose detection sample project](deeplens-templated-projects-overview.md#head-pose-detection)\. The sample project's source code, including the [preprocessing script](https://github.com/aws-samples/headpose-estimator-apache-mxnet/blob/master/preprocessingDataset_py2.py) used to prepare for input data from the original [Head Pose Image Database](http://www-prima.inrialpes.fr/perso/Gourier/Faces/HPDatabase.html), is available on [GitHub](https://github.com/aws-samples/headpose-estimator-apache-mxnet)\. 

![\[\]](http://docs.aws.amazon.com/deeplens/latest/dg/images/deeplens-tutorial-headpose-detection-github-project.png)

The HeadPose\_ResNet50\_Tutorial\.ipynb file provides a Notebook template as a starting point to learn and explore training our model\. The preprocessingDataset\_py2\.py can be used as\-is to prepare input data for training\. 

You can download and uncompress the zipped GitHub project file to a local drive\. Or you can clone the GitHub project\. To clone the project, open a terminal window and type the following Git command in a given working directory:

```
git clone https://github.com/aws-samples/headpose-estimator-apache-mxnet
```

By default, the downloaded or cloned project folder is `headpose-estimator-apache-mxnet-master`\. We will use this default folder name for the project folder throughout this tutorial\.

Having the GitHub project as a template, we're now ready to start building our project by [setting up the project's data store in S3](deeplens-headpose-project-set-up-data-store.md)\.