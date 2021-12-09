# Overriding Default Recipe Parameters<a name="customizing-solution-config"></a>

A solution is created by calling the [CreateSolution](API_CreateSolution.md) API\. A condensed version of the `CreateSolution` request is shown, highlighting the `solutionConfig` object\. You use `solutionConfig` to override the default parameters of a recipe\. When `performAutoML` is `true`, all parameters of the `solutionConfig` object are ignored except for `autoMLConfig`\. The sub\-objects of `solutionConfig` are discussed in the following sections\.

```
{
    "name": "string",
    "performAutoML": boolean,
    "recipeArn": "string",
    "performHPO": boolean,
    "eventType": "string",
    "solutionConfig": {
        "autoMLConfig": {
            "metricName": "string",
            "recipeList": [ "string" ]
        },
        "eventValueThreshold": "string",
        "featureTransformationParameters": {
            "string" : "string"
        },
        "algorithmHyperParameters": {
            "string" : "string"
        },
        "hpoConfig": {
            "algorithmHyperParameterRanges": {
                ...
            },
            "hpoResourceConfig": {
                "maxNumberOfTrainingJobs": "string",
                "maxParallelTrainingJobs": "string"
            }
        },
    },
}
```

**Topics**
+ [Hyperparameters and HPO](customizing-solution-config-hpo.md)