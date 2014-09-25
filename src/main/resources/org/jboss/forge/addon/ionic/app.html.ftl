<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no, width=device-width">
    <title></title>

    <link href="styles/ionic.min.css" rel="stylesheet">
    <link href="styles/style.css" rel="stylesheet">

    <!-- IF using Sass (run gulp sass first), then uncomment below and remove the CSS includes above
    <link href="css/ionic.app.css" rel="stylesheet">
    -->

    <!-- ionic/angularjs js -->
    <script src="scripts/vendor/ionic.bundle.min.js"></script>
    <script src="scripts/vendor/angular-resource.min.js"></script>

    <!-- cordova script (this will be a 404 during development) -->
    <script src="cordova.js"></script>
    <script src="scripts/app.js"></script>
    <#list entityNames as entityName>
    <script src="scripts/services/${entityName}Factory.js"></script>
    <script src="scripts/services/locationParser.js"></script>
    <script src="scripts/controllers/new${entityName}Controller.js"></script>
    <script src="scripts/controllers/list${entityName}Controller.js"></script>
    <script src="scripts/controllers/edit${entityName}Controller.js"></script>
    </#list>
  </head>

  <body ng-app="${projectId}">
    <ion-nav-bar class="bar-stable nav-title-slide-ios7">
      <ion-nav-back-button class="button-icon icon  ion-ios7-arrow-back">
        Back
     </ion-nav-back-button>
    </ion-nav-bar>
    <ion-nav-view id="root"></ion-nav-view>
  </body>
 </html>
