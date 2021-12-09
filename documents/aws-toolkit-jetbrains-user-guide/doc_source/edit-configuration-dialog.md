# Edit Configuration dialog box<a name="edit-configuration-dialog"></a>

The **Edit configuration** dialog box in the AWS Toolkit for JetBrains is displayed when you [change \(update\) the configuration for an AWS Lambda function](key-tasks.md#key-tasks-lambda-update) or [debug code in an Amazon ECS cluster](key-tasks.md#key-tasks-ecs-debug)\.
+ [Edit Configuration Dialog Box \(Lambda Function\)](#edit-configuration-dialog-lambda)
+ [Edit Configuration Dialog Box \(Amazon ECS Cluster\)](#edit-configuration-dialog-ecs)

## Edit Configuration dialog box \(Lambda function\)<a name="edit-configuration-dialog-lambda"></a>

The **Edit configuration** dialog box contains two tabs: **Configuration** and **SAM CLI**\.

![\[Configuration tab of the Edit configuration dialog box\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

The **Configuration** tab of the **Edit configuration** dialog box contains the following items\.

**Name**  
*Required*\. The name of this configuration\.

**Share / Share through VCS **  
*Optional*\. If selected, makes this configuration available to other team members\. 1

**Allow parallel run / Allow running in parallel **  
*Optional*\. If selected, allows IntelliJ IDEA, PyCharm, WebStorm, or JetBrains Rider to launch as many instances of the configuration to run in parallel as needed\. 1

**From template**  
*Required*\. The location and file name of the AWS Serverless Application Model \(AWS SAM\) template \(for example, `template.yaml`\) to use for this configuration, and the resource in that template to associate with this configuration\.

**Runtime**  
*Required*\. The identifier of the [runtime](https://docs.aws.amazon.com/lambda/latest/dg/lambda-runtimes.html) for Lambda to use\.

**Handler**  
*Required*\. The identifier of the corresponding function handler for [Java](https://docs.aws.amazon.com/lambda/latest/dg/java-programming-model-handler-types.html), [Python](https://docs.aws.amazon.com/lambda/latest/dg/python-programming-model-handler-types.html), or [Node\.js](https://docs.aws.amazon.com/lambda/latest/dg/nodejs-prog-model-handler.html)\.

**Environment Variables**  
*Optional*\. Any [environment variables](https://docs.aws.amazon.com/lambda/latest/dg/env_variables.html) for the Lambda function to use, specified as key\-value pairs\. To add, change, or delete environment variables, choose the folder icon, and then follow the on\-screen instructions\.

**Credentials**  
*Required*\. The name of the existing [AWS account connection](key-tasks.md#key-tasks-connections) to use\.

**Region**  
*Required*\. The name of the [AWS Region](key-tasks.md#key-tasks-switch-region) to use for the connected account\.

**File**  
Either **File** or **Text** is *required* \(but not both\)\. The location and file name of the event data to pass into the function, expressed in JSON format\. For event data examples, see [Invoke the Lambda Function](https://docs.aws.amazon.com/lambda/latest/dg/getting-started-create-function.html#get-started-invoke-manually) in the *AWS Lambda Developer Guide* and [Generating Sample Event Payloads](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/serverless-sam-cli-using-generate-event.html) in the *AWS Serverless Application Model Developer Guide*\.

**Text**  
Either **File** or **Text** is *required* \(but not both\)\. The event data to pass into the function, expression in JSON format\. For event data examples, see [Invoke the Lambda Function](https://docs.aws.amazon.com/lambda/latest/dg/getting-started-create-function.html#get-started-invoke-manually) in the *AWS Lambda Developer Guide*, and [Generating Sample Event Payloads](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/serverless-sam-cli-using-generate-event.html) in the *AWS Serverless Application Model Developer Guide*\.

**Before launch: Activate tool window**  
*Optional*\. Lists any tasks that must be performed before starting this configuration\. 2

**Show this page**  
*Optional*\. If selected, displays these configuration settings before starting this configuration\. 2

**Activate tool window**  
*Optional*\. If selected, opens the **Run** or **Debug** tool window when you start this configuration\. 2

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

![\[SAM CLI tab of the Edit configuration dialog box\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

The **SAM CLI** tab of the **Edit configuration** dialog box contains the following items\.

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
*Optional*\. The name or ID of an existing Docker network that Lambda Docker containers should connect to, and the default bridge network\. If not specified, the Lambda containers will connect to only the default bridge Docker network\.

**Before launch: Activate tool window**  
*Optional*\. Lists any tasks that must be performed before starting this configuration\. 2

**Show this page**  
*Optional*\. If selected, displays these configuration settings before starting this configuration\. 2

**Activate tool window**  
*Optional*\. If selected, opens the **Run** or **Debug** tool window when you start this configuration\. 2

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

## Edit Configuration dialog box \(Amazon ECS cluster\)<a name="edit-configuration-dialog-ecs"></a>

The **Edit configuration** dialog box contains two tabs: **Configuration** and **AWS Connection**\.

![\[Configuration tab of the Edit configuration dialog box\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

The **Configuration** tab of the **Edit configuration** dialog box contains the following items\.

**Name**  
*Required*\. The name of this configuration\.

**Share / Share through VCS**  
*Optional*\. If selected, makes this configuration available to other team members\. 1

**Allow parallel run / Allow running in parallel **  
*Optional*\. If selected, allows IntelliJ IDEA, PyCharm, WebStorm, or JetBrains Rider to launch as many instances of the configuration to run in parallel as needed\. 1

**Cluster**  
*Required*\. The name of the Amazon ECS cluster to debug\.

**Service**  
*Required*\. The name of the Amazon ECS service in the cluster to debug\.

**Add Container**  
Adds a container to this configuration\. *Optional* if at least one tab is already visible\. Each tab represents a separate container\.  
The following items apply to the selected container: **Platform**, **Remote Debug Port**, **Start Command**, **Artifacts Mappings**, and **Port Mappings**\. 

**Platform**  
*Required*\. The debug platform to use\.

**Remote Debug Port**  
*Optional*\. The port to attach to the debugger\.Generally, you should not specify this unless your service uses ports 20020\-20030\. If it does, specify that port here, so that the container doesn’t try to bind ports that might otherwise be in use elsewhere\.

**Start Command**  
*Required*\. The command to start your program so that the debugger can attach to it\. For Java, it should start with `java` and contain no debugger information \(such as `-Xdebug`\)\. For Python, it must start with `python`, `python2`, or `python3`, followed by the path and name of the file to run\.

**Artifacts Mappings**  
*Required*\. A **Local Path** on your local development machine that maps to a **Remote Path** within the container\. All code and artifacts that are to be run must be mapped\. To specify a local and remote path mapping, choose **Add** \(the **\+** icon\)\.

**Port Mappings**  
*Optional*\. A **Local Port** on your local development machine that maps to a **Remote Port** within the container\. This allows local ports to communicate directly with ports on a remote resource\. For example, for the command `curl localhost:3422`, port `3422` maps to some service\. To specify a local and remote port mapping, choose **Add** \(the **\+** icon\)\.

**Before launch: Activate tool window**  
*Optional*\. Lists any tasks that must be performed before starting this configuration\. 2

**Show this page**  
*Optional*\. If selected, displays these configuration settings before starting this configuration\. 2

**Activate tool window**  
*Optional*\. If selected, opens the **Run** or **Debug** tool window when you start this configuration\. 2

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

![\[AWS Connection tab of the Edit configuration dialog box\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

The **AWS Connection** tab of the **Edit configuration** dialog box contains the following items\.

**Name**  
*Required*\. The name of this configuration\.

**Credentials**  
*Required*\. The name of the existing [AWS account connection](key-tasks.md#key-tasks-connections) to use\.

**Region**  
*Required*\. The name of the [AWS Region](key-tasks.md#key-tasks-switch-region) to use for the connected account\.

**Share / Share through VCS**  
*Optional*\. If selected, makes this configuration available to other team members\. 1

**Allow parallel run / Allow running in parallel **  
*Optional*\. If selected, allows IntelliJ IDEA, PyCharm, WebStorm, or JetBrains Rider to launch as many instances of the configuration to run in parallel as needed\. 1

**Before launch: Activate tool window**  
*Optional*\. Lists any tasks that must be performed before starting this configuration\. 2

**Show this page**  
*Optional*\. If selected, displays these configuration settings before starting this configuration\. 2

**Activate tool window**  
*Optional*\. If selected, opens the **Run** or **Debug** tool window when you start this configuration\. 2

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