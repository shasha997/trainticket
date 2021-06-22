(function() {
	var app = angular.module('myApp');
	app.controller('CustomerController', function($scope, customerService) {
		$scope.newCustomer = {
			firstname : '',
			lastname : ''
		};

		loadCustomers();

		function loadCustomers() {
			customerService.findAll().success(function(response) {
				$scope.customers = response;
			});
		}

		$scope.createCustomer = function() {
			customerService.create($scope.newCustomer).success(function() {
				toastr.success('Customer created!');
				$scope.newCustomer = {
					firstname : '',
					lastname : ''
				};
				loadCustomers();
			});
		};
		
		$scope.deleteCustomer = function(id) {
			customerService.delete(id).success(function() {
				toastr.success('Customer deleted!');
				loadCustomers();
			});
		};
		
	});
}());