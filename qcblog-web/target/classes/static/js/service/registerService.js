app.service('registerService',function($http){
    //注册
    this.insert=function(entity){
        return  $http.post('/insert',entity);
    }
    //修改密码
    this.updataPwd=function (entity) {
        return $http.post('/User/updatePwd',entity);
    }
    //验证码图片
    this.ValidateCode=function () {
        return $http.get('/getImgCode');
    }
    //检查验证码是否正确
    this.checkImgCode=function (code) {
        return $http.post('/checkImgCode',code)
    }
});