import com.example.cloudwatch.DeleteAlarm;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.cloudwatch.CloudWatchClient;
import software.amazon.awssdk.services.cloudwatchevents.CloudWatchEventsClient;
import software.amazon.awssdk.services.cloudwatchlogs.CloudWatchLogsClient;
import com.example.cloudwatch.*;
import java.io.*;
import java.util.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CloudWatchServiceIntegrationTest {

    private static CloudWatchClient cw ;
    private static CloudWatchLogsClient cloudWatchLogsClient ;
    private static CloudWatchEventsClient cwe;
    private static String logGroup="";
    private static String alarmName="";
    private static String streamName ="";
    private static String metricId = "";
    private static String instanceId="";
    private static String ruleResource = "";
    private static String filterName="";
    private static String destinationArn="";
    private static String roleArn ="";
    private static String filterPattern = "";

    @BeforeAll
    public static void setUp() throws IOException {

        Region region = Region.US_WEST_2;;
        cw = CloudWatchClient.builder()
                .region(region)
                .build();

        cloudWatchLogsClient = CloudWatchLogsClient.builder()
                .region(region)
                .build();

        cwe = CloudWatchEventsClient.builder()
                        .region(region)
                        .build();

        try (InputStream input = CloudWatchServiceIntegrationTest.class.getClassLoader().getResourceAsStream("config.properties")) {

            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }

            //load a properties file from class path, inside static method
            prop.load(input);

            // Populate the data members required for all tests
            logGroup = prop.getProperty("logGroup");
            alarmName = prop.getProperty("alarmName");
            streamName = prop.getProperty("streamName");
            ruleResource = prop.getProperty("ruleResource");
            metricId = prop.getProperty("metricId");
            filterName = prop.getProperty("filterName");
            destinationArn = prop.getProperty("destinationArn");
            roleArn= prop.getProperty("roleArn");
            filterPattern= prop.getProperty("filterPattern");
            instanceId= prop.getProperty("instanceId");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    @Order(1)
    public void whenInitializingAWSCWService_thenNotNull() {
        assertNotNull(cw);
        assertNotNull(cloudWatchLogsClient);
        System.out.printf("\n Test 1 passed");
    }

    @Test
    @Order(2)
    public void CreateAlarm() {

        PutMetricAlarm.putMetricAlarm(cw,alarmName,instanceId );
        System.out.printf("\n Test 2 passed");
    }

    @Test
    @Order(3)
    public void DescribeAlarms() {

       DescribeAlarms.deleteCWAlarms(cw);
       System.out.printf("\n Test 3 passed");
    }

    @Test
    @Order(4)
    public void CreateSubscriptionFilters() {

       PutSubscriptionFilter.putSubFilters(cloudWatchLogsClient, filterName, filterPattern, logGroup, roleArn, destinationArn);
       System.out.printf("\n Test 4 passed");
    }

    @Test
    @Order(5)
    public void DescribeSubscriptionFilters() {

       DescribeSubscriptionFilters.describeFilters(cloudWatchLogsClient,logGroup);
       System.out.printf("\n Test 5 passed");
    }


    @Test
    @Order(6)
    public void DisableAlarmActions() {

      DisableAlarmActions.disableActions(cw, alarmName);
      System.out.println("\n Test 6 passed");
    }

    @Test
    @Order(7)
    public void EnableAlarmActions() {

      EnableAlarmActions.enableActions(cw, alarmName) ;
      System.out.println("\n Test 7 passed");
    }

    @Test
    @Order(8)
    public void GetLogEvents() {

        GetLogEvents.getCWLogEvebts(cloudWatchLogsClient,logGroup,streamName);
        System.out.println("\n Test 8 passed");
    }

    @Test
    @Order(9)
    void PutCloudWatchEvent() {

       PutEvents.putCWEvents(cwe,ruleResource );
       System.out.println("\n Test 9 passed");
    }

    @Test
    @Order(10)
    public void GetMetricData() {

      GetMetricData.getMetData(cw);
      System.out.println("\n Test 10 passed");
    }

    @Test
    @Order(11)
    public void DeleteSubscriptionFilter() {

        DeleteSubscriptionFilter.deleteSubFilter(cloudWatchLogsClient, filterName,logGroup );
        System.out.println("\n Test 11 passed");
    }

    @Test
    @Order(12)
    public void DeleteAlarm() {

      DeleteAlarm.deleteCWAlarm(cw, alarmName);
      System.out.println("\n Test 12 passed");
    }
}
