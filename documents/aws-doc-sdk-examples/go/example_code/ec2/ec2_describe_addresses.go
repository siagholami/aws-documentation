// snippet-comment:[These are tags for the AWS doc team's sample catalog. Do not remove.]
// snippet-sourceauthor:[Doug-AWS]
// snippet-sourcedescription:[Describe your Amazon EC2 instance IP addresses.]
// snippet-keyword:[Amazon Elastic Compute Cloud]
// snippet-keyword:[DescribeAddresses function]
// snippet-keyword:[Go]
// snippet-sourcesyntax:[go]
// snippet-service:[ec2]
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
    "github.com/aws/aws-sdk-go/service/ec2"
)

// Prints out the Elastic IP Addresses for the account's VPC.
//
// Usage:
//    go run ec2_describe_addresses.go 
func main() {
    // Initialize a session in us-west-2 that the SDK will use to load
    // credentials from the shared credentials file ~/.aws/credentials.
    sess, err := session.NewSession(&aws.Config{
        Region: aws.String("us-west-2")},
    )

    // Create an EC2 service client.
    svc := ec2.New(sess)

    // Make the API request to EC2 filtering for the addresses in the
    // account's VPC.
    result, err := svc.DescribeAddresses(&ec2.DescribeAddressesInput{
        Filters: []*ec2.Filter{
            {
                Name:   aws.String("domain"),
                Values: aws.StringSlice([]string{"vpc"}),
            },
        },
    })
    if err != nil {
        exitErrorf("Unable to elastic IP address, %v", err)
    }

    // Printout the IP addresses if there are any.
    if len(result.Addresses) == 0 {
        fmt.Printf("No elastic IPs for %s region\n", *svc.Config.Region)
    } else {
        fmt.Println("Elastic IPs")
        for _, addr := range result.Addresses {
            fmt.Println("*", fmtAddress(addr))
        }
    }
}

func fmtAddress(addr *ec2.Address) string {
    out := fmt.Sprintf("IP: %s,  allocation id: %s",
        aws.StringValue(addr.PublicIp), aws.StringValue(addr.AllocationId))
    if addr.InstanceId != nil {
        out += fmt.Sprintf(", instance-id: %s", *addr.InstanceId)
    }
    return out
}

func exitErrorf(msg string, args ...interface{}) {
    fmt.Fprintf(os.Stderr, msg+"\n", args...)
    os.Exit(1)
}
