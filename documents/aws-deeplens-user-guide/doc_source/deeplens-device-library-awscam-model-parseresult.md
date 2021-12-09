# `model.parseResult` Method<a name="deeplens-device-library-awscam-model-parseresult"></a>

Parses the raw inference results of some commonly used models, such as classification, SSD, and segmentation models, which are not Neo\-compiled\. For customized models, you write your own parsing functions\.

**Request Syntax**

```
import awscam
model = awscam.Model(model_topology_file, loading_config)
raw_infer_result = model.doInference(video_frame)
result = model.parseResult(model_type, raw_infer_result)
```

**Parameters**
+ `model_type`—String that identifies the model type to use to generate the inference\. Required\. 

  Valid values: `classification`, `ssd`, and `segmentation`
**Note**  
 When deploying an Amazon SageMaker\-trained SSD model, you must first run `deploy.py` \(available from [https://github\.com/apache/incubator\-mxnet/tree/master/example/ssd/](https://github.com/apache/incubator-mxnet/tree/master/example/ssd/)\) to convert the model artifact into a deployable mode\. After cloning or downloading [the MXNet repository](https://github.com/apache/incubator-mxnet), run the `git reset --hard 73d88974f8bca1e68441606fb0787a2cd17eb364` command before calling `deploy.py` to convert the model, if the latest version does not work\.
+ `raw_infer_result`—The output of the function `model.doInference(video_frame)`\. Required\.

**Return Type**
+ `dict`

**Returns**  
Returns a `dict` with a single entry of key\-value pair\. The key is the `model_type` value\. The value is a list of `dict` objects\. Each of the returned `dict` objects contains the probability calculated by the model for a specified label\. For some model types, such as `ssd`, the returned `dict` object also contains other information, such as the location and size of the bounding box the inferred image object is located in\.

**Example**  
**Sample output**:  
For the raw inference performed in the Intel DLDT runtime, the parsed inference result on a `classification` model type has the following format:  

```
{
    "classification":[
        {"label":"318", "prob":0.5},
        {"label":"277", "prob":0.3},
        ...,
        {"label":"433", "prob":0.001}
    ]
}
```
The corresponding parsed inference result on an `ssd` model type contains bounding box information and has the following format:  

```
{
    "ssd": [
        {"label": "318", "xmin": 124, "xmax": 245, "ymin": 10,  "ymax": 142, "prob": 0.5},
        {"label": "277", "xmin": 89,  "xmax": 166, "ymin": 233, "ymax": 376, "prob": 0.3},
        ...,
        {"label": "433", "xmin": 355, "xmax": 468, "ymin": 210, "ymax": 266, "prob": 0.001}
    ]
}
```
For inferences performed in the Neo runtime, the parsed inference result is the same as the raw inference result\.