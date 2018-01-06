angular.module('appModule').factory('activityService', function($http) {
	var service = {};

	var activities = [];

	service.index = function() {
		return $http({
			method : 'GET',
			url : 'rest/distance/'
		})
	};

	service.update = function(edittedActivity) {
		return $http({

			method : 'PUT',
			url : 'rest/user/1/todo/' + edittedActivity.id,
			headers : {
				'Content-Type' : 'application/json'
			},
			data : edittedActivity
		})

	}

	service.destroy = function(id) {

		return $http({

			method : 'DELETE',
			url : 'rest/distance/1/' + id
		})

	}

	service.create = function(todo) {
		return $http({

			method : 'POST',
			url : 'rest/distance/',
			headers : {
				'Content-Type' : 'application/json'
			},
			data : todo
		})
	}
	return service;

})