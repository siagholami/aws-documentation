# Java<a name="java-language-support"></a>

You can add support for the CodeGuru Profiler agent into your Java application by adding the following lines into your `startup` or `main` function\. 

```
import software.amazon.codeguruprofilerjavaagent.Profiler;

class MyClass {
    public static void main(String[] args) {
        Profiler.builder()
            .profilingGroupName("MyProfilingGroup")
            .build()
            .start();
        ...
    }
}
```

You need to add a dependency to the agent \.jar file\.