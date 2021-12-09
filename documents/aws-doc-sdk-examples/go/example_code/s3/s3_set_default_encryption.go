// snippet-comment:[These are tags for the AWS doc team's sample catalog. Do not remove.]
// snippet-sourceauthor:[Doug-AWS]
// snippet-sourcedescription:[Enables KMS server-side encryption on any objects added to to an S3 bucket.]
// snippet-keyword:[Amazon Simple Storage Service]
// snippet-keyword:[Amazon S3]
// snippet-keyword:[PutBucketEncryption function]
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
    "github.com/aws/aws-sdk-go/aws/session"
    "github.com/aws/aws-sdk-go/service/s3"

    "fmt"
    "os"
)

func main() {
    if len(os.Args) != 2 {
        fmt.Println("You must supply a key")
        os.Exit(1)
    }

    key := os.Args[1]
    bucket := "myBucket"

    // Initialize a session that the SDK uses to load
    // credentials from the shared credentials file ~/.aws/credentials
    // and configuration from the shared configuration file ~/.aws/config.
    sess := session.Must(session.NewSessionWithOptions(session.Options{
        SharedConfigState: session.SharedConfigEnable,
    }))

    svc := s3.New(sess)

    // Encrypt with KMS by default
    defEnc := &s3.ServerSideEncryptionByDefault{KMSMasterKeyID: aws.String(key), SSEAlgorithm: aws.String(s3.ServerSideEncryptionAwsKms)}
    rule := &s3.ServerSideEncryptionRule{ApplyServerSideEncryptionByDefault: defEnc}
    rules := []*s3.ServerSideEncryptionRule{rule}
    serverConfig := &s3.ServerSideEncryptionConfiguration{Rules: rules}
    input := &s3.PutBucketEncryptionInput{Bucket: aws.String(bucket), ServerSideEncryptionConfiguration: serverConfig}

    _, err := svc.PutBucketEncryption(input)
    if err != nil {
        fmt.Println("Got an error adding default KMS encryption to bucket", bucket)
        fmt.Println(err.Error())
        os.Exit(1)
    }

    fmt.Println("Bucket " + bucket + " now has KMS encryption by default")
}
