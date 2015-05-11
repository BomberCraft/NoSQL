var app = angular.module('myApp', []);

app.controller('myCtrl', function($scope, $http) {

	// ---- Définition des variables d'un utilisateur ------
	  $scope.salarie = new Object();


  //-------- HTTP Functions --------------------------

  $scope.getAllUsers = function() {
    $http.get("http://localhost:8080/tp1/collaborateurs")
    .success(function(response) {
        $scope.listSalaries = response;
      })
    .error(function(response){
        alert("Une erreur est survenue lors de la recherche des salariés");
    });
  };
  

  $scope.getAllUsers();

});