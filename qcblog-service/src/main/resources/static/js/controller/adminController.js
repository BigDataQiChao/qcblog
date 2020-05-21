app.controller('adminController' ,function($scope,$controller,adminService){
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		adminService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	};
    //获取统计量信息哦
    $scope.showStatics = function () {
        adminService.statisAll().success(
            function (response) {
                $scope.noticeNum = response.noticeNum;
                $scope.flow = response.flow;
            }
        )
    };
	//显示当前用户名
	$scope.showLoginName = function(){
		adminService.loginName().success(
				function(response){
					$scope.loginTime = response.loginTime;
					$scope.loginName = response.loginName;
				}
		)
	};
    //详情页
    $scope.findAdminOne = function(name){
        adminService.findAdminOne(name).success(
            function(response){
                $scope.admin = response;
            }
        );
    };
	//保存
	$scope.save=function(){				
		var serviceObject;//服务层对象  				
		if($scope.entity.id!=null){//如果有ID
			serviceObject=adminService.update( $scope.entity ); //修改  
		}else{
			serviceObject=adminService.add( $scope.entity  );//增加 
		}				
		serviceObject.success(
			function(response){
				if(response.success){
					//重新查询 
		        	$scope.reloadList();//重新加载
				}else{
					alert(response.message);
				}
			}		
		);				
	};
	//批量删除 
	$scope.dele=function(){			
		//获取选中的复选框			
		adminService.dele( $scope.selectIds ).success(
			function(response){
				if(response.success){
					window.location.reload();//刷新列表
					$scope.selectIds=[];
				}						
			}		
		);				
	};
	//分页
	$scope.findPage=function(page,rows){			
		adminService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	};
	$scope.searchEntity={};//定义搜索对象 
	//搜索
	$scope.search=function(page,rows){			
		adminService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	};
});	
