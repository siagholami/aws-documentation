# Requesting a package version with upstream repositories<a name="repo-upstream-behavior"></a>

 When a client \(for example, npm\) requests a package version from an CodeArtifact repository named `my-repo` that has multiple upstream repositories, the following can occur: 
+  If `my-repo` contains the requested package version, it is returned to the client\. 
+  If `my-repo` does not contain the requested package version, CodeArtifact looks for it in `my-repo`'s upstream repositories\. If the package version is found, a reference to it is copied to `my-repo`, and the package version is returned to the client\. 
+  If neither `my-repo` nor its upstream repositories contain the package version, an HTTP 404 `Not Found` response is returned to the client\.

 If a requested package version is found in an upstream repository, a reference to it is retained and is always available from the downstream repository\. The retained package version is not affected by any of the following: 
+  Deleting the upstream repository\. 
+  Disconnecting the upstream repository from the downstream repository\. 
+  Deleting the package version from the upstream repository\. 
+  Editing the package version in the upstream repository \(for example, by adding a new asset to it\)\. 

 When you add upstream repositories using the `create-repository` or `update-repository` command, the order they are passed to the `--upstreams` parameter determines their priority when a package version is requested\. Specify upstream repositories with `--upstreams` in the order that you want CodeArtifact to use when a package version is requested\. For more information, see [Upstream repository priority order](repo-upstream-search-order.md)\. 

 The maximum number of direct upstream repositories allowed for one repository is 10\. The maximum number of repositories CodeArtifact looks in when a package version is requested is 20\. 