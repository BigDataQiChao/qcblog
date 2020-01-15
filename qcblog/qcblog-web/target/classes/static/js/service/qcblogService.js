app.service('qcblogService',function($http){
    this.addNumber = function(){
            return $http.get('/number');
        };
    this.loginName = function(){
        return $http.get('/name');
    };
});