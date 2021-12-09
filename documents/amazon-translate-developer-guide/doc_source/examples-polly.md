# Using Amazon Polly with Amazon Translate<a name="examples-polly"></a>

To speak translated text, you can use Amazon Polly with Amazon Translate\. In this example you'll create a Web page where you can translate text using Amazon Translate and then speak that text using Amazon Polly\. The code can be summarized into the following:
+ CSS and HTML to create the Web page\.
+ Initialization code that creates controllers for Amazon Translate and Amazon Polly\.
+ A function that reads data from the Web page and calls Amazon Translate\.
+ A function that reads data from the Web page and calls Amazon Polly\.
+ Utility functions for managing the Web page\.

**To configure the example**

1. Install and Configure the AWS SDK for JavaScript\. For instructions for installing the SDK for JavaScript, see [Installing the SDK for JavaScript](https://docs.aws.amazon.com/sdk-for-javascript/v2/developer-guide/installing-jssdk.html)\.

1. Copy the code for the example to an HTML file on your Web server\.

1. Update the `<script>` tag to the location where you installed the SDK for JavaScript\.

1. Change the region and endpoint to the region where you want to run the Amazon Translate and Amazon Polly operations\. For a list of supported regions for Amazon Translate, see [AWS Regions and Endpoints](https://docs.aws.amazon.com/general/latest/gr/rande.html#translate_region)\. For a list of supported regions for Amazon Polly, see [AWS Regions and Endpoints](https://docs.aws.amazon.com/general/latest/gr/rande.html#pol_region) in the *AWS General Reference*\.

1. Create an IAM user with the minimum required permissions to run this example\. For information about creating an IAM user, see [ Creating an IAM User in Your AWS Account ](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_users_create.html) in the *AWS Identity and Access Management User Guide*\. For the required permissions policies, see [Amazon Translate Identity\-Based Policies](security_iam_service-with-iam.md#access-control-managing-permissions) and [ Using Identity\-Based Policies \(IAM Policies\) for Amazon Polly ](https://docs.aws.amazon.com/polly/latest/dg/using-identity-based-policies.html) in the *Amazon Polly Developer Guide*\.

1. Provide the access ID and secret key of the IAM user created in the previous step\.

## Code<a name="example-polly-code"></a>

The following is the complete code of the example Web page\. You can copy this code into an HTML file to run the example on your own Web server\.

```
<!DOCTYPE html>
<html>

<head>
    <title>Amazon Translate</title>
    <script src="aws-sdk/dist/aws-sdk.js"></script>
</head>

<body>
    <h1 style="text-align: left">Amazon Translate Demo</h1>
    <br/>
    <table class="tg">
        <tr>
            <th align="left">
Source Language Code:
                <select id="sourceLanguageCodeDropdown">
                      <option value="en">en</option>
                      <option value="ar">ar</option>
                      <option value="cs">cs</option>
                      <option value="de">de</option>
                      <option value="es">es</option>
                      <option value="fr">fr</option>
                      <option value="it">it</option>
                      <option value="ja">ja</option>
                      <option value="pt">pt</option>
                      <option value="ru">ru</option>
                      <option value="tr">tr</option>
                      <option value="zh">zh</option>
                      <option value="zh-TW">zh-TW</option>
                </select>
            </th>
            <th align="left">
Target Language Code:
                <select id="targetLanguageCodeDropdown">
                      <option value="en">en</option>
                      <option value="ar">ar</option>
                      <option value="cs">cs</option>
                      <option value="de">de</option>
                      <option value="es">es</option>
                      <option value="fr">fr</option>
                      <option value="it">it</option>
                      <option value="ja">ja</option>
                      <option value="pt">pt</option>
                      <option value="ru">ru</option>
                      <option value="tr">tr</option>
                      <option value="zh">zh</option>
                      <option value="zh-TW">zh-TW</option>
                </select>
            </th>
        </tr>
        <tr>
            <th>
                <textarea id="inputText" name="inputText" rows="10" cols="50" placeholder="Text to translate..."></textarea>
            </th>
            <th>
                <textarea id="outputText" name="outputText" rows="10" cols="50" placeholder="Translated text..."></textarea>
            </th>
        </tr>
        <tr>
            <th align="left">
                <button type="button" name="translateButton" onclick="doTranslate()">Translate</button>
                <button type="button" name="synthesizeButton" onclick="doSynthesizeInput()">Synthesize Input Speech</button>
                <button type="button" name="clearButton" onclick="clearInputs()">Clear</button>
            </th>
            <th align="left">
                <button type="button" name="synthesizeButton" onclick="doSynthesizeOutput()">Synthesize Output Speech</button>
            </th>
        </tr>
    </table>
    <script type="text/javascript">
        // set the focus to the input box
        document.getElementById("inputText").focus();

        /**
        * Change the region and endpoint.
        */
        AWS.config.region = 'region'; // Region

         /**
         * In a production application you should use a secure method of authenticating uses, such as the ones 
         * described here:
         *   https://docs.aws.amazon.com/sdk-for-javascript/v2/developer-guide/setting-credentials-browser.html
         *
         * Note that Amazon Translate does not work with Amazon Cognito Identity.
         *
         * For this example you place the credentials of an IAM user in the HTML page. The IAM user associated 
         * with these credentials must have permissions to call Amazon Translate. We recommend using the following 
         * permissions policy and nothing more, as anyone that has access to this HTML page will also have access to 
         * these hard-coded credentials.
         * {
         *     "Version": "2012-10-17",
         *     "Statement": [
         *         {
         *             "Action": [
         *                 "translate:TranslateText",
         *                 "polly:SynthesizeSpeech"
         *             ],
         *             "Resource": "*",
         *             "Effect": "Allow"
         *         }
         *     ]
         * }
         * 
         * For more information about the AWS Credentials object, see:
         *   http://docs.aws.amazon.com/AWSJavaScriptSDK/latest/AWS/Credentials.html
         */
        AWS.config.credentials = new AWS.Credentials("access key", "secret key");

        var translate = new AWS.Translate({region: AWS.config.region});
        var polly = new AWS.Polly();

        function doTranslate() {
            var inputText = document.getElementById('inputText').value;
            if (!inputText) {
                alert("Input text cannot be empty.");
                exit();
            }

            // get the language codes
            var sourceDropdown = document.getElementById("sourceLanguageCodeDropdown");
            var sourceLanguageCode = sourceDropdown.options[sourceDropdown.selectedIndex].text;

            var targetDropdown = document.getElementById("targetLanguageCodeDropdown");
            var targetLanguageCode = targetDropdown.options[targetDropdown.selectedIndex].text;

            var params = {
                Text: inputText,
                SourceLanguageCode: sourceLanguageCode,
                TargetLanguageCode: targetLanguageCode
            };

            translate.translateText(params, function(err, data) {
                if (err) {
                    console.log(err, err.stack);
                    alert("Error calling Amazon Translate. " + err.message);
                    return;
                }
                if (data) {
                    var outputTextArea = document.getElementById('outputText');
                    outputTextArea.value = data.TranslatedText;
                }
            });
        }

        function doSynthesizeInput() {
            var text = document.getElementById('inputText').value.trim();
            if (!text) {
                return;
            }
            var sourceLanguageCode = document.getElementById("sourceLanguageCodeDropdown").value;
            doSynthesize(text, sourceLanguageCode);
        }

        function doSynthesizeOutput() {
            var text = document.getElementById('outputText').value.trim();
            if (!text) {
                return;
            }
            var targetLanguageCode = document.getElementById("targetLanguageCodeDropdown").value;
            doSynthesize(text, targetLanguageCode);
        }

        function doSynthesize(text, languageCode) {
            var voiceId;
            switch (languageCode) {
                case "de":
                    voiceId = "Marlene";
                    break;
                case "en":
                    voiceId = "Joanna";
                    break;
                case "es":
                    voiceId = "Penelope";
                    break;
                case "fr":
                    voiceId = "Celine";
                    break;
                case "pt":
                    voiceId = "Vitoria";
                    break;
                default:
                    voiceId = null;
                    break;
            }
            if (!voiceId) {
                alert("Speech synthesis unsupported for language code: \"" + languageCode + "\"");
                return;
            }
            var params = {
                OutputFormat: "mp3", 
                SampleRate: "8000", 
                Text: text, 
                TextType: "text", 
                VoiceId: voiceId
            };
            polly.synthesizeSpeech(params, function(err, data) {
                if (err) {
                    console.log(err, err.stack); // an error occurred
                    alert("Error calling Amazon Polly. " + err.message);
                }
                else {
                    var uInt8Array = new Uint8Array(data.AudioStream);
                    var arrayBuffer = uInt8Array.buffer;
                    var blob = new Blob([arrayBuffer]);
                    var url = URL.createObjectURL(blob);

                    audioElement = new Audio([url]);
                    audioElement.play();
                }
            });
        }

        function clearInputs() {
            document.getElementById('inputText').value = "";
            document.getElementById('outputText').value = "";
            document.getElementById("sourceLanguageCodeDropdown").value = "en";
            document.getElementById("targetLanguageCodeDropdown").value = "en";
        }
    </script>
</body>

</html>
```