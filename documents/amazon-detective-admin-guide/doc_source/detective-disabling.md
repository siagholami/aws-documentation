# Disabling Amazon Detective<a name="detective-disabling"></a>

The master account for a behavior graph can disable Amazon Detective from the Detective console, the Detective API, or AWS Command Line Interface\. When you disable Detective, the behavior graph and its associated Detective data are deleted\.

Once a behavior graph is deleted, it cannot be restored\.

**Topics**
+ [Disabling Detective \(Console\)](#disable-from-console)
+ [Disabling Detective \(Detective API, AWS CLI\)](#disable-from-api)
+ [Disabling Detective across Regions \(Python script on GitHub\)](#disable-from-github-script)

## Disabling Detective \(Console\)<a name="disable-from-console"></a>

You can disable Amazon Detective from the AWS Management Console\.

**To disable Detective \(console\)**

1. Open the [Detective console](https://console.aws.amazon.com/detective/)\.

1. In the Detective navigation pane, under **Settings**, choose **General**\.

1. On the **General** page, under **Disable Detective**, choose **Disable Detective**\.

1. When prompted to confirm, type **disable**\.

1. Choose **Disable Detective**\.

## Disabling Detective \(Detective API, AWS CLI\)<a name="disable-from-api"></a>

You can disable Amazon Detective from the Detective API or the AWS Command Line Interface\.

**To disable Detective \(Detective API, AWS CLI\)**
+ **Detective API:** Use the [https://docs.aws.amazon.com/detective/latest/APIReference/API_DeleteGraph.html](https://docs.aws.amazon.com/detective/latest/APIReference/API_DeleteGraph.html) operation\. You must provide the graph ARN\.
+ **AWS CLI:** At the command line, run the `delete-graph` command\.

  ```
  aws detective delete-graph --graph-arn <graph ARN>
  ```

  Example:

  ```
  aws detective delete-graph --graph-arn arn:aws:detective:us-east-1:111122223333:graph:123412341234
  ```

## Disabling Detective across Regions \(Python script on GitHub\)<a name="disable-from-github-script"></a>

Detective provides an open\-source script in GitHub that allows you to disable Detective for a master account across a specified list of Regions\.

For information on how to configure and use the GitHub scripts, see [Using the Amazon Detective Python scripts](detective-github-scripts.md)\.