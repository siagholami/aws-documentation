# Doing More in Migration Hub<a name="doing-more"></a>

This section contains additional information to help enrich your migration experience by providing details on how to fully utilize the Migration Hub console discussed in the following topics:
+ [Tracking Migration Updates](#updates-tracking-wt)
+ [Tracking Metrics Using the Dashboards](#dashboards-tracking-wt)
+ [Navigating from the Dashboard and the Navigation Pane](#navigation-tracking-wt)

## Tracking Migration Updates<a name="updates-tracking-wt"></a>

In order to better understand how Migration Hub helps you monitor progress of a migration, there are three concepts to understand in the Migration Hub:
+ Applications
+ Resources \(for example, servers\)
+ Updates

Migration tools like AWS SMS, AWS DMS, and integrated partners' tools send updates to AWS Migration Hub\. These updates include information about how a particular resource migration \(for example, server or database\) is progressing\. One or more resources are grouped together to make an application\. Each application has a dedicated page in Migration Hub where you can go to see the updates for all the resources in the application\.

When Migration Hub receives an update, it is displayed on the updates page\. There can be a delay of up to five minutes for the initial update to appear in the updates page\.

### Tracking When You Perform Discovery First and Then Migrate<a name="updates-tracking-wt-disco-first"></a>

If you started performing discovery using AWS discovery tools, the servers list will likely be populated before you start migrating\. Migration Hub attempts to automatically map updates from migration tools to servers in the servers list\. If it cannot find a match in the discovered servers list, then Migration Hub will add a server corresponding to the migration update to the servers list and automatically map the update to the server\.

Sometimes, when using AWS discovery tools, the automatic mapping of migration updates to servers can be incorrect\. You can see updates and their mappings on the **Updates** page and can correct the mapping by choosing **Edit**\.

See Step 2\.a in *To determine if a migration update must be manually mapped to a discovered server* procedures below\. If you have to frequently correct mappings after performing discovery, please contact [AWS Support](https://aws.amazon.com/contact-us/)\.

**To determine if a migration update must be manually mapped to a discovered server**

1. In the navigation pane, under **Migrate**, select **Updates**\.

1. Verify if the **Mapped servers** column is populated for every row of migration updates\.

   1. If the **Mapped servers** column is populated for every row of migration updates, this means auto\-mapping was supported by the migration tool and manual mapping is not required\. *You can edit the server mapping by choosing **Edit** next to the server name\.*

   1. If one or more rows of the **Mapped servers** columns is *not* populated and there is a **Map** button present in that row's **Action** column, this is an indication that manual mapping is required\. Proceed to the next set of procedures\.

### Tracking When You Migrate Without Performing Discovery<a name="updates-tracking-wt-no-disco"></a>

If you did not perform discovery with an AWS discovery tool, then Migration Hub will add a server corresponding to the migration update to the servers list and automatically map the update to the server\. You can group servers to applications and then start tracking the migration on the application’s details page in the **Migrate** section of the console\. See, [Group Servers as Applications](migrate-wt-migrate.md#migrate-wt-group-as-applications) and [Track Status of Migrations](migrate-wt-track.md#migrate-wt-track-app-status)\.

### Troubleshooting and Manually Mapping Migration Updates<a name="updates-tracking-wt-troubleshooting"></a>

You can verify that the migration update is mapped to a server by viewing the update on the **Updates** page\. If a server has not been mapped to a migration and you just started the migration task, see if it appears as mapped after waiting five minutes and refreshing the page\.

If after an initial wait of five minutes the update is still not mapped to a server, then you can manually map the update to a server by selecting the **Map** button\. For more information, see the following procedure, *To manually map a migration update to a discovered server*\. For officially supported migration tools, you should not need to manually map migration updates\. If this happens frequently, please contact AWS Support\.

The following steps show you how to manually map a migration update to a discovered server that was not able to be automapped\.

**To manually map a migration update to a discovered server**

1. In the navigation pane, under **Migrate**, select **Updates**\.

1. For each migration update row that has a **Map** button present in the **Action** column, select the **Map** button\.

1. In the **Map to discovered server** box, select the radio button of the server you want to map to the migration update\.

1. Choose **Save**\. A green confirmation message appears at the top of the screen\.

1. Verify that the server name of the server you just mapped is now present in the **Mapped servers** column\.

## Tracking Metrics Using the Dashboards<a name="dashboards-tracking-wt"></a>

Dashboards provide a way to quickly see status and progress summary data, and also help you navigate to more detailed data\.

### Main Dashboard<a name="main-dashboard-tracking-wt"></a>

The main dashboard gathers data from the Discover and Migrate dashboards in a central location\. 

The main dashboard consists of four at\-a\-glance status and information panes as well as a consolidated list of links for quick access\. These panes allow you to understand the summary status of most recently updated applications and also get quick access to any of them, to get an overview of applications in different states, and to track the migration progress over time\. 

To reach the main dashboard, choose **Dashboard** from the navigation pane\.

## Navigating from the Dashboard and the Navigation Pane<a name="navigation-tracking-wt"></a>

After viewing dashboard data summaries, you might want to retrieve more detail without interrupting your workﬂow\. You do this by navigating directly from the relevant status or information pane on the dashboard\.

In the table following, you can ﬁnd instructions on how to navigate from a dashboard to the information you want to see\. You can also find instructions on how to get to this information by using the navigation pane\.


| To See | Do This | Which Is the Same As | 
| --- | --- | --- | 
| All servers |  From the total number of servers inside the Discovery summary box in the Main dashboard, choose **View all servers**\.  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/migrationhub/latest/ug/doing-more.html)  | 
| All agents |  From the total number of agents in the Discovery summary box in the Main Dashboard, choose **View all agents**\.  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/migrationhub/latest/ug/doing-more.html)  | 
| All connectors |  From the total number of connectors in the Discovery summary box in the Main dashboard, choose **View all connectors**\.  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/migrationhub/latest/ug/doing-more.html)  | 
| All applications |  From either the Main dashboard or Migrate dashboard, in the Most recently updated applications pane, choose **View all applications** Or, from the Discover dashboard in the Servers & Applications pane, choose **View all applications**\.  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/migrationhub/latest/ug/doing-more.html)  | 
| Application details\.\.\. [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/migrationhub/latest/ug/doing-more.html) |  From either the Main dashboard or Migrate dashboard in the Most recently updated applications box, choose the application's status box\.  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/migrationhub/latest/ug/doing-more.html)  | 
| Server details\.\.\. [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/migrationhub/latest/ug/doing-more.html) |  From either the Main dashboard or Migrate dashboard, in the Most recently updated applications pane, choose the application\. Then choose the server name in the Server ID column\.  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/migrationhub/latest/ug/doing-more.html)  | 

## Tagging Migration Resources<a name="tagging-migration-resources"></a>

Migrated resources \(Amazon EC2 instances or Amazon Machine Images \(AMIs\)\) reported to Migration Hub by migration tools \(like CloudEndure\) are automatically tagged with Application Discovery Service server IDs\. If you turn on cost allocation tagging, you can view the cost of the AWS resources that are tagged by Migration Hub in the AWS Cost Explorer Service\. Resource tagging by Migration Hub can’t be turned off\. This tagging is implemented automatically and doesn't count against your limit of 50 tags per resource\.

These resources have the `aws:migrationhub:source-id` tag, and the `source-id` matches the `server.configurationId` server asset field from Application Discovery Service\. For more information, see the following topics:
+ [Querying Discovered Configuration Items](https://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-api-queries.html) in the *Application Discovery Service User Guide*\.
+ [Using Cost Allocation Tags](https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/cost-alloc-tags.html) in the *AWS Billing and Cost Management User Guide*\.