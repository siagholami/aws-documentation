# Option 1: Perform Discovery and Then Migrate<a name="discovery-walkthroughs"></a>

**Discover**  
Here you will be guided through the workflow of starting your migration by first discovering your existing infrastructure using AWS discovery tools\. You can download and deploy discovery connectors and/or discovery agents to discover your existing infrastructure\. When one of these is deployed, you start data collection from the Migration Hub console\.

Migration Hub's discovery process collects data about your existing environment using AWS discovery tools such as the AWS Agentless Discovery Connector and the AWS Application Discovery Agent\. These discovery tools store their collected data in the Application Discovery Service's repository providing details about each server and the processes running on them\. Application Discovery Service is another AWS service that is integrated with Migration Hub so that you can view your discovery data inside Migration Hub\.

When you have discovered your servers and their respective data has been collected into the repository, you can view details about any server by choosing the server ID on the [Servers](http://console.aws.amazon.com/discovery/home?source=mgh#/resources) page\. Choosing a server ID brings you to a server detail page\.

You can logically define and group all the discovered servers that comprise the applications you want to migrate\.

**Migrate**  
Migration happens outside Migration Hub and uses the supported migration tools\. These tools include both AWS migration tools and integrated partners' migration tools\. You can also group more servers into either an existing or a new application at a later time\.

**Track**  
Migration Hub helps you monitor the status of your migrations in all AWS regions, provided your migration tools are available in that region\. The migration tools that integrate with the Migration Hub \(e\.g\., SMS, DMS\) send migration status to the Migration Hub in us\-west\-2\. There, the status is aggregated and visible in a single location\. These tools will not send status unless they have been authorized \(that is, connected\) by customers

*These tools will not send status unless they have been connected \(authorized\)\.*

The steps you will be doing in this walkthrough follow the outline of the **Perform Discovery and Then Migrate** workflow:

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/migrationhub/latest/ug/images/workflow1.png)

The following topics guide you through the three major steps of a discovery based migration workflow:

**Topics**
+ [Phase 1: Discover](discovery-wt-discover.md)
+ [Phase 2: Migrate](discovery-wt-migrate.md)
+ [Phase 3: Track](discovery-wt-track.md)