 
//snippet-sourcedescription:[delete_account_alias.cpp demonstrates how to delete an alias for an AWS account.]
//snippet-keyword:[C++]
//snippet-sourcesyntax:[cpp]
//snippet-keyword:[Code Sample]
//snippet-keyword:[AWS Identity and Access Management (IAM)]
//snippet-service:[iam]
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
//snippet-start:[iam.cpp.delete_account_alias.inc]
#include <aws/core/Aws.h>
#include <aws/iam/IAMClient.h>
#include <aws/iam/model/DeleteAccountAliasRequest.h>
#include <iostream>
//snippet-end:[iam.cpp.delete_account_alias.inc]

/**
 * Deletes an alias from an AWS account, based on command line input
 */
int main(int argc, char** argv)
{
    if (argc != 2)
    {
        std::cout << "Usage: delete_account_alias <account_alias>" <<
            std::endl;
        return 1;
    }

    Aws::SDKOptions options;
    Aws::InitAPI(options);
    {
        Aws::String alias_name(argv[1]);

        // snippet-start:[iam.cpp.delete_account_alias.code]
        Aws::IAM::IAMClient iam;

        Aws::IAM::Model::DeleteAccountAliasRequest request;
        request.SetAccountAlias(alias_name);

        const auto outcome = iam.DeleteAccountAlias(request);
        if (!outcome.IsSuccess())
        {
            std::cout << "Error deleting account alias " << alias_name << ": "
                << outcome.GetError().GetMessage() << std::endl;
        }
        else
        {
            std::cout << "Successfully deleted account alias " << alias_name <<
                std::endl;
        }
        // snippet-end:[iam.cpp.delete_account_alias.code]
    }
    Aws::ShutdownAPI(options);
    return 0;
}

