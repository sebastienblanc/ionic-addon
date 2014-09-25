<!-- 
  Create tabs with an icon and label, using the tabs-positive style. 
  Each tab's child <ion-nav-view> directive will have its own 
  navigation history that also transitions its views in and out.
-->
<ion-tabs class="tabs-icon-top">

 <#list entityNames as entityName> 
  <#assign
     listEntityController = "List${entityName}Controller"
     ShowEntityController = "Show${entityName}Controller"
     newEntityController = "New${entityName}Controller"
     editEntityController = "Edit${entityName}Controller"
     entityIdJsVar = "${entityName}Id"
     entityRoute = "/${pluralizedEntityNames[entityName_index]}"
     entityPartialsLocation = "views/${entityName}">
  <ion-tab title="${listEntityController}" icon="icon ion-home" href="#/tab/${pluralizedEntityNames[entityName_index]}">
    <ion-nav-view name="tab-${pluralizedEntityNames[entityName_index]}"></ion-nav-view>
  </ion-tab>
 <ion-tab title="New" icon="icon ion-plus" href="#/tab/new${entityName}">
    <ion-nav-view name="tab-new${entityName}"></ion-nav-view>
  </ion-tab>
</#list>
</ion-tabs>
