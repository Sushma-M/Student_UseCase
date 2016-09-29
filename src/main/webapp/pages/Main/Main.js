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
                var gradeMinValue = gradeData[i].minValue;
                var gradeMaxValue = gradeData[i].maxValue;
                if ($scope.Widgets.minValue.datavalue >= gradeMinValue && $scope.Widgets.minValue.datavalue <= gradeMaxValue) {
                    $scope.Widgets.minValue.setValidationMessage('Entered Value ' + $scope.Widgets.minValue.datavalue + ' overlaps in Grade: ' + gradeData[i].grade);
                    $scope.Widgets.save.disabled = true;
                    break;
                } else {
                    $scope.Widgets.save.disabled = false;
                    continue;
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
            debugger;
            // var gradeData1 = $scope.Variables.School_DB_GradeDetailsData.dataSet.data,
            //     maxVal = _.max(_.map(gradeData1, function(obj) {
            //         return obj.maxValue
            //     })),
            //     minVal = _.min(_.map(gradeData1, function(obj) {
            //         return obj.minValue
            //     }));
            // debugger;
            // $scope.Widgets.maxValue.minvalue = minVal;
            // $scope.Widgets.maxValue.maxvalue = maxVal;
            /*                maxInput = $scope.Widgets.maxValue.datavalue;
                        if (maxInput > minVal && maxInput <= maxVal) {
                            $scope.Widgets.maxValue.setValidationMessage('Entered Value ' + maxInput + ' overlaps in Grade');
                        }*/
            var gradeData1 = $scope.Variables.School_DB_GradeDetailsData.dataSet.data;
            var len1 = gradeData1.length;
            console.log(gradeData1);
            console.log(len1);
            for (var j = 0; j < len1; j++) {
                var gradeMinValue1 = gradeData1[j].minValue;
                var gradeMaxValue1 = gradeData1[j].maxValue;
                if ($scope.Widgets.maxValue.datavalue >= gradeMinValue1 && $scope.Widgets.maxValue.datavalue <= gradeMaxValue1) {
                    $scope.Widgets.maxValue.setValidationMessage('Entered Value ' + $scope.Widgets.maxValue.datavalue + ' overlaps in Grade: ' + gradeData1[j].grade);
                    $scope.Widgets.save.disabled = true;
                    break;
                } else if ($scope.Widgets.maxValue.datavalue <= $scope.Widgets.minValue.datavalue) {
                    $scope.Widgets.maxValue.setValidationMessage('Entered Value ' + $scope.Widgets.maxValue.datavalue + ' is less than or Equal to ' + $scope.Widgets.minValue.datavalue);
                    $scope.Widgets.save.disabled = true;
                    break;
                } else {
                    $scope.Widgets.save.disabled = false;
                    continue;
                }
            }
        };

    }
]);