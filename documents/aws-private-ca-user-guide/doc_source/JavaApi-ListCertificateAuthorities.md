# ListCertificateAuthorities<a name="JavaApi-ListCertificateAuthorities"></a>

The following Java sample shows how to use the [ListCertificateAuthorities](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_ListCertificateAuthorities.html) operation\.

This operation lists the private certificate authorities \(CAs\) that you created using the [CreateCertificateAuthority](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_CreateCertificateAuthority.html) operation\.

```
package com.amazonaws.samples;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.auth.AWSStaticCredentialsProvider;

import com.amazonaws.services.acmpca.AWSACMPCA;
import com.amazonaws.services.acmpca.AWSACMPCAClientBuilder;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.acmpca.model.ListCertificateAuthoritiesRequest;
import com.amazonaws.services.acmpca.model.ListCertificateAuthoritiesResult;
import com.amazonaws.services.acmpca.model.InvalidNextTokenException;

public class ListCertificateAuthorities {

   public static void main(String[] args) throws Exception {

      // Retrieve your credentials from the C:\Users\name\.aws\credentials file
      // in Windows or the .aws/credentials file in Linux.
      AWSCredentials credentials = null;
      try {
          credentials = new ProfileCredentialsProvider("default").getCredentials();
      } catch (Exception e) {
          throw new AmazonClientException("Cannot load your credentials from file.", e);
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

      // Create the request object.
      ListCertificateAuthoritiesRequest req = new ListCertificateAuthoritiesRequest();
      req.withMaxResults(10);

      // Retrieve a list of your CAs.
      ListCertificateAuthoritiesResult result= null;
      try {
          result = client.listCertificateAuthorities(req);
      } catch (InvalidNextTokenException ex) {
          throw ex;
      }

      // Display the CA list.
      System.out.println(result.getCertificateAuthorities());
   }
}
```

If you have any certificate authorities to list, your output should be similar to the following:

```
[{
	Arn: arn: aws: acm-pca: region: account: certificate-authority/12345678-1234-1234-1234-123456789012,
	CreatedAt: TueNov0712: 05: 39PST2017,
	LastStateChangeAt: WedJan1012: 35: 39PST2018,
	Type: SUBORDINATE,
	Serial: 4109,
	Status: DISABLED,
	NotBefore: TueNov0712: 19: 15PST2017,
	NotAfter: FriNov0513: 19: 15PDT2027,
	CertificateAuthorityConfiguration: {
		KeyType: RSA2048,
		SigningAlgorithm: SHA256WITHRSA,
		Subject: {
			Organization: ExampleCorp,
			OrganizationalUnit: HR,
			State: Washington,
			CommonName: www.example.com,
			Locality: Seattle,
			
		}
	},
	RevocationConfiguration: {
		CrlConfiguration: {
			Enabled: true,
			ExpirationInDays: 3650,
			CustomCname: your-custom-name,
			S3BucketName: your-bucket-name
		}
	}
},
{
	Arn: arn: aws: acm-pca: region: account>: certificate-authority/12345678-1234-1234-1234-123456789012,
	CreatedAt: WedSep1312: 54: 52PDT2017,
	LastStateChangeAt: WedSep1312: 54: 52PDT2017,
	Type: SUBORDINATE,
	Serial: 4100,
	Status: ACTIVE,
	NotBefore: WedSep1314: 11: 19PDT2017,
	NotAfter: SatSep1114: 11: 19PDT2027,
	CertificateAuthorityConfiguration: {
		KeyType: RSA2048,
		SigningAlgorithm: SHA256WITHRSA,
		Subject: {
			Country: US,
			Organization: ExampleCompany,
			OrganizationalUnit: Sales,
			State: Washington,
			CommonName: www.example.com,
			Locality: Seattle,
			
		}
	},
	RevocationConfiguration: {
		CrlConfiguration: {
			Enabled: false,
			ExpirationInDays: 5,
			CustomCname: your-custom-name,
			S3BucketName: your-bucket-name
		}
	}
},
{
	Arn: arn: aws: acm-pca: region: account>: certificate-authority/12345678-1234-1234-1234-123456789012,
	CreatedAt: FriJan1213: 57: 11PST2018,
	LastStateChangeAt: FriJan1213: 57: 11PST2018,
	Type: SUBORDINATE,
	Status: PENDING_CERTIFICATE,
	CertificateAuthorityConfiguration: {
		KeyType: RSA2048,
		SigningAlgorithm: SHA256WITHRSA,
		Subject: {
			Country: US,
			Organization: Examples-R-Us Ltd.,
			OrganizationalUnit: corporate,
			State: WA,
			CommonName: www.examplesrus.com,
			Locality: Seattle,
			
		}
	},
	RevocationConfiguration: {
		CrlConfiguration: {
			Enabled: true,
			ExpirationInDays: 365,
			CustomCname: your-custom-name,
			S3BucketName: your-bucket-name
		}
	}
},
{
	Arn: arn: aws: acm-pca: region: account>: certificate-authority/12345678-1234-1234-1234-123456789012,
	CreatedAt: FriJan0511: 14: 21PST2018,
	LastStateChangeAt: FriJan0511: 14: 21PST2018,
	Type: SUBORDINATE,
	Serial: 4116,
	Status: ACTIVE,
	NotBefore: FriJan0512: 12: 56PST2018,
	NotAfter: MonJan0312: 12: 56PST2028,
	CertificateAuthorityConfiguration: {
		KeyType: RSA2048,
		SigningAlgorithm: SHA256WITHRSA,
		Subject: {
			Country: US,
			Organization: ExamplesLLC,
			OrganizationalUnit: CorporateOffice,
			State: WA,
			CommonName: www.example.com,
			Locality: Seattle,
			
		}
	},
	RevocationConfiguration: {
		CrlConfiguration: {
			Enabled: true,
			ExpirationInDays: 3650,
			CustomCname: your-custom-name,
			S3BucketName: your-bucket-name
		}
	}
}]
```