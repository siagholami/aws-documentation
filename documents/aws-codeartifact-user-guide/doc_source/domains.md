# Working with domains in CodeArtifact<a name="domains"></a>

CodeArtifact *domains* make it easier to manage multiple repositories across an organization\. You can use a domain to apply permissions across many repositories owned by different AWS accounts\. An asset is stored only once in a domain, even if it's available from multiple repositories\.

Although you can have multiple domains, we recommend a single production domain that contains all published artifacts so that your development teams can find and share packages\. You can use a second preproduction domain to test changes to the production domain configuration\.

These topics describe how to use the CLI and API to configure CodeArtifact domains\.

**Topics**
+ [Domain overview](domain-overview.md)
+ [Create a domain](domain-create.md)
+ [Delete a domain](delete-domain.md)
+ [Domain policies](domain-policies.md)