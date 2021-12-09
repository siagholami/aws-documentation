# Trouble Shooting<a name="trouble-shooting"></a>

## AWS CodeCommit plugin \- Eclipse was unable to write to the secure store\.<a name="aws-codecommit-plugin-eclipse-was-unable-to-write-to-the-secure-store"></a>

 *Problem:* when checking out or checking in an AWS CodeCommit repository, I got an error saying *Writing to secure store failed, No password provided\.* 

 *Solution:* Open up *Preferences* \-> *General* \-> *Security* \-> *Security Storage* \-> *Contents* \-> *GIT* \-> *Delete*\.