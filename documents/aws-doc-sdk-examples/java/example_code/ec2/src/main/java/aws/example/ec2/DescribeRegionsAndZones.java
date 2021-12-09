//snippet-sourcedescription:[DescribeRegionsAndZones.java demonstrates how to get a description of all regions and zones.]
//snippet-keyword:[SDK for Java 1.0]
//snippet-sourcesyntax:[java]
//snippet-keyword:[Code Sample]
//snippet-keyword:[Amazon EC2]
//snippet-service:[ec2]
//snippet-sourcetype:[full-example]
//snippet-sourcedate:[2018-05-22]
//snippet-sourceauthor:[soo-aws]
/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package aws.example.ec2;
// snippet-start:[ec2.java1.describe_region_and_zones.import]
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.DescribeRegionsResult;
import com.amazonaws.services.ec2.model.Region;
import com.amazonaws.services.ec2.model.AvailabilityZone;
import com.amazonaws.services.ec2.model.DescribeAvailabilityZonesResult;
// snippet-end:[ec2.java1.describe_region_and_zones.import]

/**
 * Describes all regions and zones
 */
public class DescribeRegionsAndZones
{
    public static void main(String[] args)
    {
        final AmazonEC2 ec2 = AmazonEC2ClientBuilder.defaultClient();

// snippet-start:[ec2.java1.describe_region_and_zones.regions]
        DescribeRegionsResult regions_response = ec2.describeRegions();

        for(Region region : regions_response.getRegions()) {
            System.out.printf(
                "Found region %s " +
                "with endpoint %s",
                region.getRegionName(),
                region.getEndpoint());
        }
// snippet-end:[ec2.java1.describe_region_and_zones.regions]

// snippet-start:[ec2.java1.describe_region_and_zones.zones]
        DescribeAvailabilityZonesResult zones_response =
            ec2.describeAvailabilityZones();

        for(AvailabilityZone zone : zones_response.getAvailabilityZones()) {
            System.out.printf(
                "Found availability zone %s " +
                "with status %s " +
                "in region %s",
                zone.getZoneName(),
                zone.getState(),
                zone.getRegionName());
        }
// snippet-end:[ec2.java1.describe_region_and_zones.zones]
    }
}
