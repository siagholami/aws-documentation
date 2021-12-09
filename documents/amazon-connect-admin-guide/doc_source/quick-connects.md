# Create quick connects<a name="quick-connects"></a>

Quick connects are a way for you to create a list of destinations for common transfers\. For example, you might create a quick connect for Tier 2 support\. If agents in Tier 1 support can't solve the issue, they will transfer the contact to Tier 2\. 

## Types of quick connects<a name="quick-connect-types"></a>

The type of a quick connect specifies the destination\. You can specify one of the following destinations\.

### External quick connect<a name="external-quick-connect-type"></a>

Contacts are transferred to an external number \(such as an on\-call pager\)\. 

### Agent quick connect<a name="agent-quick-connect-type"></a>

Contacts are transferred to a specific agent as part of a contact flow\.

If you want all of your agents to appear individually in the list of quick connects in the Contact Control Panel \(CCP\), you need to add each one manually\. There's no way to automate this process\.

**Important**  
Agent and Queue quick connects only appear in the CCP when an agent goes to transfer a contact\. 

### Queue quick connect<a name="queue-quick-connect-type"></a>

Contacts are transferred to a queue as part of a contact flow\.

**Important**  
Agent and Queue quick connects only appear in the CCP when an agent goes to transfer a contact\. 

## Step 1: Create quick connects<a name="step1-create-quick-connects"></a>

**To create a quick connect**

1. Choose **Routing**, **Quick connects**, **Add a new destination**\.

1. Enter a name for the connect\. Choose the type, and then specify the destination \(such as a phone number or the name of an agent\), contact flow \(if applicable\), and description\.
**Important**  
A description is required when you create a quick connect\. If you don't add one, you'll get an error when you try to save the quick connect\. 

1. To add more quick connects, choose **Add new**\.

1. Choose **Save**\.

## Step 2: Enable agents to see quick connects<a name="step2-enable-agents-to-see-quick-connects"></a>

**To enable your agents to see the quick connects in the CCP when they transfer a contact**

1. After you create the quick connect, go to **Routing**, **Queues** and then choose the appropriate queue for the contact to be routed to\.

1. On the Edit queue page, in the Quick connect box, search for the quick connect you created\.

1. Select the quick connect and then choose **Save**\.

**Tip**  
Agents see all of the quick connects for the queues in their routing profile\.