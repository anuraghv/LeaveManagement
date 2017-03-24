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
                    console.log($scope.Variables.SignatureRequestsToMeInvoke);
                    $scope.Variables.SignatureRequestsToMeInvoke.update();
                }
            }
        });
    };


    $scope.SignatureRequestsToMeInvokeonBeforeDatasetReady = function(variable, data) {
        console.log(variable);
        console.log(data);

        var sr = data.signature_requests;
        if (sr !== undefined && sr !== null) {
            for (var i = 0; i < sr.length; i++) {
                var signs = sr[i].signatures;
                var newsigns = [];
                if (signs !== undefined && signs !== null) {
                    for (var j = 0; j < signs.length; j++) {
                        if (signs[j].signer_name == 'Eric Lin' && signs[j].status_code == 'awaiting_signature') {
                            newsigns.push(signs[j]);
                        }
                    }
                    sr[i].signatures = newsigns;
                }
            }
        }
        console.log(data);
    };

}]);