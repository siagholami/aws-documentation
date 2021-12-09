# Lumberyard Release Notes – Beta 1.17 (December 2018)<a name="lumberyard-v1.17"></a>

Lumberyard Beta 1.17 adds over 70 new features, improvements, and fixes. As we continue to improve Lumberyard, we want to thank everyone in our community, whose suggestions help us make a better product every release. Since the initial launch, we've overhauled over 50% of the original code base, and we're still just getting started. Keep sending feedback to our [forums](https://forums.awsgametech.com/) as well as lumberyard-feedback@amazon.com. For the latest Lumberyard updates, follow us on [Twitter](https://twitter.com/amznlumberyard), [Facebook](https://www.facebook.com/amazonlumberyard/), and our [blog](https://aws.amazon.com/blogs/gametech/1-17/).

**Topics**
+ [Highlights](#lumberyard-v1.17-highlights)
+ [Improvements and Changes](lumberyard-v1.17-improvements-changes.md)
+ [Fixes](lumberyard-v1.17-fixes.md)
+ [Known Issues](lumberyard-v1.17-known-issues.md)

## Highlights<a name="lumberyard-v1.17-highlights"></a>

Here's a sampling of the new features found in Lumberyard 1.17.

**Topics**
+ [Identify Slice Overrides and Hierarchies in the Entity Outliner](#lumberyard-v1.17-highlights-slices)
+ [Set Entities as Editor Only in the Entity Inspector](#lumberyard-v1.17-highlights-inspector)
+ [Sort Entities in the Entity Outliner](#lumberyard-v1.17-highlights-outliner)
+ [Find Entities in Lumberyard Editor](#finding-entities-1.17)
+ [New Tutorial: Slice Update Walkthrough](#lumberyard-v1.17-highlights-tutorials-slice-updates)

### Identify Slice Overrides and Hierarchies in the Entity Outliner<a name="lumberyard-v1.17-highlights-slices"></a>

With Lumberyard 1.17, see the following workflow and UI improvements when working with slices.

**Slices with overrides appear orange**  
When you make changes to your slices, the entity icon appears orange if the slice has an override in the **Entity Outliner**. The entity icon for a parent entity has a dot if a child entity has an override. This feature helps you identify which entities and its children have overrides.

**Slice roots appear in the Entity Outliner**  
You can now identify if a slice is a root slice. Entities that are shaded are root slices. This feature helps you identify the structure of your slice hierarchy and understand which slices inherit.

**Moving an entity from a slice hierarchy **  
You can now select and drag an entity from a slice hierarchy to create a standalone entity. You can also select and drag from one slice hierarchy to another. This adds an override for the slice that you moved from and the slice that you moved to. When you save the override, this update adds the entity to the new slice hierarchy and removes the entity from the previous hierarchy.

![\[Managing slices in the Entity Outliner.\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-working_with_slices.png)

For more information, see [Working with Slices](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-slices.html) in the *Amazon Lumberyard User Guide*.

### Set Entities as Editor Only in the Entity Inspector<a name="lumberyard-v1.17-highlights-inspector"></a>

With Lumberyard 1.17, you can specify entities as editor only. This feature is useful if you want to disable an entity during gameplay mode or you want to create test entities or visual comments for users during development. Entities specified as editor only will not appear in gameplay.

![\[Specify whether component is active, inactive, or active in editor mode only.\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-component-entity-inspector-startactive.png)

You can also select an entity in the viewport and see whether it's inactive or editor only.

**Example Start inactive**  

![\[Specify whether component is active, inactive, or active in editor mode only.\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-component-entity-inspector-inactive-example.png)

**Example Editor only**  

![\[Specify whether component is active, inactive, or active in editor mode only.\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-component-entity-inspector-editor-only-example.png)
For more information, see the [Entity Inspector](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-entity-inspector.html) in the *Amazon Lumberyard User Guide*.

### Sort Entities in the Entity Outliner<a name="lumberyard-v1.17-highlights-outliner"></a>

With Lumberyard 1.17, you can now click the filter icon and search for components. Entities that match your filters appear in the search results.

![\[Sort entities in the Entity Outliner.\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-entity-outliner-search-filter.png)

You can also click the sort icon and sort entities with the following options:

![\[Search for entities in the Entity Outliner.\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-entity-outliner-sort-filter.png)
+ **Sort: Manually** – Manually organize entities.
+ **Sort: A to Z **– Sort entities alphabetically, in ascending order.
+ **Sort: Z to A** – Sort entities, in descending order.
+ **Scroll to Selected** – When you select an entity in the viewport, the **Entity Outliner** scrolls to that entity. If you select multiple entities, the **Entity Outliner** scrolls to the last selected entity.
+ **Expand to Selected** – When you select an entity in the viewport, the **Entity Outliner** expands the hierarchy to show any child entities.

For more information, see the [Entity Outliner](https://docs.aws.amazon.com/lumberyard/latest/userguide/component-entity-outliner.html) in the *Amazon Lumberyard User Guide*.

### Find Entities in Lumberyard Editor<a name="finding-entities-1.17"></a>

You can find entities more easily in Lumberyard Editor. This is helpful when you have many entities in your level and you want to navigate quickly to a specific entity.

**Find an entity from the **Entity Outliner** in the **Asset Browser** **  
In the **Entity Outliner**, right-click the slice or slice entity and choose **Find slice in Asset Browser**. The **Asset Browser** navigates to the corresponding slice.  

![\[Find entities or slices in the Asset Browser from the Entity Outliner.\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-component-entity-outliner-search-find-in-asset-browser.png)
For more information, see [Asset Browser](https://docs.aws.amazon.com/lumberyard/latest/userguide/asset-browser-intro.html) in the *Amazon Lumberyard User Guide*.  
You can also select an entity in the **Entity Outliner** to find it in the viewport or in reverse.

**Find an entity from the **Entity Outliner** in the viewport **  
In the **Entity Outliner**, right-click an entity and choose **Find in viewport**. The viewport navigates to the corresponding entity.  

![\[Find slices or entities in the viewport from the Entity Outliner.\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-search-find-in-outliner.png)

**Find an entity from the viewport in the Entity Outliner**  
In the viewport, right-click a slice or entity and choose **Find in Entity Outliner**. The **Entity Outliner** navigates to the corresponding item.  

![\[Find entities in the Entity Outliner from the viewport.\]](http://docs.aws.amazon.com/lumberyard/latest/releasenotes/images/shared-viewport-search-find-in-outliner.png)

### New Tutorial: Slice Update Walkthrough<a name="lumberyard-v1.17-highlights-tutorials-slice-updates"></a>