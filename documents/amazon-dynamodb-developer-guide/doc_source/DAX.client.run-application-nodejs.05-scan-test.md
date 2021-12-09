# 05\-scan\-test\.js<a name="DAX.client.run-application-nodejs.05-scan-test"></a>

The `05-scan-test.js` program performs `Scan` operations on `TryDaxTable`\.

```
/**
 * Copyright 2010-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * This file is licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License. A copy of
 * the License is located at
 *
 * http://aws.amazon.com/apache2.0/
 *
 * This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
*/
const AmazonDaxClient = require('amazon-dax-client');
var AWS = require("aws-sdk");

var region = "us-west-2";

AWS.config.update({
  region: region
});

var ddbClient = new AWS.DynamoDB.DocumentClient()
var daxClient = null;

if (process.argv.length > 2) {
    var dax = new AmazonDaxClient({endpoints: [process.argv[2]], region: region})
    daxClient = new AWS.DynamoDB.DocumentClient({service: dax });
}

var client = daxClient != null ? daxClient : ddbClient;
var tableName = "TryDaxTable";

var iterations = 5;

var params = {
    TableName: tableName
};
var startTime = new Date().getTime();
for (var i = 0; i < iterations; i++) {

    client.scan(params, function(err, data) {
        if (err) {
            console.error("Unable to read item. Error JSON:", JSON.stringify(err, null, 2));
        } else {
            // Scan succeeded
        }
    });

}

var endTime = new Date().getTime();
console.log("\tTotal time: ", (endTime - startTime) , "ms - Avg time: ", (endTime - startTime) / iterations, "ms");
```