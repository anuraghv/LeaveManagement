Application.$controller("SignPolicyPageController", ["$scope", function($scope) {
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
        HelloSign.init("bf57d8f5492b4436756ea7393ad67ff2");
    };


    $scope.svGetSigntatureURLonSuccess = function(variable, data) {
        console.log(variable);
        console.log(data);
        HelloSign.open({
            url: data.embedded.sign_url,
            allowCancel: true,
            messageListener: function(eventData) {

                console.log(eventData);
                if (eventData.event === 'signature_request_signed') {
                    alert("HelloSign event received");
                    console.log($scope.Variables.SignatureRequestsToMeInvoke);
                    $scope.Variables.SignatureRequestsToMeInvoke.update();
                    alert("HelloSign event received after");
                }
            }
        });
    };

}]);


Application.$controller("grid1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);