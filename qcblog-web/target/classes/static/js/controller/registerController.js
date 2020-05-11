app.controller('registerController', function ($scope, $controller, registerService) {
    $controller('baseController', {$scope: $scope});//继承
    //增加
    $scope.insert = function () {
        registerService.insert($scope.entity).success(
            function (response) {
                if (response.success) {
                    //注册成功跳转到登录页面
                    if (response.message == '恭喜您，注册成功！') {
                        alert(response.message);
                    } else if (response.message == '有内容项为空，请重新注册！') {
                        alert(response.message);
                    } else {
                        alert(response.message);
                    }
                }
                else {
                    alert(response.message);
                }
            }
        );
    };
    //修改密码
    $scope.updatePwd = function () {
        registerService.updataPwd($scope.entity).success(
            function (response) {
                if (response.message == '修改成功，请回到登录页！') {
                    alert(response.message);
                }else{
                    alert(response.message);
                }
            }
        )
    }
    //获取验证码图片
    $scope.ValidateCode = function () {
        registerService.ValidateCode().success(
            function (response) {
                $scope.imageCode = response.data;
            }
        )
    }
    $scope.checkImgCode = function () {
        var validateCode = document.getElementById("ImgCode").value;
        if (validateCode == "") {
            alert("请输入验证码！");
            return false;
        }
        registerService.checkImgCode(validateCode).success(
            function (response) {
                alert(response.message);
            }
        )
    }
});