'use strict';

define(['services/routeResolver'], function ()
{

	var app = angular.module('customersApp', ['routeResolverServices']);

	app.config(['$routeProvider', 'routeResolverProvider', '$controllerProvider',
		'$compileProvider', '$filterProvider', '$provide',
		function ($routeProvider, routeResolverProvider, $controllerProvider, $compileProvider, $filterProvider, $provide)
		{

			//Change default views and controllers directory using the following:
			//routeResolverProvider.routeConfig.setBaseDirectories('/app/views', '/app/controllers');

			app.register =
			{
				controller: $controllerProvider.register,
				directive: $compileProvider.directive,
				filter: $filterProvider.register,
				factory: $provide.factory,
				service: $provide.service
			};

			//Define routes - controllers will be loaded dynamically
			var route = routeResolverProvider.route;

			$routeProvider
				.when('/customers', route.resolve('Customers'))
				.when('/customerorders/:customerID', route.resolve('CustomerOrders'))
				.when('/orders', route.resolve('Orders'))
				.otherwise({ redirectTo: '/customers' });

		}]);

	app.run(['$rootScope', '$location', 'authService',
		function ($rootScope, $location, authService)
		{

			//Client-side security. Server-side framework MUST add it's
			//own security as well since client-based security is easily hacked
			$rootScope.$on("$routeChangeStart", function (event, next, current)
			{
				if (next && next.$$route && next.$$route.secure)
				{
					if (!authService.user.isAuthenticated)
					{
						$rootScope.$evalAsync(function ()
						{
							authService.redirectToLogin();
						});
					}
				}
			});

		}]);

	return app;
});