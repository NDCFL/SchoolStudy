$(document).ready(function() {
    var app_key = "erp";
    var lock = true,
        withCode=false,
        withLock = false;
    var countMax = 3;
    var mode = false,
        isValid = false;

    var form_register = $('#form-register');
    var alter_register = $('#alter-register');
    //#alter-login
    var alter_login = $('#alter');
    var btn_register = $('#register-submit');
    var slider = $("#slider-container");
    //console.log("%c我是登录首页广告\r\n我是第二行", "display:block;font-size:20px;color:#456783;text-align:'center'");

    //获取验证码路径
    var captchaUrl = "/service/" + app_key + "/send/captcha";
    //注册提交路径
    var signUrl = "/service/" + app_key + "/sign";
    //登录地址
    $('.valtext').hide();
    $('#form-register').attr("action", signUrl);
    actionInit();

    function validate() {
        var pass = false;
        if (typeof isValid == 'undefined') isValid = false;
        pass = isValid = form_register.find('input[name=captcha]').val() && form_register.find('input[name=mobile]').val();
        var mobile = form_register.find('input[name=mobile]').val();
        if (!mobile) {
            $('.val-mobile-empty').show();
            $('.val-mobile-reg').hide();
        } else {
            $('.val-mobile-empty').hide();
            if (!mobile.match(/^1[3|4|5|7|8][0-9]\d{8}$/)) {
                $('.val-mobile-reg').show();
            } else {
                $('.val-mobile-reg').hide();
            }
        }
        if (!form_register.find('input[name=captcha]').val() && withCode) {
            $('.val-captcha-empty').show();
        } else {
            $('.val-captcha-empty').hide();
        }

        pass = isValid
        pass = safeValidate() ? pass : false;
        //pass = (withCode && code) ? pass : false;
        //pass = code ? pass : false;
        if (pass) {
            btn_register.removeAttr("disabled");
        } else {
            btn_register.attr("disabled", "disabled");
        }

        return pass;
    }

    function safeValidate() {
        if (withLock) {
            return lock;
        } else {
            return true;
        }
    }

    function safeCheck() {
        var count = parseInt($.cookie("count")) || 0;
        $.cookie("count", count + 1, { expires: 7, secure: true });
        if (count > countMax && !withLock) {
            lock = false;
            withLock = true;
            slider.show();
            lockInit();
            lockReset();
            return false;
        }
        count++;
        return true;
    }

    function safeLock() {
        return withLock;
    }

    function browserCheck() {
        return true;
    }

    function actionInit() {
        browserCheck();
        statusCheck();
        $('.transform').on("click", function() {
            if (safeLock) {
                //lockReset();
            }
            if (mode) {
                form_login.hide();
                form_register.show();
                $(".panel-heading").text("用户注册");
            } else {
                form_login.show();
                form_register.hide();
                $(".panel-heading").text("用户登录");
            }
            mode = !mode;
        });
        $('input').on("change keyup", function(e) {
            alter_register.hide();
            validate();
        });
        $('input').on("keyup", function(e) {
            if (mode) {
                if (e.keyCode == 13) {
                    isSubmit = true;
                    $('#form-login').trigger('submit');
                }
            }
        });

        //点击获取验证码触发
        $("#btn-code").on("click", function() {
            var $this = $(this);
            withCode = true;
            $(this).disable();
            $('#code').removeAttr("readonly");
            link(captchaUrl, { "mobile": $("#tel").val() }, callback, {
                done: done
            });
            //重新获取验证码倒计时
            function done() {
                $this.enable().text("重新获取");
            }

            function callback(res) {
                $this.disable().text("重新获取(60)");
                $('#code').removeAttr("readonly");
                validate();
                var time = 60;
                var timer = setInterval(function() {
                    $this.text("重新获取(" + time-- + ")");
                    if (time <= 0) {
                        clearInterval(timer);
                        $this.enable().text("重新获取");
                    }
                }, 1000);
            }
        });

        var isSubmit = false;
        //点击提交切换提交标记，防止触发默认提交事件重复提交
        btn_register.on("click", function() {
            isSubmit = true;
        });
        //注册提交触发
        $("#form-register").on("submit", function(e) {
            if (!validate() || !isSubmit || !safeCheck()) {
                e.preventDefault();
                return;
            }
            var mobile = $.trim($(this).find("input[name='mobile']").val());
            var captcha = $.trim($(this).find("input[name='captcha']").val());
            $(this).find("input[name='password']").val(encrypt(mobile, captcha));
        });
    }

    function statusCheck() {
        if ($("#sign_error").length >= 1 && form_register.length >= 1) {
            form_login.hide();
            form_register.show();
            $('#code').removeAttr("readonly");
            btn_register.enable();
            $(".panel-heading").text("用户注册");
            mode = false;
        }
    }

    function lockInit() {
        slidebar_width = $('#slider-bar').outerWidth();
        handle_width = $('#slider-bar .handle').outerWidth();
        $('#slider-bar').scrollbar({
            onDrag: function(x) {
                if ((x + handle_width) >= (slidebar_width - 5)) {
                    return false;
                }
                btn_register.attr("disabled", "disabled");
            },
            onDrop: function(x) {
                if ((x + handle_width) < (slidebar_width - 5)) {
                    $('.handle').animate({ 'left': 0 }, 200);
                } else {
                    $('#slider-bar').css('background', '#F2F2F2').find('span').css('color', '#1ab394').html('解锁成功！');
                    lock = true;
                    $('.handle').attr("disabled", "disabled");
                    btn_register.removeAttr('disabled');
                    form_login.find("input").trigger('change');

                }
            }
        });
    }

    function lockReset() {
        lock = false;
        $('.handle').removeAttr('disabled').removeAttr('style');
        $('#slider-bar').removeAttr('style').find('span').removeAttr('style').html('请拖动解锁');
        btn_register.attr("disabled", "disabled");
    }


    function showAlert(target, text) {}

    function addParam(target, name, value) {
        var h = "<input type='hidden' name='" + name + "' value='" + value + "' >";　
        target.append(h);
    }

    function GetRequest() {
        var url = location.search;
        var theRequest = new Object();
        if (url.indexOf("?") != -1) {
            var str = url.substr(1);
            strs = str.split("&");
            for (var i = 0; i < strs.length; i++) {
                theRequest[strs[i].split("=")[0]] = (strs[i].split("=")[1]);
            }
        }
        return theRequest;
    }

});

