var app=angular.module("app",['ngRoute']);
app.config(['$routeProvider',function($routeProvider)
{
	$routeProvider
	.when("/",{
		template:'这是电脑分类页面',
		templateUrl:"login.html"
	})
	.when("/login",{
		templateUrl:"login.html"
	}).otherwise({redirectTo:"/"});
}])

// angular.module("app", [
//        "ngRoute"
//    ]).config(["$routeProvider", function($routeProvider) {
//        $routeProvider
//            .when("/index", {
//            templateUrl: "views/page1.html",
//            controller: "Page1Controller"
//        })
//         // .when("/child", {
//            .when("/child/:content", {
//            templateUrl: "views/page2.html",
//            controller: "Page2Controller"
//        })
//            .otherwise({
//            redirectTo: "/index"
//        });
//    }])
