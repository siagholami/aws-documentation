# DeleteCertificateAuthority<a name="JavaApi-DeleteCertificateAuthority"></a>

The following Java sample shows how to use the [DeleteCertificateAuthority](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_DeleteCertificateAuthority.html) operation\.

This operation deletes the private certificate authority \(CA\) that you created using the [CreateCertificateAuthority](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_CreateCertificateAuthority.html) operation\. The `DeleteCertificateAuthority` operation requires that you provide an ARN for the CA to be deleted\. You can find the ARN by calling the [ListCertificateAuthorities](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_ListCertificateAuthorities.html) operation\. You can delete the private CA immediately if its status is `CREATING` or `PENDING_CERTIFICATE`\. If you have already imported the certificate, however, you cannot delete it immediately\. You must first disable the CA by calling the [UpdateCertificateAuthority](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_UpdateCertificateAuthority.html) operation and set the `Status` parameter to `DISABLED`\. You can then use the `PermanentDeletionTimeInDays` parameter in the `DeleteCertificateAuthority` operation to specify the number of days, from 7 to 30\. During that period the private CA can be restored to `disabled` status\. By default, if you do not set the `PermanentDeletionTimeInDays` parameter, the restoration period is 30 days\. After this period expires, the private CA is permanently deleted and cannot be restored\. For more information, see [Restore a CA](PCARestoreCA.md)\. 

For a Java example that shows you how to use the [RestoreCertificateAuthority](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_RestoreCertificateAuthority.html) operation, see [RestoreCertificateAuthority](JavaApi-RestoreCertificateAuthority.md)\. 

```
package com.amazonaws.samples;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.auth.AWSStaticCredentialsProvider;

import com.amazonaws.services.acmpca.AWSACMPCA;
import com.amazonaws.services.acmpca.AWSACMPCAClientBuilder;

import com.amazonaws.services.acmpca.model.DeleteCertificateAuthorityRequest;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.acmpca.model.ResourceNotFoundException;
import com.amazonaws.services.acmpca.model.InvalidArnException;
import com.amazonaws.services.acmpca.model.InvalidStateException;
import com.amazonaws.services.acmpca.model.RequestFailedException;

public class DeleteCertificateAuthority {

   public static void main(String[] args) throws Exception{

      // Retrieve your credentials from the C:\Users\name\.aws\credentials file
      // in Windows or the .aws/credentials file in Linux.
      AWSCredentials credentials = null;
      try {
         credentials = new ProfileCredentialsProvider("default").getCredentials();
      } catch (Exception e) {
         throw new AmazonClientException("Cannot load your credentials from disk", e);
      }

      // Define the endpoint for your sample.
      String endpointRegion = "region";  // Substitute your region here, e.g. "us-west-2"
      String endpointProtocol = "https://acm-pca." + endpointRegion + ".amazonaws.com/";
      EndpointConfiguration endpoint =
            new AwsClientBuilder.EndpointConfiguration(endpointProtocol, endpointRegion);

      // Create a client that you can use to make requests.
      AWSACMPCA client = AWSACMPCAClientBuilder.standard()
         .withEndpointConfiguration(endpoint)
         .withCredentials(new AWSStaticCredentialsProvider(credentials))
         .build();

      // Create a requrest object and set the ARN of the private CA to delete.
      DeleteCertificateAuthorityRequest req = new DeleteCertificateAuthorityRequest();

      // Set the certificate authority ARN.
      req.withCertificateAuthorityArn("arn:aws:acm-pca:region:account:" +
            "certificate-authority/11111111-2222-3333-4444-555555555555");
            
      // Set the recovery period.
      req.withPermanentDeletionTimeInDays(12);            

      // Delete the CA.
      try {
         client.deleteCertificateAuthority(req);
      } catch (ResourceNotFoundException ex) {
         throw ex;
      } catch (InvalidArnException ex) {
         throw ex;
      } catch (InvalidStateException ex) {
         throw ex;
      } catch (RequestFailedException ex) {
         throw ex;
      }
   }
}
```