var encrypt = function(user, pwd) {
    return hex_hmac_md5(user, pwd);
}
var link = function(url, data, callback, setting) {
    if (url && url[0] && url[0] != '/') url = "/" + url;
    setting = setting || {};
    data = data || {};
    $.ajax({
        url: url,
        data: JSON.stringify(data),
        method: "post",
        type: "json",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        beforeSend: function(xhr) {
            //设置自定义请求头
            //xhr.setRequestHeader("name", "value");
        },
        success: function(res) {
            var isSuccess = false;
            if (setting.done) setting.done();
            if (res.data && res.data.error) {
                if (!setting.mute) {
                    swal({
                        title: "操作失败",
                        type: "warning",
                        text: res.data.error,
                        confirmButtonText: "确定"
                    }, function() {
                        if (setting.error && setting.errorAfterAlert) setting.error(res);
                    });
                }
            } else if (res.buz_error_msg) {
                if (!setting.mute) {
                    swal({
                        title: "操作失败",
                        type: "warning",
                        text: res.buz_error_msg,
                        confirmButtonText: "确定"
                    }, function() {
                        if (setting.error && setting.errorAfterAlert) setting.error(res);
                    });
                }
            } else if (res.status == 0) {
                if (!setting.mute) {
                    var msg = "系统错误";
                    msg = res.tech_error_msg || msg;
                    swal({
                        title: "操作失败",
                        type: "warning",
                        text: msg,
                        confirmButtonText: "确定"
                    }, function() {
                        if (setting.error && setting.errorAfterAlert) setting.error(res);
                    });
                }
            } else {
                isSuccess = true;
                callback(res.data);
            }
        },
        error:function(res){
            alert('网络访问错误！');
        }
    });
}

var swal = function(data) {
    alert(data.text);
}

var hexcase = 0; /* hex output format. 0 - lowercase; 1 - uppercase        */
var b64pad = ""; /* base-64 pad character. "=" for strict RFC compliance   */

