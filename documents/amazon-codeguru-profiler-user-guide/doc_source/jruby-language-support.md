# JRuby<a name="jruby-language-support"></a>

You can add support for the CodeGuru Profiler agent into your JRuby application by adding the following lines into your `startup` or `main` function\. 

```
Java::SoftwareAmazonCodeguruprofilerjavaagent::Profiler
    .builder
    .profiling_group_name("MyProfilingGroup")
    .aws_credentials_provider(myAwsCredentialsProvider) # optional
    .build
    .start
...
```

You need to add a dependency to the agent \.jar file\.