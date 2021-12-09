# RELATED\_ITEMS Recipes<a name="related-items-recipes"></a>

 The RELATED\_ITEMS recipe, SIMS, returns items similar to a given item\. 

## [SIMS](native-recipe-sims.md)<a name="sims-overview"></a>

The item\-to\-item similarities \(SIMS\) recipe generates items similar to a given item based on the co\-occurrence of the item in user history in the user\-item interaction dataset\. If sufficient user behavior data for an item isn't available, or if the specified item ID isn't found, the recipe returns popular items as recommendations\. Use the SIMS recipe to improve item discovery\. Training is faster with the SIMS recipe compared to other recipes\.

To train a model, the SIMS recipe uses the Interactions dataset from a dataset group\. A dataset group is a set of related datasets, which can include the Users, Items, and Interactions datasets\.