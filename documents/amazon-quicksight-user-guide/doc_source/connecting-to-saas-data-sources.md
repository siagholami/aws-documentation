# Creating a Data Source and Data Set from SaaS Sources<a name="connecting-to-saas-data-sources"></a>

To analyze and report on data from software as a service \(SaaS\) applications, you can use SaaS connectors to access your data directly from Amazon QuickSight\. The SaaS connectors simplify accessing 3rd party application sources using OAuth, without any need to export the data to an intermediate data store\.

You can use either cloud\-based or server\-based instances of the SaaS\. To connect to an SaaS that is running on your corporate network, you need to make sure that the DNS name of your SaaS is accessible to Amazon QuickSight over the network\. If Amazon QuickSight can't access the SaaS, it generates an unknown host error\. 

Here are examples of some ways you can use SaaS data:
+ Engineering teams who use JIRA to track issues and bugs can report on developer efficiency and bug burndown\. 
+ Marketing organizations can integrate Amazon QuickSight with Adobe Analytics to build consolidated dashboards to visualize their online and web marketing data\.
+ Teams using social media can access Twitter data to analyze and understand their customers' sentiment\. 

Use the following procedure to create a data source and data set by connecting to sources available through Software\-as\-a\-Service \(SaaS\)\. In this procedure, we use a connection to GitHub as an example\. Other SaaS data sources follow the same process, although the screens – especially the SaaS screens – might look different\.

1. On the Amazon QuickSight start page, choose **Manage data**\.

1. On the **Your Data Sets** page, choose **New data set**\.

1. In the **FROM NEW DATA SOURCES** section of the **Create a Data Set** page, choose the icon that represents the SaaS you want to use\. For example, you might choose Adobe Analytics or GitHub\.

   For sources using OAuth, the connector takes you to the SaaS site to authorize the connection before letting you create the data source\. A screen similar to one of the following appears:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/new-saas-data-source-name-only.png)

   Or:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/new-saas-data-source-query.png)

   Or, if the SaaS data source doesn't use OAuth, this screen appears:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/new-saas-data-source-not-OAth.png)

1. Choose a name for the data source, and type it in\. If there are more screen prompts, type in the appropriate information\. Then choose **Create data source**\.

1. If you are prompted to do so, enter your credentials on the SaaS login page\.

1. When prompted, authorize the connection between your SaaS data source and Amazon QuickSight\.

   The following example shows the authorization for Amazon QuickSight to access the GitHub account for the Amazon QuickSight documentation\.
**Note**  
Amazon QuickSight documentation is now available on GitHub\. If you'd like to make changes to this user guide, you can use GitHub to edit it directly\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/new-data-source-authorize-saas-github.png)

   \(Optional\) If your SaaS account is part of an organizational account, you might be asked to request organization access as part of authorizing Amazon QuickSight\. If you want to do this, follow the prompts on your SaaS screen, then choose to authorize Amazon QuickSight\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/new-data-source-authorize-saas-github-request-org-access.png)

1. After authorization is complete, choose a table or object to connect to\. Then choose **Select**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/new-saas-data-source-choose-table-github.png)

1. On the following screen, choose one of these options:
   + To save the data source and data set, choose **Edit/Preview data**\. Then choose **Save** from the top menu bar\.
   + To create a data set and an analysis using the data as\-is, choose **Visualize**\. This option automatically saves the data source and the data set\.

     You can also choose **Edit/Preview data** to prepare the data before creating an analysis\. This opens the data preparation screen\. For more information about data preparation, see [Preparing Data Sets](preparing-data-sets.md)\.
   + 
**Note**  
If you don't have enough [SPICE](welcome.md#spice) capacity, choose **Edit/Preview data**\. In the data preparation screen, you can remove fields from the data set to decrease its size or apply a filter that reduces the number of rows returned\. For more information about data preparation, see [Preparing Data Sets](preparing-data-sets.md)\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/new-saas-data-source-finish.png)

**Note**  
The following constraints apply:  
The SaaS must support REST API operations for Amazon QuickSight to connect to it\.
If you are connecting to Jira, the URL must be a public address\.
If you are connecting to Twitter, which supports extracting seven days of data at a time, be aware that currently Amazon QuickSight retrieves only seven days before today\.