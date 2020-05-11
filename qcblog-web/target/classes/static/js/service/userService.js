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
    //文章对应的作者信息
    this.findOuthor=function (id) {
        return $http.post('/User/findOuthor',id);
    }
    //检查是否关注
    this.checkIsAttention=function (id) {
        return $http.post('/User/isAttention',id);
    }
    //关注博主
    this.addAttention=function (id) {
        return $http.post('/User/addAttention',id);
    }
    //取消关注
    this.deleAttention=function (id) {
        return $http.post('/User/deleAttention',id);
    }
});