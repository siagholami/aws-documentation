# Managing Amazon ECS Instances<a name="tkv-ecs"></a>

AWS Explorer provides detailed views of Amazon Elastic Container Service \(Amazon ECS\) clusters and container repositories\. You can create, delete and manage cluster and container details from within the Visual Studio development environment\.

## Modifying service properties<a name="tkv-ecs-clusters-service-props"></a>

You can view service details, service events and service properties from the cluster view\.

1. In AWS Explorer, open the context \(right\-click\) menu for the cluster to manage, and then choose **View**\.

1. In the ECS Cluster view, click **Services** on the left, and then click the **Details** tab in the details view\. You can click **Events** to see event messages and **Deployments** to deployment status\.

1. Click **Edit**\. You can change the desired task count and the minimum and maximum healthy percent\.

1. Click **Save** to accept changes or **Cancel** to revert to existing values\.

## Stopping a task<a name="tkv-ecs-clusters-tasks-stop"></a>

You can see the current status of tasks and stop one or more tasks in the cluster view\.

 *To stop a task* 

1. In AWS Explorer, open the context \(right\-click\) menu for the cluster with tasks you wish to stop, and then choose **View**\.

1. In the ECS Cluster view, click **Tasks** on the left\.

1. Make sure **Desired Task Status** is set to `Running`\. Choose the individual tasks to stop and then click **Stop** or click **Stop All** to select and stop all running tasks\.

1. In the **Stop Tasks** dialog box, choose **Yes**\.

## Deleting a service<a name="tkv-ecs-clusters-service-delete"></a>

You can delete services from a cluster from the cluster view\.

 *To delete a cluster service* 

1. In AWS Explorer, open the context \(right\-click\) menu for the cluster with a service you want to delete, and then choose **View**\.

1. In the ECS Cluster view, click **Services** on the left, and then click **Delete**\.

1. In the **Delete Cluster** dialog box, if there is a load balancer and target group in your cluster, you can choose to delete them with the cluster\. They will not be used when the service is deleted\.

1. In the **Delete Cluster** dialog box, choose **OK**\. When the cluster is deleted, it will be removed from the AWS Explorer\.

## Deleting a cluster<a name="tkv-ecs-cluster-view"></a>

You can delete an Amazon Elastic Container Service cluster from AWS Explorer\.

 *To delete a cluster* 

1. In AWS Explorer, open the context \(right\-click\) menu for the cluster you want to delete under the **Clusters** node of **Amazon ECS**, and then choose **Delete**\.

1. In the **Delete Cluster** dialog box, choose **OK**\. When the cluster is deleted, it will be removed from the AWS Explorer\.

## Creating a repository<a name="tkv-ecs-repository-create"></a>

You can create an Amazon Elastic Container Registry repository from AWS Explorer\.

 *To create a repository* 

1. In AWS Explorer, open the context \(right\-click\) menu of the **Repositories** node under **Amazon ECS**, and then choose **Create Repository**\.

1. In the **Create Repository** dialog box, provide a repository name and then choose **OK**\.

## Deleting a repository<a name="id1"></a>

You can delete an Amazon Elastic Container Registry repository from AWS Explorer\.

 *To delete a repository* 

1. In AWS Explorer, open the context \(right\-click\) menu of the **Repositories** node under **Amazon ECS**, and then choose **Delete Repository**\.

1. In the **Delete Repository** dialog box, you can choose to delete the repository even if it contains images\. Otherwise, it will only be deleted if it is empty\. Click **Yes**\.