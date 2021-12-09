# Creating a new user<a name="creating-newuser"></a>

The following code snippet demonstrates the request construction for creating a new user in Amazon WorkDocs\.

**Note**  
This is not a valid operation for a Connected AD configuration\. To add a new user in the Connected AD configuration, the user must already be present in the enterprise directory\. Then, you must make a call to the ActivateUser API to activate the user in Amazon WorkDocs\.

The following example demonstrates how to create a new user with a storage quota of 1 gigabytes\.

```
CreateUserRequest request = new CreateUserRequest();
    request.setGivenName("GivenName");
    request.setOrganizationId("d-12345678c4");
    // Passwords should:
    //   Be between 8 and 64 characters
    //   Contain three of the four below:
    //   A Lowercase Character
    //   An Uppercase Character
    //   A Number
    //   A Special Character
    request.setPassword("Badpa$$w0rd");
    request.setSurname("surname");
    request.setUsername("UserName");
    StorageRuleType storageRule = new StorageRuleType();
    storageRule.setStorageType(StorageType.QUOTA);
    storageRule.setStorageAllocatedInBytes(new Long(1048576l));
    request.setStorageRule(storageRule);
    CreateUserResult result = workDocsClient.createUser(request);
```

You can get a Amazon WorkDocs organization ID from the AWS console using the following steps:

**To get an organization ID**

1. In the [AWS Directory Service console](https://console.aws.amazon.com/directoryservicev2/) navigation pane, select **Directories**\.

1. The **Directory ID** corresponding to your Amazon WorkDocs site is the Organization ID for that site\.