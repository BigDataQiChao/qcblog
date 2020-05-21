app.controller('cmsController',function($scope,$controller,$location,flinkService,noticeService,adminService,cmsService) {
    $controller('baseController', {$scope: $scope});
    //显示当前用户名
    $scope.showLoginName = function () {
        adminService.loginName().success(
            function (response) {
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
    //遍历公告列表
    $scope.findNotices = function () {
        noticeService.findNotices().success(
            function (response) {
                $scope.notices = response;
            }
        )
    };

    //遍历爬取数据
    $scope.findCmsAll = function () {
        cmsService.findCmsAll().success(
            function (response) {
                $scope.cmsall = response;
            }
        )
    };
    $scope.findPage=function(page,rows){
        cmsService.findPage(page,rows).success(
            function(response){
                $scope.cmsall=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    };
    $scope.searchEntity={};//定义搜索对象
    //搜索
    $scope.search=function(page,rows){
        cmsService.search(page,rows,$scope.searchEntity).success(
            function(response){
                $scope.cmsall=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    };
    //批量删除
    $scope.dele=function(){
        //获取选中的复选框
        cmsService.dele( $scope.selectIds ).success(
            function(response){
                if(response.success){
                    window.location.reload();//刷新列表
                    $scope.selectIds=[];
                }
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
    //文章审核详情页
    $scope.findCmsOne = function (id) {
        cmsService.findCmsOne(id).success(
            function (response) {
                $scope.cmsOne =response;
            }
        )
    };
    //文章去审核
    $scope.checkCms = function (id) {
        cmsService.checkCms(id).success(
            function (response) {
                alert(response.message);
                $scope.reloadList();//重新加载
            }
        )
    }
    //文章去驳回
    $scope.checkDownCms = function (id) {
        cmsService.checkDownCms(id).success(
            function (response) {
                alert(response.message);
                $scope.reloadList();//重新加载
            }
        )
    }

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
app.filter('trustHtml',['$sce', function ($sce) {
    return function (input) {
        return $sce.trustAsHtml(input);
    }
}]);