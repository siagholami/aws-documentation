# 10: Lighting the Environment<a name="lighting"></a>

To implement global lighting for an entire level, you use a global environment probe\. Environment probes control many aspects of the physically based lighting in Lumberyard, including accurate shadow colors, ambient diffuse values, and specular reflections\. Probes also provide bounce lighting by taking the colors from the surroundings and applying them directly to the diffuse color of materials inside their radius\.

You can also affect the environment's light level by changing the time of day\. With the **Time of Day** editor, you can change the sun's position in the sky by specifying any time of day or night\. For advanced usage, you can even script times of day to fixed points in time or animate day\-to\-night cycles at customized speeds\.

In this tutorial, you learn a simple method of changing the current time of day\. For more information about creating time of day effects, see [Creating Time of Day Sky Effects](https://docs.aws.amazon.com/lumberyard/latest/userguide/sky-tod-intro.html) in the *Amazon Lumberyard User Guide*\.

**Topics**
+ [Placing a Global Environment Probe](lighting-environment-probe.md)
+ [Changing the Time of Day](lighting-timeofday.md)
+ [Creating a Light Source](lighting-creating-light.md)

[Next: Placing a Global Environment Probe](lighting-environment-probe.md)