app.service('talkService',function($http){
    //获取客户端IP
    this.getIp = function () {
        return $http.get('/signinIp');
    };
    //遍历
    this.findTalks = function () {
        return $http.get("/Talk/findAll");
    };
    //增加
    this.add=function(entity){
        return  $http.post('/Talk/add',entity );
    };
    //分页
    this.findPage=function(page,rows){
        return $http.get('/Talk/findPage?page='+page+'&rows='+rows);
    };
    //修改
    this.update=function(entity){
        return  $http.post('/Talk/update',entity);
    };
    //批量删除
    this.dele=function(ids){
        return $http.get('/Talk/delete?ids='+ids);
    };
    //单体删除
    this.deleOne=function(id){
        return $http.get('/Talk/deleteOne?id='+id);
    };
    //分页搜索
    this.search=function(page,rows,searchEntity){
        return $http.post('/Talk/search?page='+page+"&rows="+rows, searchEntity);
    };
    //计数
    this.count=function(){
        return  $http.get('/Talk/count');
    };
    //发布
    this.upTalk = function (tktitle) {
        return $http.get('/Talk/up?tktitle='+tktitle);
    };
    //撤回
    this.downTalk = function (tktitle) {
        return $http.get('/Talk/down?tktitle='+tktitle);
    };
    //名称查询
    this.findTalkOne=function(tktitle){
        return $http.get('/Talk/findOne?tktitle='+tktitle);
    }
});