Application.$controller("LeaveManagementPageController", ["$scope", function($scope) {
    "use strict";

    /* perform any action with the variables inside this block(on-page-load) */
    $scope.onPageVariablesReady = function() {
        /*
         * variables can be accessed through '$scope.Variables' property here
         * e.g. $scope.Variables.staticVariable1.getData()
         */
    };

    /* perform any action with widgets inside this block */
    $scope.onPageReady = function() {
        /*
         * widgets can be accessed through '$scope.Widgets' property here
         * e.g. $scope.Widgets.byId(), $scope.Widgets.byName()or access widgets by $scope.Widgets.widgetName
         */
    };

}]);




Application.$controller("grid5Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("pendingVacationGridController", ["$scope", "wmToaster",

    function($scope, wmToaster) {
        "use strict";
        $scope.ctrlScope = $scope;
        $scope.acceptLeave = function(row, event) {
            //alert("test");
            $scope.Variables.HrdbAcceptLeave.dataBinding.id = row.id;
            $scope.Variables.HrdbAcceptLeave.update();
            console.log(row, event);
            var calendarUpdateData = '{ \"end\": {\"date\": \"' + row.enddate + '\"},\"start\": {\"date\": \"' + row.startdate + '\"},\"summary\": \"' + row.employee.firstname + ' is on vacation.\"}';
            console.log(calendarUpdateData);
            $scope.Variables.svPostEvent.setInput("RequestBody", calendarUpdateData);
            $scope.Variables.svPostEvent.update();
            //$scope.Variables.HrdbVacationData.update();
            wmToaster.success("", "Vacation Request Accepted.");
        };
        $scope.rejectLeave = function(row) {
            $scope.Variables.HrdbRejectLeave.dataBinding.id = row.id;
            $scope.Variables.HrdbRejectLeave.update();
            //$scope.Variables.HrdbVacationData.update();
            wmToaster.error("", "Vacation Request Rejected.");
        };

    }
]);