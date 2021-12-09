# Run/Debug Configurations dialog box<a name="run-debug-configurations-dialog"></a>

The **Run/Debug Configurations** dialog box in the AWS Toolkit for JetBrains is displayed whenever you [change \(update\) the configuration for an AWS Lambda function](key-tasks.md#key-tasks-lambda-update)\.

This dialog box contains different configuration settings for the Lambda function, depending on whether you are changing \(updating\) settings for the *local* version of the function \(the function's source code is on the local computer\) or the *remote* version of that same function \(the function's source code is within the Lambda service for the account\)\.

**Topics**
+ [Run/Debug Configurations dialog box \(local function settings\)](#run-debug-configurations-dialog-local)
+ [Run/Debug Configurations dialog box \(remote function settings\)](#run-debug-configurations-dialog-remote)

## Run/Debug Configurations dialog box \(local function settings\)<a name="run-debug-configurations-dialog-local"></a>

This dialog box is displayed whenever you change \(update\) settings for the *local* version of an AWS Lambda function \(the function's source code is on the local computer\)\.

**Note**  
To change \(update\) settings for the *remote* version of that same function \(the function's source code is within the Lambda service for the account\), see [Run/Debug Configurations dialog box \(remote function settings\)](#run-debug-configurations-dialog-remote) instead\.

This dialog box contains two tabs: **Configuration** and **SAM CLI**\.

![\[Configuration tab of the Run/Debug Configurations dialog box for local function settings\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

The **Configuration** tab of the **Run/Debug Configurations** dialog box for local function settings contains the following items\.

**Name**  
*Required*\. The name of this configuration\.

**Share / Share through VCS**  
*Optional*\. If selected, makes this configuration available to other team members\. 1

**Allow parallel run / Allow running in parallel **  
*Optional*\. If selected, allows IntelliJ IDEA, PyCharm, WebStorm, or JetBrains Rider to launch as many instances of the configuration to run in parallel as needed\. 1

**From template**  
*Required*\. The location and file name of the AWS Serverless Application Model \(AWS SAM\) template \(for example, `template.yaml`\) to use for this configuration, and the resource in that template to associate with this configuration\.

**Runtime**  
*Required*\. The identifier of the [runtime](https://docs.aws.amazon.com/lambda/latest/dg/lambda-runtimes.html) for Lambda to use\.

**Handler**  
*Required*\. The identifier of the corresponding function handler for [Java](https://docs.aws.amazon.com/lambda/latest/dg/java-programming-model-handler-types.html), [Python](https://docs.aws.amazon.com/lambda/latest/dg/python-programming-model-handler-types.html), [Node\.js](https://docs.aws.amazon.com/lambda/latest/dg/nodejs-prog-model-handler.html), or [Node\.js](https://docs.aws.amazon.com/lambda/latest/dg/nodejs-prog-model-handler.html)\.

**Environment Variables**  
*Optional*\. Any [environment variables](https://docs.aws.amazon.com/lambda/latest/dg/env_variables.html) for the AWS Lambda function to use, specified as key\-value pairs\. To add, change, or delete environment variables, choose the folder icon, and then follow the on\-screen instructions\.

**Credentials**  
*Required*\. The name of the existing [AWS account connection](key-tasks.md#key-tasks-connections) to use\.

**Region**  
*Required*\. The name of the [AWS Region](key-tasks.md#key-tasks-switch-region) to use for the connected account\.

**File**  
Either **File** or **Text** is *required* \(but not both\)\. The location and file name of the event data to pass into the function, expressed in JSON format\. For event data examples, see [Invoke the Lambda Function](https://docs.aws.amazon.com/lambda/latest/dg/getting-started-create-function.html#get-started-invoke-manually) in the *AWS Lambda Developer Guide* and [Generating Sample Event Payloads](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/serverless-sam-cli-using-generate-event.html) in the *AWS Serverless Application Model Developer Guide*\.

**Text**  
Either **File** or **Text** is *required* \(but not both\)\. The event data to pass into the function, expression in JSON format\. For event data examples, see [Invoke the Lambda Function](https://docs.aws.amazon.com/lambda/latest/dg/getting-started-create-function.html#get-started-invoke-manually) in the *AWS Lambda Developer Guide* and [Generating Sample Event Payloads](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/serverless-sam-cli-using-generate-event.html) in the *AWS Serverless Application Model Developer Guide*\.

**Before launch: Activate tool window**  
*Optional*\. Lists any tasks that must be performed before starting this configuration\. 2

**Show this page**  
*Optional*\. If selected, displays these configuration settings before starting this configuration\. 2

**Activate tool window**  
*Optional*\. If selected, opens the **Run** or the **Debug** tool window when you start this configuration\. 2 

***Notes***  
1 For more information, see the following:  
+ For IntelliJ IDEA, see [Common options](https://www.jetbrains.com/help/idea/run-debug-configurations-dialog.html#common) on the IntelliJ IDEA Help website\. 
+ For PyCharm, see [Common options](https://www.jetbrains.com/help/pycharm/run-debug-configurations-dialog.html#common) on the PyCharm Help website\.
+ For WebStorm, see [Common options](https://www.jetbrains.com/help/webstorm/run-debug-configuration-node-js.html#common) on the WebStorm Help website\.
+ For JetBrains Rider, see [Common options](https://www.jetbrains.com/help/rider/Run_Debug_Configurations_dialog.html#common) on the JetBrains Rider Help website\.
2 For more information, see the following:  
+ For IntelliJ IDEA, see [Before Launch options](https://www.jetbrains.com/help/idea/run-debug-configurations-dialog.html#before-launch-options) on the IntelliJ IDEA Help website\. 
+ For PyCharm, see [Before Launch options](https://www.jetbrains.com/help/pycharm/run-debug-configurations-dialog.html#before-launch-options) on the PyCharm Help website\.
+ For WebStorm, see [Before Launch options](https://www.jetbrains.com/help/webstorm/run-debug-configuration-node-js.html#before-launch-options) on the WebStorm; Help website\.
+ For JetBrains Rider, see [Before Launch options](https://www.jetbrains.com/help/rider/Run_Debug_Configurations_dialog.html#before-launch-options) on the JetBrains Rider Help website\.

![\[SAM CLI tab of the Run/Debug Configurations dialog box for local function settings\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

The **SAM CLI** tab of the **Run/Debug Configurations** dialog box for local function settings contains the following items\.

**Name**  
*Required*\. The name of this configuration\.

**Share / Share through VCS**  
*Optional*\. If selected, makes this configuration available to other team members\. 1

**Allow parallel run / Allow running in parallel **  
*Optional*\. If selected, allows IntelliJ IDEA, PyCharm, WebStorm, or JetBrains Rider to launch as many instances of the configuration to run in parallel as needed\. 1

**Build function inside a container**  
*Optional*\. If selected, the AWS SAM CLI builds any of the serverless application's functions inside of an AWS Lambda\-like Docker container locally before deployment\. This is useful if the function depends on packages that have natively compiled dependencies or programs\. For more information, see [Building Applications with Dependencies](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/serverless-sam-cli-using-build.html) in the *AWS Serverless Application Model Developer Guide*\.

**Skip checking for newer container images**  
*Optional*\. If selected, the AWS SAM CLI skips pulling down the latest Docker image for the [runtime](https://docs.aws.amazon.com/lambda/latest/dg/lambda-runtimes.html) that is specified on the **Configuration** tab\.

**Docker Network**  
*Optional*\. The name or ID of an existing Docker network that Lambda Docker containers should connect to, with the default bridge network\. If not specified, the Lambda containers connect only to the default bridge Docker network\.

**Before launch: Activate tool window**  
*Optional*\. Lists any tasks that must be performed before starting this configuration\. 2

**Show this page**  
*Optional*\. If selected, displays these configuration settings prior to starting this configuration\. 2

**Activate tool window**  
*Optional*\. If selected, opens the **Run** or the **Debug** tool window when you start this configuration\. 2 

***Notes***  
1 For more information, see the following:  
+ For IntelliJ IDEA, see [Common options](https://www.jetbrains.com/help/idea/run-debug-configurations-dialog.html#common) on the IntelliJ IDEA Help website\. 
+ For PyCharm, see [Common options](https://www.jetbrains.com/help/pycharm/run-debug-configurations-dialog.html#common) on the PyCharm Help website\.
+ For WebStorm, see [Common options](https://www.jetbrains.com/help/webstorm/run-debug-configuration-node-js.html#common) on the WebStorm Help website\.
+ For JetBrains Rider, see [Common options](https://www.jetbrains.com/help/rider/Run_Debug_Configurations_dialog.html#common) on the JetBrains Rider Help website\.
2 For more information, see the following:  
+ For IntelliJ IDEA, see [Before Launch options](https://www.jetbrains.com/help/idea/run-debug-configurations-dialog.html#before-launch-options) on the IntelliJ IDEA Help website\. 
+ For PyCharm, see [Before Launch options](https://www.jetbrains.com/help/pycharm/run-debug-configurations-dialog.html#before-launch-options) on the PyCharm Help website\.
+ For WebStorm, see [Before Launch options](https://www.jetbrains.com/help/webstorm/run-debug-configuration-node-js.html#before-launch-options) on the WebStorm; Help website\.
+ For JetBrains Rider, see [Before Launch options](https://www.jetbrains.com/help/rider/Run_Debug_Configurations_dialog.html#before-launch-options) on the JetBrains Rider Help website\.

## Run/Debug Configurations dialog box \(remote function settings\)<a name="run-debug-configurations-dialog-remote"></a>

This dialog box displays whenever you change \(update\) settings for the *remote* version of an AWS Lambda function \(the function's source code is within the Lambda service for the account\)\.

**Note**  
To change \(update\) settings for the *local* version of that same function \(the function's source code is on the local computer\), see [Run/Debug Configurations dialog box \(local function settings\)](#run-debug-configurations-dialog-local) instead\.  
Although the name of the dialog box is **Run/Debug Configurations**, you cannot use the AWS Toolkit to debug the remote version of a Lambda function\. You can only run it\.

![\[The Run/Debug Configurations dialog box for remote function settings\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

The **Run/Debug Configurations** dialog box for remote function settings contains the following items\.

**Name**  
*Required*\. The name of this configuration\.

**Share / Share through VCS**  
*Optional*\. If selected, makes this configuration available to other team members\. 1

**Allow parallel run / Allow running in parallel **  
*Optional*\. If selected, allows IntelliJ IDEA, PyCharm, WebStorm, or JetBrains Rider to launch as many instances of the configuration to run in parallel as needed\. 1

**Credentials**  
*Required*\. The name of the existing [AWS account connection](key-tasks.md#key-tasks-connections) to use\.

**Region**  
*Required*\. The name of the [AWS Region](key-tasks.md#key-tasks-switch-region) to use for the connected account\.

**Function**  
*Required*\. The name of the AWS Lambda function to use\.

**File**  
Either **File** or **Text** is *required* \(but not both\)\. The location and file name of the event data to pass into the function, expressed in JSON format\. For event data examples, see [Invoke the Lambda Function](https://docs.aws.amazon.com/lambda/latest/dg/getting-started-create-function.html#get-started-invoke-manually) in the *AWS Lambda Developer Guide* and [Generating Sample Event Payloads](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/serverless-sam-cli-using-generate-event.html) in the *AWS Serverless Application Model Developer Guide*\.

**Text**  
Either **File** or **Text** is *required* \(but not both\)\. The event data to pass into the function, expression in JSON format\. For event data examples, see [Invoke the Lambda Function](https://docs.aws.amazon.com/lambda/latest/dg/getting-started-create-function.html#get-started-invoke-manually) in the *AWS Lambda Developer Guide* and [Generating Sample Event Payloads](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/serverless-sam-cli-using-generate-event.html) in the *AWS Serverless Application Model Developer Guide*\.

**Before launch: Activate tool window**  
*Optional*\. Lists any tasks that must be performed before starting this configuration\. 2

**Show this page**  
*Optional*\. If selected, displays these configuration settings prior to starting this configuration\. 2

**Activate tool window**  
*Optional*\. If selected, opens the **Run** or the **Debug** tool window when you start this configuration\. 2

***Notes***  
1 For more information, see the following:  
+ For IntelliJ IDEA, see [Common options](https://www.jetbrains.com/help/idea/run-debug-configurations-dialog.html#common) on the IntelliJ IDEA Help website\. 
+ For PyCharm, see [Common options](https://www.jetbrains.com/help/pycharm/run-debug-configurations-dialog.html#common) on the PyCharm Help website\.
+ For WebStorm, see [Common options](https://www.jetbrains.com/help/webstorm/run-debug-configuration-node-js.html#common) on the WebStorm Help website\.
+ For JetBrains Rider, see [Common options](https://www.jetbrains.com/help/rider/Run_Debug_Configurations_dialog.html#common) on the JetBrains Rider Help website\.
2 For more information, see the following:  
+ For IntelliJ IDEA, see [Before Launch options](https://www.jetbrains.com/help/idea/run-debug-configurations-dialog.html#before-launch-options) on the IntelliJ IDEA Help website\. 
+ For PyCharm, see [Before Launch options](https://www.jetbrains.com/help/pycharm/run-debug-configurations-dialog.html#before-launch-options) on the PyCharm Help website\.
+ For WebStorm, see [Before Launch options](https://www.jetbrains.com/help/webstorm/run-debug-configuration-node-js.html#before-launch-options) on the WebStorm; Help website\.
+ For JetBrains Rider, see [Before Launch options](https://www.jetbrains.com/help/rider/Run_Debug_Configurations_dialog.html#before-launch-options) on the JetBrains Rider Help website\.