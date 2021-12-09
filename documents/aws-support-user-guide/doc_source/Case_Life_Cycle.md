# Programming an AWS Support case<a name="Case_Life_Cycle"></a>

The AWS Support API lets you create cases and add correspondence to them throughout investigations of your issues and interactions with AWS Support staff\. This topic demonstrates the use of actions in the AWS Support service, which models much of the behavior of the [AWS Support center](https://console.aws.amazon.com/support/home#/)\.

For a list of actions and parameters that you can use for AWS Support, see the [AWS Support API Reference](https://docs.aws.amazon.com/awssupport/latest/APIReference/Welcome.html)\.

**Topics**
+ [Overview](#Overview)
+ [Create an AWS Support client](#getclient)
+ [Discover AWS services and issue severity levels](#discoverservices)
+ [Create an attachment set](#attachmentset)
+ [Create a support case](#createcase)
+ [Retrieve and update support case communications](#casecommunications)
+ [Retrieve all support case information](#describecases)
+ [Resolve a support case](#resolvecase)

## Overview<a name="Overview"></a>

This topic uses Java code examples to demonstrate the use of AWS Support\. For more information about SDK support, see [Sample code & libraries](http://aws.amazon.com/code/)\.

**Note**  
If you encounter service limits with your calls to AWS Support, follow the recommendations in [Error retries and exponential backoff in AWS](https://docs.aws.amazon.com/general/latest/gr/api-retries.html)\.

### Using IAM with the AWS Support API<a name="IAM_support"></a>

AWS Identity and Access Management \(IAM\) is supported by the AWS Support API\. For more information, see [Access AWS Support](accessing-support.md)\.

## Create an AWS Support client<a name="getclient"></a>

The following Java code snippet shows how to create an `AWSSupportClient`, which is used to call the `AWSSupportService`\. The `createClient` method gets AWS credentials by calling the `[AWSSupportClient\(\)](https://docs.aws.amazon.com/AWSJavaSDK/latest/javadoc/com/amazonaws/services/support/AWSSupportClient.html#AWSSupportClient%28%29)` constructor with no parameters, which retrieves credentials from the credentials provider chain\. For more information on this process, see [Tutorial: Grant access using an IAM role and the AWS SDK for Java](https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/java-dg-roles.html) in the *AWS SDK for Java*\.

For more information on AWS credentials, see [AWS security credentials](https://docs.aws.amazon.com/general/latest/gr/aws-security-credentials.html) in the *AWS General Reference*\.

```
private static AWSSupportClient createClient()
{
    AWSSupportClient client = new AWSSupportClient();
    client.setEndpoint("https://support.us-east-1.amazonaws.com");
    return client;
}
```

## Discover AWS services and issue severity levels<a name="discoverservices"></a>

The AWS Support Java client provides a `CreateCaseRequest` type to submit a case programmatically to AWS Support\. The `CreateCaseRequest` structure is populated with the request parameters and then passed to the `createClient` method on the `AWSSupportClient` instance\. These parameters include codes that specify the AWS service and case severity\.

The following Java code snippet demonstrates calls to the AWS Support [DescribeServices](https://docs.aws.amazon.com/awssupport/latest/APIReference/API_DescribeServices.html) and [DescribeSeverityLevel](https://docs.aws.amazon.com/awssupport/latest/APIReference/API_DescribeSeverityLevels.html) actions:

```
// DescribeServices example

public static void getServiceCodes(AWSSupportClient client) 
{
    DescribeServicesResult result = client.describeServices();
    for (Service service : result.getServices()) 
    {
        System.out.println("Service code (name): " + 
            service.getCode() + "(" + service.getName() + ")");
        for (Category category : service.getCategories())
        {
            System.out.println("    Category code (name): " + 
                category.getCode() + "(" + category.getName() + ")");
        }
    }
}

// DescribeSeverityLevels example

public static void getSeverityLevels(AWSSupportClient client) 
{
    DescribeSeverityLevelsResult result = client.describeSeverityLevels();
    for (SeverityLevel level : result.getSeverityLevelsList()) 
    {
        System.out.println("Severity level (name): " + 
            level.getCode() + level.getName() + ")");
    }
}
```

Each call returns a list of JSON\-formatted objects\. `DescribeServices` returns service codes and their corresponding names, and `DescribeSeverityLevels` returns severity levels and their corresponding names\. In addition, `DescribeServices` also returns a list of AWS Support categories that apply to each AWS service\. These categories are also used to open a support case by using the [CreateCase](https://docs.aws.amazon.com/awssupport/latest/APIReference/API_CreateCase.html) action\. Although these values can also be obtained from the AWS Support site itself, the AWS Support service always returns the most recent version of this information\.

## Create an attachment set<a name="attachmentset"></a>

To attach files to the case, you must add the attachments to an attachment set before creating the case\. You can add up to three attachments to an attachment set, and the maximum size of any attachment in the set is 5 MB\. For more information, see [AddAttachmentsToSet](https://docs.aws.amazon.com/awssupport/latest/APIReference/API_AddAttachmentsToSet.html)\.

The following Java code snippet creates a text file attachment, adds it to an attachment set, and then gets the ID of the attachment set for adding to the case\.

```
public static string createAttachmentSet() throws IOException 
{
    BufferedReader reader = 
        new BufferedReader(new InputStreamReader(System.in));
    
    // Get content and file name for an attachment.
    System.out.println("Enter text content for an attachment to the case: ");
    String attachmentcontent = null;
    try 
    {
        attachmentcontent = reader.readLine().trim();
    } 
    catch (IOException e) 
    {        
        e.printStackTrace();
        System.exit(1); 
    }
    
    System.out.println("Enter the file name for the attachment: ");
    String attachmentfilename = null;
    try 
    {
        attachmentfilename = reader.readLine().trim();
    } 
    catch (IOException e) 
    {        
        e.printStackTrace();
        System.exit(1); 
    }
    
    // Create the attachment.
    Attachment attachment1 = new Attachment();
    attachment1.setData(ByteBuffer.wrap(attachmentcontent.getBytes()));
    attachment1.setFileName("attachmentfilename");
    
    // Add the attachment to an array list.
    List<Attachment> attachments = new ArrayList<Attachment>();
    attachments.add(attachment1);
    
    // Create an attachment set and add the attachment array list to it.
    AddAttachmentsToSetRequest addAttachmentsToSetRequest = 
        new AddAttachmentsToSetRequest();
    addAttachmentsToSetRequest.setAttachments(attachments);
    
    AddAttachmentsToSetResult addAttachmentsToSetResult =
        client.addAttachmentsToSet(addAttachmentsToSetRequest);
    
    // Get the ID of the attachment set.
    String attachmentsetid = addAttachmentsToSetResult.getAttachmentSetId();
    System.out.println("Attachment ID: " + attachmentsetid);
    return attachmentsetid;
}
```

## Create a support case<a name="createcase"></a>

To create an AWS Support case using the AWS Support service, populate a `CreateCaseRequest` instance with the following information:
+ `ServiceCode` – The AWS Support service code that you obtained by calling the `DescribeServices` action, as described in the previous section\.
+ `CategoryCode` – The category code that describes the type of issue the support case concerns\.
+ `Language` – A code for the language that AWS Support provides support in\. Currently, AWS supports English \(`en`\) and Japanese \(`ja`\)\.
+ `CcEmailAddresses` – A list of email addresses to receive copies of subsequent communications\.
+ `CommunicationBody` – Text for the body of the initial case submission\.
+ `Subject` – A title for the support case\.
+ `SeverityCode` – One of the values returned by the call to `DescribeSeverityLevels`\.
+ `AttachmentSetId` – \(Optional\) The ID of a set of file attachments to include with the case\. The `AddAttachmentsToSet` action returns the ID\.

The following Java code snippet collects values for each of the case creation parameters from the command line\. It then populates a `CreateCaseRequest` instance and passes them to AWS Support by calling the `createCase` method on an `AWSSupportClient` instance\. If the call is successful, it returns an AWS Support `CaseId` value in the following format\.

```
case-123456789012-muen-2012-74a757cd8cf7558a
```

**Note**  
AWS Support provides both `CaseId` and `DisplayId` fields\. The `DisplayId` field corresponds to the case number that is displayed on the AWS Support site\. The `CaseId` field is for use in programmatic interactions with the AWS Support service\. Both fields are exposed on the `CaseDetails` data type\.

```
public static void createCase(AWSSupportClient client) throws IOException 
{
    BufferedReader reader = 
        new BufferedReader(new InputStreamReader(System.in));
        
    System.out.println("Enter an AWS Service code: ");
    String servicecode = null;
    try 
    {
        servicecode = reader.readLine().trim();
    } 
    catch (IOException e) 
    {      
        e.printStackTrace();
        System.exit(1); 
    }
    
    System.out.println("Enter a category code: ");
    String categorycode = null;
    try 
    {
        categorycode = reader.readLine().trim();
    } 
    catch (IOException e) 
    {
        e.printStackTrace();
        System.exit(1); 
    }

    System.out.println("Enter a language code, 'en' for English: ");
    String language = null;
    try 
    {
        language = reader.readLine().trim();
    } 
    catch (IOException e) 
    {      
        e.printStackTrace();
        System.exit(1); 
    }

    System.out.println("Enter an email address to copy on correspondence: ");
    String ccemailaddress = null;
    try 
    {
        ccemailaddress = reader.readLine().trim();
    } 
    catch (IOException e) 
    {      
        e.printStackTrace();
        System.exit(1); 
    }
    
    System.out.println("Enter body text for the case: ");
    String communicationbody = null;
    try 
    {
        communicationbody = reader.readLine().trim();
    } 
    catch (IOException e) 
    {     
        e.printStackTrace();
        System.exit(1); 
    }
    
    System.out.println("Enter a subject for the case: ");
    String casesubject = null;
    try 
    {
        casesubject = reader.readLine().trim();
    }
    catch (IOException e) 
    {       
        e.printStackTrace();
        System.exit(1); 
    }
    
    System.out.println("Enter the severity code for the case: ");
    String severitycode = null;
    try 
    {
        severitycode = reader.readLine().trim();
    } 
    catch (IOException e) 
    {        
        e.printStackTrace();
        System.exit(1); 
    }
    
    System.out.println("Enter the attachment set ID for the case: ");
    String attachmentsetid = null;
    try 
    {
        attachmentsetid = reader.readLine().trim();
    } 
    catch (IOException e) 
    {        
        e.printStackTrace();
        System.exit(1); 
    }
    
    CreateCaseRequest request = new CreateCaseRequest()
        .withServiceCode(servicecode)
        .withCategoryCode(categorycode)
        .withLanguage(language)
        .withCcEmailAddresses(ccemailaddress)
        .withCommunicationBody(communicationbody)
        .withSubject(casesubject)
        .withSeverityCode(severitycode)
        .withAttachmentSetId(attachmentsetid);
       
    CreateCaseResult result = client.createCase(request);
    System.out.println("CreateCase() Example: Case created with ID " 
        + result.getCaseId());
}
```

## Retrieve and update support case communications<a name="casecommunications"></a>

AWS Support cases usually result in communication between the customer and AWS Support professionals\. AWS Support provides the [DescribeCommunications](https://docs.aws.amazon.com/awssupport/latest/APIReference/API_DescribeCommunications.html) and [DescribeAttachment](https://docs.aws.amazon.com/awssupport/latest/APIReference/API_DescribeAttachment.html) actions to retrieve this correspondence, and the [AddAttachmentsToSet](https://docs.aws.amazon.com/awssupport/latest/APIReference/API_AddAttachmentsToSet.html) and [AddCommunicationToCase](https://docs.aws.amazon.com/awssupport/latest/APIReference/API_AddCommunicationToCase.html) actions to update the case\. These actions use the [Communication](https://docs.aws.amazon.com/awssupport/latest/APIReference/API_Communication.html) data type to pass updates to the service and return them to your code\.

The following Java code snippet adds communication to an AWS Support case\. In the example, a private `PrintCommunications` method is provided for your convenience\.

```
public static void addCommunication(AWSSupportClient client) 
{
    System.out.println("Enter the CaseID for the case you want to update.");
    BufferedReader reader = 
        new BufferedReader(new InputStreamReader(System.in));
    String caseid = null;
    try 
    {
        caseid = reader.readLine().trim();
    } 
    catch (IOException e) 
    {       
        e.printStackTrace();
        System.exit(1); 
    }

    System.out.println("Enter text you want to add to this case.");
    String addcomm = null;
    try 
    {
        addcomm = reader.readLine().trim();
    } 
    catch (IOException e) 
    {
        e.printStackTrace();
        System.exit(1); 
    }

    AddCommunicationToCaseRequest request = 
        new AddCommunicationToCaseRequest().withCaseId(caseid)
                                           .withCommunicationBody(addcomm);
    client.addCommunicationToCase(request);

    System.out.println(
        "AddCommunication() Example: Call GetCommunications() " + 
        "if you want to see if the communication was added.");
}

// DescribeCommunications example

public static void getCommunications(AWSSupportClient client) 
    throws IOException 
{
    BufferedReader reader = 
        new BufferedReader(new InputStreamReader(System.in));
    String caseNumber = null;

    System.out.println("Enter an AWS CaseID");
    caseNumber = reader.readLine().trim();

    {
        DescribeCommunicationsRequest request = 
            new DescribeCommunicationsRequest()
            .withCaseId(caseNumber.toString());

        DescribeCommunicationsResult result = 
            client.describeCommunications(request);
        printCommunications(result.getCommunications());

        // Get more pages.
        while (result.getNextToken() != null) 
        {
            request.setNextToken(result.getNextToken());
            result = client.describeCommunications(request);
            printCommunications(result.getCommunications());
            System.out.println(
                "GetCommunications() Example: Case communications retrieved"
                + " for case number " + request.getCaseId().toString());
        }
    }
}

private static void printCommunications(List<Communication> communications) 
{
    for (Communication communication : communications) 
    {
        System.out.println("SubmittedBy: " + communication.getSubmittedBy());
        System.out.println("  Body: " + communication.getBody());
    }

}
```

**Note**  
`DescribeCommunications` returns the five most recent communications from a support case\. Also, `DescribeCommunications` takes a list of `CaseId` values, which lets you retrieve communications for multiple cases in a single call\.

## Retrieve all support case information<a name="describecases"></a>

You can retrieve all the information associated with your AWS Support cases by calling the [DescribeCases](https://docs.aws.amazon.com/awssupport/latest/APIReference/API_DescribeCases.html) action\. You populate a `DescribeCasesRequest` data type with a list of `ClientId` values, which are returned by each case when a successful `createCase` request returns\.

The following Java code snippet accepts `CaseId` values from the console and populates a `DescribeCasesRequest` instance for use by the `DescribeCases` action\. A private `printCases` method is provided for your convenience\.

```
public static void getCases(AWSSupportClient client) 
{
    BufferedReader reader = 
        new BufferedReader(new InputStreamReader(System.in));

    System.out.println("Enter an AWS Support Case ID");
    String caseid = null;
    try 
    {
        caseid = reader.readLine().trim();
    } 
    catch (IOException e) 
    {
        e.printStackTrace();
        System.exit(1); 
    }

    DescribeCasesRequest request = new DescribeCasesRequest();
    request.withCaseIdList(caseid);

    DescribeCasesResult result = client.describeCases(request);
    printCases(result.getCases());

    // Get more pages.
    while (result.getNextToken() != null) 
    {
        request.setNextToken(result.getNextToken());
        result = client.describeCases(request);
        printCases(result.getCases());
    }
}

private static void printCases(List<CaseDetails> caseDetailsList) 
{
    for (CaseDetails caseDetails : caseDetailsList) 
    {
        System.out.println(
            "Case ID: " + caseDetails.getCaseId()); // This ID is for API use.
        System.out.println(
            "  Display ID: " + caseDetails.getDisplayId()); 
            // This ID is displayed on the AWS Support website.
        System.out.println("  Language: " + caseDetails.getLanguage());
        System.out.println("  Status: " + caseDetails.getStatus());
        System.out.println("  Subject: " + caseDetails.getSubject());
        System.out.println("Recent Communications: " + 
            caseDetails.getRecentCommunications());
    }
}
```

**Note**  
The `DescribeCases` action takes parameters that let you control the number of cases, types of cases, and amount of detail to retrieve\. For more information, see the [DescribeCases](https://docs.aws.amazon.com/awssupport/latest/APIReference/API_DescribeCases.html) action\.

## Resolve a support case<a name="resolvecase"></a>

AWS Support provides a [ResolveCase](https://docs.aws.amazon.com/awssupport/latest/APIReference/API_ResolveCase.html) action to resolve your own support cases\. The following Java code example demonstrates its use\.

```
public static void resolveSupportCase(AWSSupportClient client)
{
    System.out.println(
        "Enter the AWS Support case ID for the case you want to resolve.");
    BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    String caseid = null;
    try 
    {
        caseid = BR.readLine().trim();
    } 
    catch (IOException e) 
    {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    ResolveCaseResult rcr = 
        client.resolveCase(new ResolveCaseRequest().withCaseId(caseid));
    System.out.println("Initial case status: " + rcr.getInitialCaseStatus());
    System.out.println("Final case status: " + rcr.getFinalCaseStatus());
}
```