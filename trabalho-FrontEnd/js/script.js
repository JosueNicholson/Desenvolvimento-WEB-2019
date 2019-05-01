
$(document).ready(function () {
    $("#ver").click(function () {
        if ($(".hidden").css("display") == "none") {
            $(".hidden").css({"display": "inline-block"});
            $("#hidden-div").fadeIn();
            $("button").text("Ver menos");
        } else {
            $("#hidden-div").fadeOut();
            $(".hidden").fadeOut(); 
            $("button").text("Ver mais");
        }

    });
});
$(document).ready(function(){
    $('#telephone').mask('(00) 0 0000-0000');
});