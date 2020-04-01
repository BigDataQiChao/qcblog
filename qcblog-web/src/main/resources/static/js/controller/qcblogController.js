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
    //获取用户IP地址
    //获取当前登录用户的IP地址
    $scope.showIp = function () {
        adminService.getIp().success(
            function (response) {
                $scope.signinReferer = response.signinReferer;
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
