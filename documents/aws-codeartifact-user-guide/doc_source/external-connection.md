# Add an external connection<a name="external-connection"></a>

You can add a connection between an CodeArtifact repository and an external, public repository such as [https://npmjs\.com](https://npmjs.com) or the [Maven Central repository](https://repo.maven.apache.org/maven2/)\. Then, when you request a package from the CodeArtifact repository that's not already present in the repository, the package can be fetched from the external connection\. This makes it possible to consume open\-source dependencies used by your application\.

**Topics**
+ [Add an external connection to a repository](#adding-an-external-connection)
+ [Supported external connection repositories](#supported-public-repositories)
+ [Remove an external connection](#removing-an-external-connection)
+ [Fetch npm packages from an external connection](#fetching-packages-from-a-public-repository)
+ [Fetch Maven packages from an external connection](#fetch-maven-packages-from-public-repo)
+ [npm ingestion behavior](#npm-ingestion-behavior)
+ [Maven ingestion behavior](#maven-ingestion-behavior)
+ [Fetch packages through an upstream relationship](#fetching-packages-through-an-upstream-relationship)

## Add an external connection to a repository<a name="adding-an-external-connection"></a>

To add an external connection to an CodeArtifact repository, use `associate-external-connection`\.

```
aws codeartifact associate-external-connection --external-connection public:npmjs \
    --domain my-domain --domain-owner domain-owner-id --repository my-repo
```

Example output:

```
{
    "repository": {
        "name": my-repo
        "administratorAccount": "123456789012",
        "domainName": "my-domain",
        "domainOwner": "123456789012",
        "arn": "arn:aws:codeartifact:us-west-2:123456789012:repository/my-domain/my-repo",
        "description": "A description of my-repo",
        "upstreams": [],
        "externalConnections": [
            {
                "externalConnectionName": "public:npmjs",
                "packageFormat": "npm",
                "status": "AVAILABLE"
            }
        ]
    }
}
```

**Note**  
A repository is limited to a single external connection only\.

## Supported external connection repositories<a name="supported-public-repositories"></a>

 CodeArtifact supports an external connection to the following public repositories\. To use the CodeArtifact CLI to specify an external connection, use the value in the **Name** column for the `--external-connection-name` parameter when you run the `associate-external-connection-to-repository` command\. 


| Repository type | Description | Name | 
| --- | --- | --- | 
| npm | npm public registry | public:npmjs | 
| Python | Python Package Index | public:pypi | 
| Maven | Maven Central | public:maven\-central | 
| Maven | Google Android repository | public:maven\-googleandroid | 
| Maven | Gradle plugins repository | public:maven\-gradleplugins | 
| Maven | CommonsWare Android repository | public:maven\-commonsware | 

## Remove an external connection<a name="removing-an-external-connection"></a>

To remove an external connection, use `disassociate-external-connection`\.

```
aws codeartifact disassociate-external-connection --external-connection public:npmjs \
    --domain my-domain --domain-owner domain-owner-id --repository my-repo
```

Example output:

```
{
    "repository": {
        "name": my-repo
        "administratorAccount": "123456789012",
        "domainName": "my-domain",
        "domainOwner": "123456789012",
        "arn": "arn:aws:codeartifact:us-west-2:123456789012:repository/my-domain/my-repo",
        "description": "A description of my-repo",
        "upstreams": [],
        "externalConnections": [
            {
                "externalConnectionName": "public:npmjs",
                "packageFormat": "npm",
                "status": "AVAILABLE"
            }
        ]
    }
}
```

## Fetch npm packages from an external connection<a name="fetching-packages-from-a-public-repository"></a>

After you add an external connection, configure your package manager to use your CodeArtifact repository\. Use the following for **`npm`**\.

```
aws codeartifact login --tool npm --domain my-domain \
    --domain-owner domain-owner-id --repository my-repo
```

Then, request the package from the public repository, as follows\.

```
npm install lodash
```

After the package has been copied into your CodeArtifact repository, you can use the `list-packages` and `list-package-versions` commands to view it\.

```
aws codeartifact list-packages --domain my-domain --domain-owner domain-owner-id \
            --repository my-repo
```

Example output:

```
{
    "packages": [
        {
            "format": "npm",
            "package": "lodash"
        }
    ]
}
```

The `list-package-versions` command lists all versions of the package copied into your CodeArtifact repository\. In some cases, this is all of the versions of the package in the external repository\. In other cases, this is a subset of those versions\. For more information, see [npm ingestion behavior](#npm-ingestion-behavior)\.

```
aws codeartifact list-package-versions --domain my-domain --domain-owner domain-owner-id \
            --repository my-repo --format npm --package lodash
```

Example output:

```
{
    "defaultDisplayVersion: "1.2.5"
    "format": "npm",
    "package": "lodash",
    "versions": [
        {
            "version": "0.6.0", 
            "revision": "REVISION-1-SAMPLE-6C81EFF7DA55CC",
            "status": "Published"
        },
        {
            "version": "0.4.2",
            "revision": "REVISION-2-SAMPLE-6C81EFF7DA55CC",
            "status": "Published"
        },
        {
            "version": "0.6.1",
            "revision": "REVISION-3-SAMPLE-6C81EFF7DA55CC",
            "status": "Published"
        },
        {
            "version": "0.4.0",
            "revision": "REVISION-4-SAMPLE-6C81EFF7DA55CC",
            "status": "Published"
        }
    ]
}
```

## Fetch Maven packages from an external connection<a name="fetch-maven-packages-from-public-repo"></a>

 After you add an external connection, configure your build tool to use your CodeArtifact repository\. For more information, see [Use CodeArtifact with mvn](maven-mvn.md) and [Use CodeArtifact with Gradle](maven-gradle.md)\. If you run either tool \(for example, `gradle build`\), packages are requested from Maven Central and stored in your CodeArtifact repository\. 

### Restrict Maven dependency downloads to an CodeArtifact repository<a name="restrict-maven-downloads"></a>

 If a package cannot be fetched from a configured repository, by default, the `mvn` command fetches it from Maven Central\. Add the `mirrors` element to `settings.xml` to make `mvn` always use your CodeArtifact repository\.

```
<settings>
  ...
    <mirrors>
      <mirror>
        <id>central-mirror</id>
        <name>CodeArtifact Maven Central mirror</name>
        <url>https://my-domain-domain-owner-id.d.codeartifact.us-west-2.amazonaws.com/maven/my-repo/</url>
        <mirrorOf>central</mirrorOf>
      </mirror>
    </mirrors>
  ...
  </settings>
```

If you add a `mirrors` element, you must also have a `pluginRepository` element in your `settings.xml` or `pom.xml`\. The following example fetches application dependencies and Maven plugins from an CodeArtifact repository\. 

```
<settings>
...
  <profiles>
    <profile>
      <pluginRepositories>
        <pluginRepository>
          <id>codeartifact</id>
          <name>CodeArtifact Plugins</name>
          <url>https://my-domain-domain-owner-id.d.codeartifact.us-west-2.amazonaws.com/maven/my-repo/</url>
          <releases>
            <enabled>true</enabled>
          </releases>
          <snapshots>
            <enabled>true</enabled>
          </snapshots>
        </pluginRepository>
      </pluginRepositories>
    </profile>
  </profiles>
...
</settings>
```

The following example fetches application dependencies from an CodeArtifact repository and fetches Maven plugins from Maven Central\.

```
<profiles>
   <profile>
     <id>default</id>
     ...
     <pluginRepositories>
       <pluginRepository>
         <id>central-plugins</id>
         <name>Central Plugins</name>
         <url>https://repo.maven.apache.org/maven2/</url>
         <releases>
             <enabled>true</enabled>
         </releases>
         <snapshots>
             <enabled>true</enabled>
         </snapshots>
       </pluginRepository>
     </pluginRepositories>
   ....
   </profile>
 </profiles>
```

## npm ingestion behavior<a name="npm-ingestion-behavior"></a>

When a package is requested from a repository with an external connection to [https://npmjs\.com](https://npmjs.com), CodeArtifact ingests that package version and up to two versions of its direct and transitive dependencies\. This reduces the time to ingest the dependency tree\. 

 Each dependency has a specified version constraint\. For example, the npm package version `webpack 4.41.2` specifies a dependency on `@babel/core` with a version constraint of `^7.7.2`\. The caret \(^\) specifies that the latest minor or patch version is used \(for example, `7.7.4` or `7.8.0`\)\. When `webpack 4.41.2` is ingested, the most recent published version of `@babel/core` that satisfies the version constraint is ingested\. If the version of `@babel/core` specified by the `latest` tag is different, it is also ingested\. This logic applies to the direct and transitive dependencies of `@babel/core` and the direct and transitive dependencies of `webpack 4.41.2`\. 

If ingestion of a package is not complete in 40 seconds, a 404 error is returned to the client\.

```
npm ERR! code E404
npm ERR! 404 Not Found - GET https://my-domain-domain-owner-id.d.codeartifact.us-west-2.amazonaws.com/npm/my-repo/lodash - Ingestion is in progress. Please try again later.
npm ERR! 404
npm ERR! 404  'lodash@^4.17.15' is not in the npm registry.
npm ERR! 404 You should bug the author to publish it (or use the name yourself!)
npm ERR! 404
npm ERR! 404 Note that you can also install from a
npm ERR! 404 tarball, folder, http url, or git url.

npm ERR! A complete log of this run can be found in:
npm ERR!     /Users/username/.npm/_logs/2019-09-22T01_47_43_155Z-debug.log
```

When this occurs, CodeArtifact is still copying packages from the external repository asynchronously\. Retry the same command to complete the ingestion of the entire dependency tree\.

## Maven ingestion behavior<a name="maven-ingestion-behavior"></a>

 When a Maven package is requested from a repository with an external connection to [Maven Central repository](https://repo.maven.apache.org/maven2/), CodeArtifact ingests all assets of the package version that follow the standard Maven asset naming conventions\. The dependencies of a package version are not ingested until they are requested by the client \(for example, `mvn`\)\. 

 If ingestion of a required asset is not complete within 40 seconds, a 404 error is returned to the client\. A timeout error during a Gradle build might look like the following\.

```
> Could not resolve all files for configuration ':compileClasspath'.
  > Could not resolve org.mockito:mockito-core:3.1.0.
    Required by:
        project :
      > Could not resolve org.mockito:mockito-core:3.1.0.
         > Could not get resource 'https://my-domain.codeartifact.aws.a2z.com/maven/my-domain/org/mockito/mockito-core/3.1.0/mockito-core-3.1.0.pom'.
            > Could not GET 'https://my-domain.codeartifact.aws.a2z.com/maven/my-domain/org/mockito/mockito-core/3.1.0/mockito-core-3.1.0.pom'.
```

 When this occurs, CodeArtifact is still copying packages from the external repository asynchronously\. Retry the same command to complete the ingestion of the entire dependency tree\. 

## Fetch packages through an upstream relationship<a name="fetching-packages-through-an-upstream-relationship"></a>

If an CodeArtifact repository has an upstream relationship with an external connection, requests for packages not in the upstream repository are copied from the external repository\. For example, a repository named `my-upstream-repo` has an external connection to [https://npmjs\.com](https://npmjs.com)\.

```
aws codeartifact describe-repository --repository my-upstream-repo --domain my-domain \
        --domain-owner domain-owner-id
```

Example output:

```
{
    "repository": {
        "name": "my-upstream-repo",
        "administratorAccount": "123456789012",
        "domainName": "my-domain",
        "domainOwner": "123456789012",        
        "arn": "arn:aws:codeartifact:region-id:123456789012:repository/my-domain/my-upstream-repo",
        "upstreams": [],
        "externalConnections": [
            {
                "externalConnectionName": "public:npmjs",
                "packageFormat": "npm",
                "status": "AVAILABLE"
            }
        ]
    }
}
```

And there is a downstream repository with `my-upstream-repo` as an upstream\.

```
aws codeartifact describe-repository --domain my-domain --domain-owner domain-owner-id \
            --repository my-downstream-repo
```

Example output:

```
{
    "repository": {
        "name": "my-downstream-repo",
        "administratorAccount": "123456789012",
        "domainName": "my-domain",
        "domainOwner": "123456789012",        
        "arn": "arn:aws:codeartifact:us-west-2:123456789012:repository/my-domain/my-downstream-repo",
        "upstreams": [
            {
                "repositoryName": "my-upstream-repo"
            }
        ],
        "externalConnections": []
    }
}
```

If `npm` is configured to use the `my-downstream-repo` repository, running `npm install` triggers the copying of packages from [https://npmjs\.com](https://npmjs.com) into `my-upstream-repo`\. The versions installed are also pulled into `my-downstream-repo`\. The following example installs `lodash`\.

```
$ npm config get registry
https://my-domain-domain-owner-id.d.codeartifact.us-west-2.amazonaws.com/npm/my-downstream-repo/
$ npm install lodash
+ lodash@4.17.15
added 1 package from 2 contributors in 6.933s
```

After running `npm install`, `my-downstream-repo` contains just the latest version \(`lodash 4.17.15`\) because that's the version that was fetched by `npm` from `my-downstream-repo`\.

```
aws codeartifact list-package-versions --repository my-downstream-repo --domain my-domain \
            --domain-owner domain-owner-id --format npm --package lodash
```

Example output:

```
{
    "package": "lodash",
    "format": "npm",
    "versions": [
        {
            "version": "4.17.15",
            "revision": "REVISION-1-SAMPLE-6C81EFF7DA55CC",
            "status": "Published"
        }
    ]
}
```

 Because `my-upstream-repo` has an external connection to [https://npmjs\.com](https://npmjs.com), all the package versions that are imported from [https://npmjs\.com](https://npmjs.com) are stored in `my-upstream-repo`\. These package versions could have been fetched by any downstream repository with an upstream relationship to `my-upstream-repo`\. 

The contents of `my-upstream-repo` provide a way to see all the packages and package versions imported from [https://npmjs\.com](https://npmjs.com) over time\. For example, to see all the versions of the `lodash` package imported over time, you can use `list-package-versions`, as follows\.

```
aws codeartifact list-package-versions --repository my-upstream-repo --domain my-domain \
            --domain-owner domain-owner-id --format npm --package lodash --max-results 5
```

Example output:

```
{
    "package": "lodash",
    "format": "npm",
    "versions": [
        {
            "version": "0.10.0",
            "revision": "REVISION-1-SAMPLE-6C81EFF7DA55CC",
            "status": "Published"
        },
        {
            "version": "0.2.2",
            "revision": "REVISION-2-SAMPLE-6C81EFF7DA55CC",
            "status": "Published"
        },
        {
            "version": "0.2.0",
            "revision": "REVISION-3-SAMPLE-6C81EFF7DA55CC",
            "status": "Published"
        },
        {
            "version": "0.2.1",
            "revision": "REVISION-4-SAMPLE-6C81EFF7DA55CC",
            "status": "Published"
        },
        {
            "version": "0.1.0",
            "revision": "REVISION-5-SAMPLE-6C81EFF7DA55CC",
            "status": "Published"
        }
    ],
    "nextToken": "eyJsaXN0UGFja2FnZVZlcnNpb25zVG9rZW4iOiIwLjIuMiJ9"
}
```