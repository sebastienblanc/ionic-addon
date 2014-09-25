<ion-view title="${pluralizedEntityName}">
  <ion-content class="has-header">
    <ion-list>
      <ion-item ng-repeat="result in results" type="item-text-wrap" href="#/tab/${entityName}/result.id}}">
        {{result.id}}
        <ion-option-button class="button-assertive"
                             ng-click="remove(result)">
            Delete
          </ion-option-button>
      </ion-item>
    </ion-list>
  </ion-content>
</ion-view>
