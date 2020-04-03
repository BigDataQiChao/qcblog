window.alert =alert;
function alert(e){
    $("body").append('<div id="msg"><div id="msg_top">温馨提醒<span class="msg_close">×</span></div><div id="msg_cont">'+e+'</div><button class="msg_close" id="msg_clear">确定</button></div>');
    $(".msg_close").click(function (){
        $("#msg").remove();
        window.location.reload();
    });
}