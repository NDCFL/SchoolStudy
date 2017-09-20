
var Captcha = {};
Captcha.createCaptcha = function ($ele,callback) {
    if (!$ele) {
        return;
    }


    getCaptchaInfo();
    initCaptchaEvent();
    if(callback){
        callback();
    }

    /*
     *  绑定事件
     */
    function initCaptchaEvent() {
        //bind captcha event
        $("body").delegate(".captcha_img", "click", function () {
            var btn = $(this);
            btn.attr("src", "");
            getCaptchaInfo();
        });
    }

    /*
     * 获取验证码图片的信息
     *
     */
    function getCaptchaInfo() {
        var random = Math.random();
        $ele.find(".captcha_img").css('pointer-events', 'none');
        $.ajax({
            url: '/1.0/captcha/secret',
            type: 'get',
            data: {_: random},
            dataType: "json"
        }).done(function (data, textStatus, jqXHR) {
            var info = jqXHR.getResponseHeader('X-LAS-SECRET');
            var img = new Image();
            img.src = "/1.0/captcha?secret=" + info;
            img.onload = function () {
                $ele.find(".captcha_img").attr("src", img.src).data("HEADER_SECRET", info);
            }
        }).fail(function () {
            var $captchaImg = $ele.find(".captcha_img"), $captchaErrorSrc = $captchaImg.attr('data-error-src');
            $captchaImg.attr("src", $captchaErrorSrc);
            // Logger.error(jsI18nData['get-captcha-error']);
        }).always(function () {
            $ele.find(".captcha-warpper").show().end().find(".default-text").hide();
            $ele.find(".captcha_img").css('pointer-events', 'auto');
        });
    }

    return {
        getCaptchaValue: function () {
            return $(".captcha_input", $ele).val();
        },
        getCaptchaHeaderSecret: function () {
            return $(".captcha_img", $ele).data("HEADER_SECRET");
        },
        refresh: function () {
            $(".captcha_img", $ele).click();
        }
    };
};


