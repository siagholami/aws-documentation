# RunPipelineActivity<a name="run-pipeline-activity"></a>

Here is an example of how you would use the `RunPipelineActivity` command to test a pipeline activity\. For this example we test a math activity\.

1. Create a `maths.json` file, which contains the definition of the pipeline activity you want to test\.

   ```
   {
       "math": {
           "name": "MyMathActivity",
           "math": "((temp - 32) * 5.0) / 9.0",
           "attribute": "tempC"
       }
   }
   ```

1. Create a file `payloads.json` file, which contains the example payloads that are used to test the pipeline activity\.

   ```
   [
       "{\"humidity\": 52, \"temp\": 68 }",
       "{\"humidity\": 52, \"temp\": 32 }"
   ]
   ```

1. Call the `RunPipelineActivities` operation from the command line\.

   ```
   aws iotanalytics run-pipeline-activity  --pipeline-activity file://maths.json  --payloads file://payloads.json
   ```

   This produces the following results\.

   ```
   {
       "logResult": "",
       "payloads": [
           "eyJodW1pZGl0eSI6NTIsInRlbXAiOjY4LCJ0ZW1wQyI6MjB9",
           "eyJodW1pZGl0eSI6NTIsInRlbXAiOjMyLCJ0ZW1wQyI6MH0="
       ]
   }
   ```

   The payloads listed in the results are Base64\-encoded strings\. When these strings are decoded, you get the following results\.

   ```
   {"humidity":52,"temp":68,"tempC":20}
   {"humidity":52,"temp":32,"tempC":0}
   ```