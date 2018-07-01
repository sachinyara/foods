/**
 * Home JavaScript program.
 */
(
function () {
	'use strict';
	angular.module('foodsApp')
	  .component('home', {
	    templateUrl: 'components/home.view.html',
	    controller: ['$http','itemsService', function homeController($http, itemsService) {
	    	var self = this;
	    	self.siteName = "Ghar Da Khana";
	    	itemsService.getAll().then(function(response) {
	    		  self.items = response.data;
	    	}); 
	    	console.log(self.items);
	    }]
	})
	.service('itemsService', ['$http', function($http) {
		  this.getAll = function getAll() {
		    	return $http.get("/items");
		  }
	    }
	]);
}()
);