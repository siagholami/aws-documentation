//snippet-sourcedescription:[Upgrade AWS SDK for C++ to version 1.8 to build create_file_system_with_modeled_exception.cpp. This example demonstrates how to get modeled exception from CreateFileSystem operation outcome.]
//snippet-keyword:[C++]
//snippet-sourcesyntax:[cpp]
//snippet-keyword:[Code Sample]
//snippet-keyword:[Amazon Elastic File System]
//snippet-service:[elasticfilesystem]
//snippet-sourcetype:[full-example]
//snippet-sourcedate:[]
//snippet-sourceauthor:[AWS]

/**
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

#include <iostream>
#include <aws/core/Aws.h>
#include <aws/core/utils/Outcome.h>
#include <aws/core/utils/logging/LogLevel.h>
#include <aws/elasticfilesystem/EFSClient.h>
#include <aws/elasticfilesystem/model/CreateFileSystemRequest.h>
#include <aws/elasticfilesystem/model/DescribeFileSystemsRequest.h>
#include <aws/elasticfilesystem/model/DeleteFileSystemRequest.h>
#include <aws/elasticfilesystem/model/FileSystemAlreadyExists.h>

using namespace Aws;
using namespace Aws::Http;
using namespace Aws::Client;
using namespace Aws::EFS;
using namespace Aws::EFS::Model;

static const char FILE_SYSTEM_CREATION_TOKEN[] = "file-system-creation-token-test";

/**
 * Create file system with Elastic File System client.
 *
 * If request fails with exception FILE_SYSTEM_ALREADY_EXISTS, we can get a FileSystemAlreadyExists object
 * with createFileSystemOutcome.GetError<FileSystemAlreadyExists>(), and FileSystemId as its member.
 *
 * @param efsClient An Elastic File System client used to make request to create file systems.
 * @return Id for the file system just created, return empty string if request fails.
 */
Aws::String CreateFileSystem(const Aws::EFS::EFSClient efsClient)
{
    Aws::String fileSystemId = "";
    CreateFileSystemRequest createFileSystemRequest;
    createFileSystemRequest.SetCreationToken(FILE_SYSTEM_CREATION_TOKEN);
    auto createFileSystemOutcome = efsClient.CreateFileSystem(createFileSystemRequest);

    if (createFileSystemOutcome.IsSuccess())
    {
        fileSystemId = createFileSystemOutcome.GetResult().GetFileSystemId();
        std::cout << "Succeeded to create file system with ID: " << createFileSystemOutcome.GetResult().GetFileSystemId() << std::endl;
    }
    else if (createFileSystemOutcome.GetError().GetErrorType() == EFSErrors::FILE_SYSTEM_ALREADY_EXISTS)
    {
        std::cout << "File system with ID: " << createFileSystemOutcome.GetError<FileSystemAlreadyExists>().GetFileSystemId() << " already exists." << std::endl;
        std::cout << "Failed to create file system. Error details:" << std::endl;
        std::cout << createFileSystemOutcome.GetError() << std::endl;
    }
    else
    {
        std::cout << "Failed to create file system. Error details:" << std::endl;
        std::cout << createFileSystemOutcome.GetError() << std::endl;
    }

    return fileSystemId;
}

/**
 * With AWS SDK for C++ version 1.8, you may get more operation specific details from the exception,
 * besides general information, like error message, error type.
 * In this example, we attempt to get FileSystemId from the FileSystemAlreadyExists exception.
 */
int main(int argc, char *argv[])
{
    SDKOptions options;
    options.loggingOptions.logLevel = Utils::Logging::LogLevel::Trace;
    InitAPI(options);
    {
        Aws::EFS::EFSClient efsClient;
        std::cout << "The first request to create file system:" << std::endl;
        Aws::String fileSystemId = CreateFileSystem(efsClient);
        if (fileSystemId.empty())
        {
            ShutdownAPI(options);
            return 1;
        }

        // Wait for the new file system to be propagated and visible.
        unsigned timeoutCount = 0;
        while (timeoutCount++ < 30)
        {
            DescribeFileSystemsRequest describeFileSystemsRequest;
            describeFileSystemsRequest.SetFileSystemId(fileSystemId);
            auto describeFileSystemsOutcome = efsClient.DescribeFileSystems(describeFileSystemsRequest);
            if (describeFileSystemsOutcome.IsSuccess())
            {
                break;
            }

            std::this_thread::sleep_for(std::chrono::seconds(1));
        }

        std::cout << "\n" << "The second request to create file system with the same token:" << std::endl;
        CreateFileSystem(efsClient);

        std::cout << "\n" << "The third request to delete file system:" << std::endl;
        DeleteFileSystemRequest deleteFileSystemRequest;
        deleteFileSystemRequest.SetFileSystemId(fileSystemId);
        auto deleteFileSystemOutcome = efsClient.DeleteFileSystem(deleteFileSystemRequest);
        if (deleteFileSystemOutcome.IsSuccess())
        {
            std::cout << "Succeeded to delete file system" << std::endl;
        }
        else
        {
            std::cout << "Failed to delete file system. Error details:" << std::endl;
            std::cout << deleteFileSystemOutcome.GetError() << std::endl;
        }
    }

    ShutdownAPI(options);
    return 0;
}