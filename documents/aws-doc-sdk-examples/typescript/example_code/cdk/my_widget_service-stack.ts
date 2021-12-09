// snippet-comment:[These are tags for the AWS doc team's sample catalog. Do not remove.]
// snippet-comment:[This should be in the bin/ directory]
// snippet-comment:[and only works with widget_service.ts in the lib/ directory]
// snippet-comment:[and widgets.js in the resources/ directory.]
// snippet-sourceauthor:[Doug-AWS]
// snippet-sourcedescription:[Creates a stack for the WidgetService.]
// snippet-keyword:[CDK V1.0.0]
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
// snippet-start:[cdk.typescript.my_widget_service-stack]
import * as core from '@aws-cdk/core';
// snippet-start:[cdk.typescript.my_widget_service-stack.import]
import * as widget_service from '../lib/widget_service';
// snippet-end:[cdk.typescript.my_widget_service-stack.import]

export class MyWidgetServiceStack extends core.Stack {
  constructor(scope: core.App, id: string, props?: core.StackProps) {
    super(scope, id, props);

    // snippet-start:[cdk.typescript.my_widget_service-stack.new_widget_service]
    new widget_service.WidgetService(this, 'Widgets');
    // snippet-end:[cdk.typescript.my_widget_service-stack.new_widget_service]
  }
}
// snippet-end:[cdk.typescript.my_widget_service-stack]
