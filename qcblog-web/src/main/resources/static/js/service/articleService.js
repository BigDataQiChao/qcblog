app.service('articleService',function($http){
    //访问量
    this.addNumber = function(){
            return $http.get('/number');
        };
    //通过name查询
    this.findOne = function (atname) {
        return $http.get('/Article/findOne?atname='+atname);
    };
    //通过name查询
    this.findName = function (atname) {
        return $http.get('/Article/findName?atname='+atname);
    };
    //遍历
    this.findArticles = function(){
        return $http.get('/Article/findAll');
    };
    //分页
    this.findPage = function(page,rows){
        return $http.get('/Article/findPage?page='+page +'&rows='+rows);
    };
    //分页查询
    this.search=function(page,rows,searchEntity){
        return $http.post('/Article/search?page='+page+"&rows="+rows, searchEntity);
    };
    //增加
    this.add=function(entity){
        return $http.post('/Article/add',entity);
    };
    //修改
    this.update=function(entity){
        return $http.post('/Article/update',entity);
    };
    //前一章
    this.getPre=function (atname){
        return $http.get('/Article/getPre?atname='+atname);
    };
    //后一章
    this.getNext=function (atname){
        return $http.get('/Article/getNext?atname='+atname);
    };
    //作者名称
    this.findNameByArticle=function () {
        return $http.get('/Article/findNames');
    };
    //点赞文章
    this.getLike = function (id) {
        return $http.post('/Article/getlike',id);
    };
    //点赞状态码
    this.findStatus = function () {
        return $http.get('/Article/findStatus');
    };
    //发表文章
    this.addToArticle = function(entity) {
        return $http.post('/Article/addToArticle',entity);
    };
    //通过ID查询
    this.findById = function (id) {
        return $http.get('/Article/findById?id='+id);
    };
    //文章类型
    this.findType = function () {
        return $http.get('/Article/findType');
    };
    //文章前置标签
    this.findAtPre = function () {
        return $http.get('/Article/findAtPre');
    };
    //文章后置标签
    this.findAtPos = function () {
        return $http.get('/Article/findAtPos')
    };
    //根据专题分类查询文章内容
    this.findSubList = function (subname) {
        return $http.post('/Subject/findSubList',subname);
    };
});