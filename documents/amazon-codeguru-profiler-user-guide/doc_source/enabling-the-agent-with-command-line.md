# Enabling the agent from the command line<a name="enabling-the-agent-with-command-line"></a>

The command line option for integrating the CodeGuru Profiler agent is the easiest way to start profiling your application, because it doesn't require recompiling and redeploying your application\. Add the appropriate command line options to your JVM\-based runtime environment and you’re ready to go\.

## Installation<a name="command-line-installation"></a>

Download the [Amazon CodeGuru Profiler agent \.jar file](https://d1osg35nybn3tt.cloudfront.net/com/amazonaws/codeguru-profiler-java-agent-standalone/1.0.0/codeguru-profiler-java-agent-standalone-1.0.0.jar)\.

Save this to a location that is accessible from your JVM\-based application\.

## Configuration<a name="command-line-configuration"></a>

The only required configuration option to start the CodeGuru Profiler agent is the profiling group name\. You can find this in the **Settings** section of your profiling group on the CodeGuru Profiler console\.

You can use the credential path parameter to have the agent use credentials that are different from the default credentials\. The path must point to a valid AWS credentials file\. For more information about credentials, see [Configuration and credential file settings](https://docs.aws.amazon.com/cli/latest/userguide/cli-configure-files.html)\.

You can specify these options as an environment variable or as a command line option\.


|  Option  |  Environment variable  |  Command line option  | 
| --- | --- | --- | 
|  Profiling group name \(required\)  |  `AWS_CODEGURU_PROFILER_GROUP_NAME`  |  `profilingGroupName`  | 
|  Credential path  |  `AWS_CODEGURU_PROFILER_CREDENTIAL_PATH`  |  `credentialPath`  | 
|  Region  |  `AWS_CODEGURU_PROFILER_TARGET_REGION`  |  `region`  | 

Your startup script using environment variables might look like the following\.

```
#!/bin/bash
            
export AWS_CODEGURU_PROFILER_GROUP_NAME=MyProfilingGroup
export AWS_CODEGURU_TARGET_REGION=us-west-2

java -javaagent:/path/to/codeguru-profiler-java-agent-standalone-1.0.0.jar -jar MyApplication.jar
```

Alternatively, you can specify the configuration options by using the command line directly, as follows\.

```
java -javaagent:/path/to/codeguru-profiler-java-agent-standalone-1.0.0.jar=profilingGroupName:MyProfilingGroup,region:us-west-2 -jar MyApplication.jar
```

The argument string can contain multiple parameters\. Separate parameters with a comma \(`,`\)\. Each parameter is a key\-value pair\.

**Note**  
Your command must either be on one continuous line, or you can use a line\-continuation option appropriate for your command shell\.

## Supported runtime environments<a name="supported-runtime-environments"></a>

Most JVM\-based application runtime environments support a mechanism to specify and customize JVM startup parameters to include the CodeGuru Profiler agent in the runtime startup\. This section summarizes some of the popular runtime environments that we have verified to support this option\.

**Topics**
+ [Java](#javaagent-java)
+ [Scala](#javaagent-scala)
+ [Jython](#javaagent-jython)
+ [ColdFusion](#javaagent-coldfusion)
+ [Geronimo](#javaagent-geronimo)
+ [SOLR](#javaagent-solr)
+ [Tomcat](#javaagent-tomcat)
+ [Glassfish](#javaagent-glassfish)
+ [Grails](#javaagent-grails)
+ [Jetty](#javaagent-jetty)
+ [Play](#javaagent-play)
+ [Resin](#javaagent-resin)
+ [Spring Boot](#javaagent-spring-boot)
+ [Tanuki Wrapper](#javaagent-tanuki-wrapper)
+ [Websphere Liberty Profile](#javaagent-websphere)
+ [Spark](#javaagent-spark)
+ [Other runtime environments](#javaagent-other)

### Java<a name="javaagent-java"></a>

If you start your application using the `java` command, you can enable the CodeGuru Profiler agent in your application by adding the following `-javaagent` command line option\. 

```
java -javaagent:/path/to/codeguru-profiler-java-agent-standalone-1.0.0.jar -jar MyApplication.jar
```

### Scala<a name="javaagent-scala"></a>

If you start your application using the `scala` command, you can enable the CodeGuru Profiler agent in your application by adding the following `-J-javaagent` command line option\. 

```
scala -J-javaagent:/path/to/codeguru-profiler-java-agent-standalone-1.0.0.jar -jar MyScalaApplication.jar
```

### Jython<a name="javaagent-jython"></a>

If you start your application using the `Jython` command, you can enable the CodeGuru Profiler agent in your application by adding the following `-J-javaagent` command line option\. 

```
jython -J-javaagent:/path/to/codeguru-profiler-java-agent-standalone-1.0.0.jar -jar MyJythonApplication.jar
```

### ColdFusion<a name="javaagent-coldfusion"></a>

Enable profiling for ColdFusion applications by adding the `-javaagent` option to the JVM parameters in the administrator console\.

1. Navigate to your ColdFusion administrator console\.

1. From the left menu, choose **SERVER SETTINGS**\.

1. From the top bar, choose **Java and JVM**\.

1. In the **JVM Arguments** field, add the following `-javaagent` argument\. 

   ```
   -javaagent:/path/to/codeguru-profiler-java-agent-standalone-1.0.0.jar
   ```

1. Choose **Submit changes**, then restart your ColdFusion server\.

### Geronimo<a name="javaagent-geronimo"></a>

Add the CodeGuru Profiler agent to the Geronimo startup options by adding the `-javaagent` command line option to the `JAVA_OPTS` environment variable before starting your Geronimo instance\. 

```
export JAVA_OPTS="$JAVA_OPTS -javaagent:/path/to/codeguru-profiler-java-agent-standalone-1.0.0.jar"
    geronimo run
```

### SOLR<a name="javaagent-solr"></a>

Add the `-javaagent` command line option to the `SOLR_OPTS` variable in your SOLR startup configuration script, `/path/to/solr/bin/solr.in.sh`, by appending the following lines to it and adjusting them to your environment\.

```
SOLR_OPTS="$SOLR_OPTS -javaagent:/path/to/codeguru-profiler-java-agent-standalone-1.0.0.jar"
```

### Tomcat<a name="javaagent-tomcat"></a>

 Add the `-javaagent` command line option to the `JAVA_HOME` environment variable in Tomcat’s startup script, `/path/to/tomcat/bin/catalina.sh`\.

```
JAVA_OPTS="$JAVA_OPTS -javaagent:/path/to/codeguru-profiler-java-agent-standalone-1.0.0.jar"
```

### Glassfish<a name="javaagent-glassfish"></a>

1. Set the environment variable for the profiling group name and the default Region with `export AWS_CODEGURU_PROFILER_GROUP_NAME=glassfish-profile`\.

1. Add `<jvm-options>-javaagent:~/codeguru-profiler-java-agent-standalone-1.0.0.jar</jvm-options>` below the `java-config` tag\.

1. Start your domain, `./bin/asadmin start-domain domain1`\.

If you have JDK version 1\.8 or later and are running Glassfish version 5\.0 or later, you will receive the following error\.

```
java.lang.NoSuchMethodError: 
sun.security.ssl.Handshaker.receiveChangeCipherSpec()
```

### Grails<a name="javaagent-grails"></a>

1. Set your `ENV` variables for your profiling group name and default Region\.

   ```
   export AWS_CODEGURU_PROFILER_GROUP_NAME=grails-profile
   ```

1. Add the following to `/appName/build.groovy`\.

   ```
   tasks.withType(JavaExec) { jvmArgs "-javaagent:/path/to/codeguru-profiler-java-agent-standalone-1.0.0.jar" }
   ```

1. Start the **grails run\-app** application\.

### Jetty<a name="javaagent-jetty"></a>

1. Set the `ENV` variables for your profiling group name and default Region\.

   ```
   export AWS_CODEGURU_PROFILER_GROUP_NAME=jetty-profile
   ```

1. Append `-javaagent:~/codeguru-profiler-java-agent-standalone-1.0.0.jar` to the start script\.

### Play<a name="javaagent-play"></a>

1. Set the `ENV` variables for your profiling group name and default Region\.

   ```
   export AWS_CODEGURU_PROFILER_GROUP_NAME=play-profile
   ```

1. Append the following to your startup script, and then run the following\.

   ```
   ./sbt -J-javaagent:~/codeguru-profiler-java-agent-standalone-1.0.0.jar "run 8080"
   ```

### Resin<a name="javaagent-resin"></a>

1. Set the `ENV` variables for your profiling group name and default Region\.

   ```
   export AWS_CODEGURU_PROFILER_GROUP_NAME=resin-profile
   ```

1. Add the following to your configuration file\.

   ```
   <server-default><jvm-arg>-javaagent:~/codeguru-profiler-java-agent-standalone-1.0.0.jar</jvm-arg>
   ```

### Spring Boot<a name="javaagent-spring-boot"></a>

1. Set the `ENV` variables for your profiling group name and default Region\.

   ```
   export AWS_CODEGURU_PROFILER_GROUP_NAME=spring-profile
   ```

1. Run the server with the `javaagent`\.

   ```
   java -javaagent:~/codeguru-profiler-java-agent-standalone-1.0.0.jar -jar demo-0.0.1-SNAPSHOT.jar
   ```

### Tanuki Wrapper<a name="javaagent-tanuki-wrapper"></a>

1. Set the `ENV` variables for your profiling group name and default Region\.

   ```
   export AWS_CODEGURU_PROFILER_GROUP_NAME=tanuki-profile
   ```

1. Add the following code to `wrapper.conf`\.

   ```
   <NON_DUPLICATE_NUMBER_IN_ADDITIONAL_PARAM_LIST>=-javaagent:~/codeguru-profiler-java-agent-standalone-1.0.0.jar
   ```

### Websphere Liberty Profile<a name="javaagent-websphere"></a>

1. Set the `ENV` variables for your profiling group name and default Region\.

   ```
   export AWS_CODEGURU_PROFILER_GROUP_NAME=websphereLiberty-profile
   ```

1. Append the following path to `jvm.options`\.

   ```
   -javaagent:~/codeguru-profiler-java-agent-standalone-1.0.0.jar
   ```

### Spark<a name="javaagent-spark"></a>

CodeGuru Profiler supports Spark, but does not have `-javaagent` support\. The agent will be part of your \.jar package ﬁle when you use CodeGuru Profiler in Spark\. It doesn't matter if the agent is the worker or the primary as long as your code takes care of starting and stopping the agent when a job begins and ends\. If a job is shorter than one minute, the agent won't report recommendations\. To provide enough samples per worker, run the agent on long\-running jobs\.

### Other runtime environments<a name="javaagent-other"></a>

You can start any Java\-based application by using the `-javaagent` command line option\. If your runtime environment or hosting environment uses Java, consult your documentation to see how to customize the startup parameters for Java\.