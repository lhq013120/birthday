var app=angular.module("app",['ngRoute']);
app.config(['$routeProvider',function($routeProvider)
{
	$routeProvider
	.when("/login",{
		templateUrl:"login.html"
	})//.otherCapture("/login");
}])
//
//app.controller("app",function($scope)
//{
//	
//})