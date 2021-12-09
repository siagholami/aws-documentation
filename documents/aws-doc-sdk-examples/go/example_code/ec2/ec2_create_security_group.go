// snippet-comment:[These are tags for the AWS doc team's sample catalog. Do not remove.]
// snippet-sourceauthor:[Doug-AWS]
// snippet-sourcedescription:[Creates an EC2 security group.]
// snippet-keyword:[Amazon Elastic Compute Cloud]
// snippet-keyword:[AuthorizeSecurityGroupIngress function]
// snippet-keyword:[CreateSecurityGroup function]
// snippet-keyword:[DescribeVpcs function]
// snippet-keyword:[Go]
// snippet-sourcesyntax:[go]
// snippet-service:[ec2]
// snippet-keyword:[Code Sample]
// snippet-sourcetype:[full-example]
// snippet-sourcedate:[2020-1-6]
/*
   Copyright 2010-2020 Amazon.com, Inc. or its affiliates. All Rights Reserved.

   This file is licensed under the Apache License, Version 2.0 (the "License").
   You may not use this file except in compliance with the License. A copy of
   the License is located at

    http://aws.amazon.com/apache2.0/

   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
   CONDITIONS OF ANY KIND, either express or implied. See the License for the
   specific language governing permissions and limitations under the License.
*/
// snippet-start:[ec2.go.create_security_group.complete]
package main

// snippet-start:[ec2.go.create_security_group.imports]
import (
    "flag"
    "fmt"
    "os"

    "github.com/aws/aws-sdk-go/aws"
    "github.com/aws/aws-sdk-go/aws/awserr"
    "github.com/aws/aws-sdk-go/aws/session"
    "github.com/aws/aws-sdk-go/service/ec2"
)
// snippet-end:[ec2.go.create_security_group.imports]

// Creates a new security group with the given name and description for
// open port 80 and 22 access. Associating the security group with the
// first VPC in the account if a VPC ID is not provided.
//
// Usage:
//    go run ec2_describe_security_groups.go -n name -d description -vpc vpcID
func main() {
    // snippet-start:[ec2.go.create_security_group.vars]
    namePtr := flag.String("n", "", "Group Name")
    descPtr := flag.String("d", "", "Group Description")
    vpcIDPtr := flag.String("vpc", "", "(Optional) VPC ID to associate security group with")

    flag.Parse()

    if *namePtr == "" || *descPtr == "" {
        flag.PrintDefaults()
        exitErrorf("Group name and description require")
    }
    // snippet-end:[ec2.go.create_security_group.vars]

    // Initialize a session that the SDK will use to load
    // credentials from the shared credentials file ~/.aws/credentials.
    // snippet-start:[ec2.go.create_security_group.session]
    sess := session.Must(session.NewSessionWithOptions(session.Options{
        SharedConfigState: session.SharedConfigEnable,
    }))

    svc := ec2.New(sess)
    // snippet-end:[ec2.go.create_security_group.session]

    // If the VPC ID wasn't provided in the CLI retrieve the first in the account.
    // snippet-start:[ec2.go.create_security_group.vpcid]
    if *vpcIDPtr == "" {
        // Get a list of VPCs so we can associate the group with the first VPC.
        result, err := svc.DescribeVpcs(nil)
        if err != nil {
            exitErrorf("Unable to describe VPCs, %v", err)
        }
        if len(result.Vpcs) == 0 {
            exitErrorf("No VPCs found to associate security group with.")
        }

        *vpcIDPtr = aws.StringValue(result.Vpcs[0].VpcId)
    }
    // snippet-end:[ec2.go.create_security_group.vpcid]

    // Create the security group with the VPC, name and description.
    // snippet-start:[ec2.go.create_security_group.create]
    createRes, err := svc.CreateSecurityGroup(&ec2.CreateSecurityGroupInput{
        GroupName:   aws.String(*namePtr),
        Description: aws.String(*descPtr),
        VpcId:       aws.String(*vpcIDPtr),
    })
    if err != nil {
        if aerr, ok := err.(awserr.Error); ok {
            switch aerr.Code() {
            case "InvalidVpcID.NotFound":
                exitErrorf("Unable to find VPC with ID %q.", *vpcIDPtr)
            case "InvalidGroup.Duplicate":
                exitErrorf("Security group %q already exists.", *namePtr)
            }
        }
        exitErrorf("Unable to create security group %q, %v", *namePtr, err)
    }

    fmt.Printf("Created security group %s with VPC %s.\n",
        aws.StringValue(createRes.GroupId), *vpcIDPtr)
    // snippet-end:[ec2.go.create_security_group.create]
    
    // Add permissions to the security group
    // snippet-start:[ec2.go.create_security_group.permissions]
    _, err = svc.AuthorizeSecurityGroupIngress(&ec2.AuthorizeSecurityGroupIngressInput{
        GroupName: aws.String(*namePtr),
        IpPermissions: []*ec2.IpPermission{
            // Can use setters to simplify seting multiple values without the
            // needing to use aws.String or associated helper utilities.
            (&ec2.IpPermission{}).
                SetIpProtocol("tcp").
                SetFromPort(80).
                SetToPort(80).
                SetIpRanges([]*ec2.IpRange{
                    {CidrIp: aws.String("0.0.0.0/0")},
                }),
            (&ec2.IpPermission{}).
                SetIpProtocol("tcp").
                SetFromPort(22).
                SetToPort(22).
                SetIpRanges([]*ec2.IpRange{
                    (&ec2.IpRange{}).
                        SetCidrIp("0.0.0.0/0"),
                }),
        },
    })
    if err != nil {
        exitErrorf("Unable to set security group %q ingress, %v", *namePtr, err)
    }

    fmt.Println("Successfully set security group ingress")
    // snippet-end:[ec2.go.create_security_group.permissions]
}

// snippet-start:[ec2.go.create_security_group.exit]
func exitErrorf(msg string, args ...interface{}) {
    fmt.Fprintf(os.Stderr, msg+"\n", args...)
    os.Exit(1)
}
// snippet-end:[ec2.go.create_security_group.exit]
// snippet-end:[ec2.go.create_security_group.complete]
