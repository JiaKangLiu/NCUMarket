//1.登录功能
$("#login").click(function () {
    //禁用按钮，获取数据
    $("#myblock").removeClass("hidden");
    $("#bigBody").removeClass("jello");
    $("#login").addClass("disabled");
    var userKey = $("#userKey").val();
    var password = $("#loginpassword").val();
//     1.判断邮箱，手机格式对不对
    if (isUserKey(userKey)) {
//    2.如果正确的话提交
        $.post("/NCUAdmin/confirmLogin", {
            adminNum: userKey,
            password: password
        }, function (result) {
            if (result['success']) {
                console.log("登录成功" + result['message']);
                window.location.href = "/";
            } else {
                $("#myblock").addClass("hidden");
                $("#loginerror").html(result['message']);
                $("#loginerror").removeClass("hidden");
                $("#login").removeClass("disabled");
                $("#bigBody").addClass("jello");
            }
        })
    } else {
        //    如果格式不正确就提示
        $("#myblock").addClass("hidden");
        $("#bigBody").addClass("jello");
        $("#loginerror").removeClass("hidden");
    }


})

