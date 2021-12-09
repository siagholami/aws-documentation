# File System Is In a Misconfigured State<a name="misconfigured-ad-config"></a>

When you update your file system's self\-managed Active Directory configuration, a number of causes can put your file system into the **Misconfigured** state\. Each cause has its own resolution, as follows\.

**Potential Cause**  
Amazon FSx can't communicate with your Microsoft Active Directory domain controller or controllers\. This is because Amazon FSx can't reach either the DNS servers provided or domain controllers for your domain\. For more information, see [Using Amazon FSx with Your Self\-Managed Microsoft Active Directory](self-managed-AD.md)\. 

**Resolution**  
Make sure that your networking configuration allows traffic from the file system to the domain controller\. To update the configuration, you can use the console\. On the navigation pane, choose **File systems**, and choose the file system to change\. On its **File system details** page, you can find **Update** on the **Networking and security** tab\. You can also use the Amazon FSx API operation `update-file-system`\. For more information, see [Using Amazon FSx with Your Self\-Managed Microsoft Active Directory](self-managed-AD.md)\.

**Potential Cause**  
Amazon FSx can't establish a connection with your Microsoft Active Directory domain controller or controllers\. This is because the service account credentials provided are invalid\. For more information, see [Using Amazon FSx with Your Self\-Managed Microsoft Active Directory](self-managed-AD.md)\. 

**Resolution**  
Verify the service account credentials, then update the configuration with new service account credentials\. To update the configuration, you can use the console\. On the navigation pane, choose **File systems**, and choose the file system to change\. On its **File system details** page, you can find **Update** on the **Networking and security** tab\. You can also use the Amazon FSx API operation `update-file-system`\. To learn more, see the [UpdateFileSystem](https://docs.aws.amazon.com/fsx/latest/APIReference/API_UpdateFileSystem.html) in the *Amazon FSx API Reference*\. 

**Potential Cause**  
Amazon FSx can't establish a connection to your Microsoft Active Directory domain controllers\. This is because the service account provided doesn't have permission to join the file system to the domain with the specified OU\. 

**Resolution**  
Add the required permissions to the Amazon FSx service account, or create a new service account with the required permissions\. For more information about doing this, see [ Delegating Privileges to Your Amazon FSx Service Account ](self-managed-AD-best-practices.md#connect_delegate_privileges)\. Then update the file system's self\-managed AD configuration with the new service account credentials\. To update the configuration, you can use the console\. On the navigation pane, choose **File systems**, and choose the file system to change\. On its **File system details** page, you can find **Update** on the **Networking and security** tab\. You can also use the Amazon FSx API operation `update-file-system`\. To learn more, see the [UpdateFileSystem](https://docs.aws.amazon.com/fsx/latest/APIReference/API_UpdateFileSystem.html) in the *Amazon FSx API Reference*\.

**Potential Cause**  
Amazon FSx can't establish a connection to your Microsoft Active Directory domain controllers\. In this case, this is because the service account provided has reached the maximum number of computers that it can join to the domain\. 

**Resolution**  
 Identify another service account or create a new service account that can join new computers to the domain\. Then update the file system's self\-managed AD configuration with the new service account credentials\. To update the configuration, you can use the console\. On the navigation pane, choose **File systems**, and choose the file system to change\. On its **File system details** page, you can find **Update** on the **Networking and security** tab\. You can also use the Amazon FSx API operation `update-file-system`\. For more information, see [UpdateFileSystem](https://docs.aws.amazon.com/fsx/latest/APIReference/API_UpdateFileSystem.html) in the *Amazon FSx API Reference*\.

**Potential Cause**  
Amazon FSx can't establish a connection to your Microsoft Active Directory domain controllers because the service account provided doesn't have access to the OU specified\. 

**Resolution**  
 Identify another service account or create a new service account that has access to the OU\. Then update the file system's self\-managed AD configuration with the new service account credentials\. To update the configuration, you can use the console\. On the navigation pane, choose **File systems**, and choose the file system to change\. On its **File system details** page, you can find **Update** on the **Networking and security** tab\. You can also use the Amazon FSx API operation `update-file-system`\. For more information, see the [UpdateFileSystem](https://docs.aws.amazon.com/fsx/latest/APIReference/API_UpdateFileSystem.html) in the *Amazon FSx API Reference*\.