/*
 * These are the functions you'll usually want to call
 * They take string arguments and return either hex or base-64 encoded strings
 */
function hex_md5(s) {
    return rstr2hex(rstr_md5(str2rstr_utf8(s)));
}

function b64_md5(s) {
    return rstr2b64(rstr_md5(str2rstr_utf8(s)));
}

function any_md5(s, e) {
    return rstr2any(rstr_md5(str2rstr_utf8(s)), e);
}

function hex_hmac_md5(k, d) {
    return rstr2hex(rstr_hmac_md5(str2rstr_utf8(k), str2rstr_utf8(d)));
}

function b64_hmac_md5(k, d) {
    return rstr2b64(rstr_hmac_md5(str2rstr_utf8(k), str2rstr_utf8(d)));
}

function any_hmac_md5(k, d, e) {
    return rstr2any(rstr_hmac_md5(str2rstr_utf8(k), str2rstr_utf8(d)), e);
}

/*
 * Perform a simple self-test to see if the VM is working
 */
function md5_vm_test() {
    return hex_md5("abc").toLowerCase() == "900150983cd24fb0d6963f7d28e17f72";
}

/*
 * Calculate the MD5 of a raw string
 */
function rstr_md5(s) {
    return binl2rstr(binl_md5(rstr2binl(s), s.length * 8));
}

/*
 * Calculate the HMAC-MD5, of a key and some data (raw strings)
 */
function rstr_hmac_md5(key, data) {
    var bkey = rstr2binl(key);
    if (bkey.length > 16) bkey = binl_md5(bkey, key.length * 8);

    var ipad = Array(16),
        opad = Array(16);
    for (var i = 0; i < 16; i++) {
        ipad[i] = bkey[i] ^ 0x36363636;
        opad[i] = bkey[i] ^ 0x5C5C5C5C;
    }

    var hash = binl_md5(ipad.concat(rstr2binl(data)), 512 + data.length * 8);
    return binl2rstr(binl_md5(opad.concat(hash), 512 + 128));
}

/*
 * Convert a raw string to a hex string
 */
function rstr2hex(input) {
    try { hexcase } catch (e) { hexcase = 0; }
    var hex_tab = hexcase ? "0123456789ABCDEF" : "0123456789abcdef";
    var output = "";
    var x;
    for (var i = 0; i < input.length; i++) {
        x = input.charCodeAt(i);
        output += hex_tab.charAt((x >>> 4) & 0x0F) + hex_tab.charAt(x & 0x0F);
    }
    return output;
}

/*
 * Convert a raw string to a base-64 string
 */
function rstr2b64(input) {
    try { b64pad } catch (e) { b64pad = ''; }
    var tab = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    var output = "";
    var len = input.length;
    for (var i = 0; i < len; i += 3) {
        var triplet = (input.charCodeAt(i) << 16) | (i + 1 < len ? input.charCodeAt(i + 1) << 8 : 0) | (i + 2 < len ? input.charCodeAt(i + 2) : 0);
        for (var j = 0; j < 4; j++) {
            if (i * 8 + j * 6 > input.length * 8) output += b64pad;
            else output += tab.charAt((triplet >>> 6 * (3 - j)) & 0x3F);
        }
    }
    return output;
}

/*
 * Convert a raw string to an arbitrary string encoding
 */
function rstr2any(input, encoding) {
    var divisor = encoding.length;
    var i, j, q, x, quotient;

    /* Convert to an array of 16-bit big-endian values, forming the dividend */
    var dividend = Array(Math.ceil(input.length / 2));
    for (i = 0; i < dividend.length; i++) {
        dividend[i] = (input.charCodeAt(i * 2) << 8) | input.charCodeAt(i * 2 + 1);
    }

    /*
     * Repeatedly perform a long division. The binary array forms the dividend,
     * the length of the encoding is the divisor. Once computed, the quotient
     * forms the dividend for the next step. All remainders are stored for later
     * use.
     */
    var full_length = Math.ceil(input.length * 8 /
        (Math.log(encoding.length) / Math.log(2)));
    var remainders = Array(full_length);
    for (j = 0; j < full_length; j++) {
        quotient = Array();
        x = 0;
        for (i = 0; i < dividend.length; i++) {
            x = (x << 16) + dividend[i];
            q = Math.floor(x / divisor);
            x -= q * divisor;
            if (quotient.length > 0 || q > 0)
                quotient[quotient.length] = q;
        }
        remainders[j] = x;
        dividend = quotient;
    }

    /* Convert the remainders to the output string */
    var output = "";
    for (i = remainders.length - 1; i >= 0; i--)
        output += encoding.charAt(remainders[i]);

    return output;
}

