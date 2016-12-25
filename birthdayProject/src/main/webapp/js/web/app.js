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
		templateUrl:"login.html"
	})
	.when("/login",{
		templateUrl:"login.html"
	})
	.when("/longevity",{
		templateUrl:"longevity.html"
	})
	.when("/companyBenediction",{
		templateUrl:"companyBenediction.html"
	})
	.when("/iWantSay",{
		templateUrl:"iWantSay.html"
	})
	.when("/lottery",{
		templateUrl:"lottery.html"
	})
	.when("/msg",{
		templateUrl:"msgList.html"
	})
	.when("/explain",{
		templateUrl:"explain.html"
	})
	.otherwise({redirectTo:"/"});
}])
