 
//snippet-sourcedescription:[send_message.cpp demonstrates how to deliver a message to an Amazon SQS queue.]
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
//snippet-start:[sqs.cpp.send_message.inc]
#include <aws/core/Aws.h>
#include <aws/sqs/SQSClient.h>
#include <aws/sqs/model/SendMessageRequest.h>
#include <aws/sqs/model/SendMessageResult.h>
#include <iostream>
//snippet-end:[sqs.cpp.send_message.inc]

/**
 * Sends a message to an sqs queue based on command line input
 */
int main(int argc, char** argv)
{
    if (argc != 3)
    {
        std::cout << "Usage: send_message <queue_url> <message_body>" <<
            std::endl;
        return 1;
    }

    Aws::SDKOptions options;
    Aws::InitAPI(options);
    {
        Aws::String queue_url = argv[1];
        Aws::String msg_body = argv[2];

        // snippet-start:[sqs.cpp.send_message.code]
        Aws::SQS::SQSClient sqs;

        Aws::SQS::Model::SendMessageRequest sm_req;
        sm_req.SetQueueUrl(queue_url);
        sm_req.SetMessageBody(msg_body);

        auto sm_out = sqs.SendMessage(sm_req);
        if (sm_out.IsSuccess())
        {
            std::cout << "Successfully sent message to " << queue_url <<
                std::endl;
        }
        else
        {
            std::cout << "Error sending message to " << queue_url << ": " <<
                sm_out.GetError().GetMessage() << std::endl;
        }
        // snippet-end:[sqs.cpp.send_message.code]
    }
    Aws::ShutdownAPI(options);
    return 0;
}

