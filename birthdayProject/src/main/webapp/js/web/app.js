var app=angular.module("app",['ngRoute']);
app.config(['$routeProvider','$httpProvider',function($routeProvider,$httpProvider)
{
 	if (!$httpProvider.defaults.headers.get) {
      $httpProvider.defaults.headers.get = {};
    }
    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
    $httpProvider.defaults.headers.get['Cache-Control'] = 'no-cache';
    $httpProvider.defaults.headers.get['Pragma'] = 'no-cache';
    
	$routeProvider
	.when("/",{
		templateUrl:"pages/master/login.html"
	})
	.when("/login",{
		templateUrl:"pages/master/login.html"
	})
	.when("/longevity",{
		templateUrl:"pages/master/longevity.html"
	})
	.when("/companyBenediction",{
		templateUrl:"pages/master/companyBenediction.html"
	})
	.when("/iWantSay",{
		templateUrl:"pages/master/iWantSay.html"
	})
	.when("/lottery",{
		templateUrl:"pages/master/lottery.html"
	})
	.when("/msg",{
		templateUrl:"pages/master/msgList.html"
	})
	.when("/explain",{
		templateUrl:"pages/master/explain.html"
	})
	.otherwise({redirectTo:"/"});
}])
