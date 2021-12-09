# Python compatibility<a name="python-compatibility"></a>

 CodeArtifact supports PyPI's `Legacy` APIs, except the `simple` API\. CodeArtifact does not support PyPI's `XML-RPC` or `JSON` APIs\. 

For more information, see the following on the Python Packaging Authority's GitHub repository\.
+ [Legacy API](https://github.com/pypa/warehouse/blob/master/docs/api-reference/legacy.rst)
+ [XML\-RPC API](https://github.com/pypa/warehouse/blob/master/docs/api-reference/xml-rpc.rst)
+ [JSON API](https://github.com/pypa/warehouse/blob/master/docs/api-reference/json.rst)

## pip command support<a name="pip-command-support"></a>

The following sections summarize the npm commands that are supported, by CodeArtifact repositories, in addition to specific commands that are not supported\.

**Topics**
+ [Supported commands that interact with a repository](#supported-pip-commands-that-interact-with-a-repository)
+ [Supported client\-side commands](#supported-pip-client-side-commands)

### Supported commands that interact with a repository<a name="supported-pip-commands-that-interact-with-a-repository"></a>

This section lists `pip` commands where the `pip` client makes one or more requests to the registry it's been configured with\. These commands have been verified to function correctly when invoked against an CodeArtifact repository\.


****  

| Command | Description | 
| --- | --- | 
|   [install](https://pip.pypa.io/en/stable/reference/pip_install/)   |  Install packages\.  | 
|   [download](https://pip.pypa.io/en/stable/reference/pip_download/)   |  Download packages\.  | 

CodeArtifact does not implement `pip search`\. If you have configured `pip` with a CodeArtifact repository, running `pip search` will search and show packages from [PyPI](https://pypi.org/)\.

### Supported client\-side commands<a name="supported-pip-client-side-commands"></a>

These commands don't require any direct interaction with a repository, so CodeArtifact does not need to do anything to support them\.


****  

| Command | Description | 
| --- | --- | 
|   [uninstall](https://pip.pypa.io/en/stable/reference/pip_uninstall/)   |  Uninstall packages\.  | 
|   [freeze](https://pip.pypa.io/en/stable/reference/pip_freeze/)   |  Output installed packages in requirements format\.  | 
|   [list](https://pip.pypa.io/en/stable/reference/pip_list/)   |  List installed packages\.  | 
|   [show](https://pip.pypa.io/en/stable/reference/pip_show/)   |  Show information about installed packages\.  | 
|   [check](https://pip.pypa.io/en/stable/reference/pip_check/)   |  Verify installed packages have compatible dependencies\.  | 
|   [config](https://pip.pypa.io/en/stable/reference/pip_config/)   |  Manage local and global configuration\.  | 
|   [wheel](https://pip.pypa.io/en/stable/reference/pip_wheel/)   |  Build wheels from your requirements\.  | 
|   [hash](https://pip.pypa.io/en/stable/reference/pip_hash/)   |  Compute hashes of package archives\.  | 
|   [completion](https://pip.pypa.io/en/stable/user_guide/#command-completion)   |  A helper command used for command completion\.  | 
|   [debug](https://pip.pypa.io/en/stable/reference/pip_debug/)   |  Show information useful for debugging\.  | 
|  help  |  Show help for commands\.  | 