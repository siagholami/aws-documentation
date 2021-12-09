 
//snippet-sourcedescription:[list_tables.cpp demonstrates how to list all Amazon DynamoDB tables for an AWS account.]
//snippet-keyword:[C++]
//snippet-sourcesyntax:[cpp]
//snippet-keyword:[Code Sample]
//snippet-keyword:[Amazon DynamoDB]
//snippet-service:[dynamodb]
//snippet-sourcetype:[full-example]
//snippet-sourcedate:[]
//snippet-sourceauthor:[AWS]


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
//snippet-start:[dynamodb.cpp.list_tables.inc]
#include <aws/core/Aws.h>
#include <aws/core/utils/Outcome.h> 
#include <aws/dynamodb/DynamoDBClient.h>
#include <aws/dynamodb/model/ListTablesRequest.h>
#include <aws/dynamodb/model/ListTablesResult.h>
#include <iostream>
//snippet-end:[dynamodb.cpp.list_tables.inc]


/**
* List DynamoDB tables for the current AWS account.
*
* This code expects that you have AWS credentials set up per:
* http://docs.aws.amazon.com/sdk-for-cpp/v1/developer-guide/credentials.html
*/
int main(int argc, char** argv)
{
    std::cout << "Your DynamoDB Tables:" << std::endl;

    Aws::SDKOptions options;

    Aws::InitAPI(options);
    {
        // snippet-start:[dynamodb.cpp.list_tables.code]
        Aws::Client::ClientConfiguration clientConfig;
        Aws::DynamoDB::DynamoDBClient dynamoClient(clientConfig);

        Aws::DynamoDB::Model::ListTablesRequest ltr;
        ltr.SetLimit(50);
        do
        {
            const Aws::DynamoDB::Model::ListTablesOutcome& lto = dynamoClient.ListTables(ltr);
            if (!lto.IsSuccess())
            {
                std::cout << "Error: " << lto.GetError().GetMessage() << std::endl;
                return 1;
            }
            for (const auto& s : lto.GetResult().GetTableNames())
                std::cout << s << std::endl;
            ltr.SetExclusiveStartTableName(lto.GetResult().GetLastEvaluatedTableName());
        } while (!ltr.GetExclusiveStartTableName().empty());
        // snippet-end:[dynamodb.cpp.list_tables.code]
    }
    Aws::ShutdownAPI(options);
    return 0;
}