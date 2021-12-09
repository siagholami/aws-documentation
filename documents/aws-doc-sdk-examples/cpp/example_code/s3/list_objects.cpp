// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX - License - Identifier: Apache - 2.0

//snippet-start:[s3.cpp.list_objects.inc]
#include <iostream>
#include <aws/core/Aws.h>
#include <aws/s3/S3Client.h>
#include <aws/s3/model/ListObjectsRequest.h>
#include <aws/s3/model/Object.h>
#include <awsdoc/s3/s3_examples.h>
//snippet-end:[s3.cpp.list_objects.inc]

/* ////////////////////////////////////////////////////////////////////////////
 * Purpose: Lists all available object names for an Amazon S3 bucket.
 *
 * Prerequisites: A bucket containing at least one object.
 *
 * Inputs:
 * - bucketName: The name of the bucket containing the objects.
 * - region: The AWS Region for the bucket.
 *
 * Outputs: true if the list of available object names was retrieved;
 * otherwise, false.
 * ///////////////////////////////////////////////////////////////////////// */

// snippet-start:[s3.cpp.list_objects.code]
bool AwsDoc::S3::ListObjects(const Aws::String& bucketName, 
    const Aws::String& region)
{
    Aws::Client::ClientConfiguration config;

    if (!region.empty())
    {
        config.region = region;
    }

    Aws::S3::S3Client s3_client(config);

    Aws::S3::Model::ListObjectsRequest request;
    request.WithBucket(bucketName);

    auto outcome = s3_client.ListObjects(request);

    if (outcome.IsSuccess())
    {
        std::cout << "Objects in bucket '" << bucketName << "':" 
            << std::endl << std::endl;

        Aws::Vector<Aws::S3::Model::Object> objects =
            outcome.GetResult().GetContents();

        for (Aws::S3::Model::Object& object : objects)
        {
            std::cout << object.GetKey() << std::endl;
        }

        return true;
    }
    else
    {
        std::cout << "Error: ListObjects: " <<
            outcome.GetError().GetMessage() << std::endl;

        return false;
    }
}

int main()
{
    Aws::SDKOptions options;
    Aws::InitAPI(options);
    {
        Aws::String bucket_name = "my-bucket";
        Aws::String region = "us-east-1";

        if (!AwsDoc::S3::ListObjects(bucket_name, region))
        {
            return 1;
        }
        
    }
    Aws::ShutdownAPI(options);

    return 0;
}
// snippet-end:[s3.cpp.list_objects.code]