/*
 * Encode a string as utf-8.
 * For efficiency, this assumes the input is valid utf-16.
 */
function str2rstr_utf8(input) {
    var output = "";
    var i = -1;
    var x, y;

    while (++i < input.length) {
        /* Decode utf-16 surrogate pairs */
        x = input.charCodeAt(i);
        y = i + 1 < input.length ? input.charCodeAt(i + 1) : 0;
        if (0xD800 <= x && x <= 0xDBFF && 0xDC00 <= y && y <= 0xDFFF) {
            x = 0x10000 + ((x & 0x03FF) << 10) + (y & 0x03FF);
            i++;
        }

        /* Encode output as utf-8 */
        if (x <= 0x7F)
            output += String.fromCharCode(x);
        else if (x <= 0x7FF)
            output += String.fromCharCode(0xC0 | ((x >>> 6) & 0x1F),
                0x80 | (x & 0x3F));
        else if (x <= 0xFFFF)
            output += String.fromCharCode(0xE0 | ((x >>> 12) & 0x0F),
                0x80 | ((x >>> 6) & 0x3F),
                0x80 | (x & 0x3F));
        else if (x <= 0x1FFFFF)
            output += String.fromCharCode(0xF0 | ((x >>> 18) & 0x07),
                0x80 | ((x >>> 12) & 0x3F),
                0x80 | ((x >>> 6) & 0x3F),
                0x80 | (x & 0x3F));
    }
    return output;
}

/*
 * Encode a string as utf-16
 */
function str2rstr_utf16le(input) {
    var output = "";
    for (var i = 0; i < input.length; i++)
        output += String.fromCharCode(input.charCodeAt(i) & 0xFF,
            (input.charCodeAt(i) >>> 8) & 0xFF);
    return output;
}

function str2rstr_utf16be(input) {
    var output = "";
    for (var i = 0; i < input.length; i++)
        output += String.fromCharCode((input.charCodeAt(i) >>> 8) & 0xFF,
            input.charCodeAt(i) & 0xFF);
    return output;
}

/*
 * Convert a raw string to an array of little-endian words
 * Characters >255 have their high-byte silently ignored.
 */
function rstr2binl(input) {
    var output = Array(input.length >> 2);
    for (var i = 0; i < output.length; i++)
        output[i] = 0;
    for (var i = 0; i < input.length * 8; i += 8)
        output[i >> 5] |= (input.charCodeAt(i / 8) & 0xFF) << (i % 32);
    return output;
}

/*
 * Convert an array of little-endian words to a string
 */
function binl2rstr(input) {
    var output = "";
    for (var i = 0; i < input.length * 32; i += 8)
        output += String.fromCharCode((input[i >> 5] >>> (i % 32)) & 0xFF);
    return output;
}

/*
 * Calculate the MD5 of an array of little-endian words, and a bit length.
 */
