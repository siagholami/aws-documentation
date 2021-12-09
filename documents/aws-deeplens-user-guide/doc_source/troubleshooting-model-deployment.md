# Troubleshooting Issues with Model Deployments to the AWS DeepLens Device<a name="troubleshooting-model-deployment"></a>

Use the following information to troubleshoot issues that occur when deploying models to an AWS DeepLens device\.

**Topics**
+ [How to Resolve an Access Denied Error Encountered While Downloading a Model After Device Registration Went through without Errors?](#troubleshooting-device-registration-11)
+ [How to Resolve the ModelDownloadFailed Error?](#troubleshooting-model-deployment-download)
+ [Resolve Model Optimization Failure Reported As std::bad\_alloc\(\)](#troubleshooting-model-deployment-1)
+ [How to Resolve Model Optimization Failure Caused by a Missing stride Attribute?](#troubleshooting-model-deployment-2)
+ [How to Resolve Model Optimization Failure When the List Object Is Missing the shape Attribute?](#troubleshooting-model-deployment-3)
+ [How to Ensure Reasonable Inference for a Model?](#troubleshooting-model-deployment-4)
+ [How to Determine Why AWS DeepLens Classifies Data Incorrectly When the Model Performs Well on the Validation Set?](#troubleshooting-model-deployment-5)

## How to Resolve an Access Denied Error Encountered While Downloading a Model After Device Registration Went through without Errors?<a name="troubleshooting-device-registration-11"></a>

When setting permissions during device registration, make sure that you have the IAM role for AWS IoT Greengrass created and the role is associated with the **IAM group role for AWS Greengrass** option on the console when setting permissions during device registration\. If you didn't, reregister the device with the correct roles\.

## How to Resolve the ModelDownloadFailed Error?<a name="troubleshooting-model-deployment-download"></a>

When using the AWS DeepLens console, you must provide two IAM roles for AWS IoT Greengrass: **IAM Role for AWS Greengrass** and **IAM group role for AWS Greengrass**\. If you specify the same IAM role for both, you get this error\. To fix it, specify `AWSDeepLensGreengrassRole` for the **IAM Role for AWS Greengrass** and `AWSDeepLensGreengrassGroupRole` for the **IAM group role for AWS Greengrass**\.

## Resolve Model Optimization Failure Reported As std::bad\_alloc\(\)<a name="troubleshooting-model-deployment-1"></a>

This occurs because the version of MXNet on the device doesn't match the version used to train the model\. Upgrade the version of MXNet on the device by running the following command from a terminal on the device: 

```
sudo pip3 install mxnet==1.0.0
```

We assume that the version of MXNet used for training is `1.0.0`\. If you use a different version for training, change the version number accordingly\.

## How to Resolve Model Optimization Failure Caused by a Missing stride Attribute?<a name="troubleshooting-model-deployment-2"></a>

If you haven't specified the `stride` argument in the hyper parameter list for pooling layers, the model optimizer fails and reports the following error message:

```
AttributeError: 'MxNetPoolingLayer' object has no attribute 'stride_x'
```

This occurs because the `stride` argument is removed from the latest MXNet pooling layers' hyper parameter list\.

To fix the problem, add `"stride": "(1, 1)"` to the symbol file\. In a text editor, edit your symbol file so that the pooling layer looks like this:

```
{
    "op": "Pooling",
    "name": "pool1",
    "attr": {
        "global_pool": "True",
        "kernel": "(7, 7)",
        "pool_type": "avg",
        "stride": "(1, 1)"
    },
    "inputs": <your input shape>
},
```

 After the `stride` property is added to all the pooling layers, you should no longer get the error and everything should work as expected\. For more information, see [this forum post](https://forums.aws.amazon.com/thread.jspa?threadID=271284&tstart=0)\. 

## How to Resolve Model Optimization Failure When the List Object Is Missing the shape Attribute?<a name="troubleshooting-model-deployment-3"></a>

You receive the following error message during model optimization when the layer names for non\-null operators have suffixes: 

```
File "/opt/intel/deeplearning_deploymenttoolkit_2017.1.0.5852/
deployment_tools/model_optimizer/model_optimizer_mxnet/mxnet_convertor/
mxnet_layer_utils.py", line 75, in transform_convolution_layer
res = np.ndarray(l.weights.shape)
AttributeError: 'list' object has no attribute 'shape'
```

In a text editor, open your model's symbol file \(`<model_name>-symbol.json` \. Remove suffixes from all of the layer names for non\-null operators\. The following is an example of how a non\-null operator is defined:

```
{
    "op": "Convolution",
    "name": "deep_dog_conv0_fwd",
    "attr": {
        "dilate": "(1, 1)",
        "kernel": "(3, 3)",
        "layout": "NCHW",
        "no_bias": "False",
        "num_filter": "64",
        "num_group": "1",
        "pad": "(0, 0)",
        "stride": "(2, 2)"
    }
}
```

Change `"name": "deep_dog_conv0_fwd"` to `"name": "deep_dog_conv0"`x\.

In contrast, the following is an example of a null operator:

```
{
    "op": "null",
    "name": "deep_dog_conv0_weight",
    "attr": {
        "__dtype__": "0",
        "__lr_mult__": "1.0",
        "__shape__": "(64, 0, 3, 3)",
        "__wd_mult__": "1.0"
    }
},
```

For a softmax layer, if the `"attr": "{}"` property is missing, add it to the JSON file\. For example:

```
{
    "op": "SoftmaxOutput",
    "name": "softmax",
    "attr": {},
    "inputs": [[192,0,0]]
}
```

Finally, make sure that you use only the supported layers in your model\. For a list of supported MXNet layers, see [MXNet Models](deeplens-supported-frameworks-mxnet.md)\.

## How to Ensure Reasonable Inference for a Model?<a name="troubleshooting-model-deployment-4"></a>

To ensure reasonable inference based on a given model, the height and width of the model optimizer must match the height and width of images in the training set\. For example, if you trained your model using images that are 512 pixels X 512 pixels, you must set your model optimizer's height and width to 512 X 512\. Otherwise, the inference won't make sense\.

## How to Determine Why AWS DeepLens Classifies Data Incorrectly When the Model Performs Well on the Validation Set?<a name="troubleshooting-model-deployment-5"></a>

AWS DeepLens classifies data incorrectly even if the model performs well on a validation set when your training data wasn't normalized\. Retrain the model with normalized training data\.

If the training data has been normalized, also normalize the input data before passing it to the inference engine\.