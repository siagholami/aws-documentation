# Getting started using the AWS CLI<a name="getting-started-cli"></a>

 Run the following steps to get started with CodeArtifact using the AWS Command Line Interface \(AWS CLI\)\. For more information, see [Install or upgrade and then configure the AWS CLI](get-set-up-install-cli.md)\.

1.  Use the AWS CLI to run the create\-domain command\. 

   ```
   aws codeartifact create-domain --domain my-domain
   ```

    JSON\-formatted data appears in the output with details about your new domain\. 

   ```
   {
       "domain": {
           "name": "my-domain",
           "owner": "123456789012",
           "arn": "arn:aws:codeartifact:us-west-2:123456789012:domain/my-domain",
           "status": "Active",
           "encryptionKey": "arn:aws:kms:us-west-2:123456789012:key/your-kms-key"
       }
   }
   ```

1.  Use the create\-repository command to create a repository in your domain\.

   ```
   aws codeartifact create-repository --domain my-domain --domain-owner domain-owner-id --repository my-repo
   ```

    JSON\-formatted data appears in the output with details about your new repository\. 

   ```
   {
       "repository": {
           "name": "my-repo",
           "administratorAccount": "123456789012",
           "domainName": "my-domain",
           "domainOwner": "123456789012",
           "arn": "arn:aws:codeartifact:us-west-2:123456789012:repository/my-domain/my-repo",
           "upstreams": [],
           "externalConnections": []
       }
   }
   ```

1. Use the create\-repository command to create an upstream repository for your `my-repo` repository\.

   ```
   aws codeartifact create-repository --domain my-domain --domain-owner domain-owner-id --repository npm-store
   ```

    JSON\-formatted data appears in the output with details about your new repository\.

   ```
   {
       "repository": {
           "name": "delete",
           "administratorAccount": "123456789012",
           "domainName": "my-domain",
           "domainOwner": "123456789012",
           "arn": "arn:aws:codeartifact:us-west-2:123456789012:repository/my-domain/npm-store",
           "upstreams": [],
           "externalConnections": []
       }
   }
   ```

1.  Use the associate\-external\-connection command to add an external connection to the npm public repository to your `npm-store` repository\. 

   ```
   aws codeartifact associate-external-connection --domain my-domain --domain-owner domain-owner-id --repository npm-store --external-connection "public:npmjs"
   ```

    JSON\-formatted data appears in the output with details about the repository and its new external connection\.

   ```
   {
       "repository": {
           "name": "npm-store",
           "administratorAccount": "123456789012",
           "domainName": "my-domain",
           "domainOwner": "123456789012",
           "arn": "arn:aws:codeartifact:us-west-2:123456789012:repository/my-domain/npm-store",
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

    For more information, see [Add an external connection](external-connection.md)\. 

1.  Use the update\-repository command to associate the `npm-store` repository as an upstream repository to the `my-repo` repository\. 

   ```
   aws codeartifact update-repository --repository my-repo --domain my-domain --domain-owner domain-owner-id --upstreams repositoryName=npm-store
   ```

    JSON\-formatted data appears in the output with details about your updated repository, including its new upstream repository\.

   ```
   {
       "repository": {
           "name": "my-repo",
           "administratorAccount": "123456789012",
           "domainName": "my-domain",
           "domainOwner": "123456789012",
           "arn": "arn:aws:codeartifact:us-west-2:123456789012:repository/my-domain/my-repo",
           "upstreams": [
               {
                   "repositoryName": "npm-store"
               }
           ],
           "externalConnections": []
       }
   }
   ```

    For more information, see [Add, update, or remove upstream repositories \(AWS CLI\)](repo-upstream-add-cli.md)\. 

1. Use the login command to configure your npm package manager with your `my-repo` repository\. 

   ```
   aws codeartifact login --tool npm --repository my-repo --domain my-domain --domain-owner your-AWS-account-ID
   ```

   If successful, you see the following output\.

   ```
   Successfully logged in to codeartifact for npm
   ```

    For more information, see [Authentication with npm](npm-auth.md)\. 

1.  Use the npm CLI to install an npm library\. For example, install a library listed in [https://www\.npmjs\.com/](https://www.npmjs.com/) as follows\. 

   ```
   npm install library-name
   ```

1.  Use the list\-packages command to view the package you just installed in your `my-repo` repository\. 
**Note**  
 There may be a delay between when you install the package and when it is ingested into your repository\. 

   ```
   aws codeartifact list-packages --domain my-domain --repostiory my-repo
   ```

    JSON\-formatted data appears in the output with the format and name of the package that you installed\. 

   ```
   {
       "packages": [
           {
               "format": "npm",
               "package": "library-name"
           }
       ]
   }
   ```

   You now have the following three CodeArtifact resources: 
   +  The domain `my-domain`\. 
   +  The repository `my-repo` that is contained in `my-domain`\. This repository has an npm package available to it\. 
   +  The repository `npm-store` that is contained in `my-domain`\. This repository also has an external connection to the public npm repository and is associated as an upstream repository with the `my-repo` repository\. 

1. To avoid further AWS charges, delete the resources that you used during this tutorial: 
**Note**  
 You cannot delete a domain that contains repositories, so you must delete `my-repo` and `npm-store` before you delete `my-domain`\. 

   1.  Use the delete\-repository command to delete the `npm-store` repository\. 

      ```
      aws codeartifact delete-repository --domain my-domain --domain-owner domain-owner-id --repository my-repo
      ```

       JSON\-formatted data appears in the output with details about the deleted repository\. 

      ```
      {
          "repository": {
              "name": "my-repo",
              "administratorAccount": "123456789012",
              "domainName": "my-domain",
              "domainOwner": "123456789012",
              "arn": "arn:aws:codeartifact:us-west-2:123456789012:repository/my-domain/my-repo",
              "upstreams": [
                  {
                      "repositoryName": "npm-store"
                  }
              ],
              "externalConnections": []
          }
      }
      ```

   1.  Use the delete\-repository command to delete the `npm-store` repository\. 

      ```
      aws codeartifact delete-repository --domain my-domain --domain-owner domain-owner-id --repository npm-store
      ```

       JSON\-formatted data appears in the output with details about the deleted repository\.

      ```
      {
          "repository": {
              "name": "npm-store",
              "administratorAccount": "123456789012",
              "domainName": "my-domain",
              "domainOwner": "123456789012",
              "arn": "arn:aws:codeartifact:us-west-2:123456789012:repository/my-domain/npm-store",
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

   1. Use the delete\-domain command to delete the `my-domain` repository\. 

      ```
      aws codeartifact delete-domain --domain my-domain --domain-owner domain-owner-id
      ```

       JSON\-formatted data appears in the output with details about the deleted domain\.

      ```
      {
          "domain": {
              "name": "my-domain",
              "owner": "123456789012",
              "arn": "arn:aws:codeartifact:us-west-2:123456789012:domain/my-domain",
              "status": "Active",
              "encryptionKey": "arn:aws:kms:us-west-2:123456789012:key/your-kms-key"
          }
      }
      ```