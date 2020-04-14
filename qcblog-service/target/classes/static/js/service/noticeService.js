app.service('noticeService',function($http){
    //获取客户端IP
    this.getIp = function () {
        return $http.get('/signinIp');
    };
    //遍历
    this.findNotices = function () {
        return $http.get("/Notice/findAll");
    };
    //增加
    this.add=function(entity){
        return  $http.post('/Notice/add',entity );
    };
    //分页
    this.findPage=function(page,rows){
        return $http.get('/Notice/findPage?page='+page+'&rows='+rows);
    };
    //分页查询
    this.search=function(page,rows,searchEntity){
        return $http.post('/Notice/search?page='+page+"&rows="+rows, searchEntity);
    };
    //修改
    this.update=function(entity){
        return  $http.post('/Notice/update',entity);
    };
    //删除
    this.dele=function(ids){
        return $http.get('/Notice/delete?ids='+ids);
    };
    //计数
    this.count=function(){
        return  $http.get('/Notice/count');
    };
    //发布
    this.upNotice = function (ntname) {
        return $http.get('/Notice/up?ntname='+ntname);
    };
    //撤回
    this.downNotice = function (ntname) {
        return $http.get('/Notice/down?ntname='+ntname);
    };
    //名称查询
    this.findNoticeOne=function(id){
        return $http.get('/Notice/findOne?id='+id);
    };
    //标记已读状态
    this.updateNoticeStatus=function (id) {
        return $http.get('/Notice/updateStatus?id='+id);
    }
    //统计未读消息
    this.countByStatus=function () {
        return $http.get('/Notice/countByStatus');
    }
});