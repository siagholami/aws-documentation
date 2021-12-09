 
//snippet-sourcedescription:[get_queue_url.cpp demonstrates how to retrieve the URL of an Amazon SQS queue.]
//snippet-keyword:[C++]
//snippet-sourcesyntax:[cpp]
//snippet-keyword:[Code Sample]
//snippet-keyword:[Amazon Simple Queue Service]
//snippet-service:[sqs]
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
//snippet-start:[sqs.cpp.get_queue_url.inc]
#include <aws/core/Aws.h>
#include <aws/sqs/SQSClient.h>
#include <aws/sqs/model/GetQueueUrlRequest.h>
#include <aws/sqs/model/GetQueueUrlResult.h>
#include <iostream>
//snippet-end:[sqs.cpp.get_queue_url.inc]

/**
 * Gets the url associated with an sqs queue based on command line input
 */
int main(int argc, char** argv)
{
    if (argc != 2) {
        std::cout << "Usage: get_queue_url <queue_name>" << std::endl;
        return 1;
    }

    Aws::SDKOptions options;
    Aws::InitAPI(options);
    {
        Aws::String queue_name = argv[1];

        // snippet-start:[sqs.cpp.get_queue_url.code]
        Aws::SQS::SQSClient sqs;

        Aws::SQS::Model::GetQueueUrlRequest gqu_req;
        gqu_req.SetQueueName(queue_name);

        auto gqu_out = sqs.GetQueueUrl(gqu_req);
        if (gqu_out.IsSuccess()) {
            std::cout << "Queue " << queue_name << " has url " <<
            gqu_out.GetResult().GetQueueUrl() << std::endl;
        } else {
            std::cout << "Error getting url for queue " << queue_name << ": " <<
                gqu_out.GetError().GetMessage() << std::endl;
        }
        // snippet-end:[sqs.cpp.get_queue_url.code]
    }
    Aws::ShutdownAPI(options);
    return 0;
}

