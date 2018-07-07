/**
 * Home JavaScript program.
 */
(
function () {
	'use strict';
	angular.module('foodsApp')
	  .component('home', {
	    templateUrl: 'components/home.view.html',
	    controller: ['$scope', '$http', 'itemsService', function homeController($scope, $http, itemsService) {
	    	var self = this;
	    	self.siteName = "Ghar Da Khana";
	    	itemsService.getAll().then(function(response) {
	    		$scope.items = response.data;
	    		$scope.items.forEach(itemCategory => {
    				itemCategory.items.forEach(item => {
    					item.orderQantity = 0;
    				});
	    		});
	    	});
	    	 
	    	$scope.$watch('items', function(newItems, oldItems) {
				if($scope.items != null) {
		    		itemsService.getUserId().then(function(response) {
			    		self.userId = response.data;
			    		itemsService.getCart(self.userId).then(function(response) {
			    			self.cart = response.data;
			    			self.totalBill = 0;
			    			self.cart.forEach(cartItem => self.totalBill+=cartItem.item.price*cartItem.quantity);
			    			$scope.items.forEach(itemCategory => {
			    				itemCategory.items.forEach(item => {
			    					let cartItem = self.cart.find(cartItem => cartItem.item.id == item.id);
			    					if(cartItem != null)
			    						item.orderQantity = cartItem.quantity;
			    				});
			    			});
			    		});
			    	});
				}
			});
	    	self.addItemToCart = function(item) {
	    		var itemCopy = angular.copy(item);
	    		itemCopy.itemImage = [];
	    		item.orderQantity++;
    			var cartItem = null;
    			if(self.cart != null)
    				cartItem = self.cart.find(cartItem => cartItem.item.id == item.id);
    			if(cartItem == null) {
	    			cartItem = {
	    				userId: self.userId,
	    				item : itemCopy,
	    				quantity: item.orderQantity
	    			};
    			}
    			else {
    				cartItem.quantity = item.orderQantity;
    				cartItem.item.itemImage = [];
    			}
    			itemsService.addItem(self.userId, cartItem).then(function(response) {
    				self.cart = response.data;
    				self.totalBill = 0;
    				self.cart.forEach(cartItem => self.totalBill+=cartItem.item.price*cartItem.quantity);
    			});
	    	};
	    	
	    	self.removeItemToCart = function(item) {
	    		if(item.orderQantity > 0) {
	    			item.orderQantity--;
	    			var cartItem = self.cart.find(cartItem => cartItem.item.id == item.id);
	    			cartItem.quantity = item.orderQantity;
	    			itemsService.removeItem(self.userId, cartItem).then(function(response) {
	    				self.cart = response.data;
	    				self.totalBill = 0;
	    				self.cart.forEach(cartItem => self.totalBill+=cartItem.item.price*cartItem.quantity);
	    			});
	    		}
	    	}
	    }]
	})
	.service('itemsService', ['$http', function($http) {
		this.getUserId = function() {
			return $http.get("/user");
		};
		this.getAll = function getAll() {
			return $http.get("/items");
		};
		this.getCart = function(userId) {
			return $http.get("/cart/" + userId);
		};
		this.addItem = function(userId, cartItem) {
			return $http.post("/cart/" + userId, JSON.stringify(cartItem));
		};
		this.removeItem = function(userId, cartItem) {
			return $http.put("/cart/" + userId, JSON.stringify(cartItem));
		};
	}]);
}()
);