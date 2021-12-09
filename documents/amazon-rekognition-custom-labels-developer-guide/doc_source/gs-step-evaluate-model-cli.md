# Step 5: Evaluate Your Model<a name="gs-step-evaluate-model-cli"></a>

To evaluate a model, you call [DescribeProjectVersions](https://docs.aws.amazon.com/rekognition/latest/dg/API_DescribeProjectVersions) to get the training results\. The training results include metrics that aren't available in the console, such as a confusion matrix for classification results\. The training results are returned in the following formats: 
+ F1 score – A single value representing the overall performance of precision and recall for the model\. For more information, see [Overall Model Performance](tr-metrics-use.md#tr-f1-metric)\.
+ Summary file location – The training summary includes aggregated evaluation metrics for the entire testing dataset and metrics for each individual label\. `DescribeProjectVersions` returns the Amazon S3 bucket and folder location of the summary file\. For more information, see [Summary File](tr-summary-file-api.md)\.
+ Evaluation manifest snapshot location – The snapshot contains detailed information about the test results including the confidence ratings and the results of classification tests, such as false positives\. `DescribeProjectVersions` returns the Amazon S3 bucket and folder location of the snapshot files\. For more information, see [Evaluation Manifest Snapshot](tr-evaluation-manifest-snapshot-api.md)\. 

In this step, you use the `DescribeProjectVersions` API to get the location of the summary file and the evaluation manifest snapshot\. Use the information to evaluate the performance of your model\. For more information, see [Evaluating a Trained Amazon Rekognition Custom Labels Model](tr-train-results.md)\. If you need to improve the performance of your model, see [Improving an Amazon Rekognition Custom Labels Model](tr-improve-model.md)\. 

**To access training results \(SDK\)**
+ At the command prompt, enter the following command\. Replace `project_arn` with the Amazon Resource Name \(ARN\) of the project you created in [Step 2: Create a Project](gs-step-create-project-cli.md)\. Replace `version_name` with the version name you used in [Step 4: Train Your Model](gs-step-train-model-cli.md)\.

  ```
  aws rekognition describe-project-versions --project-arn "project_arn"\
       --version-names "version_name"
  ```

The training results F1 score and summary information are in `EvaluationResult`\. For example:

```
"EvaluationResult": {
                "F1Score": 0.39382708072662354,
                "Summary": {
                    "S3Object": {
                        "Bucket": "my bucket",
                        "Name": "output/EvaluationResultSummary.json"
                    }
                }
            }
```

The evaluation manifest snapshot is stored in the location specified in the ` --output-config` input parameter that you specified in [Step 4: Train Your Model](gs-step-train-model-cli.md)\. 