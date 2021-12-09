//snippet-sourcedescription:[ExampleConstants.cs contains definitions for constants used in Athena examples.]
//snippet-keyword:[dotnet]
//snippet-keyword:[.NET]
//snippet-sourcesyntax:[.net]
//snippet-keyword:[Code Sample]
//snippet-keyword:[Amazon Athena]
//snippet-service:[athena]
//snippet-sourcetype:[full-example]
//snippet-sourcedate:[]
//snippet-sourceauthor:[AWS]
﻿using System;

namespace AthenaSamples1
{
    class ExampleConstants
    {
        public static int CLIENT_EXECUTION_TIMEOUT = 100000;
        public static String ATHENA_OUTPUT_BUCKET = "s3://my-athena-bucket";
        // This is querying a table created by the getting started tutorial in Athena
        public static String ATHENA_SAMPLE_QUERY = "SELECT elb_name, "
		        + " count(1)"
		        + " FROM elb_logs"
		        + " Where elb_response_code = '200'"
		        + " GROUP BY elb_name"
		        + " ORDER BY 2 DESC limit 10;";
        public static long SLEEP_AMOUNT_IN_MS = 1000;
        public static String ATHENA_DEFAULT_DATABASE = "default";
    }
}
