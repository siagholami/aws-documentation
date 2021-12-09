# Phase 2: Migrate<a name="discovery-wt-migrate"></a>

The migrate phase has the following steps:
+ Connect Migration Tools to Migration Hub\.
+ Migrate Using the Connected Migration Tools\.

**Topics**
+ [Migrate Step 1: Connect Migration Tools to Migration Hub](#discovery-wt-auth-migrate-tools)
+ [Migrate Step 2: Migrate Using the Connected Migration Tools](#discovery-wt-migrate-using-tools)

## Migrate Step 1: Connect Migration Tools to Migration Hub<a name="discovery-wt-auth-migrate-tools"></a>

### <a name="w33aac12c15c41c11b3"></a>

Migration happens outside Migration Hub using AWS migration tools or integrated partners' migration tools\. You choose these tools through the Tools page in the Migrate section in Migration Hub\.

The table following lists the supported tools\.


| Resource type | Migration tool name | 
| --- | --- | 
|  Server  |  AWS Server Migration Service CloudEndure Migration ATADATA ATAmotion RiverMeadow Migration SaaS  | 
| Database |  AWS Database Migration Service  | 

The preceding tools communicate directly to Migration Hub giving an aggregated view of their migrated progress and status so they can be tracked through Migration Hub\.

The following steps walk you through connecting \(authorizing\) your selected migration tool\.

**To connect \(authorize\) a migration tool**

1. In the navigation pane under **Migrate**, choose **Tools**\.

1. Decide upon which AWS migration tools or integrated partners' tools to migrate your application\.

1. Choose **Connect** in the box to authorize the migration tool you selected to communicate with Migration Hub\. 

   1. AWS migration tools utilize a one\-click authorization process which automatically adds the required permissions role once you choose **Connect**\.

   1. Integrated partners' tools take you to their website when you choose **Connect** where you will be instructed on how to complete authorization\.

**Note**  
Note that if you are using API's or do not want to authorize through Migration Hub's console, you can learn about manual role creation in [New User IAM Setup](new-customer-setup.md)\.

## Migrate Step 2: Migrate Using the Connected Migration Tools<a name="discovery-wt-migrate-using-tools"></a>

### <a name="w33aac12c15c41c13b3"></a>

The following steps walk you through the migration of a previously defined application\.

**To migrate an application**

1. In the navigation pane under **Migrate**, choose **Tools**\.

1. If you connected \(authorized\) an AWS migration tool, choose the console link\. If you connected \(authorized\) an integrated partner's tool, choose the website link\.

1. When you have been linked to either the tool's console or website, follow the migration instructions for your selected migration tool as migration happens outside of Migration Hub\.

1. When your application's migration has started, return to Migration Hub\.

### <a name="w33aac12c15c41c13b5"></a>

**Next steps**

Once you have completed the two steps of the Migrate phase, proceed to
+ [Phase 3: Track](discovery-wt-track.md)