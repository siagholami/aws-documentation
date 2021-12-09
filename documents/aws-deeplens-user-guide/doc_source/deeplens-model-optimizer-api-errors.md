# Troubleshooting the Model Optimizer<a name="deeplens-model-optimizer-api-errors"></a>

 In this section, you'll find a list of frequently asked questions and answers about errors reported by the model optimizer\. The AWS DeepLens model optimizer depends on the Intel Computer Vision SDK, which is installed with the AWS DeepLens software\. For errors not covered here, see [Intel Computer Vision SDK Support](https://software.intel.com/en-us/forums/computer-vision) and ask a question on the forum\. 

**Topics**
+ [How to handle the "*Current caffe\.proto does not contain field\.*" error?](#deeplens-mo-errors-cafee_proto-missing-field)
+ [How to create a bare Caffe model with only prototxt?](#deeplens-mo-errors-2)
+ [How to handle the "*Unable to create ports for node with id\.*" error?](#deeplens-mo-errors-3)
+ [How to Handle "*Invalid proto file: there is neither 'layer' nor 'layers' top\-level messages\.*" error?](#deeplens-mo-errors-7)
+ [How to handle the "*Old\-style inputs \(via 'input\_dims'\) are not supported\. Please specify inputs via 'input\_shape'\.*" error?](#deeplens-mo-errors-8)
+ [How to handle the "*Invalid prototxt file: value error\.*" error?](#deeplens-mo-errors-11)
+ [How to handle the "*Error happened while constructing caffe\.Net in the Caffe fallback function\.*" error?](#deeplens-mo-errors-12)
+ [How to handle the "*Cannot infer shapes due to exception in Caffe\.*" error?](#deeplens-mo-errors-13)
+ [How to handle the "*Cannot infer shape for node \{\} because there is no Caffe available\. Please register python infer function for op or use Caffe for shape inference\.*" error?](#deeplens-mo-errors-14)
+ [How to handle the "*Input shape is required to convert MXNet model\. Please provide it with \-\-input\_width and \-\-input\_height\.*" error?](#deeplens-mo-errors-16)
+ [How to handle the "*Cannot find prototxt file: for Caffe please specify \-\-input\_proto \- a protobuf file that stores topology and \-\-input\_model that stores pretrained weights\.*" error?](#deeplens-mo-errors-20)
+ [How to handle the "*Specified input model does not exist\.*" error?](#deeplens-mo-errors-21)
+ [How to handle the "*Failed to create directory \.\.\. Permission denied\!*" error?](#deeplens-mo-errors-22)
+ [How to handle the "*Discovered data node without inputs and value\.*" error?](#deeplens-mo-errors-23)
+ [How to handle the "*Placeholder node doesn't have input port, but input port was provided\.*" error?](#deeplens-mo-errors-28)
+ [How to handle the "*No or multiple placeholders in the model, but only one shape is provided, cannot set it\.*" error?](#deeplens-mo-errors-32)
+ [How to handle the "*Cannot write an event file for the tensorboard to directory\.*" error?](#deeplens-mo-errors-36)
+ [How to handle the "*Stopped shape/value propagation at node\.*" error?](#deeplens-mo-errors-38)
+ [How to handle the "*Module tensorflow was not found\. Please install tensorflow 1\.2 or higher\.*" error?](#deeplens-mo-errors-42)
+ [How to handle the "*Cannot read the model file: it is incorrect TensorFlow model file or missing\.*" error?](#deeplens-mo-errors-43)
+ [How to handle the "*Cannot pre\-process TensorFlow graph after reading from model file\. File is corrupt or has unsupported format\.*" error?](#deeplens-mo-errors-44)
+ [How to handle the "*Input model name is not in an expected format, cannot extract iteration number\.*" error?](#deeplens-mo-errors-48)
+ [How to handle the "*Cannot convert type of placeholder because not all of its outputs are 'Cast' to float operations\.*" error?](#deeplens-mo-errors-49)
+ [How to handle the "*Data type is unsupported\.*" error?](#deeplens-mo-errors-50)
+ [How to handle the "*No node with name \.\.\.*" error?](#deeplens-mo-errors-51)
+ [How to handle the "*Module mxnet was not found\. Please install mxnet 1\.0\.0*" error?](#deeplens-mo-errors-52)
+ [How to handle the "*The following error happened while loading mxnet model \.\.\.*" error?](#deeplens-mo-errors-53)
+ [How to handle the "*\.\.\. elements of \.\.\. were clipped to infinity while converting a blob for node \[\.\.\.\] to \.\.\.*" error?](#deeplens-mo-errors-76)
+ [How to handle the "*\.\.\. elements of \.\.\. were clipped to zero while converting a blob for node \[\.\.\.\] to \.\.\.*" error?](#deeplens-mo-errors-77)
+ [How to handle the "* topology contains no 'input' layers\.*" error?](#deeplens-mo-errors-79)

## How to handle the "*Current caffe\.proto does not contain field\.*" error?<a name="deeplens-mo-errors-cafee_proto-missing-field"></a>

Your model has custom layers that are not supported by the model optimizer\.

## How to create a bare Caffe model with only prototxt?<a name="deeplens-mo-errors-2"></a>

To create a bare Caffe model with only *\.prototxt*, import the Caffe module and run the following: 

```
python3 

import caffe 
net = caffe.Net('PATH_TO_PROTOTXT/my_net.prototxt', caffe.TEST) 
net.save('PATH_TO_PROTOTXT/my_net.caffemodel')
```

## How to handle the "*Unable to create ports for node with id\.*" error?<a name="deeplens-mo-errors-3"></a>

Your model has custom layers that aren't supported by the model optimizer\. Remove the custom layers\.

## How to Handle "*Invalid proto file: there is neither 'layer' nor 'layers' top\-level messages\.*" error?<a name="deeplens-mo-errors-7"></a>

The structure of a Caffe topology is described in the `caffe.proto` file\. For example, in the model optimizer you might find the following default `proto` file: `/opt/awscam/intel/deeplearning_deploymenttoolkit/deployment_tools/model_optimizer/mo/front/caffe/proto/my_caffe.proto`\. This file contains the structure, for example:

```
message NetParameter {
   // ... some other parameters

   // The layers that make up the net.  Each of their configurations, including 
   // connectivity and behavior, is specified as a LayerParameter. 
   repeated LayerParameter layer = 100;  // Use ID 100 so layers are printed last. 

   // DEPRECATED: use 'layer' instead. 
   repeated V1LayerParameter layers = 2; 
}
```

This means that any topology should contain layers as top\-level structures in *prototxt*\. For more information, see [LeNet topology](https://github.com/BVLC/caffe/blob/master/examples/mnist/lenet.prototxt)\.

## How to handle the "*Old\-style inputs \(via 'input\_dims'\) are not supported\. Please specify inputs via 'input\_shape'\.*" error?<a name="deeplens-mo-errors-8"></a>

The structure of a Caffe topology is described in the `caffe.proto` file\. For example, in the model optimizer, you can find the following default proto file: `/opt/awscam/intel/deeplearning_deploymenttoolkit/deployment_tools/model_optimizer/mo/front/caffe/proto/my_caffe.proto`\. This file contains the structure, for example:

```
message NetParameter {
    optional string name = 1; // Consider giving the network a name.
    // DEPRECATED. See InputParameter. The input blobs to the network. 
    repeated string input = 3; 
    // DEPRECATED. See InputParameter. The shape of the input blobs. 
    repeated BlobShape input_shape = 8; 

    // 4D input dimensions are deprecated.  Use "input_shape" instead. 
    // If specified, for each input blob, there should be four 
    // values specifying the num, channels, and height and width of the input blob. 
    // Therefore, there should be a total of (4 * #input) numbers. 
    repeated int32 input_dim = 4; 
    // ... other parameters 
}
```

Specify the input layer of the provided model using one of the following formats:

1. Input layer format 1:

   ```
   input: "data" 
   input_shape 
   { 
       dim: 1 
       dim: 3 
       dim: 227 
       dim: 227 
   }
   ```

1. Input layer format 2: 

   ```
   input: "data" 
   input_shape 
   { 
       dim: 1 
       dim: 3 
       dim: 600 
       dim: 1000 
   } 
   input: "im_info" 
   input_shape 
   { 
       dim: 1 
       dim: 3 
   }
   ```

1. Input layer format 3:

   ```
   layer 
   { 
       name: "data" 
       type: "Input" 
       top: "data"
       input_param {shape: {dim: 1 dim: 3 dim: 600 dim: 1000}} 
   } 
   
   layer 
   { 
       name: "im_info" 
       type: "Input" 
       top: "im_info" 
       input_param {shape: {dim: 1 dim: 3}} 
   }
   ```

1. Input layer format 4:

   ```
   input: "data" 
   input_dim: 1 
   input_dim: 3 
   input_dim: 500
   ```

However, if your model contains more than one input layer, the model optimizer can convert the model with an input layer of format 1, 2, and 3\. You can't use format 4 in any multi\-input topology\.

## How to handle the "*Invalid prototxt file: value error\.*" error?<a name="deeplens-mo-errors-11"></a>

See [How to Handle "*Invalid proto file: there is neither 'layer' nor 'layers' top\-level messages\.*" error? ](#deeplens-mo-errors-7) and [How to handle the "*Cannot find prototxt file: for Caffe please specify \-\-input\_proto \- a protobuf file that stores topology and \-\-input\_model that stores pretrained weights\.*" error? ](#deeplens-mo-errors-20)\. 

## How to handle the "*Error happened while constructing caffe\.Net in the Caffe fallback function\.*" error?<a name="deeplens-mo-errors-12"></a>

The model optimizer can't use the Caffe module to construct a net, while it is trying to infer a specified layer in the Caffe framework\. Make sure that your `.caffemodel` and `.prototxt` files are correct\. To make sure that the problem is not in the `.prototxt` file, see [How to create a bare Caffe model with only prototxt?](#deeplens-mo-errors-2)\.

## How to handle the "*Cannot infer shapes due to exception in Caffe\.*" error?<a name="deeplens-mo-errors-13"></a>

Your model has custom layers that are not supported by the model optimizer\. Remove any custom layers\.

## How to handle the "*Cannot infer shape for node \{\} because there is no Caffe available\. Please register python infer function for op or use Caffe for shape inference\.*" error?<a name="deeplens-mo-errors-14"></a>

Your model has custom layers that are not supported by the model optimizer\. Remove any custom layers\.

## How to handle the "*Input shape is required to convert MXNet model\. Please provide it with \-\-input\_width and \-\-input\_height\.*" error?<a name="deeplens-mo-errors-16"></a>

To convert a MXNet model to an IR, you must specify the input shape, because MXNet models do not contain information about input shapes\. Use the `–input_shape` flag to specify the `input_width` and `input_height`\.  

## How to handle the "*Cannot find prototxt file: for Caffe please specify \-\-input\_proto \- a protobuf file that stores topology and \-\-input\_model that stores pretrained weights\.*" error?<a name="deeplens-mo-errors-20"></a>

The model optimizer can't find a `prototxt` file for a specified model\. By default, the `.prototxt` file must be located in the same directory as the input model with the same name \(except for the extension\)\. If any of these conditions is not satisfied, use `--input_proto` to specify the path to the *prototxt* file\.

## How to handle the "*Specified input model does not exist\.*" error?<a name="deeplens-mo-errors-21"></a>

Most likely, you have specified an incorrect path to the model\. Make sure that the path is correct and the file exists\.

## How to handle the "*Failed to create directory \.\.\. Permission denied\!*" error?<a name="deeplens-mo-errors-22"></a>

The model optimizer can't create a directory specified as the `–output_dir` parameter\. Make sure that you have permissions to create the specified directory\.

## How to handle the "*Discovered data node without inputs and value\.*" error?<a name="deeplens-mo-errors-23"></a>

One of the layers in the specified topology might not have inputs or values\. Make sure that the provided `.caffemodel` and `.protobuf` files contain all required inputs and values\.

## How to handle the "*Placeholder node doesn't have input port, but input port was provided\.*" error?<a name="deeplens-mo-errors-28"></a>

You might have specified an input node for a placeholder node, but the model does not contain the input node\. Make sure that the model has the input or use a model\-supported input node\. 

## How to handle the "*No or multiple placeholders in the model, but only one shape is provided, cannot set it\.*" error?<a name="deeplens-mo-errors-32"></a>

You might have provided only one shape for the placeholder node for a model that contains no inputs or multiple inputs\. Make sure that you have provided the correct data for placeholder nodes\.

## How to handle the "*Cannot write an event file for the tensorboard to directory\.*" error?<a name="deeplens-mo-errors-36"></a>

The model optimizer failed to write an event file in the specified directory because that directory doesn't exist or you don't have permissions to write to it\. Make sure that the directory exists and you have the required write permission\.

## How to handle the "*Stopped shape/value propagation at node\.*" error?<a name="deeplens-mo-errors-38"></a>

The model optimizer can't infer shapes or values for the specified node because: the inference function has a bug, the input nodes have incorrect values or shapes, or the input shapes are invalid\. Verify that the inference function, input values, or shapes are correct\.

## How to handle the "*Module tensorflow was not found\. Please install tensorflow 1\.2 or higher\.*" error?<a name="deeplens-mo-errors-42"></a>

To use the model optimizer to convert TensorFlow models, install TensorFlow 1\.2 or higher\. 

## How to handle the "*Cannot read the model file: it is incorrect TensorFlow model file or missing\.*" error?<a name="deeplens-mo-errors-43"></a>

The model file should contain a TensorFlow graph snapshot of the binary format\. Ensure that –input\_model\_is\_text is provided for the model in the text format, by specifying the `--input_model_is_text` parameter as `false`\. By default, a model is interpreted a binary file\. 

## How to handle the "*Cannot pre\-process TensorFlow graph after reading from model file\. File is corrupt or has unsupported format\.*" error?<a name="deeplens-mo-errors-44"></a>

Make sure that you've specified the correct model file, the file has the correct format, and the content of the file isn't corrupted\. 

## How to handle the "*Input model name is not in an expected format, cannot extract iteration number\.*" error?<a name="deeplens-mo-errors-48"></a>

MXNet model files must be in \.json or \.para format\. Use the correct format\.

## How to handle the "*Cannot convert type of placeholder because not all of its outputs are 'Cast' to float operations\.*" error?<a name="deeplens-mo-errors-49"></a>

Use the FP32 data type for the model's placeholder node\. Don't use UINT8 as the input data type for the placeholder node\. 

## How to handle the "*Data type is unsupported\.*" error?<a name="deeplens-mo-errors-50"></a>

The model optimizer can't convert the model to the specified data type\. Set the data type with the `–precision` parameter with `FP16`, `FP32`, `half`, or `float` values\.

## How to handle the "*No node with name \.\.\.*" error?<a name="deeplens-mo-errors-51"></a>

The model optimizer can't access the node that doesn't exist\. Make sure to specify the correct placeholder, input node name, or output node name\.

## How to handle the "*Module mxnet was not found\. Please install mxnet 1\.0\.0*" error?<a name="deeplens-mo-errors-52"></a>

To ensure that the model optimizer can convert MXNet models, install MXNet 1\.0\.0 or higher\.

## How to handle the "*The following error happened while loading mxnet model \.\.\.*" error?<a name="deeplens-mo-errors-53"></a>

Make sure that the specified path is correct, that the model exists and is not corrupted, and that you have sufficient permissions to work with the model\.

## How to handle the "*\.\.\. elements of \.\.\. were clipped to infinity while converting a blob for node \[\.\.\.\] to \.\.\.*" error?<a name="deeplens-mo-errors-76"></a>

When you use the `--precision=FP16` command line option, the model optimizer converts all of the blobs in the node to the `FP16` type\. If a value in a blob is out of the range of valid FP16 values, the model optimizer converts the value to positive or negative infinity\. Depending on the model, this can produce incorrect inference results or it might not cause any problems\. Inspect the number of these elements and the total number of elements in the used blob that is printed out with the name of the node\.

## How to handle the "*\.\.\. elements of \.\.\. were clipped to zero while converting a blob for node \[\.\.\.\] to \.\.\.*" error?<a name="deeplens-mo-errors-77"></a>

When you use the `--precision=FP16` command line option, the model optimizer converts all of the blobs in the node to the `FP16` type\. If a value in the blob is so close to zero that it can't be represented as a valid FP16 value, the model optimizer converts it to true zero\. Depending on the model, this might produce incorrect inference results or it might not cause any problem\. Inspect the number of these elements and the total number of elements in the used blob that is printed out with the name of the node\.

## How to handle the "* topology contains no 'input' layers\.*" error?<a name="deeplens-mo-errors-79"></a>

The `prototxt` file for your Caffe topology might be intended for training when the model optimizer expects a deploy\-ready `.prototxt` file\. To prepare a deploy\-ready `.prototxt` file, follow the [instructions](https://github.com/BVLC/caffe/wiki/Using-a-Trained-Network:-Deploy) provided on GitHub\. Typically, preparing a deploy\-ready topology involves removing data layers, adding input layers, and removing loss layers\.