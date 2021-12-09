# Translating Text Using the AWS Mobile SDK for Android<a name="getting-started-android"></a>

You can use Amazon Translate in an Android application to translate text\.

**To configure the example**

1. Set up the AWS Mobile SDK for Android\. For instructions, see [ Android: Setup Options for the SDK](https://docs.aws.amazon.com/aws-mobile/latest/developerguide/how-to-android-sdk-setup.html) in the *AWS Mobile Developer Guide*

1. Create an IAM user with the minimum required permissions to run this example\. For information about creating an IAM user, see [ Creating an IAM User in Your AWS Account ](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_users_create.html) in the *AWS Identity and Access Management User Guide*\. For the required permissions policies, see [Amazon Translate Identity\-Based Policies](security_iam_service-with-iam.md#access-control-managing-permissions)\. After you create the user, download the credentials or record the access key and secret access key\.

1. Create a new project with Android Studio\.

1. Add the following to the dependencies section of your `build.gradle` file\.

   ```
   dependencies {
       implementation 'com.amazonaws:aws-android-sdk-translate:2.6.20'
   }
   ```

1. Add the following permissions to the `AndroidManifest.xml` file\.

   ```
   <uses-permission android:name="android.permission.INTERNET"/>
   <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
   ```

1. Copy the source code into your project

1. Change the access key and secret access key to the keys that you recorded in step one\. 

## Code<a name="android-sdk-code"></a>

Use the following code to create the example\.

```
package com.amazonaws.amazontranslatetester;
 
import android.app.Activity;
import android.util.Log;
 
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.translate.AmazonTranslateAsyncClient;
import com.amazonaws.services.translate.model.TranslateTextRequest;
import com.amazonaws.services.translate.model.TranslateTextResult;
 
public class MainActivity extends Activity {
 
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AWSCredentials awsCredentials = new AWSCredentials() {
            @Override
            public String getAWSAccessKeyId() {
                return "access key";
            }
 
            @Override
            public String getAWSSecretKey() {
                return "secret key";
            }
        };
 
        AmazonTranslateAsyncClient translateAsyncClient = new AmazonTranslateAsyncClient(awsCredentials);
        TranslateTextRequest translateTextRequest = new TranslateTextRequest()
                .withText("Hello, world")
                .withSourceLanguageCode("en")
                .withTargetLanguageCode("es");
        translateAsyncClient.translateTextAsync(translateTextRequest, new AsyncHandler<TranslateTextRequest, TranslateTextResult>() {
            @Override
            public void onError(Exception e) {
                Log.e(LOG_TAG, "Error occurred in translating the text: " + e.getLocalizedMessage());
            }
 
            @Override
            public void onSuccess(TranslateTextRequest request, TranslateTextResult translateTextResult) {
                Log.d(LOG_TAG, "Original Text: " + request.getText());
                Log.d(LOG_TAG, "Translated Text: " + translateTextResult.getTranslatedText());
            }
        });
    }
}
```