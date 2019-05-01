var App = angular.module("myApp",['ngRoute']);
App.config(function($routeProvider) {
	alert("Iam in config function with route provider");
	$routeProvider.when("/", {
		templateUrl : "index.html"
	}).when("/login", {
		templateUrl : "c_user/login.html"
	}).when("/register", {
		templateUrl : "c_user/register.html"
	})

})