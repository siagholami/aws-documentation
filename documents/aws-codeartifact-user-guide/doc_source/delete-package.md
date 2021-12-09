# Delete a package version<a name="delete-package"></a>

You can delete one or more package versions at a time using the `delete-package-versions` command\. The following deletes versions `4.0.0`, `4.0.1`, and `5.0.0` of the npm package named `my-package` in the `my-repo` in the `my-domain` domain:

```
aws codeartifact delete-package-versions --domain my-domain --domain-owner domain-owner-id --repository my-repo \
  --format npm --package my-package --versions 4.0.0 4.0.1 5.0.0
```

You can confirm that the versions were deleted by running `list-package-versions` for the same package name:

```
aws codeartifact list-package-versions --domain my-domain --domain-owner domain-owner-id --repository my-repo \
   --format npm --package my-package
```