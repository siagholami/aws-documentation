# Step 1: Preparing for migration<a name="prepare"></a>

**To prepare for migration**

1. On your Amazon WorkDocs site, under **My Documents**, create a folder that you want to migrate your files and folders to\.

1. Confirm that the files to be migrated are less than 5 TB each\. Each file name must be 255 characters or fewer\. Amazon WorkDocs Drive displays only files with a full directory path of 260 characters or fewer\.

**Warning**  
Attempting to migrate files or folders with names containing the following characters can cause errors and stop the migration process\. If this occurs, choose **Download report** to download a log listing the errors, the files that failed to migrate, and any successfully migrated files\.
+ **Trailing spaces**–For example: an extra space at the end of a file name\.
+ **Periods at the beginning or end**–For example: `.file`, `.file.ppt`, `.`, `..`, or `file.`
+ **Tildes at the beginning or end**–For example: `file.doc~`, `~file.doc`, or `~$file.doc`
+ **File names ending in `.tmp`**–For example: `file.tmp`
+ **File names exactly matching these case\-sensitive terms**–`Microsoft User Data`, `Outlook files`, `Thumbs.db`, or `Thumbnails`
+ **File names containing any of these characters**–`*` \(asterisk\), `/` \(forward slash\), `\` \(back slash\), `:` \(colon\), `<` \(less than\), `>` \(greater than\), `?` \(question mark\), `|` \(vertical bar/pipe\), `"` \(double quotes\), or `\202E` \(character code 202E\)\.