$(document).ready(function(){
	$('span.popover-container .inner_box').each(function(index, ele) {
		$(ele).width($('body').width()).css('left', -$(ele).parent().offset().left)
	})
	$('.a6').css('top', -$('.a6').height())

	var winHeight = $(document).scrollTop();
	$(window).scroll(function() {
        var scrollY = $(document).scrollTop();// 获取垂直滚动的距离，即滚动了多少
        if (scrollY > 250){ //如果滚动距离大于550px则隐藏，否则删除隐藏类
        	$('.header').addClass('hiddened');
        }
        else {
        	$('.header').removeClass('hiddened');
        }
        if (scrollY < 697){ //如果没滚动到顶部，删除显示类，否则添加显示类
        	$('.header').removeClass('showed');
        }
        else {
        	$('.header').addClass('showed');
        }
    });

	var swiperT = new Swiper('.swiper-container-top', {
		pagination: '.swiper-pagination-top',
		paginationClickable: true,
		parallax: true,
		speed: 600,
		loop: true,
		autoplay: 10500,
		autoplayDisableOnInteraction: false
	});
	var newsSwiper = new Swiper('.primary-thumb-container', {
		scrollbar: '.swiper-scrollbar',
		loop: true,
		autoplay: 2000
	})

	//google验证
	$("#getcode_gg").click(function() {
		$(this).attr("src", '/templates/maijiayun/code_gg.php?' + Math.random());
	});

	appendRightBox();
	goTopEx();
});



function to_register(){
	window.open("http://erp.maijiayun.cn/register.html");
}

// $('#goTopBtn').css('display','none')

function goTopEx() {
	var obj = document.getElementById("right_box");
	if (!obj) return;
	function getScrollTop() {
		return document.documentElement.scrollTop + document.body.scrollTop;
	}
	function getWindowHeigt() {
		return window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight;
	}
	function setScrollTop(value) {
		if (document.documentElement.scrollTop) {
			document.documentElement.scrollTop = value;
		} else {
			document.body.scrollTop = value;
		}
	}
	/**
	 * 设置右下角通栏的显示状态
	 */
	 function setObjDisplay() {
	 	getScrollTop() > (getWindowHeigt()/2) ? obj.style.display = "": obj.style.display = "none";
	 }
	 window.onscroll = function() {
	 	setObjDisplay();
	 }
	 setObjDisplay();
	 $(obj).find('.go_top')[0].onclick = function() {
	 	var goTop = setInterval(scrollMove, 10);
	 	function scrollMove() {
	 		setScrollTop(getScrollTop() / 1.1);
	 		if (getScrollTop() < 1) clearInterval(goTop);
	 	}
	 }
	}

	function appendRightBox() {
		var tpl = '<div id="right_box">' +
		'<a href="javascript:void(0);" rel="nofollow" class="right1"  onclick="ysf.open()" ><span>QQ:2580848389<span></a>' +
		'<a href="javascript:void(0);" rel="nofollow" class="right2"><span>010-58103284<span></a>' +
		'<a href="javascript:void(0);" rel="nofollow" class="go_top"></a>' +
		'</div>';

		$('body').append(tpl);
	}

	var ww=($(window).width()-198)/2;
	$(".a8").css("left",ww);
	$(".a9").css("left",ww+108);







	$('.video_open').click(function() {
		$('.video_shade').fadeIn("200");
	})
	$('.video_close').click(function() {
		$('.video_shade').fadeOut("100");
	})

		    var w = $(window).width(); //屏幕宽高
		    var h = $(window).height(); //屏幕宽高
		    var str = "";
		    $(".tc_bg").width(w);
		    $(".tc_bg").height(h);
		    //定位
		    $(".tc_main").css("left", (w - 488) / 2);
		    $(".tc_main").css("top", (h - 520) / 2);
		    var oBox = document.getElementById('box');
		    if (aLabel) {
		    	var aLabel = oBox.getElementsByTagName('label');
		    	for (var i = 0, leni = aLabel.length; i < leni; i++) {
		    		aLabel[i].onclick = function() {
		    			for (var j = 0, lenj = aLabel.length; j < lenj; j++) {
		    				aLabel[j].removeAttribute('class');
		    			}
		    			this.className = 'selected';
		    		}
		    	}
		    }
		    function tc_show() {
		    	$(".tc").show();
		    	$(".tc_main").show();
		    	$(".tc_bg").show();
		    	$('.header').hide();
		    }

		    function tc_hide() {
		    	$(".tc").hide();
		    	$(".tc_main").hide();
		    	$(".tc_bg").hide();
		    	$('.header').show();
		    }

		    function f1() {
		    	var lc_name = $.trim($("#lc_name").val());
		    	var lc_title = $.trim($("#lc_title").val());
		    	var lc_tel = $("#lc_tel").val();
		    	var lc_email = $("#lc_email").val();
		    	var code_gg = $("#code_gg").val();
		    	var str = $(".selected").text();
		    	$("#lc_name").focus(function() {
		    		$(".c1").text("");
		    		$(this).css('border', '1px solid #4aacff')
		    	})
		    	$("#lc_title").focus(function() {
		    		$(".c2").text("");
		    		$(this).css('border', '1px solid #4aacff')
		    	})
		    	$("#lc_tel").focus(function() {
		    		$(".c3").text("");
		    		$(this).css('border', '1px solid #4aacff')
		    	})
		    	$("#lc_email").focus(function() {
		    		$(this).css('border', '1px solid #4aacff')
		    	})
		    	$("#lc_name").blur(function() {
		    		$(this).css('border', '1px solid #d3d3d3')
		    	})
		    	$("#lc_title").blur(function() {
		    		$(".c2").text("");
		    		$(this).css('border', '1px solid #d3d3d3')
		    	})
		    	$("#lc_tel").blur(function() {
		    		$(".c3").text("");
		    		$(this).css('border', '1px solid #d3d3d3')
		    	})
		    	$("#lc_email").blur(function() {
		    		$(this).css('border', '1px solid #d3d3d3')
		    	})
		    	$("#code_gg").click(function() {
		    		$(".c5").text("");
		    	})
		    	if (lc_name == "") {
		    		$(".c1").text("请输入姓名");
		    	} else if (lc_title == "") {
		    		$(".c2").text("请输入公司名称");
		    	} else if (!lc_tel.match(/^1[34578]\d{9}$/)) {
		    		$(".c3").text("请输入正确格式");
		    	} else if (code_gg == "") {
		    		$(".c5").text("请填写验证码");
		    	} else if (code_gg != "") {
		    		$.post("/templates/maijiayun/chk_code.php?act=gg", {
		    			code: code_gg
		    		},
		    		function(msg) {
		    			if (msg != 1) {
		    				$(".c5").text("验证码不正确");
		    			} else {
		    				$.post("../index.php?a=gbook_save", {

		    					lc_name: lc_name,
		    					lc_title: lc_title,
		    					lc_tel: lc_tel,
		    					lc_email: lc_email,
		    					str: str
		    				},
		    				function(data, status) {
		    					$('.cover_box').show();
		    					var sec = $('.cover_box').find('span').text();

		    					function DisNone() {
		    						sec--;
		    						$('.cover_box').find('span').text(sec)
		    					}
		    					setInterval(DisNone, 1000)

		    					function refresh() {
		    						location.reload()
		    					}
		    					setTimeout(refresh, 3000)
		    				});
		    			}
		    		});
		    	}
		    }
