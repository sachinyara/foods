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
	    	});
	    	 
	    	$scope.$watch('items', function(newItems, oldItems) {
				if($scope.items != null) {
		    		itemsService.getUserId().then(function(response) {
			    		self.userId = response.data;
			    		itemsService.getCart(self.userId).then(function(response) {
			    			$scope.cart = response.data;
			    		});
		    		});
				}
			});
	    	$scope.$watch('cart', function(newItems, oldItems) {
	    		if($scope.cart != null) {
	    			self.totalCartItems = 0;
					self.totalBill = 0;
	    			$scope.items.forEach(itemCategory => {
	    				itemCategory.items.forEach(item => {
	    					let cartItem = $scope.cart.find(cartItem => cartItem.itemId == item.id);
	    					if(cartItem != null) {
	    						item.orderQantity = cartItem.quantity;
	    						cartItem.name = item.name;
	    						cartItem.price = item.price;
	    						self.totalCartItems += cartItem.quantity;
	    						self.totalBill += cartItem.quantity * cartItem.price;
	    					}
	    					else
	    						item.orderQantity = 0;
	    				});
	    			});
	    		}
			});
	    	self.addItemToCart = function(item) {
	    		if(item.orderQantity)
	    			item.orderQantity++;
    			var cartItem = null;
    			if($scope.cart != null)
    				cartItem = $scope.cart.find(cartItem => cartItem.itemId == item.id);
    			if(cartItem == null) {
	    			cartItem = {
	    				userId: self.userId,
	    				itemId : item.id,
	    				quantity: 1
	    			};
    			}
    			else {
    				cartItem.quantity++;
    			}
    			itemsService.addItem(self.userId, cartItem).then(function(response) {
    				$scope.cart = response.data;
    				self.totalBill = 0;
    				$scope.cart.forEach(cartItem => self.totalBill+=cartItem.price*cartItem.quantity);
    			});
	    	};
	    	
	    	self.removeItemToCart = function(item) {
	    		if(item.orderQantity && item.orderQantity > 0) {
	    			item.orderQantity--;
	    			var cartItem = $scope.cart.find(cartItem => cartItem.itemId == item.id);
	    			cartItem.quantity--;
	    			itemsService.removeItem(self.userId, cartItem).then(function(response) {
	    				$scope.cart = response.data;
	    				self.totalBill = 0;
	    				$scope.cart.forEach(cartItem => self.totalBill+=cartItem.price*cartItem.quantity);
	    			});
	    		}
	    	};
	    	
	    	self.increaseQuantity = function(cartItem) {
    			cartItem.quantity++;
    			itemsService.addItem(self.userId, cartItem).then(function(response) {
    				$scope.cart = response.data;
    				self.totalBill = 0;
    				$scope.cart.forEach(cartItem => self.totalBill+=cartItem.price*cartItem.quantity);
    			});
	    	};
	    	
	    	self.decreaseQuantity = function(cartItem) {
    			cartItem.quantity--;
    			itemsService.removeItem(self.userId, cartItem).then(function(response) {
    				$scope.cart = response.data;
    				self.totalBill = 0;
    				$scope.cart.forEach(cartItem => self.totalBill+=cartItem.price*cartItem.quantity);
    			});
	    	};
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