function binl_md5(x, len) {
    /* append padding */
    x[len >> 5] |= 0x80 << ((len) % 32);
    x[(((len + 64) >>> 9) << 4) + 14] = len;

    var a = 1732584193;
    var b = -271733879;
    var c = -1732584194;
    var d = 271733878;

    for (var i = 0; i < x.length; i += 16) {
        var olda = a;
        var oldb = b;
        var oldc = c;
        var oldd = d;

        a = md5_ff(a, b, c, d, x[i + 0], 7, -680876936);
        d = md5_ff(d, a, b, c, x[i + 1], 12, -389564586);
        c = md5_ff(c, d, a, b, x[i + 2], 17, 606105819);
        b = md5_ff(b, c, d, a, x[i + 3], 22, -1044525330);
        a = md5_ff(a, b, c, d, x[i + 4], 7, -176418897);
        d = md5_ff(d, a, b, c, x[i + 5], 12, 1200080426);
        c = md5_ff(c, d, a, b, x[i + 6], 17, -1473231341);
        b = md5_ff(b, c, d, a, x[i + 7], 22, -45705983);
        a = md5_ff(a, b, c, d, x[i + 8], 7, 1770035416);
        d = md5_ff(d, a, b, c, x[i + 9], 12, -1958414417);
        c = md5_ff(c, d, a, b, x[i + 10], 17, -42063);
        b = md5_ff(b, c, d, a, x[i + 11], 22, -1990404162);
        a = md5_ff(a, b, c, d, x[i + 12], 7, 1804603682);
        d = md5_ff(d, a, b, c, x[i + 13], 12, -40341101);
        c = md5_ff(c, d, a, b, x[i + 14], 17, -1502002290);
        b = md5_ff(b, c, d, a, x[i + 15], 22, 1236535329);

        a = md5_gg(a, b, c, d, x[i + 1], 5, -165796510);
        d = md5_gg(d, a, b, c, x[i + 6], 9, -1069501632);
        c = md5_gg(c, d, a, b, x[i + 11], 14, 643717713);
        b = md5_gg(b, c, d, a, x[i + 0], 20, -373897302);
        a = md5_gg(a, b, c, d, x[i + 5], 5, -701558691);
        d = md5_gg(d, a, b, c, x[i + 10], 9, 38016083);
        c = md5_gg(c, d, a, b, x[i + 15], 14, -660478335);
        b = md5_gg(b, c, d, a, x[i + 4], 20, -405537848);
        a = md5_gg(a, b, c, d, x[i + 9], 5, 568446438);
        d = md5_gg(d, a, b, c, x[i + 14], 9, -1019803690);
        c = md5_gg(c, d, a, b, x[i + 3], 14, -187363961);
        b = md5_gg(b, c, d, a, x[i + 8], 20, 1163531501);
        a = md5_gg(a, b, c, d, x[i + 13], 5, -1444681467);
        d = md5_gg(d, a, b, c, x[i + 2], 9, -51403784);
        c = md5_gg(c, d, a, b, x[i + 7], 14, 1735328473);
        b = md5_gg(b, c, d, a, x[i + 12], 20, -1926607734);

        a = md5_hh(a, b, c, d, x[i + 5], 4, -378558);
        d = md5_hh(d, a, b, c, x[i + 8], 11, -2022574463);
        c = md5_hh(c, d, a, b, x[i + 11], 16, 1839030562);
        b = md5_hh(b, c, d, a, x[i + 14], 23, -35309556);
        a = md5_hh(a, b, c, d, x[i + 1], 4, -1530992060);
        d = md5_hh(d, a, b, c, x[i + 4], 11, 1272893353);
        c = md5_hh(c, d, a, b, x[i + 7], 16, -155497632);
        b = md5_hh(b, c, d, a, x[i + 10], 23, -1094730640);
        a = md5_hh(a, b, c, d, x[i + 13], 4, 681279174);
        d = md5_hh(d, a, b, c, x[i + 0], 11, -358537222);
        c = md5_hh(c, d, a, b, x[i + 3], 16, -722521979);
        b = md5_hh(b, c, d, a, x[i + 6], 23, 76029189);
        a = md5_hh(a, b, c, d, x[i + 9], 4, -640364487);
        d = md5_hh(d, a, b, c, x[i + 12], 11, -421815835);
        c = md5_hh(c, d, a, b, x[i + 15], 16, 530742520);
        b = md5_hh(b, c, d, a, x[i + 2], 23, -995338651);

        a = md5_ii(a, b, c, d, x[i + 0], 6, -198630844);
        d = md5_ii(d, a, b, c, x[i + 7], 10, 1126891415);
        c = md5_ii(c, d, a, b, x[i + 14], 15, -1416354905);
        b = md5_ii(b, c, d, a, x[i + 5], 21, -57434055);
        a = md5_ii(a, b, c, d, x[i + 12], 6, 1700485571);
        d = md5_ii(d, a, b, c, x[i + 3], 10, -1894986606);
        c = md5_ii(c, d, a, b, x[i + 10], 15, -1051523);
        b = md5_ii(b, c, d, a, x[i + 1], 21, -2054922799);
        a = md5_ii(a, b, c, d, x[i + 8], 6, 1873313359);
        d = md5_ii(d, a, b, c, x[i + 15], 10, -30611744);
        c = md5_ii(c, d, a, b, x[i + 6], 15, -1560198380);
        b = md5_ii(b, c, d, a, x[i + 13], 21, 1309151649);
        a = md5_ii(a, b, c, d, x[i + 4], 6, -145523070);
        d = md5_ii(d, a, b, c, x[i + 11], 10, -1120210379);
        c = md5_ii(c, d, a, b, x[i + 2], 15, 718787259);
        b = md5_ii(b, c, d, a, x[i + 9], 21, -343485551);

        a = safe_add(a, olda);
        b = safe_add(b, oldb);
        c = safe_add(c, oldc);
        d = safe_add(d, oldd);
    }
    return Array(a, b, c, d);
}

