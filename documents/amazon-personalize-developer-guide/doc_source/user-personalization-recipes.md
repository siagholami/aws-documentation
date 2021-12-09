# USER\_PERSONALIZATION Recipes<a name="user-personalization-recipes"></a>

 USER\_PERSONALIZATION recipes predict the items that a user will interact with based on Interactions, Items, and Users datasets\. 

**Note**  
 When choosing a recipe with AutoML, Amazon Personalize considers only the HRNN, HRNN\-Metadata, and HRNN\-Coldstart recipes 

## [User\-Personalization](native-recipe-new-item-USER_PERSONALIZATION.md)<a name="aws-user-personalization-recipe-overview"></a>

 The User\-Personalization \(aws\-user\-personalization\) recipe is optimized for all USER\_PERSONALIZATION recommendation scenarios and uses automatic item exploration when recommending items\. With automatic exploration, Amazon Personalize automatically tests different item recommendations, learns from how users interact with these recommended items, and boosts recommendations for items that drive better engagement and conversion\. This is improves item discovery and engagement when you have a fast\-changing catalog, or when new items, such as news articles or promotions, are more relevant to users when fresh\. 

To train a model, User\-Personalization uses the Interactions dataset from a dataset group\. A dataset group is a set of related datasets, which can include the Users, Items, and Interactions datasets\.

## [HRNN](native-recipe-hrnn.md)<a name="native-recipe-hrnn-overview"></a>

HRNN is a hierarchical recurrent neural network, which can model the user\-item interactions across a given timeframe\. Use the HRNN recipe when user behavior changes over time, which is referred to the evolving intent problem\.

To train a model, HRNN uses the Interactions dataset from a dataset group\. A dataset group is a set of related datasets, which can include the Users, Items, and Interactions datasets\.

## [HRNN\-Metadata](native-recipe-hrnn-metadata.md)<a name="native-recipe-hrnn-metadata-overview"></a>

HRNN\-Metadata is the HRNN recipe with additional features derived from metadata found in the Interactions, Users, and Items datasets\. For example, rating, movie genre, or release year\. The training data *must* include metadata in at least one of the datasets\. HRNN\-Metadata performs better than non\-metadata models when high\-quality metadata is available\. Training with this recipe can involve longer training times\.

To train a model, HRNN\-Metadata uses the Users, Items, and Interactions datasets from a dataset group\. A dataset group is a set of related datasets, which can include the Users, Items, and Interactions datasets\.

## [HRNN\-Coldstart](native-recipe-hrnn-coldstart.md)<a name="native-recipe-hrnn-cold-start-overview"></a>

HRNN\-Coldstart is similar to the HRNN\-Metadata recipe, but also includes personalized exploration of new items\. Use the HRNN\-Coldstart recipe when you frequently add new items to a catalog and want the items to immediately be included in recommendations\.

To train a model, HRNN\-Coldstart uses the Users, Items, and Interactions datasets from a dataset group\. A dataset group is a set of related datasets, which can include the Users, Items, and Interactions datasets\. The dataset group that supplies the training data must include an Items dataset\. 

## [Popularity\-Count](native-recipe-popularity.md)<a name="native-recipe-popularity-count-overview"></a>

The Popularity\-Count recipe calculates the popularity of items based on a count of events against that item in the Interactions dataset\. Use the Popularity\-Count recipe to create a baseline to compare results with other USER\-PERSONALIZATION recipes\.

To train a model, the Popularity\-Count recipe uses the Interactions dataset from a dataset group\. A dataset group is a set of related datasets, which can include the Users, Items, and Interactions datasets\.