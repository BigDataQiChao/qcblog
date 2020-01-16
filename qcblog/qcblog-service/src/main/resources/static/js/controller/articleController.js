app.controller('articleController',function($scope,$controller,$location,adminService,articleService){
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
            }
        )
    };
    //遍历文章列表
    $scope.findArticles = function () {
        articleService.findArticles().success(
            function (response) {
                $scope.articles = response;
            }
        )
    };
    //保存
    $scope.save=function(){
        var serviceObject;//服务层对象
        if($scope.updateOne.id!=null){//如果有ID
            serviceObject=articleService.update( $scope.updateOne ); //修改
        }else{
            serviceObject=articleService.add( $scope.updateOne  );//增加
        }
        serviceObject.success(
            function(response){
                if(response.success){
                    //重新查询
                    alert(response.message);
                    location.href='/article';
                }else{
                    alert(response.message);
                }
            }
        );
    };

    //分页
    $scope.findPage=function(page,rows){
        articleService.findPage(page,rows).success(
            function(response){
                $scope.articles=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    };
    //批量删除
    $scope.dele=function(){
        //获取选中的复选框
        articleService.dele( $scope.selectIds ).success(
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
        articleService.deleOne(id).success(
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
        articleService.search(page,rows,$scope.searchEntity).success(
            function(response){
                $scope.articles=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    };
    //统计
    $scope.countArticle = function () {
        articleService.count().success(
            function (response) {
                $scope.countArticle = response.countArticle;
            }
        )
    };
    //发布文章
    $scope.upArticle = function (name) {
        alert("重新发布'"+name+"'文章,请稍后....");
        articleService.upArticle(name).success(//撤回
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
    $scope.downArticle = function (name) {
        alert("正在撤回'"+name+"'文章,请稍后....");
        articleService.downArticle(name).success(//撤回
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
    $scope.findArticleOne = function(name){
        articleService.findOne(name).success(
            function(response){
                $scope.articleOne = response;
            }
        );
    };
    //详情页
    $scope.updateArticleOne = function(){
        var id=$location.search()['id'];
        if(id==null){
            return ;
        }
        articleService.updateArticleOne(id).success(
            function(response){
                $scope.updateOne = response;
                editor.html($scope.updateOne.atcontent);
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
    //上传图片
    $scope.uploadFile = function(){
        uploadService.uploadFile().success(
            function(response){
                if(response.success){
                    $scope.entity.atImg= response.message;
                    alert("上传成功，文件名为："+response.message);
                }else{
                    alert(response.message);
                }
            }
        ).error(
            function(){
                alert("上传失败");
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
app.filter('trustHtml', function ($sce) {
    return function (input) {
        return $sce.trustAsHtml(input);
    }
});