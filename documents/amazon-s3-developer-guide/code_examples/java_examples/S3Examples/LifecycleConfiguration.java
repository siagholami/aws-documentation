// Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0 (For details, see https://github.com/awsdocs/amazon-s3-developer-guide/blob/master/LICENSE-SAMPLECODE.)

import java.io.IOException;
import java.util.Arrays;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.BucketLifecycleConfiguration;
import com.amazonaws.services.s3.model.BucketLifecycleConfiguration.Transition;
import com.amazonaws.services.s3.model.StorageClass;
import com.amazonaws.services.s3.model.Tag;
import com.amazonaws.services.s3.model.lifecycle.LifecycleAndOperator;
import com.amazonaws.services.s3.model.lifecycle.LifecycleFilter;
import com.amazonaws.services.s3.model.lifecycle.LifecyclePrefixPredicate;
import com.amazonaws.services.s3.model.lifecycle.LifecycleTagPredicate;

public class LifecycleConfiguration {

    public static void main(String[] args) throws IOException {
        String clientRegion = "*** Client region ***";
        String bucketName = "*** Bucket name ***";
        
        // Create a rule to archive objects with the "glacierobjects/" prefix to Glacier immediately.
        BucketLifecycleConfiguration.Rule rule1 = new BucketLifecycleConfiguration.Rule()
                .withId("Archive immediately rule")
                .withFilter(new LifecycleFilter(new LifecyclePrefixPredicate("glacierobjects/")))
                .addTransition(new Transition().withDays(0).withStorageClass(StorageClass.Glacier))
                .withStatus(BucketLifecycleConfiguration.ENABLED);

        // Create a rule to transition objects to the Standard-Infrequent Access storage class 
        // after 30 days, then to Glacier after 365 days. Amazon S3 will delete the objects after 3650 days.
        // The rule applies to all objects with the tag "archive" set to "true". 
        BucketLifecycleConfiguration.Rule rule2 = new BucketLifecycleConfiguration.Rule()
                .withId("Archive and then delete rule")
                .withFilter(new LifecycleFilter(new LifecycleTagPredicate(new Tag("archive", "true"))))
                .addTransition(new Transition().withDays(30).withStorageClass(StorageClass.StandardInfrequentAccess))
                .addTransition(new Transition().withDays(365).withStorageClass(StorageClass.Glacier))
                .withExpirationInDays(3650)
                .withStatus(BucketLifecycleConfiguration.ENABLED);

        // Add the rules to a new BucketLifecycleConfiguration.
        BucketLifecycleConfiguration configuration = new BucketLifecycleConfiguration()
                .withRules(Arrays.asList(rule1, rule2));

        try {
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                    .withCredentials(new ProfileCredentialsProvider())
                    .withRegion(clientRegion)
                    .build();

            // Save the configuration.
            s3Client.setBucketLifecycleConfiguration(bucketName, configuration);
    
            // Retrieve the configuration.
            configuration = s3Client.getBucketLifecycleConfiguration(bucketName);
    
            // Add a new rule with both a prefix predicate and a tag predicate.
            configuration.getRules().add(new BucketLifecycleConfiguration.Rule().withId("NewRule")
                    .withFilter(new LifecycleFilter(new LifecycleAndOperator(
                            Arrays.asList(new LifecyclePrefixPredicate("YearlyDocuments/"),
                                          new LifecycleTagPredicate(new Tag("expire_after", "ten_years"))))))
                    .withExpirationInDays(3650)
                    .withStatus(BucketLifecycleConfiguration.ENABLED));
    
            // Save the configuration.
            s3Client.setBucketLifecycleConfiguration(bucketName, configuration);
    
            // Retrieve the configuration.
            configuration = s3Client.getBucketLifecycleConfiguration(bucketName);
    
            // Verify that the configuration now has three rules.
            configuration = s3Client.getBucketLifecycleConfiguration(bucketName);
            System.out.println("Expected # of rules = 3; found: " + configuration.getRules().size());
    
            // Delete the configuration.
            s3Client.deleteBucketLifecycleConfiguration(bucketName);
    
            // Verify that the configuration has been deleted by attempting to retrieve it.
            configuration = s3Client.getBucketLifecycleConfiguration(bucketName);
            String s = (configuration == null) ? "No configuration found." : "Configuration found.";
            System.out.println(s);
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