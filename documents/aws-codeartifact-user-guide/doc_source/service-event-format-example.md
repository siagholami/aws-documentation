# CodeArtifact event format and example<a name="service-event-format-example"></a>

The following are event fields and descriptions along with an example of an CodeArtifact event\.

## CodeArtifact event format<a name="service-event-format"></a>

 All CodeArtifact events include the following fields\.


| Event field | Description | 
| --- | --- | 
| version | The version of the event format\. There is currently only a single version, 0\. | 
| id | A unique identifier for the event\. | 
| detail\-type | The type of event\. This determines the fields in the detail object\. The one detail\-type currently supported is CodeArtifact Package Version State Change\. | 
| account | The account that owns the domain and repository that triggered the event\. | 
| resources | A list that contains the ARN of the package that changed\. The list contains one entry\. For information about package ARN format, see [Grant write access to packages](repo-policies.md#granting-write-access-to-specific-packages)\. | 
| domainName | The domain that contains the repository that contains the package\. | 
| domainOwner | The AWS account ID of the owner of the domain\. | 
| repositoryName | The repository that contains the package\. | 
| packageFormat | The format of the package that triggered the event\. | 
| packageNamespace | The namespace of the package that triggered the event\. | 
| packageName | The name of the package that triggered the event\. | 
| packageVersion | The version of the package that triggered the event\. | 
| packageVersionState | The state of the package version when the event was triggered\. Possible values are Unfinished, Published, Unlisted, Archived, and Disposed\. | 
| packageVersionRevision | A value that uniquely identifies the state of the assets and metadata of the package version when the event was triggered\. If the package version is modified \(for example, by adding another JAR file to a Maven package\), the packageVersionRevision changes\. | 
| changes\.assetsAdded | The number of assets added to a package that triggered an event\. Examples of an asset are a Maven JAR file or a Python wheel\. | 
| changes\.assetsRemoved | The number of assets removed from a package that triggered an event\. | 
| changes\.assetsUpdated | The number of assets modified in the package that triggered the event\. | 
| changes\.metadataUpdated | A boolean value that is set to true if the event includes modified package\-level metadata\. For example, an event might modify a Maven pom\.xml file\. | 
| changes\.statusChanged | A boolean value that is set to true if the event's packageVersionStatus is modified\(for example, if packageVersionStatus changes from Unfinished to Published\)\. | 
| operationType | Describes the high\-level type of the package version change\. The possible values are Created, Updated, and Deleted\. | 
| sequenceNumber | An integer that specifies an event number for a package\. Each event on a package increments the sequenceNumber so events can be arranged sequentially\. An event can increment the sequenceNumber by any integer number\.   EventBridge events might be received out of order\. `sequenceNumber` can be used to determine their actual order\.   | 
| eventDeduplicationId | An ID used to differentiate duplicate EventBridge events\. In rare cases, EventBridge might trigger the same rule more than once for a single event or scheduled time\. Or, it might invoke the same target more than once for a given triggered rule\.  | 

## CodeArtifact event example<a name="service-event-sample"></a>

 The following is an example of an CodeArtifact event that might be triggered when an npm package is published\. 

```
{
  "version":"0",
  "id":"73f03fec-a137-971e-6ac6-07c8ffffffff",
  "detail-type":"CodeArtifact Package Version State Change",
  "source":"aws.codeartifact",
  "account":"123456789012",
  "time":"2019-11-21T23:19:54Z",
  "region":"us-west-2",
  "resources":["arn:aws:codeartifact:us-west-2:123456789012:package/mydomain/myrepo/npm//mypackage"],
  "detail":{
    "domainName":"mydomain",
    "domainOwner":"123456789012",
    "repositoryName":"myrepo",
    "packageFormat":"npm",
    "packageNamespace":null,
    "packageName":"mypackage",
    "packageVersion":"1.0.0",
    "packageVersionState":"Published",
    "packageVersionRevision":"0E5DE26A4CD79FDF3EBC4924FFFFFFFF",
    "changes":{
      "assetsAdded":1,
      "assetsRemoved":0,
      "metadataUpdated":true,
      "assetsUpdated":0,
      "statusChanged":true
    },
    "operationType":"Created",
    "sequenceNumber":1,
    "eventDeduplicationId":"2mEO0A2Ke07rWUTBXk3CAiQhdTXF4N94LNaT/ffffff="
  }
}
```