app.controller('qcblogController',function($scope ,$controller,userService,qcblogService,flinkService,articleService){
    $controller('baseController',{$scope:$scope});//继承
	//访问量
        $scope.addNumber = function(){
            qcblogService.addNumber().success(
                function(response){
                    $scope.numbers = response.numbers;
                }
            )
    };
    //通过userid 获取文章作者名称
    $scope.findNames = function () {
        articleService.findNameByArticle().success(
            function (response) {
                $scope.userArticles = response;
            }
        )
    }
    //通知公告
    $scope.listAll = function () {
        qcblogService.listAll().success(
            function(response){
                $scope.noticelist = response;
            }
        )
    }
    //用户登录信息
    $scope.userInfo = function () {
        userService.userInfo().success(
            function (response) {
                $scope.signinName = response.signinName;
                $scope.signinTime = response.signinTime;
                $scope.userCount = response.userCount;
                $scope.signinImage = response.signinImage;
            }
        )
    };
    //遍历链接
    $scope.findFlinks = function () {
        flinkService.findFlinks().success(
            function (response) {
                $scope.flinks = response;
            }
        )
    };
    $scope.searchArticle =function () {
        alert("请登录后操作！！！")
    };
    //遍历文章列表
    $scope.findArticles = function () {
        articleService.findArticles().success(
            function (response) {
                $scope.articles = response;
            }
        )
    };
    //专题切换
    $scope.subCut = [
        {name:'java'},
        {name:'python'},
        {name:'java2'},
    ];
    $scope.subCutDetail = $scope.subCut[0];
        var qiehuan = document.getElementsByClassName('panel-title');
        qiehuan[0].style.color = "#29bd80";
        for (let i = 0; i < qiehuan.length; i++) {
            const item = qiehuan[i];
            item.onclick = function(){
                $scope.subCutDetail = $scope.subCut[i];
                $scope.reloadList();
                for (let index = 0; index < qiehuan.length; index++) {
                    qiehuan[index].style.color = '#333';
                }
                item.style.color = '#29bd80';
            }
        }
    //获取用户IP地址
    //获取当前登录用户的IP地址
    $scope.showIp = function () {
        adminService.getIp().success(
            function (response) {
                $scope.signinReferer = response.signinReferer;
            }
        );
    };
    //分页
    $scope.findPage = function (page, rows) {
        articleService.findPage(page, rows).success(
            function (response) {
                $scope.articles = response.rows;
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    };
    $scope.searchEntity = {};//定义搜索对象
    //搜索
    $scope.search = function (page, rows) {
        articleService.search(page, rows, $scope.searchEntity).success(
            function (response) {
                $scope.articles = response.rows;
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    };
});
/*
app.filter('trustHtml', function ($sce) {
    return function (input) {
        return $sce.trustAsHtml(input);
    }
});*/
