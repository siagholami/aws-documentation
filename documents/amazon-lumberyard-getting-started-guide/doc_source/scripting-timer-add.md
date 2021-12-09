# Adding a Timer<a name="scripting-timer-add"></a>

To add more challenge to the game experience, you'll add a timer that starts when the player enters the maze and stops upon exit\. To do this, you'll set up a Lua script with supporting entity components that trigger when the player enters the maze and stops upon exiting\. Timing how long it takes to complete a particular task is an element of gameplay that adds tension and excitement\.

To set up your timer, you do the following:
+ Create a parent entity \(**TimerParent**\) and add a child entity \(**TimerStart**\)\.
+ To **TimerStart**, add and configure the following components:
  + **Box Shape**
  + **Trigger Area**
  + **UI Canvas Asset Ref**
+ To **TimerStart**, add and configure three **Lua Script** components\.
+ Adjust the position of the **TimerStart** entity so that it starts when the player crosses the maze threshold\.

You complete a similar set of steps to set up the stop trigger, which stops the timer when your player exits the maze\.

[Next: Creating the Timer Parent and Child Entities](scripting-timer-add-create.md)