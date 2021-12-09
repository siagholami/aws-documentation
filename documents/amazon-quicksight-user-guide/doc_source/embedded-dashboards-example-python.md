# Python3 Example of Embedding a Dashboard with Amazon QuickSight<a name="embedded-dashboards-example-python"></a>

The following example shows the Python3 code you can use to get the URL to display an embedded dashboard\.

**Example**  

```
import botocore.session
session = botocore.session.get_session()
client = session.create_client("quicksight", region_name='us-east-1')
client.get_dashboard_embed_url(AwsAccountId="111122223333", DashboardId="1c1fe111-e2d2-3b30-44ef-a0e111111cde", IdentityType="IAM", SessionLifetimeInMinutes=100, ResetDisabled=True, UndoRedoDisabled=True)
```