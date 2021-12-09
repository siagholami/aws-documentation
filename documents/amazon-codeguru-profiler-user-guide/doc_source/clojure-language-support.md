# Clojure<a name="clojure-language-support"></a>

You can add support for the CodeGuru Profiler agent into your Clojure application by adding the following lines into your `startup` or `main` function\. 

```
(-> (software.amazon.codeguruprofilerjavaagent.Profiler/builder)
    (.profilingGroupName "MyProfilingGroup")
    (.awsCredentialsProvider myAwsCredentialsProvider) ; optional
    (.build)
    (.start))
...
```

You need to add a dependency to the agent \.jar file\.