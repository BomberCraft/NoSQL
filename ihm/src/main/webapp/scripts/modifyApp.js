var app = angular.module('myApp', ['ui.bootstrap', 'ngRoute'])
	.config(function ($locationProvider) {
		$locationProvider.html5Mode({
			  enabled: true,
			  requireBase: false
			});
	});

app.controller('myCtrl', function($scope, $http, $routeParams, $route) {

	// ---- Définition des variables d'un utilisateur ------
	  $scope.salarie = new Object();
	  
	  $scope.idParam = $routeParams.id;


  //-------- HTTP Functions --------------------------
  $scope.updateUser = function() {
    $http.put("http://localhost:8080/tp1/collaborateurs/"+$scope.idParam, $scope.salarie)
    .success(function(response) {
        alert("Salarié modifié avec succès"); 
      })
    .error(function(response){
        alert("La modification a rencontré une erreur");
    });
  };

  $scope.deleteUser = function() {
    $http.put("http://localhost:8080/tp1/collaborateurs/"+$scope.idParam, $scope.salarie)
    .success(function(response) {
        alert("Salarié supprimé avec succès"); 
      })
    .error(function(response){
        alert("La suppression a rencontré une erreur");
    });
  };

  $scope.getOneUser = function() {
    $http.get("http://localhost:8080/tp1/collaborateurs/"+$scope.idParam)
    .success(function(response) {
         $scope.salarie = response;
      })
    .error(function(response){
        alert("La recherche d'un salarié a rencontré une erreur");
    });
  };


  $scope.getOneUser();

  //-------- DatePicker Functions --------------------------
  $scope.today = function() {
    $scope.dt = new Date();
  };
  $scope.today();

  $scope.clear = function () {
    $scope.dt = null;
  };

  $scope.open = function($event) {
    $event.preventDefault();
    $event.stopPropagation();

    $scope.opened = true;
  };

  $scope.format = 'dd-MM-yyyy';

});