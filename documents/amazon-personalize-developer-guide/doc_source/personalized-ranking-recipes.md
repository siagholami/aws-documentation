# PERSONALIZED\_RANKING Recipes<a name="personalized-ranking-recipes"></a>

The PERSONALIZED\_RANKING recipe, Personalized\-Ranking, provides recommendations in ranked order based on predicted interest level\.

## [Personalized\-Ranking](native-recipe-search.md)<a name="personalized-ranking-overview"></a>

The Personalized\-Ranking recipe is a hierarchical recurrent neural network \(HRNN\) recipe that also can filter and re\-rank results\. Personalized\-Ranking provides a list of the best recommendations\. Use the Personalized\-Ranking recipe when you’re personalizing the results for your users, such as personalized re\-ranking of search results or curated lists\.

To train a model, the Personalized\-Ranking recipe uses the Interactions dataset from a dataset group\. A dataset group is a set of related datasets, which can include the Users, Items, and Interactions datasets\.