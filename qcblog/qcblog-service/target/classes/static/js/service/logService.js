app.service('logService',function($http){
    //遍历
    this.findLogsAll = function () {
        return $http.get("/Log/findAll");
    };
    //增加
    this.add=function(entity){
        return  $http.post('/Log/add',entity );
    };
    //分页
    this.findPage=function(page,rows){
        return $http.get('/Log/findPage?page='+page+'&rows='+rows);
    };
    //修改
    this.update=function(entity){
        return  $http.post('/Log/update',entity);
    };
    //批量删除
    this.dele=function(ids){
        return $http.get('/Log/delete?ids='+ids);
    };
    //单体删除
    this.deleOne=function(id){
        return $http.get('/Log/deleteOne?id='+id);
    };
    //分页搜索
    this.search=function(page,rows,searchEntity){
        return $http.post('/Log/search?page='+page+"&rows="+rows, searchEntity);
    };
    //计数
    this.count=function(){
        return  $http.get('/Log/count');
    };
    //名称查询
    this.findLogOne=function(id){
        return $http.get('/Log/findOne?id='+id);
    };
});