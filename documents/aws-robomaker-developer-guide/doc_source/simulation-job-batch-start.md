# Starting a Simulation Job Batch<a name="simulation-job-batch-start"></a>

Simulation job batches are started from the AWS SDK or AWS CLI\. A simulation job batch includes one or more simulation job requests\. Each simulation job request identifies which applications to use in each simulation, the maximum duration of the job, and other information\. You can apply tags to the simulation job batch and each simulation job request\. 

**To start a simulation job batch, you must do the following:**

1. Install the AWS Command Line Interface\. For more information about installing the AWS CLI, see [Installing the AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-install.html)\. 

1. Copy the following JSON into a file named `startsimjobbatch.json`\. Modify the file to match your desired configuration, and then save it\. 

   ```
   {
       "batchPolicy": {
           "timeoutInSeconds": 400,
           "maxConcurrency": 2
       },
       "createSimulationJobRequests": [
           {
               "maxJobDurationInSeconds": 300,
               "iamRole": "arn:aws:iam::111111111111:role/MyRole",
               "failureBehavior": "Fail",
               "robotApplications": [
                   {
                       "application": "arn:aws:robomaker:us-east-1:111111111111:robot-application/MyRobotApplicationArn",
                       "launchConfig": {
                           "packageName": "hello_world_robot",
                           "launchFile": "rotate.launch"
                       }
                   }
               ],
               “simulationApplications": [
                   {
                       "application": "arn:aws:robomaker:us-east-1:111111111111:simulation-applicationMySimulationApplicationArn",
                       "launchConfig": {
                           "packageName": "hello_world_simulation",
                           "launchFile": "simulation.launch"
                       }
                   }
               ],
               "tags": { 
               	"myRequestTagKey" : "myRequestTagValue" 
               }
           },
           {
               "maxJobDurationInSeconds": 200,
               "iamRole": "arn:aws:iam::111111111111:role/MyRole",
               "failureBehavior": "Fail",
               “simulationApplications": [
                   {
                       "application": "arn:aws:robomaker:us-east-1:111111111111:simulation-applicationMySimulationApplicationArn",
                       "launchConfig": {
                           "packageName": "hello_world_simulation",
                           "launchFile": "simulation.launch"
                       }
                   }
               ]
           }
       ],
       "tags": { 
            "myBatchTagKey" : "myBatchTagValue" 
        }
   }
   ```

1. Open a command prompt, then run the following AWS CLI command:

   ```
   $ aws robomaker start-simulation-job-batch start-simulation-job-batch --cli-input-json  file://startsimjobbatch.json
   ```

   To view the simulation job batch, see [Viewing a Simulation Job Batch](simulation-job-batch-describe.md)\.