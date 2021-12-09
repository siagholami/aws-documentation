# Using Signature Version 4 with Amazon Translate<a name="examples-sigv4"></a>

This example Python program shows how to use Signature Version 4 to add authentication information to Amazon Translate requests\. The example makes a POST request, creates a JSON structure that contains the text to be translated in the body \(payload\) of the request, and passes authentication information in an Authorization header\. For more information about using Signature Version 4, see [ Signature Version 4 Signing Process ](https://docs.aws.amazon.com/general/latest/gr/signature-version-4.html) in the *Amazon Web Services General Reference*\.

## Setting Up<a name="examples-sig4-setting-up"></a>

To run the example, perform the following steps:

1. Install the AWS Command Line Interface \(AWS CLI\)\. The AWS SDK for Python \(Boto\) is included when you install the AWS CLI\. For instructions, see [Step 2: Set Up the AWS Command Line Interface \(AWS CLI\)](setup-awscli.md)\.

1. Create an AWS Identity and Access Management \(IAM\) user with the minimum required permission policy to run this example\. For information about creating an IAM user, see [ Creating an IAM User in Your AWS Account ](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_users_create.html) in the *AWS Identity and Access Management User Guide*\. For the required permissions policies, see [Amazon Translate Identity\-Based Policies](security_iam_service-with-iam.md#access-control-managing-permissions)\. Record the user access key ID and the secret access key\.

1. Place the access key ID and secret access key in environment variables named `AWS_ACCESS_KEY and AWS_SECRET_ACCESS_KEY`, respectively\. As a best practice, we recommend that you don't embed credentials in code\.

1. Create a new file on your computer, copy the code for the example \(which you can find in the next section\), paste it into the file, and save the file with the extension `.py`\.

1. In the code, replace `region` with the name of the AWS Region where you want to run the Amazon Translate `TranslateText` operation\. For a list of supported Regions, see [ AWS Regions and Endpoints ](https://docs.aws.amazon.com/general/latest/gr/rande.html#translate_region) in the *AWS General Reference*\. 

## Code<a name="example-sigv4-code"></a>

The following is the complete code of the example Python program\. 

After creating request values such as the endpoint URL and the body of the request, the code does the following:

1. Create a canonical request to the Amazon Translate `TranslateText` operation\.

1. Create the string to that you hash to create the signature\.

1. Calculate the signature\.

1. Add the signature to the request header\.

1. Send the request to the `TranslateText` operation\.

To run the example on your computer, copy the code to a Python file\.

```
# AWS Version 4 signing example

# Translate API (TranslateText)

# For more information about using Signature Version 4, see http://docs.aws.amazon.com/general/latest/gr/sigv4_signing.html.
# This example makes a POST request to Amazon Translate and 
# passes the text to translate JSON in the body (payload) 
# of the request. Authentication information is passed in an 
# Authorization header.
import sys, os, base64, datetime, hashlib, hmac
import requests # pip install requests

# ************* REQUEST VALUES *************
method = 'POST'
service = 'translate'
region = 'region'
host = service + '.' + region + '.amazonaws.com'
endpoint = 'https://' + host + '/'

# POST requests use a content type header. For Amazon Translate,
# the content is JSON.
content_type = 'application/x-amz-json-1.1'
# Amazon Translate requires an x-amz-target header that has this format:
#     AWSShineFrontendService_20170701.<operationName>.
amz_target = 'AWSShineFrontendService_20170701.TranslateText'

# Pass request parameters for the TranslateText operation in a JSON block.
request_parameters =  '{'
request_parameters +=  '"Text": "Hello world.",'
request_parameters +=  '"SourceLanguageCode": "en",'
request_parameters +=  '"TargetLanguageCode": "de"'
request_parameters +=  '}'

# The following functions derive keys for the request. For more information, see
# http://docs.aws.amazon.com/general/latest/gr/signature-v4-examples.html#signature-v4-examples-python.
def sign(key, msg):
    return hmac.new(key, msg.encode("utf-8"), hashlib.sha256).digest()

def getSignatureKey(key, date_stamp, regionName, serviceName):
    kDate = sign(('AWS4' + key).encode('utf-8'), date_stamp)
    kRegion = sign(kDate, regionName)
    kService = sign(kRegion, serviceName)
    kSigning = sign(kService, 'aws4_request')
    return kSigning

# Python can read the AWS access key from environment variables or the configuration file. 
# In this example, keys are stored in environment variables. As a best practice, do not 
# embed credentials in code.
access_key = os.environ.get('AWS_ACCESS_KEY_ID')
secret_key = os.environ.get('AWS_SECRET_ACCESS_KEY')
if access_key is None or secret_key is None:
    print 'No access key is available.'
    sys.exit()

# Create a timestamp for headers and the credential string.
t = datetime.datetime.utcnow()
amz_date = t.strftime('%Y%m%dT%H%M%SZ')
date_stamp = t.strftime('%Y%m%d') # The date without time is used in the credential scope.


# ************* TASK 1: CREATE A CANONICAL REQUEST *************
# For information about creating a canonical request, see http://docs.aws.amazon.com/general/latest/gr/sigv4-create-canonical-request.html.

# Step 1: Define the verb (GET, POST, etc.), which you have already done.

# Step 2: Create a canonical URI. A canonical URI is the part of the URI from domain to query. 
# string (use '/' if no path)
canonical_uri = '/'

## Step 3: Create the canonical query string. In this example, request
# parameters are passed in the body of the request and the query string
# is blank.
canonical_querystring = ''

# Step 4: Create the canonical headers. Header names must be trimmed,
# lowercase, and sorted in code point order from low to high.
# Note the trailing \n.
canonical_headers = 'content-type:' + content_type + '\n' + 'host:' + host + '\n' + 'x-amz-date:' + amz_date + '\n' + 'x-amz-target:' + amz_target + '\n'

# Step 5: Create the list of signed headers by listing the headers
# in the canonical_headers list, delimited with ";" and in alphabetical order.
# Note: The request can include any headers. Canonical_headers and
# signed_headers should contain headers to include in the hash of the
# request. "Host" and "x-amz-date" headers are always required.
# For Amazon Translate, content-type and x-amz-target are also required.
signed_headers = 'content-type;host;x-amz-date;x-amz-target'

# Step 6: Create the payload hash. In this example, the request_parameters
# variable contains the JSON request parameters.
payload_hash = hashlib.sha256(request_parameters).hexdigest()

# Step 7: Combine the elements to create a canonical request.
canonical_request = method + '\n' + canonical_uri + '\n' + canonical_querystring + '\n' + canonical_headers + '\n' + signed_headers + '\n' + payload_hash


# ************* TASK 2: CREATE THE STRING TO SIGN*************
# Set the algorithm variable to match the hashing algorithm that you use, either SHA-256 (recommended) or SHA-1. 
# 
algorithm = 'AWS4-HMAC-SHA256'
credential_scope = date_stamp + '/' + region + '/' + service + '/' + 'aws4_request'
string_to_sign = algorithm + '\n' +  amz_date + '\n' +  credential_scope + '\n' +  hashlib.sha256(canonical_request).hexdigest()


# ************* TASK 3: CALCULATE THE SIGNATURE *************
# Create the signing key using the getSignaturKey function defined above.
signing_key = getSignatureKey(secret_key, date_stamp, region, service)

# Sign the string_to_sign using the signing_key.
signature = hmac.new(signing_key, (string_to_sign).encode('utf-8'), hashlib.sha256).hexdigest()


# ************* TASK 4: ADD SIGNING INFORMATION TO THE REQUEST *************
# Put the signature information in a header named Authorization.
authorization_header = algorithm + ' ' + 'Credential=' + access_key + '/' + credential_scope + ', ' +  'SignedHeaders=' + signed_headers + ', ' + 'Signature=' + signature

# For Amazon Translate, the request can include any headers, but it must include "host," "x-amz-date,"
# "x-amz-target," "content-type," and "Authorization" headers. Except for the authorization
# header, the headers must be included in the canonical_headers and signed_headers values, as
# noted earlier. Header order is not significant.
# Note: The Python 'requests' library automatically adds the 'host' header.
headers = {'Content-Type':content_type,
           'X-Amz-Date':amz_date,
           'X-Amz-Target':amz_target,
           'Authorization':authorization_header}


# ************* TASK 5: SEND THE REQUEST *************
print 'Request:\n\t' + request_parameters

response = requests.post(endpoint, data=request_parameters, headers=headers)
print 'Response:\n\t' + response.text
```