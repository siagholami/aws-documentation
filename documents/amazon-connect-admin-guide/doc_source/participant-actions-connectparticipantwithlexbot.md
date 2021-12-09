# ConnectParticipantWithLexBot<a name="participant-actions-connectparticipantwithlexbot"></a>

Connects the participant with the specified Amazon Lex bot\. When the interaction is over, the Intent and Slots of the bot are available to the flow during its run\. 

## Parameter object<a name="connectparticipantwithlexbot-parameter"></a>

```
{
    "PromptId": [Optional] A prompt ID or prompt ARN to play to the participant along with gathering input. May not be specified if Text or SSML is also specified. Must be specified either statically or as a single valid JSONPath identifier.
    "Text":  An optional string that defines text to send to the participant along with gathering input. May not be specified if PromptId or SSML is also specified. May be specified statically or dynamically.
    "SSML": An optional string that defines SSML to send to the participant along with gathering input. May not be specified if Text or PromptId is also specified May be specified statically or dynamically.
    "LexBot": { The details of the Lex bot to invoke
        "Name": The name of the Lex bot. May be specified statically or dynamically.
        "Region": The region in which this Lex bot exists. May be specified statically or dynamically.
        "Alias": The specific alias of the Lex bot to invoke. May be specified statically or dynamically.
    },
    "LexSessionAttributes: { A map of session attributes to pass to the Amazon Lex bot when it is invoked. The keys and values may be static or dynamic.
    }
}
```

## Results and conditions<a name="connectparticipantwithlexbot-results"></a>

If the Amazon Lex interaction succeeds, the result is the Intent of the bot\. Conditions are supported, but only the Equals operator is supported within these conditions\.

## Errors<a name="connectparticipantwithlexbot-errors"></a>
+ NoMatchingCondition \- If no specified condition evaluated to True\.
+ NoMatchingError \- If an error occurred and no other error matched\.

## Restrictions<a name="connectparticipantwithlexbot-restrictions"></a>

This action is supported by all channels\.

This action is available only in contact flows, transfer flows, and customer queue flows\. It is not available in whisper flows or hold flows\.

## Corresponding block in the UI<a name="connectparticipantwithlexbot-ui"></a>

[Get customer input](get-customer-input.md)