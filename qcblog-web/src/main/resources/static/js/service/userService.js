app.service('userService',function($http){
    //用户信息
    this.userInfo = function(){
        return $http.get('/User/signinInfo');
    };
    //通过ID查询
    this.findOne = function (id) {
        return $http.get('/User/findOne?id='+id);
    };
    //修改
    this.update=function(entity){
        return  $http.post('/User/update',entity);
    };
    //更换头像
    this.updateImage=function (entity) {
        return $http.post('/User/updateImage',entity);
    }
});