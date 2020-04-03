 //控制层
app.controller('baseController' ,function($scope){
	
    //重新加载列表数据
    $scope.reloadList=function(){
    	//切换页码  
    	$scope.search( $scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);	   	
    }

	//分页控件配置
	$scope.paginationConf = {
         currentPage: 1,
         totalItems: 5,
         itemsPerPage: 5,
         perPageOptions: [5, 15, 25, 35, 45],
         onChange: function(){
        	 $scope.reloadList();//重新加载
     	 }
	}; 
	$scope.selectIds=[];//选中的ID集合 
	//更新复选
	$scope.updateSelection = function($event, id) {		
		if($event.target.checked){//如果是被选中,则增加到数组
			$scope.selectIds.push( id);			
		}else{
			var idx = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(idx, 1);//删除 
		}
	}
	
});	