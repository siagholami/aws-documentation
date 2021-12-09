# Dependency caching<a name="dependency-caching"></a>

You can enable local caching in CodeBuild to reduce the number of dependencies that need to be fetched from CodeArtifact for each build\. For information, see [Build Caching in AWS CodeBuild](https://docs.aws.amazon.com/codebuild/latest/userguide/build-caching.html) in the *AWS CodeBuild User Guide*\. After you enable a custom local cache, add the cache directory to your project's `buildspec.yaml` file\.

For example, if you are using `mvn`, use the following\.

```
cache:
  paths:
    - '/root/.m2/**/*'
```

For other tools, use the cache folders shown in this table\.


****  

| Tool | Cache directory | 
| --- | --- | 
|   ** `mvn` **   |   `/root/.m2/**/*`   | 
|   ** `gradle` **   |   `/root/.gradle/caches/**/*`   | 
|   ** `pip` **   |   `/root/.cache/pip/**/*`   | 
|   ** `npm` **   |   `/root/.npm/**/*`   | 