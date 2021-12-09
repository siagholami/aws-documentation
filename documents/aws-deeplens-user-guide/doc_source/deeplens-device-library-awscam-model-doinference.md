# model\.doInference Method<a name="deeplens-device-library-awscam-model-doinference"></a>

Runs inference on a video frame \(image file\) by applying the loaded model\. The method returns the result of the inference\.

**Request Syntax**

```
import awscam
model = awscam.Model(model_topology_file, loading_config)
raw_inference_results = model.doInference(video_frame)
```

**Parameters**
+ `video_frame`—Required\. A video frame from the AWS DeepLens video feeds\.

**Return Type**
+ `dict` — The inference result, as a dictionary of output layers based on the loaded model\.

**Returns**  
Returns a `dict` object with entries of key\-value pairs\. The key of an entry is the identifier of an output layer of the model\. For the output of inference running in the default Intel DLDT runtime, the output layer identifier is the output layer name as specified in the model\. For example, with MXNet, the output layer names are defined in the model's \.json file\. For the output of inference running in the Neo runtime, the output layer identifier is the ordinal number of the output layer as defined in the model\. The value of an entry is a `list` object that holds the probabilities of the input `video_frame` over the labeled images used to train the model\. 

**Example**  
**Sample output:**  
Running inference in the Intel DLDT runtime on a model with an output layer named `SoftMax_67` of six labels, the inference outcome has the following format\.   

```
{
   ‘SoftMax_67’: array(
       [  
          2.41881448e-08, 
          3.57339691e-09, 
          1.00263861e-07, 
          5.40415579e-09, 
          4.37702547e-04, 
          6.16787545e-08
       ], 
   dtype=float32)
}
```

If the Neo runtime \(`runtime=1`\) is used to run the inference, the raw inference result is a `dict` object, where `results[i]` holds the `ith` output layer\. For example, for an image classification network such as Resnet\-50 with only one Softmax output layer, `results[0]` is a `Numpy` array with size `N x 1` that gives the probability for each of the `N` labeled image types\. 

The following example output shows the raw inference result of the same model \(above\) running in the Neo runtime\.

```
{
   0 : array(
       [  
          2.41881448e-08, 
          3.57339691e-09, 
          1.00263861e-07, 
          5.40415579e-09, 
          4.37702547e-04, 
          6.16787545e-08
       ], 
   dtype=float32)
}
```