# Troubleshooting<a name="troubleshooting"></a>

 This section helps you troubleshoot common problems you might encounter when working with Amazon CodeGuru Profiler\. 

**Topics**
+ [Why are certain methods missing from my profile?](#troubleshooting-missing-functions)
+ [I don't see any CodeGuru Profiler data in my application logs\.](#troubleshooting-agent-not-running)
+ [I get a ResourceNotFoundException in the application logs\. The profiling group doesn't exist\.](#troubleshooting-profiler-group-does-not-exist)
+ [I received a 403 Forbidden error in the agent\. The agent doesn't have permission to submit data\.](#troubleshooting-agent-permission)
+ [I don't see any data in the console\.](#troubleshooting-no-data)
+ [There isn't enough data\. The profile only has a few frames\.](#troubleshooting-not-enough-data)

## Why are certain methods missing from my profile?<a name="troubleshooting-missing-functions"></a>

The CodeGuru Profiler tool can miss methods that the Java virtual machine \(JVM\) has chosen to inline for performance reasons\. This inlining biases the CodeGuru Profiler data\.

Additionally, because CodeGuru Profiler does statistical sampling, methods that are rarely called in your application might not show up\.

## I don't see any CodeGuru Profiler data in my application logs\.<a name="troubleshooting-agent-not-running"></a>

Make sure you call `.start()` on your `Profiler` object at the beginning of your program\. After you deploy the CodeGuru Profiler agent to your application, wait 15 minutes for data to arrive\. Check the logs to make sure the agent is running\. When CodeGuru Profiler starts and is configured correctly, the log statement `Starting the Profiler` will appear\.

The following example shows a successful log record\. 

```
INFO: Attempting to report profile data: start=2020-01-16T18:38:39.286Z end=2020-01-16T18:43:39.564Z .... 
                
INFO: Successfully reported profile
```

## I get a ResourceNotFoundException in the application logs\. The profiling group doesn't exist\.<a name="troubleshooting-profiler-group-does-not-exist"></a>

Make sure you've created a profiling group with the same name that is used in the error through the console or API\. Also, be sure you're using the correct AWS Region for the profiler\. Do this by running your application in the same Region where you created the profiling group, or by manually configuring the agent to target a given Region\. 

For more information, see [Step 3: Set permissions for CodeGuru Profiler](https://docs.aws.amazon.com/codeguru/latest/profiler-ug/setting-up.html#setting-up-step-3)\.

## I received a 403 Forbidden error in the agent\. The agent doesn't have permission to submit data\.<a name="troubleshooting-agent-permission"></a>

Make sure you've given full CodeGuru Profiler permissions to the role the agent is running with\. Make sure the agent is using the right credentials, either through the default credential provider or by explicitly providing the credentials in the builder\. 

For more information, see [Setting up CodeGuru Profiler](https://docs.aws.amazon.com/codeguru/latest/profiler-ug/setting-up.html)\.

## I don't see any data in the console\.<a name="troubleshooting-no-data"></a>

Make sure the agent is configured and deployed successfully so that it reports profiles\. By default, the CodeGuru Profiler profiling agent profiles for five minutes before submitting its first profile\. Wait 10–15 minutes after the first profile submission, and check the logs to make sure the agent is running\.

If the problem persists, contact us at [codeguru\-profiler@amazon\.com](mailto:codeguru-profiler@amazon.com)\.

## There isn't enough data\. The profile only has a few frames\.<a name="troubleshooting-not-enough-data"></a>

For CodeGuru Profiler to provide statistically valid information, it needs your application to be running under load\. We recommend running your application for at least an hour with at least 30% CPU utilization\.