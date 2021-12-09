# Step 8: Test the End User Experience<a name="getstarted-verify"></a>

To verify that the end user can successfully access the end user console view and launch your product, sign in to AWS as the end user and perform those tasks\.

**To verify that the end user can access the end user console**

1. To sign in as the IAM user, use account\-specific URL\. To find this URL, open the IAM console, choose **Dashboard** in the navigation pane, and choose **Copy Link**\. Paste the link in your browser, and use the name and password of the IAM user\.

1. In the menu bar, choose the region in which you created the `Engineering Tools` portfolio\.

1. Open the AWS Service Catalog console at [https://console\.aws\.amazon\.com/servicecatalog/](https://console.aws.amazon.com/servicecatalog/) and select **Service Catalog**, **Dashboard** to see the following:
   + **Products** – The products that the user can use\.
   + **Provisioned products** – The provisioned products that the user has launched\.

**To verify that the end user can launch the Linux Desktop product**

1. In the **Products** section of the console, choose **Linux Desktop**\.

1. Choose **Launch product** to start the wizard for configuring your product\.

1. On the **Product version** page, for **Name**, type **Linux\-Desktop**\.

1. In the **Version** table, choose **v1\.0**\.

1. Choose **Next**\.

1. On the **Parameters** page, type the following and choose **Next**:
   +  **Server size** – Choose **t2\.micro**\. 
   +  **Key pair** – Select the key pair that you created in [Step 2: Create a Key Pair](getstarted-keypair.md)\.
   +  **CIDR range** – Type a valid CIDR range for the IP address from which you will connect to the instance\. This can be the default value \(0\.0\.0\.0/0\) to allow access from any IP address, your IP address followed by **/32** to restrict access to your IP address only, or something in between\.

1. On the **Review** page, review the information that you typed, and then choose **Launch** to launch the stack\. The console displays the stack details page for the Linux\-Desktop stack\. The initial status of the product is **Launching**\. It takes several minutes for AWS Service Catalog to launch the product\. To see the current status, refresh your browser\. After the product is launched, the status is **Available**\.