app.controller('qcblogController', function ($scope, $controller, userService, qcblogService, flinkService, articleService) {
    $controller('baseController', {$scope: $scope});//继承
    //访问量
    $scope.addNumber = function () {
        qcblogService.addNumber().success(
            function (response) {
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
            function (response) {
                $scope.noticelist = response;
            }
        )
    }
    //用户登录信息
    $scope.userInfo = function () {
        userService.userInfo().success(
            function (response) {
                $scope.userName = response.userName;
                $scope.userTime = response.userTime;
                $scope.userCount = response.userCount;
                $scope.userImage = response.userImage;
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
    $scope.searchArticle = function () {
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
    //首页文章推荐
    $scope.findIndexArticle = function () {
         articleService.findIndexArticle().success(
             function (response) {
                 $scope.IndexArticle = response;
             }
         )
    };
    //专题切换
    $scope.subCut = [
        {name: 'Java专题'},
        {name: 'Python专题'},
        {name: '区块链专题'},
        {name: 'Spring专题'},
        {name: '教育专题'},
        {name: '论坛专题'},
        {name: '中台专题'},
        {name: '其他专题'}
    ];
    $scope.findSubList = function () {
        articleService.findSubList($scope.subCut[0].name).success(
            function (response) {
                $scope.subCutDetail = response;
            }
        );
        var qiehuan = document.getElementsByClassName('panel-title');
        qiehuan[0].style.color = "#29bd80";
        for (let i = 0; i < qiehuan.length; i++) {
            const item = qiehuan[i];
            item.onclick = function () {
                articleService.findSubList($scope.subCut[i].name).success(
                    function (response) {
                        $scope.subCutDetail = response;
                    }
                );
                $scope.reloadList();
                for (let index = 0; index < qiehuan.length; index++) {
                    qiehuan[index].style.color = '#333';
                }
                item.style.color = '#29bd80';
            }
        }
    };

    //获取用户IP地址
    //获取当前登录用户的IP地址
    $scope.showIp = function () {
        qcblogService.getIp().success(
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
