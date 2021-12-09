# Phase 1: Migrate<a name="migrate-wt-migrate"></a>

The migrate phase has the following steps: 
+ Connect Migration Tools to Migration Hub\.
+ Migrate Using the Connected Migration Tools\.
+ Group Servers as Applications\.

**Topics**
+ [Migrate Step 1: Connect Migration Tools to Migration Hub](#migrate-wt-auth-migrate-tools)
+ [Migrate Step 2: Migrate Using the Connected Migration Tools](#migrate-wt-migrate-using-tools)
+ [Migrate Step 3: Group Servers as Applications](#migrate-wt-group-as-applications)

## Migrate Step 1: Connect Migration Tools to Migration Hub<a name="migrate-wt-auth-migrate-tools"></a>

If you landed here from Step 3 of [Migrate Without Performing Discovery](gs-new-user-migration.md), the following steps will show you how to authorize a migration tool and begin migrating\. 

### <a name="w33aac12c20c27c11b5"></a>

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

## Migrate Step 2: Migrate Using the Connected Migration Tools<a name="migrate-wt-migrate-using-tools"></a>

### <a name="w33aac12c20c27c13b3"></a>

The following steps walk you through the migration of a previously defined application\.

**To migrate an application**

1. In the navigation pane under **Migrate**, choose **Tools**\.

1. If you connected \(authorized\) an AWS migration tool, choose the console link\. If you connected \(authorized\) an integrated partner's tool, choose the website link\.

1. When you have been linked to either the tool's console or website, follow the migration instructions for your selected migration tool as migration happens outside of Migration Hub\.

1. When your application's migration has started, return to Migration Hub\.

## Migrate Step 3: Group Servers as Applications<a name="migrate-wt-group-as-applications"></a>

These steps walk you through the process of grouping servers as applications when directly migrating with a migration tool without performing discovery first\.

When the migration tool has started, you will see the servers listed in Migration Hub from the migration updates sent from the migration tool\. You can select the servers and group them as applications\. Keep in mind that the server information communicated to Migration Hub from the migration tool is not as detailed as what is collected from a discovery tool\.

The following steps will show you how to select the server or servers you want to group for your application, how to create your application and name it, and how to add identifying tags\.

**To group servers into a new or existing application**

1. In the navigation pane, select **Servers**\.

1. In the severs list, select the checkbox for each of the servers you want to group into a new or existing application\.

   1. You can also search and filter on any of the criteria specified in the headers of the server list\. Click inside the search bar and choose an item from the dropdown, then choose an operator from the next dropdown, and then type in your criteria\.

   1. Optionally, for each selected server, you can add a descriptive tag by choosing **Add tag**\. A dialog box appears where you can type a value for **Key**, and optionally, a value for **Value**\.

1. Create your application, or add to an existing one, by choosing **Group as application**\.

1. In the **Group as application** dialog box, select either **Group as a new application** or **Add to an existing application**\.

   1. If you chose **Group as a new application**, type a name for **Application name**\. Optionally, you can type a description for **Application description**\.

   1. If you chose **Add to an existing application**, select the radio button next to the application name in the list box\.

1. Choose **Save**\. A green confirmation message appears at the top of the screen\.

**Next steps**

Once you have completed the three steps of the Migrate phase, proceed to
+ [Phase 2: Track](migrate-wt-track.md)