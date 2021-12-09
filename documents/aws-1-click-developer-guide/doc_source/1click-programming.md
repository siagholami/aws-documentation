# AWS IoT 1\-Click Programming Model<a name="1click-programming"></a>

To build applications using AWS IoT 1\-Click devices, programmers use the [AWS IoT 1\-Click Devices API](https://docs.aws.amazon.com/iot-1-click/1.0/devices-apireference/) and the [AWS IoT 1\-Click Projects API](https://docs.aws.amazon.com/iot-1-click/latest/projects-apireference/)\. The Devices API interacts with the AWS IoT 1\-Click devices component and handles events coming from devices\. These events include enabling and disabling the devices and defining event formats and the actions \(Lambda functions\) that they trigger\. The Devices API is tightly coupled with the AWS components that reside in the region where the manufacturer registered the devices\. This is why [AWS device regions](1click-devices.md) might be different from the region where the customer is using the devices\. The Projects API interacts with the AWS IoT 1\-Click Projects service and is used to manage AWS IoT 1\-Click devices in aggregate, which makes it possible to: 
+ Group devices into projects\.
+ Create templates used to set actions for all devices in the project\.
+ Define attributes storing contextual data pertinent to the project\.

You can use the AWS IoT 1\-Click programming model to program individual devices by using the Devices API\. In this case, you will use the AWS IoT 1\-Click device type\. The API defines standard event formats and a list of methods that form the programming interface for all devices of that type\. To invoke methods pertaining to a given device type, a programmer can use the [`InvokeDeviceMethod` API](https://docs.aws.amazon.com/iot-1-click/1.0/devices-apireference/API_InvokeDeviceMethod.html) and specify the device method as a parameter\.

For example, all AWS IoT 1\-Click devices that have the device type "button" emit events associated with clicks and have methods to set callback functions that are invoked when the device is clicked\. For information about the button interface, see [Interfaces by Device Type](1click-devices.md)\. Here is the code to set this callback function:

```
    String methodParameters = mapper.writeValueAsString(
        SetOnClickCallbackRequestParameters.builder()
                .deviceId(deviceId)
                .callback(DeviceCallback.builder()
                        .awsLambdaArn(“arn:aws:lambda:us-west-2:123456789012:MyButtonListener”)
                        .build())
                .build());
    InvokeDeviceMethodRequest request = new InvokeDeviceMethodRequest()
        .withDeviceMethod(new DeviceMethod()
                .withDeviceType("button")
                .withMethodName("setOnClickCallback"))
        .withDeviceMethodParameters(methodParameters);
```

You use the Projects API to program a fleet of devices\. Using the APIs, you first define what each placement looks like, including device templates and attributes for each placement\. After that is done, you create placements with specific device IDs\. Each placement follows the same template\. Here is the sample code to do this:

```
    final Map<String, String> callbacks = new HashMap<>();
callbacks.put("onClickCallback", "arn:aws:lambda:us-west-2:123456789012:MyButtonListener");
final DeviceTemplate item = DeviceTemplate.builder()
                .withDeviceType(“button”)
                .withCallbackOverrides(callbacks)
                .build();
final Map<String, DeviceTemplate> deviceTemplateMap = new HashMap<>();
deviceTemplateMap.put(“MyDevice”, item);

final Map<String, String> placementDefaultAttributes = new HashMap<>();
placementDefaultAttributes.put(“location”, “Seattle”)

request = CreateProjectRequest.builder()
                .withProjectName(“HelloWorld”)
                .withDescription(“My first project!”)
                .withPlacementTemplate(PlacementTemplate.builder()
                        .withDefaultAttributes(placementDefaultAttributes)
                        .withDeviceTemplates(deviceTemplateMap)
                        .build())
                .build();
projectsClient.createProject(request)
```

## AWS IoT 1\-Click Callback Events<a name="1click-events"></a>

AWS IoT 1\-Click allows you to subscribe to device events by registering callbacks\. An example of a callback is an AWS Lambda function owned and implemented by you, the AWS IoT 1\-Click customer\. This callback is invoked every time there is an event available for it to consume\. For information about events and their payloads, see the [AWS IoT 1\-Click Click Events](#1click-click-events) and [AWS IoT 1\-Click Health Events](#1click-health-events) sections\.

### AWS IoT 1\-Click Click Events<a name="1click-click-events"></a>

Devices of type `button` publish a click event each time they are clicked\. You can subscribe to this event by:
+ Calling the device `SetOnClickCallback` method on a device\.
+ Configuring the associated project appropriately, as shown in the earlier create project code example\.

In the following example, be aware that the `placementInfo` section is only present when the device has an associated placement\. For more information, see [Projects, Templates, and Placements](1click-PTP.md)\.

```
{
    "deviceEvent": {
      "buttonClicked": {
        "clickType": "SINGLE",
        "reportedTime": "2018-05-04T23:26:33.747Z"
      }
    },
    "deviceInfo": {
      "attributes": {
        "key3": "value3",
        "key1": "value1",
        "key4": "value4"
      },
      "type": "button",
      "deviceId": " G030PMXXXXXXXXXX ",
      "remainingLife": 5.00
    },
    "placementInfo": {
      "projectName": "test",
      "placementName": "myPlacement",
      "attributes": {
        "location": "Seattle",
        "equipment": "printer"
      },
      "devices": {
        "myButton": " G030PMXXXXXXXXXX "
      }
    }
  }
```

### AWS IoT 1\-Click Health Events<a name="1click-health-events"></a>

Devices publish a health event based on the health parameters calculated by the AWS IoT 1\-Click service, but you set their corresponding thresholds\. The following example represents the JSON payload of a health event for device `G030PMXXXXXXXXXX` with a remaining life of 10% \(note `"remainingLifeLowerThan":10` key\-value pair\)\.

```
{
    "deviceEvent": {
      "deviceHealthMonitor": {
        "condition": {
          "remainingLifeLowerThan": 10
        }
      }
    },
    "deviceInfo": {
      "attributes": {
        "key2": "value2",
        "key1": "value1",
        "projectRegion": "us-west-2"
      },
      "type": "button",
      "deviceId": "G030PMXXXXXXXXXX",
      "remainingLife": 5.4
    }
  }
```

## Device Methods<a name="1click-device-methods"></a>

AWS IoT 1\-Click device methods are APIs that are supported by devices of a certain device\-type, as demonstrated in the following table\. The full list of device methods supported by any device can be retrieved by calling [https://docs.aws.amazon.com/iot-1-click/1.0/devices-apireference/devices-deviceid-methods.html](https://docs.aws.amazon.com/iot-1-click/1.0/devices-apireference/devices-deviceid-methods.html)\.


| Device Type | Method Name | Description | 
| --- | --- | --- | 
|  `device`  |  `getDeviceHealthParameters`  |  Gets the device's health parameters, such as `remainingLife`\.  | 
|  `device`  |  `setDeviceHealthMonitorCallback`  |  Sets a callback to be called when the device health parameters are below a threshold\.  | 
|  `device`  |  `getDeviceHealthMonitorCallback`  |  Gets the configured callback which is called when the health parameters are below a threshold\.  | 
|  `button`  |  `setOnClickCallback`  |  Sets a callback to be called when the button has been clicked\.  | 
|  `button`  |  `getOnClickCallback`  |  Gets the configured callback which is called when the button is clicked\.  | 