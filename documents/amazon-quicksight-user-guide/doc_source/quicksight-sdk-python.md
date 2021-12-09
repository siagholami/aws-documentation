# Amazon QuickSight Python3 SDK<a name="quicksight-sdk-python"></a>

Use the following procedure to create a custom built `botocore` package to interact with Amazon QuickSight\. 

1. Create a credentials file in the AWS directory for your environment\. In a Linux/Mac\-based environment, that file is called \~/\.aws/credentials and looks like this:

   ```
   [default]
   aws_access_key_id = Your_IAM_access_key
   aws_secret_access_key = Your_IAM_secret_key
   ```

1. Unzip the folder `botocore-1.12.10`\. Change directory into `botocore-1.12.10` and enter the Python3 interpreter environment\.

1. Responses come back as a dictionary object\. They each have a `ResponseMetadata` entry that contains request IDs and response status\. Other entries are based on what type of operation you run\.

1. The following example is a sample app that first creates, deletes, and lists groups\. Then, it lists users in a Quicksight account:

   ```
   import botocore.session
   default_namespace = 'default'
   account_id = 'relevant_AWS_Account'
   
   session = botocore.session.get_session()
   client = session.create_client("quicksight", region_name='us-east-1')
   
   print('Creating three groups: ')
   client.create_group(AwsAccountId = account_id, Namespace=default_namespace, GroupName='MyGroup1')
   client.create_group(AwsAccountId = account_id, Namespace=default_namespace, GroupName='MyGroup2')
   client.create_group(AwsAccountId = account_id, Namespace=default_namespace, GroupName='MyGroup3')
   
   print('Retrieving the groups and listing them: ')
   response = client.list_groups(AwsAccountId = account_id, Namespace=default_namespace)
   for group in response['GroupList']:
       print(group)
   
   print('Deleting our groups: ')
   client.delete_group(AwsAccountId = account_id, Namespace=default_namespace, GroupName='MyGroup1')
   client.delete_group(AwsAccountId = account_id, Namespace=default_namespace, GroupName='MyGroup2')
   client.delete_group(AwsAccountId = account_id, Namespace=default_namespace, GroupName='MyGroup3')
   
   response = client.list_users(AwsAccountId = account_id, Namespace=default_namespace)
   for user in response['UserList']:
       print(user)
   ```