Application.$controller("ChatPagePageController", ["$scope", "$timeout", function($scope, $timeout) {
    "use strict";

    /* perform any action on widgets/variables within this block */
    $scope.onPageReady = function() {
        /*
         * variables can be accessed through '$scope.Variables' property here
         * e.g. to get dataSet in a staticVariable named 'loggedInUser' use following script
         * $scope.Variables.loggedInUser.getData()
         *
         * widgets can be accessed through '$scope.Widgets' property here
         * e.g. to get value of text widget named 'username' use following script
         * '$scope.Widgets.username.datavalue'
         */
        $scope.picUrls = {};
    };

    $scope.chatroomonMessageReceive = function(variable, data) {

        $timeout(function() {
                WM.element('.chatcontent').animate({
                    scrollTop: WM.element('.chatcontent')[0].scrollHeight
                }, 1000);
            })
            //        $scope.Widgets.messageForm.reset();
            //        $scope.Widgets.message.datavalue = "";
    };


    $scope.employeeDataonSuccess = function(variable, data) {
        for (var i = 0; i < data.length; i++) {
            $scope.picUrls[data[i].username] = data[i].picurl;
        }
    };




    $scope.messageFormSubmit = function($event, $isolateScope, $formData) {
        $timeout(function() {
            console.log("messageFormSubmit:timeout called");
            $scope.Widgets.message.datavalue = "";
        }, 300);
    };


    $scope.messageFormSuccess = function($event, $isolateScope, $data) {
        //$scope.Widgets.messageForm.reset();

    };

}]);

Application.$controller("dialog1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.fileupload3Success = function($event, $isolateScope) {
            console.log($event, $isolateScope);
        };


        $scope.button2Click = function($event, $isolateScope) {
            //   debugger;
            $scope.Widgets.message.datavalue = $scope.Widgets.fileupload3.uploadedFiles[0].path;
            console.log($scope.Widgets.fileupload3.uploadedFiles[0].path);
            console.log($scope.Widgets.message.datavalue);
            $scope.Widgets.messageForm.submit();
            //$scope.Widgets.message.datavalue = "";
            //$scope.Widgets.messageForm.reset();
        };


        $scope.button2Click1 = function($event, $isolateScope) {
            //$scope.Widgets.message.datavalue = "";

        };

    }
]);