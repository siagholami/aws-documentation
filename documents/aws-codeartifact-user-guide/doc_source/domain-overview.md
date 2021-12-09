# Domain overview<a name="domain-overview"></a>

When you're working with CodeArtifact, domains are useful for the following: 
+  **Deduplicated storage**: An asset only needs to be stored once in a domain, even if it's available in 2 or 2,000 repositories\. That means you only pay for storage once\.
+  **Fast copying**: When you pull packages from an upstream CodeArtifact repository into a downstream or use the [CopyPackageVersions API](copy-package.md), only metadata records must be updated\. No assets are copied\. This makes it fast to set up a new repository for staging or testing\. For more information, see [Working with upstream repositories in CodeArtifact](repos-upstream.md)\.
+  **Easy sharing across repositories and teams**: All of the assets and metadata in a domain are encrypted with a single AWS Key Management Service \(AWS KMS\) customer master key \(CMK\)\. You don't need to manage a key for each repository or grant multiple accounts access to a single key\.
+  **Apply policy across multiple repositories**: The domain administrator can apply policy across the domain\. This includes restricting which accounts have access to repositories in the domain, and who can configure connections to public repositories to use as sources of packages\. For more information, see [Domain policies](domain-policies.md)\.
+  **Unique repository names**: The domain provides a namespace for repositories\. Repository names only need to be unique within the domain\. You should use meaningful names that are easy to understand\.

Domain names must be unique within an account\.

You cannot create a repository without a domain\. When you use the [CreateRepository](create-repo.md) API to create a repository, you must specify a domain name\. You cannot move a repository from one domain to another\.

A repository can be owned by the same AWS account that owns the domain, or a different account\. If the owning accounts are different, the repository\-owning account must be granted the `CreateRepository` permission on the domain resource\. You can do this by adding a resource policy to the domain using the [PutDomainPermissionsPolicy](domain-policies.md#set-domain-policy) command\.

Although an organization can have multiple domains, the recommendation is to have a single production domain that contains all published artifacts so that development teams can find and share packages across their organization\. A second pre\-production domain can be useful for testing changes to the production domain configuration\.

## Cross\-account domains<a name="domain-overview-cross-account"></a>

Domain names only need to be unique within an account, which means there could be multiple domains within a region that have the same name\. Because of this, if you want to access a domain that is owned by an account you are not authenticated to, you must provide the domain owner ID along with the domain name in both the CLI and the console\. See the CLI examples below\.

**Access a domain owned by an account you are authenticated to:**

When accessing a domain within the account you're authenticated to, you only need to specify the domain name\. The example below lists packages in the *my\-repo* repository in the *my\-domain* domain that is owned by your account\.

```
aws codeartifact list-packages --domain my-domain --repository my-repo
```

**Access a domain owned by an account that you are not authenticated to:**

When accessing a domain that is owned by an account that you're not authenticated to, you need to specify the domain owner as well as the domain name\. The example below lists packages in the *other\-repo* repository in the *other\-domain* domain that is owned by an account that you are not authenticated to\. Notice the addition of the `--domain-owner` parameter\.

```
aws codeartifact list-packages --domain other-domain --domain-owner domain-owner-id --repository other-repo
```