# Kotlin<a name="kotlin-language-support"></a>

You can add support for the CodeGuru Profiler agent into your Kotlin application by adding the following lines into your `startup` or `main` function\. 

```
import software.amazon.codeguruprofilerjavaagent.Profiler

fun main() {
    Profiler.builder()
        .profilingGroupName("MyProfilingGroup")
        .build()
        .start()
    ...
}
```

You need to add a dependency to the agent \.jar file\.