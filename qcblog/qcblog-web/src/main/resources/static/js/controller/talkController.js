app.controller('talkController',function($scope ,$controller,talkService,uploadService){
    $controller('baseController',{$scope:$scope});//继承
    //访问量
    $scope.addNumber = function(){
        talkService.addNumber().success(
            function(response){
                $scope.numbers = response.numbers;
            }
        )
    };
    $scope.findTalks = function(){
        talkService.findTalks().success(
        function (response) {
            $scope.talks = response;
        }
    )
};
    //上传图片
    $scope.uploadFile = function(){
        uploadService.uploadFile().success(
            function(response){
                if(response.success){
                    $scope.entity.tkImg= response.message;
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
    $scope.save=function(){
        var talkObject;//服务层对象
        if($scope.entity.id!=null){//如果有ID
            talkObject=talkService.update( $scope.entity ); //修改
        }else{
            talkObject=talkService.add( $scope.entity );//增加
        }
        talkObject.success(
            function(response){
                if(response.success){
                    alert(response.message);
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
});