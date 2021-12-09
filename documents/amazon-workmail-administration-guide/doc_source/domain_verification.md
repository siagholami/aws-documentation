# Verifying domains<a name="domain_verification"></a>

After adding a domain for Amazon WorkMail in the console, the next step is to verify the domain\. Verifying the domain confirms that you own the domain and that you are using Amazon WorkMail as the email service for the domain\.

To verify a domain with Amazon WorkMail, initiate the process using the Amazon WorkMail console\. Then add a TXT record to your DNS service as described in [Verifying domains in Amazon SES](https://docs.aws.amazon.com/ses/latest/DeveloperGuide/verify-domains.html) in the *Amazon Simple Email Service Developer Guide*\. Use the Amazon WorkMail console to verify that your DNS service is successfully updated with the TXT record for Amazon WorkMail\. For more information, see [Adding a domain](add_domain.md)\. 

You can also use `nslookup` or `dig` to confirm that your Amazon WorkMail TXT records and MX records are updated with your DNS service\.

**Topics**
+ [Verifying TXT records and MX records with your DNS service](#domain-verification-check-dns)
+ [Troubleshooting domain verification](#domain-verification-issues)

## Verifying TXT records and MX records with your DNS service<a name="domain-verification-check-dns"></a>

Confirm that the TXT record that verifies that you own the domain is added correctly to your DNS service\. This procedure uses the [nslookup](http://en.wikipedia.org/wiki/Nslookup) tool, which is available for Windows and Linux\. On Linux, you can also use [dig](http://en.wikipedia.org/wiki/Dig_(command))\.

In this procedure for the `nslookup` tool, you first find the DNS servers that serve your domain\. Then you query those servers to view the TXT records\. You query the DNS servers for your domain because those servers contain the most up\-to\-date information for your domain\. This information can take time to propagate to other DNS servers\.

**To use nslookup to verify that your TXT record is added to your DNS service**

1. Find the name servers for your domain:

   1. Open a command prompt\.

   1. Run the following command to list all of the name servers that serve your domain\.

      ```
      1. nslookup -type=NS example.com
      ```

      You query one of these name servers in the next step\.

1. Verify that the TXT record is correctly added\.

   1. Run the following command using your domain and one of the name servers that you found in step 1\.

      ```
      1. nslookup -type=TXT _amazonses.example.com ns1.name-server.net
      ```

   1. In the output of the command, verify that the string that follows `text = ` matches the TXT value you see when you select the domain in the Verified Senders list of the Amazon WorkMail console\. 

      In the example, you are looking for a TXT record under *\_amazonses\.example\.com* with a value of `fmxqxT/icOYx4aA/bEUrDPMeax9/s3frblS+niixmqk=`\. If the record is correctly updated, the command should have the following output:

      ```
      1. _amazonses.example.com text = "fmxqxT/icOYx4aA/bEUrDPMeax9/s3frblS+niixmqk="
      ```

**To use dig to verify that your TXT record is added to your DNS service**

1. Open a terminal window\.

1. Run the following command to list the TXT records for your domain\.

   ```
   1. dig +short example.com txt
   ```

1. Verify that the string that follows `TXT` matches the TXT value you see when you select the domain in the Verified Senders list of the Amazon WorkMail console\.

**To use nslookup to verify that your MX record is added to your DNS service**

1. Find the name servers for your domain:

   1. Open a command prompt\.

   1. Run the following command to list all of the name servers that serve your domain\.

      ```
      1. nslookup -type=NS example.com
      ```

      You query one of these name servers in the next step\.

1. Verify that the MX record is correctly added:

   1. Run the following command using your domain and one of the name servers that you found in step 1\.

      ```
      1. nslookup -type=MX example.com ns1.name-server.net
      ```

   1. In the output of the command, verify that the string that follows `mail exchange = ` matches one of the following values: 

      For the US East \(N\. Virginia\) Region, the record must be: `10 inbound-smtp.us-east-1.amazonaws.com`

      For the Europe \(Ireland\) Region, the record must be: `10 inbound-smtp.eu-west-1.amazonaws.com`

      For the US West \(Oregon\) Region, the record must be: `10 inbound-smtp.us-west-2.amazonaws.com`
**Note**  
`10` represents the MX preference number or priority\.

**To use dig to verify that your MX record is added to your DNS service**

1. Open a terminal window\.

1. Run the following command to list the MX records for your domain\.

   ```
   1. dig +short example.com mx
   ```

1. Verify that the string that follows `MX` matches one of the following values:

   For the US East \(N\. Virginia\) Region, the record must be: `10 inbound-smtp.us-east-1.amazonaws.com`

   For the Europe \(Ireland\) Region, the record must be: `10 inbound-smtp.eu-west-1.amazonaws.com`

   For the US West \(Oregon\) Region, the record must be: `10 inbound-smtp.us-west-2.amazonaws.com`
**Note**  
`10` represents the MX preference number or priority\.

## Troubleshooting domain verification<a name="domain-verification-issues"></a>

For help troubleshooting domain verification, see the following suggestions:
+ **Your DNS service does not allow underscores in TXT record names** – You can omit `_amazonses` from the TXT record name\.
+ **You want to verify the same domain multiple times and you can't have multiple TXT records with the same name** – You might need to verify your domain name more than once because you're sending from multiple AWS accounts using the same domain in the same Region\. If your DNS service does not allow you to have multiple TXT records with the same name, there are two workarounds\. The first workaround, if your DNS service allows it, is to assign multiple values to the TXT record\. For example, if your DNS is managed by Amazon Route 53, you can set up multiple values for the same TXT record as follows:

  1. In the Route 53 console, choose the `_amazonses` TXT record that you added when you verified your domain in the first Region\.

  1. For **Value**, press **Enter** after the first value\.

  1. Add the value for the additional Region, and save the record set\.

  If you only need to verify your domain twice, another workaround you can try is to verify it one time with `_amazonses` in the TXT record name and then omit `_amazonses` from the record name entirely\. We recommend the multiple value solution as a best practice\.
+ **Amazon WorkMail reports that domain verification failed** – The domain displays a status of "failed" on the **Domains** tab of the Amazon WorkMail console\. This means that Amazon WorkMail cannot find the necessary TXT record for your DNS service\. Verify that the required TXT record is correctly added to your DNS service by using the procedure in [Verifying TXT records and MX records with your DNS service](#domain-verification-check-dns), and look for the following possible error\.
  + **Your DNS provider appended the domain name to the end of the TXT record** – Adding a TXT record that already contains the domain name \(such as \_amazonses\.example\.com\) might result in the duplication of the domain name \(such as \_amazonses\.example\.com\.example\.com\)\. To avoid duplicating the domain name in the record name, add a period to the end of the domain name in the TXT record\. This indicates to your DNS provider that the record name is fully qualified \(that is, no longer relative to the domain name\), and prevents the DNS provider from appending an additional domain name\.
+ **Amazon WorkMail reports that the MX record is Inconsistent** – When migrating from existing mail servers, the MX record might read **Inconsistent**\. To resolve this, update your MX record to point to Amazon WorkMail instead of pointing to your previous mail server\. The MX record is also returned as **Inconsistent** when a third\-party email proxy is used along with Amazon WorkMail\. If this is the case, it is safe to ignore the **Inconsistent** warning\.