/*
 * These functions implement the four basic operations the algorithm uses.
 */
function md5_cmn(q, a, b, x, s, t) {
    return safe_add(bit_rol(safe_add(safe_add(a, q), safe_add(x, t)), s), b);
}

function md5_ff(a, b, c, d, x, s, t) {
    return md5_cmn((b & c) | ((~b) & d), a, b, x, s, t);
}

function md5_gg(a, b, c, d, x, s, t) {
    return md5_cmn((b & d) | (c & (~d)), a, b, x, s, t);
}

function md5_hh(a, b, c, d, x, s, t) {
    return md5_cmn(b ^ c ^ d, a, b, x, s, t);
}

function md5_ii(a, b, c, d, x, s, t) {
    return md5_cmn(c ^ (b | (~d)), a, b, x, s, t);
}

/*
 * Add integers, wrapping at 2^32. This uses 16-bit operations internally
 * to work around bugs in some JS interpreters.
 */
function safe_add(x, y) {
    var lsw = (x & 0xFFFF) + (y & 0xFFFF);
    var msw = (x >> 16) + (y >> 16) + (lsw >> 16);
    return (msw << 16) | (lsw & 0xFFFF);
}

/*
 * Bitwise rotate a 32-bit number to the left.
 */
function bit_rol(num, cnt) {
    return (num << cnt) | (num >>> (32 - cnt));
}

$.fn.scrollbar = function(options) {
    var defaults = {
        onDrag: function() {
            return true;
        },
        onDrop: function() {},
        handle: '.handle'
    };
    var o = $.extend({}, defaults, options);
    return this.each(function() {

        var $this = $(this);
        var scrollbar = $this.find('.handle');
        var scrollbar_width = scrollbar.outerWidth(true);
        var viewport_width = $this.parent().width();
        var scrollbar_moving_spaceX = viewport_width - scrollbar_width - 2;

        scrollbar.mousedown(function(e) {
            e.preventDefault();
            var x = get_scrollbar_Xpos();
            var lastMouseX = e.pageX;
            var minMouseX = e.pageX - x;
            var maxMouseX = minMouseX + scrollbar_moving_spaceX;

            $(document).on('mousemove', function(e) {
                var ex = e.pageX;
                x = get_scrollbar_Xpos();
                ex = Math.max(ex, minMouseX);
                ex = Math.min(ex, maxMouseX);
                var nx = x + (ex - lastMouseX);
                set_scrollbar_Xpos(nx);
                lastMouseX = ex;
                if (o.onDrag.call(this, x) === false) $(document).unbind('mousemove');
            });

            $(document).on('mouseup', function(e) {
                $(document).unbind('mousemove');
                $(document).unbind('mouseup');
                x = get_scrollbar_Xpos();
                o.onDrop.call(this, x);
            });
        });
        scrollbar.on('touchstart', function(e) {
            e.preventDefault();
            var x = get_scrollbar_Xpos();
            var lastMouseX = e.originalEvent.touches[0].pageX;
            var minMouseX = e.originalEvent.touches[0].pageX - x;
            var maxMouseX = minMouseX + scrollbar_moving_spaceX;
            scrollbar.on('touchmove', function(e) {
                var ex = e.originalEvent.touches[0].pageX;
                x = get_scrollbar_Xpos();
                ex = Math.max(ex, minMouseX);
                ex = Math.min(ex, maxMouseX);
                var nx = x + (ex - lastMouseX);
                set_scrollbar_Xpos(nx);
                lastMouseX = ex;
                if (o.onDrag.call(this, x) === false) scrollbar.unbind('touchmove');
            });

            scrollbar.on('touchend', function(e) {
                scrollbar.unbind('touchmove');
                scrollbar.unbind('touchend');
                x = get_scrollbar_Xpos();
                o.onDrop.call(this, x);
            });

        });
        get_scrollbar_Xpos = function() {
            return parseInt(scrollbar.css('left'));
        };
        set_scrollbar_Xpos = function(sdelta) {
            if (scrollbar.attr("disabled") == "disabled") {
                return;
            }
            scrollbar.css({ left: Math.abs(sdelta) + 'px' });
        };
    });
};

