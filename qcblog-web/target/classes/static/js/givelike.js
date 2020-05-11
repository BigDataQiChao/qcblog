$(document).ready(function () {
    $('body').on("click", '.heartAnimation', function () {
        var heartChange = $(this).attr("rel");
        $(this).css("background-position","");
        if (heartChange === 'like') {
            $(this).addClass("heartAnimation").attr("rel", "unlike");
        } else {
            $(this).removeClass("heartAnimation").attr("rel", "like");
            $(this).css("background-position", "left");
        }
    });
});

/*
function likeHeart(id) {
    alert(id)
}*/
