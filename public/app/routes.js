(function() {
    var app = angular.module('myApp');

    app.config(['$routeProvider', function($routeProvider) {
        $routeProvider
            .when('/customers',  {
                templateUrl: 'app/customer/customers.html',
                controller: 'CustomerController'
            })
            .when('/customers/:id',  {
                templateUrl: 'app/customer/customer.html',
                controller: 'CustomerDetailController'
            })
            .otherwise({
                redirectTo: '/customers'
            });
    }]);
}());