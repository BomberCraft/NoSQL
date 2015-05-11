var app = angular.module('myApp', ['ui.bootstrap']);

app.controller('myCtrl', function($scope, $http) {

	// ---- D√©finition des variables d'un utilisateur ------
	$scope.salarie = new Object();

    $scope.salarie.id;
    $scope.salarie.prenom = "";
    $scope.salarie.nom = "";
    $scope.salarie.dateNaissance = new Date();
    $scope.salarie.poste = "";
    $scope.salarie.mail;
    $scope.salarie.salaire;
    $scope.salarie.dateEntree = new Date();
    $scope.salarie.dateSortie = new Date();
    $scope.salarie.photo;
    $scope.salarie.numeroEmploye;
    $scope.salarie.motifSuppression;

    $scope.dt = new Date();

  //-------- HTTP Functions --------------------------
  $scope.createUser = function() {
    $http.post("http://localhost:8080/tp1/collaborateurs", $scope.salarie)
    .success(function(response) {
        alert("SalariÈ crÈÈ avec succ√®s"); 
      })
    .error(function(response){
        alert("La cr√©ation a rencontr√© une erreur");
    });
  };


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