/**
 * Copyright 2018-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * This file is licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License. A copy of
 * the License is located at
 *
 * http://aws.amazon.com/apache2.0/
 *
 * This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
*/

// snippet-sourcedescription:[MakingRequestsWithIAMTempCredentials.java demonstrates how to assume an IAM role temporarily and use it to make requests against Amazon S3.]
// snippet-service:[s3]
// snippet-keyword:[Java]
// snippet-keyword:[Amazon S3]
// snippet-keyword:[Code Sample]
// snippet-keyword:[GET Bucket]
// snippet-sourcetype:[full-example]
// snippet-sourcedate:[2019-01-28]
// snippet-sourceauthor:[AWS]
// snippet-start:[s3.java.making_requests_with_IAM_temp_credentials.complete]

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.securitytoken.AWSSecurityTokenService;
import com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClientBuilder;
import com.amazonaws.services.securitytoken.model.AssumeRoleRequest;
import com.amazonaws.services.securitytoken.model.AssumeRoleResult;
import com.amazonaws.services.securitytoken.model.Credentials;

public class MakingRequestsWithIAMTempCredentials {
    public static void main(String[] args) {
        String clientRegion = "*** Client region ***";
        String roleARN = "*** ARN for role to be assumed ***";
        String roleSessionName = "*** Role session name ***";
        String bucketName = "*** Bucket name ***";

        try {
            // Creating the STS client is part of your trusted code. It has
            // the security credentials you use to obtain temporary security credentials.
            AWSSecurityTokenService stsClient = AWSSecurityTokenServiceClientBuilder.standard()
                                                    .withCredentials(new ProfileCredentialsProvider())
                                                    .withRegion(clientRegion)
                                                    .build();

            // Obtain credentials for the IAM role. Note that you cannot assume the role of an AWS root account;
            // Amazon S3 will deny access. You must use credentials for an IAM user or an IAM role.
            AssumeRoleRequest roleRequest = new AssumeRoleRequest()
                                                    .withRoleArn(roleARN)
                                                    .withRoleSessionName(roleSessionName);
            AssumeRoleResult roleResponse = stsClient.assumeRole(roleRequest);
            Credentials sessionCredentials = roleResponse.getCredentials();
            
            // Create a BasicSessionCredentials object that contains the credentials you just retrieved.
            BasicSessionCredentials awsCredentials = new BasicSessionCredentials(
                    sessionCredentials.getAccessKeyId(),
                    sessionCredentials.getSecretAccessKey(),
                    sessionCredentials.getSessionToken());

            // Provide temporary security credentials so that the Amazon S3 client 
	    // can send authenticated requests to Amazon S3. You create the client 
	    // using the sessionCredentials object.
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                                    .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                                    .withRegion(clientRegion)
                                    .build();

            // Verify that assuming the role worked and the permissions are set correctly
            // by getting a set of object keys from the bucket.
            ObjectListing objects = s3Client.listObjects(bucketName);
            System.out.println("No. of Objects: " + objects.getObjectSummaries().size());
        }
        catch(AmazonServiceException e) {
            // The call was transmitted successfully, but Amazon S3 couldn't process 
            // it, so it returned an error response.
            e.printStackTrace();
        }
        catch(SdkClientException e) {
            // Amazon S3 couldn't be contacted for a response, or the client
            // couldn't parse the response from Amazon S3.
            e.printStackTrace();
        }
    }
}

// snippet-end:[s3.java.making_requests_with_IAM_temp_credentials.complete]
