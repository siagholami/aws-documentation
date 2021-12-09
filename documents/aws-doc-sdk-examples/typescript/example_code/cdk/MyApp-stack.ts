// snippet-comment:[These are tags for the AWS doc team's sample catalog. Do not remove.]
// snippet-comment:[This goes in the lib dir.]
// snippet-comment:[This is a full sample when you include MyApp.ts, which goes in the bin dir.]
// snippet-sourceauthor:[Doug-AWS]
// snippet-sourcedescription:[MyApp-stack.ts creates a stack in a specific region with an S3 bucket with optional encrypted storage.]
// snippet-keyword:[CDK V1.0.0]
// snippet-keyword:[S3.Alarm function]
// snippet-keyword:[TypeScript]
// snippet-sourcesyntax:[javascript]
// snippet-service:[cdk]
// snippet-keyword:[Code Sample]
// snippet-sourcetype:[full-example]
// snippet-sourcedate:[2019-7-11]
// Copyright 2010-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
//
// This file is licensed under the Apache License, Version 2.0 (the "License").
// You may not use this file except in compliance with the License. A copy of the
// License is located at
//
// http://aws.amazon.com/apache2.0/
//
// This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
// OF ANY KIND, either express or implied. See the License for the specific
// language governing permissions and limitations under the License.
// snippet-start:[cdk.typescript.MyApp-stack]
import * as core from "@aws-cdk/core";
import * as s3 from "@aws-cdk/aws-s3";

interface MyStackProps extends core.StackProps {
  enc: boolean;
}

export class MyStack extends core.Stack {
  constructor(scope: core.App, id: string, props: MyStackProps) {
    super(scope, id, props);

    if (props.enc) {
      new s3.Bucket(this, "MyGroovyBucket", {
        encryption: s3.BucketEncryption.KMS_MANAGED
      });
    } else {
      new s3.Bucket(this, "MyGroovyBucket");
    }
  }
}
// snippet-end:[cdk.typescript.MyApp-stack]
