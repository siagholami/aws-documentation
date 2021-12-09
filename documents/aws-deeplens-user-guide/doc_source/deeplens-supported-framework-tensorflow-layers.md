# Supporting TensorFlow Layers<a name="deeplens-supported-framework-tensorflow-layers"></a>

You can use the following TensorFlow layers to train deep learning models that are supported by AWS DeepLens\.


| Supported TensorFlow Layers |  Layer | Description | 
| --- | --- | --- | 
|   Add   | Computes element\-wise addition | 
|  AvgPool   | Performs average pooling on the input | 
|   BatchToSpaceND   | Rearranges data from batch into blocks of spatial data | 
|  BiasAdd   | Adds bias | 
|   Const   | Creates a constant tensor | 
|   Conv2D   | Computes a 2\-D convolution | 
|   Conv2DBackpropInput   | Computes the gradients of convolution with respect to the input | 
|   Identity   | Returns a tensor with the same shape and contents as input | 
|   Maximum   | Computes element\-wise maximization\. | 
|   MaxPool   | Performs the max pooling on the input | 
|   Mean   | Computes the mean of elements across dimensions of a tensor | 
|   Mul   | Computes element\-wise multiplication | 
| Neg | Computes numerical negative value element\-wise | 
|   Pad  | Pads a tensor | 
|  Placeholder   | Inserts a placeholder for a tensor that will be always fed | 
|   Prod   | Computes the product of elements across dimensions of a tensor | 
|  RandomUniform   | Outputs random values from a uniform distribution | 
|   Range   | Creates a sequence of numbers | 
|   Relu   | Computes rectified linear activations | 
|   Reshape   | Reshapes a tensor | 
|   Rsqrt   | Computes reciprocal of square root | 
|   Shape   | Returns the shape of a tensor | 
|   Softmax   | Computes Softmax activations | 
|   SpaceToBatchND   | Zero\-pads and then rearranges blocks of spatial data into batch | 
|   Square   | Computes element\-wise square | 
|   Squeeze  | Removes dimensions of size 1 from the shape of a tensor | 
|   StopGradient   | Stops gradient computation | 
|   Sub   | Computes element\-wise subtraction | 
|   Sum   | Computes the sum of elements across dimensions of a tensor | 
|   Tile   | Constructs a tensor by tiling a given tensor | 

 For more information about TensorFlow layers, see [TensorFlow Layers ](https://www.tensorflow.org/api_docs/python/tf/layers)\. 