# Using Amazon Translate to Translate a Chat Channel<a name="examples-twitch"></a>

You can use Amazon Translate for real time translation of chat messages\. This example uses a Twitch channel, but you can use it as a starting point for other real\-time streaming text like other chat platforms, customer service interactions, message boards, and more\. 

This example uses a web page that shows real\-time messages in English and their real\-time translations side\-by\-side\. You can send the messages to Amazon Polly to speak the text\. To follow a person in the chat, type their user name\. The app will speak only messages from that user\.

The code can be summarized as follows:
+ CSS and HTML to create the Web page\.
+ Initialization code that creates controllers for Amazon Translate and Amazon Polly\.
+ A call back function that gets executed when a chat message is received\.
+ A function that sends a chat message\.
+ A function that calls Amazon Translate to translate messages\.
+ A function that calls Amazon Polly to synthesize speech\.
+  Utility functions for managing the Web page\.

**To configure the example**

1. Install and Configure the AWS SDK for JavaScript\. For instructions for installing the SDK for JavaScript, see [Installing the SDK for JavaScript](https://docs.aws.amazon.com/sdk-for-javascript/v2/developer-guide/installing-jssdk.html)\.

1. Copy the code for the example to an HTML file on your Web server\.

1. Update the `<script>` tag to the location where you installed the SDK for JavaScript\.

1. Change the region and endpoint to the region where you want to run the Amazon Translate and Amazon Polly operations\. For a list of supported regions for Amazon Translate, see [AWS Regions and Endpoints](https://docs.aws.amazon.com/general/latest/gr/rande.html#translate_region) in the *AWS General Reference*\.

1. Create an IAM user with the minimum required permissions to run this example\. For information about creating an IAM user, see [ Creating an IAM User in Your AWS Account ](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_users_create.html) in the *AWS Identity and Access Management User Guide*\. For the required permissions policies, see [Amazon Translate Identity\-Based Policies](security_iam_service-with-iam.md#access-control-managing-permissions) and [ Using Identity\-Based Policies \(IAM Policies\) for Amazon Polly ](https://docs.aws.amazon.com/polly/latest/dg/using-identity-based-policies.html) in the *Amazon Polly Developer Guide*\.

1. Provide the access ID and secret key of the IAM user created in the previous step\.

1. Provide a Twitch user name and OAuth token for your account\. You can create a Twitch account at [https://www\.twitch\.tv](https://www.twitch.tv)\. You can create a Twitch OAuth token at [https://twitchapps\.com/tmi](https://twitchapps.com/tmi)\.

```
<!doctype html>
<html lang="en">
<head>
  <title>Amazon Translate</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Latest compiled and minified CSS for Bootstrap -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

   <!-- Custom CSS -->
   <style>
     .topHeader
     {
       background-color: #6441a4;
       padding: 10px;
       border-bottom: solid 1px #cacaca;
       color: white
     }

     .panelHeading
     {
       background-color: #6441a4 !important;
     }

     .panelBody
     {
      min-height: 450px;  max-height: 450px;overflow-y: scroll;
     }

     body{
        margin-left: 0px;
        margin-right: 0px;
        height: 100%;
      }
   </style>
</head>
<body>
  <div class="container-fluid">
    <!--Top Header-->
    <div class="row topHeader">
      <div class="col-md-12">
          <h4>Amazon Translate - Artificial Intelligence on AWS - Powerful machine learning for all Developers and Data Scientists</h4>
      </div>
    </div>

    <!--Status Label-->
    <div class="row">
      <div class="col-md-12">
        <p class="bg-info">
        <div id="connecting-div"></div>
        </p>
      </div>
    </div>

    <div class="row" style="padding: 10px;">
      <div class="col-md-6">
          <div class="form-inline">
            <div class="form-group">
              <input type="text" id="channel" class="form-control" value="" placeholder="Channel"/>
            </div>
            <div class="form-group">
              <select id="sourceLanguage" class="form-control">
                  <option value="en">en</option>
                  <option value="ar">ar</option>
                  <option value="de" selected="selected">de</option>
                  <option value="es">es</option>
                  <option value="fr">fr</option>
                  <option value="pt">pt</option>
                  <option value="zh">zh</option>
                </select>
            </div>
            <div class="form-group">
              <select id="targetLanguage" class="form-control">
                <option value="en" selected="selected">en</option>
                <option value="ar">ar</option>
                <option value="de">de</option>
                <option value="es">es</option>
                <option value="fr">fr</option>
                <option value="pt">pt</option>
                <option value="zh">zh</option>
              </select>
            </div>
            <div class="form-group">
              <button type="button" class="form-control" id="btn-go" onclick="connect()">Go</button>
              <button type="button" class="form-control" id="btn-stop" onclick="location.href='index.html';">Stop</button>
              <span id="status"></span>
            </div>
          </div>
        </div>
        <div class="col-md-6">
            <div class="form-inline">
              <div class="form-group">
                  <input type="checkbox" id="cbSpeak" value="Speak"> Speak Live Translation
                  <input type="text" id="follow" class="form-control" value="" placeholder="follow"/>
                </div>
            </div>
          </div>
      </div>

    <!--Chat Boxes-->
    <div class="row">
      <!--Live Chat-->
      <div class="col-md-6">
        <div class="panel panel-primary">
          <div class="panel-heading panelHeading">Live Chat</div>
            <div id="livechatc" class="panel-body panelBody">
              <div class="subscribe" id="livechat"></div>
          </div>
        </div>
      </div>
      <!--Live Chat-->
      <!--Translated Chat-->
      <div class="col-md-6">
        <div class="panel panel-primary">
          <div class="panel-heading panelHeading">Live Translation</div>
            <div id="livetranslationc" class="panel-body panelBody">
              <div class="imageDetected" id="livetranslation"></div>
          </div>
        </div>
      </div>
      <!--Translated Chat-->
    </div>

    <!--Send Message-->
    <div class="row">
        <div class="col-md-11">
            <input type="text" id="message" class="form-control"/>
        </div>
        <div class=" col-md-1">
          <button type="button" class="form-control btn btn-default" id="btn-send" onclick="sendMessage()">Send</button>
        </div>
    </div>
  </div>

   <!-- Latest compiled and minified JavaScript -->
   <!-- jQuery first, then Bootstrap JS -->
   <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

   <script src="aws-js-sdk/dist/aws-sdk-all.js"></script>
   <script src="http://cdn.tmijs.org/js/1.2.1/tmi.min.js" integrity="sha384-eE0n7sm1W7DOUI2Xh5I4qSpZTe6hupAO0ovLfqEy0yVJtGRBNfssdmjbJhEYm6Bw" crossorigin="anonymous"></script>
   <script>
     cred = {
          twitchUsername: "Twitch user name",
          twitchOAuthToken: "Twitch OAuth token",
          awsAccessKeyId: "access key",
          awsSecretAccessKey: "secret key"
     };

     AWS.config.region = 'region';
     ep = new AWS.Endpoint('endpoint');

     AWS.config.credentials = new AWS.Credentials(cred.awsAccessKeyId, cred.awsSecretAccessKey);
     window.translator = new AWS.Translate({endpoint: ep, region: AWS.config.region});

     /**************************Init and Connect to Chat****************************/
     function connect(){
       init();

       //Twitch Client
       var options = {
           options: {
             debug: false
           },
           connection: {
             cluster: "aws",
             reconnect: true
           },
           identity: {
             username: cred.twitchUsername,
             password: cred.twitchOAuthToken
           },
           channels: [con.channel]
       };

       window.client = tmi.client(options);

       window.client.connect();

       //Attached Handlers
       window.client.on("chat", onChat);
       window.client.on("connecting", onConnecting);
       window.client.on("connected", onConnected);

       //Disable UI Elements
       document.getElementById("sourceLanguage").disabled = true;
       document.getElementById("targetLanguage").disabled = true;
       document.getElementById("channel").disabled = true;
       document.getElementById("btn-go").disabled = true;
     }

     function init(){
       //Get UI Controls
       var lc = document.getElementById("livechat");
       var lt = document.getElementById("livetranslation")
       var lcc = document.getElementById("livechatc");
       var ltc = document.getElementById("livetranslationc")
       var cbspeak = document.getElementById("cbSpeak")
       var follow = document.getElementById("follow");
       var sendMessage = document.getElementById("message");

       //Cache values
       con = {
         channel: document.getElementById("channel").value,
         sourceLanguage: document.getElementById("sourceLanguage").value,
         targetLanguage: document.getElementById("targetLanguage").value,
         liveChatUI: lc,
         liveTranslationUI: lt,
         liveChatUIContainer: lcc,
         liveTranslationUIContainer: ltc,
         cbSpeak: cbspeak,
         follow: follow,
         sendMessage: sendMessage
       }

         lc.innerHTML = '';
         lt.innerHTML = '';

         //Speaker
        var voiceId = "Joanna";
        if(con.targetLanguage == "en")
           voiceId = "Joanna";
        else if(con.targetLanguage == "de")
             voiceId = "Marlene";
        else if(con.targetLanguage == "es")
            voiceId = "Conchita";
        else if(con.targetLanguage == "fr")
           voiceId = "Celine";
        else if(con.targetLanguage == "pt")
           voiceId = "Ines";
        else
           voiceId = "Joanna";
         window.audioPlayer = AudioPlayer(voiceId);
     }
     /**************************Init and Connect to Chat****************************/

     /**************************Receive and Translate Chat****************************/
     function onChat (channel, userstate, message, self) {
         // Don't listen to my own messages..
         if (self) return;

         //Translate
         if (message) {
           var username = userstate['username'];

           var params = {
               Text: message,
               SourceLanguageCode: con.sourceLanguage,
               TargetLanguageCode:  con.targetLanguage
           };

           window.translator.translateText(params, function onIncomingMessageTranslate(err, data) {
              if (err) {
                 console.log("Error calling Translate. " + err.message + err.stack);
             }
              if (data) {
                  console.log("M: " + message);
                  console.log("T: " + data.TranslatedText);

                  //Print original message in chat UI
                  con.liveChatUI.innerHTML += '<strong>' + username + '</strong>: ' +  message + '<br>';

                  //Print translation in translation UI
                  con.liveTranslationUI.innerHTML += '<strong>' + username + '</strong>: ' + data.TranslatedText + '<br>';

                  //If speak translation in enabled, speak translated message
                  if(con.cbSpeak.checked){
                    if(con.follow.value == "" || username == con.follow.value)
                      audioPlayer.Speak(username + " says " + data.TranslatedText);
                  }

                  //Scroll chat and translated UI to bottom to keep focus on latest messages
                  con.liveChatUIContainer.scrollTop = con.liveChatUIContainer.scrollHeight;
                  con.liveTranslationUIContainer.scrollTop = con.liveTranslationUIContainer.scrollHeight;
                }
           });
         }
     }
     /**************************Receive and Translate Chat****************************/

     /**************************Client Connecting****************************/
     function onConnecting (address, port) {
         document.getElementById("status").innerHTML = " [ Connecting...]"
     }

     function onConnected (address, port) {
         document.getElementById("status").innerHTML = " [ Connected ]"
         window.audioPlayer.Speak("Connected to channel " + con.channel + ". You should now be getting live chat messages.");
     }
     /**************************Client Connecting****************************/

     /**************************Send Message****************************/
     function sendMessage(){
          if(con.sendMessage.value){
            message = con.sendMessage.value;
            var params = {
                Text: con.sendMessage.value,
                SourceLanguageCode: con.targetLanguage,
                TargetLanguageCode:  con.sourceLanguage
            };

            window.translator.translateText(params, function onSendMessageTranslate(err, data) {
                  if (err) {
                     console.log("Error calling Translate. " + err.message + err.stack);
                  }
                  if (data) {
                      console.log("M: " + message);
                      console.log("T: " + data.TranslatedText);

                      //Send message to chat
                      window.client.action(con.channel, data.TranslatedText);

                      //Clear send message UI
                      con.sendMessage.value = "";

                      //Print original message in Translated UI
                      con.liveTranslationUI.innerHTML += '<strong> ME: </strong>: ' +  message + '<br>';

                      //Print translated message in Chat UI
                      con.liveChatUI.innerHTML += '<strong> ME: </strong>: ' + data.TranslatedText + '<br>';

                      //Scroll chat and translated UI to bottom to keep focus on latest messages
                      con.liveChatUIContainer.scrollTop = con.liveChatUIContainer.scrollHeight;
                      con.liveTranslationUIContainer.scrollTop = con.liveTranslationUIContainer.scrollHeight;
                  }
            });
          }
     }
     /**************************Send Message****************************/

     /**************************Audio player****************************/
     function AudioPlayer(voiceId) {
         var audioPlayer = document.createElement('audio');
         audioPlayer.setAttribute("id", "audioPlayer");
         document.body.appendChild(audioPlayer);

         var isSpeaking = false;

         var speaker = {
             self: this,
             playlist:[],

             Speak: function (text) {
                 //If currently speaking a message, add new message to the playlist
                 if (isSpeaking) {
                     this.playlist.push(text);
                 } else {
                     speakTextMessage(text).then(speakNextTextMessage)
                 }
             }
         }

         // Speak text message
         function speakTextMessage(text) {
             return new Promise(function (resolve, reject) {
                 isSpeaking = true;
                 getAudioStream(text).then(playAudioStream).then(resolve);
             });
         }

         // Speak next message in the list
         function speakNextTextMessage() {
             var pl = speaker.playlist;
             if (pl.length > 0) {
                 var txt = pl[0];
                 pl.splice(0, 1);
                 speakTextMessage(txt).then(speakNextTextMessage);
             }
         }

         // Get synthesized speech from Amazon polly
         function getAudioStream(textMessage) {
             return new Promise(function (resolve, reject) {
                 var polly = new AWS.Polly();
                 var params = {
                     OutputFormat: 'mp3',
                     Text: textMessage,
                     VoiceId: voiceId
                 }
                 polly.synthesizeSpeech(params, function (err, data) {
                     if (err)
                         reject(err);
                     else
                         resolve(data.AudioStream);
                 });
             });
         }

         // Play audio stream
         function playAudioStream(audioStream) {
             return new Promise(function (resolve, reject) {
                 var uInt8Array = new Uint8Array(audioStream);
                 var arrayBuffer = uInt8Array.buffer;
                 var blob = new Blob([arrayBuffer]);

                 var url = URL.createObjectURL(blob);
                 audioPlayer.src = url;
                 audioPlayer.addEventListener("ended", function () {
                     isSpeaking = false;
                     resolve();
                 });
                 audioPlayer.play();
             });
         }

         return speaker;
     }
     /**************************Audio player****************************/
   </script>
</body>
</html>
```