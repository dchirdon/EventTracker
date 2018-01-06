angular.module('appModule').factory('activityService', function($http) {
	var service = {};

	var activities = [];

	service.index = function() {
		return $http({
			method : 'GET',
			url : 'rest/distance/'
		})
	};

	service.update = function(editedActivity) {
		return $http({

			method : 'PUT',
			url : 'rest/distance/' + editedActivity.id,
			headers : {
				'Content-Type' : 'application/json'
			},
			data : editedActivity
		})

	}

	service.destroy = function(id) {

		return $http({

			method : 'DELETE',
			url : 'rest/distance/' + id
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