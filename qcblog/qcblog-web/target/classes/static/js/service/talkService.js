app.service('talkService',function($http){
    //访问量
    this.addNumber = function(){
        return $http.get('/number');
    };
    //遍历
    this.findTalks = function(){
        return $http.get('/Talk/findAll');
    };
    //分页
    this.findPage = function(page,rows){
        return $http.get('/Talk/findPage?page='+page +'&rows='+rows);
    };
    //分页查询
    this.search=function(page,rows,searchEntity){
        return $http.post('/Talk/search?page='+page+"&rows="+rows, searchEntity);
    };
    //增加
    this.add = function(entity){
        return $http.post('/Talk/add',entity);
    };
    //修改
    this.update = function(entity){
        return $http.post('/Talk/update',entity);
    };
});