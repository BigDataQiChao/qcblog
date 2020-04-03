app.service('qcblogService', function ($http) {
    this.addNumber = function () {
        return $http.get('/number');
    };
    this.loginName = function () {
        return $http.get('/name');
    };
    this.listAll = function () {
        return $http.get('/Notice/listAll');
    }
    this.getIp = function () {
        return $http.get('/getIp');
    }
});