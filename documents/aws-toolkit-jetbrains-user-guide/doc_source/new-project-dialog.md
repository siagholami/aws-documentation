# New Project dialog box<a name="new-project-dialog"></a>

The **New Project** dialog box in the AWS Toolkit for JetBrains is displayed when you [create an AWS serverless application](key-tasks.md#key-tasks-sam-create)\.

**Topics**
+ [New Project dialog box \(IntelliJ IDEA\)](#new-project-dialog-intellij)
+ [New Project dialog box \(PyCharm\)](#new-project-dialog-pycharm)
+ [New Project dialog box \(WebStorm\)](#new-project-dialog-webstorm)
+ [New Project dialog box \(JetBrains Rider\)](#new-project-dialog-rider)

## New Project dialog box \(IntelliJ IDEA\)<a name="new-project-dialog-intellij"></a>

![\[The New Project dialog box for IntelliJ IDEA\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

The **New Project** dialog box contains the following items\.

**Project name**  
*Required*\. The name of the project\.

**Project location**  
*Required*\. The location where IntelliJ IDEA will create the project\.

**Runtime**  
*Required*\. The identifier of the [runtime](https://docs.aws.amazon.com/lambda/latest/dg/lambda-runtimes.html) for AWS Lambda to use\.

**SAM Template**  
*Required*\. The name of the AWS Serverless Application Model \(AWS SAM\) template to use\.

**Project SDK**  
*Required*\. The Java SDK \(JDK\) to use\. For more information, see [Configure the JDK when creating a project](https://www.jetbrains.com/help/idea/creating-and-managing-projects.html#configure-jdk) on the IntelliJ IDEA Help website\.

**Module name**  
*Required*\. The name of the module to create\. For more information, see [Modules](https://www.jetbrains.com/help/idea/creating-and-managing-modules.html#Creating_and_Managing_Modules.xml) on the IntelliJ IDEA Help website\.

**Content root**  
*Required*\. The location where IntelliJ IDEA will create the project's content root\. For more information, see [Content roots](https://www.jetbrains.com/help/idea/content-roots.html#Content_roots.xml) on the IntelliJ IDEA Help website\.

**Module file location**  
*Required*\. The location where IntelliJ IDEA will create the module\. For more information, see [Modules](https://www.jetbrains.com/help/idea/creating-and-managing-modules.html#Creating_and_Managing_Modules.xml) on the IntelliJ IDEA Help website\.

**Project format**  
*Required*\. The format of the project that IntelliJ IDEA will create\. For more information, see [Project formats](https://www.jetbrains.com/help/idea/creating-and-managing-projects.html#project-formats) on the IntelliJ IDEA Help website\.

## New Project dialog box \(PyCharm\)<a name="new-project-dialog-pycharm"></a>

![\[The New Project dialog box for PyCharm\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

The **New Project** dialog box contains the following items\.

**Location**  
*Required*\. The location where PyCharm will create the project\. For more information, see [Project](https://www.jetbrains.com/help/pycharm/project.html) on the PyCharm Help website\.

**SAM Template**  
*Required*\. The name of the AWS Serverless Application Model \(AWS SAM\) template to use\.

**New environment using / Existing interpreter**  
Either **New environment using** or **Existing interpreter** is *required* \(but not both\)\. Provides information about the interpreter that PyCharm will use when creating the project\. For more information, see [Configure a Python interpreter](https://www.jetbrains.com/help/pycharm/configuring-python-interpreter.html#Configuring__language__Interpreter.xml) on the PyCharm Help website\.

## New Project dialog box \(WebStorm\)<a name="new-project-dialog-webstorm"></a>

![\[The New Project dialog box for WebStorm\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

The **New Project** dialog box contains the following items\.

**Location**  
*Required*\. The location where WebStorm will create the project\.

**Runtime**  
*Required*\. The identifier of the [runtime](https://docs.aws.amazon.com/lambda/latest/dg/lambda-runtimes.html) for AWS Lambda to use\.

**SAM Template**  
*Required*\. The name of the AWS SAM template to use\.

**Node interpreter**  
*Required*\. The location where the Node\.js interpreter is installed\.

## New Project dialog box \(JetBrains Rider\)<a name="new-project-dialog-rider"></a>

**Note**  
When you create a new solution, this dialog box will contain the title **New Solution** instead of **New Project**\. However, the dialog box's contents are the same\.

![\[The New Project dialog box for JetBrains Rider\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

The **New Project** dialog box contains the following items\.

**Solution name**  
*Required*\. The name of the solution\.

**Project name**  
*Required*\. The name of the project\.

**Solution directory**  
*Required*\. The path to the solution's directory\.

**Put solution and project in the same directory**  
*Optional*\. If selected, puts the solution's files in the same location as the project's files\.

**Create repository**  
*Optional*\. If selected, creates a remote repository for the project with the specified provider\.

**Runtime**  
*Required*\. The Lambda runtime to be used\.

**SAM CLI executable**  
*Required*\. The location where the SAM CLI is installed\.

**SAM Template**  
*Required*\. The name of the SAM template to use to create the project\.

**Resulting project structure**  
*Required*\. The paths for the project's directories and files that will be created\.