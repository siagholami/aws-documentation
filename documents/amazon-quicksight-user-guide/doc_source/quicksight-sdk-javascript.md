# Amazon QuickSight JavaScript \(Node\.js\) SDK<a name="quicksight-sdk-javascript"></a>

Use the following procedure to interact with Amazon QuickSight using Node\.js\. It Node/npm are available on the target system\.

1. Set up your node environment using the following commands:
   + `npm install aws-sdk`
   + `npm install aws4 `
   + `npm install request`
   + `npm install url`

1. For information on configuring the *Node with AWS SDK* and setting your credentials, see [http://docs\.amazonaws\.cn/en\_us/AWSJavaScriptSDK/guide/node\-configuring\.html](http://docs.amazonaws.cn/en_us/AWSJavaScriptSDK/guide/node-configuring.html) 

1. Use the following code sample to test your setup\. HTTPS is required\. The sample displays a full listing of Amazon QuickSight operations along with their URL request parameters, followed by a list of Amazon QuickSight users in your account\.

   ```
   const AWS = require('aws-sdk');
   const https = require('https');
   
   var quicksight = new AWS.Service({
       apiConfig: require('./quicksight-2018-04-01.min.json'),
       region: 'us-east-1',
   });
   
   console.log(quicksight.config.apiConfig.operations);
   
   quicksight.listUsers({
       // Enter your actual AWS account ID
       'AwsAccountId': 'relevant_AWS_account_ID', 
       'Namespace': 'default',
   }, function(err, data) {
       console.log('---');
       console.log('Errors: ');
       console.log(err);
       console.log('---');
       console.log('Response: ');
       console.log(data);
   });
   ```