# mo\.optimize Method<a name="deeplens-model-optimizer-api-functions_and_objects"></a>

 Converts AWS DeepLens model artifacts from a Caffe \(`.prototxt` or `.caffemodel`\), MXNet \(`.json` and `.params`\), or TensorFlow \(`.pb`\) representation to an AWS DeepLens representation and performs necessary optimization\. 

**Syntax**

```
import mo
res = mo.optimize(model_name, input_width, input_height, platform, aux_inputs)
```

**Request Parameters**
+ `model_name`: The name of the model to optimize\. 

  Type: `string`

  Required: Yes
+ `input_width`: The width of the input image in pixels\. The value must be a non\-negative integer less than or equal to 1024\. 

  Type: `integer`\.

  Required: Yes
+ `input_height`: The height of the input image in pixels\. The value must be a non\-negative integer less than or equal to 1024\. 

  Type: `integer`\.

  Required: Yes
+ `platform`: The source platform for the optimization\. For valid values, see the following table\.

  Type: `string`

  Required: No  
**Valid `platform` Values:**    
<a name="table-mo-optimize-platform-values"></a>[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/deeplens/latest/dg/deeplens-model-optimizer-api-functions_and_objects.html)
+ `aux_inputs`: A Python dictionary object that contains auxiliary inputs, including entries common to all platforms and entries specific to individual platforms\. 

  Type: `Dict`

  Required: No  
**Valid `aux_inputs` dictionary Entries**    
<a name="table-mo-optimize-aux_inputs-values"></a>[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/deeplens/latest/dg/deeplens-model-optimizer-api-functions_and_objects.html)

**Returns**

The `optimize` function returns a result that contains the following:
+ `model_path`: Path of the optimized model artifacts when they are successfully returned\.

  Type: string
+ `status`: Operational status of the function\. For possible cause of failures and corrective actions when the method call fails, see the status table below\. 

  Type: integer  
****    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/deeplens/latest/dg/deeplens-model-optimizer-api-functions_and_objects.html)

To load the optimized model for inference, call the [`awscam.Model`](deeplens-device-library-awscam-model-constructor.md) API and specify the `model_path` returned from this function\.