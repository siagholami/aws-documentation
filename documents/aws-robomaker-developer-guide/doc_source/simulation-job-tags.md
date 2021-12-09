# Managing Tags in a Simulation Job<a name="simulation-job-tags"></a>

To help you manage your simulation jobs, you can optionally assign your own metadata\. For example, you can categorize simulation jobs by the type of terrain simulated, test result, or robot hardware configuration\. This helps you organize and track simulation job results\. 

This section includes information about using ROS command\-line tools and code\. For more information about managing tags with the AWS RoboMaker API, see [TagResource](https://docs.aws.amazon.com/robomaker/latest/dg/API_TagResource.html)\. For more information about tagging, see [Tagging Your AWS RoboMaker Resources](tagging-robomaker.md)\. 

You must have permissions to tag, untag, and list tags for a simulation job\. For more information, see [Permissions Required to use Tags from a ROS Application or ROS Command Line](auth-and-access-control.md#auth_access_required-permissions-iam-eventing)\. 

**Note**  
This topic applies to ROS Kinetic and ROS Melodic\. For more information about ROS 2 Dashing, see [ROS 2 Dashing \(Beta\)](robomaker-ros2-beta.md)\. 

## Using tags using ROS command\-line tools<a name="simulation-job-tags-tools"></a>

You can use the ROS command\-line tool `rosservice` to add, list, and remove tags for the simulation job\. The following example adds the tags "status" and "name", lists the tags, and then removes both of the tags\. 

The following example adds the tags "status" and "pass" to the current simulation job:

**Note**  
You must have permissions to call `TagResource`, `UntagResource`, and `ListTagsForResource`\. For more information about permissions, see [Authentication and Access Control for AWS RoboMaker](auth-and-access-control.md)\.

```
robomaker@9cc6d11dfa46:~$rosservice call /robomaker/job/add_tags "[{key: status, value: pass}, {key: name, value: my_test}]"
success: True
message: ''
```

The following example lists all tags for the simulation job:

```
robomaker@9cc6d11dfa46:~$rosservice call /robomaker/job/list_tags
success: True
message: ''
tags:
  -
    key: "status"
    value: "pass"
  -
    key: "name"
    value: "my_test"
```

The following example removes the tags "status" and "pass" from the current simulation job:

```
robomaker@9cc6d11dfa46:~$rosservice call /robomaker/job/remove_tags "[status, name]"
success: True
message: ''
```

## Using tags from code in a simulation application<a name="simulation-job-tags-code"></a>

The following example provides a Python function you can use to manage tags in your simulation application:

```
#!/usr/bin/env python

# before using, add a dependency on the AWS RoboMaker package
# in package.xml to access the service (.srv) types:
# 
#     <depend>aws_robomaker_simulation_ros_pkgs</deped>
#
# See the repo at https://github.com/aws-robotics/aws-robomaker-simulation-ros-pkgs.
#
import rospy
from robomaker_simulation_msgs.msg import Tag
from robomaker_simulation_msgs.srv import AddTags

# add a list of Tag(key,value) to the simulation job
def add_tags(tags):
    # ensure the service is ready
    rospy.wait_for_service('/robomaker/job/add_tags', timeout=30)    
    requestAddTags = rospy.ServiceProxy('/robomaker/job/add_tags', AddTags)
    response = requestAddTags(tags)
    if response.success:
        rospy.loginfo("Successfully added tags: %s", tags)
    else:
        rospy.logerr("Add tags request failed for tags (%s): %s", tags, response.message)
```

For more information about ``