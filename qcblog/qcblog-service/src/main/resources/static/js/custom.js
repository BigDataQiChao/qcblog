/*====================================
免费供个人及商业用途
作者:赵起超
许可:开放源码- MIT
请访问http://opensource.org/licenses/MIT获取更多完整的许可条款。
======================================*/
(function ($) {
    "use strict";
    var mainApp = {

        main_fun: function () {
           
            var count = new countUp("error-link", 10, 404, 0, 2); //根据需要将404更改为错误值

            window.onload = function () {
                        count.start();
            }

            /*====================================
            在这里编写脚本
            ======================================*/
        },

        initialization: function () {
            mainApp.main_fun();

        }

    }
    //初始化条件 ///

    $(document).ready(function () {
        mainApp.main_fun();
    });

}(jQuery));
