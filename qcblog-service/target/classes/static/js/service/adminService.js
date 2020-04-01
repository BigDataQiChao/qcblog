app.service('adminService',function($http){
	//获取登录信息
	this.loginName = function(){
		return $http.get('/signinName');
	};
	this.findAll = function(){
		return $http.get('/Admin/findAll');
	};
    this.statisAll = function(){
        return $http.get('/statistics');
    };
	//获取客户端IP
	this.getIp = function () {
		return $http.get('/signinIp');
    };
   //查询实体
	this.findAdminOne=function(name){
		return $http.get('/Admin/findOne?name='+name);
	};
    //查询实体
    this.findLogs=function(logname){
        return $http.get('/Log/findLogs?logname='+logname);
    };
	//增加
	this.add=function(entity){
		return  $http.post('/Admin/add',entity );
	};
	//修改 
	this.update=function(entity){
		return  $http.post('/Admin/update',entity );
	};
	//删除
	this.dele=function(ids){
		return $http.get('/Admin/delete?ids='+ids);
	};
	this.search=function(page,rows,searchEntity){
		return $http.post('/Admin/search?page='+page+"&rows="+rows, searchEntity);
	};
	//分页 
	this.findPage=function(page,rows){
		return $http.get('/Admin/findPage?page='+page+'&rows='+rows);
	};
});