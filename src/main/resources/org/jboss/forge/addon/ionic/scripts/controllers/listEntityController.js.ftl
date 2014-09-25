<#assign
    angularApp = "${projectId}" 
    angularController = "List${entityName}Controller" 
    angularResource = "${entityName}Resource" 
    model = "$scope.${entityName?uncap_first}" 
    entityRoute = "/${pluralizedEntityName}"
>

<#assign relatedResources>
<#list properties as property>
<#if (property["many-to-one"]!) == "true" || (property["one-to-one"]!) == "true" || (property["n-to-many"]!) == "true">
, ${property.simpleType}Resource<#t>
</#if>
</#list>
</#assign>

angular.module('${angularApp}.controllers').controller('${angularController}', function($scope, $location, $http, ${angularResource}) {

    $scope.search={};
    $scope.currentPage = 0;
    $scope.pageSize= 10;
    $scope.results = [];
    $scope.filteredResults = [];
    $scope.pageRange = [];
    $scope.numberOfPages = function() {
        var result = Math.ceil($scope.filteredResults.length/$scope.pageSize);
        var max = (result == 0) ? 1 : result;
        $scope.pageRange = [];
        for(var ctr=0;ctr<max;ctr++) {
            $scope.pageRange.push(ctr);
        }
        return max;
    };
    <#list properties as property>
    <#if (property["many-to-one"]!) == "true" || (property["one-to-one"]!) == "true">
    <#assign
        relatedCollection = "$scope.${property.identifier}List"
        relatedResource = "${property.simpleType}Resource">
    ${relatedCollection} = ${relatedResource}.queryAll();
    <#elseif property["lookup"]??>
    <#assign
        lookupCollection = "$scope.${property.identifier}List">
    ${lookupCollection} = [
    <#list property["lookup"]?split(",") as option>
        "${option}"<#if option_has_next>,</#if>
    </#list>
    ];
    </#if>
    </#list>

    $scope.performSearch = function() {
        $scope.results = ${angularResource}.queryAll(function(){
            $scope.numberOfPages();
        });
    };
    
    $scope.previous = function() {
       if($scope.currentPage > 0) {
           $scope.currentPage--;
       }
    };
    
    $scope.next = function() {
       if($scope.currentPage < ($scope.numberOfPages() - 1) ) {
           $scope.currentPage++;
       }
    };
    
    $scope.setPage = function(n) {
       $scope.currentPage = n;
    };
    
    $scope.remove = function(customer) {
       var successCallback = function() {
            $scope.performSearch();
        };
        var errorCallback = function() {
            $scope.displayError=true;
        }; 
      customer.$remove(successCallback, errorCallback);
    };

    $scope.performSearch();
});