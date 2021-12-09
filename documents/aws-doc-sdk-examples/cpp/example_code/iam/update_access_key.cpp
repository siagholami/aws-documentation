 
//snippet-sourcedescription:[update_access_keys.cpp demonstrates how to update the status of an IAM user's access key.]
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
//snippet-start:[iam.cpp.update_access_key.inc]
#include <aws/core/Aws.h>
#include <aws/iam/IAMClient.h>
#include <aws/iam/model/UpdateAccessKeyRequest.h>
#include <iostream>
//snippet-end:[iam.cpp.update_access_key.inc]

void PrintUsage()
{
    std::cout <<
        "Usage: update_access_key <user_name> <access_key_id> <Active|Inactive>"
        << std::endl;
}

/**
 * Updates the status (active/inactive) of an iam user's access key, based on
 * command line input
 */
int main(int argc, char** argv)
{
    if (argc != 4)
    {
        PrintUsage();
        return 1;
    }

    Aws::SDKOptions options;
    Aws::InitAPI(options);
    {
        Aws::String user_name(argv[1]);
        Aws::String accessKeyId(argv[2]);

        auto status =
            Aws::IAM::Model::StatusTypeMapper::GetStatusTypeForName(argv[3]);

        if (status == Aws::IAM::Model::StatusType::NOT_SET)
        {
            PrintUsage();
            return 1;
        }

        // snippet-start:[iam.cpp.update_access_key.code]
        Aws::IAM::IAMClient iam;
        Aws::IAM::Model::UpdateAccessKeyRequest request;
        request.SetUserName(user_name);
        request.SetAccessKeyId(accessKeyId);
        request.SetStatus(status);

        auto outcome = iam.UpdateAccessKey(request);
        if (outcome.IsSuccess())
        {
            std::cout << "Successfully updated status of access key " <<
                accessKeyId << " for user " << user_name << std::endl;
        }
        else
        {
            std::cout << "Error updated status of access key " << accessKeyId <<
                " for user " << user_name << ": " <<
                outcome.GetError().GetMessage() << std::endl;
        }
        // snippet-end:[iam.cpp.update_access_key.code]
    }
    Aws::ShutdownAPI(options);
    return 0;
}

