app.service('cmsService',function($http){
    //查询所有爬取文章数据资源
    this.findCmsAll=function(){
        return $http.get('/Cms/findCmsAll');
    };
    //分页搜索
    this.search=function(page,rows,searchEntity){
        return $http.post('/Cms/search?page='+page+"&rows="+rows, searchEntity);
    };
    //分页
    this.findPage=function(page,rows){
        return $http.get('/Cms/findPage?page='+page+'&rows='+rows);
    };
    //分页
    this.dele=function(ids){
        return $http.get('/Cms/delete?ids='+ids);
    };
    //分页
    this.findCmsOne=function(id){
        return $http.get('/Cms/findCmsOne?id='+id);
    };
    this.checkCms=function(id){
        return $http.get('/Cms/checkCms?id='+id);
    };
    this.checkDownCms=function(id){
        return $http.get('/Cms/checkDownCms?id='+id);
    };
});