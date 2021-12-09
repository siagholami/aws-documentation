// snippet-comment:[These are tags for the AWS doc team's sample catalog. Do not remove.]
// snippet-sourceauthor:[Doug-AWS]
// snippet-sourcedescription:[Lists the valid SES email addresses.]
// snippet-keyword:[Amazon Simple Email Service]
// snippet-keyword:[Amazon SES]
// snippet-keyword:[GetIdentityVerificationAttributes function]
// snippet-keyword:[ListIdentities function]
// snippet-keyword:[Go]
// snippet-sourcesyntax:[go]
// snippet-service:[ses]
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
    "fmt"
    "os"

    "github.com/aws/aws-sdk-go/aws"
    "github.com/aws/aws-sdk-go/aws/session"
    "github.com/aws/aws-sdk-go/service/ses"
)

func main() {
    // Initialize a session in us-west-2 that the SDK will use to load
    // credentials from the shared credentials file ~/.aws/credentials.
    sess, err := session.NewSession(&aws.Config{
        Region: aws.String("us-west-2")},
    )

    // Create SES service client
    svc := ses.New(sess)

    result, err := svc.ListIdentities(&ses.ListIdentitiesInput{IdentityType: aws.String("EmailAddress")})

    if err != nil {
        fmt.Println(err)
        os.Exit(1)
    }

    for _, email := range result.Identities {
        var e = []*string{email}

        verified, err := svc.GetIdentityVerificationAttributes(&ses.GetIdentityVerificationAttributesInput{Identities: e})

        if err != nil {
            fmt.Println(err)
            os.Exit(1)
        }

        for _, va := range verified.VerificationAttributes {
            if *va.VerificationStatus == "Success" {
                fmt.Println(*email)
            }
        }
    }
}
