app.service('flinkService',function($http){
    this.findFlinks = function(){
        return $http.get('/Flink/findAll');
    };
});