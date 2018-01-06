angular.module('appModule').component('activityList', {
	templateUrl : 'app/appModule/activityList/activityList.component.html',
	controller : function(activityService) {
		var vm = this;

		vm.activities = [];

		vm.selected = null;

		vm.editActivity = null;

		vm.todos = activityService.index();

		vm.updateActivity = function(editedActivity) {
			activityService.update(editedActivity).then(function(response) {
				reloadActivities();
			})
		}

		vm.deleteActivity = function(activity) {
			activityService.destroy(activity).then(function(response) {
				reloadActivities();
			})

		}

		vm.setEditActivity = function() {
			vm.editActivity = angular.copy(vm.selected);
		}

		vm.displayTable = function() {
			vm.selected = null;
		}

		vm.displayActivity = function(activity) {
			vm.selected = activity;
		}

		vm.countActivities = function() {
			return vm.activities.length;
		}

		var reloadActivities = function() {
			activityService.index() 
			.then(function(response) { 

				vm.activities = response.data;
			});
		};
		reloadActivities();

		vm.addActivity = function(activity) {
			activityService.create(activity).then(function() {
				reloadActivities();
			});
		}

	},
	controllerAs : 'vm'
});