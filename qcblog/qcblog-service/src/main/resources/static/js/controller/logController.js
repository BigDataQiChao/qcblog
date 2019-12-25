app.controller('logController',function($scope,$controller,adminService,logService){
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
    //获取统计量信息哦
    $scope.showStatics = function () {
        adminService.statisAll().success(
            function (response) {
                $scope.noticeNum = response.noticeNum;
            }
        )
    };
    //遍历日志列表
    $scope.findLogsAll = function () {
        logService.findLogsAll().success(
            function (response) {
                $scope.logs = response;
            }
        )
    };
    //保存
    $scope.save=function(){
        logService.update( $scope.logOne ).success(
            function(response){
                    //重新查询
                    $scope.reloadList();//重新加载
                }
        );
    };
    //分页
    $scope.findPage=function(page,rows){
        logService.findPage(page,rows).success(
            function(response){
                $scope.logs=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    };
    //批量删除
    $scope.dele=function(){
        //获取选中的复选框
        logService.dele( $scope.selectIds ).success(
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
        logService.deleOne(id).success(
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
        logService.search(page,rows,$scope.searchEntity).success(
            function(response){
                $scope.logs=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    };
    //统计
    $scope.countLog = function () {
        logService.count().success(
            function (response) {
                $scope.countSigninlog = response.countSigninlog;
            }
        )
    };
    //详情页
    $scope.findLogOne = function(name){
        logService.findLogOne(name).success(
            function(response){
                $scope.logOne = response;
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
   /* var checkall=document.getElementsByName("checkbox[]");
    var checkallId = document.getElementById("selectId");
    //全选
    $scope.selectlogIds=[];//选中的logID集合
    $scope.select = function(){
        for(var $i=0;$i<checkall.length;$i++){
            checkall[$i].checked=true;
        }
        if(checkall.checked){//如果是被选中,则增加到数组
            $scope.selectlogIds.push(checkallId.value);
            console.log($scope.selectlogIds);
        }
    };
    $scope.noselect = function(id){
        for(var $i=0;$i<checkall.length;$i++){
            if(checkall[$i].checked){
                checkall[$i].checked=false;
                var idx = $scope.selectlogIds.indexOf(id);
                $scope.selectlogIds.splice(idx, 1);//删除
            }
        }
    }*/
});
