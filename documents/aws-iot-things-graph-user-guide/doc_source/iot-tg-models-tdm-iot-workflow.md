--------

--------

# Workflow<a name="iot-tg-models-tdm-iot-workflow"></a>

The `Workflow` construct \(also called flow\) describes an automated process that consists of multiple devices and stateful services\. 

`Workflow` takes a set of parameters and consists of an array of steps that are connected to events\. Input events can trigger a step, and a step can generate an output event\. Each step can represent a Lambda function, a device action, or a web application method\.

The following pseudocode defines what happens at a conceptual level when you create a workflow\.

```
CREATE Workflow workflowUrn ‘(‘ [paramName paramType [= defaultValue] [,]]* ‘)’ {
        [varName varType [= defaultValue] [,]]*       
        STEPS {
            [STEP (NAME stepName, [CONDITION conditionExpr]  [DESCRIPTION descriptionText]) {
	 [EVENTS {
	     [INPUT ( ${expression-over events} ) ]
                    [OUTPUT ( [eventName, [eventUrn] [,]]*  )]
	 }]*
	 [ACTIVITY ‘(‘ [paramName = paramExpr [,]]* [[,] out =$varName  ‘)]
                  [OnError 
                     {Retries{Retry (name=retryName, condition=booleanExpr, [ [interval=expr] 
                                                  [backoffRate=expr] [maxAttempts=expr]) }*
                     Catches{Catch(name=catchName, condition=booleanExpr, raiseEvent[(eventName[,])* )} } 
                  ]   
	  [OnSuccess {
                      (CHECK (name=chkName, condition=booleanExpr) THEN (onPassExpr, onFailExpr)*	
                }]
        } 
}
```

**Key concepts**

workflowUrn  
Unique identifier of the workflow\.

paramType  
Data type of the workflow parameter\.

paramName  
Workflow parameter name\.

defaultValue  
Default parameter value\.

varName  
Variable name\.

varType  
Variable type\.

stepName  
Name of a step in the workflow\. Unique to the workflow\.

descriptionText  
Optional description\.

conditionExpr  
Optional condition\. If it resolves to false, the step is skipped\.

eventName  
Input or output event name\. The step either waits for it to start, or publishes it on completion\.

eventUrn  
Optional global event URN\.

ACTIVITY  
Placeholder for device activity, web activity, or a built\-in control activity\.

booleanExpr  
A Boolean condition\.

onPassExpr  
Evaluated if `CHECK(booleanExpr)` evaluates to true\.

onFailExpr  
Evaluated if `CHECK(booleanExpr)` evaluates to false\.

