# Ingesting data to AWS IoT SiteWise from AWS IoT things<a name="ingest-data-from-iot-things"></a>

You can easily ingest data to AWS IoT SiteWise from a fleet of AWS IoT things by using device shadows\. Device shadows are JSON objects that store current state information for an AWS IoT device\. For more information, see [Device shadow service](https://docs.aws.amazon.com/iot/latest/developerguide/iot-device-shadows.html) in the *AWS IoT Developer Guide*\.

After you complete this tutorial, you can set up an operation in AWS IoT SiteWise based on AWS IoT things\. By using AWS IoT things, you can also easily integrate your operation with other useful features of AWS IoT\. For example, you can configure AWS IoT features to do the following tasks:
+ Configure additional rules to stream data to [AWS IoT Events](https://docs.aws.amazon.com/iotevents/latest/developerguide/), [Amazon DynamoDB](https://docs.aws.amazon.com/dynamodb), and other AWS services\. For more information, see [Rules](https://docs.aws.amazon.com/iot/latest/developerguide/iot-rules.html) in the *AWS IoT Developer Guide*\.
+ Index, search, and aggregate your device data with the AWS IoT Fleet Indexing service\. For more information, see [Fleet indexing service](https://docs.aws.amazon.com/iot/latest/developerguide/iot-indexing.html) in the *AWS IoT Developer Guide*\.
+ Audit and secure your devices with AWS IoT Device Defender\. For more information, see [AWS IoT Device Defender](https://docs.aws.amazon.com/iot/latest/developerguide/device-defender.html) in the *AWS IoT Developer Guide*\.

In this tutorial, you learn how to ingest data from AWS IoT things' device shadows to assets in AWS IoT SiteWise\. To do so, you create one or more AWS IoT things and run a script that updates each thing's device shadow with CPU and memory usage data\. You use CPU and memory usage data in this tutorial to imitate realistic sensor data\. Then, you create a rule with an AWS IoT SiteWise action that sends this data to an asset in AWS IoT SiteWise every time a thing's device shadow updates\. For more information, see [Ingesting data using AWS IoT Core rules](iot-rules.md)\.

**Topics**
+ [Prerequisites](#rule-ingestion-tutorial-prerequisites)
+ [Creating an AWS IoT policy](#rule-tutorial-create-iot-policy)
+ [Creating and configuring an AWS IoT thing](#rule-tutorial-create-iot-thing)
+ [Creating a device asset model](#rule-tutorial-create-device-model)
+ [Creating a device fleet asset model](#rule-tutorial-create-fleet-model)
+ [Creating and configuring a device asset](#rule-tutorial-create-device-assets)
+ [Creating and configuring a device fleet asset](#rule-tutorial-create-fleet-asset)
+ [Creating a rule in AWS IoT Core to send data to device assets](#rule-tutorial-create-iot-rule)
+ [Running the device client script](#rule-tutorial-run-script)
+ [Cleaning up resources after the tutorial](#rule-tutorial-clean-up-resources)
+ [Troubleshooting a rule](#rule-tutorial-troubleshoot-rule)

## Prerequisites<a name="rule-ingestion-tutorial-prerequisites"></a>

To complete this tutorial, you need the following:
+ An AWS account\. If you don't have one, see [Setting up an AWS account](set-up-aws-account.md)\.
+ A development computer running Windows, macOS, Linux, or Unix to access the AWS Management Console\. For more information, see [Getting Started with the AWS Management Console](https://docs.aws.amazon.com/awsconsolehelpdocs/latest/gsg/getting-started.html)\.
+ An IAM user with administrator permissions\.
+ Python 3 installed on your development computer or installed on the device that you want to register as an AWS IoT thing\.

## Creating an AWS IoT policy<a name="rule-tutorial-create-iot-policy"></a>

In this procedure, you create an AWS IoT policy that allows your AWS IoT things to access the resources used in this tutorial\.

**To create an AWS IoT policy**

1. Sign in to the [AWS Management Console](https://console.aws.amazon.com/)\.

1. Review the [AWS Regions](getting-started.md#requirements) where AWS IoT SiteWise is supported\. Switch to one of these supported Regions, if necessary\.

1. Navigate to the [AWS IoT console](https://console.aws.amazon.com/iot/)\. If a **Get started** button appears, choose it\.

1. In the left navigation pane, choose **Secure** and then choose **Policies**\.

1. If a **You don't have any policies yet** dialog box appears, choose **Create a policy**\. Otherwise, choose **Create**\.

1. Enter a name for the AWS IoT policy \(for example, **SiteWiseTutorialDevicePolicy**\)\.

1. Under **Add statements**, choose **Advanced mode** to enter the following policy in JSON form\. Replace *region* and *account\-id* with your Region and account ID, such as **us\-east\-1** and **123456789012**\.

   ```
   {
     "Version": "2012-10-17",
     "Statement": [
       {
         "Effect": "Allow",
         "Action": "iot:Connect",
         "Resource": "arn:aws:iot:region:account-id:client/SiteWiseTutorialDevice*"
       },
       {
         "Effect": "Allow",
         "Action": "iot:Publish",
         "Resource": [
           "arn:aws:iot:region:account-id:topic/$aws/things/${iot:Connection.Thing.ThingName}/shadow/update",
           "arn:aws:iot:region:account-id:topic/$aws/things/${iot:Connection.Thing.ThingName}/shadow/delete",
           "arn:aws:iot:region:account-id:topic/$aws/things/${iot:Connection.Thing.ThingName}/shadow/get"
         ]
       },
       {
         "Effect": "Allow",
         "Action": "iot:Receive",
         "Resource": [
           "arn:aws:iot:region:account-id:topic/$aws/things/${iot:Connection.Thing.ThingName}/shadow/update/accepted",
           "arn:aws:iot:region:account-id:topic/$aws/things/${iot:Connection.Thing.ThingName}/shadow/delete/accepted",
           "arn:aws:iot:region:account-id:topic/$aws/things/${iot:Connection.Thing.ThingName}/shadow/get/accepted",
           "arn:aws:iot:region:account-id:topic/$aws/things/${iot:Connection.Thing.ThingName}/shadow/update/rejected",
           "arn:aws:iot:region:account-id:topic/$aws/things/${iot:Connection.Thing.ThingName}/shadow/delete/rejected"
         ]
       },
       {
         "Effect": "Allow",
         "Action": "iot:Subscribe",
         "Resource": [
           "arn:aws:iot:region:account-id:topicfilter/$aws/things/${iot:Connection.Thing.ThingName}/shadow/update/accepted",
           "arn:aws:iot:region:account-id:topicfilter/$aws/things/${iot:Connection.Thing.ThingName}/shadow/delete/accepted",
           "arn:aws:iot:region:account-id:topicfilter/$aws/things/${iot:Connection.Thing.ThingName}/shadow/get/accepted",
           "arn:aws:iot:region:account-id:topicfilter/$aws/things/${iot:Connection.Thing.ThingName}/shadow/update/rejected",
           "arn:aws:iot:region:account-id:topicfilter/$aws/things/${iot:Connection.Thing.ThingName}/shadow/delete/rejected"
         ]
       },
       {
         "Effect": "Allow",
         "Action": [
           "iot:GetThingShadow",
           "iot:UpdateThingShadow",
           "iot:DeleteThingShadow"
         ],
         "Resource": "arn:aws:iot:region:account-id:thing/SiteWiseTutorialDevice*"
       }
     ]
   }
   ```

   This policy allows your AWS IoT things to connect and interact with device shadows through MQTT messages\. To interact with device shadows, your AWS IoT things publish and receive MQTT messages on topics that start with `$aws/things/thing-name/shadow/`\. This policy uses a thing policy variable `${iot:Connection.Thing.ThingName}`, which substitutes the connected thing's name in each topic\. The `iot:Connect` statement limits which things can connect, so the thing policy variable can only substitute to names that start with `SiteWiseTutorialDevice`\. 

   For more information, see [Thing policy variables](https://docs.aws.amazon.com/iot/latest/developerguide/iot-policy-variables.html) in the *AWS IoT Developer Guide*\.
**Note**  
This policy applies to things whose names start with `SiteWiseTutorialDevice`\. To use a different name for your things, you must update the policy accordingly\.

1. Choose **Create**\.

## Creating and configuring an AWS IoT thing<a name="rule-tutorial-create-iot-thing"></a>

In this procedure, you create and configure an AWS IoT thing\. You can register your development computer as an AWS IoT thing to easily complete this tutorial\. When you apply this tutorial's concepts to a real\-world application, you can create and configure AWS IoT things on any device that can run an AWS IoT SDK, including AWS IoT Greengrass and FreeRTOS\. For more information, see [AWS IoT SDKs](https://docs.aws.amazon.com/iot/latest/developerguide/iot-sdks.html) in the *AWS IoT Developer Guide*\.

**To create and configure an AWS IoT thing**

1. Open a command line and run the following command to create a directory for this tutorial\.

   ```
   mkdir iot-sitewise-rule-tutorial
   cd iot-sitewise-rule-tutorial
   ```

1. Run the following command to create a directory for your thing's certificates\.

   ```
   mkdir device1
   ```

   If you're creating additional things, increment the number in the directory name accordingly to keep track of which certificates belong to which thing\.

1. Navigate to the [AWS IoT console](https://console.aws.amazon.com/iot/)\.

1. In the left navigation pane, choose **Manage** and then choose **Things**\.

1. If a **You don't have any things yet** dialog box appears, choose **Create a thing**\. Otherwise, choose **Create**\.

1. On the **Creating AWS IoT things** page, choose **Create a single thing**\.

1. On the **Add your device to the device registry** page, enter a name for your AWS IoT thing \(for example, **SiteWiseTutorialDevice1**\) and then choose **Next**\. If you're creating additional things, increment the number in the thing name accordingly\.
**Important**  
The thing name must match the name used in the policy that you created earlier in this tutorial\. Otherwise, your device can't connect to AWS IoT\.  
![\[AWS IoT "Add your device to the thing registry" page screenshot with the thing name highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/rule-ingestion/iot-name-thing-console.png)

1. On the **Add a certificate for your thing** page, choose **Create certificate**\. Certificates enable AWS IoT to securely identify your devices\.  
![\[AWS IoT "Add a certificate for your thing" page screenshot with "Create certificate" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/rule-ingestion/iot-add-thing-certificate-console.png)

1. Choose the **Download** links to download your thing's certificate, public key, and private key\. Save all three files to the directory that you created for your thing's certificates \(for example, `iot-sitewise-rule-tutorial/device1`\)\.
**Important**  
This is the only time that you can download your thing's certificate and keys, which you need for your device to successfully connect to AWS IoT\.  
![\[AWS IoT "Certificate created" page screenshot with certificate download links highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/rule-ingestion/iot-download-thing-certificates-console.png)

1. Choose the root CA **Download** link to open a documentation page where you choose and download a root CA certificate\. Save the root CA certificate to the `iot-sitewise-rule-tutorial`\. We recommend downloading Amazon Root CA 1\.

1. Choose **Activate**\.

1. Choose **Attach a policy**\.

1. On the **Add a policy for your thing page**, choose the policy that you created earlier in this tutorial \(**SiteWiseTutorialDevicePolicy**\), then choose **Register Thing**\.  
![\[AWS IoT "Add a policy for your thing" page screenshot with "SiteWiseTutorialDevicePolicy" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/rule-ingestion/iot-attach-thing-policy-console.png)

1. You have now registered an AWS IoT thing on your computer\. You can now take one of the following next steps:
   + Continue to the next section without creating additional AWS IoT things\. You can complete this tutorial with only one thing\.
   + Repeat the steps in this section on another computer or device to create more AWS IoT things\. For this tutorial, we recommend that you follow this option so that you can ingest unique CPU and memory usage data from multiple devices\.
   + Repeat the steps in this section on the same device \(your computer\) to create more AWS IoT things\. Each AWS IoT thing receives similar CPU and memory usage data from your computer, so use this approach to demonstrate ingesting non\-unique data from multiple devices\.

## Creating a device asset model<a name="rule-tutorial-create-device-model"></a>

In this procedure, you create an asset model in AWS IoT SiteWise to represent your devices that stream CPU and memory usage data\. Asset models enforce consistent information across multiple assets of the same type, so that you can process data in assets that represent groups of devices\. For more information, see [Modeling industrial assets](industrial-asset-models.md)\.

**To create an asset model that represents a device**

1. Navigate to the [AWS IoT SiteWise console](https://console.aws.amazon.com/iotsitewise/)\.

1. In the left navigation pane, choose **Models**\.

1. Choose **Create model**\.

1. Enter a name under **Asset model information** \(for example, **SiteWise Tutorial Device Model**\)\.

1. Under **Measurement definitions**, do the following:

   1. In **Name**, enter **CPU Usage**\.

   1. In **Unit**, enter **%**\.

   1. Leave the **Data type** as **Double**\.

   Measurement properties represent a device's raw data streams\. For more information, see [Defining data streams from equipment \(measurements\)](measurements.md)\.

1. Choose **Add measurement** to add a second measurement property\.

1. In the second row under **Measurement definitions**, do the following:

   1. In **Name**, enter **Memory Usage**\.

   1. In **Unit**, enter **%**\.

   1. Leave the **Data type** as **Double**\.  
![\[AWS IoT SiteWise device asset "Measurement definitions" screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/rule-ingestion/sitewise-device-model-measurements-console.png)

1. Under **Metric definitions**, do the following:

   1. In **Name**, enter **Average CPU Usage**\.

   1. In **Formula**, enter **avg\(CPU Usage\)**\. Choose **CPU Usage** from the autocomplete list when it appears\.

   1. In **Time interval**, enter **5 minutes**\.

   Metric properties define aggregation calculations that process all input data points over an interval and output a single data point per interval\. This metric property calculates each device's average CPU usage every 5 minutes\. For more information, see [Aggregating data from properties and other assets \(metrics\)](metrics.md)\.

1. Choose **Add metric** to add a second metric property\.

1. In the second row under **Metric definitions**, do the following:

   1. In **Name**, enter **Average Memory Usage**\.

   1. In **Formula**, enter **avg\(Memory Usage\)**\. Choose **Memory Usage** from the autocomplete list when it appears\.

   1. In **Time interval**, enter **5 minutes**\.

   This metric property calculates each device's average memory usage every 5 minutes\.  
![\[AWS IoT SiteWise device asset "Metric definitions" screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/rule-ingestion/sitewise-device-model-metrics-console.png)

1. \(Optional\) Add other additional metrics that you're interested in calculating per device\. Some interesting functions include `min` and `max`\. For more information, see [Using formula expressions](formula-expressions.md)\. In the next section, you create a parent asset that can calculate metrics using data from your entire fleet of devices\.

1. Choose **Create model**\.

## Creating a device fleet asset model<a name="rule-tutorial-create-fleet-model"></a>

In this procedure, you create an asset model in AWS IoT SiteWise to represent your fleet of devices\. In this asset model, you define a hierarchy, which lets you associate many device assets to a single fleet asset\. Then, you define metrics in the fleet asset model that aggregate data from all associated device assets to gain insights about your fleet as a whole\.

**To create an asset model that represents a device fleet**

1. Navigate to the [AWS IoT SiteWise console](https://console.aws.amazon.com/iotsitewise/)\.

1. In the left navigation pane, choose **Models**\.

1. Choose **Create model**\.

1. Enter a name under **Asset model information** \(for example, **SiteWise Tutorial Device Fleet Model**\.

1. Under **Hierarchy definitions**, do the following:

   1. Choose **Add hierarchy**\.

   1. In **Hierarchy name**, enter **Device**\.

   1. In **Hierarchy model**, choose your device asset model \(**SiteWise Tutorial Device Model**\)\.

   A hierarchy defines a relationship between a parent \(fleet\) asset model and a child \(device\) asset model\. Parent assets can access child assets' property data\. When you create assets later, you need to associate child assets to parent assets according to a hierarchy definition in the parent asset model\. For more information, see [Defining relationships between assets \(hierarchies\)](asset-hierarchies.md)\.

1. Under **Metric definitions**, do the following:

   1. In **Name**, enter **Average CPU Usage**\.

   1. In **Formula**, enter **avg\(Device \| Average CPU Usage\)**\. When the autocomplete list appears, choose **Device** to choose a hierarchy, then choose **Average CPU Usage** to choose the metric from the device asset that you created earlier\.

   1. In **Time interval**, enter **5 minutes**\.

   This metric property calculates the average CPU usage of all device assets associated to a fleet asset through the **Device** hierarchy\.

1. Choose **Add metric** to add a second metric property\.

1. In the second row under **Metric definitions**, do the following:

   1. In **Name**, enter **Average Memory Usage**\.

   1. In **Formula**, enter **avg\(Device \| Average Memory Usage\)**\. When the autocomplete list appears, choose **Device** to choose a hierarchy, then choose **Average Memory Usage** to choose the metric from the device asset that you created earlier\.

   1. In **Time interval**, enter **5 minutes**\.

   This metric property calculates the average memory usage of all device assets associated to a fleet asset through the **Device** hierarchy\.  
![\[AWS IoT SiteWise device fleet asset "Metric definitions" screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/rule-ingestion/sitewise-device-fleet-model-console.png)

1. \(Optional\) Add other additional metrics that you're interested in calculating across your fleet of devices\.

1. Choose **Create model**\.

## Creating and configuring a device asset<a name="rule-tutorial-create-device-assets"></a>

In this procedure, you create a device asset from your device asset model\. Then, you define property aliases for each measurement property\. A property alias is a string that uniquely identifies an asset property\. You can later use these aliases, rather than asset ID and property ID, to identify a property to which to upload data\. For more information, see [Mapping industrial data streams to asset properties](connect-data-streams.md)\.

**To create a device asset and define property aliases**

1. Navigate to the [AWS IoT SiteWise console](https://console.aws.amazon.com/iotsitewise/)\.

1. In the left navigation pane, choose **Assets**\.

1. Choose **Create asset**\.

1. In **Asset model**, choose your device asset model, **SiteWise Tutorial Device Model**\.

1. In **Name**, enter **SiteWise Tutorial Device 1**\.

1. Choose **Create asset**\.  
![\[AWS IoT SiteWise "Create an asset" screenshot for a SiteWise Tutorial Device asset.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/rule-ingestion/sitewise-create-device-asset-console.png)

1. For your new device asset, choose **Edit**\.  
![\[AWS IoT SiteWise device asset "Edit" screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/rule-ingestion/sitewise-device-asset-edit-console.png)

1. Under **CPU Usage**, enter **/tutorial/device/SiteWiseTutorialDevice1/cpu** as the property alias\. You include the AWS IoT thing's name in the property alias, so that you can ingest data from all of your devices using a single AWS IoT rule\.

1. Under **Memory Usage**, enter **/tutorial/device/SiteWiseTutorialDevice1/memory** as the property alias\.  
![\[AWS IoT SiteWise device fleet asset property aliases screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/rule-ingestion/sitewise-device-asset-alias-console.png)

1. Choose **Save asset**\.

1. If you created multiple AWS IoT things earlier, repeat steps 3 through 10 for each device, and increment the number in the asset name and property aliases accordingly\. For example, the second device asset's name should be **SiteWise Tutorial Device 2**, and its property aliases should be **/tutorial/device/SiteWiseTutorialDevice2/cpu**, and **/tutorial/device/SiteWiseTutorialDevice2/memory**\.

## Creating and configuring a device fleet asset<a name="rule-tutorial-create-fleet-asset"></a>

In this procedure, you create a device fleet asset from your device fleet asset model\. Then, you associate your device assets to the fleet asset so that the fleet asset's metric properties can aggregate data from many devices\.

**To create a device fleet asset and associate device assets**

1. Navigate to the [AWS IoT SiteWise console](https://console.aws.amazon.com/iotsitewise/)\.

1. In the left navigation pane, choose **Assets**\.

1. Choose **Create asset**\.

1. In **Asset model**, choose your device fleet asset model, **SiteWise Tutorial Device Fleet Model**\.

1. In **Name**, enter **SiteWise Tutorial Device Fleet 1**\.

1. Choose **Create asset**\.  
![\[AWS IoT SiteWise "Create an asset" screenshot for a SiteWise Tutorial Device Fleet asset.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/rule-ingestion/sitewise-create-device-fleet-asset-console.png)

1. For your new device fleet asset, choose **Edit**\.  
![\[AWS IoT SiteWise device fleet asset "Edit" screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/rule-ingestion/sitewise-device-fleet-asset-edit-console.png)

1. Under **Assets associated to this asset**, choose **Add associated asset**\.

1. Under **Hierarchy**, choose **Device**\. This hierarchy identifies the hierarchical relationship between device and device fleet assets\. You defined this hierarchy in the device fleet asset model earlier in this tutorial\.

1. Under **Asset**, choose your device asset, **SiteWise Tutorial Device 1**\.  
![\[AWS IoT SiteWise "Assets associated to this asset" screenshot for a SiteWise Tutorial Device Fleet asset.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/rule-ingestion/sitewise-associate-device-assets-console.png)

1. If you created multiple device assets earlier, repeat steps 8 through 10 for each device asset that you created\.

1. Choose **Save asset**\.

   You should now see your device assets organized as a hierarchy\.  
![\[AWS IoT SiteWise device asset hierarchy screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/rule-ingestion/sitewise-device-asset-hierarchy-console.png)

## Creating a rule in AWS IoT Core to send data to device assets<a name="rule-tutorial-create-iot-rule"></a>

In this procedure, you create a rule in AWS IoT Core that parses device shadow notification messages and sends data to your device assets in AWS IoT SiteWise\. Each time your device's shadow updates, AWS IoT sends an MQTT message\. You can create a rule that takes action when device shadows change based on the MQTT message\. In this case, you want to process the update message to extract the property values and send them to your device assets in AWS IoT SiteWise\.

**To create a rule with an AWS IoT SiteWise action**

1. Navigate to the [AWS IoT console](https://console.aws.amazon.com/iot/)\.

1. In the left navigation pane, choose **Act** and then choose **Rules**\.

1. If a **You don't have any rules yet** dialog box appears, choose **Create a rule**\. Otherwise, choose **Create**\.

1. Enter a name and description for your rule\.  
![\[AWS IoT Core "Create a rule" page screenshot with "Name" and "Description" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/rule-ingestion/rule-define-name-description-console.png)

1. Enter the following rule query statement\.

   ```
   SELECT
     *
   FROM
     '$aws/things/+/shadow/update/accepted'
   WHERE
     startsWith(topic(3), "SiteWiseTutorialDevice")
   ```

   This rule query statement works because the device shadow service publishes shadow updates to `$aws/things/thingName/shadow/update/accepted`\. For more information about device shadows, see [Device shadow service](https://docs.aws.amazon.com/iot/latest/developerguide/iot-device-shadows.html) in the *AWS IoT Developer Guide*\.

   In the `WHERE` clause, this rule query statement uses the `topic(3)` function to get the thing name from the third segment of the topic\. Then, the statement filters out devices that have names that don't match those of the tutorial devices\. For more information about AWS IoT SQL, see [AWS IoT SQL reference](https://docs.aws.amazon.com/iot/latest/developerguide/iot-sql-reference.html) in the *AWS IoT Developer Guide*\.

1. Under **Set one or more actions**, choose **Add action**\.  
![\[AWS IoT Core "Create a rule" page screenshot with "Add action" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/rule-ingestion/rule-add-action-console.png)

1. On the **Select an action** page, choose **Send message data to asset properties in AWS IoT SiteWise** to create an AWS IoT SiteWise rule action\.  
![\[AWS IoT Core "Select an action" page screenshot with the AWS IoT SiteWise action highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/rule-ingestion/rule-choose-sitewise-action-console.png)

1. Choose **Configure action** at the bottom of the page\.

1. On the **Configure action** page, complete the following steps to set up the AWS IoT SiteWise rule action:

   1. Choose **By property alias**\.  
![\[AWS IoT Core "Configure AWS IoT SiteWise action" page screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/rule-ingestion/rule-configure-sitewise-action-console.png)

   1. In **Property alias**, enter **/tutorial/device/$\{topic\(3\)\}/cpu**\.

      The `${...}` syntax is a substitution template\. AWS IoT evaluates the contents within the braces\. This substitution template pulls the thing name from the topic to create an alias unique to each thing\. For more information, see [Substitution templates](https://docs.aws.amazon.com/iot/latest/developerguide/iot-substitution-templates.html) in the *AWS IoT Developer Guide*\.

   1. In **Entry ID**, enter **$\{concat\(topic\(3\), "\-cpu\-", floor\(state\.reported\.timestamp\)\)\}**\.

      Entry IDs uniquely identify each value entry attempt\. If an entry returns an error, you can find the entry ID in the error output to troubleshoot the issue\. The substitution template in this entry ID combines the thing name and the device's reported timestamp\. For example, the resulting entry ID might look like `SiteWiseTutorialDevice1-cpu-1579808494`\.

   1. In **Time in seconds**, enter **$\{floor\(state\.reported\.timestamp\)\}**\.

      This substitution template calculates the time in seconds from the device's reported timestamp\. In this tutorial, devices report timestamp in seconds in Unix epoch time as a floating point number\.

   1. In **Offset in nanos**, enter **$\{floor\(\(state\.reported\.timestamp % 1\) \* 1E9\)\}**\.

      This substitution template calculates the nanosecond offset from the time in seconds by converting the decimal portion of the device's reported timestamp\.
**Note**  
AWS IoT SiteWise requires that your data has a current timestamp in Unix epoch time\. If your devices don't report time accurately, you can get the current time from the AWS IoT rules engine with [timestamp\(\)](https://docs.aws.amazon.com/iot/latest/developerguide/iot-sql-functions.html#iot-function-timestamp)\. This function reports time in milliseconds, so you must update your rule action's time parameters to the following values:  
In **Time in seconds**, enter **$\{floor\(timestamp\(\) / 1E3\)\}**\.
In **Offset in nanos**, enter **$\{\(timestamp\(\) % 1E3\) \* 1E6\}**\.

   1. In **Value**, enter **$\{state\.reported\.cpu\}**\. In substitution templates, you use the `.` operator to retrieve a value from within a JSON structure\.

   1. In **Data type**, choose **Double**\.

      This data type must match the data type of the asset property you defined in the asset model\.

   1. Choose **Add entry** to add a new entry for the memory usage property, and complete the following steps again for that property:

      1. In **Property alias**, enter **/tutorial/device/$\{topic\(3\)\}/memory**\.

      1. In **Entry ID**, enter **$\{concat\(topic\(3\), "\-memory\-", floor\(state\.reported\.timestamp\)\)\}**\.

      1. In **Time in seconds**, enter **$\{floor\(state\.reported\.timestamp\)\}**\.

      1. In **Offset in nanos**, enter **$\{floor\(\(state\.reported\.timestamp % 1\) \* 1E9\)\}**\.

      1. In **Value**, enter **$\{state\.reported\.memory\}**\.

      1. In **Data type**, choose **Double**\.

   1. Under **Root asset name**, choose **Select** to expand the list, then choose your device fleet asset \(**SiteWise Tutorial Device Fleet 1**\)\.

   1. Under **Role**, choose **Create Role** to create an IAM role for this rule action\. This role allows AWS IoT to push data to properties in your device fleet asset and its asset hierarchy\.

   1. Enter a role name and choose **Create role**\.  
![\[AWS IoT Core "Configure AWS IoT SiteWise action" page screenshot with "Create role" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/rule-ingestion/rule-create-role-console.png)

   1. Choose **Add action**\.

1. \(Optional\) Configure an error action that you can use to troubleshoot your rule\. For more information, see [Troubleshooting a rule](#rule-tutorial-troubleshoot-rule)\.

1. Choose **Create rule** at the bottom of the page to finish creating the rule\.

## Running the device client script<a name="rule-tutorial-run-script"></a>

Because you aren't using an actual device to report data, you run a script to update your AWS IoT thing's device shadow with CPU and memory usage to imitate real sensor data\. To run the script, you must first install required Python packages\. In this procedure, you install the required Python packages and then run the device client script\.

**To configure and run the device client script**

1. Navigate to the [AWS IoT console](https://console.aws.amazon.com/iot/)\.

1. At the bottom of the left navigation pane, choose **Settings**\.

1. Save your custom endpoint for use with the device client script\. You use this endpoint to interact with your thing's shadows\. This endpoint is unique to your account in the current Region\.

   Your custom endpoint should look like the following example\.

   ```
   identifier.iot.region.amazonaws.com
   ```

1. Open a command line and run the following command to navigate to the tutorial directory you created earlier\.

   ```
   cd iot-sitewise-rule-tutorial
   ```

1. Run the following command to install the AWS IoT Device SDK for Python\.

   ```
   pip3 install AWSIoTPythonSDK
   ```

   For more information, see [AWS IoT Device SDK for Python](https://docs.aws.amazon.com/iot/latest/developerguide/iot-sdks.html#iot-python-sdk) in the *AWS IoT Developer Guide*

1. Run the following command to install psutil, a cross\-platform process and system utilities library\.

   ```
   pip3 install psutil
   ```

   For more information, see [psutil](https://pypi.org/project/psutil/) in the *Python Package Index*\.

1. Create a file called `thing_performance.py` in the `iot-sitewise-rule-tutorial` directory and then copy the following Python code into the file\.

   ```
   from AWSIoTPythonSDK.MQTTLib import AWSIoTMQTTShadowClient
   
   import json
   import psutil
   import argparse
   import logging
   import time
   
   # Configures the argument parser for this program.
   def configureParser():
       parser = argparse.ArgumentParser()
       parser.add_argument("-e", "--endpoint", action="store", required=True, dest="host",
               help="Your AWS IoT custom endpoint")
       parser.add_argument("-r", "--rootCA", action="store", required=True, dest="rootCAPath", help="Root CA file path")
       parser.add_argument("-c", "--cert", action="store", required=True, dest="certificatePath",
               help="Certificate file path")
       parser.add_argument("-k", "--key", action="store", required=True, dest="privateKeyPath",
               help="Private key file path")
       parser.add_argument("-p", "--port", action="store", dest="port", type=int, default=8883,
               help="Port number override")
       parser.add_argument("-n", "--thingName", action="store", required=True, dest="thingName",
               help="Targeted thing name")
       parser.add_argument("-d", "--requestDelay", action="store", dest="requestDelay", type=float, default=1,
               help="Time between requests (in seconds)")
       parser.add_argument("-v", "--enableLogging", action="store_true", dest="enableLogging",
               help="Enable logging for the AWS IoT Device SDK for Python")
       return parser
   
   
   # An MQTT shadow client that uploads device performance data to AWS IoT at a regular interval.
   class PerformanceShadowClient:
       def __init__(self, thingName, host, port, rootCAPath, privateKeyPath, certificatePath, requestDelay):
           self.thingName = thingName
           self.host = host
           self.port = port
           self.rootCAPath = rootCAPath
           self.privateKeyPath = privateKeyPath
           self.certificatePath = certificatePath
           self.requestDelay = requestDelay
   
       # Updates this thing's shadow with system performance data at a regular interval.
       def run(self):
           print("Connecting MQTT client for {}...".format(self.thingName))
           mqttClient = self.configureMQTTClient()
           mqttClient.connect()
           print("MQTT client for {} connected".format(self.thingName))
           deviceShadowHandler = mqttClient.createShadowHandlerWithName(self.thingName, True)
   
           print("Running performance shadow client for {}...\n".format(self.thingName))
           while True:
               performance = self.readPerformance()
               print("[{}]".format(self.thingName))
               print("CPU:\t{}%".format(performance["cpu"]))
               print("Memory:\t{}%\n".format(performance["memory"]))
               payload = { "state": { "reported": performance } }
               deviceShadowHandler.shadowUpdate(json.dumps(payload), self.shadowUpdateCallback, 5)
               time.sleep(args.requestDelay)
   
       # Configures the MQTT shadow client for this thing.
       def configureMQTTClient(self):
           mqttClient = AWSIoTMQTTShadowClient(self.thingName)
           mqttClient.configureEndpoint(self.host, self.port)
           mqttClient.configureCredentials(self.rootCAPath, self.privateKeyPath, self.certificatePath)
           mqttClient.configureAutoReconnectBackoffTime(1, 32, 20)
           mqttClient.configureConnectDisconnectTimeout(10)
           mqttClient.configureMQTTOperationTimeout(5)
           return mqttClient
   
       # Returns the local device's CPU usage, memory usage, and timestamp.
       def readPerformance(self):
           cpu = psutil.cpu_percent()
           memory = psutil.virtual_memory().percent
           timestamp = time.time()
           return { "cpu": cpu, "memory": memory, "timestamp": timestamp }
       
       # Prints the result of a shadow update call.
       def shadowUpdateCallback(self, payload, responseStatus, token):
           print("[{}]".format(self.thingName))
           print("Update request {} {}\n".format(token, responseStatus))
   
   
   # Configures debug logging for the AWS IoT Device SDK for Python.
   def configureLogging():
       logger = logging.getLogger("AWSIoTPythonSDK.core")
       logger.setLevel(logging.DEBUG)
       streamHandler = logging.StreamHandler()
       formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
       streamHandler.setFormatter(formatter)
       logger.addHandler(streamHandler)
   
   
   # Runs the performance shadow client with user arguments.
   if __name__ == "__main__":
       parser = configureParser()
       args = parser.parse_args()
       if (args.enableLogging):
           configureLogging()
       thingClient = PerformanceShadowClient(args.thingName, args.host, args.port, args.rootCAPath, args.privateKeyPath,
               args.certificatePath, args.requestDelay)
       thingClient.run()
   ```

1. Run `thing_performance.py` from the command line with the following parameters:
   + `-n`, `--thingName` – Your thing name, such as **SiteWiseTutorialDevice1**\.
   + `-e`, `--endpoint` – Your custom AWS IoT endpoint that you saved earlier in this procedure\.
   + `-r`, `--rootCA` – The path to your AWS IoT root CA certificate\.
   + `-c`, `--cert` – The path to your AWS IoT thing certificate\.
   + `-k`, `--key` – The path to your AWS IoT thing certificate private key\.
   + `-d`, `--requestDelay` – \(Optional\) The time in seconds to wait between each device shadow update\. Defaults to 1 second\.
   + `-v`, `--enableLogging` – \(Optional\) If this parameter is present, the script prints debug messages from the AWS IoT Device SDK for Python\.

   Your command should look similar to the following example\.

   ```
   python3 thing_performance.py \
     --thingName SiteWiseTutorialDevice1 \
     --endpoint identifier.iot.region.amazonaws.com \
     --rootCA AmazonRootCA1.pem \
     --cert device1/thing-id-certificate.pem.crt \
     --key device1/thing-id-private.pem.key
   ```

   If you're running the script for additional AWS IoT things, update the thing name and certificate directory accordingly\.

1. Try opening and closing programs on your device to see how the CPU and memory usages change\. The script prints each CPU and memory usage reading\. If the script uploads data to the device shadow service successfully, the script's output should look like the following example\.

   ```
   [SiteWiseTutorialDevice1]
   CPU:    24.6%
   Memory: 85.2%
   
   [SiteWiseTutorialDevice1]
   Update request e6686e44-fca0-44db-aa48-3ca81726f3e3 accepted
   ```

1. Follow these steps to verify that the script is updating the device shadow:

   1. Navigate to the [AWS IoT console](https://console.aws.amazon.com/iot/)\.

   1. In the left navigation pane, choose **Manage** and then choose **Things**\.

   1. Choose your thing, **SiteWiseTutorialDevice1**\.

   1. In the left navigation pane on your thing's page, choose **Shadow**\.

   1. Verify that the **Shadow state** looks like the following example\.

      ```
      {
        "reported": {
          "cpu": 24.6,
          "memory": 85.2,
          "timestamp": 1579567542.2835066
        }
      }
      ```

   1. If your thing's shadow state is empty or doesn't look like the previous example, check that the script is running and successfully connected to AWS IoT\. If the script continues to time out when connecting to AWS IoT, check that your [thing policy](#rule-tutorial-create-iot-policy) is configured according to this tutorial\.

1. Follow these steps to verify that the rule action is sending data to AWS IoT SiteWise:

   1. Navigate to the [AWS IoT SiteWise console](https://console.aws.amazon.com/iotsitewise/)\.

   1. In the left navigation pane, choose **Assets**\.

   1. Choose the arrow next to your device fleet asset \(**SiteWise Tutorial Device Fleet 1**\) to expand its asset hierarchy, and then choose your device asset \(**SiteWise Tutorial Device 1**\)\.

   1. Choose **Measurements**\.

   1. Verify that the **Latest value** cells have values for the **CPU Usage** and **Memory Usage** properties\.  
![\[AWS IoT SiteWise "SiteWise Tutorial Device 1 Asset" page screenshot with "Measurements" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/rule-ingestion/sitewise-view-measurement-values-console.png)

   1. If the **CPU Usage** and **Memory Usage** properties don't have the latest values, refresh the page\. If values don't appear after a few minutes, see [Troubleshooting a rule](#rule-tutorial-troubleshoot-rule)\.

1. You have completed this tutorial\. If you want to explore live visualizations of your data, you can configure a portal in AWS IoT SiteWise Monitor\. For more information, see [Monitoring data with AWS IoT SiteWise Monitor](monitor-data.md)\. Otherwise, you can press **CTRL\+C** in your command prompt to stop the device client script\. It's unlikely the Python program will send enough messages to incur charges, but it's a best practice to stop the program when you're done\.

## Cleaning up resources after the tutorial<a name="rule-tutorial-clean-up-resources"></a>

After you complete the tutorial, clean up your resources to avoid incurring additional charges\.<a name="rule-tutorial-delete-assets"></a>

**To delete hierarchical assets in AWS IoT SiteWise**

1. Navigate to the [AWS IoT SiteWise console](https://console.aws.amazon.com/iotsitewise/)

1. In the left navigation pane, choose **Assets**\.

1. When you delete assets in AWS IoT SiteWise, you must first disassociate them\.

   Complete the following steps to disassociate your device assets from your device fleet asset:

   1. Choose your device fleet asset \( **SiteWise Tutorial Device Fleet 1**\)\.

   1. Choose **Edit**\.

   1. Under **Assets associated to this asset**, choose **Disassociate** for each device asset associated to this device fleet asset\.

   1. Choose **Save asset**\.

      You should now see your device assets no longer organized as a hierarchy\.  
![\[AWS IoT SiteWise flattened device asset hierarchy screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/rule-ingestion/sitewise-delete-device-asset-hierarchy-console.png)

1. Choose your device asset \(**SiteWise Tutorial Device 1**\)\.

1. Choose **Delete**\.

1. In the confirmation dialog, enter **Delete** and then choose **Delete**\.  
![\[AWS IoT SiteWise "Delete asset" dialog screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/rule-ingestion/sitewise-delete-device-asset-console.png)

   When you delete an asset, AWS IoT SiteWise discards all data from that asset's properties\.

1. Repeat steps 4 through 6 for each device asset and the device fleet asset \(**SiteWise Tutorial Device Fleet 1**\)\.

**To delete hierarchical asset models in AWS IoT SiteWise**

1. Navigate to the [AWS IoT SiteWise console](https://console.aws.amazon.com/iotsitewise/)\.

1. If you haven't already, delete your device and device fleet assets\. For more information, see [the previous procedure](#rule-tutorial-delete-assets)\. You can't delete a model if you have assets that were created from that model\.

1. In the left navigation pane, choose **Models**\.

1. Choose your device fleet asset model \(**SiteWise Tutorial Device Fleet Model**\)\.

   When you delete hierarchical asset models, you must delete the parent asset model first\.

1. Choose **Delete**\.

1. In the confirmation dialog, enter **Delete** and then choose **Delete**\.  
![\[AWS IoT SiteWise "Delete model" dialog screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/rule-ingestion/sitewise-delete-device-fleet-model-console.png)

1. Repeat steps 4 through 6 for your device asset model \(**SiteWise Tutorial Device Model**\)\.

**To disable or delete a rule in AWS IoT Core**

1. Navigate to the [AWS IoT console](https://console.aws.amazon.com/iot/)\.

1. In the left navigation pane, choose **Act** and then choose **Rules**\.

1. Choose the menu on your rule and choose **Disable** or **Delete**\.  
![\[AWS IoT Core "Rules" page screenshot with a rule's menu open and highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/rule-ingestion/rule-disable-delete-rule-console.png)

## Troubleshooting a rule<a name="rule-tutorial-troubleshoot-rule"></a>

Follow the steps in this procedure to troubleshoot your rule if the CPU and memory usage data isn't appearing in AWS IoT SiteWise as expected\. In this procedure, you configure the republish rule action as an error action to view error messages in the MQTT test client\. You can also configure logging to CloudWatch Logs to troubleshoot\. For more information, see [Troubleshooting an AWS IoT SiteWise rule action](troubleshoot-rule.md)\.

**To add a republish error action to a rule**

1. Navigate to the [AWS IoT console](https://console.aws.amazon.com/iot/)\.

1. In the left navigation pane, choose **Act** and then choose **Rules**\.

1. Choose the rule that you created earlier\.  
![\[AWS IoT Core "Rules" page screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/rule-ingestion/rule-choose-rule-console.png)

1. Under **Error action**, choose **Add action**\.

1. Choose **Republish a message to an AWS IoT topic**\.  
![\[AWS IoT Core "Select an action" page screenshot with the Republish action highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/rule-ingestion/rule-choose-republish-action-console.png)

1. Choose **Configure action** at the bottom of the page\.

1. In **Topic**, enter **sitewise/rule/tutorial/error**\. AWS IoT Core will republish error messages to this topic\.  
![\[AWS IoT Core "Configure Republish action" page screenshot with the "Topic" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/rule-ingestion/rule-configure-republish-action-console.png)

1. Choose **Select** to grant AWS IoT Core access to perform the error action\.

1. Choose **Select** next to the role that you created earlier \(for example, **SiteWiseTutorialDeviceRuleRole**\)\.  
![\[AWS IoT Core "Configure Republish action" page screenshot with the role select button highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/rule-ingestion/rule-select-role-console.png)

1. Choose **Update Role** to add the additional permissions to the role\.  
![\[AWS IoT Core "Configure Republish action" page screenshot with the update role button highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/rule-ingestion/rule-update-role-console.png)

1. Choose **Add action**\.

1. Choose the back arrow in the upper left of the console to return to the AWS IoT console home\.

After you set up the republish error action, you can view the error messages in the MQTT test client in AWS IoT Core\.

In the following procedure, you subscribe to the error topic in the MQTT test client\.

**To subscribe to the error action topic**

1. Navigate to the [AWS IoT console](https://console.aws.amazon.com/iot/)\.

1. In the left navigation page, choose **Test** to open the MQTT test client\.

1. In the **Subscription topic** field, enter **sitewise/rule/tutorial/error** and choose **Subscribe to topic**\.  
![\[AWS IoT Core "MQTT client" page screenshot with the "Subscribe to topic" button highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/rule-ingestion/rule-subscribe-error-topic-console.png)

1. When error messages appear, view the `failures` array in any error message to diagnose issues\. For more information about possible issues and how to resolve them, see [Troubleshooting an AWS IoT SiteWise rule action](troubleshoot-rule.md)\.

   If errors don't appear, check that your rule is enabled and that you subscribed to the same topic that you configured in the republish error action\. If errors still don't appear after you do that, check that the device script is running and updating the device's shadow successfully\.
**Note**  
You can also subscribe to your device's shadow update topic to view the payload that your AWS IoT SiteWise action parses\. To do so, subscribe to the following topic\.  

   ```
   $aws/things/+/shadow/update/accepted
   ```