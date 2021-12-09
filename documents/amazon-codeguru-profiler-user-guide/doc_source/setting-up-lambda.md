# Profiling your applications that run on AWS Lambda<a name="setting-up-lambda"></a>

If you're profiling applications that run on AWS Lambda, add the following environment variables to your AWS Lambda function\.
+ `AWS_CODEGURU_PROFILER_GROUP_ARN` – Identifies the profiling group ARN\.
+ `AWS_CODEGURU_PROFILER_ENABLED` – Enables profiling when set to `TRUE`\. To disable profiling, set this variable to `FALSE`\.

For information about setting environment variables in the AWS Lambda console, see [Using AWS Lambda environment variables](https://docs.aws.amazon.com/lambda/latest/dg/configuration-envvars.html)\.

Add a dependency to the CodeGuru Profiler profiling agent library\. You can do this manually by adding a dependency in your Maven or Gradle configuration files\. For more information about adding dependencies, see [Enabling the agent with code](https://docs.aws.amazon.com/codeguru/latest/profiler-ug/enabling-the-agent-with-code)\.

## Make code changes to start profiling your AWS Lambda functions<a name="lambda-code-change"></a>

If you have been using handlers provided by AWS Lambda, then you can alter your code to use handlers provided by CodeGuru to enable profiling\. For information about your Lambda function's header, see [AWS Lambda function handler in Java](https://docs.aws.amazon.com/lambda/latest/dg/java-handler.html)\. 

If your Lambda function uses AWS Lambda’s RequestHandler, you can replace it with CodeGuru Profiler's `RequestHandlerWithProfiling`\. This will enable profiling by default\. The following example provides a sample code snippet to do so\. The `RequestHandlerWithProfiling` is a generic type that takes two parameters: the input type and the output type\. Both types must be objects\. When you use this, the Java runtime deserializes the event into an object with the input type, and serializes the output into text\. Use this interface when the built\-in serialization works with your input and output types\.

```
package example;

import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;

import software.amazon.codeguruprofilerjavaagent.RequestHandlerWithProfiling;

public class Handler extends RequestHandlerWithProfiling<Map<String,String>, String> {

    @Override
    public String requestHandler(Map<String, String> input, Context context) {
        // Your function code here
    }
}
```

If you are using `RequestStreamHandler`, then you can replace it with CodeGuru Profiler's `RequestStreamHandlerWithProfiling`\. To use your own serialization, implement the `RequestStreamHandlerWithProfiling` interface\. With this, AWS Lambda passes your handler an input stream and output stream\. The handler reads bytes from the input stream, writes to the output stream, and returns void\. 

```
package example;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.amazonaws.services.lambda.runtime.Context;

import software.amazon.codeguruprofilerjavaagent.RequestStreamHandlerWithProfiling;

public class StreamHandler extends RequestStreamHandlerWithProfiling {

    @Override
    public void requestHandler(InputStream input, OutputStream output, Context context) throws IOException {
        // Your function code here
    }
}
```

If you don't use handlers provided by AWS Lambda, then add the following code to start profiling your AWS Lambda functions\. Wrap your AWS Lambda function’s logic inside a utility from the CodeGuru Profiler profiling agent\.

```
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import software.amazon.codeguruprofilerjavaagent.LambdaProfiler;

public class MyHandler implements RequestHandler<Input, Output>{

    @Override
    public Output handleRequest(Input input, Context context) {
        return LambdaProfiler.profile(input, context, this::myHandlerFunction);
    }
    
    public Output myHandlerFunction(Input input, Context context) {
        // your function code here
    }
}
```

Your AWS Lambda function runs the way it typically does, while the CodeGuru Profiler profiling agent runs in parallel\. After running for five minutes, the agent submits your first profile\. Processing can take up to 15 minutes\.