(function () {
    var pcinitflag = 0,mobileinitflag = 0,initPageflag = 0,loginCaptchaObj,regCaptchaObj,errorTimes = 0;
    function initRegCaptcha(){
    }
    function initCaptcha(){
        errorTimes = 4;
        var $captcha = $('.captcha', $("#login")).show().find('.captcha_input').removeAttr('disabled').val("").end();
        if (loginCaptchaObj) {
            loginCaptchaObj.refresh();
        } else {
            loginCaptchaObj = Captcha.createCaptcha($captcha);
        }
    }

    function checkUserStatus() {
        var token = $.cookie('sessionToken') || '';
        var apiKey = $.cookie('APIKey') || '';
        var appId = $.cookie('appId') || '';
        // var token = Storage.get('sessionToken') || '';

        if (token && token != '') {

            var keys = document.cookie.match(/[^ =;]+(?=\=)/g);
            if (keys) {
                for (var i = keys.length; i--;){
                    $.cookie(keys[i],"",{expires:0});
                }
            }

            $.cookie('sessionToken',token,{ expires: 365,path:'/',secure: true });
            $.cookie("APIKey",apiKey,{ expires: 365,path:'/',secure: true });
            $.cookie("appId",appId,{ expires: 365,path:'/',secure: true });

            var env;
            if(window.ENV == 'DEV'){
                env = 'dev';
            }else if(window.ENV == 'UAT'){
                env = 'uat';
            }else{
                env = '';
            }

            window.location.href = 'https://www'+env+'.leapcloud.cn/manage?sessionToken='+token+'&appId='+appId+'&APIKey='+apiKey+"&currentUrl="+document.URL;

            return 1;
        }else{
            return 0;
        }
    }

    function initPageValidate() {

        $.validator.addMethod("phonenum",function(value,element,params){
            if(value=="")
                return true;

            var value = $.trim(value);
            // var phoneValidate = /^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/.test(value);
            var mobileValidate = /^1[3|4|5|6|7|8|9][0-9]{1}[0-9]{8}$/.test(value);
            // if(!phoneValidate && !mobileValidate){
            if(!mobileValidate){
                return false;
            }
            return true;
        });


        $("#register").validate({
            rules: {
                regEmail:{
                    minlength: 6
                },
                name:{
                    required: true,
                },
                coname: {
                    required: true,
                },
                telephone2: {
                    required: true,
                    phonenum: "",
                },
                regPassword: {
                    required: true,
                    minlength: 8,
                },
                captcha:{
                    required: true,
                },
                telephone: {
                    required: true,
                    phonenum: "",
                },
                agree: {
                    required : true
                }
            },
            messages: {
                regEmail:{
                    required: "必填",
                    email: "Email格式不正确",
                    minlength: "至少6位"
                },
                regPassword: {
                    required: "必填",
                    minlength: "至少8位",
                },
                captcha:{
                    required: "必填",
                },
                name:{
                    required: "必填"
                },
                coname:{
                    required: "必填"
                },
                telephone2: {
                    required: "必填",
                    phonenum: "号码格式不正确"
                },
                telephone: {
                    required: "必填",
                    phonenum: "号码格式不正确"
                },
                agree: {
                    required: "请勾选协议"
                }
            },
            highlight: function(element) {
                $(element).closest('.input-wrapper').removeClass('success').addClass('error');
            },
            errorPlacement: function(error, element) {
                element.siblings('.error-promote').append(error);
            },
            success: function(element) {
                element.closest('.input-wrapper').removeClass('error').addClass('success');
            },
            onkeyup: function(element, event) {

                if (event.which === 13)
                    $("#register").submit();

                if (event.which === 9 && this.elementValue(element) === "") {
                    return;


                } else if (element.name in this.submitted || element === this.lastElement) {
                    this.element(element);
                }

                this.checkForm();

            },
            submitHandler: function(form) {
                postStepExcute();
            }
        });
    }
    $("#register [name=telephone2]").keyup(function(){
        $("#register .captchaBtn").css({
            "background-color":"#00cc33",
            "color":"#fff"
        })
    });
    function postStepExcute(){

        function postCheck(data){
            $(".postBtn").hide().nextAll(".error-promote").text("");
            $(".postBtn-loading").css("display","inline-block");

            $.ajax({
                url: "/1.0/account/apply",
                type: 'POST',
                dataType: 'json',
                data: JSON.stringify(data),
                contentType: 'application/json',
                success: function (user){
                    // $(".postBtn-loading").text("注册成功! 正在登录...").width("100%");
                    DataCollection.monitor("Signup",{
                        path:location.href,
                        phone:data.phone,
                        username:data.username
                    });
                    delete data.challenge;

                    localStorage.setItem("userPhone" , data.phone);

                    // console.log("这是用户注册的电话号码：" + localStorage.getItem("userPhone"));
                    // console.log(data.phone);
                    window.location.href = '/website/signupsuccess';
                    // setTimeout(function(){
                    //     $.ajax({
                    //         url: "/1.0/users/login",
                    //         type: 'POST',
                    //         dataType: 'json',
                    //         data: JSON.stringify(data),
                    //         contentType: 'application/json',
                    //         success: function (user){
                    //
                    //             Storage.set("userId",user.id);
                    //             Storage.set("email",user.email);
                    //
                    //             Storage.set("username",user.username);
                    //             Storage.set("orgType",user.orgType||'App');
                    //             DataCollection.saveAppInfo({
                    //                 //fix 数据分析错误，需要string类型
                    //                 orgUserId:user.id+"",
                    //                 maxwon_appId:user.appId
                    //             });
                    //             $.cookie("sessionToken",user.sessionToken,{ expires: 365,path:'/',secure: true });
                    //             $.cookie("APIKey",user.apiKey,{ expires: 365,path:'/',secure: true });
                    //             $.cookie("appId",user.appId,{ expires: 365,path:'/',secure: true });
                    //             //保存 userId,在统计时发送服务器
                    //             localStorage.setItem('orgUserId',user.id);
                    //             if(user.timezone){
                    //                 Storage.set("timezone",user.timezone);
                    //             }
                    //
                    //             var lastUrl = Storage.get("lastUrl");
                    //             if (lastUrl) {
                    //                 lastUrl = lastUrl.url || "";
                    //             }
                    //
                    //             window.location.href = 'http://'+ window.location.host + '/website/applyaccount';
                    //         },
                    //         error: function(response, textStatus, errorThrown){
                    //             alert("自动登陆出错，请手动登陆")
                    //             window.location.href = '/website/manageLogin';
                    //             // console.log(XMLHttp  Request,textStatus,errorThrown)
                    //         }
                    //     });
                    // },200);

                },
                error: function(response, textStatus, errorThrown){
                    var resp;

                    try{
                        resp = JSON.parse( response.responseText || "{}" );
                    }catch(e){
                        resp = {
                            errorMessage:response.responseText
                        };
                    }

                    switch(resp.errorCode){
                        case 203:$(".postBtn").nextAll(".error-promote").text("邮箱已经被注册");initRegCaptcha();break;
                        case 241:$(".postBtn").nextAll(".error-promote").text("验证码错误");initRegCaptcha();break;
                        case 240:$(".postBtn").nextAll(".error-promote").text("手机号已经被注册");break;
                        case 502:$(".loginBtn").nextAll(".error-promote").text("服务器错误");break;
                        case 1:$(".postBtn").nextAll(".error-promote").text("服务器错误");break;
                        default:$(".postBtn").nextAll(".error-promote").text(resp.errorMessage||"未知错误");initRegCaptcha();break;
                    }
                    $(".postBtn-loading").hide();
                    $(".postBtn").css("display","inline-block");
                    // console.log(XMLHttpRequest,textStatus,errorThrown)
                }
            })
        }

        var utmstrings = {};
        var keys = document.cookie.match(/[^ =;]+(?=\=)/g);
        if (keys) {
            for (var i = keys.length; i--;){

                if(keys[i] == "utm_source" ){
                    utmstrings.utm = $.cookie(keys[i]);
                }
                if(keys[i] == "utm_campaign" ){
                    utmstrings.utmCampaign = $.cookie(keys[i]);
                }
                if(keys[i] == "utm_medium" ){
                    utmstrings.utmMedium = $.cookie(keys[i]);
                }
                if(keys[i] == "utm_term" ){
                    utmstrings.utmTerm = $.cookie(keys[i]);
                }
                if(keys[i] == "utm_content" ){
                    utmstrings.utmContent = $.cookie(keys[i]);
                }
                if(keys[i] == "utm_term_keyword" ){
                    utmstrings.utmTermKeyword = $.cookie(keys[i]);
                }
            }
        }

        var types = [];

        var data = {
            // username: $("#register [name=regEmail]").val().split('@')[0],
            name: "user" + $("#register [name=telephone2]").val(),
            // email: $("#register [name=regEmail]").val(),
            // password: $("#register [name=regPassword]").val(),
            phone: $("#register [name=telephone2]").val(),
            // captcha : captcha,
            smsCode : $("#register [name=captcha]").val(),
            companyName : $("#register [name=company]").val(),
            regClientPlatform : /iphone|ipad|android|Windows Phone/i.test(navigator.userAgent) ? 'mobile' : 'desktop'
            // userType: "2",

            // utmTermKeyword:utmstrings.utmTermKeyword
        };


        //如果utm存在, 再传入推广信息
        if(utmstrings.utm){
            data.utm = utmstrings.utm;
            data.utmTerm = utmstrings.utmTerm;
            data.utmContent = utmstrings.utmContent;
            data.utmCampaign = utmstrings.utmCampaign;
            data.utmMedium = utmstrings.utmMedium;

            data.landingPage = $.cookie('landingPage');
            data.referer = document.referrer.substr(0, 255);
            data.clientPlatform = data.regClientPlatform;
        }

        postCheck(data);
    }

    function initPage(){
        if(initPageflag)
            return ;

        var rememberUser = Storage.get('rememberUser');
        var loginId = Storage.get('email');

        if (!!+rememberUser) {
            $("#remember").addClass('checked').removeClass("unchecked");
            $("[name=email]").val(loginId);
        } else {
            $("#remember").removeClass('checked').addClass('unchecked');
        }
        initPageValidate();
        initPageflag = 1;
    }

    if(checkUserStatus()==1){
        return ;
    }

    function initPC(){
        if(pcinitflag)
            return ;

        var $bigImage = $(".leftBigImage > img");
        initPage();

        $("body").css("visibility","visible");

        pcinitflag = 1;
    }

    function initMobile(){
        if(mobileinitflag)
            return ;

        initPage();
        $("body").css("visibility","visible");
        mobileinitflag = 1;
    }

    function sendMessage(){

        if( $("#register").validate().element($("[name=telephone2]")) ){
            var data = {
                phone:$("#register [name=telephone2]").val()
            },count = 60;

            $("#register .captchaBtn").hide().next().text("正在发送...").css("display","inline-block");

            $.ajax({
                url: "/1.0/sms/requestSmsCode",
                type: 'POST',
                dataType: 'json',
                data: JSON.stringify(data),
                contentType: 'application/json',
                success: function (data){
                    if(data && data.success){
                        var countInterval = setInterval(function(){
                            if(count < 0 ){
                                $("#register .captchaBtn").css("display","inline-block").next().hide();
                                clearInterval(countInterval);
                            }else{
                                $("#register .captchaBtn-loading").text(count--).show();
                            }
                        },1000)
                    }else{
                        switch(data.errorCode){
                            case 503:$(".postBtn").nextAll(".error-promote").text("发送过于频繁，请稍后");break;
                            default:$(".postBtn").nextAll(".error-promote").text(data.errorMessage||"未知错误");break;
                        }
                        $("#register .captchaBtn").css("display","inline-block").next().hide();
                    }
                },
                error: function(response, textStatus, errorThrown){
                    $("#register .captchaBtn").show().next().hide();

                    var resp;
                    try{
                        resp = JSON.parse( response.responseText || "{}" );
                    }catch(e){
                        resp = {
                            errorMessage:response.responseText
                        };
                    }

                    switch(resp.errorCode){
                        default:$(".postBtn").nextAll(".error-promote").text(resp.errorMessage||"未知错误");break;
                    }
                }
            })
        }
    }

    $(function () {
        'use strict';

        $(".checkbox-inline").click(function(e){
            $(e.currentTarget).find(".icon").toggleClass("checked unchecked");
        });

        $(".loginBtn").click(function(){
            $("#login").submit();
            DataCollection.monitor("Login",{
                path:location.href
            });
        });

        $(".postBtn").click(function(){
            $("#register").submit();
        });

        $(".captchaBtn").click(function(){
            sendMessage();
        })

        initRegCaptcha();
        $(window).resize(function(){
            if($(this).width() < windowbreakpoint ){
                initMobile();
                $("#register").css("display","inline-block");
            }else{
                initPC();
            }
        })

        $(window).resize();
    });
})();