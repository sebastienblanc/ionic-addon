<ion-view title="Edit/create">
<#assign formName = "${entityName}Form"
        model = "${entityName?uncap_first}">
<ion-content class="has-header">        
<form id="${formName}" name="${formName}" class="form-horizontal" role="form">
    <div class="list">
    ${formProperties}
    </div>
    <div class="button-bar">
       <button id="save${entityName}" name="save${entityName}" class="button button-positive" ng-click="save()">Save</button>
       <button id="cancel" name="cancel" class="button button-assertive" ng-click="cancel()">Cancel</button>
    </div>
    </div>
</form>
</ion-content>
</ion-view>