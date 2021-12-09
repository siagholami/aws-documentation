# Validating Phone Numbers with Amazon Pinpoint<a name="channels-sms-verify"></a>

Before you send an SMS message, you can use Amazon Pinpoint to determine whether the destination phone number is valid\. A valid phone number is:
+ **Formatted correctly** – The number includes the country code, area code, and subscriber number\. For example, a valid US phone number is formatted as \+14085550100\.
+ **Assigned to a mobile phone** – Landline phone numbers are invalid destinations for SMS messages\.

If you send an SMS message to an invalid number, the delivery fails\. You can validate phone numbers to increase the likelihood that your audience receives your messages\. You can improve your phone number records and your message deliverability in use cases such as the following\.

**Example Use Cases**
+ If your audience members opt in to your SMS program by providing a number on your website, you can check the number at the time of submission\. Use your website's backend to validate the number with the Amazon Pinpoint API\. The API response states whether the number is invalid—for example, because it's formatted incorrectly or it's a landline number\. In such cases, your website can display a message that prompts the user to enter a valid number\.
+ If you have a database of customer phone numbers, you can validate each number and take action on invalid entries\.
+ If you intend to send an SMS message but you determine that the destination number is invalid, you can message the recipient through a different channel\. For example, you can send an email if you know the recipient's email address\.

The response from Amazon Pinpoint also includes data about the number\. Amazon Pinpoint obtains this data from wireless carriers\. It includes information such as the carrier that the number is registered with and the location where the number was originally registered\.

