# Connect to Amazon WorkDocs with IAM user credentials and query for users<a name="connect-workdocs-iam"></a>

The following code, using the AWS SDK, illustrates the steps in making API calls using an IAM user’s API credentials\. In this case the API user and the Amazon WorkDocs site belong to the same AWS account\.

Ensure that the IAM user has been granted Amazon WorkDocs API access through an appropriate IAM policy\.

The code sample uses describeUsers API to search for users and obtain metadata for users\. User metadata provides details such as first name, last name, User ID and Root Folder ID\. Root Folder ID is particularly helpful if you want to perform any content upload or download operations on behalf of the user\.

The code requires that you obtain an Amazon WorkDocs Organization ID\.

You can get a Amazon WorkDocs organization ID from the AWS console using the following steps:

**To get an organization ID**

1. In the [AWS Directory Service console](https://console.aws.amazon.com/directoryservicev2/) navigation pane, select **Directories**\.

1. The **Directory ID** corresponding to your Amazon WorkDocs site is the Organization ID for that site\.

The following is the code example:

```
import java.util.ArrayList;
import java.util.List;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.workdocs.AmazonWorkDocs;
import com.amazonaws.services.workdocs.AmazonWorkDocsClient;
import com.amazonaws.services.workdocs.model.DescribeUsersRequest;
import com.amazonaws.services.workdocs.model.DescribeUsersResult;
import com.amazonaws.services.workdocs.model.User;

public class GetUserDemo {

  public static void main(String[] args) throws Exception {
    AWSCredentials longTermCredentials =
        new BasicAWSCredentials("accessKey", "secretKey");
    AWSStaticCredentialsProvider staticCredentialProvider =
        new AWSStaticCredentialsProvider(longTermCredentials);

    AmazonWorkDocs workDocs =
        AmazonWorkDocsClient.builder().withCredentials(staticCredentialProvider)
            .withRegion(Regions.US_WEST_2).build();

    List<User> wdUsers = new ArrayList<>();
    DescribeUsersRequest request = new DescribeUsersRequest();
	
    // The OrganizationId used here is an example and it should be replaced 
	   // with the OrganizationId of your WorkDocs site.
    request.setOrganizationId("d-123456789c");
    request.setQuery("joe");
	
    String marker = null;
    do {
      request.setMarker(marker);
      DescribeUsersResult result = workDocs.describeUsers(request);
      wdUsers.addAll(result.getUsers());
      marker = result.getMarker();
    } while (marker != null);
	
    System.out.println("List of users matching the query string: joe ");
    
	for (User wdUser : wdUsers) {
      System.out.printf("Firstname:%s | Lastname:%s | Email:%s | root-folder-id:%s\n",
          wdUser.getGivenName(), wdUser.getSurname(), wdUser.getEmailAddress(),
          wdUser.getRootFolderId());
    }
  }
}
```