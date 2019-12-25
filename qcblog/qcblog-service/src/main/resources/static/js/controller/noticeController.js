app.controller('noticeController',function($scope,$controller,adminService,noticeService){
    $controller('baseController',{$scope:$scope});
    //获取当前登录用户的IP地址
    $scope.showIp = function(){
        adminService.getIp().success(
            function(response){
                $scope.signinIp = response.signinIp;
                $scope.signinOSName = response.signinOSName;
            }
        );
    };
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
    $scope.findNotices = function () {
        noticeService.findNotices().success(
            function (response) {
                $scope.notices = response;
            }
        )
    };
    //保存
    $scope.save=function(){
        var serviceObject;//服务层对象
        if($scope.noticeOne.id!=null){//如果有ID
            serviceObject=noticeService.update( $scope.noticeOne ); //修改
        }else{
            serviceObject=noticeService.add( $scope.noticeOne  );//增加
        }
        serviceObject.success(
            function(response){
                if(response.success){
                    //重新查询
                    alert(response.message);
                    $scope.reloadList();//重新加载
                }else{
                    alert(response.message);
                }
            }
        );
    };
    //分页
    $scope.findPage=function(page,rows){
        noticeService.findPage(page,rows).success(
            function(response){
                $scope.notices=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    };
    //批量删除
    $scope.dele=function(){
        //获取选中的复选框
        noticeService.dele( $scope.selectIds ).success(
            function(response){
                if(response.success){
                    window.location.reload();//刷新列表
                    $scope.selectIds=[];
                }
            }
        );
    };
    $scope.searchEntity={};//定义搜索对象
    //搜索
    $scope.search=function(page,rows){
        noticeService.search(page,rows,$scope.searchEntity).success(
            function(response){
                $scope.notices=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    };
    //统计
    $scope.countNotice = function () {
        noticeService.count().success(
            function (response) {
                $scope.countNotice = response.countNotice;
            }
        )
    };
    //发布公告
    $scope.upNotice = function (name) {
        alert("重新发布'"+name+"'公告,请稍后....");
        noticeService.upNotice(name).success(//撤回
            function (response) {
                if (response.success) {
                    $scope.reloadList();//重新加载
                } else {
                    alert(response.message);
                }
            }
        );
    };
    //撤回公告
    $scope.downNotice = function (name) {
        alert("正在撤回'"+name+"'公告,请稍后....");
        noticeService.downNotice(name).success(//撤回
            function (response) {
                if (response.success) {
                    $scope.reloadList();//重新加载
                } else {
                    alert(response.message);
                }
            }
        );
    };
    //详情页
    $scope.findNoticeOne = function(ntname){
        noticeService.findNoticeOne(ntname).success(
            function(response){
                $scope.noticeOne = response;
            }
        );
    }
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