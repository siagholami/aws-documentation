# Model Class Constructor<a name="deeplens-device-library-awscam-model-constructor"></a>

Creates an `awscam.Model` object to run inference in a specific type of processor and a particular inference runtime\. For models that are not Neo\-compiled, the `Model` object exposes parsing the raw inference output in order to return model\-specific inference results\.

**Request Syntax**

```
import awscam
model = awscam.Model(model_topology_file, loading_config, runtime=0)
```

**Parameters**
+ `model_topology_file`—Required\. When `runtime=0`, this parameter value is the path to an optimized model \(\.xml\) file output by the [`mo.optimize`](#deeplens-device-library-awscam-model-constructor) method\. When runtime=1, this parameter value is the name of the folder containing the compiled model artifacts, which include a *\.json* file, a *\.params* file, and a *\.so* file\.

  Neo\-compiled models support only the Classification model type\. Other models support Classification, Segmentation, and Single Shot MultiBox Detector \(SSD\)\.
**Note**  
 When deploying an Amazon SageMaker\-trained SSD model, you must first run `deploy.py` \(available from [https://github\.com/apache/incubator\-mxnet/tree/master/example/ssd/](https://github.com/apache/incubator-mxnet/tree/master/example/ssd/)\) to convert the model artifact into a deployable mode\. After cloning or downloading [the MXNet repository](https://github.com/apache/incubator-mxnet), run the `git reset --hard 73d88974f8bca1e68441606fb0787a2cd17eb364` command before calling `deploy.py` to convert the model, if the latest version does not work\.
+ `loading_config` \(dict\)—Required\. Specifies whether the model should be loaded into the GPU or CPU\. The format of this parameter is a dictionary\.

**Valid values:**
  + `{"GPU":1}`—Loads the model into the GPU\. To run inference in the Neo runtime \(`runtime=1`\), you must select GPU \(`{'GPU':1}`\)\.
  + `{"GPU":0}`—Loads the model into the CPU\.
+  `runtime` int—Optional\. Specifies the runtime to run inference in\. 

**Valid values:**
  + `0`—Intel DLDT as the default inference runtime\.
  + `1`—The Neo runtime to run inference on a compiled model\.