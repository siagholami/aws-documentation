# Terminology<a name="quicksight-developer-terminology"></a>

*Caller identity:* – The identity of the AWS Identity and Access Management \(IAM\) user making an API request\. The identity of the caller is determined by Amazon QuickSight using the signature attached to the request\. Through the use of our provided SDK clients, no manual steps are necessary to generate the signature or attach it to the requests\. However, you can do it manually if you want to\. 

*Invoker identity:* – In addition to the caller identity, but not as a replacement for it, you can assume a caller’s identity through the Assume Role functionality when making calls to Amazon QuickSight\. We approve callers through their invoker’s identity\. This is done to avoid having to explicitly add multiple accounts belonging to the same Amazon QuickSight subscription\. 

*QuickSight user:* – This is an Amazon QuickSight user identity acted upon by your API call\. This user is not identical to the caller identity but night be the one that maps to him/her within Amazon QuickSight\. 

*QuickSight ARN:* – Amazon Resource Name\. Amazon QuickSight resources —in this context users and groups— are identified using their name or ARN\. For example, these are the ARNs for a group named `MyGroup1`, a user named `User1`, and a dashboard with the ID `1a1ac2b2-3fc3-4b44-5e5d-c6db6778df89`:

```
arn:aws:quicksight:us-east-1:111122223333:group/default/MyGroup1
arn:aws:quicksight:us-east-1:111122223333:user/default/User1
arn:aws:quicksight:us-west-2:111122223333:dashboard/1a1ac2b2-3fc3-4b44-5e5d-c6db6778df89
```

Depending on the scenario, you might need to provide an entity’s name, ID, or ARN\. You can retrieve the ARN if you have the name, using some of the operations described in the following sections\. 