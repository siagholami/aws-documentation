--------

--------

# Creating a Flow with Lambda Functions by Using the AWS CLI<a name="iot-tg-gs-lambda-sample-deploy-cli"></a>

This topic contains the AWS CLI commands that create the flow in [Create a Flow With Lambda Functions](iot-tg-gs-lambda-sample.html)\. The setup instructions for this example are identical to the ones in that topic\. Before starting with this example, follow all of the instructions in that topic up to [Create and Deploy the Flow](iot-tg-gs-lambda-sample.html#iot-tg-gs-lambda-sample-proc), and then return to this topic\.

## Install the CLI<a name="iot-tg-gs-lambda-sample-deploy-cli-install"></a>

To install the AWS CLI, follow the instructions in [Installing the AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-install.html)\.

## Create the Flow by Using the AWS CLI<a name="iot-tg-gs-lambda-sample-deploy-cli-steps"></a>

The following steps describe how to create and deploy the flow by using the AWS CLI\.

1. The following AWS IoT Things Graph Data Model \(TDM\) code contains the definition of the flow used in this example\. 

   Copy this code to a file\. Replace the *REGION* and *ACCOUNT ID* placeholders with your AWS Region and account ID\. Replace the *S3 BUCKET IN `SaveToS3`* placeholder with the name of the Amazon S3 bucket that you're using in the `SaveToS3` Lambda function\.

   ```
   {
   query TextProcessing @workflowType(id: \"urn:tdm:REGION/ACCOUNT ID/default:Workflow:TextProcessing\") {
     variables {
       getS3LambdaResult @property(id: \"urn:tdm:aws/examples:property:getS3ObjectAsStringResponse\")
       wordCountLambdaResult @property(id: \"urn:tdm:aws/examples:property:wordCountResponse\")
     }
     steps {
       step(name: \"getS3Lambda", outEvent: [\"getS3LambdaDone\"]) {
         WebserviceActivity(webservice: \"urn:tdm:aws/examples:Service:getS3Lambda\", out: \"getS3LambdaResult\") {
           getS3ObjectAsString(bucket: \"S3 BUCKET IN SaveToS3\", key: \"HelloWorld.txt\")
         }
       }
       step(name: \"wordCountLambda", inEvent: [\"getS3LambdaDone\"], outEvent: [\"wordCoundLambdaDone\"]) {
         WebserviceActivity(webservice: \"urn:tdm:aws/examples:Service:wordCountLambda\", out: \"wordCountLambdaResult\") {
           wordCount(message: \"${getS3LambdaResult.message}\")
         }
       }
       step(name: \"saveResponseLambda\", inEvent: [\"wordCoundLambdaDone\"]) {
         WebserviceActivity(webservice: \"urn:tdm:aws/examples:Service:saveResponseLambda\") {
           save(response: \"${wordCountLambdaResult}\")
         }
       }
     }
   }
   }
   ```

1. Enter the following command to create the flow\. This command assumes that you're working in a Linux or Unix environment\. For other environments, use the equivalent of the `cat` utility\.

   ```
   aws iotthingsgraph create-flow-template --definition language=GRAPHQL,text='"'"$(cat PATH TO TDM FILE)"'"'
   ```

1. The following TDM code contains the definition of the system used in this example\. Because the flow contains no devices or device models, this system contains only the flow\. 

   Copy this code to a file\. Replace the *REGION* and *ACCOUNT ID* placeholders with your AWS Region and account ID\.

   ```
   {
   type TextProcessing @systemType(id: \"urn:tdm:REGION/ACCOUNT ID/default:System:TextProcessing", description: \"Text processing system\") {
     TextProcessing: Flow @workflow(id: \"urn:tdm:REGION/ACCOUNT ID/default:Workflow:TextProcessing\")
   }
   }
   ```

1. Enter the following command to create the system\.

   ```
   aws iotthingsgraph create-system-template --definition language=GRAPHQL,text='"'"$(cat PATH TO TDM FILE)"'"'
   ```

1. The following TDM code contains the definition of the flow configuration used in this example\. The TDM definition is inside the `definition` object\. For more information, see [Creating Flow Configurations](iot-tg-sysdeploy-depconfig.html)\. 

   Copy this code to a file\. Replace the *REGION* and *ACCOUNT ID* placeholders with your AWS Region and account ID\.

   ```
   {
   query LambdaDeployment @deployment(id: \"urn:tdm:REGION/ACCOUNT ID/default:Deployment:LambdaDeployment\", systemId: \"urn:tdm:REGION/ACCOUNT ID/default:System:TextProcessing\") {
   triggers {
   TimeTrigger(description: \"Time based trigger\") {
       condition(expr: \"every 60 seconds\")
       action(expr: \"ThingsGraph.startFlow('TextProcessing')\")
       }
       }
      }
   }
   ```

1. Enter the following command to create the flow configuration\. Replace *GREENGRASS GROUP* and *S3 BUCKET* with the names of your AWS IoT Greengrass group and Amazon S3 bucket\.

   ```
   aws iotthingsgraph create-system-instance --definition language=GRAPHQL,text='"'"$(cat PATH TO TDM FILE)"'"' \
                   --target GREENGRASS --greengrass-group-name GREENGRASS GROUP --s3-bucket-name S3 BUCKET
   ```

   When the operation completes, the AWS CLI returns the following deployment summary as a JSON object\. Use the `id` value in the `summary` block as the TDM URN of the flow configuration\. 

   ```
   {
       "summary": {
           "status": "PENDING_DEPLOYMENT",
           "greengrassGroupName": "ThingsGraphGrnGr",
           "target": "GREENGRASS",
           "arn": "arn:aws:iotthingsgraph:REGION:ACCOUNT ID:default#Deployment#LambdaDeployment",
           "updatedAt": 1555022420.184,
           "id": "urn:tdm:REGION/ACCOUNT ID/default:Deployment:LambdaDeployment",
           "createdAt": 1555022420.184
       }
   }
   ```

1. Enter the following command to deploy the flow configuration to your AWS IoT Greengrass group\. Use the TDM URN value returned in the previous step as the value of the `id` parameter\.

   ```
   aws iotthingsgraph deploy-system-instance --id SYSTEM INSTANCE URN
   ```

## Delete the Flow and Flow Configuration \(Optional\)<a name="iot-tg-gs-thingdev-sample-cleanup"></a>

For instructions on how to undeploy a flow configuration, and delete the flow configuration and flow that you've created, see [Deleting Flow Configurations](iot-tg-lifecycle.html#iot-tg-lifecycle-deletingflowconfig) and [Deleting Systems, Flows, and Namespaces](iot-tg-lifecycle.html#iot-tg-lifecycle-deletingsysflow) in [Lifecycle Management for AWS IoT Things Graph Entities, Flows, Systems, and Deployments](iot-tg-lifecycle.html)\.