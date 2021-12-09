# Update user personal PINs<a name="update-pins"></a>

The following example shows how to reset the personal meeting PIN for a specified Amazon Chime user\.

```
ResetPersonalPINRequest request = new ResetPersonalPINRequest()
    .withAccountId("chimeAccountId")
    .withUserId("userId");

ResetPersonalPINResult result = chime.resetPersonalPIN(request);

User user = result.getUser();
user.getPersonalPIN()
```