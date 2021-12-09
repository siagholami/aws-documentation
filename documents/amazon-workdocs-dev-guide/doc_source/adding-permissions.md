# Adding permissions to user on a resource<a name="adding-permissions"></a>

The following code snippet illustrates the request construction for adding permissions for a user on a resource\. In this example we are adding `CONTRIBUTOR` permissions to a `USER` on a resource\. This API can also be used to give permissions to a User or Group for a Folder or Document\.

```
AddResourcePermissionsRequest request = new AddResourcePermissionsRequest();
    request.setResourceId("resource-id");
    Collection<SharePrincipal> principals = new ArrayList<>();;
    SharePrincipal principal = new SharePrincipal();
    principal.setId("user-id");
    principal.setType(PrincipalType.USER);
    principal.setRole(RoleType.CONTRIBUTOR);
    principals.add(principal);
    request.setPrincipals(principals);
    AddResourcePermissionsResult result = workDocsClient.addResourcePermissions(request);
```