# Supported MXNet Models Exposed by the Gluon API<a name="deeplens-supported-frameworks-gluon"></a>

AWS DeepLens supports the following Apache MXNet deep learning models from the Gluon model zoo that are exposed by the Gluon API\.


| Supported Gluon Models |  Model | Description | 
| --- | --- | --- | 
|   AlexNet   |  Image classification model trained on the ImageNet dataset imported from the Open Neural Network Exchange \(ONNX\)\.   | 
|   MobileNet   |  Image classification model trained in TensorFlow using the RMSprop optimizer\.  | 
|   ResNet   |  Image classification model trained on the ImageNet dataset imported from MXNet\.   | 
|   SqueezeNet   |  Image classification model trained on the ImageNet dataset imported from ONNX\.   | 
|   VGG   |  Image classification model trained on the ImageNet dataset imported from MXNet or ONNX\.   | 

**Example**  
The following example shows how to export a SqueezeNet version 1 model using the Gluon API\. The output is a symbol and parameters file\. The filename has the '`squeezenet`' prefix\.  

```
import mxnet as mx
from mxnet.gluon.model_zoo import vision
squeezenet = vision.squeezenet_v1(pretrained=True, ctx=mx.cpu())

# To export, you need to hybridize your gluon model,
squeezenet.hybridize()

# SqueezeNet’s input pattern is 224 pixel X 224 pixel images. Prepare a fake image,
fake_image = mx.nd.random.uniform(shape=(1,3,224,224), ctx=mx.cpu())

# Run the model once.
result = squeezenet(fake_image)

# Now you can export the model. You can use a path if you want ‘models/squeezenet’.
squeezenet.export(‘squeezenet')
```

 For a complete list of models and more information, see the [Gluon Model Zoo](https://gluon-cv.mxnet.io/model_zoo/index.html)\. 