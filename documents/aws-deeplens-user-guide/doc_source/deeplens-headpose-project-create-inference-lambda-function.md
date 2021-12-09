# Create an Inference Lambda Function to Detect Head Poses<a name="deeplens-headpose-project-create-inference-lambda-function"></a>

Before creating an AWS DeepLens project for deployment to your AWS DeepLens device for head pose detection, you must create and publish a Lambda function to make inference based on the trained model\. 

To create and publish the inference Lambda function, follow the instruction given in [Create and Publish an AWS DeepLens Inference Lambda Function](deeplens-inference-lambda-create.md), but replace the code in the greengrassHelloWorld\.py file with one similar to the following that is used in the [Head Pose Detection Sample project](deeplens-templated-projects-overview.md#head-pose-detection)\. 

```
""" This is a lambda function that demonstrates how one can use a deep learning network
    (ResNet) to detect the person's head pose. We use a shaded rectangle to indicate
    the region that the persons head is pointed towards. We also display a red ball
    that moves with the person's head.
"""
from threading import Thread, Event
import os
import json
import numpy as np
import cv2
import greengrasssdk
import awscam
import mo

class LocalDisplay(Thread):
    """ Class for facilitating the local display of inference results
        (as images). The class is designed to run on its own thread. In
        particular the class dumps the inference results into a FIFO
        located in the tmp directory (which lambda has access to). The
        results can be rendered using mplayer by typing:
        mplayer -demuxer lavf -lavfdopts format=mjpeg:probesize=32 /tmp/results.mjpeg
    """
    def __init__(self, resolution):
        """ resolution - Desired resolution of the project stream"""
        # Initialize the base class, so that the object can run on its own
        # thread.
        super(LocalDisplay, self).__init__()
        # List of valid resolutions
        RESOLUTION = {'1080p' : (1920, 1080), '720p' : (1280, 720), '480p' : (858, 480)}
        if resolution not in RESOLUTION:
            raise Exception("Invalid resolution")
        self.resolution = RESOLUTION[resolution]
        # Initialize the default image to be a white canvas. Clients
        # will update the image when ready.
        self.frame = cv2.imencode('.jpg', 255*np.ones([640, 480, 3]))[1]
        self.stop_request = Event()

    def run(self):
        """ Overridden method that continually dumps images to the desired
            FIFO file.
        """
        # Path to the FIFO file. The lambda only has permissions to the tmp
        # directory. Pointing to a FIFO file in another directory
        # will cause the lambda to crash.
        result_path = '/tmp/results.mjpeg'
        # Create the FIFO file if it doesn't exist.
        if not os.path.exists(result_path):
            os.mkfifo(result_path)
        # This call will block until a consumer is available
        with open(result_path, 'w') as fifo_file:
            while not self.stop_request.isSet():
                try:
                    # Write the data to the FIFO file. This call will block
                    # meaning the code will come to a halt here until a consumer
                    # is available.
                    fifo_file.write(self.frame.tobytes())
                except IOError:
                    continue

    def set_frame_data(self, frame):
        """ Method updates the image data. This currently encodes the
            numpy array to jpg but can be modified to support other encodings.
            frame - Numpy array containing the image data of the next frame
                    in the project stream.
        """
        ret, jpeg = cv2.imencode('.jpg', cv2.resize(frame, self.resolution))
        if not ret:
            raise Exception('Failed to set frame data')
        self.frame = jpeg

    def join(self):
        self.stop_request.set()

class HeadDetection():
    """ Custom class that helps us post process the data. In particular it draws
        a ball that moves across the screen depending on the head pose.
        It also draws a rectangle indicating the region that the person's head is pointing
        to. We divide the frame into 9 distinct regions.
    """
    def __init__(self, circ_cent_x, circ_cent_y):
        """ circ_cent_x - The x coordinate for the center of the frame
            circ_cent_y - The y coordinate for the center of the frame
        """
        self.result_thread = LocalDisplay('480p')
        self.result_thread.start()
        self.circ_cent_x = circ_cent_x
        self.circ_cent_y = circ_cent_y
        # Compute the maximum x and y coordinates.
        self.x_max = 2 * circ_cent_x
        self.y_max = 2 * circ_cent_y
        # Number of quadrants to split the image into.
        # This is model dependent.
        self.quadrants = 9

    def update_coords(self, frame, change_x, change_y, label):
        """ Helper method that draws a rectangle in the region the person is looking at.
            It also draws a red ball that changes its speed based on how long a person
            has been looking at a particular direction.
            frame - The frame where the ball and rectangle should be drawn
            change_x - The amount to increment the x axis after drawing the red ball.
            change_y - The amount to increment the y axis after drawing the red ball.
            label - Label corresponding to the region that the person's head is looking at.
        """
        # Set coordinates of the rectangle that will be drawn in the region that the
        # person is looking at.
        rect_margin = 10
        rect_width = frame.shape[1] // 3 - rect_margin * 2
        rect_height = frame.shape[0] // 3 - rect_margin * 2
        # Set the draw options.
        overlay = frame.copy()
        font_color = (20, 165, 255)
        line_type = 8
        font_type = cv2.FONT_HERSHEY_DUPLEX
        # Draw the rectangle with some text to indicate the region.
        if label == 0:
            cv2.putText(frame, "Down Right", (1024, 440 - 15), font_type, 3, font_color, line_type)
            cv2.rectangle(overlay,
                          (frame.shape[1] // 3 * 2 + rect_margin,
                           frame.shape[0] // 3 * 2 + rect_margin),
                          (frame.shape[1] // 3 * 2 + rect_width,
                           frame.shape[0] // 3 * 2 + rect_height),
                          (0, 255, 0), -1)
        elif label == 1:
            cv2.putText(frame, "Right", (1024, 440 - 15), font_type, 3, font_color, line_type)
            cv2.rectangle(overlay,
                          (frame.shape[1] // 3 * 2 + rect_margin,
                           frame.shape[0] // 3 * 1 + rect_margin),
                          (frame.shape[1] // 3 * 2 + rect_width,
                           frame.shape[0] // 3 * 1 + rect_height),
                          (0, 255, 0), -1)
        elif label == 2:
            cv2.putText(frame, "Up Right", (1024, 440 - 15), font_type, 3, font_color, line_type)
            cv2.rectangle(overlay,
                          (frame.shape[1] // 3 * 2 + rect_margin, rect_margin),
                          (frame.shape[1] // 3 * 2 + rect_width, rect_height),
                          (0, 255, 0), -1)
        elif label == 3:
            cv2.putText(frame, "Down", (1024, 440 - 15), font_type, 3, font_color, line_type)
            cv2.rectangle(overlay,
                          (frame.shape[1] // 3 * 1 + rect_margin,
                           frame.shape[0] // 3 * 2 + rect_margin),
                          (frame.shape[1] // 3 * 1 + rect_width,
                           frame.shape[0] // 3 * 2 + rect_height),
                          (0, 255, 0), -1)
        elif label == 4:
            cv2.putText(frame, "Middle", (1024, 440 - 15), font_type, 3, font_color, line_type)
            cv2.rectangle(overlay,
                          (frame.shape[1] // 3 * 1 + rect_margin,
                           frame.shape[0] // 3 * 1 + rect_margin),
                          (frame.shape[1] // 3 * 1 + rect_width,
                           frame.shape[0] // 3 * 1 + rect_height),
                          (0, 255, 0), -1)
        elif label == 5:
            cv2.putText(frame, "Up", (1024, 440 - 15), font_type, 3, font_color, line_type)
            cv2.rectangle(overlay,
                          (frame.shape[1] // 3 * 1 + rect_margin, rect_margin),
                          (frame.shape[1] // 3 * 1 + rect_width, rect_height),
                          (0, 255, 0), -1)
        elif label == 6:
            cv2.putText(frame, "Down Left", (1024, 440 - 15), font_type, 3, font_color, line_type)
            cv2.rectangle(overlay,
                          (rect_margin, frame.shape[0] // 3 * 2 + rect_margin),
                          (rect_width, frame.shape[0] // 3 * 2 + rect_height),
                          (0, 255, 0), -1)
        elif label == 7:
            cv2.putText(frame, "Left", (1024, 440 - 15), font_type, 3, font_color, line_type)
            cv2.rectangle(overlay,
                          (rect_margin, frame.shape[0] // 3 * 1 + rect_margin),
                          (rect_width, frame.shape[0] // 3 * 1 + rect_height),
                          (0, 255, 0), -1)
        else:
            cv2.putText(frame, "Up Left", (1024, 440 - 15), font_type, 3, font_color, line_type)
            cv2.rectangle(overlay, (rect_margin, rect_margin),
                          (rect_width, rect_height), (0, 255, 0), -1)
        # Set the opacity
        alpha = 0.2
        cv2.addWeighted(overlay, alpha, frame, 1 - alpha, 0, frame)
        # Draw the red ball at the previous x-y position.
        cv2.circle(frame, (self.circ_cent_x, self.circ_cent_y), 50, (0, 0, 255), -1)
        # Update the balls x-y coordinates.
        self.circ_cent_x += int(change_x)
        self.circ_cent_y += int(change_y)
        # Make sure the ball stays inside the image.
        if self.circ_cent_x > self.x_max:
            self.circ_cent_x = self.x_max
        if self.circ_cent_x < 0:
            self.circ_cent_x = 0
        if self.circ_cent_y > self.y_max:
            self.circ_cent_y = self.y_max
        if self.circ_cent_y < 0:
            self.circ_cent_y = 0
        # Send the post processed frame to the FIFO file for display
        self.result_thread.set_frame_data(frame)

    def adjust_x_vel(self, velocity, pct_of_center):
        """ Helper for computing  the next x coordinate.
            velocity - x direction velocity.
            pct_of_center - The percantage around the center of the image that
            we should consider a dead zone.
        """
        x_vel = 0
        if self.circ_cent_x < (1.0 - pct_of_center) * self.x_max/2:
            x_vel = velocity
        if self.circ_cent_x > (1.0 - pct_of_center) * self.x_max/2:
            x_vel = -1 *velocity
        return x_vel

    def adjust_y_vel(self, velocity, pct_of_center):
        """ Helper for computing  the next y coordinate.
            velocity - y direction velocity.
            pct_of_center - The percantage around the center of the image that
            we should consider a dead zone.
        """
        y_vel = 0
        if self.circ_cent_y < (1.0 - pct_of_center) * self.y_max/2:
            y_vel = velocity
        if self.circ_cent_y > (1.0 - pct_of_center) * self.y_max/2:
            y_vel = -1 * velocity
        return y_vel

    def send_data(self, frame, parsed_results):
        """ Method that handles all post processing and sending the results to a FIFO file.
            frame - The frame that will be post processed.
            parsed_results - A dictionary containing the inference results.
        """
        label = parsed_results[0]["label"]
        # Use the probability to determine the velocity, scale it by 100 so that the ball
        # moves across the screen at reasonable rate.
        velocity = parsed_results[0]["prob"] * 100
        pct_of_center = 0.05

        if label == 0:
            self.update_coords(frame, velocity, velocity, label)
        elif label == 1:
            self.update_coords(frame, velocity,
                               self.adjust_y_vel(velocity, pct_of_center), label)
        elif label == 2:
            self.update_coords(frame, velocity, -1*velocity, label)
        elif label == 3:
            self.update_coords(frame, self.adjust_x_vel(velocity, pct_of_center),
                               velocity, label)
        elif label == 4:
            self.update_coords(frame, self.adjust_x_vel(velocity, pct_of_center),
                               self.adjust_y_vel(velocity, pct_of_center),
                               label)
        elif label == 5:
            self.update_coords(frame, self.adjust_x_vel(velocity, pct_of_center),
                               -1*velocity, label)
        elif label == 6:
            self.update_coords(frame, -1*velocity, velocity, label)
        elif label == 7:
            self.update_coords(frame, -1*velocity, self.adjust_y_vel(velocity, pct_of_center),
                               label)
        elif label == 8:
            self.update_coords(frame, -1*velocity, -1*velocity, label)

    def get_results(self, parsed_results, output_map):
        """ Method converts the user entered number of top inference
            labels and associated probabilities to json format.
            parsed_results - A dictionary containing the inference results.
            output_map - A dictionary that maps the numerical labels returned
            the inference engine to human readable labels.
        """
        if self.quadrants <= 0 or self.quadrants > len(parsed_results):
            return json.dumps({"Error" : "Invalid"})

        top_result = parsed_results[0:self.quadrants]
        cloud_output = {}
        for obj in top_result:
            cloud_output[output_map[obj['label']]] = obj['prob']
        return json.dumps(cloud_output)

def head_detection():
    """ This method serves as the main entry point of our lambda.
    """
    # Creating a client to send messages via IoT MQTT to the cloud
    client = greengrasssdk.client('iot-data')
    # This is the topic where we will publish our messages too
    iot_topic = '$aws/things/{}/infer'.format(os.environ['AWS_IOT_THING_NAME'])
    try:
        # define model prefix and the amount to down sample the image by.
        input_height = 84
        input_width = 84
        model_name="frozen_model" 
        # Send message to IoT via MQTT
        client.publish(topic=iot_topic, payload="Optimizing model")
        ret, model_path = mo.optimize(model_name, input_width, input_height, platform='tf')
        # Send message to IoT via MQTT
        client.publish(topic=iot_topic, payload="Model optimization complete")
        if ret is not 0:
            raise Exception("Model optimization failed, error code: {}".format(ret))
        # Send message to IoT via MQTT
        client.publish(topic=iot_topic, payload="Loading model")
        # Load the model into cl-dnn
        model = awscam.Model(model_path, {"GPU": 1})
        # Send message to IoT via MQTT
        client.publish(topic=iot_topic, payload="Model loaded")
        # We need to sample a frame so that we can determine where the center of
        # the image is located. We assume that
        # resolution is constant during the lifetime of the Lambda.
        ret, sample_frame = awscam.getLastFrame()
        if not ret:
            raise Exception("Failed to get frame from the stream")
        # Construct the custom helper object. This object just lets us handle postprocessing
        # in a managable way.
        head_pose_detection = HeadDetection(sample_frame.shape[1]/2, sample_frame.shape[0]/2)
        # Dictionary that will allow us to convert the inference labels
        # into a human a readable format.
        output_map = ({0:'Bottom Right', 1:'Middle Right', 2:'Top Right', 3:'Bottom Middle',
                       4:'Middle Middle', 5:'Top Middle', 6:'Bottom Left', 7:'Middle Left',
                       8:'Top Left'})
        # This model is a ResNet classifier, so our output will be classification.
        model_type = "classification"
        # Define a rectangular region where we expect the persons head to be.
        crop_upper_left_y = 440
        crop_height = 640
        crop_upper_left_x = 1024
        crop_width = 640
        while True:
            # Grab the latest frame off the mjpeg stream.
            ret, frame = awscam.getLastFrame()
            if not ret:
                raise Exception("Failed to get frame from the stream")
            # Mirror Image
            frame = cv2.flip(frame, 1)
            # Draw the rectangle around the area that we expect the persons head to be.
            cv2.rectangle(frame, (crop_upper_left_x, crop_upper_left_y),
                          (crop_upper_left_x + crop_width, crop_upper_left_y + crop_height),
                          (255, 40, 0), 4)
            # Crop the the frame so that we can do inference on the area of the frame where
            # expect the persons head to be.
            frame_crop = frame[crop_upper_left_y:crop_upper_left_y + crop_height,
                               crop_upper_left_x:crop_upper_left_x + crop_width]
            # Down sample the image.
            frame_resize = cv2.resize(frame_crop, (input_width, input_height))
            # Renormalize the image so that the color magnitudes are between 0 and 1
            frame_resize = frame_resize.astype(np.float32)/255.0
            # Run the down sampled image through the inference engine.
            infer_output = model.doInference(frame_resize)
            # Parse the results so that we get back a more manageble data structure.
            parsed_results = model.parseResult(model_type, infer_output)[model_type]
            # Post process the image and send it to the FIFO file
            head_pose_detection.send_data(frame, parsed_results)
            # Send the results to MQTT in JSON format.
            client.publish(topic=iot_topic,
                           payload=head_pose_detection.get_results(parsed_results, output_map))

    except Exception as ex:
        msg = "Lambda has failure, error msg {}: ".format(ex)
        client.publish(topic=iot_topic, payload=msg)
# Entry point of the lambda function.
head_detection()
```

The `LocalDisplay` class defined in the Lambda function above serializes processed images, in a dedicated thread, to a specified FIFO file that serves as the source to replay the inference results as the project stream\. 

The `HeadDetection` class handles post\-process of parsed data, including calling out a detected head position and pose in the project stream's local display\. 

The `heade_detection` function coordinates the whole process to infer head poses of capture frames from AWS DeepLens video feeds, including loading the model artifact deployed to your AWS DeepLens device\. To load the model, you must specify the path to the model artifact\. To get this path you can call the `mo.optimize` method and specify `"frozen_model"` as the `model_name` input value\. This model name corresponds to the file name without the `.pb` extension of the model artifact uploaded to Amazon S3\. 

Having trained your model and uploaded it to S3 and created the Lambda function in your account, you're now ready to [create and deploy the head pose detection project](deeplens-headpose-project-create-and-deploy-project.md)\.