import com.example.iam.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.iam.IamClient;
import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IAMServiceIntegrationTest {

    private static IamClient iam;
    private static String userName="";
    private static String policyName="";
    private static String roleName="";
    private static String policyARN=""; // Set in test 3
    private static String accessKey="" ;
    private static String keyId ="" ; // set in test 4
    private static String accountAlias="";

    @BeforeAll
    public static void setUp() throws IOException {

        Region region = Region.AWS_GLOBAL;
        iam =  IamClient.builder().region(region).build();

        try (InputStream input = IAMServiceIntegrationTest.class.getClassLoader().getResourceAsStream("config.properties")) {

            Properties prop = new Properties();
            prop.load(input);
            // Populate the data members required for all tests
            userName = prop.getProperty("userName");
            policyName= prop.getProperty("policyName");
            policyARN= prop.getProperty("policyARN");
            roleName=prop.getProperty("roleName");
            accountAlias=prop.getProperty("accountAlias");

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    @Order(1)
    public void whenInitializingAWSIAMService_thenNotNull() {
        assertNotNull(iam);
        System.out.printf("\n Test 1 passed");
    }

    @Test
    @Order(2)
    public void CreatUser() {

        String result = CreateUser.createIAMUser(iam, userName);
        assertTrue(!result.isEmpty());
        System.out.println("\n Test 2 passed");
    }

    @Test
    @Order(3)
    public void CreatePolicy() {

         policyARN = CreatePolicy.createIAMPolicy(iam, policyName);
         assertTrue(!policyARN.isEmpty());
         System.out.println("\n Test 3 passed");
    }

    @Test
    @Order(4)
    public void CreateAccessKey() {

        keyId = CreateAccessKey.createIAMAccessKey(iam,userName);
        assertTrue(!keyId.isEmpty());
        System.out.println("\n Test 4 passed");
    }

    @Test
    @Order(5)
    public void AttachRolePolicy() {

        try {
            //Wait 20 secs for the policy to be created - otherwise the test fails
            TimeUnit.SECONDS.sleep(20);
            AttachRolePolicy.attachIAMRolePolicy(iam, roleName, policyARN );
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        System.out.println("\n Test 5 passed");
    }

    @Test
    @Order(6)
    public void DetachRolePolicy() {

        DetachRolePolicy.detachPolicy(iam, roleName, policyARN);
        System.out.println("\n Test 6 passed");
    }

    @Test
    @Order(7)
    public void GetPolicy() {

        GetPolicy.getIAMPolicy(iam, policyARN);
        System.out.println("\n Test 7 passed");
    }

    @Test
    @Order(8)
    public void ListAccessKeys() {

        ListAccessKeys.listKeys(iam,userName);
        System.out.println("\n Test 8 passed");
    }

    @Test
    @Order(9)
    public void ListUsers() {

       ListUsers.listAllUsers(iam);
       System.out.println("\n Test 9 passed");
   }

    @Test
    @Order(10)
   public void CreateAccountAlias() {

       CreateAccountAlias.createIAMAccountAlias(iam, accountAlias);
       System.out.println("\n Test 10 passed");
    }

    @Test
    @Order(11)
    public void DeleteAccountAlias() {

        DeleteAccountAlias.deleteIAMAccountAlias(iam, accountAlias);
        System.out.println("\n Test 11 passed");
    }

    @Test
    @Order(12)
    public void DeletePolicy() {

       DeletePolicy.deleteIAMPolicy(iam, policyARN);
       System.out.println("\n Test 12 passed");
    }

    @Test
    @Order(13)
   public void DeleteAccessKey() {

       DeleteAccessKey.deleteKey(iam, userName, keyId);
       System.out.println("\n Test 13 passed");
   }

    @Test
    @Order(14)
    public void DeleteUser() {

        DeleteUser.deleteIAMUser(iam,userName);
        System.out.println("\n Test 14 passed");
    }
}
