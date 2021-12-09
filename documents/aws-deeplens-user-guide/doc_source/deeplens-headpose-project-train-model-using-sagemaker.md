# Train a Head Pose Detection Model in Amazon SageMaker<a name="deeplens-headpose-project-train-model-using-sagemaker"></a>

To train our model in Amazon SageMaker, follow the steps below to create a Notebook using the Amazon SageMaker console:

**Create an Amazon SageMaker Notebook**

1. Sign in to the Amazon SageMaker console at [https://console\.aws\.amazon\.com/sagemaker/home?region=us\-east\-1](https://console.aws.amazon.com/sagemaker/home?region=us-east-1)\.

1. From the main navigation pane, choose **Notebook instances**\.

1. Under **Notebook instance settings** on the **Create notebook instance** page, do the following:

   1. Under **Notebook instance name**, type `TFHeadpose`\.

   1. Leave the default values for all other options\.

   1. Choose **Create notebook instance**\.

1. Next to the **TFHeadpose** notebook instance, choose **Open**, after the notebook instance status becomes **inService**\.

1. On the upper\-right corner, choose **Upload** to start importing a notebook instance and other needed files\. 

1. In the file picker, navigate to the **HeadPost\_SageMaker\_PythonSDK** folder in the previously cloned or downloaded **headpose\-estimator\-apache\-mxnet\-master** project folder\. Then, select the following files: 
   + **resnet\_headpose\.py**: This is a script that defines the workflow for training with the deep learning network architecture prescribed in the accompanying **resnet\_model\_headpose\.py** file applied to a specified input data\.
   + **resnet\_model\_headpose\.py**: This is a Python script that prescribes the deep learning network architecture used to train our model for head pose detection\.
   + **tensorflow\_resnet\_headpost\_for\_deeplens\.ipynb**: This is a Notebook instance to run an Amazon SageMaker job to manage training following the script of **resnet\_headpose\.py**, including data preparation and transformation\.

   Then, choose **Open**\.

   If you intend to run the preprocessing script on the AWS Cloud, navigate to the **headpose\-estimator\-apache\-mxnet\-master** folder, select the **preprocessingDataset\_py2\.py**, and choose **Open**\. 

1. On the **Files** tab in the **TFHeadpose** notebook, choose **Upload** for each of the newly selected files to finish importing the files into the notebook\. You're now ready to run an Amazon SageMaker job to train your model\.

1. Choose **tensorflow\_resnet\_headpose\_for\_deeplens\.ipynb** to open the notebook instance in a separate browser tab\. The notebook instance lets you step through the tasks necessary to run an Amazon SageMaker job to train your model and to transform the model artifacts to a format supported by AWS DeepLens\.

1.  Run an Amazon SageMaker job to train your model in the notebook instance\. The implementation is presented in separate code cells that can be run sequentially\.

   1. Under **Set up the environment**, the code cell contains the Python code to configure the data store for the input and output of the Amazon SageMaker model training job\. 

      ```
      import os
      import sagemaker
      from sagemaker import get_execution_role
      
      s3_bucket = 'deeplens-sagemaker-models-<my-name>'
      headpose_folder = 'headpose'
      
      #Bucket location to save your custom code in tar.gz format.
      custom_code_folder = 'customTFcodes'
      custom_code_upload_location = 's3://{}/{}/{}'.format(s3_bucket, headpose_folder, custom_code_folder)
      
      #Bucket location where results of model training are saved.
      model_artifacts_folder = 'TFartifacts'
      model_artifacts_location = 's3://{}/{}/{}'.format(s3_bucket, headpose_folder, model_artifacts_folder)
      
      #IAM execution role that gives SageMaker access to resources in your AWS account.
      #We can use the SageMaker Python SDK to get the role from our notebook environment. 
      
      role = get_execution_role()
      ```

      To use the [S3 bucket and folders](deeplens-headpose-project-set-up-data-store.md) as the data store, assign your S3 bucket name \(e\.g\., `deeplens-sagemaker-models-<my-name>`\) to the `s3_bucket` variable\. Make sure that the specified folder names all match what you have in the Amazon S3 bucket\. 

      To execute this code block, choose **Run** from the menu bar of the notebook instance\.  
![\[\]](http://docs.aws.amazon.com/deeplens/latest/dg/images/deeplens-tutorial-head-pose-notebook-run.png)

   1.  Under **Create a training job using the sagemaker\.tensorflow\.TensorFlow estimator**, the code cell contains the code snippet that performs the following tasks:

      1. Instantiate a [sagemaker\.tensorflow\.TensorFlow](https://github.com/aws/sagemaker-python-sdk/blob/master/src/sagemaker/tensorflow/README.rst) estimator class \(`estimator`\), with a specified training script and process configuration\.

      1. Start training the model \(`estimator.fit(…)`\) with the estimator, with the training data in a specified data store\. 

      The code snippet is shown as follows: 

      ```
      from sagemaker.tensorflow import TensorFlow
      
      source_dir = os.path.join(os.getcwd())
      
      # AWS DeepLens currently supports TensorFlow version 1.4 (as of August 24th 2018). 
      estimator = TensorFlow(entry_point='resnet_headpose.py',
                             framework_version = 1.4,
                             source_dir=source_dir,
                             role=role,
                             training_steps=25000, evaluation_steps=700,
                             train_instance_count=1, 
                             base_job_name='deeplens-TF-headpose',
                             output_path=model_artifacts_location,
                             code_location=custom_code_upload_location,
                             train_instance_type='ml.p2.xlarge',
                             train_max_run = 432000,
                             train_volume_size=100)
      
      
      # Head-pose dataset "HeadPoseData_trn_test_x15_py2.pkl" is in the following S3 folder. 
      dataset_location = 's3://{}/{}/datasets'.format(s3_bucket, headpose_folder)
      
      estimator.fit(dataset_location)
      ```

      To create the `estimator` object, you assign to `entry_point` the name of the Python file containing [the custom TensorFlow model training script](https://docs.aws.amazon.com/sagemaker/latest/dg/tf-training-inference-code-template.html)\. For this tutorial, this custom code file is `resnet_headpose.py` that was uploaded to the same directory where the notebook instance is located\. For `framework_version`, specify a TensorFlow version supported by AWS DeepLens\.

      With the `train_instance_type` of `ml.p2.xlarge`, it takes about 6\.7 billable compute hours to complete the training job \(`estimator.fit(…)`\)\. You can experiment with [other `train_instance_type` options](https://aws.amazon.com/sagemaker/pricing/instance-types/) to speed up the process or to optimize the cost\. 

      The successfully trained model artifact \(model\.tar\.gz\) is output to your S3 bucket: 

      ```
      s3://deeplens-sagemaker-models-<my-name>/headpose/TFartifacts/<training-job-name>/output/model.tar.gz
      ```

      where `<training-job-name>` is of the `<base_job_name>-<timestamp>`\. Using the training code above, an example of the `<training-job-name>` would be `deeplens-TF-headpose-2018-08-16-20-10-09-991`\. You must transform this model artifact into a frozen protobuff format that is supported by AWS DeepLens\.

   1.  To transform the trained model artifact \(model\.tar\.gz\) into a frozen protobuff file \(frozen\.model\.pb\), do the following:

      1. Run the following code to use the AWS SDK for Python \(`boto3`\) in a code cell in the notebook to download the trained model artifact from your S3 bucket to your notebook:

         ```
         import boto3
         s3 = boto3.resource('s3')
         
         #key = '{}/{}/{}/output/model.tar.gz'.format(headpose_folder, model_artifacts_folder,estimator.latest_training_job.name)
         key = '{}/{}/{}/output/model.tar.gz'.format(headpose_folder, model_artifacts_folder, 'deeplens-TF-headpose-2018-08-16-20-10-09-991')
         
         print(key)
         s3.Bucket(s3_bucket).download_file(key,'model.tar.gz')
         ```

         You can verify the downloaded files by running the following shell command in a code cell of the notebook and then examine the output\.

         ```
         !ls
         ```

      1. To uncompress the trained model artifact \(model\.tar\.gz\), run the following shell command in a code cell:

         ```
         !tar -xvf model.tar.gz
         ```

         This command will produce the following output:

         ```
         export/
         export/Servo/
         export/Servo/1534474516/
         export/Servo/1534474516/variables/
         export/Servo/1534474516/variables/variables.data-00000-of-00001
         export/Servo/1534474516/variables/variables.index
         export/Servo/1534474516/saved_model.pb
         ```

         The path to a model directory is of the `export/*/*` pattern\. You must specify the model directory path to make a frozen protobuff file from the model artifact\. You'll see how to get this directory path in the next step\.

      1. To get the model directory and cache it in memory, run the following Python code in a code cell of the notebook instance:

         ```
         import glob
         model_dir = glob.glob('export/*/*')
         # The model directory looks like 'export/Servo/{Assigned by Amazon SageMaker}'
         print(model_dir)
         ```

         The output is `['export/Servo/1534474516']`\.

         You can proceed to freezing the graph and save it in the frozen protobuff format\.

      1. To freeze the TensorFlow graph and save it in the frozen protobuff format, run the following Python code snippet in a code cell of the notebook instance\. The code snippet does the following:

         1. Calls `convert_variables_to_constants` from the `tf.graph_util` module to freeze the graph, 

         1. Calls `remove_training_nodes` from the `tf.graph_util` module to remove all unnecessary nodes\. 

         1. Calls `optimize_for_inference` from the `optimize_for_inference_lib` module to generate the inference `graph_def`\. 

         1. Serializes and saves the file as a protobuff\.

         ```
         import tensorflow as tf
         from tensorflow.python.tools import optimize_for_inference_lib
         def freeze_graph(model_dir, input_node_names, output_node_names):
             """Extract the sub graph defined by the output nodes and convert 
             all its variables into constant 
             Args:
                 model_dir: the root folder containing the checkpoint state file,
                 input_node_names: a comma-separated string, containing the names of all input nodes
                 output_node_names: a comma-separated string, containing the names of all output nodes, 
                                     
             """
             
             # We start a session using a temporary fresh Graph
             with tf.Session(graph=tf.Graph()) as sess:
                 # We import the meta graph in the current default Graph
                 tf.saved_model.loader.load(sess, [tf.saved_model.tag_constants.SERVING], model_dir)
         
                 # We use a built-in TF helper to export variables to constants
                 input_graph_def = tf.graph_util.convert_variables_to_constants(
                     sess, # The session is used to retrieve the weights
                     tf.get_default_graph().as_graph_def(), # The graph_def is used to retrieve the nodes 
                     output_node_names.split(",") # The output node names are used to select the usefull nodes
                 ) 
         
             # We generate the inference graph_def
             input_node_names=['Const_1']    # an array of the input node(s)
             output_graph_def = optimize_for_inference_lib.optimize_for_inference(tf.graph_util.remove_training_nodes(input_graph_def),
                                                                                  input_node_names.split(","),  # an array of input nodes
                                                                                  output_node_names.split(","), # an array of output nodes
                                                                                  tf.float32.as_datatype_enum)
             # Finally we serialize and dump the output graph_def to the filesystem
             with tf.gfile.GFile('frozen_model.pb', "wb") as f:
                     f.write(output_graph_def.SerializeToString())
         
         
         freeze_graph(model_dir[0], 'Const_1', 'softmax_tensor')
         ```

         As the result, the model artifact is transformed into the frozen protobuff format \(`frozen_model.pb`\) and saved to the notebook instance's home directory \(`model_dir[0]`\)\.

         In the code above, you must specify the input and output nodes, namely, `'Const_1'` and `'softmax_tensor'`\. For more details, see the **resnet\_model\_headpose\.py**\.

         When creating an AWS DeepLens project later, you'll need to add this frozen graph to the project\. For this you must upload the protobuff file to an Amazon S3 folder\. For this tutorial, you can use your Amazon SageMaker traing job's output folder \(`s3://deeplens-sagemaker-models-<my-name>/headpose/TFartifacts/<sagemaker-job-name>/output`\) in S3\. However, the model is considered an externally trained model in AWS DeepLens\.

   1. To upload the frozen graph to your Amazon SageMaker training job's output folder, run the following Python code snippet in a code cell of the running notebook instance:

      ```
      data = open('frozen_model.pb', "rb")
      #key = '{}/{}/{}/output/frozen_model.pb'.format(headpose_folder, model_artifacts_folder,estimator.latest_training_job.name)
      key = '{}/{}/{}/output/frozen_model.pb'.format(headpose_folder, model_artifacts_folder, 'deeplens-TF-headpose-2018-08-16-20-10-09-991')
      s3.Bucket(s3_bucket).put_object(Key=key, Body=data)
      ```

      Once uploaded, the model is ready to be imported into your AWS DeepLens project\. Before creating the project, we must [create a Lambda function that performs inference based on this trained model](deeplens-headpose-project-create-inference-lambda-function.md)\.