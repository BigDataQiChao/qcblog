(function($){
    $.fn.sideSwitch = function(opts){
        var defaults = {
            contentWidth:'400px',
            contentHeight:'185px',
            btnWidth:'30px',
            btnHeight:'80px',
            initTop:'100px',//初始化离浏览器顶部的距离
            extra:'',//因页面布局需要额外向左移动的距离
            callback:''//菜单拉出后的回调函数
        }
        var option = $.extend(defaults,opts);
        this.each(function(){//这一行的this是指$选择器选择到的对象，是一个数组
            var _this = $(this);//拿到某一个div
            var btndiv = _this.find('.ss_btn');
            var btnTop = (parseInt(option.contentHeight)-parseInt(option.btnHeight))/2;
            btndiv.css({width:option.btnWidth,height:option.btnHeight,top:btnTop,position:"absolute",cursor:"pointer"});
            var contentdiv = _this.find('.ss_content');
            var contentLeft = parseInt(option.btnWidth)+parseInt(btndiv.css('borderLeftWidth'))+parseInt(btndiv.css('borderRightWidth'));
            contentdiv.css({width:option.contentWidth,height:option.contentHeight,position:"relative",left:contentLeft,top:"0px"});

            var boxInitLeft = parseInt(document.body.clientWidth)-parseInt(option.btnWidth)-parseInt(btndiv.css('borderLeftWidth'))-parseInt(btndiv.css('borderRightWidth'))-option.extra;
            var boxInitWidth = parseInt(option.btnWidth)+parseInt(btndiv.css('borderLeftWidth'))+parseInt(btndiv.css('borderRightWidth'));
            _this.css({width:boxInitWidth,overflow:"hidden",position:"absolute",zIndex:999});
            if(!option.initTop){option.initTop = (parseInt(document.body.clientHeight)-parseInt(_this.css('height'))-parseInt(_this.css("borderTopWidth"))-parseInt(contentdiv.css("borderTopWidth")))/2;}
            _this.css({left:boxInitLeft,top:option.initTop});
            var menuYloc = _this.offset().top; //当前窗口的相对偏移
            $(window).scroll(function (){
                var offsetTop = menuYloc + $(window).scrollTop() +"px";
                _this.animate({top : offsetTop },{ duration:600 , queue:false });
            });
            btndiv.click(
                function(){
                    if(parseInt(_this.css("width"))<parseInt($('.ss_content').css('width'))){
                        var boxNewWidth = parseInt($('.ss_content').css('width'))+parseInt($('.ss_content').css('borderLeftWidth'))+parseInt($('.ss_content').css('borderRightWidth'))+parseInt($('.ss_btn').css('width'))+parseInt($('.ss_btn').css('borderLeftWidth'))+parseInt($('.ss_btn').css('borderRightWidth'));

                        var boxNewLeft = parseInt(document.body.clientWidth)-boxNewWidth-option.extra;
                        _this.animate({left:boxNewLeft+'px',width:boxNewWidth+"px"},"slow");
                        /*option.callback();*/
                    }
                    else{
                        _this.animate({left:boxInitLeft,width:"30px"},"slow");
                    }

                }
            )
        });
    }
})(jQuery)