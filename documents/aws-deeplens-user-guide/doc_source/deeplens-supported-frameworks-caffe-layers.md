# Supporting Caffe Layers<a name="deeplens-supported-frameworks-caffe-layers"></a>

You can use the following Caffe layers to train deep learning models supported by AWS DeepLens\.


| Supported Caffe Layers |  Layer | Description | 
| --- | --- | --- | 
| BatchNorm | Normalizes the input to have 0\-mean and/or unit variance across the batch | 
| Concat | Concatenates input blobs | 
| Convolution | Convolves the input with a bank of learned filters | 
| Deconvolution | Performs in the opposite sensor of the Convolution layer | 
| Dropout | Performs dropout | 
| Eltwise | Performs element\-wise operations, such as product and sum, along multiple input blobs | 
| Flatten | Reshapes the input blob into flat vectors | 
| InnerProduct | Computes an inner product | 
| Input | Provides input data to the model | 
| LRN \(Local Response Normalization\) | Normalizes the input in a local region across or within feature maps | 
| Permute | Permutes the dimensions of a blob | 
| Pooling | Pools the input image by taking the max, average, etc\.,\. within regions | 
| Power | Computes the output as `(shift + scale * x) ^ power` for each input element `x` | 
| ReLU | Computes rectified linear activations | 
| Reshape | Changes the dimensions of the input blob, without changing its data | 
| ROIPooling | Applies pooling for each region of interest | 
| Scale | Computes the element\-wise product of two input blobs | 
| Slice | Slices an input layer to multiple output layers along a given dimension | 
| Softmax | Computes the Softmax activations | 
| Tile | Copies a blob along specified dimensions | 

 For more information about Caffe layers, see [Caffe Layers ](http://caffe.berkeleyvision.org/tutorial/layers.html)\. 