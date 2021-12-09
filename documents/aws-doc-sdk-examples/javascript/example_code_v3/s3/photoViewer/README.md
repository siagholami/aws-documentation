# Typescript environment for Amazon S3 examples
Environment for AWS SDK for JavaScript (V3) Amazon S3 Photo Viewer tutorial. For more information, see the [AWS documentation for these examples](https://docs.aws.amazon.com/sdk-for-javascript/v3/developer-guide/s3-example-photos-view.html).

Amazon Simple Storage Service (Amazon S3) is an object storage service that offers industry-leading scalability, data availability, security, and performance.

This is a workspace where you can find working AWS SDK for JavaScript (V3) S3 samples. 

# Getting Started

1. Clone the [AWS SDK Code Samples repo](https://github.com/awsdocs/aws-doc-sdk-examples) repo to your local environment. See [here](https://docs.github.com/en/github/creating-cloning-and-archiving-repositories/cloning-a-repository) for instructions.

2. Install the dependencies listed in the package.json.

**Note**: These include the client modules for the AWS services required in these example, 
which include *@aws-sdk/client-s3*, *@aws-sdk/client-cognito-identity*, and 
*@aws-sdk/credential-provider-cognito-identity*.
```
npm install ts-node -g // if you prefer to use JavaScript, enter 'npm install node -g' instead
cd javascript/example_code_v3/s3/src/photoViewer/src
npm install
```
3. Follow the steps in the [AWS documentation for this examples](https://docs.aws.amazon.com/sdk-for-javascript/v3/developer-guide/s3-example-photos-view.html).
