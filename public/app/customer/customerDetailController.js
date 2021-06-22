(function() {
	var app = angular.module('myApp');
	app.controller('CustomerDetailController', function($scope, $routeParams, customerService) {
		customerService.findOne($routeParams.id).success(function(response) {
			$scope.customer = response;
		});

		$scope.saveCustomer = function() {
			customerService.save($scope.customer).success(function() {
				toastr.success('Customer saved!');
			});
		};
		
	});
}());