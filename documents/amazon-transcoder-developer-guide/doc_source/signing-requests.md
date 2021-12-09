# Signing Requests<a name="signing-requests"></a>

If you're using a language for which AWS provides an SDK, we recommend that you use the SDK\. All of the AWS SDKs greatly simplify the process of signing requests and save you a significant amount of time when compared with using the Elastic Transcoder API\. In addition, the SDKs integrate easily with your development environment and provide easy access to related commands\.

Elastic Transcoder requires that you authenticate every request you send by signing the request\. To sign a request, you calculate a digital signature using a cryptographic hash function, which returns a hash value based on the input\. The input includes the text of your request and your secret access key\. The hash function returns a hash value that you include in the request as your signature\. The signature is part of the `Authorization` header of your request\. 

After receiving your request, Elastic Transcoder recalculates the signature using the same hash function and input that you used to sign the request\. If the resulting signature matches the signature in the request, Elastic Transcoder processes the request\. Otherwise, the request is rejected\. 

Elastic Transcoder supports authentication using [AWS Signature Version 4](https://docs.aws.amazon.com/general/latest/gr/signature-version-4.html)\. The process for calculating a signature can be broken into three tasks:
+ <a name="SignatureCalculationTask1"></a>[Task 1: Create a Canonical Request](https://docs.aws.amazon.com/general/latest/gr/sigv4-create-canonical-request.html)

  Create your HTTP request in canonical format as described in [Task 1: Create a Canonical Request For Signature Version 4](https://docs.aws.amazon.com/general/latest/gr/sigv4-create-canonical-request.html) in the *Amazon Web Services General Reference*\. 
+ <a name="SignatureCalculationTask2"></a>[Task 2: Create a String to Sign](https://docs.aws.amazon.com/general/latest/gr/sigv4-create-string-to-sign.html)

  Create a string that you will use as one of the input values to your cryptographic hash function\. The string, called the *string to sign*, is a concatenation of the name of the hash algorithm, the request date, a *credential scope* string, and the canonicalized request from the previous task\. The *credential scope* string itself is a concatenation of date, region, and service information\.

  For the `X-Amz-Credential` parameter, specify:
  + The code for the endpoint to which you're sending the request, for example, `us-east-1`\. For a list of regions and endpoints for Elastic Transcoder, see the [Regions and Endpoints](https://docs.aws.amazon.com/general/latest/gr/rande.html#elastictranscoder_region) chapter of the *Amazon Web Services General Reference*\. When specifying the code for the endpoint, include only the part between `elastictranscoder.` and `.amazonaws.com`
  + `elastictranscoder` for the service abbreviation

  For example:

  `X-Amz-Credential=AKIAIOSFODNN7EXAMPLE/20130501/us-east-1/elastictranscoder/aws4_request`
+ <a name="SignatureCalculationTask3"></a>[Task 3: Create a Signature](https://docs.aws.amazon.com/general/latest/gr/sigv4-calculate-signature.html)

  Create a signature for your request by using a cryptographic hash function that accepts two input strings: your *string to sign* and a *derived key*\. The *derived key* is calculated by starting with your secret access key and using the *credential scope* string to create a series of hash\-based message authentication codes \(HMACs\)\. 