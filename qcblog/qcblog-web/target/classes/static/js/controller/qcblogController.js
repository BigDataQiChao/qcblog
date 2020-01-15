app.controller('qcblogController',function($scope ,$controller,qcblogService,flinkService,articleService){
    $controller('baseController',{$scope:$scope});//继承
	//访问量
        $scope.addNumber = function(){
            qcblogService.addNumber().success(
                function(response){
                    $scope.numbers = response.numbers;
                }
            )
    };
    //用户名
    $scope.loginName = function(){
        qcblogService.loginName().success(
            function(response){
                $scope.signinName = response.signinName;
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
});
/*
app.filter('trustHtml', function ($sce) {
    return function (input) {
        return $sce.trustAsHtml(input);
    }
});*/
