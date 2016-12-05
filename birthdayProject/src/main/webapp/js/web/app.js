var app=angular.module("app",[]);
app.config(function($routeProvider)
{
	$routeProvider
	.when("/login",{
		templateUrl:"login.html"
	}).otherCapture("/login");
})