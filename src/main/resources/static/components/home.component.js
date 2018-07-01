/**
 * Home JavaScript program.
 */
(
function () {
	'use strict';
	angular.module('foodsApp')
	  .component('home', {
	    templateUrl: 'components/home.view.html',
	    controller: ['$http','$cookies', 'itemsService', function homeController($http, $cookies, itemsService) {
	    	var self = this;
	    	self.siteName = "Ghar Da Khana";
	    	itemsService.getAll().then(function(response) {
	    		  self.items = response.data;
	    	});
	    	let deviceId = $cookies.get('_deviceId')
	    	console.log('deviceId:', deviceId);
	    	if(deviceId != null)
	    		itemsService.getUserId(deviceId).then(function(response) {
		    		let userId = response.data;
		    		itemsService.getCart(userId).then(function(response) {
		    			self.cart = response.data;
		    		}); 
		    	});	
	    }]
	})
	.service('itemsService', ['$http', function($http) {
		  this.getAll = function getAll() {
		    	return $http.get("/items");
		  }
		  this.getCart = function(userId) {
		    	return $http.get("/cart/" + userId);
		  }
		  this.getUserId = function(deviceId) {
		    	return $http.get("/user/" + deviceId);
		  }
	    }
	]);
}()
);