# Custom Terminology<a name="how-custom-terminology"></a>

Using custom terminology with your translation requests enables you to make sure that your brand names, character names, model names, and other unique content is translated exactly the way you need it, regardless of its context and the Amazon Translate algorithm’s decision\.

It's easy to set up a terminology file and attach it to your Amazon Translate account\. When you translate text, you simply choose to use the custom terminology as well, and any examples of your source word are translated as you want them\.

For example, consider the following: *Amazon Family* is a collection of benefits that offers Amazon Prime members exclusive offers, such as up to 20% off subscriptions to diapers, baby food, and more\. In France, it's called *Amazon Famille*\. If you translate *Amazon Family* into French using Amazon Translate without any additional context, the result is *Famille Amazon* as the output\. While this is an accurate translation, it isn't what the Amazon team in France needs\. However, if you add context to this, as in: "Have you ever shopped with Amazon Family?", Amazon Translate determines that the program name does not need to be translated, and the result is "Avez\-vous déjà fait des achats avec Amazon Family?"\. This is a good translation, but still not what the Amazon team is looking for\. Custom terminologies can solve issues like this\. By adding an entry showing that the term *Amazon Family* should be translated as *Amazon Famille* to their custom terminology, the team can make sure that it is translated this way every time, regardless of context\. *Amazon Family* is now translated into *Amazon Famille* and "Have you ever shopped with Amazon Family?" is now translated into "Avez\-vous déjà fait des achats avec Amazon Famille?"

**Topics**
+ [How does this work?](#how-does-ct-work)
+ [Creating a Custom Terminology](creating-custom-terminology.md)
+ [Using Custom Terminologies](using-ct.md)
+ [Encrypting Your Terminology](protect-terminology.md)
+ [Best Practices](ct-best-practices.md)

## How does this work?<a name="how-does-ct-work"></a>

Generally speaking, when a translation request comes in, Amazon Translate reads the source sentence, creates a semantic representation of the content \(in other words, it understands it\), and generates a translation into the target language\. 

When a custom terminology is used as part of the translation request, the engine scans the terminology file before returning the final result\. When the engine identifies an exact match between a terminology entry and a string in the source text, it locates the appropriate string in the proposed translation and replaces it with the terminology entry\. In the Amazon Family example, it first generates the translation "Avez\-vous déjà fait des achats avec Amazon Family?" but stops and replaces *Amazon Family* with *Amazon Famille* before providing the response\.