To validate a number, send an HTTP POST request to the `/v1/phone/number/validate/` URI in the Amazon Pinpoint API\. For information about supported methods, parameters, and schemas, see [Phone Number Validate](https://docs.aws.amazon.com/pinpoint/latest/apireference/phone-number-validate.html) in the *Amazon Pinpoint API Reference*\.

## Example Request with a Valid Phone Number<a name="channels-sms-verify-example-valid"></a>

The example in this section passes a correctly formatted phone number to the Amazon Pinpoint API\.

A phone number is formatted correctly if it includes the country code, area code, and subscriber number\. Specifically, the number matches the E\.164 format\. E\.164 is a standard for the phone number structure used for international telecommunication\. Phone numbers that follow this format typically have up to 15 digits\. They are prefixed with the plus character \(\+\) and the country code\.

**Example Request**  
The following request includes the required HTTP headers and a simple JSON body\. The body specifies the number to validate with the `PhoneNumber` parameter:  

```
POST /v1/phone/number/validate/ HTTP/1.1
Host: pinpoint.us-east-1.amazonaws.com
Content-Type: application/json
X-Amz-Date: 20180420T162340Z
Authorization: AWS4-HMAC-SHA256 Credential=AKIAIOSFODNN7EXAMPLE/20180420/us-east-1/mobiletargeting/aws4_request, SignedHeaders=content-length;content-type;host;x-amz-date, Signature=39df573629ddb283aea1fa2f7eef4106c0fb4826edf72e9934f03cf771276159
Cache-Control: no-cache

{
	"PhoneNumber": "+14085550100"
}
```

**Example Response**  
If the request succeeds, the response provides data about the number, as in the following example:  

```
Access-Control-Allow-Origin:*
Connection: keep-alive
Content-Length: 392
Content-Type: application/json
Date: Fri, 20 Apr 2018 16:23:44 GMT
X-Amzn-Trace-Id: Root=1-5ada140d-84d6b93a13855f08f1857133
x-amz-apigw-id: FpgSDEKqoAMFjjQ=
x-amzn-RequestId: 3015d110-44b7-11e8-8e9f-dd939118442c

{
    "CountryCodeIso2": "US",
    "CountryCodeNumeric": "1",
    "Country": "United States",
    "City": "Anytown",
    "ZipCode": "95037",
    "County": "Santa Clara",
    "Timezone": "America/Los_Angeles",
    "CleansedPhoneNumberNational": "4085550100",
    "CleansedPhoneNumberE164": "+14085550100",
    "Carrier": "AnyCompany",
    "PhoneTypeCode": 0,
    "PhoneType": "MOBILE",
    "OriginalPhoneNumber": "+14085550100",
    "OriginalCountryCodeIso2": "US"
}
```
The response indicates that the `PhoneType` is `MOBILE`\. Because the phone number is formatted correctly and assigned to a mobile phone, it's a valid destination for SMS messages\.  
The `PhoneType` attribute is useful for determining whether you can send an SMS message to the phone number\. Each possible `PhoneType` value has a corresponding `PhoneTypeCode` integer:  


| `PhoneTypeCode` | `PhoneType` | 
| --- | --- | 
| 0 | MOBILE | 
| 1 | LANDLINE | 
| 2 | VOIP | 
| 3 | INVALID | 
| 4 | OTHER | 
| 5 | PREPAID | 
The other data in the response indicates that the phone number was originally registered in Santa Clara County, California, in the United States\.  
The data provided in the response varies by country or region\.

## Example Responses for Invalid Phone Numbers<a name="channels-sms-verify-example-invalid"></a>

A phone number is invalid if it's formatted incorrectly or isn't assigned to a mobile phone\.

**Example Response for an Incorrectly Formatted Number**  
The following example JSON body includes the US phone number from the previous example, but it omits the country code for the US \(`1`\):  

```
{
	"PhoneNumber": "4085550100"
}
```
When Amazon Pinpoint receives this request body, it discerns the country from the first digits in the number, as in the following response:  

```
Access-Control-Allow-Origin: *
Connection: keep-alive
Content-Length: 229
Content-Type: application/json
Date: Mon, 23 Apr 2018 17:50:10 GMT
X-Amzn-Trace-Id: Root=1-5ade1ccb-1d7bb9e12d4e2b7bced8f4f4
x-amz-apigw-id: Fzlv2HFtoAMFa7w=
x-amzn-RequestId: c07d2cf1-471e-11e8-b276-57d2b8118b9d

{
    "CountryCodeIso2": "RO",
    "CountryCodeNumeric": "40",
    "Country": "Romania",
    "CleansedPhoneNumberNational": "85550100",
    "CleansedPhoneNumberE164": "+4085550100",
    "PhoneTypeCode": 3,
    "PhoneType": "INVALID",
    "OriginalPhoneNumber": "4085550100"
}
```
To detect invalid numbers, you can validate whether:  
+ The `PhoneType` attribute has a value of `MOBILE` or `PREPAID`\.
+ The country information matches what you expect\.
+ The cleansed phone number information matches the number that you want to message\.
This response states that the phone was registered in `Romania`, which is an unexpected result for a US phone number\. Also, the `PhoneType` value indicates that the phone number is `INVALID`, which might mean that the number isn't formatted correctly or isn't registered with the wireless carriers\.  
After receiving a response like this, you might purge the phone number from your database, or you might ask your customer to update his or her contact information\.

**Example Response for a Landline Number**  
If your request includes a landline phone number, Amazon Pinpoint returns a response like the following:  

```
Access-Control-Allow-Origin:*
Connection: keep-alive
Content-Length: 331
Content-Type: application/json
Date: Mon, 23 Apr 2018 17:42:50 GMT
X-Amzn-Trace-Id: Root=1-5ade1b19-0c981399f4fac319aa44c89b
x-amz-apigw-id: Fzkr-EBxoAMF-zw=
x-amzn-RequestId: bd8c6b94-471d-11e8-9c10-eb82221e637d

{
    "CountryCodeIso2": "US",
    "CountryCodeNumeric": "1",
    "Country": "United States",
    "City": "Anytown",
    "ZipCode": "95037",
    "Timezone": "America/Los_Angeles",
    "CleansedPhoneNumberNational": "4085550101",
    "CleansedPhoneNumberE164": "14085550101",
    "Carrier": "AnyCompany",
    "PhoneTypeCode": 1,
    "PhoneType": "LANDLINE",
    "OriginalPhoneNumber": "+14085550101"
}
```
The `PhoneType` value indicates that the request provided a landline number\.