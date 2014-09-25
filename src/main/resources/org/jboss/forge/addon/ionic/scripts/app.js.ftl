<#assign angularApp = "${projectId}">
'use strict';

angular.module('${angularApp}',['ionic','ngResource','${angularApp}.controllers','${angularApp}.services'])
.run(function($ionicPlatform) {
  $ionicPlatform.ready(function() {
	
  });
})
  .config(function($stateProvider, $urlRouterProvider) {

  // Ionic uses AngularUI Router which uses the concept of states
  // Learn more here: https://github.com/angular-ui/ui-router
  // Set up the various states which the app can be in.
  // Each state's controller can be found in controllers.js
  $stateProvider
    // setup an abstract state for the tabs directive
    .state('tab', {
      url: "/tab", 
      abstract: true,
      templateUrl: "views/tabs.html" 
    })
    	<#list entityNames as entityName> 
      <#assign
                listEntityController = "List${entityName}Controller"
                ShowEntityController = "Show${entityName}Controller"
                newEntityController = "New${entityName}Controller"
                editEntityController = "Edit${entityName}Controller"
                entityIdJsVar = "${entityName}Id"
                entityRoute = "/${pluralizedEntityNames[entityName_index]}"
                entityPartialsLocation = "views/${entityName}">
    // Each tab has its own nav history stack:

    .state('tab.list${entityName}', {
      url: '/${pluralizedEntityNames[entityName_index]}',
      views: {
        'tab-${pluralizedEntityNames[entityName_index]}': {
          templateUrl: 'views/${entityName}/search.html',
          controller: '${listEntityController}'
        }
      }
    })
    .state('tab.${entityName}-detail', {
      url: '/${entityName}/:${entityIdJsVar}',
      views: { 
        'tab-${pluralizedEntityNames[entityName_index]}': {
          templateUrl: 'views/${entityName}/detail.html',
          controller: '${ShowEntityController}'
        }
      }
    })

    .state('tab.new${entityName}', {
      url: '/new${entityName}',
      views: {
        'tab-new${entityName}': {
          templateUrl: 'views/${entityName}/detail.html',
          controller: '${newEntityController}'
        }
      }
    })
    $urlRouterProvider.otherwise('/tab/${pluralizedEntityNames[entityName_index]}');
    </#list>
    ;

  });
