# Use CodeArtifact with Gradle<a name="maven-gradle"></a>

After you have the CodeArtifact auth token in an environment variable as described in [Pass an auth token using an environment variable](tokens-authentication.md#env-var), follow these instructions to consume Maven packages from, and publish new packages to, an CodeArtifact repository\.

**Topics**
+ [Fetch dependencies](#fetching-dependencies)
+ [Publish artifacts](#publishing-artifacts)
+ [Run a Gradle build in IntelliJ IDEA](#gradle-intellij)

## Fetch dependencies<a name="fetching-dependencies"></a>

To fetch dependencies from CodeArtifact in a Gradle build, add a `maven` section to the `repositories` section in the project `build.gradle` file\.

```
maven {
         url 'https://my-domain-domain-owner-id.d.codeartifact.us-west-2.amazonaws.com/maven/my-repo/'
         credentials {
             username "aws"
             password System.env.CODEARTIFACT_TOKEN
         }
}
```

For example, with a repository named `myrepo`, the URL should be the following:

```
url 'https://my-domain-domain-owner-id.d.codeartifact.us-west-2.amazonaws.com/maven/my-repo/'
```

To use the CodeArtifact repository as the only source for your project dependencies, remove any other sections in `repositories` from `build.gradle`\. If you have more than one repository, Gradle searches each repository for dependencies in the order they are listed\.

After you configure the repository, you can add project dependencies to the `dependencies` section with standard Gradle syntax\.

```
dependencies {
    implementation 'com.google.guava:guava:27.1-jre'
    implementation 'commons-cli:commons-cli:1.4'
    testImplementation 'org.testng:testng:6.14.3'
}
```

## Publish artifacts<a name="publishing-artifacts"></a>

This section describes how to publish a Java library built with Gradle to an CodeArtifact repository\.

First, add the `maven-publish` plugin to the `plugins` section of the project's `build.gradle` file\.

```
plugins {
    id 'java-library'
    id 'maven-publish'
}
```

Next, add a `publishing` section to the project `build.gradle` file\.

```
publishing {
    publications {
        mavenJava(MavenPublication) {
            groupId = 'group-id'
            artifactId = 'artifact-id'
            version = 'version'
            from components.java
        }
    }
    repositories {
        maven {
            url 'https://my-domain-domain-owner-id.d.codeartifact.us-west-2.amazonaws.com/maven/my-repo/'
            credentials {
                username "aws"
                password System.env.CODEARTIFACT_TOKEN
            }
        }
    }
}
```

The `maven-publish` plugin generates a POM file based on the `groupId`, `artifactId`, and `version` specified in the `publishing` section\.

After these changes to `build.gradle` are complete, run the following command to build the project and upload it to the repository\.

```
./gradlew publish
```

Use `list-package-versions` to check that the package was successfully published\.

```
aws codeartifact list-package-versions --domain my-domain --domain-owner domain-owner-id --repository my-repo --format maven\
  --namespace com.company.framework --package my-package-name
```

Sample output:

```
{
    "format": "maven",
    "namespace": "com.company.framework",
    "package": "example",
    "versions": [
        {
            "version": "1.0", 
            "revision": "REVISION-SAMPLE-1-C7F4S5E9B772FC",
            "status": "Published"
        }
    ]
}
```

For more information, see these topics on the Gradle website:
+  [Building Java Libraries](https://guides.gradle.org/building-java-libraries/) 
+  [Publishing a project as a module](https://docs.gradle.org/current/userguide/publishing_setup.html) 

## Run a Gradle build in IntelliJ IDEA<a name="gradle-intellij"></a>

You can run a Gradle build in IntelliJ IDEA that pulls dependencies from CodeArtifact\. You can store and use a CodeArtifact auth token in `gradle.properties` or a separate file of your choice\.

**Method 1: Putting the auth token in `gradle.properties`**

Use this method if you are not using the `gradle.properties` file and can overwrite its contents with your auth token\. If you are using `gradle.properties`, you can modify this method to add the token instead of overwriting the file's contents\.
**Note**  
The example shows the `gradle.properties` file located in `GRADLE_USER_HOME`\.

1. Update your `build.gradle` file with the following snippet:

   ```
   repositories {
       maven {
                url 'https://domain-name-domain-owner-id.d.codeartifact.region.amazonaws.com/maven/repo-name/'
                credentials {
                    username "aws"
                    password "$codeartifactToken"
                }   
       }   
   }
   ```

1. Fetch a CodeArtifact auth token:

   ```
   export CODEARTIFACT_AUTH_TOKEN=`aws codeartifact get-authorization-token --domain domain-name --domain-owner domain-owner-id --query authorizationToken --output text --profile profile-name`
   ```

1. Write the auth token into the `gradle.properties` file:

   ```
   echo "codeartifactToken=$CODEARTIFACT_AUTH_TOKEN" > ~/.gradle/gradle.properties
   ```

**Method 2: Putting the auth token in a separate file**

Use this method if you do not want to modify your `gradle.properties` file\.

1. Update your `build.gradle` file with the following snippet:

   ```
   def props = new Properties()
   file("file").withInputStream { props.load(it) }
   
   repositories {
   
       maven {
                url 'https://domain-name-domain-owner-id.d.codeartifact.region.amazonaws.com/maven/repo-name/'
                credentials {
                    username "aws"
                    password props.getProperty("codeartifactToken")
                }
       }
   }
   ```

1. Fetch a CodeArtifact auth token:

   ```
   export CODEARTIFACT_AUTH_TOKEN=`aws codeartifact get-authorization-token --domain domain-name --domain-owner domain-owner-id --query authorizationToken --output text --profile profile-name`
   ```

1. Write the auth token into the file that was specified in your `build.gradle` file:

   ```
   echo "codeartifactToken=$CODEARTIFACT_AUTH_TOKEN" > file
   ```