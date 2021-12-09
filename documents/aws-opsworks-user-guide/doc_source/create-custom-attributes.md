# Attributes File<a name="create-custom-attributes"></a>

Before looking at the recipes, it is useful to first examine the Tomcat cookbook's attributes file, which contains variety of configuration settings that the recipes use\. Attributes aren't required; you can simply hardcode these values in your recipes or templates\. However, if you define configuration settings using attributes, you can use the AWS OpsWorks Stacks console or API to modify the values by defining custom JSON attributes, which is simpler and more flexible than rewriting the recipe or template code every time you want to change a setting\. This approach allows you, for example, to use the same cookbook for multiple stacks, but configure the Tomcat server differently for each stack\. For more information on attributes and how to override them, see [Overriding Attributes](workingcookbook-attributes.md)\.

The following example shows the complete attributes file, `default.rb`, which is located in the Tomcat cookbook's `attributes` directory\.

```
default['tomcat']['base_version'] = 6
default['tomcat']['port'] = 8080
default['tomcat']['secure_port'] = 8443
default['tomcat']['ajp_port'] = 8009
default['tomcat']['shutdown_port'] = 8005
default['tomcat']['uri_encoding'] = 'UTF-8'
default['tomcat']['unpack_wars'] = true
default['tomcat']['auto_deploy'] = true
case node[:platform]
when 'centos', 'redhat', 'fedora', 'amazon'
  default['tomcat']['java_opts'] = ''
when 'debian', 'ubuntu'
  default['tomcat']['java_opts'] = '-Djava.awt.headless=true -Xmx128m -XX:+UseConcMarkSweepGC'
end
default['tomcat']['catalina_base_dir'] = "/etc/tomcat#{node['tomcat']['base_version']}"
default['tomcat']['webapps_base_dir'] = "/var/lib/tomcat#{node['tomcat']['base_version']}/webapps"
default['tomcat']['lib_dir'] = "/usr/share/tomcat#{node['tomcat']['base_version']}/lib"
default['tomcat']['java_dir'] = '/usr/share/java'
default['tomcat']['mysql_connector_jar'] = 'mysql-connector-java.jar'
default['tomcat']['apache_tomcat_bind_mod'] = 'proxy_http' # or: 'proxy_ajp'
default['tomcat']['apache_tomcat_bind_config'] = 'tomcat_bind.conf'
default['tomcat']['apache_tomcat_bind_path'] = '/tc/'
default['tomcat']['webapps_dir_entries_to_delete'] = %w(config log public tmp)
case node[:platform]
when 'centos', 'redhat', 'fedora', 'amazon'
  default['tomcat']['user'] = 'tomcat'
  default['tomcat']['group'] = 'tomcat'
  default['tomcat']['system_env_dir'] = '/etc/sysconfig'
when 'debian', 'ubuntu'
  default['tomcat']['user'] = "tomcat#{node['tomcat']['base_version']}"
  default['tomcat']['group'] = "tomcat#{node['tomcat']['base_version']}"
  default['tomcat']['system_env_dir'] = '/etc/default'
end
```

The settings themselves are discussed later in the related section\. The following notes apply generally:
+ All of the node definitions are `default` type, so you can override them with [custom JSON attributes](workingcookbook-json-override.md)\.
+ The file uses a `case` statement to conditionally set some attribute values based on instance's operating system\.

  The `platform` node is generated by Chef's Ohai tool and represents the instance's operating system\. 