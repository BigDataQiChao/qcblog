app.controller('indexController', function ($scope, $http, adminService) {
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
    //获取当前登录用户的IP地址
    $scope.showIp = function () {
        adminService.getIp().success(
            function (response) {
                $scope.signinIp = response.signinIp;
                $scope.signinOSName = response.signinOSName;
                $scope.signinCookie = response.signinCookie;
                $scope.signinHost = response.signinHost;
                $scope.signinLanguage = response.signinLanguage;
                $scope.signinConnection = response.signinConnection;
                $scope.signinReferer = response.signinReferer;
            }
        );
    };
    //详情页
    $scope.findAdminOne = function (name) {
        adminService.findAdminOne(name).success(
            function (response) {
                $scope.entity = response;
            }
        );
    };
    //日志详情页
    $scope.findLogs = function (logname) {
        adminService.findLogs(logname).success(
            function (response) {
                $scope.Logs = response;
            }
        );
    };
    //获取统计量信息
    $scope.showStatics = function () {
        adminService.statisAll().success(
            function (response) {
                $scope.articleNum = response.articleNum;
                $scope.noticeNum = response.noticeNum;
                $scope.flinkNum = response.flinkNum;
                $scope.talkNum = response.talkNum;
                $scope.gameNum = response.gameNum;
                $scope.userNum = response.userNum;
                $scope.qcblogNum = response.qcblogNum;
                $scope.numbers = response.numbers;
            }
        )
    };
    $scope.showBingDatas = function () {
        var url = '/getPieData';
        $http.post(url).then(function (response) {
            $scope.pieResult = response;
            return $scope.pieResult;
        })
    }
    $scope.showHistogramDatas = function () {
        var url = '/getHistogram';
        $http.post(url).then(function (response) {
            $scope.histogramResult = response;
            return $scope.histogramResult;
        })
    }
});
app.directive('pie', function () {
        return {
            scope: {
                id: "@",
                legend: "=",
                data: "="
            },
            restrict: 'E',
            template: '<div  style="height:400px;width:100%;margin-top:20px;display:block;"></div>',
            replace: true,
            controller: function ($scope) {
                var ele = document.querySelector("[ng-controller=indexController]");
                var scope = angular.element(ele).scope();
                scope.showBingDatas();
                setTimeout(() => {
                    $scope.result = scope.pieResult.data;
                    $scope.data = [$scope.result];
                    $scope.legend = ['平台用户', '技术文章', '个性说说', '友情链接', '通知公告', '小程序'];
                }, 1500);
            },
            link: function ($scope) {
                setTimeout(() => {
                    var option = {
                        // 提示框，鼠标悬浮交互时的信息提示
                        tooltip: {
                            show: true,
                            trigger: "item",
                            formatter: "{a} <br/>{b} : {c} ({d}%)"
                        },
                        // 图例
                        legend: {
                            data: $scope.legend
                        },
                        // 数据内容数组
                        series: function () {
                            var serie = [];
                            for (var i = 0; i < $scope.legend.length; i++) {
                                var item = {
                                    name: '平台数据报告',
                                    type: 'pie',
                                    data: $scope.data[i],
                                    animationType: 'scale',
                                    animationEasing: 'elasticOut',
                                    //	roseType: 'radius',
                                    animationDelay: function (idx) {
                                        return Math.random() * 200;
                                    }
                                };
                                serie.push(item);
                            }
                            return serie;
                        }()
                    };
                    var myChart = echarts.init(document.getElementById("pie"));
                    myChart.setOption(option);
                }, 1500);
            }
        };
});
app.directive('bar', function() {
    return {
        scope: {
            id: "@",
            data: "="
        },
        restrict: 'E',
        template: '<div  style="height:400px;width:100%;margin-top:20px;display:block;"></div>',
        replace: true,
        controller: function ($scope) {
            var ele = document.querySelector("[ng-controller=indexController]");
            var scope = angular.element(ele).scope();
            scope.showHistogramDatas();
            setTimeout(() => {
                $scope.data = scope.histogramResult.data;
            }, 2000);
        },
        link: function($scope) {
            setTimeout(() => {
                var option = {
                    tooltip:{
                        trigger:'axis',
                        axisPointer:{
                            type:'shadow'
                        }
                    },
                    legend: {},
                    dataset: {
                        source: [
                            ['product', '并发数据量', '平台访问量'],
                            ['平台数据报告', $scope.data[0], $scope.data[1]],
                        ]
                    },
                    xAxis:{
                        type:'category',
                    },
                    yAxis:{
                        type: 'value'
                    },
                    series:[
                        {barWidth:'10%',type: 'bar'},
                        {barWidth:'10%',type: 'bar'}
                    ]
                };
                var myChart = echarts.init(document.getElementById("histogram"));
                myChart.setOption(option);
            }, 2000);
        }
    };
});


