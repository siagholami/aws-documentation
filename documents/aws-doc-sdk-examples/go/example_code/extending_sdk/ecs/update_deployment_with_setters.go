// snippet-comment:[These are tags for the AWS doc team's sample catalog. Do not remove.]
// snippet-sourceauthor:[Doug-AWS]
// snippet-sourcedescription:[update_deployment_with_setters.go uses chainable setters on nested fields in an API operation request.]
// snippet-keyword:[Extending the SDK]
// snippet-keyword:[UpdateService function]
// snippet-keyword:[Go]
// snippet-sourcesyntax:[go]
// snippet-service:[aws-go-sdk]
// snippet-sourcetype:[full-example]
// snippet-sourcedate:[2019-03-22]
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
//snippet-start:[s3.go.update_deployment]
package main

import (
    "github.com/aws/aws-sdk-go/aws/session"
    "github.com/aws/aws-sdk-go/service/ecs"

    "fmt"
)

func main() {
    sess := session.Must(session.NewSessionWithOptions(session.Options{
        SharedConfigState: session.SharedConfigEnable,
    }))

    svc := ecs.New(sess)

    //snippet-start:[s3.go.update_deployment.call]
    resp, err := svc.UpdateService((&ecs.UpdateServiceInput{}).
        SetService("myService").
        SetDeploymentConfiguration((&ecs.DeploymentConfiguration{}).
            SetMinimumHealthyPercent(80),
        ),
    )
    //snippet-end:[s3.go.update_deployment.call]
    if err != nil {
        fmt.Println("Error calling UpdateService:")
        fmt.Println(err.Error())
    } else {
        fmt.Println(resp)
    }
}
//snippet-end:[s3.go.update_deployment]
