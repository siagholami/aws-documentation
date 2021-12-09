# Example CORS policy: Read access for a specific domain<a name="cors-policies-examples-read-specific-domain"></a>

The following policy allows a webpage from `https://www.example.com` to retrieve content from your AWS Elemental MediaStore container\. The request includes all HTTP headers from `https://www.example.com`, and the service responds only to HTTP GET and HTTP HEAD requests from `https://www.example.com`\. The results are cached for 3,000 seconds before a new set of results is delivered\. 

```
[
  {
    "AllowedHeaders": [
      "*"
    ],
    "AllowedMethods": [
      "GET",
      "HEAD"
    ],
    "AllowedOrigins": [
      "https://www.example.com"
    ],
    "MaxAgeSeconds": 3000
  }
]
```