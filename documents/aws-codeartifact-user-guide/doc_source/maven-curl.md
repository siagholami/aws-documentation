# Publishing with curl<a name="maven-curl"></a>

This section shows how to use the HTTP client `curl` to publish Maven artifacts to a CodeArtifact repository\. Publishing artifacts with `curl` can be useful if you do not have or want to install the Maven client in your environments\.

**Publish a Maven artifact with `curl`**

1. Fetch a CodeArtifact authorization token by following the steps in [Pass an auth token using an environment variable](tokens-authentication.md#env-var) and return to these steps\.

1. Use the following `curl` command to publish the JAR to a CodeArtifact repository:

   ```
   curl -u aws:$CODEARTIFACT_TOKEN https://domain-name-domain-owner-id.d.codeartifact.region.amazonaws.com/maven/repo-name/com/mycompany/app/my-app/1.0/my-app-1.0.jar \
       --request PUT \
       --data target/my-app-1.0.jar
   ```

1. Use the following `curl` command to publish the POM to a CodeArtifact repository:

   ```
   curl -u aws:$CODEARTIFACT_TOKEN https://domain-name-domain-owner-id.d.codeartifact.region.amazonaws.com/maven/repo-name/com/mycompany/app/my-app/1.0/my-app-1.0.pom \
       --request PUT \
       --data target/my-app-1.0.pom
   ```

1. At this point, the Maven artifact will be in your CodeArtifact repository with a status of `Unfinished`\. To be able to consume the package, it must be in the `Published` state\. You can move the package from `Unfinished` to `Published` by either uploading a `maven-metadata.xml` file to your package, or calling the [UpdatePackageVersionsStatus API](https://docs.aws.amazon.com/codeartifact/latest/APIReference/API_UpdatePackageVersionsStatus.html) to change the status\.

   1.  Option 1: Use the following `curl` command to add a `maven-metadata.xml` file to your package: 

      ```
      curl -u aws:$CODEARTIFACT_TOKEN https://domain-name-domain-owner-id.d.codeartifact.region.amazonaws.com/maven/repo-name/com/mycompany/app/my-app/maven-metadata.xml \
          --request PUT \
          --data target/maven-metadata.xml
      ```

      Below is an example of the contents of a `maven-metadata.xml` file:

      ```
      <metadata modelVersion="1.1.0">
          <groupId>com.mycompany.app</groupId>
          <artifactId>my-app</artifactId>
          <versioning>
              <latest>1.0</latest>
              <release>1.0</release>
              <versions>
                  <version>1.0</version>
              </versions>
              <lastUpdated>20200731090423</lastUpdated>
          </versioning>
      </metadata>
      ```

   1.  Option 2: Update the package status to `Published` with the `UpdatePackageVersionsStatus` API\. 

      ```
      aws codeartifact update-package-versions-status \
          --domain my-domain \
          --domain-owner domain-owner-id \
          --repository repo-name \
          --format maven \
          --package my-app \
          --versions 1.0 \
          --target-status Published
      ```

If you only have an artifact's JAR file, you can publish a consumable package version to a CodeArtifact repository using `mvn`\. This can be useful if you do not have access to the artifact's source code or POM\. See [Publish third\-party artifacts](maven-mvn.md#publishing-third-party-artifacts) for details\.