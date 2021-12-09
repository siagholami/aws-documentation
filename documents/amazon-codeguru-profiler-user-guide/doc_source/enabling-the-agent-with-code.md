# Enabling the agent with code<a name="enabling-the-agent-with-code"></a>

You can enable the Amazon CodeGuru Profiler agent in your application by adding code inside the startup routine of your application\. 

In addition to adding code, you also need to add a dependency to the agent library in your build steps\. For this you can use a package manager such as Maven or Gradle\.

## Installation<a name="enabling-with-code-installation"></a>

To include the agent in your application, you need to tell your build system how to access the agent library\. You can do this manually by adding a dependency in your Maven or Gradle configuration files\.

### Maven<a name="enabling-with-code-maven"></a>

To add a dependency to the agent, add the following sections to your pom\.xml file\. if you already have a `repositories` or `dependencies` element in your POM, add the individual `repositories` or `dependencies` elements inside the existing outer elements\. 

```
<project xmlns="http://maven.apache.org/POM/4.0.0" 
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven- 4.0.0.xsd">
...
    <repositories>
        <repository>
            <id>codeguru-profiler</id>
            <name>codeguru-profiler</name>
            <url>https://d1osg35nybn3tt.cloudfront.net</url>
        </repository>
    </repositories>
    ... 
    <dependencies>
        <dependency>
            <groupId>com.amazonaws</groupId>
            <artifactId>codeguru-profiler-java-agent</artifactId>
            <version>1.0.0</version>
        </dependency>
    </dependencies>
...
</project>
```

For more information about configuring repositories in Maven, see [Setting up Multiple Repositories](https://maven.apache.org/guides/mini/guide-multiple-repositories.html) in the Maven documentation\.

### Gradle<a name="enabling-with-code-gradle"></a>

To add a dependency to the agent, add the following sections to your gradle file\. If you already have a `repositories` or `dependencies` element in your gradle file, add the individual subelements into the existing outer elements\. 

```
repositories {
    maven {
        url = uri("https://d1osg35nybn3tt.cloudfront.net")
    }
}
dependencies {
    implementation("com.amazonaws:codeguru-profiler-java-agent:1.0.0")
}
```

For more information about creating a custom Gradle repository, see [ Declaring a custom repository by URL](https://docs.gradle.org/current/userguide/declaring_repositories.html#sec:declaring_custom_repository)\. For examples, see examples 18 and 19 in [ Supported repository transport protocols](https://docs.gradle.org/current/userguide/declaring_repositories.html#sec:plugin-vs-build-repos)\. 

## Configuration<a name="enabling-with-code-configuration"></a>

You can configure the agent by using explicit API calls to the `Profiler.Builder` class\. The following table shows the available options\.


|  Type  |  API call  | 
| --- | --- | 
|  Profiling group name \(required\)  |  `.profilingGroupName(String)`  | 
|  AWS Credentials Provider  |  `.awsCredentialsProvider(AwsCredentialsProvider)`  | 
|  Region  |  `.awsRegionToReportTo(Region)`  | 

The following is an example of command line API calls\.

```
Profiler.builder()
    .profilingGroupName(“MyProfilingGroup”)
    .build()
    .start();
```

We recommend that you configure and start the agent inside of the `startup` or `main` function\. The following is an example of adding the configuration to the `main` function\. 

```
import software.amazon.codeguruprofilerjavaagent.Profiler;

class MyApplication {
    public static void main(String[] args) {
        Profiler.builder()
            .profilingGroupName("MyProfilingGroup")
            .build()
            .start();
        ...
    }
}
```

If you don't have access to a `startup` or `main` function, you can add a static initializer to your `main` class to configure and start the agent\. This configures and starts the agent during the first time your application class is used inside the application container\. See the following example\.

```
import software.amazon.codeguruprofilerjavaagent.Profiler;

class MyClass {
    static Profiler profiler;
    
    static {
        Profiler.builder()
            .profilingGroupName("MyProfilingGroup")
            .build();
        profiler.start();
    }
    ...
}
```

When your application is running, data is available in the CodeGuru Profiler console\. To view your profiling data, choose **Profiler** in the navigation pane, choose **Profiling groups**, and then select your profiling group\. 

After your application has run for more than 15 minutes, data will be available for you to visualize\. For example, you can use an **Overview** visualization to identify code paths that are executed frequently\. For more information about visualizations, see [Working with visualizations](working-with-visualizations.md)\.

When your application has run for an hour, the first **Recommendations** report will be available\. After the first report, new reports are generated hourly\. For more information, see [Working with anomalies and recommendation reports](working-with-recommendation-reports.md)\.

**Note**  
If you don't want to use the default credentials to run the profiler, you can provide custom credentials by using following code\. For more information about custom credentials, see [Supplying and Retrieving AWS Credentials](https://docs.aws.amazon.com/sdk-for-java/v2/developer-guide/credentials.html)\.  

```
public static void main(String[] args) {
     Profiler.builder()
          .profilingGroupName("MyProfilingGroup")
          .awsCredentialsProvider(myAwsCredentialsProvider).build().start();
 }
```

## Supported languages<a name="supported-languages"></a>

The following topics provide code that you can add to your application to enable the Amazon CodeGuru Profiler agent\.

**Topics**
+ [Java](java-language-support.md)
+ [Scala](scala-language-support.md)
+ [Kotlin](kotlin-language-support.md)
+ [Groovy](groovy-language-support.md)
+ [Jython](jython-language-support.md)
+ [JRuby](jruby-language-support.md)
+ [Clojure](clojure-language-support.md)