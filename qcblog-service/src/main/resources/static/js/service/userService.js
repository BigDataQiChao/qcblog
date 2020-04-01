app.service('userService',function($http){
    this.findUserAll = function () {
        return $http.get("/User/findAll");
    };
    //增加
    this.add=function(entity){
        return  $http.post('/User/add',entity );
    };
    //计数
    this.count=function(){
        return  $http.get('/User/count');
    };
    //修改
    this.update=function(entity){
        return  $http.post('/User/update',entity);
    };
    //批量删除
    this.dele=function(ids){
        return $http.get('/User/delete?ids='+ids);
    };
    //单体删除
    this.deleOne=function(id){
        return $http.get('/User/deleteOne?id='+id);
    };
    //禁用
    this.forbidden=function (name) {
      return $http.get("/User/forbiddenOne?name="+name);
    };
    //启用
    this.enabled=function (name) {
        return $http.get("/User/enabledOne?name="+name);
    };
    this.search=function(page,rows,searchEntity){
        return $http.post('/User/search?page='+page+"&rows="+rows, searchEntity);
    };
    //分页
    this.findPage=function(page,rows){
        return $http.get('/User/findPage?page='+page+'&rows='+rows);
    };
    //名称查询
    this.findUserOne=function(name){
        return $http.get('/User/findOne?name='+name);
    }
});