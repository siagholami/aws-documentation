# Translating Text Using the AWS Mobile SDK for iOS<a name="getting-started-ios"></a>

You can use Amazon Translate in an iOS application to translate text\.

**To configure the example**

1. Create an IAM user with the minimum required permissions to run this example\. For information about creating an IAM user, see [ Creating an IAM User in Your AWS Account ](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_users_create.html) in the *AWS Identity and Access Management User Guide*\. For the required permissions policies, see [Amazon Translate Identity\-Based Policies](security_iam_service-with-iam.md#access-control-managing-permissions)\. After you create the user, download the credentials or record the access key and secret access key\.

1. Install Xcode version 8\.0 or later\. You can download the latest version of Xcode from the Apple website, [ https://developer\.apple\.com/xcode/](https://developer.apple.com/xcode/)\.

1. Install Cocoapods\. In a terminal window, run the following command:

   ```
   sudo gem install cocoapods
   ```

1. Create a project using Xcode\. Then, in a terminal window, navigate to the directory that contains your project's `.xcodeproj` file and run the following command:

   ```
   pod init
   ```

1. Add the core Mobile SDK for iOS components to your pod file:

   ```
   platform :ios, '9.0'
   target :'app name' do
      use_frameworks!
      pod 'AWSTranslate', '~> 2.6.19'
      # other pods
   end
   ```

1. Install dependencies by running the following command in a terminal window:

   ```
   pod install --repo-update
   ```

1. Running '`pod install`' creates a new workspace file\. Close your Xcode project and then open it using the \./*project\_name*\.xcworkspace file\. From now on you should only use this file to open your Xcode project

   Rebuild your app after you open it to resolve APIs from the new libraries called in your code\.

1. Add the following import statement to your view controller:

   ```
   import AWSTranslate
   ```

1. Copy the following code into your XCode project\. Update the access key and secret key to the values that you recorded in step 1\.

## Code<a name="ios-sdk-code"></a>

Use the following code to create the example\.

```
var credentialsProvider = AWSStaticCredentialsProvider(accessKey: "access key", secretKey: "secret key")

var configuration = AWSServiceConfiguration(region: AWSRegionUSEast1, credentialsProvider: credentialsProvider)

AWSServiceManager.default().defaultServiceConfiguration = configuration

let translateClient = AWSTranslate.default()
let translateRequest = AWSTranslateTranslateTextRequest()
translateRequest?.sourceLanguageCode = "en"
translateRequest?.targetLanguageCode = "es"
translateRequest?.text = "Hello World"
        
let callback: (AWSTranslateTranslateTextResponse?, Error?) -> Void = { (response, error) in
   guard let response = response else {
      print("Got error \(error)")
      return
   }
            
   if let translatedText = response.translatedText {
      print(translatedText)
   }
}
        
translateClient.translateText(translateRequest!, completionHandler: callback)
```