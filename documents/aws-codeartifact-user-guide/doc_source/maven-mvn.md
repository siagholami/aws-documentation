# Use CodeArtifact with mvn<a name="maven-mvn"></a>

You use the `mvn` command to execute Maven builds\. This section shows how to configure `mvn` to use an CodeArtifact repository\.

After you have the CodeArtifact auth token in an environment variable as described in [Passing an Auth Token Using an Environment Variable](tokens-authentication.md#env-var), follow these instructions to consume Maven packages from, and publish new packages to, an CodeArtifact repository\.

**Topics**
+ [Fetch dependencies](#fetching-dependencies)
+ [Publish artifacts](#publishing-artifacts)
+ [Publish third\-party artifacts](#publishing-third-party-artifacts)

## Fetch dependencies<a name="fetching-dependencies"></a>

To configure `mvn` to fetch dependencies from an CodeArtifact repository, you must edit the Maven configuration file, `settings.xml`, and optionally, your project's POM\.

1. In `settings.xml` \(typically found at `~/.m2/settings.xml`\), add a `<servers>` section with a reference to the `CODEARTIFACT_TOKEN` environment variable so that Maven passes the token in HTTP requests\.

   ```
   <settings>
   ...
       <servers>
           <server>
               <id>codeartifact</id>
               <username>aws</username>
               <password>${env.CODEARTIFACT_TOKEN}</password>
           </server>
       </servers>
   ...
   </settings>
   ```

1. Add the URL endpoint for your CodeArtifact repository in a `<repository>` element\. You can do this in `settings.xml` or your project's POM file\.

   Add the repository endpoint to `settings.xml` as follows\.

   ```
   <settings>
   ...
       <profiles>
           <profile>
               <id>default</id>
               <repositories>
                   <repository>
                       <id>codeartifact</id>
                       <url>https://my-domain-domain-owner-id.d.codeartifact.us-west-2.amazonaws.com/maven/my-repo/</url>
                   </repository>
               </repositories>
           </profile>
       </profiles>
       <activeProfiles>
           <activeProfile>default</activeProfile>
       </activeProfiles>
       ...
   </settings>
   ```

   Or, you can add the `<repositories>` section to a project POM file to use CodeArtifact for that project only\.

   ```
   <project>
   ...
       <repositories>
           <repository>
               <id>codeartifact</id>
               <name>codeartifact</name>
               <url>https://my-domain-domain-owner-id.d.codeartifact.us-west-2.amazonaws.com/maven/my-repo/</url>
           </repository>
       </repositories>
   ...
   </project>
   ```

**Important**  
You can use any value in the `<id>` element, but it must be the same in both the `<server>` and `<repository>` elements\. This enables the specified credentials to be included in requests to CodeArtifact\.

After you make these configuration changes, you can build the project\.

```
mvn compile
```

Maven logs the full URL of all the dependencies it downloads to the console\.

```
[INFO] ------------------< com.example.example:myapp >-------------------
[INFO] Building myapp 1.0
[INFO] --------------------------------[ jar ]---------------------------------
Downloading from codeartifact: https://<domain>.d.codeartifact.us-west-2.amazonaws.com/maven/myrepo/commons-cli/commons-cli/1.4/commons-cli-1.4.pom
Downloaded from codeartifact: https://<domain>.d.codeartifact.us-west-2.amazonaws.com/maven/myrepo/commons-cli/commons-cli/1.4/commons-cli-1.4.pom (11 kB at 3.9 kB/s)
Downloading from codeartifact: https://<domain>.d.codeartifact.us-west-2.amazonaws.com/maven/myrepo/org/apache/commons/commons-parent/42/commons-parent-42.pom
Downloading from codeartifact: https://<domain>.d.codeartifact.us-west-2.amazonaws.com/maven/myrepo/org/apache/commons/commons-parent/42/commons-parent-42.pom
Downloaded from codeartifact: https://<domain>.d.codeartifact.us-west-2.amazonaws.com/maven/myrepo/org/apache/commons/commons-parent/42/commons-parent-42.pom (68 kB at 123 kB/s)
Downloading from codeartifact: https://<domain>.d.codeartifact.us-west-2.amazonaws.com/maven/myrepo/commons-cli/commons-cli/1.4/commons-cli-1.4.jar
Downloaded from codeartifact: https://<domain>.d.codeartifact.us-west-2.amazonaws.com/maven/myrepo/commons-cli/commons-cli/1.4/commons-cli-1.4.jar (54 kB at 134 kB/s)
```

## Publish artifacts<a name="publishing-artifacts"></a>

To publish a Maven artifact with `mvn` to an CodeArtifact repository, you must also edit `~/.m2/settings.xml` and the project POM\.

1. Add a `<servers>` section to `settings.xml` with a reference to the `CODEARTIFACT_TOKEN` environment variable so that Maven passes the token in HTTP requests\.

   ```
   <settings>
   ...
       <servers>
           <server>
               <id>codeartifact</id>
               <username>aws</username>
               <password>${env.CODEARTIFACT_TOKEN}</password>
           </server>
       </servers>
   ...
   </settings>
   ```

1. Add a `<distributionManagement>` section to your project's `pom.xml`\.

   ```
   <project>
   ...
        <distributionManagement>
            <repository>
                <id>codeartifact</id>
                <name>codeartifact</name>
                <url>https://my-domain-domain-owner-id.d.codeartifact.us-west-2.amazonaws.com/maven/my-repo/</url>
            </repository>
        </distributionManagement>
   ...
   </project>
   ```

After you make these configuration changes, you can build the project and publish it to the specified repository\.

```
mvn deploy
```

Use `list-package-versions` to check that the package was successfully published\.

```
aws codeartifact list-package-versions --domain my-domain --domain-owner domain-owner-id --repository my-repo --format maven \
  --namespace com.company.framework --package my-package-name
```

Sample output:

```
{
    "format": "maven",
    "namespace": "com.company.framework",
    "package": "my-package-name",
    "versions": [
        {
            "version": "1.0", 
            "revision": "REVISION-SAMPLE-1-C7F4S5E9B772FC",
            "status": "Published"
        }
    ]
}
```

## Publish third\-party artifacts<a name="publishing-third-party-artifacts"></a>

You can publish third\-party Maven artifacts to a CodeArtifact repository with `mvn deploy:deploy-file`\. This can be helpful to users that want to publish artifacts and only have `JAR` files and don't have access to package source code or `POM` files\.

The `mvn deploy:deploy-file` command will generate a `POM` file based on the information passed in the command line\.

**Publish third\-party Maven artifacts**

1. Create a `~/.m2/settings.xml` file with the following contents:

   ```
   <settings>
       <servers>
           <server>
               <id>codeartifact</id>
               <username>aws</username>
               <password>${env.CODEARTIFACT_AUTH_TOKEN}</password>
           </server>
       </servers>
   </settings>
   ```

1. Fetch a CodeArtifact authorization token:

   ```
   export CODEARTIFACT_AUTH_TOKEN=`aws codeartifact get-authorization-token --domain domain-name --domain-owner domain-owner-id --query authorizationToken --output text --profile profile-name
   ```

1. Run the `mvn deploy:deploy-file` command:

   ```
   mvn deploy:deploy-file -DgroupId=commons-cli          \
   -DartifactId=commons-cli       \
   -Dversion=1.4                  \
   -Dfile=./commons-cli-1.4.jar   \
   -Dpackaging=jar                \
   -DrepositoryId=codeartifact    \
   -Durl=https://domain-name-domain-owner-id.d.codeartifact.region.amazonaws.com/maven/repo-name/
   ```
**Note**  
The example above publishes `commons-cli 1.4`\. Modify the groupId, artifactID, version, and file arguments to publish a different JAR\.

These instructions are based on examples in the [Guide to deploying 3rd party JARs to remote repository](https://maven.apache.org/guides/mini/guide-3rd-party-jars-remote.html) from the *Apache Maven documentation*\. 

 For more information, see these topics on the Apache Maven Project website:
+  [Setting up Multiple Repositories](https://maven.apache.org/guides/mini/guide-multiple-repositories.html) 
+  [Settings Reference](https://maven.apache.org/settings.html) 
+  [Distribution Management](https://maven.apache.org/pom.html#Distribution_Management) 
+  [Profiles](https://maven.apache.org/pom.html#Profiles) 