(function() {
	var app = angular.module('myApp');
	app.factory('customerService', function($http) {
		return {
			findAll: function() {
				return $http.get('/api/customers');
			},
			findOne: function(id) {
				return $http.get('/api/customers/' + id);
			},
			create: function(customer) {
				return $http.post('/api/customers', customer);
			},
			delete: function(id) {
				return $http.delete('/api/customers/' + id);
			},
			save: function(customer) {
				return $http.post('/api/customers/' + customer.id, customer);
			}
		};
	});
}());