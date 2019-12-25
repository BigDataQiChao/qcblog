app.controller('userController',function($scope,$controller,adminService,userService){
    $controller('baseController',{$scope:$scope});
    //显示当前用户名
    $scope.showLoginName = function(){
        adminService.loginName().success(
            function(response){
                $scope.signinTime = response.signinTime;
                $scope.signinName = response.signinName;
                $scope.signinRole = response.signinRole;
                $scope.signinNums = response.signinNums;
                $scope.signinNumbers = response.signinNumbers;
            }
        );
    };
    //遍历文章列表
    $scope.findUsers = function () {
        userService.findUserAll().success(
            function (response) {
                $scope.users = response;
            }
        )
    };
    $scope.countUser = function () {
        userService.count().success(
            function (response) {
                $scope.countUser = response.countUser;
            }
        )
    };
    //保存
    $scope.save=function(){
        var serviceObject;//服务层对象
        if($scope.userOne.id!=null){//如果有ID
            serviceObject=userService.update( $scope.userOne); //修改
        }else{
            serviceObject=userService.add( $scope.userOne);//增加
        }
        serviceObject.success(
            function(response){
                if(response.success){
                    $scope.reloadList();//重新加载
                    alert(response.message);
                }else{
                    alert(response.message);
                }
            }
        );
    };
    //批量删除
    $scope.dele=function(){
        //获取选中的复选框
        userService.dele( $scope.selectIds ).success(
            function(response){
                if(response.success){
                    alert(response.message);
                    window.location.reload();//刷新列表
                    $scope.selectIds=[];
                }
            }
        );
    };
    //单体删除
    $scope.deleOne=function(id){
        userService.deleOne(id).success(
            function(response){
                if(response.success){
                    alert(response.message);
                    window.location.reload();//刷新列表
                }
            }
        );
    };
    //禁用
    $scope.forbidden = function (name) {
      //获取需要禁用的用户名
        alert("正在禁用'"+name+"'用户,请稍后....");
        userService.forbidden(name).success(
            function (response) {
                if(response.success){
                    window.location.reload();//刷新列表
                }
            }
        );
    };
    //启用
    $scope.enabled = function (name) {
        //获取需要启用的用户名
        alert("正在启用'"+name+"'用户,请稍后....");
        userService.enabled(name).success(
            function (response) {
                if(response.success){
                    window.location.reload();//刷新列表
                }
            }
        );
    };
    //分页
    $scope.findPage=function(page,rows){
        userService.findPage(page,rows).success(
            function(response){
                $scope.users=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    };
    $scope.searchEntity={};//定义搜索对象
    //搜索
    $scope.search=function(page,rows){
        userService.search(page,rows,$scope.searchEntity).success(
            function(response){
                $scope.users=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    };
    //详情页
    $scope.findUserOne = function(title){
        userService.findUserOne(title).success(
            function(response){
                $scope.userOne = response;
            }
        );
    };
    //管理员详情
    $scope.findAdminOne = function(title){
        adminService.findAdminOne(title).success(
            function(response){
                $scope.admin = response;
            }
        );
    };
    //日志详情页
    $scope.findLogs = function(logname){
        adminService.findLogs(logname).success(
            function(response){
                $scope.Logs = response;
            }
        );
    };
});
app.filter('cut',function () {
    return function (value, wordwise, max,tail) {
        if (!value) {
            return "";
        }
        max = parseInt(max, 10);
        if (!max) {
            return value;
        }
        if (value.length <= max) {
            return value;
        }
        value = value.substr(0, max);
        if (wordwise) {
            var lastspace = value.lastIndexOf(' ');
            if (lastspace != -1) {
                value = value.substr(0, lastspace);
            }
        }
        return value + (tail || '...');
    };
});