(function(factory) {
    if (typeof define === 'function' && define.amd) {
        // AMD (Register as an anonymous module)
        define(['jquery'], factory);
    } else if (typeof exports === 'object') {
        // Node/CommonJS
        module.exports = factory(require('jquery'));
    } else {
        // Browser globals
        factory(jQuery);
    }
}(function($) {

    var pluses = /\+/g;

    function encode(s) {
        return config.raw ? s : encodeURIComponent(s);
    }

    function decode(s) {
        return config.raw ? s : decodeURIComponent(s);
    }

    function stringifyCookieValue(value) {
        return encode(config.json ? JSON.stringify(value) : String(value));
    }

    function parseCookieValue(s) {
        if (s.indexOf('"') === 0) {
            // This is a quoted cookie as according to RFC2068, unescape...
            s = s.slice(1, -1).replace(/\\"/g, '"').replace(/\\\\/g, '\\');
        }

        try {
            // Replace server-side written pluses with spaces.
            // If we can't decode the cookie, ignore it, it's unusable.
            // If we can't parse the cookie, ignore it, it's unusable.
            s = decodeURIComponent(s.replace(pluses, ' '));
            return config.json ? JSON.parse(s) : s;
        } catch (e) {}
    }

    function read(s, converter) {
        var value = config.raw ? s : parseCookieValue(s);
        return $.isFunction(converter) ? converter(value) : value;
    }

    var config = $.cookie = function(key, value, options) {

        // Write

        if (arguments.length > 1 && !$.isFunction(value)) {
            options = $.extend({}, config.defaults, options);

            if (typeof options.expires === 'number') {
                var days = options.expires,
                    t = options.expires = new Date();
                t.setMilliseconds(t.getMilliseconds() + days * 864e+5);
            }

            return (document.cookie = [
                encode(key), '=', stringifyCookieValue(value),
                options.expires ? '; expires=' + options.expires.toUTCString() : '', // use expires attribute, max-age is not supported by IE
                options.path ? '; path=' + options.path : '',
                options.domain ? '; domain=' + options.domain : '',
                options.secure ? '; secure' : ''
            ].join(''));
        }

        // Read

        var result = key ? undefined : {},
            // To prevent the for loop in the first place assign an empty array
            // in case there are no cookies at all. Also prevents odd result when
            // calling $.cookie().
            cookies = document.cookie ? document.cookie.split('; ') : [],
            i = 0,
            l = cookies.length;

        for (; i < l; i++) {
            var parts = cookies[i].split('='),
                name = decode(parts.shift()),
                cookie = parts.join('=');

            if (key === name) {
                // If second argument (value) is a function it's a converter...
                result = read(cookie, value);
                break;
            }

            // Prevent storing a cookie that we couldn't decode.
            if (!key && (cookie = read(cookie)) !== undefined) {
                result[name] = cookie;
            }
        }

        return result;
    };

    config.defaults = {};

    $.removeCookie = function(key, options) {
        // Must not alter options, thus extending a fresh object...
        $.cookie(key, '', $.extend({}, options, { expires: -1 }));
        return !$.cookie(key);
    };

}));


$.fn.extend({
    enable: function(o) {
        if (o === false) {
            $(this).attr("disabled", "disabled");
        } else {
            $(this).removeAttr('disabled');
        }
        return $(this);
    },
    disable: function() {
        $(this).attr("disabled", "disabled");
        return $(this);
    }
});
