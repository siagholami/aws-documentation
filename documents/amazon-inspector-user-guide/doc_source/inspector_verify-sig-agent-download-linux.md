# \(Optional\) Verify the signature of the Amazon Inspector agent installation script on Linux\-based operating systems<a name="inspector_verify-sig-agent-download-linux"></a>

This topic describes the recommended process of verifying the validity of the Amazon Inspector agent's installations script for Linux\-based operating systems\. 

Whenever you download an application from the internet, we recommend that you authenticate the identity of the software publisher and check that the application is not altered or corrupted since it was published\. This protects you from installing a version of the application that contains a virus or other malicious code\.

If after running the steps in this topic, you determine that the software for the Amazon Inspector agent is altered or corrupted, do NOT run the installation file\. Instead, contact AWS Support\.

Amazon Inspector agent files for Linux\-based operating systems are signed using `GnuPG`, an open source implementation of the Pretty Good Privacy \(OpenPGP\) standard for secure digital signatures\. `GnuPG` \(also known as `GPG`\) provides authentication and integrity checking through a digital signature\. Amazon EC2 publishes a public key and signatures that you can use to verify the downloaded Amazon EC2 CLI tools\. For more information about `PGP` and `GnuPG` \(`GPG`\), see [http://www\.gnupg\.org](http://www.gnupg.org)\.

The first step is to establish trust with the software publisher\. Download the public key of the software publisher, check that the owner of the public key is who they claim to be, and then add the public key to your *keyring*\. Your keyring is a collection of known public keys\. After you establish the authenticity of the public key, you can use it to verify the signature of the application\.

**Topics**
+ [Installing the GPG tools](#inspector_verify-signature-of-agent-download-install-tools)
+ [Authenticating and importing the public key](#inspector_verify-signature-of-agent-download-authenticate-import-public-key)
+ [Verify the signature of the package](#inspector_verify-signature-of-agent-package)

## Installing the GPG tools<a name="inspector_verify-signature-of-agent-download-install-tools"></a>

If your operating system is Linux or Unix, the GPG tools are likely already installed\. To test whether the tools are installed on your system, type gpg at a command prompt\. If the GPG tools are installed, you see a GPG command prompt\. If the GPG tools are not installed, you see an error stating that the command cannot be found\. You can install the GnuPG package from a repository\. 

**To install GPG tools on Debian\-based Linux**
+ From a terminal, run the following command: apt\-get install gnupg\.

**To install GPG tools on Red Hat–based Linux**
+ From a terminal, run the following command: yum install gnupg\.

## Authenticating and importing the public key<a name="inspector_verify-signature-of-agent-download-authenticate-import-public-key"></a>

The next step in the process is to authenticate the Amazon Inspector public key and add it as a trusted key in your `GPG` keyring\.

**To authenticate and import the Amazon Inspector public key**

1. Obtain a copy of our public `GPG` build key by doing one of the following:
   + Download from [https://d1wk0tztpsntt1\.cloudfront\.net/linux/latest/inspector\.gpg](https://d1wk0tztpsntt1.cloudfront.net/linux/latest/inspector.gpg)\.
   + Copy the key from the following text and paste it into a file called `inspector.key`\. Make sure to include everything that follows:

     ```
     -----BEGIN PGP PUBLIC KEY BLOCK-----
     Version: GnuPG v2.0.18 (GNU/Linux)
     
     mQINBFYDlfEBEADFpfNt/mdCtsmfDoga+PfHY9bdXAD68yhp2m9NyH3BOzle/MXI
     8siNfoRgzDwuWnIaezHwwLWkDw2paRxp1NMQ9qRe8Phq0ewheLrQu95dwDgMcw90
     gf9m1iKVHjdVQ9qNHlB2OFknPDxMDRHcrmlJYDKYCX3+MODEHnlK25tIH2KWezXP
     FPSU+TkwjLRzSMYH1L8IwjFUIIi78jQS9a31R/cOl4zuC5fOVghYlSomLI8irfoD
     JSa3csVRujSmOAf9o3beiMR/kNDMpgDOxgiQTu/Kh39cl6o8AKe+QKK48kqO7hra
     h1dpzLbfeZEVU6dWMZtlUksG/zKxuzD6d8vXYH7Z+x09POPFALQCQQMC3WisIKgj
     zJEFhXMCCQ3NLC3CeyMq3vP7MbVRBYE7t3d2uDREkZBgIf+mbUYfYPhrzy0qT9Tr
     PgwcnUvDZuazxuuPzucZGOJ5kbptat3DcUpstjdkMGAId3JawBbps77qRZdA+swr
     o9o3jbowgmf0y5ZS6KwvZnC6XyTAkXy2io7mSrAIRECrANrzYzfp5v7uD7w8Dk0X
     1OrfOm1VufMzAyTu0YQGBWaQKzSB8tCkvFw54PrRuUTcV826XU7SIJNzmNQo58uL
     bKyLVBSCVabfs0lkECIesq8PT9xMYfQJ421uATHyYUnFTU2TYrCQEab7oQARAQAB
     tCdBbWF6b24gSW5zcGVjdG9yIDxpbnNwZWN0b3JAYW1hem9uLmNvbT6JAjgEEwEC
     ACIFAlYDlfECGwMGCwkIBwMCBhUIAgkKCwQWAgMBAh4BAheAAAoJECR0CWBYNgQY
     8yUP/2GpIl40f3mKBUiSTe0XQLvwiBCHmY+V9fOuKqDTinxssjEMCnz0vsKeCZF/
     L35pwNa/oW0OJa8D7sCkKG+8LuyMpcPDyqptLrYPprUWtz2+qLCHgpWsrku7ateF
     x4hWS0jUVeHPaBzI9V1NTHsCx9+nbpWQ5Fk+7VJI8hbMDY7NQx6fcse8WTlP/0r/
     HIkKzzqQQaaOf5t9zc5DKwi+dFmJbRUyaq22xs8C81UODjHunhjHdZ21cnsgk91S
     fviuaum9aR4/uVIYOTVWnjC5J3+VlczyUt5FaYrrQ5ov0dM+biTUXwve3X8Q85Nu
     DPnO/+zxb7Jz3QCHXnuTbxZTjvvl60Oi8//uRTnPXjz4wZLwQfibgHmk1++hzND7
     wOYA02Js6v5FZQlLQAod7q2wuA1pq4MroLXzziDfy/9ea8B+tzyxlmNVRpVZY4Ll
     DOHyqGQhpkyV3drjjNZlEofwbfu7m6ODwsgMl5ynzhKklJzwPJFfB3mMc7qLi+qX
     MJtEX8KJ/iVUQStHHAG7daL1bxpWSI3BRuaHsWbBGQ/mcHBgUUOQJyEp5LAdg9Fs
     VP55gWtF7pIqifiqlcfgG0Ov+A3NmVbmiGKSZvfrc5KsF/k43rCGqDx1RV6gZvyI
     LfO9+3sEIlNrsMib0KRLDeBt3EuDsaBZgOkqjDhgJUesqiCy
     =iEhB
     -----END PGP PUBLIC KEY BLOCK-----
     ```

1. At a command prompt in the directory where you saved **inspector\.key**, use the following command to import the Amazon Inspector public key into your keyring:

   ```
   gpg --import inspector.key
   ```

   The command returns results that are similar to the following:

   ```
   gpg: key 58360418: public key "Amazon Inspector <inspector@amazon.com>" imported
                       gpg: Total number processed: 1
                       gpg:               imported: 1  (RSA: 1)
   ```

   Make a note of the key value; you need it in the next step\. In the preceding example, the key value is `58360418`\.

1. Verify the fingerprint by running the following command, replacing *key\-value* with the value from the preceding step:

   ```
   gpg --fingerprint key-value
   ```

   This command returns results similar to the following:

   ```
   pub   4096R/58360418 2015-09-24
                   Key fingerprint = DDA0 D4C5 10AE 3C20 6F46  6DC0 2474 0960 5836 0418
                   uid                  Amazon Inspector <inspector@amazon.com>
   ```

   Additionally, the fingerprint string should be identical to `DDA0 D4C5 10AE 3C20 6F46 6DC0 2474 0960 5836 0418`, as shown in the preceding example\. Compare the key fingerprint that is returned to the one published on this page\. They should match\. If they don't match, don't install the Amazon Inspector agent installation script, and contact AWS Support\. 

## Verify the signature of the package<a name="inspector_verify-signature-of-agent-package"></a>

After you install the `GPG` tools, authenticate and import the Amazon Inspector public key, and verify that the public key is trusted, you are ready to verify the signature of the installation script\. 

**To verify the installation script signature**

1. At a command prompt, run the following command to download the signature file for the installation script:

   ```
   curl -O https://inspector-agent.amazonaws.com/linux/latest/install.sig
   ```

1. Verify the signature by running the following command at a command prompt in the directory where you saved `install.sig` and the Amazon Inspector installation file\. Both files must be present\.

   ```
   gpg --verify ./install.sig
   ```

   The output should look something like the following:

   ```
   gpg: Signature made Thu 24 Sep 2015 03:19:09 PM UTC using RSA key ID 58360418
   gpg: Good signature from "Amazon Inspector <inspector@amazon.com>" [unknown]
   gpg: WARNING: This key is not certified with a trusted signature!
   gpg:          There is no indication that the signature belongs to the owner.
   Primary key fingerprint: DDA0 D4C5 10AE 3C20 6F46  6DC0 2474 0960 5836 0418
   ```

   If the output contains the phrase `Good signature from "Amazon Inspector <inspector@amazon.com>"`, it means that the signature has successfully been verified, and you can proceed to run the Amazon Inspector installation script\.

   If the output includes the phrase `BAD signature`, check whether you performed the procedure correctly\. If you continue to get this response, don't run the installation file that you downloaded previously, and contact AWS Support\.

The following are details about the warnings you might see: 
+ **WARNING: This key is not certified with a trusted signature\! There is no indication that the signature belongs to the owner\.** This refers to your personal level of trust in your belief that you possess an authentic public key for Amazon Inspector\. In an ideal world, you would visit an AWS office and receive the key in person\. However, more often you download it from a website\. In this case, the website is an AWS website\. 
+ **gpg: no ultimately trusted keys found\.** This means that the specific key is not "ultimately trusted" by you \(or by other people whom you trust\)\.

For more information, see [http://www\.gnupg\.org](http://www.gnupg.org)\.