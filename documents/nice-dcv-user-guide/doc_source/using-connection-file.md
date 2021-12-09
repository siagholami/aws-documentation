# Using a Connection File<a name="using-connection-file"></a>

The Windows, Linux, and macOS native clients enable you to create a connection file that you can use to instantly connect to a NICE DCV session\. 

**Topics**
+ [Creating the Connection File](#connection-file-create)
+ [Supported Parameters](#connection-file-params)
+ [Executing the Connection File](#connection-file-execute)

## Creating the Connection File<a name="connection-file-create"></a>

The connection file is a text\-based file with a `.dcv` file extension\. The format of the `.dcv` file is similar to that of an `.ini` file, where the file includes `[groups]` followed by the parameters and their values\. The groups and parameters take the following format:

```
[group_name]
parameter_name=parameter_value
```

For example:

```
[options]
fullscreen=true
```

For the Windows client, you can create a connection file for a specific NICE DCV session directly from the client, or you can create a connection file from scratch using a text editor\. For the Linux and macOS clients, you can only create a connection file from scratch using a text editor\.

**Note**  
The procedure for creating a connection file from scratch using a text editor is the same for the Windows, Linux, and macOS clients\.

**To create a connection file from the Windows client**

1. Open the Windows client and connect to the server and session for which to create the file\.

1. Select the NICE DCV server's hostname in the top\-right corner and choose **Save Connection As**\.

1. In the **Save As** window, enter a file name and destination folder, and choose **Save**\.

By default, when you create a connection file using the Windows client, the file includes the `format`, `host`, `port`, `user`, and `proxytype` parameters\. These parameters are required to connect to the session from which the file was created\. You can manually customize or add parameters at any time by editing the file using a text editor\.

**To create a connection file from scratch using a text editor**

1. Create a `.dcv` file with the following file name format: `file_name.dcv`

1. Open the `.dcv` file using your preferred text editor\.

1. Add the `[version]` group and `format` parameter to the top of the file in the following format:

   ```
   [version]
   format=1.0
   ```
**Important**  
If the `.dcv` file does not include the `[version]` group and `format` parameter, parsing fails\.

1. Add the required parameter groups using the following format:

   ```
   [group_name]
   ```

   For more information about the parameter groups, see [Supported Parameters](#connection-file-params)\.

1. Add the parameters and parameter values after the groups using the following format:

   ```
   parameter_name=parameter_value
   ```
**Note**  
Parameter names are case sensitive\.
Do not enclose string parameter values in quotation marks\.

   For more information about the parameters and parameter values, see [Supported Parameters](#connection-file-params)\.

1. Save the changes and close the `.dcv` file\.

You can also use this procedure to add additional parameters to an existing connection file at any time\.

## Supported Parameters<a name="connection-file-params"></a>

Currently, the `.dcv` file supports parameters in three parameter groups—`[version]`, `[connect]`, and `[options]`\. The following tables list the groups and their available parameters\.

**Topics**
+ [`[version]` Parameters](#param-version)
+ [`[connect]` Parameters](#param-connect)
+ [`[options]` Parameters](#param-option)

### `[version]` Parameters<a name="param-version"></a>

**Important**  
This is a required group\. If your `.dcv` file does not include this group, parsing fails\.

The following table lists the parameters that can be specified in the `[version]` group\.


| Parameter | Type | Default value | Description | 
| --- | --- | --- | --- | 
| format | string |  |   This is a required parameter\. The parameter value must be `1.0`\. If your `.dcv` file does not include this parameter, parsing fails\.   | 

### `[connect]` Parameters<a name="param-connect"></a>

The following table lists the parameters that can be specified in the `[connect]` group\.


| Parameter | Type | Default value | Description | 
| --- | --- | --- | --- | 
| host | String |  | The hostname of the NICE DCV server hosting the session\. | 
| port | Integer | 8443 | The port to use when connecting to the NICE DCV server\. | 
| weburlpath | String |  | A custom path on the NICE DCV server to which to connect\. For example, if you specify customPath, the client attempts to connect to host:port/customPath\. | 
| sessionid | String |  | The ID of the NICE DCV session to which to connect\. | 
| authtoken | String |  | The authentication token to be used for the connection\. If you specify an authtoken, you must also specify a sessionid\. When using authtoken, you can omit the user and password parameters\. | 
| user | String |  | The user name to use when connecting to the NICE DCV server\. | 
| password | String |  | The password to use when connecting to the NICE DCV server\. The password is not encrypted\. | 
| proxytype | String | SYSTEM | The proxy type to be used\. Valid values include: HTTPS, HTTP, SOCKS5\|SOCKS, SYSTEM, or NONE\|DIRECT\. If you specify SYSTEM, your computer's proxy settings are used\. | 
| proxyhost | String |  | The address of the proxy server to be used if connecting through a proxy server\. | 
| proxyport | Integer |  | The port to be used if connecting through a proxy server\. | 
| proxyuser | String |  | The user name to be used for proxy authentication\. | 
| proxypassword | String |  | The password to be used for proxy authentication\. The password is not encrypted\. | 

### `[options]` Parameters<a name="param-option"></a>

The following table lists the parameters that can be specified in the `[options]` group\.


| Parameter | Type | Default value | Description | 
| --- | --- | --- | --- | 
| fullscreen | Boolean | false | Indicates whether the client should start in full screen mode\. | 
| useallmonitors | Boolean | false | Indicates whether the client should use all monitors when starting full screen mode\. | 
| promptreconnect | Boolean | true | Indicates whether the client should prompt you to reconnect after you disconnect from a session\. If the parameter is set to true, you are redirected to the sign\-in screen when you disconnect\. If the parameter is set to false, the client closes when you disconnect\. | 

## Executing the Connection File<a name="connection-file-execute"></a>

To execute a `.dcv` connection file, navigate to the file and double\-click it\.

Or, specify the file path as an argument for the `dcvviewer` command\. For example:
+ Windows client

  ```
  C:\> dcvviewer.exe path\connection_file_name.dcv
  ```
+ Linux and macOS client

  ```
  $ dcvviewer path/connection_file_name.dcv
  ```