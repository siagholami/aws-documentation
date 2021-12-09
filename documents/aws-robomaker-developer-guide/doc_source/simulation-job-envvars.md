# Environment Variables Created by AWS RoboMaker<a name="simulation-job-envvars"></a>

AWS RoboMaker defines these simulation job environment variables\.
+ `AWS_ROBOMAKER_SIMULATION_JOB_ID`
+ `AWS_ROBOMAKER_SIMULATION_JOB_ARN`
+ `AWS_ROBOMAKER_SIMULATION_RUN_ID`

You can get these variables from your application or from the command line\. For example, to get the current simulation job Amazon Resource Name \(ARN\) in Python, use `os.environ.get("AWS_ROBOMAKER_SIMULATION_JOB_ARN")`\. 

If you specified an Amazon Simple Storage Service output bucket for the simulation job, you can use the environment variables to find the output path\. AWS RoboMaker writes output to `s3://bucket-name/AWS_ROBOMAKER_SIMULATION_JOB_ID/AWS_ROBOMAKER_SIMULATION_RUN_ID`\. Use this to manage objects in Amazon S3 from code or the command line\. 