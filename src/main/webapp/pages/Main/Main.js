Application.$controller("MainPageController", ["$scope", function($scope) {
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
    // $scope.txt_subjectNameChange = function($event, $isolateScope, newVal, oldVal) {
    //     debugger;
    //     var subName = $scope.Widgets.txt_subjectName.datavalue;
    //     $scope.Variables.LV_InsertSubjectDetails.setInput('subjectName', subName);
    //     $scope.Variables.LV_InsertSubjectDetails.createRecord();
    //     $scope.Variables.School_DB_SubjectDetailsData.listRecords();
    //     $scope.Widgets.composite_subjectName.show = false;
    // };


    $scope.button_addsubjectClick = function($event, $isolateScope) {
        $scope.Widgets.composite_subjectName.show = true;
        $scope.Widgets.button_addNew.show = true;
        $scope.Widgets.button_addsubject.show = false;
    };


    $scope.button_addNewClick = function($event, $isolateScope) {
        debugger;
        $scope.Variables.LV_InsertSubjectDetails.createRecord();
        $scope.Widgets.txt_subjectName.datavalue = '';
        $scope.Widgets.composite_subjectName.show = false;
        $scope.Widgets.button_addNew.show = false;
        $scope.Widgets.button_addsubject.show = true;
    };


}]);


Application.$controller("grid_testDetailsController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("grid_academicYearController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("liveform_academicYearController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.startYearChange = function($event, $isolateScope, newVal, oldVal) {
            //debugger;
            var acStartYear = $scope.Widgets.startYear.datavalue;
            $scope.Widgets.endYear.datavalue = acStartYear + 1;
            var acEndYear = $scope.Widgets.endYear.datavalue;
            var s1 = acStartYear.toString();
            var s2 = acEndYear.toString();
            $scope.Widgets.academicYear.datavalue = s1 + '-' + s2;
        };

    }
]);


Application.$controller("grid_standardDetailsController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("liveform_standardDetailsController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("grid_gradeDetailsController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("liveform_gradeDetailsController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
        $scope.minValueChange = function($event, $isolateScope, newVal, oldVal) {
            debugger;
            var gradeData = $scope.Variables.School_DB_GradeDetailsData.dataSet.data;
            var len = gradeData.length;
            console.log(gradeData);
            console.log(len);
            for (var i = 0; i < len; i++) {
                var maxRangeValue = gradeData[i].minValue - 1;
                var gradeLevelMinValue = gradeData[i].minValue;
                if ($scope.Widgets.minValue.datavalue < maxRangeValue && $scope.Widgets.minValue.datavalue < gradeLevelMinValue) {
                    continue;
                } else {
                    $scope.Widgets.minValue.setValidationMessage('Entered Value ' + $scope.Widgets.minValue.datavalue + ' overlaps in Grade: ' + gradeData[i].grade);
                    break;
                }
            }
            // gradeData.forEach(function(gradeLevel) {
            //     console.log(gradeLevel.minValue + '.. ' + gradeLevel.maxValue)
            //     if ($scope.Widgets.minValue.datavalue < 100) {
            //         var maxRangeBoundValue = gradeLevel.maxValue - 1;
            //         if ($scope.Widgets.minValue.datavalue < maxRangeBoundValue && $scope.Widgets.minValue.datavalue < gradeLevel.minValue) {
            //             //alert(gradeLevel.grade);
            //             //    $scope.Widgets.minValue.datavalue = $scope.Widgets.minValue.datavalue;
            //             return true;
            //         } else {
            //             return false;
            //             alert('enter valid range');
            //             console.log('Please enter valid value');
            //         }

            //     }

            // })
        };

        $scope.maxValueChange = function($event, $isolateScope, newVal, oldVal) {
            var gradeData1 = $scope.Variables.School_DB_GradeDetailsData.dataSet.data;
            var len1 = gradeData1.length;
            for (var j = 0; j < len1; j++) {
                var maxRangeValue1 = gradeData1[j].minValue - 1;
                var gradeLevelMinValue1 = gradeData1[j].minValue;
                if ($scope.Widgets.maxValue.datavalue <= maxRangeValue1 && $scope.Widgets.maxValue.datavalue < gradeLevelMinValue1) {
                    continue;
                } else {
                    $scope.Widgets.minValue.setValidationMessage('Entered Value ' + $scope.Widgets.maxValue.datavalue + ' overlaps in Grade: ' + gradeData[i].grade);
                    break;
                }
            }
        };

    }
]);