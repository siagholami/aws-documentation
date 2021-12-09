// snippet-comment:[These are tags for the AWS doc team's sample catalog. Do not remove.]
// snippet-sourceauthor:[Doug-AWS]
// snippet-sourcedescription:[Lists the names of up to 100 of your AWS CodeBuild projects.]
// snippet-keyword:[AWS CodeBuild]
// snippet-keyword:[ListProjects function]
// snippet-keyword:[Go]
// snippet-sourcesyntax:[go]
// snippet-service:[codebuild]
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
    "github.com/aws/aws-sdk-go/service/codebuild"
    "fmt"
    "os"
)

// Lists a CodeBuild projects in the region configured in the shared config
func main() {
    // Initialize a session in us-west-2 that the SDK will use to load
    // credentials from the shared credentials file ~/.aws/credentials.
    sess, err := session.NewSession(&aws.Config{
        Region: aws.String("us-west-2")},
    )

    // Create CodeBuild service client
    svc := codebuild.New(sess)

    // Get the list of projects
    result, err := svc.ListProjects(
        &codebuild.ListProjectsInput{
            SortBy:    aws.String("NAME"),
            SortOrder: aws.String("ASCENDING", )})

    if err != nil {
        fmt.Println("Got error listing projects: ", err)
        os.Exit(1)
    }

    for _, p := range result.Projects {
        fmt.Println(*p)
    }
}
