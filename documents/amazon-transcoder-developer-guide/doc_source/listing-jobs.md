# Listing Jobs and Viewing Job Settings in Elastic Transcoder<a name="listing-jobs"></a>

You can list the jobs in a specified pipeline or with a specified status either by using the Elastic Transcoder console or by using the applicable API action\. You can also view the settings for an individual job\. The following procedure explains how to list jobs and how to view settings for a job by using the console\.

**Note**  
When you list jobs by pipeline, Elastic Transcoder lists all of the jobs that you've created in the last six months for that pipeline\. When you list jobs by status, Elastic Transcoder lists all of the jobs that you created during the past six months that currently have the specified status\.

For information about how to use the API to:
+ List jobs in a specified pipeline, see [List Jobs by Pipeline](list-jobs-by-pipeline.md)\.
+ List jobs that have a specified status, see [List Jobs by Status](list-jobs-by-status.md)\.
+ Get settings for a specified job, see [Read Job](get-job.md)\.

**Note**  
If you have specified more than one output for your jobs \(for example, one output for the Kindle Fire and another output for the Apple iPhone 4s\), you currently must use the Elastic Transcoder API to list the jobs\.

**To list jobs and view job settings using the Elastic Transcoder console**

1. Sign in to the AWS Management Console and open the Elastic Transcoder console at [https://console\.aws\.amazon\.com/elastictranscoder/](https://console.aws.amazon.com/elastictranscoder/)\.

1. In the navigation bar of the Elastic Transcoder console, select the region in which you want to list jobs\.

1. In the navigation \(left\) pane of the console, click **Jobs**\.

1. On the **Jobs** page, specify the applicable values\. For more information about a field, click the ![\[Icon to display the tooltip for a field.\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/images/i-tooltip-icon.png) icon next to the field\.

1. Click **Search**\.

1. To display detailed information about a job that is listed in the search results, click the ![\[Arrow to display the settings for a job.\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/images/magnifying-glass-icon.png) icon next to the job\.