onError, Retries, Retry, Catches, Catch  
Error handling with the same semantics as [AWS Step Functions](https://docs.aws.amazon.com/step-functions/latest/dg/concepts-error-handling.html)\.   
`OnError` is evaluated when the activity fails or times out\. The `Retries` are evaluated in the specified order\. On exhaustion of all `Retries`, control falls to the `Catch` clause\.

**GraphQL Example**

The following GraphQL creates a workflow that monitors door entry in a building\. A camera takes a picture of the person entering the building, which triggers a face detection service\. The face detection service then displays an image of the person on a screen\. The example also handles camera errors and failure\.

```
query monitorDoorEntry ($cameraId: DeviceId!, $screenId: DeviceId!,                                             # Arguments and their data types
                        $lampId: DeviceId!, $cameraDelay_ms : Number = 0,
                        $cameraFailedImage: String = “http://abc/defaultCameraFailedImage.jpg”)
                        @workflowType(id:"urn:tdm:aws:workflow:monitorDoorEntry") {                   # @workflowType directive and workflow unique URN

# Declare workflow variables
   variables {                                                                                                  # Workflow variables
      cameraImage  @property(id:"urn:tdm:aws:property:image/imageUri")                                # Semantic property imageUri
      faceDetected @property(id:"urn:tdm:aws:property:bool/boolean")                                  # Raw datatype property boolean
   }

   steps {                                                                                                      # Set of steps.
   
     # Device activity step
     step(name:"camera", description:"Activate Camera" outEvent:["CameraClicked"]){                             # Step name, description, and output event
        DeviceActivity(deviceModel:"urn:tdm:aws:device:camera" deviceId:"$cameraId"){                 # Device activity ARN. Device ID
           capture(delay_ms:$cameraDelay_ms)
        }
       OnError {                                                                                                # Error handling
         Retries {
            Retry(name:"foo1", errorEquals:["ErrorA", "ErrorB"], interval:”1 sec”, 
                  backoffRate:2.0, maxAttempts:2),
            Retry(name:"foo2", errorEquals:["ErrorC"], interval:”5 sec”),
            Retry(name:"foo3", condition:"${Error IN ('ErrorD', 'ErrorE')}", interval:”5 sec”)
         }
         Catches {
            Catch(name:'catch1',condition:"${Error=='ErrorE'}", expr:”$cameraFailed.IsTrue=true]")
         }
      }
      OnSuccess {                                                                                               # Validation of image captured by the camera
         Check(name:"validation1", condition:"${lib.fileSize(cameraImage) > 100}" ) {
            OnPass { stmt(expr:"${imageOK=true}") }
            OnFail { stmt(expr:”$cameraFailed.IsTrue=true)"}                                                    # Raise cameraFailed Event
         }
      }
    }
    
    # Device activity step
    step (name:"Lamp") {                                                                                        # Step name
         DeviceActivity(deviceModel:"urn:tdm:aws:device:lightBulb",deviceId:"$lampId"){                                  # Device activity ARN. Device ID
          powerOn(param:$cameraDelay_ms)
       }
    }
    
    # Web service activity step
    step(name:"FaceDetectionService" condition:”${imageOK}”  inEvent:["CameraClicked"],                         # Conditional web service activity. Condition is $imageOK
                                                            outEvent:["FaceDetectedEvt"]) {                     # Input and output events
         WebServiceActivity(webservice:"urn:tdm:aws:service:faceDetection" out:”$faceDetected”) {
            detect(image:”$cameraImage”)
       }
    }
    
    # Device activity step
    step(name:"DisplayImage", inEvent:”${FaceDetectedEvt}" ) {                                                  # Conditional device activity. 
       DeviceActivity(DeviceModel:"urn:tdm:aws:devicemodel:displayScreen" deviceId:"$screenId”) {               # Device activity ARN. Device ID
          display(imageUri:”${cameraImage.lastClickedImage)                                                     # Display the image.
          }
       }
    }
}
```

This example contains the following key elements that differ from the AWS Lambda service:
+ A set of arguments and their data types\. This example passes three non\-nullable device URNs, a camera burst delay setting with a default value of 0, and an image URL \(with a default value\) for failed image captures\.
+ The `workflowType` directive and its unique URN\.
+ A set of workflow variables and their data types \(and property URNs\)\.
+ A list of steps with names and descriptions\.
+ Each step has an activity specification\. Possible values are `DeviceActivity` and `WebServiceActivity`\.
+ A `DeviceActivity` is specified by a device model and the ID of the concrete device in the workflow\.
+ The device or service activity that the device or service in each step performs\. These activities are specified in the device model's capability\. They are implemented in the concrete device's definition\.
+ Error handling with the `OnError`, `Retries`, `Retry`, `Catches`, and `Catch`\. The `OnError` clause is evaluated when the activity fails or times out\. The `Retries` clause is then evaluated in the specified order until all `Retry` clauses have been attempted\. If all of the retries fail, control falls to the `Catches` clause\. These clauses have the same semantics as `Retry` and `Catch` in [AWS Step Functions](https://docs.aws.amazon.com/step-functions/latest/dg/concepts-error-handling.html)\. The `OnSuccess` clause also contains additional validation to ensure that the camera captured a valid image\.

The workflow makes extensive use of [Expressions]() to determine how the workflow proceeds, depending on whether the camera works and the condition of the image that it returns\. The web service activity, for example, doesn't run unless a valid image is captured\. See [Expressions]() for more information about how to use expressions\.