 
//snippet-sourcedescription:[start_stop_instance.cpp demonstrates how to start and stop an Amazon EC2 instance.]
//snippet-keyword:[C++]
//snippet-sourcesyntax:[cpp]
//snippet-keyword:[Code Sample]
//snippet-keyword:[Amazon EC2]
//snippet-service:[ec2]
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
//snippet-start:[ec2.cpp.start_instance.inc]
#include <aws/core/Aws.h>
#include <aws/ec2/EC2Client.h>
#include <aws/ec2/model/StartInstancesRequest.h>
#include <aws/ec2/model/StartInstancesResponse.h>
//snippet-end:[ec2.cpp.start_instance.inc]
//snippet-start:[ec2.cpp.stop_instance.inc]
#include <aws/ec2/model/StopInstancesRequest.h>
#include <aws/ec2/model/StopInstancesResponse.h>
//snippet-end:[ec2.cpp.stop_instance.inc]
#include <iostream>

void StartInstance(const Aws::String& instance_id)
{
    // snippet-start:[ec2.cpp.start_instance.code]
    Aws::EC2::EC2Client ec2;

    Aws::EC2::Model::StartInstancesRequest start_request;
    start_request.AddInstanceIds(instance_id);
    start_request.SetDryRun(true);

    auto dry_run_outcome = ec2.StartInstances(start_request);
    assert(!dry_run_outcome.IsSuccess());
    if (dry_run_outcome.GetError().GetErrorType() !=
        Aws::EC2::EC2Errors::DRY_RUN_OPERATION)
    {
        std::cout << "Failed dry run to start instance " << instance_id << ": "
            << dry_run_outcome.GetError().GetMessage() << std::endl;
        return;
    }

    start_request.SetDryRun(false);
    auto start_instancesOutcome = ec2.StartInstances(start_request);

    if (!start_instancesOutcome.IsSuccess())
    {
        std::cout << "Failed to start instance " << instance_id << ": " <<
            start_instancesOutcome.GetError().GetMessage() << std::endl;
    }
    else
    {
        std::cout << "Successfully started instance " << instance_id <<
            std::endl;
    }
    // snippet-end:[ec2.cpp.start_instance.code]
}

void StopInstance(const Aws::String& instance_id)
{
    // snippet-start:[ec2.cpp.stop_instance.code]
    Aws::EC2::EC2Client ec2;
    Aws::EC2::Model::StopInstancesRequest request;
    request.AddInstanceIds(instance_id);
    request.SetDryRun(true);

    auto dry_run_outcome = ec2.StopInstances(request);
    assert(!dry_run_outcome.IsSuccess());

    if (dry_run_outcome.GetError().GetErrorType() !=
        Aws::EC2::EC2Errors::DRY_RUN_OPERATION)
    {
        std::cout << "Failed dry run to stop instance " << instance_id << ": "
            << dry_run_outcome.GetError().GetMessage() << std::endl;
        return;
    }

    request.SetDryRun(false);
    auto outcome = ec2.StopInstances(request);
    if (!outcome.IsSuccess())
    {
        std::cout << "Failed to stop instance " << instance_id << ": " <<
            outcome.GetError().GetMessage() << std::endl;
    }
    else
    {
        std::cout << "Successfully stopped instance " << instance_id <<
            std::endl;
    }
    // snippet-end:[ec2.cpp.stop_instance.code]
}

void PrintUsage()
{
    std::cout << "Usage: start_stop_instance <instance_id> <start|stop>" <<
        std::endl;
}

/**
 * Stops or starts an ec2 instance based on command line input
 */
int main(int argc, char** argv)
{
    if (argc != 3)
    {
        PrintUsage();
        return 1;
    }

    Aws::SDKOptions options;
    Aws::InitAPI(options);
    {
        Aws::String instance_id = argv[1];

        bool start_instance;
        if (Aws::Utils::StringUtils::CaselessCompare(argv[2], "start"))
        {
            start_instance = true;
        }
        else if (Aws::Utils::StringUtils::CaselessCompare(argv[2], "stop"))
        {
            start_instance = false;
        }
        else
        {
            PrintUsage();
            return 1;
        }

        if (start_instance)
        {
            StartInstance(instance_id);
        }
        else
        {
            StopInstance(instance_id);
        }
    }
    Aws::ShutdownAPI(options);
    return 0;
}

