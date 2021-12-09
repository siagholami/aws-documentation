# Contributing to the Lumberyard Public Release Notes

The Amazon Lumberyard (beta) Release Notes are formed and managed on GitHub in this repo (https://github.com/awsdocs/amazon-lumberyard-release-notes). Release Notes for the next Lumberyard version are in a formative state and are provided as early information as to the state of the release. They do **not** represent a commitment for delivery in the final release version. We develop these in public to give customers an early look into what we know about a coming release and to centralize our Release Notes development process.

Previous Release Notes are also archived here.

Anyone can contribute to the Release Notes with a pull request (PR).  The Amazon Lumberyard Docs Team will review all PRs within 5 business days of submission. Amazon Lumberyard reserves the right to reject any Release Notes contribution for any reason.

You can also provide feedback by submitting Issues. As with PRs, we will respond to Issues within 5 business days of submission. We invite you to use this rvvepo as a formal channel of communication with the Lumberyard team around releases.

This is a public repo and all branches are visible. If you want to collaborate on private changes, you can fork this repo to your own GitHub account, grant access to collaborators, and submit a PR to this repo from your fork when the content is ready for public visibility.

## Lumberyard Public Release Notes Structure

The Release Notes are structured under two folders:

- '/{current-release}', e.g. '/1.22' -- This contains the Release Notes for the **current** release.
- '/archive' -- This contains an archive of prior Release Notes, organized by release version number (for example, '/archive/1.21').

In the {current-release} folder or a version-numbered folder in '/archive', you'll find 4 Markdown files:

- 'index.md': Authored by the Lumberyard Docs Team at the time of release. This file contains the highlighted changes for the release and links to the other pages in the Release Notes.
- 'fixes.md': A comprehensive list of fixes to Lumberyard for a specific release.
- 'improvements-changes.md': A list of significant changes and improvements made to Lumberyard for a specific release.
- 'known-issues.md': An updated list of known bugs, problems, and issues with Lumberyard as of the specific release. Please contribute to this list and keep it up-to-date!

## Lumberyard Public Release Notes Workflow

After a release completes, the Lumberyard Docs Team will move this release's Release Notes into the '/archive' folder under a directory named after the version number (e.g. '/1.21'). Then, we copy the templates from the '/templates' folder to the folder for the current release. Be sure you remove the '-templates' part of the file name!

Copy Known Issues over from the text of 'known-issues.md' in the prior release. Spot-check it to make sure everything was correctly captured. Remove any fixed issues. This allows contributors to remove Known Issues as they are addressed, and for the community to contribute new ones as they uncover them.

**NOTE**: Do NOT specify the version number or date(s) until the day of the release. Use "the next version of the Amazon Lumberyard beta" instead to replace any placeholder values for version numbers or dates. All PRs that specify a specific future release version will be rejected if they specify a date or version number before the release date itself.
