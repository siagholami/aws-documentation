# Step 2: Set Up the AWS Command Line Interface \(AWS CLI\)<a name="setup-awscli"></a>

You use the AWS CLI to make interactive calls to Amazon Translate\. 

**To set up the AWS CLI**

1. Download and configure the AWS CLI\. For instructions, see the following topics in the *AWS Command Line Interface User Guide*: 
   + [Getting Set Up with the AWS Command Line Interface](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-getting-set-up.html)
   + [Configuring the AWS Command Line Interface](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-getting-started.html)

1. In the AWS CLI `config` file, add a named profile for the administrator user:

   ```
   [profile adminuser]
   aws_access_key_id = adminuser access key ID
   aws_secret_access_key = adminuser secret access key
   region = aws-region
   ```

   You use this profile when executing AWS CLI commands\. For more information about named profiles, see [Named Profiles](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-getting-started.html#cli-multiple-profiles) in the *AWS Command Line Interface User Guide*\. For a list of AWS Regions, see [Regions and Endpoints](https://docs.aws.amazon.com/general/latest/gr/rande.html) in the *Amazon Web Services General Reference*\.

1. Verify the setup by typing the following help command at the command prompt: 

   ```
   aws translate help
   ```

   You should see a brief description of Amazon Translate and a list of the available commands\.

## Next Step<a name="setting-up-next-step-3"></a>

[Step 3: Getting Started \(Console\)](get-started-console.md)