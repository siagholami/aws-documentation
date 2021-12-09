# Supporting MXNet Layers<a name="deeplens-supported-frameworks-mxnet-layers"></a>

You can use the following Apache MXNet modeling layers to train deep learning model for AWS DeepLens\.


| Supported MXNet Modeling Layers |  Layer | Description | 
| --- | --- | --- | 
|   Activation   |  Applies an activation function to the input  | 
|   BatchNorm   |  Applies batch normalization  | 
|   Concat   |  Joins input arrays along a given axis  | 
|   \_contrib\_MultiBoxDetection   |  Converts a multibox detection prediction  | 
|   \_contrib\_MultiBoxPrior   |  Generates prior boxes from data, sizes, and ratios  | 
|   Convolution   |  Applies a convolution layer on input  | 
|   Deconvolution   |  Applies a transposed convolution on input  | 
|   elemwise\_add   |  Applies element\-wise addition of arguments  | 
|   Flatten   |  Collapses the higher dimensions of an input into an 2\-dimensional array  | 
|   FullyConnected   |  Applies a linear transformation of `Y = WX + b` on input `X`  | 
|   InputLayer   |  Specifies the input to a neural network  | 
|   L2Norm   |  Applies `L2` normalization to the input array  | 
|  LRN \( Local Response Normalization \)  |  Applies local response normalization to the input array  | 
|   Pooling   |  Performs pooling on the input  | 
|   Reshape   |  Reshapes the input array with a different view without changing the data  | 
|   ScaleShift   |  Applies scale and shift operations on input elements  | 
|   SoftmaxActivation   |  Applies Softmax activation to the input  | 
|   SoftmaxOutput   |  Computes the gradient of cross\-entropy loss with respect to Softmax output  | 
|   transpose   |  Permutes the dimensions of an array  | 
|   UpSampling   |  Performs nearest\-neighbor or bilinear upsampling to input  | 
|   \_mul   |  Performs multiplication  | 
|   \_Plus   |  Performs an element\-wise sum of the input arrays with broadcasting  | 

 For more information about MXNet layers, see [ MXNet Gluon Neural Network Layers](https://gluon.mxnet.io/index.html)\.