# Working with unsupported AWS Regions<a name="working-with-unsupported-regions"></a>

To use Amazon CodeGuru Profiler in an AWS Region it doesn't support, you can configure your agent to submit profiles to one of the supported Regions instead\. You can specify which AWS Region to submit profiles to by using `.awsRegionToReportTo(<AWS Region>)`\. For example, using CodeGuru Profiler in `eu-west-1` would mean that profiled data would be stored in that Region\. 

You should create the profiling group in the target AWS Region, which might differ from the Region that the application is running in\. The application role should have permissions set up to allow profiles to be submitted to the target Region\.

The following code example demonstrates how to configure your agent to get access to the CodeGuru Profiler console from `eu-west-1`\. You can do this for any of the supported Regions, by replacing `EU_WEST_1` with the Region name you want\.

```
Profiler.builder()
        .profilingGroupName("ExampleAppConsumingCodeGuruProfilerJavaAgent") 
        .awsRegionToReportTo(Region.EU_WEST_1) 
        .build() 
        .start();
```

To submit any profiles to the CodeGuru Profiler API, your host must have internet access\.