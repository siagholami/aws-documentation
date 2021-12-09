# Jython<a name="jython-language-support"></a>

You can add support for the CodeGuru Profiler agent into your Jython application by adding the following lines into your `startup` or `main` function\. 

```
import sys
sys.path.append("/path/to/codeguru-profiler-java-agent-standalone-1.0.0.jar")
from software.amazon.codeguruprofilerjavaagent import Profiler

Profiler.builder()
    .profilingGroupName("MyProfilingGroup")
    .build()
    .start()
...
```

You need to add a dependency to the agent \.jar file\.