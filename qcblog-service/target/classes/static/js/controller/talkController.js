app.controller('talkController',function($scope,$controller,adminService,talkService,noticeService){
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
    $scope.findTalks = function () {
        talkService.findTalks().success(
            function (response) {
                $scope.talks = response;
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
            serviceObject=talkService.update( $scope.entity ); //修改
        }else{
            serviceObject=talkService.add( $scope.entity  );//增加
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
        talkService.findPage(page,rows).success(
            function(response){
                $scope.talks=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    };
    //批量删除
    $scope.dele=function(){
        //获取选中的复选框
        talkService.dele( $scope.selectIds ).success(
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
        talkService.deleOne(id).success(
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
        talkService.search(page,rows,$scope.searchEntity).success(
            function(response){
                $scope.talks=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    };
    //统计
    $scope.countTalk = function () {
        talkService.count().success(
            function (response) {
                $scope.countTalk = response.countTalk;
            }
        )
    };
    //发布文章
    $scope.upTalk = function (tkTitle) {
        alert("重新发布该说说,请稍后...")
        talkService.upTalk(tkTitle).success(//撤回
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
    $scope.downTalk = function (tkTitle) {
        alert("正在撤回该说说,请稍后...");
        talkService.downTalk(tkTitle).success(//撤回
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
    $scope.findTalkOne = function(tkTitle){
        talkService.findTalkOne(tkTitle).success(
            function(response){
                $scope.talkOne = response;
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