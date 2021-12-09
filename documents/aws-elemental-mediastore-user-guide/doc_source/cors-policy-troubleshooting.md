# Troubleshooting CORS issues<a name="cors-policy-troubleshooting"></a>

If you encounter unexpected behavior when you access a container that has a CORS policy, follow these steps to troubleshoot the issue\.

1. Verify that the CORS policy is attached to the container\.

   For instructions, see [Viewing a CORS policy](cors-policy-viewing.md)\.

1. Capture the complete request and response using a tool of your choice \(such as your browser's developer console\)\. Verify that the CORS policy that is attached to the container includes at least one CORS rule that matches the data in your request, as follows:

   1. Verify that the request has an `Origin` header\.

      If the header is missing, AWS Elemental MediaStore does not treat the request as a cross\-origin request and does not send CORS response headers back in the response\.

   1. Verify that the `Origin` header in your request matches at least one of the `AllowedOrigins` elements in the specific `CORSRule`\.

      The scheme, the host, and the port values in the `Origin` request header must match the `AllowedOrigins` in the `CORSRule`\. For example, if you set `CORSRule` to allow the origin `http://www.example.com`, then both `https://www.example.com` and `http://www.example.com:80` origins in your request do not match the allowed origin in your configuration\.

   1. Verify that the method in your request \(or the method specified in the `Access-Control-Request-Method` in case of a preflight request\) is one of the `AllowedMethods` elements in the same `CORSRule`\.

   1. For a preflight request, if the request includes an `Access-Control-Request-Headers` header, verify that the `CORSRule` includes the `AllowedHeaders` entries for each value in the `Access-Control-Request-Headers` header\.