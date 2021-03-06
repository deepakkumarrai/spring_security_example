require.config({
	baseUrl: '/app',
	urlArgs: 'v=1.0'
});

require(
	[
		'app',
		'services/routeResolver',
		'services/config',
		'services/customersBreezeService',
		'services/customersService',
		'services/dataService',
		'controllers/navbarController',
		'controllers/orderChildController'
	],
	function () {
		angular.bootstrap(document, ['customersApp']);
	});