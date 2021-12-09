# MXBoard<a name="tutorial-mxboard"></a>

 [MXBoard](https://github.com/awslabs/mxboard) lets you to visually inspect and interpret your MXNet runs and graphs using the TensorBoard software\. It runs a web server that serves a webpage for viewing and interacting with the MXBoard visualizations\. 

MXNet, TensorBoard, and MXBoard are preinstalled with the Deep Learning AMI with Conda \(DLAMI with Conda\)\. In this tutorial, you use an MXBoard function to generate logs that are compatible with TensorBoard\.

**Topics**
+ [Using MXNet with MXBoard](#tutorial-mxboard-example)
+ [More Info](#tutorial-mxboard-project)

## Using MXNet with MXBoard<a name="tutorial-mxboard-example"></a>

**Generate MXBoard Log Data Compatible with TensorBoard**

1. Connect to your Amazon Elastic Compute Cloud \(Amazon EC2\) instance of the DLAMI with Conda\. 

1. Activate the Python 3 MXNet environment\.

   ```
   $ source activate mxnet_p36
   ```

1. Prepare a Python script for writing data generated by the normal operator to an event file\. The data is generated ten times with decreasing standard deviation, then written to the event file each time\. You will see data distribution gradually become more centered around the mean value\. Note that you will specify the event file in the logs folder\. You pass this folder path to the TensorBoard binary\.

   ```
   $ vi mxboard_normal.py
   ```

1. Paste the following in the file and save it:

   ```
   import mxnet as mx
   from mxboard import SummaryWriter
   
   
   with SummaryWriter(logdir='./logs') as sw:
       for i in range(10):
           # create a normal distribution with fixed mean and decreasing std
           data = mx.nd.normal(loc=0, scale=10.0/(i+1), shape=(10, 3, 8, 8))
           sw.add_histogram(tag='norml_dist', values=data, bins=200, global_step=i)
   ```

1. Run the script\. This will generate logs in a `logs` folder that you can use for visualizations\.

   ```
   $ python mxboard_normal.py
   ```

1. Now you must switch to the TensorFlow environment to use TensorBoard and MXBoard to visualize the logs\. This is a required dependency for MXBoard and TensorBoard\.

   ```
   $ source activate tensorflow_p36
   ```

1. Pass the location of the logs to `tensorboard`: 

   ```
   $ tensorboard --logdir=./logs --host=127.0.0.1 --port=8888
   ```

   TensorBoard launches the visualization web server on port 8888\.

1. For easy access from your local browser, you can change the web server port to port 80 or another port\. Whichever port you use, you will need to open this port in the EC2 security group for your DLAMI\. You can also use port forwarding\. For instructions on changing your security group settings and port forwarding, see [Set up a Jupyter Notebook Server](setup-jupyter.md)\. The default settings are described in the next step\.
**Note**  
If you need to run both Jupyter server and a MXBoard server, use a different port for each\. 

1. Open port 8888 \(or the port you assigned to the visualization web server\) on your EC2 instance\.

   1. Open your EC2 instance in the Amazon EC2console at [https://console\.aws\.amazon\.com/ec2/](https://console.aws.amazon.com/ec2/)\.

   1. In the Amazon EC2 console, choose **Network & Security**, then choose **Security Groups**\.

   1. For **Security Group**, , choose the one that was created most recently \(see the timestamp in the description\)\.

   1.  Choose the **Inbound** tab, and choose **Edit**\.

   1. Choose **Add Rule**\. 

   1. In the new row, type the followings: 

      **Type** : Custom **TCP Rule**

      **Protocol**: **TCP**

      **Port Range**: **8888** \(or the port that you assigned to the visualization server\)

      **Source**: **Anywhere** \(**0\.0\.0\.0/0,::/0**\)

1. If you want to visualize the data from local browser, type the following command to forward the data that is rendering on the EC2 instance to your local machine\.

   ```
   $ ssh -Y -L localhost:8888:localhost:8888 user_id@ec2_instance_ip
   ```

1. Open the web page for the MXBoard visualizations by using the public IP or DNS address of the EC2 instance that's running the DLAMI with Conda and the port that you opened for MXBoard: 

   **http://127\.0\.0\.1:8888**

## More Info<a name="tutorial-mxboard-project"></a>

To learn more about MXBoard, see the [MXBoard website](https://github.com/awslabs/mxboard)\.