app.controller('articleController', function ($scope, $controller, articleService, flinkService, userService) {
    $controller('baseController', {$scope: $scope});//继承
    //点赞踩功能实现
    $scope.getLike = function (id) {
          articleService.getLike(id).success(
               function (response) {
                   alert(response.message);
                   $scope.reloadList();//重新加载
               }
          )
    };
    //点赞状态码
    $scope.findStatus =function () {
        articleService.findStatus().success(
            function (response) {
                    $scope.likeInfo = response;
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
    //访问量
    $scope.addNumber = function () {
        articleService.addNumber().success(
            function (response) {
                $scope.numbers = response.numbers;
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
    //遍历文章列表
    $scope.findArticles = function () {
        articleService.findArticles().success(
            function (response) {
                $scope.articles = response;
            }
        )
    };
    //通过name查询实体
    $scope.findOne = function (name) {
        articleService.findOne(name).success(
            function (response) {
                $scope.article = response;
            }
        );
    };
    //通过userid 获取文章作者名称
    $scope.findNames = function () {
        articleService.findNameByArticle().success(
            function (response) {
                $scope.userArticles = response;
            }
        )
    }
    //通过atname查询实体----url 单值传参
    $scope.findArticleOne = function (atname) {
        var url = location.search;
        if (url.indexOf("?") != -1) {
            var str = url.substr(1);
            atname = str.split("=");
        }
        articleService.findOne(atname[1]).success(
            function (response) {
                $scope.articleOne = response;
                if ($scope.articleOne.atname != null) {
                    articleService.getPre($scope.articleOne.atname).success( //前一章
                        function (response) {
                            $scope.preAticle = response;
                        }
                    );
                    articleService.getNext($scope.articleOne.atname).success( //后一章
                        function (response) {
                            $scope.nextAticle = response;
                        }
                    );
                }
                /*
                      $scope.getNext($scope.entity.atname);*/
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
    //保存
    $scope.save = function () {
        var serviceObject;//服务层对象
        if ($scope.article.id != null) {//如果有ID
            serviceObject = articleService.update($scope.article); //修改
        } else {
            serviceObject = articleService.add($scope.article);//增加
        }
        serviceObject.success(
            function (response) {
                if (response.success) {
                    //重新查询
                    $scope.reloadList();//重新加载
                } else {
                    alert(response.message);
                }
            }
        );
    };
});
app.filter('trustHtml', function ($sce) {
    return function (input) {
        return $sce.trustAsHtml(input);
    }
});