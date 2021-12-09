 
//snippet-sourcedescription:[delete_branch.cpp demonstrates how to delete a repository branch using AWS CodeCommit.]
//snippet-keyword:[C++]
//snippet-sourcesyntax:[cpp]
//snippet-keyword:[Code Sample]
//snippet-keyword:[AWS CodeCommit]
//snippet-service:[codecommit]
//snippet-sourcetype:[full-example]
//snippet-sourcedate:[]
//snippet-sourceauthor:[tapasweni-pathak]


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

#include <aws/core/Aws.h>
#include <aws/core/utils/Outcome.h>
#include <aws/codecommit/CodeCommitClient.h>
#include <aws/codecommit/model/DeleteBranchRequest.h>
#include <aws/codecommit/model/DeleteBranchResult.h>
#include <aws/codecommit/model/RepositoryMetadata.h>
#include <iostream>

/**
 * Deletes a branch of repository based on command line inputs
 */

int main(int argc, char ** argv)
{
  if (argc != 3)
  {
    std::cout << "Usage: delete_branch <repository_name> <branch_name>"
              << std::endl;
    return 1;
  }

  Aws::SDKOptions options;
  Aws::InitAPI(options);
  {
    Aws::String repository_name(argv[1]);
    Aws::String branch_name(argv[2]);

    Aws::CodeCommit::CodeCommitClient codecommit;

    Aws::CodeCommit::Model::DeleteBranchRequest db_req;

    db_req.SetRepositoryName(repository_name);
    db_req.SetBranchName(branch_name);

    auto db_out = codecommit.DeleteBranch(db_req);

    if (db_out.IsSuccess())
    {
      std::cout << "Successfully deleted branch from repository" << std::endl;
    }
    else
    {
      std::cout << "Error deleting branch" << db_out.GetError().GetMessage()
                << std::endl;
    }
  }

  Aws::ShutdownAPI(options);
  return 0;
}
