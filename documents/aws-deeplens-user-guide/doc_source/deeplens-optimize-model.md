# Optimize a Custom Model<a name="deeplens-optimize-model"></a>

AWS DeepLens uses the Computer Library for Deep Neural Networks \(clDNN\) to leverage the GPU for performing inferences\. If your model artifacts are not compatible with the clDNN format, you must convert your model artifacts by calling the model optimization \(mo\) module\. The process is known as model optimization\. Model artifacts output by MXNet, Caffe or TensorFlow are not optimized\. 

To optimize your model artifacts, call the [`mo.optimize`](deeplens-model-optimizer-api-functions_and_objects.md) method as illustrated in the following code:

```
error, model_path = mo.optimize(model_name,input_width,input_height)
```

To load a model artifact for inference in your inference Lambda function, specify the model artifact path on the device\. For an unoptimized model artifact, you must use the `model_path` returned from the above method call\. 

Models are deployed to the `/opt/awscam/artifacts` directory on the device\. An optimized model artifact is serialized into an XML file and you can assign the file path directly to the `model_path` variable\. For an example, see [Create and Publish an AWS DeepLens Inference Lambda Function](deeplens-inference-lambda-create.md)\.

For MXNet model artifacts, the model optimizer can convert `.json` and `.params` files\. For Caffe model artifacts, the model optimizer can take `.prototxt` or `.caffemodel` files\. For TensorFlow model artifacts, the model optimizer expects the frozen graph \(`.pb`\) file\. 

For more information about the model optimizer, see [Model Optimization \(mo\) Module](deeplens-model-optimizer-api.md)\.