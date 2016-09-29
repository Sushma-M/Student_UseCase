Application.$controller("Subject_DetailsPageController", ["$scope", function($scope) {
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


    $scope.txt_subjectNameChange = function($event, $isolateScope, newVal, oldVal) {
        debugger;
        // var subjectData = $scope.Widgets.txt_subjectName.datavalue;
        // $scope.Widgets.txt_subjectName.datavalue = subjectData.toUpperCase();
    };

    $scope.button_addsubjectClick = function($event, $isolateScope) {
        $scope.Widgets.composite_subjectName.show = true;
        $scope.Widgets.button_addNew.show = true;
        $scope.Widgets.button_cancel.show = true;
        $scope.Widgets.button_addsubject.show = false;
    };
    $scope.txt_subjectNameKeydown = function($event, $isolateScope) {
        if ($event.keyCode === 13) {
            $scope.Variables.LV_InsertSubjectDetails.createRecord();
            $scope.Widgets.txt_subjectName.datavalue = '';
            $scope.Widgets.composite_subjectName.show = false;
            $scope.Widgets.button_addNew.show = false;
            $scope.Widgets.button_cancel.show = false;
            $scope.Widgets.button_addsubject.show = true;

        }
    };

    $scope.button_cancelClick = function($event, $isolateScope) {
        $scope.Widgets.composite_subjectName.show = false;
        $scope.Widgets.button_addNew.show = false;
        $scope.Widgets.button_cancel.show = false;
        $scope.Widgets.button_addsubject.show = true;
        $scope.Widgets.txt_subjectName.datavalue = '';

    };

    $scope.button_addNewClick = function($event, $isolateScope) {
        debugger;
        $scope.Variables.LV_InsertSubjectDetails.createRecord();
        $scope.Widgets.txt_subjectName.datavalue = '';
        $scope.Widgets.composite_subjectName.show = false;
        $scope.Widgets.button_addNew.show = false;
        $scope.Widgets.button_cancel.show = false;
        $scope.Widgets.button_addsubject.show = true;
    };

}]);