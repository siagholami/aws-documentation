//snippet-sourcedescription:[DescribeAccountAttributes.java demonstrates how to retrieve attributes that belong to an Amazon RDS account.]
////snippet-keyword:[SDK for Java 2.0]
//snippet-keyword:[Code Sample]
//snippet-service:[Amazon Relational Database Service]
//snippet-sourcetype:[full-example]
//snippet-sourcedate:[7/6/2020]
//snippet-sourceauthor:[scmacdon - aws]

/*
   Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
   This file is licensed under the Apache License, Version 2.0 (the "License").
   You may not use this file except in compliance with the License. A copy of
   the License is located at
    http://aws.amazon.com/apache2.0/
   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
   CONDITIONS OF ANY KIND, either express or implied. See the License for the
   specific language governing permissions and limitations under the License.
*/

package com.example.rds;

// snippet-start:[rds.java2.describe_account.import]
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.rds.RdsClient;
import software.amazon.awssdk.services.rds.model.AccountQuota;
import software.amazon.awssdk.services.rds.model.DescribeAccountAttributesRequest;
import software.amazon.awssdk.services.rds.model.RdsException;
import software.amazon.awssdk.services.rds.model.DescribeAccountAttributesResponse;
import java.util.List;
// snippet-end:[rds.java2.describe_account.import]

public class DescribeAccountAttributes {

    public static void main(String[] args) {

        Region region = Region.US_WEST_2;
        RdsClient rdsClient = RdsClient.builder()
                .region(region)
                .build();

        getAccountAttributes(rdsClient) ;
    }

    // snippet-start:[rds.java2.describe_account.main]
    public static void getAccountAttributes(RdsClient rdsClient) {

    try {
        DescribeAccountAttributesRequest accountAttributesRequest = DescribeAccountAttributesRequest.builder()
            .build();

        DescribeAccountAttributesResponse response = rdsClient.describeAccountAttributes();

        List<AccountQuota> quotasList = response.accountQuotas();

        for (AccountQuota quotas: quotasList) {
            System.out.println("Name is: "+quotas.accountQuotaName());
            System.out.println("Max value is " +quotas.max());
        }

    } catch (RdsException e) {
        System.out.println(e.getLocalizedMessage());
        System.exit(1);
    }
        // snippet-end:[rds.java2.describe_account.main]
   }
 }
