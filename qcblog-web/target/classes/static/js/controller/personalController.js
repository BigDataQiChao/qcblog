app.controller('personalController',function($scope ,$location,$controller,userService,qcblogService,articleService,uploadService){
    $controller('baseController',{$scope:$scope});//继承
    //访问量
    $scope.addNumber = function(){
        articleService.addNumber().success(
            function(response){
                $scope.numbers = response.numbers;
            }
        )
    };
    $scope.listAll = function () {
        qcblogService.listAll().success(
            function(response){
                $scope.notices = response;
            }
        )
    };
    $scope.userInfo = function () {
        userService.userInfo().success(
            function (repsonse) {
                $scope.userName =repsonse.userName;
                $scope.userEmail = repsonse.userEmail;
                $scope.userIndus = repsonse.userIndus;
                $scope.userTelph = repsonse.userTelph;
                $scope.userStatus = repsonse.userStatus;
                $scope.userTime = repsonse.userTime;
                $scope.userImage = repsonse.userImage;
                $scope.userSex = repsonse.userSex;
                $scope.userTName = repsonse.userTName;
                $scope.userCount = repsonse.userCount;
                $scope.userViewNum = repsonse.userViewNum;
                $scope.userId = repsonse.userId;
                $scope.userCarticNum =repsonse.userCarticNum;
                $scope.userIntro =repsonse.userIntro;
                $scope.userEducation =repsonse.userEducation;
                $scope.userSchName =repsonse.userSchName;
                $scope.userWkCondition =repsonse.userWkCondition;

            }
        )
    };
    $scope.findUserOne = function(id){
        var url = location.search;
        if (url.indexOf("?") != -1) {
            var str = url.substr(1);
            id = str.split("=");
        }
        userService.findOne(id[1]).success(
            function(response){
                $scope.userOne = response;
            }
        );
    };
    //上传图片
    $scope.uploadFile = function(){
        uploadService.uploadFile().success(
            function(response){
                if(response.success){
                    $scope.userOne.image = response.message;
                }else{
                    alert(response.message);
                }
            }
        ).error(
            function(){
                alert(response.message);
            }
        );
    };
    //保存头像
    $scope.saveImage=function () {
        var imageObject;//更换头像对象
        imageObject = userService.updateImage($scope.userOne);
        imageObject.success(
            function (response) {
                if(response.success){
                    //重新查询
                    alert(response.message);
                }else{
                    alert(response.message);
                }
            }
        )
    };
    //保存
    $scope.save=function(){
        var serviceObject;//服务层对象
        serviceObject=userService.update( $scope.userOne); //修改
        serviceObject.success(
            function(response){
                if(response.success){
                    //重新查询
                    alert(response.message);
                }else{
                    alert(response.message);
                }
            }
        );
    };
    $scope.business = ['教育行业', '保险业', '公益组织','航空航天','计算机软件','制造业','交通运输、仓储和邮政','批发和零售','住宿和餐饮业','科学研究、技术服务和地质勘查','金融业','公共管理和社会组织','房地产业','水利、环境和公共设施管理','卫生、社会保障和社会福利','文化、体育和娱乐业','租赁和商务服务','国际组织'];
    $scope.educations = ['小学','初中', '高中', '专科','本科','硕士','博士'];
    $scope.wkconditions = ['学生','工作中','待就业','度假中','隔离中','已确诊'];
});