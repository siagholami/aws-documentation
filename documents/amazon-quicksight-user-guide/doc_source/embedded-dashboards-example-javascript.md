# JavaScript \(Node\.js\) Example of Embedding a Dashboard with Amazon QuickSight<a name="embedded-dashboards-example-javascript"></a>

The following example shows the JavaScript \(Node\.js\) you can use to get the URL to display an embedded dashboard\.

**Example**  

```
const AWS = require('aws-sdk');
const https = require('https');
 
var quicksight = new AWS.Service({
    apiConfig: require('./quicksight-2018-04-01.min.json'),
    region: 'us-east-1,
});
 
 
quicksight.getDashboardEmbedUrl({
    'AwsAccountId': '111122223333', 
    'DashboardId': '1c1fe111-e2d2-3b30-44ef-a0e111111cde',
    'IdentityType': 'IAM',
    'ResetDisabled': true,
    'SessionLifetimeInMinutes': 100,
    'UndoRedoDisabled': false
 
}, function(err, data) {
    console.log('Errors: ');
    console.log(err);
    console.log('Response: ');
    console.log(data);
});
```

**Example**  

```
//The URL returned is over 900 characters. For this example, we've shortened the string for readability and added ellipsis to indicate that it's incomplete.
					{ Status: 200,
  EmbedUrl: 'https://spaceneedle-alpha.amazon.com/embed/620bef10822743fab329fb3751187d2d…
  RequestId: '7bee030e-f191-45c4-97fe-d9faf0e03713' }
```