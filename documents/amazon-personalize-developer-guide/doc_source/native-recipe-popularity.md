# Popularity\-Count Recipe<a name="native-recipe-popularity"></a>

Popularity\-count returns the top popular items from a dataset\. A popular item is defined by the number of times it occurs in the dataset\. The recipe returns the same popular items for all users\. Popularity\-count is a good starting point to compare against other recipes\.

This predefined recipe has the following properties:
+  **Name** – `aws-popularity-count`
+  **Recipe ARN** – `arn:aws:personalize:::recipe/aws-popularity-count`
+  **Algorithm ARN** – `arn:aws:personalize:::algorithm/aws-popularity-count`
+  **Feature Transformation ARN** – `arn:aws:personalize:::feature-transformation/sims`
+  **Recipe type** – `USER_PERSONALIZATION`

Popularity\-count has no exposed hyperparameters\.