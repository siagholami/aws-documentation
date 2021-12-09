 
//snippet-sourcedescription:[describe_key_pairs.cpp demonstrates how to retrieve information about Amazon EC2 key pairs.]
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
//snippet-start:[ec2.cpp.describe_key_pairs.inc]
#include <aws/core/Aws.h>
#include <aws/ec2/EC2Client.h>
#include <aws/ec2/model/DescribeKeyPairsRequest.h>
#include <aws/ec2/model/DescribeKeyPairsResponse.h>
#include <iomanip>
#include <iostream>
//snippet-end:[ec2.cpp.describe_key_pairs.inc]

/**
 * Describes all instance key pairs
 */
int main(int argc, char** argv)
{
    Aws::SDKOptions options;
    Aws::InitAPI(options);
    {
        // snippet-start:[ec2.cpp.describe_key_pairs.code]
        Aws::EC2::EC2Client ec2;
        Aws::EC2::Model::DescribeKeyPairsRequest request;

        auto outcome = ec2.DescribeKeyPairs(request);
        if (outcome.IsSuccess())
        {
            std::cout << std::left <<
                std::setw(32) << "Name" <<
                std::setw(64) << "Fingerprint" << std::endl;

            const auto &key_pairs = outcome.GetResult().GetKeyPairs();
            for (const auto &key_pair : key_pairs)
            {
                std::cout << std::left <<
                    std::setw(32) << key_pair.GetKeyName() <<
                    std::setw(64) << key_pair.GetKeyFingerprint() << std::endl;
            }
        }
        else
        {
            std::cout << "Failed to describe key pairs:" <<
                outcome.GetError().GetMessage() << std::endl;
        }
        // snippet-end:[ec2.cpp.describe_key_pairs.code]
    }
    Aws::ShutdownAPI(options);
    return 0;
}

