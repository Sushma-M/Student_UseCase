Application.$controller("ManagementPagePageController", ["$scope", function($scope) {
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
    };


    $scope.livelist_academicSubjectsgroupby = function(rowData) {
        return 'Standard: ' + rowData.standard + ' Year:' + rowData.academicYear;
        /*
         * this function is iterated over each data object in the livelist dataSet collection the data will be grouped by what is returned from this function E.g. to group a collection of CGPA details under rounded figure CGPA return following return Math.floor(dataObject.cgpa)
         */
    };

}]);


Application.$controller("grid_academicsController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("liveform6Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);



Application.$controller("dialog1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("grid2Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("grid3Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("dialog3Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);







Application.$controller("dialog2Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("grid6_1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);





Application.$controller("liveform_academicsController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("grid_studentDetailsController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("liveform_studentDetailsController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("dialog4Controller", ["$scope",
	function($scope) {
		"use strict";
		$scope.ctrlScope = $scope;
	}
]);



Application.$controller("liveform4Controller", ["$scope",
	function($scope) {
		"use strict";
		$scope.ctrlScope = $scope;
	}
]);