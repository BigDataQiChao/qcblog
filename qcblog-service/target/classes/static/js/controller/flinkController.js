app.controller('flinkController',function($scope,$controller,adminService,noticeService,flinkService){
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
    //获取统计量信息
    $scope.showStatics = function () {
        adminService.statisAll().success(
            function (response) {
                $scope.noticeNum = response.noticeNum;
                $scope.flow = response.flow;
            }
        )
    };
    //遍历文章列表
    $scope.findFlinks = function () {
        flinkService.findFlinks().success(
            function (response) {
                $scope.flinks = response;
            }
        )
    };
    //遍历公告列表
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
        if($scope.entity.id!=null){//如果有ID
            serviceObject=flinkService.update( $scope.entity ); //修改
        }else{
            serviceObject=flinkService.add( $scope.entity  );//增加
        }
        serviceObject.success(
            function(response){
                if(response.success){
                    //重新查询
                    $scope.reloadList();//重新加载
                }else{
                    alert(response.message);
                }
            }
        );
    };

    //分页
    $scope.findPage=function(page,rows){
        flinkService.findPage(page,rows).success(
            function(response){
                $scope.flinks=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    };
    //批量删除
    $scope.dele=function(){
        //获取选中的复选框
        flinkService.dele( $scope.selectIds ).success(
            function(response){
                if(response.success){
                    window.location.reload();//刷新列表
                    $scope.selectIds=[];
                }
            }
        );
    };
    //单体删除
    $scope.deleOne=function(id){
        flinkService.deleOne(id).success(
            function(response){
                if(response.success){
                    alert(response.message);
                    window.location.reload();//刷新列表
                }
            }
        );
    };
    $scope.searchEntity={};//定义搜索对象
    //搜索
    $scope.search=function(page,rows){
        flinkService.search(page,rows,$scope.searchEntity).success(
            function(response){
                $scope.flinks=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    };
    //统计
    $scope.countFlink = function () {
        flinkService.count().success(
            function (response) {
                $scope.countFlink = response.countFlink;
            }
        )
    };
    //发布文章
    $scope.upFlink = function (name) {
        alert("重新发布'"+name+"'友链,请稍后....");
        flinkService.upFlink(name).success(//撤回
            function (response) {
                if (response.success) {
                    $scope.reloadList();//重新加载
                } else {
                    alert(response.message);
                }
            }
        );
    };
    //撤回文章
    $scope.downFlink = function (name) {
        alert("正在撤回'"+name+"'友链,请稍后....");
        flinkService.downFlink(name).success(//撤回
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
    $scope.findFlinkOne = function(name){
        flinkService.findFlinkOne(name).success(
            function(response){
                $scope.entity = response;
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