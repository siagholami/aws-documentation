# List package version assets<a name="list-assets"></a>

An *asset* is an individual file \(for example, an npm `.tgz` file or Maven POM or JAR file\) stored in CodeArtifact that is associated with a package version\. You can use the `list-package-version-assets` command to list the assets in each package version\.

Run the `list-package-version-assets` command to return the following information about each asset in your AWS account and your current AWS Region:
+  Its name\. 
+  Its size, in bytes\. 
+  A set of hash values used for checksum validation\. 

For example, use the following command to list the assets of the Python package `flatten-json`, version `0.1.7`\.

```
aws codeartifact list-package-version-assets --domain my-domain --domain-owner domain-owner-id --repository my-repo\
    --format pypi --package flatten-json --package-version 0.1.7
```

The following shows the output\.

```
{
    "format": "pypi",
    "package": "flatten-json",
    "version": "0.1.7",
    "versionRevision": "REVISION-SAMPLE-1-C7F4S5E9B772FC",
    "assets": [
        {
            "name": "flatten_json-0.1.7-py3-none-any.whl",
            "size": 31520,
            "hashes": {
                "MD5": "41bba98d5b9219c43089eEXAMPLE-MD5",
                "SHA-1": "69b215c25dd4cda1d997a786ec6EXAMPLE-SHA-1",
                "SHA-256": "43f24850b7b7b7d79c5fa652418518fbdf427e602b1edabe6EXAMPLE-SHA-256",
                "SHA-512": "3947382ac2c180ee3f2aba4f8788241527c8db9dfe9f4b039abe9fc560aaf5a1fced7bd1e80a0dca9ce320d95f0864e0dec3ac4f2f7b2b2cbEXAMPLE-SHA-512"
            }
        },
        {
            "name": "flatten_json-0.1.7.tar.gz",
            "size": 2865,
            "hashes": {
                "MD5": "41bba98d5b9219c43089eEXAMPLE-MD5",
                "SHA-1": "69b215c25dd4cda1d997a786ec6EXAMPLE-SHA-1",
                "SHA-256": "43f24850b7b7b7d79c5fa652418518fbdf427e602b1edabe6EXAMPLE-SHA-256",
                "SHA-512": "3947382ac2c180ee3f2aba4f8788241527c8db9dfe9f4b039abe9fc560aaf5a1fced7bd1e80a0dca9ce320d95f0864e0dec3ac4f2f7b2b2cbEXAMPLE-SHA-512"
            }
        }
    ]
}
```

To list the assets of the Maven package `commons-cli:commons-cli`:

```
aws codeartifact list-package-version-assets --domain my-domain --domain-owner domain-owner-id --repository my-repo \
    --format maven --package commons-cli --namespace commons-cli --package-version 1.0
```

The following shows the output\.

```
{
    "format": "maven",
    "namespace": "commons-cli",
    "package": "commons-cli",
    "version": "1.0",
    "versionRevision": "REVISION-SAMPLE-55C752BEE9B772FC",
    "assets": [
        {
            "name": "commons-cli-1.0.jar",
            "size": 30117,
            "hashes": {
                "MD5": "41bba98d5b9219c43089eEXAMPLE-MD5",
                "SHA-1": "69b215c25dd4cda1d997a786ec6EXAMPLE-SHA-1",
                "SHA-256": "43f24850b7b7b7d79c5fa652418518fbdf427e602b1edabe6EXAMPLE-SHA-256",
                "SHA-512": "3947382ac2c180ee3f2aba4f8788241527c8db9dfe9f4b039abe9fc560aaf5a1fced7bd1e80a0dca9ce320d95f0864e0dec3ac4f2f7b2b2cbEXAMPLE-SHA-512"
            }
        },
        {
            "name": "commons-cli-1.0.pom",
            "size": 2105,
            "hashes": {
                "MD5": "41bba98d5b9219c43089eEXAMPLE-MD5",
                "SHA-1": "69b215c25dd4cda1d997a786ec6EXAMPLE-SHA-1",
                "SHA-256": "43f24850b7b7b7d79c5fa652418518fbdf427e602b1edabe6EXAMPLE-SHA-256",
                "SHA-512": "3947382ac2c180ee3f2aba4f8788241527c8db9dfe9f4b039abe9fc560aaf5a1fced7bd1e80a0dca9ce320d95f0864e0dec3ac4f2f7b2b2cbEXAMPLE-SHA-512"
            }
        },
        {
            "name": "maven-metadata.xml",
            "size": 119,
            "hashes": {
                "MD5": "41bba98d5b9219c43089eEXAMPLE-MD5",
                "SHA-1": "69b215c25dd4cda1d997a786ec6EXAMPLE-SHA-1",
                "SHA-256": "43f24850b7b7b7d79c5fa652418518fbdf427e602b1edabe6EXAMPLE-SHA-256",
                "SHA-512": "3947382ac2c180ee3f2aba4f8788241527c8db9dfe9f4b039abe9fc560aaf5a1fced7bd1e80a0dca9ce320d95f0864e0dec3ac4f2f7b2b2cbEXAMPLE-SHA-512"
            }
        }
    ]
}
```

An npm package always has a single asset with a name of `package.tgz`\.

```
aws codeartifact list-package-version-assets --domain my-domain --domain-owner domain-owner-id --repository my-repo \
    --format npm --package webpack --package-version 4.9.2
```

The following shows the output\.

```
{
    "format": "npm",
    "package": "webpack",
    "version": "4.9.2",
    "versionRevision": "REVISION-SAMPLE-55C752BEE9B772FC",
    "assets": [
        {
            "name": "package.tgz",
            "size": 242930,
            "hashes": {
                "MD5": "41bba98d5b9219c43089eEXAMPLE-MD5",
                "SHA-256": "43f24850b7b7b7d79c5fa652418518fbdf427e602b1edabe6EXAMPLE-SHA-256",
                "SHA-512": "3947382ac2c180ee3f2aba4f8788241527c8db9dfe9f4b039abe9fc560aaf5a1fced7bd1e80a0dca9ce320d95f0864e0dec3ac4f2f7b2b2cbEXAMPLE-SHA-512"
            }
        }
    ]
}
```