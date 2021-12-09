# Getting Started<a name="getting-started"></a>

This getting started guide shows you how to create a campaign that returns movie recommendations for a user, based on historical data that consists of 100,000 movie ratings on 9,700 movies from 600 users\.

**To simplify this guide:**
+ We rely on the fact that a user saw a movie and not on what they rated the movie\. This simplifies the preparation of the training data\.
+ We don't record live user interaction events\. For information on capturing user events, see [Recording Events](recording-events.md)\.

To begin, download and prepare the training data\. Next, create an AWS Identity and Access Management \(IAM\) role that allows Amazon Personalize to access the data on your behalf\. After creating the training data and role, proceed to either [Getting Started \(Console\)](getting-started-console.md) or [Getting Started \(AWS CLI\)](getting-started-cli.md)\.

When you finish the getting started exercise, you might want to delete the resources you created\. 

**Topics**
+ [Getting Started Prerequisites](gs-prerequisites.md)
+ [Getting Started \(Console\)](getting-started-console.md)
+ [Getting Started \(AWS CLI\)](getting-started-cli.md)
+ [Getting Started \(AWS SDK for Python\)](getting-started-python.md)
+ [Clean Up Resources](gs-cleanup.md)