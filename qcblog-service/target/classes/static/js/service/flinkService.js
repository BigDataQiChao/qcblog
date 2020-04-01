app.service('flinkService',function($http){
    //遍历
    this.findFlinks = function () {
        return $http.get("/Flink/findAll");
    };
    //增加
    this.add=function(entity){
        return  $http.post('/Flink/add',entity );
    };
    //分页
    this.findPage=function(page,rows){
        return $http.get('/Flink/findPage?page='+page+'&rows='+rows);
    };
    //修改
    this.update=function(entity){
        return  $http.post('/Flink/update',entity);
    };
    //批量删除
    this.dele=function(ids){
        return $http.get('/Flink/delete?ids='+ids);
    };
    //单体删除
    this.deleOne=function(id){
        return $http.get('/Flink/deleteOne?id='+id);
    };
    //分页搜索
    this.search=function(page,rows,searchEntity){
        return $http.post('/Flink/search?page='+page+"&rows="+rows, searchEntity);
    };
    //计数
    this.count=function(){
        return  $http.get('/Flink/count');
    };
    //发布
    this.upFlink = function (flname) {
        return $http.get('/Flink/up?flname='+flname);
    };
    //撤回
    this.downFlink = function (flname) {
        return $http.get('/Flink/down?flname='+flname);
    };
    //名称查询
    this.findFlinkOne=function(flname){
        return $http.get('/Flink/findOne?flname='+flname);
    };
});