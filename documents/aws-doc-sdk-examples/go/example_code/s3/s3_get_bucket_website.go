// snippet-comment:[These are tags for the AWS doc team's sample catalog. Do not remove.]
// snippet-sourceauthor:[Doug-AWS]
// snippet-sourcedescription:[Gets the website configuration for an S3 bucket.]
// snippet-keyword:[Amazon Simple Storage Service]
// snippet-keyword:[Amazon S3]
// snippet-keyword:[GetBucketWebsite function]
// snippet-keyword:[Go]
// snippet-sourcesyntax:[go]
// snippet-service:[s3]
// snippet-keyword:[Code Sample]
// snippet-sourcetype:[full-example]
// snippet-sourcedate:[2018-03-16]
/*
   Copyright 2010-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This file is licensed under the Apache License, Version 2.0 (the "License").
   You may not use this file except in compliance with the License. A copy of
   the License is located at

    http://aws.amazon.com/apache2.0/

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
   CONDITIONS OF ANY KIND, either express or implied. See the License for the
   specific language governing permissions and limitations under the License.
*/

package main

import (
    "github.com/aws/aws-sdk-go/aws"
    "github.com/aws/aws-sdk-go/aws/awserr"
    "github.com/aws/aws-sdk-go/aws/session"
    "github.com/aws/aws-sdk-go/service/s3"
    "fmt"
    "os"
)

// Retrieves the bucket's website configuration.
//
// Usage:
//    go run s3_get_bucket_website.go BUCKET_NAME
func main() {
    if len(os.Args) != 2 {
        exitErrorf("bucket name required\nUsage: %s bucket_name", os.Args[0])
    }
    
    bucket := os.Args[1]

    // Initialize a session in us-west-2 that the SDK will use to load
    // credentials from the shared credentials file ~/.aws/credentials.
    sess, err := session.NewSession(&aws.Config{
        Region: aws.String("us-west-2")},
    )

    // Create S3 service client
    svc := s3.New(sess)

    // Call S3 to retrieve the website configuration for the bucket
    result, err := svc.GetBucketWebsite(&s3.GetBucketWebsiteInput{
        Bucket: aws.String(bucket),
    })
    if err != nil {
        // Check for the NoSuchWebsiteConfiguration error code telling us
        // that the bucket does not have a website configured.
        if awsErr, ok := err.(awserr.Error); ok && awsErr.Code() == "NoSuchWebsiteConfiguration" {
            exitErrorf("Bucket %s does not have website configuration\n", bucket)
        }
        exitErrorf("Unable to get bucket website config, %v", err)
    }

    // Print out the details about the bucket's website config.
    fmt.Println("Bucket Website Configuration:")
    fmt.Println(result)
}

func exitErrorf(msg string, args ...interface{}) {
    fmt.Fprintf(os.Stderr, msg+"\n", args...)
    os.Exit(1)
}
