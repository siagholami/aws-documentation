# Connecting an Application to a Database Server<a name="workingapps-connectdb"></a>

You can associate an Amazon RDS database server with an app when you [create the app](workingapps-creating.md) or later by [editing the app](workingapps-editing.md)\. Your application can then use the database connection information—user name, password, \.\.\.—to connect to the database server\. When you [deploy an app](workingapps-deploying.md), AWS OpsWorks Stacks provides this information to applications in two ways:
+ For Linux stacks, AWS OpsWorks Stacks creates a file on each of the built\-in application server instances containing the connection data that the application can use to connect to the database server\.
+ AWS OpsWorks Stacks includes the connection information in the [stack configuration and deployment attributes](workingcookbook-json.md) that are installed on each instance\.

  You can implement a custom recipe to extract the connection information from these attributes and put it in a file in your preferred format\. For more information, see [Passing Data to Applications](apps-data.md)\.

**Important**  
For Linux stacks, if you want to associate an Amazon RDS service layer with your app, you must add the appropriate driver package to the associated app server layer, as follows:   
Click **Layers** in the navigation pane and open the app server's **Recipes** tab\.
Click **Edit** and add the appropriate driver package to **OS Packages**\. For example, you should specify `mysql` if the layer contains Amazon Linux instances and `mysql-client` if the layer contains Ubuntu instances\.
Save the changes and redeploy the app\.

## Using a Custom Recipe<a name="workingapps-connectdb-custom"></a>

You can implement a custom recipe that extracts the connection data from the app's [`deploy` attributes](workingcookbook-json.md#workingcookbook-json-deploy) and saves it in a form that the application can read, such as a YAML file\.

You attach a database server to an app when you [create the app](workingapps-creating.md) or later by [editing the app](workingapps-editing.md)\. When you deploy the app, AWS OpsWorks Stacks installs a [stack configuration and deployment attributes](workingcookbook-json.md) on each instance that include the database connection information\. Your app can then retrieve the appropriate attributes\. The details depend on whether you are using a Linux or Windows stack\.

### Connecting to a Database Server for a Linux Stack<a name="w4ab1c11c49c17b9b6"></a>

For Linux stacks, the [stack configuration and deployment attributes'](workingcookbook-json.md) `deploy` namespace includes an attribute for each deployed app, named with the app's short name\. When you attach a database server to an app, AWS OpsWorks Stacks populates the app's `[:database]` attribute with the connection information, and installs it on the stack's instances for each subsequent deployment\. The attribute values are either user\-provided or generated by AWS OpsWorks Stacks\.

**Note**  
AWS OpsWorks Stacks allows you to attach a database server to multiple apps, but each app can have only one attached database server\. If you want to connect an application to more than one database server, attach one of the servers to the app, and use the information in the app's `deploy` attributes to connect to that server\. Use custom JSON to pass the connection information for the other database servers to the application\. For more information, see [Passing Data to Applications](apps-data.md)\.

An application can use the connection information from the instance's `deploy` attributes to connect to a database\. However, applications cannot access that information directly—only recipes can access the `deploy` attributes\. You can address this issue by implementing a custom recipe that extracts the connection information from the `deploy` attributes and puts it in a file that can be read by the application\.