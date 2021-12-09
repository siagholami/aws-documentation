# Authenticate chatbot requests<a name="auth-bots"></a>

You can authenticate requests sent to your chatbot from an Amazon Chime chat room\. To do this, compute a signature based on the request\. Then, validate that the computed signature matches the one on the request header\. Amazon Chime uses the HMAC SHA256 hash to generate the signature\.

If your chatbot is configured for Amazon Chime using an outbound HTTPS endpoint, use the following authentication steps\.

**To validate a signed request from Amazon Chime for a chatbot with a outbound HTTPS endpoint configured**

1. Get the **Chime\-Signature** header from the HTTP request\.

1. Get the **Chime\-Request\-Timestamp** header and the **body** of the request\. Then, use a vertical bar as the delimiter between the two elements to form a string\.

1. Use the **SecurityToken** from the CreateBot response as the initial key of **HMAC\_SHA\_256**, and hash the string that you created in step 2\.

1. Encode the hashed byte with Base64 encoder to a signature string\.

1. Compare this computed signature to the one in the **Chime\-Signature** header\.

The following code sample demonstrates how to generate a signature using Java\.

```
        private final String DELIMITER = "|";
        private final String HMAC_SHA_256 = "HmacSHA256";
   
        private String generateSignature(String securityToken, String requestTime, String requestBody) 
        {
            try {
                final Mac mac = Mac.getInstance(HMAC_SHA_256);
                SecretKeySpec key = new SecretKeySpec(securityToken.getBytes(UTF_8), HMAC_SHA_256);
                mac.init(key);
                String data = requestTime + DELIMITER + requestBody;
                byte[] rawHmac = mac.doFinal(data.getBytes(UTF_8));

                return Base64.getEncoder().encodeToString(rawHmac);
                } 
            catch (Exception e) {
                throw e;
                }
         }
```

The outbound HTTPS endpoint must respond to the Amazon Chime request with `200 OK` within 2 seconds\. Otherwise, the request fails\. If the outbound HTTPS endpoint is unavailable after 2 seconds, possibly because of a Connection or Read timeout, , or if Amazon Chime receives a 5xx response code, Amazon Chime retries the request two times\. The first retry is sent 200 milliseconds after the initial request fails\. The second retry is sent 400 milliseconds after the previous retry fails\. If the outbound HTTPS endpoint is still unavailable after the second retry, the request fails\.

**Note**  
The **Chime\-Request\-Timestamp** changes each time the request is retried\.

If your chatbot is configured for Amazon Chime using a Lambda function ARN, use the following authentication steps\.

**To validate a signed request from Amazon Chime for a chatbot with a Lambda function ARN configured**

1. Get the **Chime\-Signature** and **Chime\-Request\-Timestamp** from the Lambda request **ClientContext**, in Base64 encoded JSON format\. 

   ```
   {
   "Chime-Signature" : "1234567890",
   "Chime-Request-Timestamp" : "2019-04-04T21:30:43.181Z"
   }
   ```

1. Get the **body** of the request from the request payload\.

1. Use the **SecurityToken** from the `CreateBot` response as the initial key of **HMAC\_SHA\_256**, and hash the string that you created\.

1. Encode the hashed byte with Base64 encoder to a signature string\.

1. Compare this computed signature to the one in the **Chime\-Signature** header\. 

If a `com.amazonaws.SdkClientException` occurs during the Lambda invocation, Amazon Chime retries the request two times\.