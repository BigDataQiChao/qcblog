app.service('articleService',function($http){
    //遍历
    this.findArticles = function () {
        return $http.get("/Article/findAll");
    };
    //增加
    this.add=function(entity){
        return  $http.post('/Article/add',entity );
    };
    //分页
    this.findPage=function(page,rows){
        return $http.get('/Article/findPage?page='+page+'&rows='+rows);
    };
    //修改
    this.update=function(entity){
        return  $http.post('/Article/update',entity);
    };
    //批量删除
    this.dele=function(ids){
        return $http.get('/Article/delete?ids='+ids);
    };
    //单体删除
    this.deleOne=function(id){
        return $http.get('/Article/deleteOne?id='+id);
    };
    //分页搜索
    this.search=function(page,rows,searchEntity){
        return $http.post('/Article/search?page='+page+"&rows="+rows, searchEntity);
    };
    //计数
    this.count=function(){
        return  $http.get('/Article/count');
    };
    //发布
    this.upArticle = function (atname) {
        return $http.get('/Article/up?atname='+atname);
    };
    //撤回
    this.downArticle = function (atname) {
        return $http.get('/Article/down?atname='+atname);
    };
    //名称查询
    this.findOne=function(atname){
        return $http.get('/Article/findOne?atname='+atname);
    };
    this.updateArticleOne = function (id) {
        return $http.get('/Article/updateArticleOne?id='+id);
    };
});