# Digital Audio<a name="audio"></a>

 Digital audio is stored, transferred, and played back as channels, and you can store, transfer, and play back multiple channels in tracks, also known as streams\. Multiple channels and tracks allow you to include extra information such as surround sound, stereo, and multiple languages in files\. For example, you can have a file with a surround sound track that has six channels and a stereo track with two channels\. You can use Elastic Transcoder to change the number of tracks and channels in your file\. If you have a file that has only a surround sound six\-channel track, you can use Elastic Transcoder to create a file that has a stereo two\-channel track\.

A single channel carries the information played by a single speaker\. For example, a stereo track with two channels sends one channel to the left speaker and the other channel to the right speaker\. You can use tracks to choose between different sets of channels\. For example, you can have a file with two tracks: one track with two channels, and one track with six channels\. When your player plays that file, it can use the two\-channel track for a stereo speaker system, or the six\-channel track for a surround sound speaker system\. 

Not all tracks have audio information\. Tracks without audio are known as Mit Out Sound \(MOS\) tracks\. You can use MOS tracks and a sound editing program to add sound effects and music to your file\. If your output file uses an MXF container, you can use Elastic Transcoder to add MOS tracks to your file\.

Elastic Transcoder defaults to a single track, but lets you choose the number of channels in that track\. You can choose up to two tracks, or pass through the same number of channels that your input has\. If you transcode a file with an MXF container, Elastic Transcoder lets you create multiple tracks for your output\.

You can use Elastic Transcoder presets to do the following:
+ Remove audio from an output
+ Duplicate mono to multiple channels
+ Combine \(downmix\) stereo to mono
+ Downmix surround sound to stereo or mono
+ Pass through the existing channels
+ \(MXF only\) Add MOS tracks to your output

For more information about using Elastic Transcoder to transcode audio, see [Channels](preset-settings.md#preset-settings-audio-channels)\.