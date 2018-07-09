 angular.module('foodsApp')
 .directive('customTitle', function(){
	return {
		restrict : "A",
		scope : {
		    value : '=customTitle'
		  },
		  link: function(scope, element) {
		    if (scope.value && scope.value.length > 40) {
		    	element.attr('title', scope.value);
		    }
		  }
	}
})
.filter('ellipsis', function () {
   return function (input) {
     if(input && input.length > 40) {
    	 return input.substr(0,40) + "...";
     }
     else {
    	 return input;
     }
   };
});