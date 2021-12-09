# Using Amazon Translate to Translate a Web Page<a name="examples-web"></a>

You can use Amazon Translate to translate the contents of a Web page\. The following Java program translates a specified Web page from English to Spanish and creates an HTML file that contains the result of the translation\. There are two functions in the program:
+ A function that reads data from the source Web page, separates it into HTML elements, and then calls the second function to translate the element\. At the end of the document, it writes the results to an HTML file\.
+ A function that calls the Amazon Translate service to translate the contents of an HTML element\.

This example works on simple HTML pages without nested elements\.

**To configure the example**

1. Install and configure the AWS SDK for Java\. For instructions for installing the SDK for Java, see [ Set up the AWS SDK for Java](https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/setup-install.html)\.

1. Install the jsoup Java HTML parser\. For instructions, see [jsoup](https://jsoup.org/)\.

1. Create an IAM user with the minimum required permissions to run this example\. For information about creating an IAM user, see [ Creating an IAM User in Your AWS Account ](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_users_create.html) in the *AWS Identity and Access Management User Guide*\. For the required permissions policies, see [Amazon Translate Identity\-Based Policies](security_iam_service-with-iam.md#access-control-managing-permissions)\.

1. Set up the credentials needed to run the sample\. For instructions, see [ Set up AWS Credentials and Region for Development ](https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/setup-credentials.html) in the *AWS SDK for Java Developer Guide*\.

1. Create a new project in your Java IDE and copy the source code\.

1. Change the region and endpoint to the region where you want to run the Amazon Translate operation\. For a list of supported regions for Amazon Translate, see [AWS Regions and Endpoints](https://docs.aws.amazon.com/general/latest/gr/rande.html#translate_region) in the *AWS General Reference*\.

```
package com.amazonaws.translateweb;
 
import com.amazonaws.auth.AWSCredentialsProviderChain;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.auth.SystemPropertiesCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.translate.AmazonTranslate;
import com.amazonaws.services.translate.AmazonTranslateClient;
import com.amazonaws.services.translate.model.TranslateTextRequest;
import com.amazonaws.services.translate.model.TranslateTextResult;
import com.amazonaws.AmazonServiceException;
 
import java.io.IOException;
import java.io.PrintWriter;
 
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
 
import org.jsoup.select.Elements;
 
 
public class TranslateWebPage {
                
   public static void main(String[] args) throws InterruptedException {
 
   // Define the URL of the HTML content to translate
   String url = "http://example.com/source.html";
   
   // Create credentials using a provider chain that will evaluate in order;
   // a) Any Java system properties
   // b) Any environment variables
   // c) Any profile file
   AWSCredentialsProviderChain DefaultAWSCredentialsProviderChain = new AWSCredentialsProviderChain(
         new SystemPropertiesCredentialsProvider(),
         new EnvironmentVariableCredentialsProvider(),
         new ProfileCredentialsProvider()
      );
 
   // Create an endpoint configuration for the Translate service
   AwsClientBuilder.EndpointConfiguration endpointConfiguration = new AwsClientBuilder.EndpointConfiguration(
      "endpoint", "region");
 
   // Create a client for the Translate service
   AmazonTranslate translate = AmazonTranslateClient.builder()
      .withCredentials(DefaultAWSCredentialsProviderChain)
      .withEndpointConfiguration(endpointConfiguration).build();
 
   
   // Record the beginning of translating the HTML content at the url
   System.out.println("Translating URL: " + url);
 
   // Create an empty HTML document to store the parsed data
   Document doc;
 
   try {
      // Retrieve the HTML located at the URL
      doc = Jsoup.connect(url).get();
 
      // Select all of the elements in the HTML
      Elements eles = doc.select("*");
 
      // For each element
      for (Element ele : eles) {
      
          // Translate the element 
          translateElement(ele, translate);
      
          // If you encounter service throttling when translating large web
          // pages, you can request a service limit increase. For details, 
          // see https://aws.amazon.com/premiumsupport/knowledge-center/manage-service-limits/,
          // or you can throttle your requests by inserting a sleep statement.
          // Thread.sleep(1000);
      }
      
      // Configure an output file for the translated HTML
      String fname = "output HTML file name";
      PrintWriter pw = new PrintWriter(fname, "UTF-8");
            
      // Write our translated HTML to the output file
      pw.println(doc);
      pw.close();
            
      // Record that the file has been saved
      System.out.println("Saved file "+fname);
      
      
      // Catch any exceptions in retrieving the HTML
   } catch (IOException e1) {
      e1.printStackTrace();
   }
}
 
   // This function is used to translate each individual element
   public static void translateElement(Element ele, AmazonTranslate translate) {
   
      // Check if the element has any text
      if (!ele.ownText().isEmpty()) {
      
         // Retrieve the text of the HTML element
         String text = ele.ownText();
      
         // Now translate the element's text
         try {
   
            // Translate from English to Spanish
            TranslateTextRequest request = new TranslateTextRequest()
               .withText(text)
               .withSourceLanguageCode("en")
               .withTargetLanguageCode("es");
                      
            // Retrieve the result
            TranslateTextResult result  = translate.translateText(request);
   
            // Record the original and translated text
            System.out.println("Original text: " + text + " - Translated text: "+ result.getTranslatedText());
   
            // Update the HTML element with the translated text
            ele.text(result.getTranslatedText());
   
            // Catch any translation errors           
         } catch (AmazonServiceException e) {
                   System.err.println(e.getErrorMessage());
                   System.exit(1);
         }
      } else {
       // We have found a non-text HTML element. No action required.
      } 
   }         
}
```