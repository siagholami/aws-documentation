# Example CORS policy: Read access for any domain<a name="cors-policies-examples-read-all-domains"></a>

The following policy allows a webpage from any domain to retrieve content from your AWS Elemental MediaStore container\. The request includes all HTTP headers from the originating domain, and the service responds only to HTTP GET and HTTP HEAD requests from the originating domain\. The results are cached for 3,000 seconds before a new set of results is delivered\. 

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
      "*"
    ],
    "MaxAgeSeconds": 3000
  }
]
```