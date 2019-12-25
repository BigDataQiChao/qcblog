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
        return  $http.post('/Article/add',entity);
    };
    //修改
    this.update=function(entity){
        return  $http.post('/Article/update',entity);
    };
    //前一章
    this.getPre=function (atname){
        return $http.get('/Article/getPre?atname='+atname);
    };
    //后一章
    this.getNext=function (atname){
        return $http.get('/Article/getNext?atname='+atname);
    };
});