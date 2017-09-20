<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="SQLBean.UserBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户的操作</title>
<link rel="shortcut icon" href="http://image.meilele.com/favicon.ico" />
<link rel="stylesheet" href="http://image.meilele.com/css/mll.common.user.min.css?20160311" />
<link href="http://image.meilele.com/css/user/user_interface.min.css" rel="stylesheet" type="text/css"/>
<style type="text/css"></style>
</head>
<body class="root-body" style="min-width:1190px;">
<%
	UserBean user = (UserBean)session.getAttribute("user");
%>
<div class="site-nav">
    <div class="w clearfix">
        <ul class="Left menu clearfix">
            <li class="Left banner last" id="JS_head_login">
            	<c:if test="<%=user.getUsername()==null %>">
            		<a target="_blank" href="<%=basePath %>data/login.jsp">请登录</a>&nbsp;&nbsp;
            	</c:if>
            	<c:if test="<%=user.getUsername()!=null %>">
            		<a target="_blank" href="<%=basePath %>data/login.jsp"><font color="blue"><%=user.getUsername()%></font></a>&nbsp;&nbsp;
            	</c:if>
            	<a target="_blank" href="<%=basePath %>data/zhuce.jsp">免费注册</a>
            </li>
        </ul>
        <ul class="Right menu clearfix">
            <li class="Left fore">
                <a class="drop-title" href="/user/?act=index" target="_blank">我的乐家具<i class="drop-arrow" target="_blank"></i></a>
                <ul class="dropdown mll-self">
                    <li><a href="/user/?act=order_list" target="_blank">我的订单</a></li>
                    <li><a href="/user/?act=coin_log" target="_blank">我的金币</a></li>
                    <li><a href="/user/?act=bonus" target="_blank">我的红包</a></li>
                    <li><a href="/user/?act=collection_list" target="_blank">我的收藏</a></li>
                    <li><a href="/user/?act=comment_list" target="_blank">我要评价</a></li>
                    <li><a href="/user/?act=insured_apply" target="_blank">申请保价</a></li>
                </ul>
            </li>

           <li id="JS_cart2" class="phc-cart Left fore">
                <a class="drop-title" href="/flow/?step=cart&rel=header" target="_blank" onmouseenter="window._gaq.push(['_trackEvent','2016版首页','鼠标移入购物车区域','onMouseOver'])"><i class="i-cart"></i><span class="cart-word">购物车<span id="JS_cart_num2" class="cart-count">0</span></span><i class="drop-arrow"></i></a>
                <div id="JS_cart_box2" class="cart-box dropdown cart-self">
                    <ul id="JS_cart_list2" class="cart-list" onclick="Cart.del(event);">
                    </ul>
                    <div id="JS_count_area2" class="cart-count none shopcart-count">
                        <p class="count-area" >共<span id="JS_cart_count2">0</span>件商品，共计<strong id="JS_count_total2" class="count-total red">&yen;00.00</strong></p>
                        <a class="count-btn" target="_blank" href="/flow/?step=cart&rel=header" target="_blank">去购物车结算</a>
                    </div>
                </div>
            </li>
            
            <li class="Left fore">
                <a class="drop-title" href="/user/?act=index" target="_blank"><i class="i-scan"></i><span class="scan-word">关注乐家具</span><i class="drop-arrow"></i></a>
                <ul class="dropdown two-dimension">
                    <li>
                        <a href="http://www.meilele.com/topic/201602_315dc.html?topdaohang" class="JS_header_gaerCode" target="_blank">
                            <img src="http://img003.mllres.com/images/201704/dfad46af6bcae11c07c491b7c73d7bf3.jpg" width="132px" height="132px">
                            <span>扫一扫</span>
                            <img src="http://img002.mllres.com/images/201610/1476412218454787057.jpg">
                        </a>
                    </li>
                </ul>
            </li>
            <li class="Left fore">
                <a class="drop-title" href="/article_cat-4/article-656.html" target="_blank">帮助中心<i class="drop-arrow" target="_blank"></i></a>
                <ul class="dropdown help-center">
                    <li><a href="/" target="_blank">招商加盟</a></li>
                    <li><a href="/" target="_blank">购买流程</a></li>
                    <li><a href="javascript:;" onclick="window.mchat&&window.mchat.openui&& window.mchat.openui()" rel="nofollow">在线帮助</a></li>
                    <li><a href="/" target="_blank">企业采购</a></li>
                </ul>
            </li>
            <li class="Left banner">
                <a href="javascript:;" onclick="addFavorite()">收藏本站</a>
            </li>
            
            <li class="Left banner last">
                <span class="blank" style="width:222px;height:24px;z-index:2"></span>
                <div id="JS_head_scoll_phone_527" class="JS_head_scoll_phone_527_active_br" ><div style="height:24px;width:213px;padding:0 5px;padding-left:7px;line-height:24px;overflow:hidden;" ><span style="color: #999;">服务热线：</span><span class="hotLine">176-0797-5702</span></div></div>
            </li>
        </ul>
    </div>
</div>

<script type="text/javascript">
function _show_( _this, config ){
    if( !_this )return;
    if( config && config.source && config.target ){
        var source = typeof config.source === 'string' ? $( "#"+config.source ) : $(config.source) ;
        var target = typeof config.target === 'string' ? $( "#"+config.target ) : $(config.target) ;
        var data = typeof config.data === 'string' ? $( "#"+config.data ) : $(config.data) ;
        if( source.length && target.length && !target.isDone){

            var html = $( source.val() || sourse.html() );
            if( data.length && typeof config.templateFunction == 'function' ) {

                var dataString = data.val() || data.html();
                dataString = $.parseJSON(dataString);

                html = config.templateFunction( html , dataString );

                data.remove();
            }
            target.empty().append( html ); 
            source.remove();
            if( typeof config.callback == 'function' )config.callback();
            target.isDone = true;
        }
    }

    $(_this).addClass('hover');

    //左侧菜单图片延时加载
    if( config && config.isLazyLoad  && _this.isDone ){ 
        var imgs = _this.find( 'img' );
        for( var k = 0 , kk = imgs.length ; k < kk ; k++ ){
            var src = imgs[k].getAttribute('data-src_index_menu');
            if( src ){
                imgs[k].setAttribute( 'src' , src );
                imgs[k].removeAttribute('data-src_index_menu');
            }
        }
        _this.isDone = true;
    }
}
/*------------------------------------------
 * @ 显示隐藏内容
 * @param [_this] [objext] {鼠标离开的对象}
 ------------------------------------------*/
function _hide_( _this ){
    if( !_this )return;
    var o = $(_this);
    if( o.hasClass('hover') ){
        o.removeClass('hover');
    }
}
function switchCityEvent(){
    $('#JS_hide_city_menu_11').hover(function(){
        _show_(this,{source:'JS_choose_city_source',target:'JS_header_city_bar_box',data:'JS_city_data',templateFunction:function(dom,json){
                dom = dom.jquery ? dom : $(dom);
                if(json){
                    var out = '';
                    var hot = '<a href="/" class="site_all Left" onclick="$.goExpr(\'index.html\',\'\',\'\',\'全国\');window._gaq.push([\'_trackEvent\',\'2016版首页\',\'成功切换城市\',\'click\']);return !1;"><strong>全国</strong></a>&nbsp;';
                    var inner = '';
                    var charList = '';

                    $.each(json.city_list, function(key,item){
                        charList += '<a href="javascript:;">'+key+'</a>';
                        out += '<tr><th><div>'+key+'</div></th><td>';
                        $.each(item,function(index,shi){
                            if(shi.v||shi.is_virtual) return ; //屏蔽虚拟站点
                            var sp = shi.p || shi.pinyin, si = shi.i || shi.region_id, sn = shi.n || shi.region_name;
                            out += '<a href="/'+sp+'/" data-region_id="'+si+'" data-pinyin="'+sp+'" onclick="$.goExpr(\''+sp+'\',\''+si+'\',\'\',\''+sn+'\');window._gaq.push([\'_trackEvent\',\'2016版首页\',\'成功切换城市\',\'click\']);return !1;">'+sn+'</a>';
                        });
                        out += '</td></tr>';
                    });

                    $.each(json.host_city_list,function(index,shi){
                        var sp = shi.p || shi.pinyin, si = shi.i || shi.region_id, sn = shi.n || shi.region_name;
                        hot += '<a href="/'+sp+'/" data-region_id="'+si+'" data-pinyin="'+sp+'" onclick="$.goExpr(\''+sp+'\',\''+si+'\',\'\',\''+sn+'\');window._gaq.push([\'_trackEvent\',\'2016版首页\',\'成功切换城市\',\'click\']);return !1;">'+sn+'</a>';
                    });

                    dom.find('#JS_header_city_hot').html( hot );
                    dom.find('#JS_header_city_char').html( charList );
                    dom.find('#JS_header_city_list').html( out );
                    return dom;
                }
            }});
            City.init();
        },function(){
            _hide_(this);
        }
    );
};


// 顶部导航hover效果
function siteHoverEvent(){
    $('.site-nav .drop-title').parent().on({
        'mouseenter':function(){
            jQuery(this).addClass('hover')
        },
        'mouseleave':function(){
            jQuery(this).removeClass('hover')
        }
    });
};
/* @ 收藏
============================================*/
function addFavorite(){
    window._gaq = window._gaq || [];
    _gaq.push(['_trackEvent','headerAddFavorite',location.href]);
    var sURL=window.location.href;
    var sTitle=document.title;
    try{
            window.external.addFavorite(sURL,sTitle);
    }catch(e){
        try{
            window.sidebar.addPanel(sTitle,sURL,"");
        }catch(e){
            alert("对不起，您的浏览器不支持此操作！\n请您使用菜单栏或Ctrl+D收藏本站。");
        }
    }
};
function exprCallBackNum(json){
    if(json && json.html_content){
        try{
            eval('json.html_content='+json.html_content);
        }catch(e){jQuery('#JS_head_scoll_phone_527').siblings('span.blank').remove();return;}
        if(!json)return;

        var o1 = $('#JS_mll_head_menu_expr');
        var o3 = $('#JS_Header_Home_Link');
        var o4 = $('#JS_Header_Logo_link_home');
        if ( json.html_content && json.html_content.expr_count > 0  && json.html_content.pinyin ) {
            o1.attr('href',"/"+json.html_content.pinyin+"/expr.html").html('体验馆<img src="http://image.meilele.com/images/common/site/hot.gif">');
            o3.attr('href',"/"+json.html_content.pinyin+"/");
            o4.attr('href',"/"+json.html_content.pinyin+"/");
        } else {
            jQuery('#JS_head_scoll_phone_527').siblings('span.blank').remove();
        }
        var len = exprCallBackNum.callFnArr.length;
        for(var i = 0;i < len;i ++){
            exprCallBackNum.callFnArr[i] && exprCallBackNum.callFnArr[i](json);
        }
    } else {
        jQuery('#JS_head_scoll_phone_527').siblings('span.blank').remove();
    }
};
exprCallBackNum.callFnArr = [];

/* @ 搜索
============================================*/
function searchBarEvent(){
    //初始化搜索
    $('#JS_MLL_search_header_input').click(function(){
        jQuery.searchKey( 'JS_MLL_search_header_input', 'JS_search_suggest' );
        $('#JS_MLL_search_header_input').unbind('click');
        $(this).addClass('search-input-focus');
        return false;
    });
};
function _clickHotSearch(obj){
    window._gaq && window._gaq.push(['_trackEvent','热门搜索',''+obj.innerHTML,''+obj.href]);
    return true;
};
function _clickSearchAd(){
    window._gaq && window._gaq.push(['_trackEvent','ad_click_gaca','ad_click_gaco','ad_click_搜索框左侧广告图_1']);
    return true;
};

function _INIT_HEAD_SEARCH(data){
    var json;
    try{
        json = eval( data.html_content );
    }
    catch(e){};
    if(json && json.length){
        var url = location.pathname;
        var wordIndex = -1;
        var tmpFilter ;
        window.__HEAD_SEARCH_WORDS_ARR = [];
        window.__HEAD_SEARCH_WORDS_OBJ = {};
        if(/\/jiaju\//.test(url)) {
            wordIndex = 0;
        } else if (/\/jiancai\//.test(url)){
            wordIndex = 1;
        } else if (/\/shipin\//.test(url)) {
            wordIndex = 2;
        }
        for(var k = 0,kk=json.length ; k < kk ;k++){
            tmpFilter = json[k].type.split("");
            if( wordIndex == -1 || tmpFilter[wordIndex] == 1 ){
                __HEAD_SEARCH_WORDS_ARR.push( json[k] );
                __HEAD_SEARCH_WORDS_OBJ[ json[k].text ] = json[k];
            }
        }
        var inpt = $('#JS_MLL_search_header_input')[0];
        if( __HEAD_SEARCH_WORDS_ARR.length && inpt && inpt.value == ""){
            inpt.value = MLL_Header_search_words();
            inpt.onfocus = function(){
                this.value = '';
                this.onfocus = function(){};
            }
            inpt.onblur = function(){
                if( this.value == '' ){
                    this.value = MLL_Header_search_words();
                    this.onfocus = function(){
                        this.value = '';
                        this.onfocus = function(){};
                    }
                }
            }
        }
    }
};
function MLL_Header_search_words(){
    var words = __HEAD_SEARCH_WORDS_ARR,
        k = Math.floor(Math.random()*words.length);
    return words[k].text;
};
function MLL_header_search_submit(flag){ 
    var val = '';
    
    var inpt = $('#JS_MLL_search_header_input')[0];
    var form = $('#JS_search_form')[0];
    
    val  = inpt.value + '';

    
    val = $.trim(val||'');
    var charVal=val;
        //搜索历史记录存cookie
    if (val && charVal.replace(/[^\x00-\xff]/g, "**").length<31) {
        var cval = $.cookie('search_h');
        if (cval) {
            cval = unescape(cval);
            cval = cval.split('*#');
            cval = removeElement(cval, val);
            if (cval.length > 9) {
                cval.shift();
            }
            cval = cval.join('*#');
            cval += '*#' + val
        } else {
            cval = val + '*#'
        }
        cval = escape(cval);
        $.cookie('search_h', cval, {path: '/', expires: 365});
    }
    //去除数组中的某个元素
    function removeElement(arr, val) {
        var newarr = [];
        for (var i = 0; i < arr.length; i++) {
            if (arr[i] != val) {
                newarr.push(arr[i]);
            }
        }
        return newarr;
    }
    if(!val)return false;
    if( window.__HEAD_SEARCH_WORDS_OBJ && __HEAD_SEARCH_WORDS_OBJ[val] ){//有匹配，跳转
        window.open(__HEAD_SEARCH_WORDS_OBJ[val].href + ( __HEAD_SEARCH_WORDS_OBJ[val].href.indexOf("#") >= 0 ? "&":"#" )+"kw="+encodeURIComponent(val));
        return false;
    }else{
        inpt.value = val;
        //$.cookie( 'MLL_AD' , val , {expires:15,domain:'meilele.com'} );
        return true;
    }
};

/* @ 购物车产品数量
============================================*/
/* @ lib_insert回调函数
-----------------------------*/
var car_number = 0;
function DY_cart_detail_nav_cb(json){
    Cart.goodsList = 1;
    Cart.saleLimit = json.saleLimit || 100;
    var size = json.goods_list.length;
    if(size > 0){
        Cart.formatData(json) || {};
        Cart.info.goodsData = json.goods_list;
    }
    Cart.update();
}
/* @ 购物车对象
-----------------------------*/
var Cart = {};
//购物车初始化
Cart.init = function(){
    //购物车下拉列表触发器
    Cart.handdler = $("#JS_cart,#JS_cart2");
    //购物车下拉列表
    Cart.Dom = Cart.handdler.find("#JS_cart_list,#JS_cart_list2");
    //商品个数显示
    Cart.number = Cart.handdler.find('#JS_cart_num,#JS_cart_num2');
    //商品价格显示区域
    Cart.countArea = Cart.handdler.find('#JS_count_area,#JS_count_area2');
    Cart.countNum = Cart.handdler.find('#JS_cart_count,#JS_cart_count2');
    Cart.sum = Cart.handdler.find('#JS_count_total,#JS_count_total2');
    Cart._isIE = !-[1,];
    Cart.info = {
        goodsData   : [],   //购物车商品信息
        sum         : 0,    //总金额
        goodsNumber : 0,    //商品数量
        giftsNumber : 0,    //赠品数量
        kindsNumber : 0 //商品种数
    };
    //初始化浮标
    Cart.number.html($.cookie("cart_number") || 0);
};

//判断是否登录
Cart.isLogin = function(){
    return ($.cookie('meilele_login') == '1' || $.cookie('ECS[username]'));
};

//显示购物车下拉列表
Cart.show = function(that){
    if(Cart.isLogin() && !Cart.moveToCollect.moved){//已登录
        Cart.moveToCollect(reqCartInfo);//先移入收藏夹
    }else{
        reqCartInfo();
    }

    /*
    *@param goodsGoodsIds 过滤的商品
    */
    function reqCartInfo(filterGoodsIds){
        if(!Cart.goodsList){//有新商品才更新
            Cart.Dom.html('')[0].className = 'cart-list';
            Cart.countArea.addClass('none');
            Cart.getCartInfo(null,filterGoodsIds);
        }
    }
  $(that).addClass('hover');
    if(Cart._isIE){
        Cart.handdler.find('.cart-arrow').addClass('cart-arrow-ie');
    }
};

/*
*@param filterGoodsIds 过滤的商品id
*/
Cart.getCartInfo = function(fn,filterGoodsIds){
    Cart.info = {
        goodsData   : [],   //购物车商品信息
        sum         : 0,    //总金额
        goodsNumber : 0,    //商品数量
        giftsNumber : 0,    //赠品数量
        kindsNumber : 0 //商品种数
    };
    var data = {};
    if(filterGoodsIds && filterGoodsIds.length){
        data.filterGoodsIds = filterGoodsIds.join('!');// '!'  感叹号隔开
    }
    jQuery.ajax({
        url:'/mll_api/api/cart_info',
        dataType:'json',
        cache:false,
        data : data,
        success: function(data){
            DY_cart_detail_nav_cb(data);
            fn && fn(data);
        }
    });
};

//设置商品个数到cookie
Cart.setCartNum = function(num){
    jQuery.cookie("cart_number",num || 0);
};

//收回购物车下拉列表
Cart.hide = function(that){
   $(that).removeClass("hover");
    if(Cart._isIE){
        Cart.handdler.find('.cart-arrow').removeClass('cart-arrow-ie');
    }
};

//删除购物车中的记录
Cart.del = function(e,dom){
    var evt = e || window.event,
        target = evt.target || evt.srcElement;
    if(dom){
        target = dom;
    }
    var _target = $(target);
    if( !_target.hasClass('Cart_del') ){
        return false;
    }

    var index = _target.attr("data-index"),
        rec_id = _target.attr("data-rec_id"),
        num = _target.attr("data-num"),
        price = _target.attr("data-goods_price"),
        act_id = _target.attr("data-act_id");
    var data = [];
    var obj = {};

    if( act_id > 0) {//活动,赠品
        var list = Cart.Dom.find('.JS_cart_list_act_' + act_id);
        list.each(function(i,dom){
            var _this = $(this);
            var rec_id = _this.data('rec_id');
            var index = _this.data('index');
            var num = _this.data('num');

            data.push( rec_id);
            obj[rec_id] = {
                index : index,
                num : num,
                price : 0
            }
        });
    } else {
        data.push( rec_id );
        obj[rec_id] = {
            'index': index,
            'num': num,
            'price' : price
        }
    }

    if( !Cart.inDelAjax && data.length > 0 ){
        Cart.inDelAjax = true;
        $.ajax({
            // url:'/flow/?step=drop_goods&ajax=1&id='+recId,
            url: '/add_cart/?step=dropGoods&ajax=1&goods=' + data.join('|'),
            type:'GET',
            dataType:'json',
            success:function( json ){
                if(json.error == 0){
                    delDom(data,obj);
                }else{
                    this.error();
                }
            },
            error:function(){
                /*alert("删除失败，请稍后再试！");*/
                $.lightBox( '删除失败，请稍后再试！',{确定:'close'},'','','',true,'c');
            },
            complete:function(){
                Cart.inDelAjax = false;
            }
        });
    }

    function delDom(data,obj){
        var goodsInfo = Cart.info;
        for(var i = 0;i < data.length;i++){
            var recId = data[i];
            var index = obj[recId].index;
            var num = obj[recId].num || 0;
            var price = obj[recId].price || 0;
            var total = num * price;

            var giftList = $('.JS_cart_list_gift_' + recId);
            giftList.each(function(i){
                var n = parseInt( giftList.eq(i).attr('data-num') );
                goodsInfo.giftsNumber -= n;
            });

            $("#JS_cart_list_index_"+index).remove();//删除商品
            giftList.remove();//删除赠品
            goodsInfo.goodsNumber -= num;
            goodsInfo.kindsNumber --;
            goodsInfo.sum -= total;
        }
        Cart.update();//更新
    }
};

Cart.formatData = function(_data){
    var goodsInfo = Cart.info;//商品种数
    var GD = _data.goods_list;
    var total = 0;
    var giftTotal = 0;
    var html = [];

    for(var x=0,xx=GD.length;x<xx;x++){
        var gdThumb = (GD[x].goods_thumb_1) ? GD[x].goods_thumb_1 : GD[x].goods_thumb;
        html.push('<li id="JS_cart_list_index_'+x+'" class="'+(GD[x].goods_activity_type!='newgift'? '':'JS_cart_list_gift_'+GD[x].activity_par_id)+(GD[x].price_activity_id>0?' JS_cart_list_act_'+GD[x].price_activity_id: '')+'clearfix cart-item" data-num="'+GD[x].goods_number+'" data-rec_id="'+GD[x].rec_id+'" data-index="'+x+'">');

            html.push('<a class="cart-img Left" href="'+GD[x].url+'" target="_blank" title="'+GD[x].goods_name+'"><img class="fl" src="http://img004.mllres.com/'+gdThumb+'" alt="'+GD[x].goods_name+'" width="86" height="57" ></a>');

            html.push('<a target="_blank" class="cart-link" title="'+GD[x].goods_name+'" href="'+GD[x].url+'">'+GD[x].goods_name+'</a>');

            if( GD[x].goods_activity_type != 'newgift' ){
                html.push('<p class="cart-cal clearfix"><a data-goods_id="' + GD[x].goods_id + '" class="Right black Cart_del" href="javascript:void(0)" data-index="'+x+'" data-rec_id="'+GD[x].rec_id+'" data-num="'+GD[x].goods_number+'" data-goods_price="' + GD[x].goods_price + '" data-act_id="'+(GD[x].price_activity_id || 0)+'">删除</a><span class="red cart-price " id="JS_danjia'+x+'">&yen;'+GD[x].goods_price+'</span>×<span class="black">'+GD[x].goods_number+'</span></p>');
                goodsInfo.goodsNumber += GD[x].goods_number-0;
                goodsInfo.kindsNumber ++ ;
                goodsInfo.sum += (GD[x].goods_number||0) * (GD[x].goods_price||0)
            } else {//赠品
                html.push('<p class="cart-cal clearfix"><strong style="margin-left:12px"><span class="cl red">赠品</span>&times;'+GD[x].goods_number+'</strong></p>');
                giftTotal += parseInt(GD[x].goods_number) || 0;
                goodsInfo.giftsNumber += GD[x].goods_number-0;
            }
        html.push('</li>');
        total += parseInt(GD[x].goods_number) || 0;
        // car_number=x;
    }

    Cart.Dom.html(html.join(''));
    Cart.update();//更新
    return goodsInfo;
};

//结算按钮
Cart.goPreCheckOut = function(){
    jQuery.showLoginBox( function(){
        location.href = '/flow/?step=pre_checkout&rel=header';
    } );
};

//超过100种商品移入收藏夹
Cart.moveToCollect = function(callback){
    Cart.countArea.find('.cart-tip').remove();
    jQuery.ajax({
        url : '/add_cart/?step=insertCollect',
        type : 'GET',
        dataType : 'JSON',
        cache : false,
        success : function(data){
            if(data && data.error == '0' && data.moveToCollect && data.moveToCollect.length){
                var goods = data.moveToCollect;
                var goodsIds = [];
                var h = [];
                h.push('<div class="cart-tip"><span class="red"><b>提示：</b>购物车里有' + goods.length + '件商品被移入收藏夹</span><p class="tip-content">');

                for(var i = 0,len = goods.length;i < len;i ++){
                    if(i<3){
                        h.push('<a target="_blank" class="tip-link" href="' + goods[i].goodsLink + '">' + goods[i].goodsName + '</a>');
                    }
                    goodsIds.push(goods[i].goodsId);
                }
                h.push('</p><a href="/user/?act=collection_list" target="_blank" class="red">查看收藏夹&gt;&gt;</a></div>');
                Cart.countArea.append(h.join(''));
                callback && callback(goodsIds);
            }else{
                this.error();
            }
            Cart.moveToCollect.moved = true;
        },
        error : function(){
            callback && callback([]);
            Cart.moveToCollect.moved = false;
        }
    });
};

//更新购物车
Cart.update = function(data){
    var data = data || Cart.info;
    var num = Number(data.goodsNumber || 0) + Number(data.giftsNumber || 0);
    if(num == 0){
        Cart.setCartNum(0);
        Cart.number.html(0);
        Cart.Dom.html('<li class="nothing"><b class="common-bg nothing-icon"></b>&nbsp;购物车中还没有商品，赶紧选购吧！</li>');
        Cart.countArea.addClass('none');
        Cart.Dom.removeClass('cart-full');
        return;
    }

    Cart.number.html(num);//浮标
    Cart.countNum.html(num);//计算区域的个数
    Cart.sum.html('&yen;' + Number(data.sum || 0).toFixed(2));//价格
    // data.listStr && Cart.Dom.html(data.listStr);//列表
    Cart.Dom.addClass('cart-full');
    Cart.countArea.removeClass('none');
    Cart.setCartNum(num);

    var itemNum = Cart.Dom.find('.cart-item').length;
    Cart.Dom.addClass('cart-full' + (itemNum > 2 ? 3 : itemNum));
    if(itemNum == 0){
        Cart.Dom[0].className = 'cart-list';
    }
};
window._onReadyList = window._onReadyList || [];
_onReadyList.push(function(){
    // 站点
    var regionName = $.cookie('region_name');
    $('#DY_site_name').html(regionName.slice(0,4) + '站');

    // 登录
    var userName = $.cookie('meilele_login') == "1" && $.cookie('ECS[username]');
    if ( userName ) {
        var count_num;
        /**
         * [success description] 未读消息请求
         * @param  {[type]} 获取总数对象
         * @return {[type]} return 未读消息的总数
         * @author jinzeze
         */
        $.ajax({
            type: 'POST',
            url: '/dubbo_api/mll/stationMsg/getMsgCount',
            dataType: 'json',
            success: function(json) {
                if(json && json.error == 0) {
                    $('.JS_mes_num').text(json.count).show();
                }else{
                    $('.JS_mes_num').hide();
                }
            },
            error:function(){
                $('.JS_mes_num').hide();
            }
        });
        $('#JS_head_login').html('<li class="Left banner"><span class="u-name">欢迎，<a href="/user/" target="_blank">' + userName + '</a></span>&emsp;<a target="_blank" class="u-mes" href="/user/?act=news">消息&nbsp;<i class="i-cyc JS_mes_num">' + 0 + '</i>&emsp;</a><a href="javascript:;" class="login-out" id="JS_login_out">[退出]</a></li>');
    }
    
    var img = new Image();
    if ( !$.cookie('ECS_ID') || $.cookie('autoLogin') || $.cookie('meilele_login') != 1 ) {
        img.src ='/ecsid_maker/?_='+(new Date()).getTime();
    }

    function substr(str, len) {
        if ( !str ) return '';
        var index = 0, arr = [];
        for ( var i = 0, ii = str.length; i < ii; i++ ) {
            var c = str.charAt(i);
            if ( c.charCodeAt(0) > 255 ) {
                index += 2;
            } else {
                index ++;
            }
            if ( index <= len ) {
                arr.push(c);
            } else {
                return arr.join('');
            }
        }
        return arr.join('');
    }
    
    $('#JS_login_out').on('click',function(){
        // $.cookie('autoLogin', 0);
        $.ajax({
            url:'/user/?act=logout',
            type:'get',
            cache: false,
            dataType:'json',
            success:function(json){
                if(json.error ==0){
                    window.location.reload();
                    return false;
                }else{
                    /*$.alert('注销失败，请重试！');*/
                    $.lightBox('注销失败，请重试！',{确定:'close'},'','','',true,'c');
                }
            },
            error:function(){
                /*$.alert('网络异常，请重试！');*/
                $.lightBox('网络异常，请重试！',{确定:'close'},'','','',true,'c');
            }
        });
    });

    // 顶部导航
    siteHoverEvent();
    // 初始化购物车
   $('#JS_cart,#JS_cart2').hover(function(){
        Cart.show(this)
   },function(){
        Cart.hide(this)
   })

    Cart.init();
    // 顶部切换城市
    // switchCityEvent();
});
</script>


<style type="text/css">
.page-header .hover .cart-box{display: block;background: #fff;padding-bottom: 20px;}
.Cart_del{color: #333!important}
.user-page-header .uph-cart .cart-box{left: -160px;}
.page-header .phc-cart{width:130px;height:30px;border:1px solid #ededed;margin-top:8px;position: relative;z-index: 5;text-align: center;}
.page-header .phc-cart .cart{width:130px;height:25px;display:inline-block;*zoom:1;color:#666;padding-top:5px;background-color:#f9f9f9;}
.page-header .phc-cart .cart:hover{color:#c9033b!important;}
.page-header .phc-cart .cart-box{width:280px;border:1px solid #ededed;left:-151px;top:31px;position: absolute;box-shadow:0px 0px 3px #ccc;z-index: 2;display:none;}
.page-header .phc-cart .cart-icon{width:22px;height:22px;padding-right:11px;display:inline-block;background-position:-100px 1px;vertical-align:middle;}
.page-header .phc-cart .cart-num{padding:1px 5px;border-radius:20px;position:absolute;top:-11px;left:21px;text-align: center;color:#fff;background:#ff8f16;font-weight: bold}
.page-header .phc-cart .cart-arrow{width:12px;height:12px;margin-left:25px;*margin-top:-14px;display:inline-block;*zoom:1;vertical-align:middle;background-position:1px -55px;transition: .2s ease-in-out ;-webkit-transition: .2s ease-in-out ;-moz-transition: .2s ease-in-out ;-o-transition: .2s ease-in-out ;vertical-align:-1px;}
.page-header .phc-cart .cart-list{height: 72px;background:#fff url(/images/common/loading.gif) no-repeat center center;}
.page-header .hover .cart-box{display:block;}
.page-header .hover.phc-cart{box-shadow:0px 0px 3px #ccc}
.page-header .phc-cart .cart .blank{display: none;}
.page-header .hover .blank{width:100%;height:3px;z-index:10;left:0;top:29px;position: absolute;background:#fff;display: inline!important}
.page-header .hover .cart-arrow{transform: rotate(-180deg);-webkit-transform: rotate(-180deg);-moz-transform: rotate(-180deg);-o-transform: rotate(-180deg);}
.page-header .hover .cart-arrow-ie{background-position: 1px -40px;}
.page-header .hover .cart{background:#fff}
.page-header .hover .cart-list{*zoom:1;}
.page-header .hover .cart-list .nothing{height:28px;font-size: 14px;font-family: 微软雅黑;color:#999;padding-top:25px;background-color:#fff}
.page-header .hover .cart-list .nothing-icon{width: 21px;height:20px;display: inline-block;*zoom:1;background-position:-101px -59px;vertical-align:bottom;}
.page-header .hover .cart-full{height:auto;max-height:255px;*max-height:270px;background:#fff;padding:0 15px;text-align: left;overflow-y:auto;}
.page-header .hover .cart-full3{_height:270px!important;}
.page-header .hover .cart-full2{_height:185px!important;}
.page-header .hover .cart-full1{_height:100px!important;}
.page-header .cart-full .cart-item{height:54px;*height:auto;padding:15px 0;background:00;border-bottom:1px dashed #eaeaea;*zoom:1;}
.page-header .cart-full .cart-item .cart-img{width:87px;height:59px;}
.page-header .cart-full .cart-item .cart-link{width:auto;min-width:131px;height:36px;margin-left:98px;line-height:18px;color:#333;display:block;overflow: hidden;word-break:break-all;word-wrap:break-word;}
.page-header .cart-full .cart-item .cart-link{_width:130px!important;}
.page-header .cart-full .cart-item .cart-link:hover{color:#ee1f1f !important;}
.page-header .cart-full .cart-item .cart-price{margin-left:10px;margin-top:5px;color:#cf000e
;}
.page-header .cart-full .cart-item .cart-cal{margin-top:5px}
.page-header .cart-full .cart-item .cart-del{margin-right:8px;color:#c9033b;}
.page-header .cart-full .cart-item .cart-del:hover{color:#c9033b!important;}
.page-header .phc-cart .cart-box .cart-count{padding-bottom:11px;padding-top: 10px;background:#f8f8f8;text-align:right;}
.page-header .cart-box .cart-count .count-area{padding-right:20px;}
.page-header .cart-box .cart-count .count-total{font-size:16px;vertical-align:middle;position:relative;top:-1px;color:#cf000e;}
.page-header .cart-box .cart-count .count-btn{width:106px;height:29px;border-radius:3px;margin-right: 21px;color:#fff;display: inline-block;font-size: 14px;background: #cf000e;font-weight:bold;line-height: 29px;text-align: center;margin-top:10px;font-family: 微软雅黑}
.page-header .cart-box .cart-count .count-btn:hover{color:#fff!important;text-decoration: none;}

.page-header .phc-cart .cart-tip{padding:14px 10px 12px 19px;border:1px solid #EBEBEB;margin:20px 17px 17px 17px;background:#fff;display:none;text-align:left}
.page-header .phc-cart .cart-tip .tip-link{width:210px;overflow:hidden;white-space:nowrap;text-overflow:ellipsis;display:block;color:#777;text-decoration:underline;line-height:16px;background:#fff;}
.page-header .phc-cart .cart-tip .tip-content{margin-top:3px;background:#fff;}
.page-header .hover .cart-tip{display:block;}
.page-header .cart-box .cart-count{padding-bottom: 11px;padding-top: 10px;background: #f8f8f8;text-align: right;}
.user-page-header .uph-cart .cart-icon{float:left;margin-top:2px;margin-left:11px;padding-right:0;width:17px;height:14px;background:url(http://image.meilele.com/images/common/site/site.png) -92px -48px no-repeat;}
.user-page-header .uph-cart .cart-arrow{margin:-2px 4px 0 3px;height:6px;vertical-align:middle;background:url(http://image.meilele.com/images/user/user_bg.png) -135px -5px no-repeat;}
.user-page-header .uph-cart .cart{padding-top:6px;height:24px;font-size:13px;}
</style>
<div class="user-page-header  page-header">
	
		<div class="w clearfix uph-container">
        <ul class="uph-navigator Left">
        	<li><a href="<%=basePath %>data/face.jsp"> <img src="<%=basePath %>images/face1.png" alt="" width="120" height="44"></a></li>
        	<li><a href="<%=basePath %>data/face.jsp">首页</a></li>
        	<li><a href="/user/?act=index">我的乐家具</a></li>
        	<li><a href="/user/?act=security">账户设置</a></li>
        	<li><a href="/user/?act=news">我的消息</a></li>
        </ul>
        <div class="uph-search Left">
			<form id="JS_search_form" class="search-form" action="/category-9999/" method="get" onsubmit="return MLL_header_search_submit();">
				<input type="hidden" name="fl" value="q">
				<input type="submit" class="submit-btn Right" value="搜索">
				<input id="JS_MLL_search_header_input" name="keywords" placeholder="团购" value="" autocomplete="off" type="text" maxlength="255" class="search-input search-input-focus">
			</form>
			<div id="JS_search_suggest" class="suggest" style="display: none;">
			</div>
		</div>
        <div id="JS_cart" class="uph-cart Right">
			<a href="/flow/?step=cart&amp;rel=header" class="cart"><b class="common-bg cart-icon"></b>我的购物车<b class="common-bg cart-arrow"></b></a>
			<span id="JS_cart_num" class="cart-num">0</span>
			<span class="blank none">&nbsp;</span>
			<div id="JS_cart_box" class="cart-box">
				<ul id="JS_cart_list" class="cart-list cart-full cart-full3" onclick="Cart.del(event);"></ul>
				<div id="JS_count_area" class="cart-count">
					<p class="count-area">共<span id="JS_cart_count">0</span>件商品，共计<strong id="JS_count_total" class="count-total red">¥279398.23</strong></p>
					<a class="count-btn" target="_blank" href="/flow/?step=cart&amp;rel=header">去购物车结算</a>
				</div>
			</div>
		</div>
		<span class="triangle"></span>
	</div>
</div>

		<div class="user-page-content">
			<div class="clearfix w">
				<div class="user_menu">
					<div class="navs" id="JS_u_navs">
						<h3>
							<span class="s1"></span>订单中心
						</h3>
						<ul>
							<li>
								<a href="<%=basePath%>data/myinfo.jsp" target="right">我的订单</a>
							</li>
							<li>
								<a href="<%=basePath%>data/myinfo.jsp" target="right">收货地址</a>
							</li>
							<li>
								<a href="<%=basePath%>data/myinfo.jsp" target="right">我的收藏</a>
							</li>
							<li>
								<a href="<%=basePath%>data/myinfo.jsp" target="right">评价晒单</a>
							</li>
							<li>
								<a href="<%=basePath%>data/myinfo.jsp" target="right">我的邀请</a>
							</li>
						</ul>
						<h3>
							<span class="s2"></span>我的资产
						</h3>
						<ul>
							<li>
								<a href="<%=basePath%>data/myinfo.jsp" target="right">我的金币</a>
							</li>
							<li>
								<a href="<%=basePath%>data/myinfo.jsp" target="right">我的乐币</a>
							</li>
							<li>
								<a href="<%=basePath%>data/myinfo.jsp" target="right">我的优惠券</a>
							</li>
							<li>
								<a href="<%=basePath%>data/myinfo.jsp" target="right">订单抽奖奖品</a>
							</li>
						</ul>
						<h3>
							<span class="s3"></span>客服服务
						</h3>
						<ul>
							<li>
								<a href="<%=basePath%>data/myinfo.jsp" target="right">申请保价</a>
							</li>
							<li>
								<a href="<%=basePath%>data/myinfo.jsp" target="right">返修/退换货</a>
							</li>
							<li class="last">
								<a href="<%=basePath%>data/myinfo.jsp" target="right">在线留言</a>
							</li>
							<li class="last">
								<a href="<%=basePath%>data/myinfo.jsp" target="right">退款记录</a>
							</li>
							<li>
								<a href="<%=basePath%>data/myinfo.jsp" target="right">我的拍卖</a>
							</li>
							<li>
								<a href="<%=basePath%>data/myinfo.jsp" target="right">我的留言</a>
							</li>
							<li>
								<a href="<%=basePath%>data/myinfo.jsp" target="right">纠纷投诉</a>
							</li>
						</ul>

					</div>
					<!---->
				</div>
				<div class="user_main">

					<style type="text/css">
.content-one {
	padding: 10px 30px;
}

.content-list {
	margin-top: 15px;
}

.content-one .u-info {
	position: relative;
}

.content-one .u-head {
	width: 110px;
	height: 110px;
	border: none;
	border-radius: 50%;
	overflow: hidden;
	margin: 20px 20px 20px 0;
}

.content-one .u-head img {
	width: 110px;
	height: 110px;
}

.content-one .u-level {
	width: 151px;
	height: 117px;
	padding: 20px 38px 20px 0;
	border-right: dashed 1px #efefef;
}

.content-one .u-level .name {
	color: #333;
	font-size: 18px;
}

.content-one .u-level .i-mes {
	margin-left: 10px;
	position: relative;
	display: inline-block;
	width: 22px;
	height: 20px;
	background: url(http://image.meilele.com/images/user/user_bg.png) -60px
		-41px no-repeat;
}

.content-one .u-level .mes-num {
	position: absolute;
	display: inline-block;
	min-width: 11px;
	height: 15px;
	line-height: 15px;
	background: #ed4c4c;
	border-radius: 17px;
	color: #fff;
	font-style: normal;
	left: 11px;
	top: -7px;
	font-size: 12px;
	text-align: center;
	padding: 1px 3px;
}

.content-one .u-level .mem-lev,.content-one .u-level .secur-lev {
	height: 22px;
	line-height: 22px;
	margin-top: 6px;
	font-size: 12px;
}

.content-one .u-level .t {
	color: #666;
}

.content-one .u-level .mem-lev .i-mem-lev {
	display: inline-block;
	width: 17px;
	height: 17px;
	margin-left: 10px;
	vertical-align: -3px;
	background: url(http://image.meilele.com/images/user/user_bg.png) -105px
		-43px no-repeat;
}

.content-one .u-level .t-green {
	color: #25b957;
}

.content-one .u-level .lev-bar-bg {
	display: inline-block;
	margin-left: 8px;
	width: 56px;
	background: #e0e0e0;
	height: 8px;
	border-radius: 4px;
	position: relative;
}

.content-one .u-level .lev-bar {
	display: inline-block;
	width: 28px;
	height: 8px;
	position: absolute;
	border-radius: 4px;
	background-color: #25b957;
	top: 0;
	left: 0;
}

.content-one .bind-lev {
	margin-top: 10px;
	margin-left: -1px;
	font-size: 12px;
}

.content-one .bind-lev .i-valid {
	display: inline-block;
	margin-right: 4px;
	width: 28px;
	height: 28px;
	background: url(http://image.meilele.com/images/user/user_bg.png) 0
		-127px no-repeat;
}

.content-one .bind-lev .i-valid.v1 {
	background-position: 0 -155px;
}

.content-one .bind-lev .i-valid.v2 {
	background-position: -29px -127px;
}

.content-one .bind-lev .i-valid.v3 {
	background-position: -29px -155px;
}

.content-one .bind-lev .i-valid.v4 {
	background-position: -57px -127px;
}

.content-one .bind-lev .i-valid.v5 {
	background-position: -57px -155px;
}

.content-one .bind-lev .i-valid.v6 {
	background-position: -86px -127px;
}

.content-one .bind-lev .i-valid.v7 {
	background-position: -86px -155px;
}

.content-one .u-order-link {
	padding: 30px 40px;
	border-right: dashed 1px #efefef;
}

.content-one .u-order-link li {
	float: left;
	display: inline;
	margin-right: 36px;
	width: 66px;
}

.content-one .u-order-link li.last {
	margin-right: 0;
}

.content-one .u-order-link li .link-icon {
	display: block;
	width: 66px;
	height: 66px;
	background: url(http://image.meilele.com/images/user/user_bg.png) 0
		-61px no-repeat;
}

.content-one .u-order-link li .link-icon.i2 {
	background-position: -66px -61px;
}

.content-one .u-order-link li .link-icon.i3 {
	background-position: -132px -61px;
}

.content-one .u-order-link li .link-icon.i4 {
	background-position: -198px -61px;
}

.content-one .u-order-link li .link-txt {
	margin-top: 10px;
	display: block;
	height: 24px;
	line-height: 24px;
	text-align: center;
	color: #333;
}

.content-one .coin-box {
	padding: 30px 25px 0 0;
}

.content-one .coin-box td {
	height: 28px;
	color: #666;
	font-size: 14px;
}

.content-one .coin-box td a {
	color: #444;
	font-weight: bold;
}

.content-one .u-info .dot {
	position: absolute;
	width: 15px;
	height: 15px;
	background: url(http://image.meilele.com/images/user/user_bg.png) -162px
		-230px no-repeat;
	right: 170px;
	top: -16px;
}

.content-one .u-info .down-dot {
	top: 161px;
}

/*我的订单*/
.content-list .def-act-filter {
	height: 23px;
	border: solid 1px #ebebeb;
	position: relative;
}

.content-list .def-act-filter .act-show {
	display: inline-block;
	height: 23px;
	line-height: 23px;
	padding-right: 20px;
	text-indent: 6px;
	color: #666;
	position: relative;
}

.content-list .def-act-filter .i-arrow {
	position: absolute;
	width: 12px;
	height: 6px;
	background: url(http://image.meilele.com/images/user/user_bg.png) -135px
		-5px no-repeat;
	top: 9px;
	right: 2px;
	overflow: hidden;
}

.content-list .def-act-filter.hover .i-arrow {
	transform: rotateX(180deg);
	-o-transform: rotateX(180deg);
	-ms-transform: rotateX(180deg);
	-moz-transform: rotateX(180deg);
	-webkit-transform: rotateX(180deg);
}

.content-list .def-act-filter ul {
	display: none;
	background-color: #fff;
	border: solid 1px #ebebeb;
	border-radius: 2px;
	position: absolute;
	right: -1px;
	top: 23px;
	z-index: 300;
}

.content-list .def-act-filter.hover ul {
	display: block;
}

.content-list .def-act-filter ul li a {
	display: block;
	height: 26px;
	line-height: 26px;
	padding: 0 20px 0 6px;
	background-color: #fff;
	white-space: nowrap;
	color: #666;
}

.content-list .def-act-filter ul li a:hover {
	background-color: #ed4c4c;
	color: #fff;
}

.content-list .def-order {
	width: 100%;
	border-collapse: collapse;
}

.content-list .def-order td {
	height: 96px;
	border-top: solid 1px #ebebeb;
	border-bottom: solid 1px #ebebeb;
	text-align: center;
}

.content-list .def-order .o-img-td {
	font-size: 0;
	text-align: left;
}

.content-list .def-order .o-img-td a {
	display: inline-block;
	margin-right: 15px;
}

.content-list .def-order .o-dot {
	display: inline-block;
	height: 67px;
	line-height: 58px;
	font-size: 30px;
	color: #ccc;
}

.content-list .order-trace-a i {
	display: inline-block;
	width: 12px;
	height: 6px;
	background: url(http://image.meilele.com/images/user/user_bg.png) -135px
		-13px no-repeat;
}

.content-list .track {
	position: relative;
	z-index: 4;
}

.content-list .track .trackInfo {
	border: 1px solid #eacaa5;
	border-radius: 2px;
	background: #fffae3;
	padding: 5px 10px 10px 10px;
	margin-top: 7px;
	position: absolute;
	width: 513px;
	top: 0;
	right: 8px;
	z-index: 10;
}

.content-list .track .trackInfo .out {
	width: 0;
	height: 0;
	position: absolute;
	top: -7px;
	right: 30px;
	border-left: 7px solid transparent;
	border-right: 7px solid transparent;
	border-bottom: 7px solid #eacaa5;
	_border-left-color: tomato;
	_border-right-color: tomato;
	_filter: chroma(color = tomato);
}

.content-list .track .trackInfo .in {
	width: 0;
	height: 0;
	position: absolute;
	top: -6px;
	right: 31px;
	border-left: 6px solid transparent;
	border-right: 6px solid transparent;
	border-bottom: 6px solid #fffae3;
	_border-left-color: tomato;
	_border-right-color: tomato;
	_filter: chroma(color = tomato);
}

.content-list .track .trackList {
	width: 100%;
}

.content-list .track .trackInfo th {
	font-weight: normal;
	border-bottom: dotted 1px #ebebeb;
	color: #999;
	height: 24px;
	text-align: left;
}

.content-list .track .trackInfo td {
	color: #666;
	height: 20px;
	text-align: left;
	border: none;
}

.content-list .oper a {
	color: #0072ca;
}

.content-list .oper .btn_s {
	display: block;
	width: 80px;
	margin: 0 auto;
	padding: 3px;
	margin-bottom: 5px;
	background-color: #ed4c4c;
	border-radius: 4px;
	color: #fff;
}

.tabConts {
	padding-top: 20px;
}

.hotSlide {
	position: relative;
	height: 157px;
}

.hotSlide .container {
	position: absolute;
	width: 880px;
	height: 157px;
	overflow: hidden;
	left: 35px;
}

.hotSlide .hot_list {
	position: absolute;
	height: 157px;
}

.hotSlide .hot_list .listItem {
	float: left;
	width: 160px;
	height: 157px;
	line-height: 1.6;
	margin-right: 20px;
}

.hotSlide .next,.hotSlide .prev {
	width: 18px;
	height: 27px;
	background: url(http://image.meilele.com/images/user/user_bg.png) -170px
		-16px no-repeat;
	position: absolute;
	left: 6px;
	top: 40px;
	display: block;
	text-indent: -999em;
}

.hotSlide .next {
	background-position: -192px -16px;
	left: 930px;
}

.hotSlide .hot_list .listItem p {
	margin: 14px 0 4px 0;
	line-height: 1;
}

.avatar-layer {
	top: 80px;
}

.ava-edit {
	width: 682px;
	border: solid 5px rgba(85, 85, 85, 0.3);
	border-radius: 5px;
	background: #fff;
	margin-left: auto;
	margin-right: auto;
}

.ava-edit .header {
	height: 40px;
	padding: 0 10px;
	background: #eee;
	font-weight: bold;
}

.ava-edit .header span {
	padding-left: 10px;
	font-size: 15px;
	font-family: '微软雅黑';
	color: #454545;
	float: left;
}

.ava-edit .header span,.ava-edit .header a {
	display: inline-block;
	height: 40px;
	line-height: 40px;
	vertical-align: top;
}

.ava-edit .header a {
	font-size: 20px;
	text-decoration: none;
	color: #ccc;
	float: right;
}

.content-one .u-level p.name span {
	display: inline-block;
	max-width: 100px;
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
}
</style>
					<div class="content-one">
						<div class="admin">
							<iframe rameborder="0" src="<%=basePath%>index.jsp" name="right"
								width="1000" height="920px"></iframe>
						</div>
					</div>
					<div class="content-list">
						<div class="clearfix">
							<div class="c-title Left">
								我的订单
							</div>
							<a class="Right gray" href="<%=basePath%>data/myinfo.jsp"
								target="right">全部订单<span class="songti">>></span>
							</a>
						</div>
						<div class="list-tips">
							<i class="i-warn"></i>您还没有任何商品购买记录！
						</div>
					</div>
					<div class="content-list">
						<div class="clearfix def-act-title">
							<div class="c-title Left">
								促销活动
							</div>
							<div class="def-act-filter Right">
								<a class="act-show" href="javascript:;" id="JS_act_filter_a"><span
									class="txt">团购活动</span><i class="i-arrow"></i>
								</a>
								<ul class="act-items" id="JS_act_filter_ul">
									<li>
										<a href="javasctipt:;" data-act="0">团购活动</a>
									</li>
									<li>
										<a href="javasctipt:;" data-act="1">特价活动</a>
									</li>
								</ul>
							</div>
						</div>
						<div class="tabs" id="JS_order_tabs">
							<div class="tabConts">
								<div class="tabItem tabItem_0">
									<div class="hotSlide">
										<div class="container">
											<ul class="hot_list clearfix">
												<li class="listItem">
													<a href="/tuangou/info-216711.html" target="_balnk"
														title="加厚6厘米抗菌舒适床垫榻榻米 灰色"><img
															src="http://image.meilele.com/images/images/blank.gif"
															data-src="http://img003.mllres.com/images/small/161/width/235/height/156/mode/1/encrypt/79e2992589eb9b9dcc4ede1aa2b4f22b/path/YKkxtD0+l8CT6mdTP0jUTosXyzGqRaYb484nDncYwHN73ZJpbqRYMTAVgG3rAvasm_osLHSZtBksryjW4OFUjAkQ5vgAhsiQgsTVvAF0bvuunwTX4v1oqPO4WI4WwsN+.jpg"
															alt="加厚6厘米抗菌舒适床垫榻榻米 灰色" width="160" height="107" />
													</a>
													<p>
														<a href="/tuangou/info-216711.html" target="_balnk"
															title="加厚6厘米抗菌舒适床垫榻榻米 灰色">加厚6厘米抗菌舒适床垫榻</a>
													</p>
													<span class="gray">团购价：</span><span class="orange yen">&yen;139</span>
												</li>
												<li class="listItem">
													<a href="/tuangou/info-258001.html" target="_balnk"
														title="爱情格调斜纹印花四件套（1.5米床）"><img
															src="http://image.meilele.com/images/images/blank.gif"
															data-src="http://img004.mllres.com/images/small/264/width/235/height/156/mode/1/encrypt/4d2b62fc8006a66032757ba6833457e2/path/YKkxtD0+l8CT6mdTP0jUTosXyzGqRaYb484nDncYwHMu0LBdu8KTW1PfFm4chOFVSeTCXkKc75Df8XQIsbYCyVnWvZOnuVv2HmQASiQjruTAjdKMWL5lwjXqNv7NG5Kd.jpg"
															alt="爱情格调斜纹印花四件套（1.5米床）" width="160" height="107" />
													</a>
													<p>
														<a href="/tuangou/info-258001.html" target="_balnk"
															title="爱情格调斜纹印花四件套（1.5米床）">爱情格调斜纹印花四件套（</a>
													</p>
													<span class="gray">团购价：</span><span class="orange yen">&yen;169</span>
												</li>
												<li class="listItem">
													<a href="/tuangou/info-281391.html" target="_balnk"
														title="【枕夜】邓禄普工艺天然颗粒乳胶枕 物理发泡 透气均匀 完美贴合颈部曲线 促进深度睡眠"><img
															src="http://image.meilele.com/images/images/blank.gif"
															data-src="http://img003.mllres.com/images/small/102/width/235/height/156/mode/1/encrypt/ee2f30e362d01d7e6ebbc5a345463f09/path/YKkxtD0+l8CT6mdTP0jUTosXyzGqRaYb484nDncYwHNbMet609TOCDpi8KxHwMj3YS4pFO7DA7Oi1T42NNDL6FBZOVbljuszZ4si7mckVdy0kduS+3BhrnP_GhicBcE1.jpg"
															alt="【枕夜】邓禄普工艺天然颗粒乳胶枕 物理发泡 透气均匀 完美贴合颈部曲线 促进深度睡眠"
															width="160" height="107" />
													</a>
													<p>
														<a href="/tuangou/info-281391.html" target="_balnk"
															title="【枕夜】邓禄普工艺天然颗粒乳胶枕 物理发泡 透气均匀 完美贴合颈部曲线 促进深度睡眠">【枕夜】邓禄普工艺天然颗</a>
													</p>
													<span class="gray">团购价：</span><span class="orange yen">&yen;47</span>
												</li>
												<li class="listItem">
													<a href="/tuangou/info-80419.html" target="_balnk"
														title="慢回弹竹纤维记忆枕保健枕"><img
															src="http://image.meilele.com/images/images/blank.gif"
															data-src="http://image.meilele.com/images/other_shop/20/80419/3d20dc70ee1c262e594c8ba6ad4ffa34.jpg"
															alt="慢回弹竹纤维记忆枕保健枕" width="160" height="107" />
													</a>
													<p>
														<a href="/tuangou/info-80419.html" target="_balnk"
															title="慢回弹竹纤维记忆枕保健枕">慢回弹竹纤维记忆枕保健枕</a>
													</p>
													<span class="gray">团购价：</span><span class="orange yen">&yen;29</span>
												</li>
												<li class="listItem">
													<a href="/tuangou/info-200001.html" target="_balnk"
														title="【疏影】1.5*2.0米 5公分纯乳胶薄垫 泰国天然乳胶原料 邓禄普生产工艺 物理发泡而成 正方面均匀分布透气孔 弹力持久~~"><img
															src="http://image.meilele.com/images/images/blank.gif"
															data-src="http://img001.mllres.com/images/small/940/width/235/height/156/mode/1/encrypt/3be5ba683ecfd72e67e7771b98833178/path/YKkxtD0+l8CT6mdTP0jUTosXyzGqRaYb484nDncYwHPXhkyS4C6D2QFa29yhCnzkEIIAIlxa6MBk6rjTL37Otf68WR2kcgzDy9OLXsuEucHsbh6EOw_3PhCl482zJpZ7.jpg"
															alt="【疏影】1.5*2.0米 5公分纯乳胶薄垫 泰国天然乳胶原料 邓禄普生产工艺 物理发泡而成 正方面均匀分布透气孔 弹力持久~~"
															width="160" height="107" />
													</a>
													<p>
														<a href="/tuangou/info-200001.html" target="_balnk"
															title="【疏影】1.5*2.0米 5公分纯乳胶薄垫 泰国天然乳胶原料 邓禄普生产工艺 物理发泡而成 正方面均匀分布透气孔 弹力持久~~">【疏影】1.5*2.0米</a>
													</p>
													<span class="gray">团购价：</span><span class="orange yen">&yen;1799</span>
												</li>
												<li class="listItem">
													<a href="/tuangou/info-200000.html" target="_balnk"
														title="【疏影】1.2*2.0米 5公分纯乳胶薄垫 泰国天然乳胶原料 邓禄普生产工艺 物理发泡而成 正方面均匀分布透气孔 弹力持久~~"><img
															src="http://image.meilele.com/images/images/blank.gif"
															data-src="http://img001.mllres.com/images/small/940/width/235/height/156/mode/1/encrypt/3be5ba683ecfd72e67e7771b98833178/path/YKkxtD0+l8CT6mdTP0jUTosXyzGqRaYb484nDncYwHPXhkyS4C6D2QFa29yhCnzkEIIAIlxa6MBk6rjTL37Otf68WR2kcgzDy9OLXsuEucHsbh6EOw_3PhCl482zJpZ7.jpg"
															alt="【疏影】1.2*2.0米 5公分纯乳胶薄垫 泰国天然乳胶原料 邓禄普生产工艺 物理发泡而成 正方面均匀分布透气孔 弹力持久~~"
															width="160" height="107" />
													</a>
													<p>
														<a href="/tuangou/info-200000.html" target="_balnk"
															title="【疏影】1.2*2.0米 5公分纯乳胶薄垫 泰国天然乳胶原料 邓禄普生产工艺 物理发泡而成 正方面均匀分布透气孔 弹力持久~~">【疏影】1.2*2.0米</a>
													</p>
													<span class="gray">团购价：</span><span class="orange yen">&yen;1299</span>
												</li>
												<li class="listItem">
													<a href="/tuangou/info-199995.html" target="_balnk"
														title="【疏影】1.0*2.0米 5公分纯乳胶薄垫 泰国天然乳胶原料 邓禄普生产工艺 物理发泡而成 正反面均匀分布透气孔 弹力持久~~"><img
															src="http://image.meilele.com/images/images/blank.gif"
															data-src="http://img001.mllres.com/images/small/940/width/235/height/156/mode/1/encrypt/3be5ba683ecfd72e67e7771b98833178/path/YKkxtD0+l8CT6mdTP0jUTosXyzGqRaYb484nDncYwHPXhkyS4C6D2QFa29yhCnzkEIIAIlxa6MBk6rjTL37Otf68WR2kcgzDy9OLXsuEucHsbh6EOw_3PhCl482zJpZ7.jpg"
															alt="【疏影】1.0*2.0米 5公分纯乳胶薄垫 泰国天然乳胶原料 邓禄普生产工艺 物理发泡而成 正反面均匀分布透气孔 弹力持久~~"
															width="160" height="107" />
													</a>
													<p>
														<a href="/tuangou/info-199995.html" target="_balnk"
															title="【疏影】1.0*2.0米 5公分纯乳胶薄垫 泰国天然乳胶原料 邓禄普生产工艺 物理发泡而成 正反面均匀分布透气孔 弹力持久~~">【疏影】1.0*2.0米</a>
													</p>
													<span class="gray">团购价：</span><span class="orange yen">&yen;1099</span>
												</li>
												<li class="listItem">
													<a href="/tuangou/info-204523.html" target="_balnk"
														title="【疏影】1.2*1.9米 5公分纯乳胶薄垫 泰国天然乳胶原料 邓禄普生产工艺 物理发泡而成 正方面均匀分布透气孔 弹力持久"><img
															src="http://image.meilele.com/images/images/blank.gif"
															data-src="http://img001.mllres.com/images/small/940/width/235/height/156/mode/1/encrypt/3be5ba683ecfd72e67e7771b98833178/path/YKkxtD0+l8CT6mdTP0jUTosXyzGqRaYb484nDncYwHPXhkyS4C6D2QFa29yhCnzkEIIAIlxa6MBk6rjTL37Otf68WR2kcgzDy9OLXsuEucHsbh6EOw_3PhCl482zJpZ7.jpg"
															alt="【疏影】1.2*1.9米 5公分纯乳胶薄垫 泰国天然乳胶原料 邓禄普生产工艺 物理发泡而成 正方面均匀分布透气孔 弹力持久"
															width="160" height="107" />
													</a>
													<p>
														<a href="/tuangou/info-204523.html" target="_balnk"
															title="【疏影】1.2*1.9米 5公分纯乳胶薄垫 泰国天然乳胶原料 邓禄普生产工艺 物理发泡而成 正方面均匀分布透气孔 弹力持久">【疏影】1.2*1.9米</a>
													</p>
													<span class="gray">团购价：</span><span class="orange yen">&yen;1299</span>
												</li>
											</ul>
										</div>
										<a href="#" class="prev">prev</a>
										<a href="#" class="next">next</a>
									</div>
								</div>
								<div class="tabItem none tabItem_1">
									<div class="hotSlide">
										<div class="container">
											<ul class="hot_list clearfix">
												<li class="listItem">
													<a href="/category-woshitaofang/goods-25741.html"
														target="_balnk" title="卧房家具-品牌6件套（1.8米床）"><img
															src="http://image.meilele.com/images/images/blank.gif"
															data-src="http://img003.mllres.com/images/201407/1405332200409991828.jpg"
															alt="卧房家具-品牌6件套（1.8米床）" width="160" height="107" />
													</a>
													<p>
														<a href="/category-woshitaofang/goods-25741.html"
															target="_balnk" title="卧房家具-品牌6件套（1.8米床）">卧房家具-品牌6件套（1</a>
													</p>
													<span class="gray">特价：</span><span class="orange yen">&yen;3999.00</span>
												</li>
												<li class="listItem">
													<a href="/category-woshitaofang/goods-26645.html"
														target="_balnk" title="卧房6件套（1.5床）"><img
															src="http://image.meilele.com/images/images/blank.gif"
															data-src="http://img002.mllres.com/images/201407/1405332936843269454.jpg"
															alt="卧房6件套（1.5床）" width="160" height="107" />
													</a>
													<p>
														<a href="/category-woshitaofang/goods-26645.html"
															target="_balnk" title="卧房6件套（1.5床）">卧房6件套（1.5床）</a>
													</p>
													<span class="gray">特价：</span><span class="orange yen">&yen;3935.00</span>
												</li>
												<li class="listItem">
													<a href="/category-chuangtougui/goods-48497.html"
														target="_balnk" title="橡胶实木床头柜 双层开敞式储物床头柜"><img
															src="http://image.meilele.com/images/images/blank.gif"
															data-src="http://img003.mllres.com/images/201403/1394865119981610679.jpg"
															alt="橡胶实木床头柜 双层开敞式储物床头柜" width="160" height="107" />
													</a>
													<p>
														<a href="/category-chuangtougui/goods-48497.html"
															target="_balnk" title="橡胶实木床头柜 双层开敞式储物床头柜">橡胶实木床头柜
															双层开敞</a>
													</p>
													<span class="gray">特价：</span><span class="orange yen">&yen;320.00</span>
												</li>
												<li class="listItem">
													<a href="/category-meiguichuang/goods-90780.html"
														target="_balnk" title="欧洲皇室御用款 桃花芯木雕花床 1.93米黄牛双色全真皮床"><img
															src="http://image.meilele.com/images/images/blank.gif"
															data-src="http://image.meilele.com/images/201408/1408598109111557758.jpg"
															alt="欧洲皇室御用款 桃花芯木雕花床 1.93米黄牛双色全真皮床" width="160"
															height="107" />
													</a>
													<p>
														<a href="/category-meiguichuang/goods-90780.html"
															target="_balnk" title="欧洲皇室御用款 桃花芯木雕花床 1.93米黄牛双色全真皮床">欧洲皇室御用款
															桃花芯木</a>
													</p>
													<span class="gray">特价：</span><span class="orange yen">&yen;11799.00</span>
												</li>
												<li class="listItem">
													<a href="/category-luodideng/goods-23918.html"
														target="_balnk" title="现代 两头白色落地灯 带玻璃茶几 客厅卧室"><img
															src="http://image.meilele.com/images/images/blank.gif"
															data-src="http://img003.mllres.com/images/201503/1425520441127987746.jpg"
															alt="现代 两头白色落地灯 带玻璃茶几 客厅卧室" width="160" height="107" />
													</a>
													<p>
														<a href="/category-luodideng/goods-23918.html"
															target="_balnk" title="现代 两头白色落地灯 带玻璃茶几 客厅卧室">现代
															两头白色落地灯 带</a>
													</p>
													<span class="gray">特价：</span><span class="orange yen">&yen;160.00</span>
												</li>
												<li class="listItem">
													<a href="/category-baijianjiqita/goods-29044.html"
														target="_balnk" title="8毫米仿珍珠饰品"><img
															src="http://image.meilele.com/images/images/blank.gif"
															data-src="http://img002.mllres.com/images/201211/1353487592969415825.jpg"
															alt="8毫米仿珍珠饰品" width="160" height="107" />
													</a>
													<p>
														<a href="/category-baijianjiqita/goods-29044.html"
															target="_balnk" title="8毫米仿珍珠饰品">8毫米仿珍珠饰品</a>
													</p>
													<span class="gray">特价：</span><span class="orange yen">&yen;5.00</span>
												</li>
												<li class="listItem">
													<a href="/category-baijianjiqita/goods-24252.html"
														target="_balnk" title="红葡萄蜡艺饰品（摆场）"><img
															src="http://image.meilele.com/images/images/blank.gif"
															data-src="http://image.meilele.com/images/201202/1328592091921599021.jpg"
															alt="红葡萄蜡艺饰品（摆场）" width="160" height="107" />
													</a>
													<p>
														<a href="/category-baijianjiqita/goods-24252.html"
															target="_balnk" title="红葡萄蜡艺饰品（摆场）">红葡萄蜡艺饰品（摆场）</a>
													</p>
													<span class="gray">特价：</span><span class="orange yen">&yen;18.00</span>
												</li>
											</ul>
										</div>
										<a href="#" class="prev">prev</a>
										<a href="#" class="next">next</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<script type="text/javascript">
window._onReadyList = window._onReadyList || [];
window._onReadyList.push(function(){
    $.fn.slidePicLong=function(auto,speed,slideSpe,minNum,addW,itemsCon){
        return this.each( function() {
            var $this=$(this);
            var container=$this.find('ul');
            var prevBtn=$this.find('.prev');
            var nextBtn=$this.find('.next');
            var items=container.children('li');
            var w=items.outerWidth()+addW;
            var len=items.length;
            if(len <= minNum) {
                prevBtn.hide();
                nextBtn.hide();
                return 0;//修复return false循环停止bug
            }else{
                prevBtn.show();
                nextBtn.show();
            }
            if(!$this.children('.container')){
                container.wrap('<div class="container"></div>');
            }
            container.css({'width':w *len});

            function slide(dir){
                switch(dir){
                    case 'next':
                    container.animate({'margin-left':-w},slideSpe,function(){
                        container.css('margin-left', '0');
                        container.find('li:first').appendTo(container);
                    });
                    break;

                    case 'prev':
                    container.css({'margin-left': -w});
                    container.find('li:last').prependTo(container);
                    container.animate({'marginLeft': 0},slideSpe);
                    break;
                }


            }
            function play(){
                auto=setInterval(function(){slide('next')},speed);
            }
            prevBtn.click(function(){
                clearInterval(auto);
                slide('prev');
                play();
                return false;
            })
            nextBtn.click(function(){
                clearInterval(auto);
                slide('next');
                play();
                return false;
            })
            container.hover(function(){
                    clearInterval(auto);
                },function(){
                    play();
            })
            if(auto){
                play();
            }
        })
    };
    $(function($){
        $('#JS_act_filter_a').click(function(){
            $(this).parent().addClass('hover');
            return false;
        });
        $('#JS_act_filter_ul').hover(function(){},function(){
            $(this).parent().removeClass('hover');
        });
        $('#JS_act_filter_ul a').click(function(){
            var curAct = $(this).data('act');
            if(curAct) {
                $('#JS_act_filter_a .txt').text('特价活动')
                $('#JS_order_tabs .tabItem').removeClass('none');
                $('#JS_order_tabs .tabItem_0').addClass('none');
            } else {
                $('#JS_act_filter_a .txt').text('团购活动')
                $('#JS_order_tabs .tabItem').removeClass('none');
                $('#JS_order_tabs .tabItem_1').addClass('none');
            }
            $('#JS_act_filter_ul').parent().removeClass('hover');
            return false;
        });

        $('.JS_order_trace_a').hover(function(){
            $(this).next('.track').find('.trackInfo').show();
        },function(){
            $(this).next('.track').find('.trackInfo').hide();
        });
        $('.hotSlide').slidePicLong(false,4000,350,4,25,'.container');
        // $('#hot1').slidePicLong(true,4000,350,4,25,'.container');
        // $('#hot2').slidePicLong(true,4000,350,4,25,'.container');
    });
});
var avatar = {
    _host: /www\.meilele\.com/.test(location.host) ? 'zx.meilele.com' : 'zxdev.meilele.com',
    show: function () {
        $.lightBox(avatar.createHtml(), {} , true , 300 , '' , true , 'avatar-layer')
    },
    createHtml: function () {
        var a = [];
        a.push('<div class="ava-edit">');
        a.push('<div class="header"><span>修改头像</span><a href="javascript:;" onclick="avatar.close();">&times;</a></div>');
        a.push('<div class="body"><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="680" height="490" id="FlashID" name="FlashID"  title="">');
        a.push('<param name="movie" value="http://img004.mllres.com/themes/paipai/flash/UploadHeadportrait.swf" />');
        a.push('<param name="allowfullscreen" value="true" />');
        a.push('<param name="allowscriptaccess" value="always" />');
        a.push('<param name="flashvars" value="id=FlashID&uploadUrl=http%3A%2F%2Fzx.meilele.com%2Fuser.html%3Fact%3DchangeAvatar" />');
        a.push('<embed id="FlashID" name="FlashID" src="http://img004.mllres.com/themes/paipai/flash/UploadHeadportrait.swf"  width="680" height="490" allowscriptaccess="always" allowfullscreen="true" flashvars="id=FlashID&uploadUrl=http%3A%2F%2F'+ this._host +'%2Fuser.html%3Fact%3DchangeAvatar"></embed></object></div>');
        a.push("</div>");
        return a.join("");
    },
    close: function () {
        $.closeLightBox();
    }
};

function cancelAndCloseEditor() {
    avatar.close();
}

function editorUploadSuccess(a) {
    /*$('.ava-edit').html('<div class="red" style="text-align:center;padding:20px; 0;font-size:16px;font-family:\'微软雅黑\'">头像上传成功！</div>')
    setTimeout(function () {
        $('.avatar').attr('src',a)
        avatar.close();
    }, 2000);*/
    avatar.close();
    $('.avatar').attr('src',a);
    /*alert('头像保存成功！');*/
    $.lightBox( '头像保存成功！',{确定:'close'},'','','',true,'c');
}
</script>
				</div>
			</div>
		</div>
		<style type="text/css">
    .footer-copy .copy-index{border:none;padding-top:0;}
    .footer-icon{margin-top:0;}
</style>
<div class="footer">
    <div class="footer-icon">
        <div class="w">
            <a href="/topic/article_diyipinpai.html#tab=o2o" target="_blank" title="网商+体验馆" rel="nofollow" class="icon-map"><p class="icon-bg i1"></p><p class="icon-title">网商+体验馆</p></a><a href="/topic/article_diyipinpai.html#tab=bso" target="_blank" title="100%正品" rel="nofollow" class="icon-map"><p class="icon-bg i3"></p><p class="icon-title">100%正品</p></a><a href="/topic/article_diyipinpai.html#tab=quality" target="_blank" title="双重质检" rel="nofollow" class="icon-map"><p class="icon-bg i4"></p><p class="icon-title">双重质检</p></a><a href="/topic/article_diyipinpai.html#tab=purchase" target="_blank" title="全球化采购" rel="nofollow" class="icon-map"><p class="icon-bg i5"></p><p class="icon-title">全球化采购</p></a><a href="/topic/article_diyipinpai.html#tab=returns" target="_blank" title="无理由退货" rel="nofollow" class="icon-map"><p class="icon-bg i6"></p><p class="icon-title">无理由退货</p></a><a href="/topic/article_diyipinpai.html#tab=postage" target="_blank" title="贵就赔" rel="nofollow" class="icon-map"><p class="icon-bg i7"></p><p class="icon-title">贵就赔</p></a><a href="/topic/article_diyipinpai.html#tab=mouth" target="_blank" title="万千口碑" rel="nofollow" class="icon-map"><p class="icon-bg i8"></p><p class="icon-title">万千口碑</p></a>
        </div>
    </div>
    <div class="footer-index">
        <div class="w clearfix">
            <ul class="Left coverage">
                <li class="s1">客服热线（8:00-23:00）</li>
                <li class="s2">400-009-8666</li>
                <li class="s3">乐家具在全国实体店<span class="red">297</span>家、样板间<span class="red">1</span>家</li>
                <li class="s4">
                    <a href="/expr.html" target="_blank"><i class="i-coord"></i>查看全国实体店</a>
                </li>
                <li class="s5">
                    <a href="javascript:;" onclick="$.codeSms(false, {click: '版权'});return false;"><i class="i-mobile"></i>免费发送到手机</a>
                </li>
            </ul>
            <div class="Right clearfix service">
                               <dl>
                    <dt>关于乐家具</dt>
                    <dd>
                                                                        <a href="/article_cat-12/article-5224.html" target="_blank" title="公司简介" rel="nofollow">公司简介</a>
                                                                                                <a href="/article_cat-12/article-10600.html" target="_blank" title="媒体聚焦" rel="nofollow">媒体聚焦</a>
                                                                                                <a href="/article_cat-12/article-5225.html" target="_blank" title="体验馆" rel="nofollow">体验馆</a>
                                                                                                <a href="/article_cat-12/article-830.html" target="_blank" title="诚聘英才" rel="nofollow">诚聘英才</a>
                                                                                                <a href="/article_cat-12/article-4615.html" target="_blank" title="联系我们" rel="nofollow">联系我们</a>
                                                                                                <a href="/article_cat-12/article-10611.html" target="_blank" title="乐家具O2O" rel="nofollow">乐家具O2O</a>
                                                                                                                                                                                                                                                                                                                    </dd>
                </dl>
                                <dl>
                    <dt>新手指南</dt>
                    <dd>
                                                                        <a href="/article_cat-6/article-5404.html" target="_blank" title="注册新用户" rel="nofollow">注册新用户</a>
                                                                                                <a href="/article_cat-6/article-9930.html" target="_blank" title="会员级别" rel="nofollow">会员级别</a>
                                                                                                <a href="/article_cat-6/article-9931.html" target="_blank" title="金币说明" rel="nofollow">金币说明</a>
                                                                                                <a href="/article_cat-6/article-16736.html" target="_blank" title="乐币说明" rel="nofollow">乐币说明</a>
                                                                                                <a href="/article_cat-6/article-101.html" target="_blank" title="订购家具流程" rel="nofollow">订购家具流程</a>
                                                                                                <a href="/article_cat-6/article-5280.html" target="_blank" title="体验馆购买指导" rel="nofollow">体验馆购买指导</a>
                                                                                                                                                                                                                                                                    </dd>
                </dl>
                                <dl>
                    <dt>配送安装</dt>
                    <dd>
                                                                        <a href="/article_cat-23/article-5405.html" target="_blank" title="收货指南" rel="nofollow">收货指南</a>
                                                                                                <a href="/article_cat-23/article-3206.html" target="_blank" title="体验馆服务费" rel="nofollow">体验馆服务费</a>
                                                                                                <a href="/article_cat-23/article-618.html" target="_blank" title="物流配送" rel="nofollow">物流配送</a>
                                                                    </dd>
                </dl>
                                <dl>
                    <dt>售后服务</dt>
                    <dd>
                                                                        <a href="/article_cat-26/article-620.html" target="_blank" title="45天无理由退换货" rel="nofollow">45天无理由退换货</a>
                                                                                                <a href="/article_cat-26/article-621.html" target="_blank" title="如何申请退款" rel="nofollow">如何申请退款</a>
                                                                                                <a href="/article_cat-26/article-2838.html" target="_blank" title="维修补件说明" rel="nofollow">维修补件说明</a>
                                                                                                <a href="/article_cat-26/article-1530.html" target="_blank" title="贵就赔" rel="nofollow">贵就赔</a>
                                                                    </dd>
                </dl>
                                <dl>
                    <dt>购物保障</dt>
                    <dd>
                                                                        <a href="/article_cat-15/article-2880.html" target="_blank" title="正品保证" rel="nofollow">正品保证</a>
                                                                                                <a href="/article_cat-15/article-300.html" target="_blank" title="注册协议" rel="nofollow">注册协议</a>
                                                                                                <a href="/article_cat-15/article-298.html" target="_blank" title="隐私保护" rel="nofollow">隐私保护</a>
                                                                                                <a href="/article_cat-15/article-297.html" target="_blank" title="免责声明" rel="nofollow">免责声明</a>
                                                                    </dd>
                </dl>
                                <dl class="fr">
                    <dt>官方微信</dt>
                    <dd>
                        <img src="http://image.meilele.com/images/201704/225cf87680308b23082b01db670100ee.jpg" alt="乐家具微信公众号" width="96" height="96" >
                    </dd>
                </dl>
            </div>
        </div>    
    </div>
    
    <div class="footer-copy">
        <div class="link-container">
            <div class="w">
                <div class="copy-index clearfix">
                   <div class="Left">
                        <p>
                            <a href="http://www.meilele.com/list/" target="_blank" title="家具图片">家具图片</a>  |  <a href="/article/" target="_blank" title="家居资讯">家居资讯</a>  |  <a href="/baike/" target="_blank" title="生活百科">生活百科</a>  |  <a href="/article_cat-1/" target="_blank" title="家私导购">家私导购</a>  |  <a href="/brand/" target="_blank" title="品牌展厅">品牌展厅</a>  |  <a href="http://club.meilele.com" target="_blank" title="装修论坛">装修论坛</a>  |  <a href="http://www.melodyhome.com/" target="_blank" title="furniture store">furniture store</a>  |  <a href="/article_cat-4/article-656.html" target="_blank" title="客服中心" rel="nofollow">客服中心</a>  |  <a href="/sitesmap.html" target="_blank" title="网站地图">网站地图</a>  |  <a href="/links.html" target="_blank" title="友情链接" rel="nofollow">友情链接</a>  |  <a href="/keywords/" target="_blank" title="更多">更多</a> 
                        </p>
                        <p>
                            <span class="yen">&copy; 2017-2027 </span><span id="JS_footer_copyright">乐家具</span> 版权所有，并保留所有权利。<a href="http://www.miibeian.gov.cn/" target="_blank" class="gray" rel="nofollow">ICP备案证书号：粤ICP备08008334号</a>
                        </p>
                   </div>
                   <div class="Right credit">
                        <a target="_blank" href="https://search.szfw.org/cert/l/CX20141121005615005700"><span><i class="c1"></i>诚信网站示范企业</span></a>
                        <a target="_blank" href="https://ss.knet.cn/verifyseal.dll?sn=e12042051010018574308175&ct=df"><span><i class="c2"></i>可信网站信用评价</span></a>
                        <span><i class="c3"></i>经营网站备案信息</span>
                   </div>
                </div>
            </div>
        </div>
    </div>
</div>


<script id="JS_city_data" type="text/html"></script>
<textarea id="JS_choose_city_source" style="display:none">
    <em class="i-c"></em>
    <div class="hideMap">
        <div class="showPanel clearfix" style="padding-bottom: 10px;">
            <div class="Left mycity">
                <div id="JS_current_city_box">
                    当前城市：<strong id="JS_city_current_city" style="color: #444;"></strong>
                    <a class="red" style="display:none" id="JS_set_default_city_header" href="javascript:;">[设为默认城市]</a>
                </div>
                <div id="JS_default_city_delete" style="display:none"></div>
            </div>
            <a class="Right near" id="JS_my_near_expr" target="_blank" href="/expr.html"><i class="i-coord"></i>附近的体验馆</a>        </div>
        <div class="showPanel showPanel2 clearfix">
            <div class="hot_city" id="JS_header_city_hot"></div>
            <div class="mt10">
                <div id="JS_search_city_tip_header" class="search_city_tip"  style="display:none;">抱歉，该城市暂无体验馆！</div>
                <input id="JS_search_city_input_header" class="search_city_input" value="输入城市名" /><input type="button" id="JS_search_city_submit_header" class="search_city_submit" value="搜索">
            </div>
            <div class="city_words mt10" id="JS_header_city_char" ></div>
        </div>
        <div class="scrollBody">
            <div class="cityMap clearfix">
                <table id="JS_header_city_list" class="city_list"></table>
            </div>

            <div class="scrollBar"><span id="JS_header_city_bar"></span></div>
        </div>
    </div>
</textarea>


<script src="http://image.meilele.com/js/mll/jq.js?0419"></script> 
<script>
$.__IMG = 'http://image.meilele.com' || 'http://image.meilele.com';
(function($){
	var lists = [
		[ 'checkPrize' , 'checkprize.min.js?0116g'],
		[ 'sendSms' , 'sendsms2.min.js?160307'],
		[ 'sendSmsGoods' , 'sendSmsGoods.min.js?20170205'],
		[ 'codeSms' , 'codesms.min.js?20170316'], // 二维码短信
		[ 'orderQuery' , 'orderquery.min.js?0116g'],
		[ 'addToCart' , 'addtocart.min.js?201508188'],
		[ 'costDownTip' , 'costdowntip.min.js?160823'],
		[ 'searchKey' , 'searchkey.min.js?20161103'],
		[ 'getComment' , 'getcomment.min.js?0801'],
		[ 'goodsComment' , 'goodscomment.min.js?0905'],
		[ 'quickBuy' , 'quickbuy.min.js?0812'],
		[ 'onlineVideo' , 'onlinevideo.min.js?0410'],
		// [ 'wholehouse' , 'mini_qwg.min.js?1205'],
		[ 'visitYBJ' , 'ybjvisit.min.js?0910'],
		[ 'mobileCaptcha','mobilecaptcha.min.js?060119'],
		[ 'shipRegion','ship_region.min.js?0715'],
		[ 'bonus','bonus.min.js?0520'],
		[ 'sendPrize','sendPrize.min.js?20160805'],
		// 发送购物车到手机
		[ 'cartSms','cartsms.min.js?0108'],
		// 红包预售
		['couponPresell', 'coupon_presell.min.js?20170205'],
        //城市选择
        ['cityLayer', 'cityLayer.min.js?20170321'],
        //老用户采集弹框
        ['oldClient', 'oldClient.min.js?20161125'],
        ['customBoxExtend','customBoxExtend.min.js?20170306'],
        //红包页面 红包
        ['redEnvelope','redEnvelope.min.js?20170205']
	];
	var kk = lists.length;
	for(var k = 0 ; k < kk ; k++) {
		var key  = lists[k][0];
		var file = lists[k][1];
		$[ key ] = (function( key , file ){
			return function(){
				var params = arguments;
                $.req( file , function(){
                    $[key].apply( $ , params );
                })
			}
		})( key , file );
	}
	//特殊
	$.showLoginBox = function(callback,refresh,phone_num){
		if ($.cookie("meilele_login") == "1" && $.cookie("ECS[username]") ) {
			if (typeof callback == "function"){
				callback({
					"username": $.cookie("ECS[username]"),
					"email": $.cookie("ECS[email]")
				});
			}
			return;
		}
		$.req( 'showloginbox.min.js?0428' , function(){
			$.showLoginBox( callback,refresh,phone_num );
		});
	}
    
	if( window._ipad_from ){
		$.addToCart = function(mainGoodsId,goodsData){
			if( goodsData ){
				var tmpH = [];
				for(var k in goodsData){
					var data = goodsData[k];
					if( $.isNumeric(data) ){
						tmpH.push( k+':'+data );
					} else {
						var tmp = [];
						tmp.push(k);
						tmp.push(data.number || 1);
						tmpH.push( tmp.join(':') );
					}
				};
				tmpH = tmpH.join(',');
				window.open("/addToCart/"+tmpH);
			}
		}
		$.cookie('ipad_from',1,{domain:location.host});
	}
})(jQuery);
</script>




<script>
    (function(){
        var that = this;
        if($.cookie('currentCity')) {
            return;
        }
        $.ajax({
            url:'http://api.map.baidu.com/location/ip?ak=R1CsBhbOHZyefZKArjicj741l7K36eyV',
            dataType: 'jsonp',
            success: function(json) {
                if(json && json.address) {
                    var addr = json.address.split('|')[2];
                    $.cookie('currentCity',addr,{
                        path: "/",
                        expires: 365,
                        domain: '.meilele.com'
                    });
                } else {
                    $.cookie('currentCity','北京');
                }
            },error: function() {
                $.cookie('currentCity','北京');
            }
        })
    })()
</script>
<script>
//老用户号码采集优化
(function(popout){
    window.oldClientPopout = popout;
    var s = document.createElement("script");s.type = "text/javascript";s.async = true;s.src = "http://image.meilele.com/js/ocl.invoke.min.js?20161122";
    var s0 = document.getElementsByTagName("script")[0];s0.parentNode.insertBefore(s, s0);
})('');
</script>

<script>window.M = window.M || {};if($.addToCart)M.addToCart = $.addToCart</script><script>var City={};City.init=function(){if(City.ready&&City.currentCity==$("#DY_site_name").html().replace("站","")){return;}City.currentCity=$("#DY_site_name").html().replace("站","");City.handdler=$("JS_header_city_char");City.chars=$("#JS_header_city_char a");City.stage=$("#JS_header_city_list");City.lists=$("#JS_header_city_list tr");City.setDefaultDom=$("#JS_set_default_city_header");City.deleteDefaultCityDom=$("#JS_default_city_delete");City.nearDom=$("#JS_my_near_expr");City.currentBox=$("#JS_current_city_box");var c=City.stage.find("a");City.cityData={};for(var a=0,d=c.length;a<d;a++){var f=c[a];var g=f.getAttribute("data-region_id");var b=f.getAttribute("data-pinyin");var e=f.innerHTML;City.cityData[e]=City.cityData[b]=City.cityData[g]={regionId:g,pinyin:b,regionName:e};}c=null;City.defaultCity={};if($.cookie("default_rgn_id")){City.defaultCity=City.cityData[$.cookie("default_rgn_id")]||{};}$("#JS_city_current_city").html(City.currentCity);City.currentCityData=City.cityData[City.currentCity];City.refreshDefaultCityDom();City.inputDom=$("#JS_search_city_input_header");City.tip=$("#JS_search_city_tip_header");City.inputDom.keyup(function(h){City.tip.hide();if(h.keyCode==13){City.goSearch();}});City.inputDom.focus(function(){if(this.value=="输入城市名"){this.value="";}City.tip.hide();});$("#JS_search_city_submit_header").click(City.goSearch);City.bar=$("#JS_header_city_bar");City.barBox=$("#JS_header_city_bar_box");City.size=City.chars.length;City.allHeight=City.stage.height();City.rate=(City.allHeight-170)/(180-36);City.to=0;City.to2=0;City.nowH=0;City.mouseDown=false;City.selectByChar();City.scrollBar();City.scrollByWheel();City.ready=true;};City.refreshDefaultCityDom=function(){if(City.currentCity!="全国"&&City.currentCityData&&City.currentCityData.regionId!=City.defaultCity.regionId){City.setDefaultDom.show();City.setDefaultDom.attr("href","javascript:City.setDefaultCity('"+City.currentCityData.regionId+"')");}else{City.setDefaultDom.hide();City.nearDom.hide();}if(City.currentCity!="全国"&&City.currentCityData){City.nearDom.attr("href","/"+City.currentCityData.pinyin+"/area.html");City.nearDom.show();City.currentBox.show();}else{City.nearDom.hide();City.currentBox.hide();}if(City.defaultCity&&City.defaultCity.regionId){City.deleteDefaultCityDom.html('您默认的城市是：<a href="javascript:;" onclick="M.goExpr(City.defaultCity.pinyin,City.defaultCity.regionId,\'{$goExprUrlType}\',City.defaultCity.regionName);return false;" class="red">'+City.defaultCity.regionName+'</a> <a href="javascript:City.delDefaultCity();" class="red">[删除]</a>');City.deleteDefaultCityDom.show();}else{City.deleteDefaultCityDom.hide();}};City.setDefaultCity=function(a){if(a&&City.cityData[a]){City.defaultCity=City.cityData[a];$.cookie("default_rgn_id",City.cityData[a].regionId,{expires:365});City.refreshDefaultCityDom();}};City.delDefaultCity=function(){City.defaultCity={};$.cookie("default_rgn_id","",{expires:-1});City.refreshDefaultCityDom();};City.goSearch=function(){var b=(City.inputDom.val()+"").replace(/[\s\d]/g,"");var a=City.cityData[b];if(a){City.tip.hide();$.goExpr(a.pinyin,a.regionId,"{$goExprUrlType}",a.regionName);}else{City.tip.show();}};City.selectByChar=function(){var b=0;for(var a=0;a<City.size;a++){City.chars[a]._h=b;City.chars[a].onmouseover=function(){var c=this;window._cityTimer=setTimeout(function(){City.move(c._h);City.to2=City.to;},300);};City.chars[a].onmouseout=function(){if(window._cityTimer){clearTimeout(window._cityTimer);return;}};b+=City.lists.eq(a).height();}};City.move=function(b,a){if(b<0){b=0;}b=b>=(City.allHeight-170)?(City.allHeight-170):b;var c=parseInt(b/City.rate);if(a){City.stage.css("margin-top",(0-b)+"px");City.bar.css("margin-top",c+"px");}else{City.stage.stop(true,false).animate({marginTop:(0-b)+"px"});City.bar.stop(true,false).animate({marginTop:c+"px"});}City.to=c;City.nowH=b;};City.scrollBar=function(){City.bar.on("mousedown",function(a){a=a||window.event;City.mouseDown=true;City.nowHeight=a.pageY||a.clientY;a.returnValue=false;return false;});City.bar.on("dragstart",function(a){a=a||window.event;a.returnValue=false;});$("body").on("mouseup",function(a){a=a||window.event;City.mouseDown=false;City.to2=City.to;a.returnValue=false;return false;});City.barBox.on("mousemove",function(a){if(!City.mouseDown){return;}a=a||window.event;var b=a.pageY||a.clientY;City.move((b-City.nowHeight+City.to2)*City.rate,true);a.returnValue=false;return false;});};City.scrollByWheel=function(a){City.addScrollListener(City.barBox[0],function(c){c=c||window.event;var b;if(c.wheelDelta){b=(0-c.wheelDelta)/Math.abs(c.wheelDelta);}else{b=c.detail/Math.abs(c.detail);}City.move(City.nowH+b*50);City.to2=City.to;if(navigator.userAgent.toLowerCase().indexOf("msie")>=0){event.returnValue=false;}else{c.preventDefault();}});};City.addScrollListener=function(e,d){if(typeof e!="object"){return;}if(typeof d!="function"){return;}if(typeof arguments.callee.browser=="undefined"){var c=navigator.userAgent;var a={};a.opera=c.indexOf("Opera")>-1&&typeof window.opera=="object";a.khtml=(c.indexOf("KHTML")>-1||c.indexOf("AppleWebKit")>-1||c.indexOf("Konqueror")>-1)&&!a.opera;a.ie=c.indexOf("MSIE")>-1&&!a.opera;a.gecko=c.indexOf("Gecko")>-1&&!a.khtml;arguments.callee.browser=a;}if(e==window){e=document;}if(arguments.callee.browser.ie){e.attachEvent("onmousewheel",d);}else{e.addEventListener(arguments.callee.browser.gecko?"DOMMouseScroll":"mousewheel",d,false);}};City.exed=true;
/*leihao:2015-01-28 10:21:22*/</script>
<script type="text/javascript">
;(function(){//清除电信广告
    function checkIframe(nLen){
        if(nLen > 10)return;  //最多检测10 秒钟
        var bRemove  =false;
        var oIframes = document.getElementsByTagName('iframe');
        var oIframe = null;
        if(oIframes == null || oIframes.length == 0){       
            window.setTimeout(function(){checkIframe(nLen+1)}, 1000)    ;
            return;
        }
        var nLength = oIframes.length;
        for(var i=0;i<nLength; i++){
            oIframe = oIframes[i];
            var strSRC = oIframe.src;   
            if( /72link/.test(strSRC) ){
                setTimeout(function(){
                    location.reload();
                },1000)
                throw new Error('发现电信广告');
            }   
            
        }
        if(!bRemove)window.setTimeout(function(){checkIframe(nLen+1)}, 1000)    ;   
    }
    window.setTimeout(function(){checkIframe(0)}, 100);
})();


</script><script>

$(function($){
	var mHeight = Math.max($('.user_menu').height()+20,$('.user_main').height());
	$('.user_menu').css('height', (mHeight-20) + 'px');
});
// M.addHandler( window , 'load' , function(){M.lazyImg.start()} );
$(window).on('load',function(){
	$.lazyImg.start();

});
</script>
<div id="static_dynamic" name="static_dynamic" page_sn="user" rgn_id="" debug=""></div>
<script type="text/javascript">window.static_dynamic && static_dynamic();</script><div id="INIT_Fchat2" class="" style="display: none;width: 58px;height: 127px;right: 5px;top: 190px;_top: expression(eval(document.documentElement.scrollTop+190));background: url(http://image.meilele.com/images/201405/1401178094439.png) 0 0;_background: url(http://image.meilele.com/images/201405/140117892382.gif) 0 0;cursor: pointer;font-size: 12px;z-index: 1500;position: fixed;_position: absolute;overflow: hidden;"><div class="FC_btns FC_number" style="margin-left:24px;margin-top:-1px;" id="JS_FC_number2"></div></div>
<script type="text/javascript">
(function(){
	window.mchat = window.mchat || {};

			mchat.activityUrl = 'http://www.meilele.com/topic/201703_znqdccj.html?site_from=zhannei&href=[JS_img_3]#thg=gaca&adg=gaco&adn=%E6%B5%AE%E6%BC%8220%E6%8A%B5200&ado=1&adc=0';
	
	var d = document.getElementById('INIT_Fchat2');
	if( (d && mchat.config) || window._ipad_from ){
		d.style.display = 'none';
	}
	var date = new Date();
	d.onclick = function(){
		if( mchat.show ){
			mchat.show();
		}else{
			if (window.isGoodsIndex) {
				$.ajax({
					url:'http://image.meilele.com/js/mll/chatFloat_new.min.js?'+date.getFullYear()+date.getMonth()+date.getDate(),
					cache:true,
					dataType:'script'
				});
			} else {
				$.ajax({
					url:'http://image.meilele.com/js/mll/chatFloat.min.js?'+date.getFullYear()+date.getMonth()+date.getDate(),
					cache:true,
					dataType:'script'
				});
			}
		}
	}
	setTimeout(function(){
		if ( !mchat.config  || !mchat.config.background_main ) {
			$('#INIT_Fchat2').trigger('click');
		}
	},1500);
})();
</script><script src="http://image.meilele.com/js/ana.min.js?1121"></script>
<script>window._ana && _ana.push( ['trackView'] );</script>
<script>window._gaq=window._gaq||[];$(window).on("load",function(){window._gaq=window._gaq||[];window.MLLgaq=window.MLLgaq||[];for(var a=0;a<MLLgaq.length;a++){_gaq.push(MLLgaq[a]);}_gaq.push(["_setAccount","UA-10173353-1"]);_gaq.push(["_setDomainName","meilele.com"]);_gaq.push(["_trackPageview"]);var d=document.createElement("script"),b=new Date();d.type="text/javascript";d.async=true;d.defer=true;d.src=$.__IMG+"/zximages/js/dc.js?"+b.getFullYear()+(b.getMonth()+1)+(b.getDate()<10?"0"+b.getDate():b.getDate());var c=document.getElementsByTagName("script")[0];c.parentNode.insertBefore(d,c);});function parseGaData(){_gaq.push([arguments[0],arguments[1],arguments[2],arguments[3]]);}function gaSetActiveUser(b,a){if(!/isActiveUser=1/.test(document.cookie)&&!/ECSCP_ID=/.test(document.cookie)&&!/ECS_MLL_SE=/.test(document.cookie)){_gaq.push(["_trackEvent","ActiveUser",b+"",a+""]);if(window.$&&$.cookie){jQuery.cookie("isActiveUser","1",{domain:location.host,path:"/"});}}}window.bd_cpro_rtid="rHnLnHT";_LOAD_SCRIPT_("http://cpro.baidu.com/cpro/ui/rt.js");_LOAD_SCRIPT_("http://tajs.qq.com/stats?sId=11450600");_LOAD_SCRIPT_("http://tajs.qq.com/gdt.php?sId=23384945");_LOAD_SCRIPT_("http://tajs.qq.com/gdt.php?sId=21253825");_LOAD_SCRIPT_("http://tajs.qq.com/gdt.php?sId=26418742");_LOAD_SCRIPT_("http://tajs.qq.com/gdt.php?sId=43311811");window.goSpread=function(b){window._hmt=window._hmt||[];b=b||window.mllSpreadData||["_trackRTEvent",{data:{}}];var a=["_setAccount","d91942b1e6dd95baed4560c0c6d8071b"];window._hmt.push(a);window._hmt.push(b);return window._hmt;};if(!window.notGoSpread){goSpread();}window.gdt_tracker=window.gdt_tracker||[];window.goGdt=function(a){gdt_tracker.push(["set_source_id","132679"]);for(var b=0;b<a.length;b++){gdt_tracker.push(a[b]);}gdt_tracker.push(["send"]);_LOAD_SCRIPT_("http://qzs.qq.com/qzone/biz/res/gt.js");};(function(a){if(a.notJuXiao){return false;}a._mvq=a._mvq||[];_mvq.push(["$setAccount","m-22687-1"]);_mvq.push(["$logConversion"]);_LOAD_SCRIPT_("https:"==document.location.protocol?"https://static-ssl.mediav.com/mvl.js":"http://static.mediav.com/mvl.js");})(window);if(window.jQuery){jQuery(window).on("load",function(){jQuery.ajax({url:"http://cn-tags.vizury.com/analyze/pixel.php?account_id=VIZVRM1409",dataType:"script",async:true,cache:true,success:function(){window.pixel&&pixel.parse();}});});}(function(){if(Math.random()>0.1||!window.jQuery){return;}$(window).on("load",function(){var g;var c=function(i){var j=$(i);var h=j.parent("a");if(!h&&h.length!=1){return false;}var k=/\/category-.*\/goods-(\d+)\.html/.exec(h.prop("href"));if(k&&k[1]){i.__goodsId=k[1];i.__offsetTop=i._offsetTop||j.offset().top;return k[1];}else{return false;}};var d=function(h){h.__isSendGa=true;window._mllga&&window._mllga({utmac:"UA-53663717-1",utme:"5("+h.__goodsId+"*"+(h.getAttribute("data-src")||h.src)+")"});};var b=document.images;var f=[];for(var a=0,e=b.length;a<e;a++){if(c(b[a])){f.push(b[a]);}}scrollResponse=function(){if(g){clearTimeout(g);}g=setTimeout(function(){var i=window.pageYOffset||document.documentElement.scrollTop||document.body.scrollTop||0;for(var h in f){if(!f[h].__isSendGa&&i+document.documentElement.clientHeight>f[h].__offsetTop&&i<f[h].__offsetTop+(f[h].height||f[h].cilentHeight)){d(f[h]);}}},300);};scrollResponse();$(window).on("scroll",scrollResponse);});})();$(window).on("load",function(){if(!window._mllga){return;}var c=/thg=(.+)&adg=(.+)&adn=(.+)&ado=(.+)&adc=(\d+)/i;var a=function(e){var h=c.exec(e);if(h&&h.length==6){for(var g=1;g<=5;g++){if(h[g]){try{h[g]=decodeURIComponent(h[g].replace("*",""));}catch(f){}}}h.push(window.jQuery&&window.jQuery.cookie("region_name"));return h;}return false;};var d=function(e,f){if(!f){return;}var g="";if(window.getCookie&&getCookie("MLL_CID")){g="8(CID)9("+getCookie("MLL_CID")+")11(2)";}_mllga({utmac:"UA-52467404-2",utmt:"event",utme:"5("+e+"_"+f[1]+"*"+e+"_"+f[2]+"*"+e+"_"+f[3]+"_"+f[4]+"_"+f[6]+")"+g});};if(c.test(location.href)){var b=a(location.href);d("ad_click",b);window._ana&&window._ana.push(["trackEvent","ad_click",b[1],b[2],b[3],b[4],b[6]]);}setTimeout(function(){var j=document.links;var h=[],f;for(var e=0,l=j.length;e<l;e++){f=j[e].getAttribute("href");if(j[e]&&f&&c.test(f)){h.push(a(f));}}for(var g=0;g<h.length;g++){if(h[g]&&Math.random()<0.1){d("ad_show",h[g]);}}},5000);});$(window).on("load",function(){var c=location.search;if(c){c=c.replace("?","").split("&");for(var b=0;b<c.length;b++){if(c[b].indexOf("from=MT")===0){var a=new Image;a.src="/solr_api/mss/message/statistic.do?fromUrl="+encodeURIComponent(location.href);return;}}}});(function(){var a=window.google_tag_params||{ecomm_pagetype:"other"};var c=new Image();var d=[];for(var b in a){d.push("data."+b+"="+encodeURIComponent(a[b]));}var e="//googleads.g.doubleclick.net/pagead/viewthroughconversion/992307345/?value=0&label=_2h2CK-jsgQQkdGV2QM&guid=ON&script=0&"+d.join("&");if(window.jQuery){jQuery(window).on("load",function(){c.src=e;});}else{window.onload=function(){c.src=e;};}})();window.criteo_q=window.criteo_q||[];window.goCriteo=function(c){if(criteo_q.length==0){criteo_q=[{event:"viewHome"}];}var b=window.getCookie&&window.getCookie("ECS[email]");var a=[{event:"setAccount",account:17380},{event:"setCustomerId",id:b||""},{event:"setSiteType",type:"d"}];Array.prototype.push.apply(criteo_q,a);_LOAD_SCRIPT_("http://static.criteo.net/js/ld/ld.js",c);};if(!window.notGoCriteo){goCriteo();}
/*leihao:2017-03-13 17:00:12*/</script>
<script type="text/javascript">
var _dxt = _dxt || [];
_dxt.push(["_setUserId", $.cookie('MLL_CID')]);
$(window).on('load', function() {
    var hm = document.createElement("script");
    hm.src = "//datax.baidu.com/x.js?si=&dm=meilele.com";
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(hm, s);
});
//href跳转至页面固定位置
$(document).ready(function() {
    var achor = location.href.match(/href\=\[(.*)\]/);
    if ( achor && achor[1] ) {
        setTimeout(function(){
            $('html, body').animate({scrollTop: $('#'+achor[1]).offset().top}, 0, 'linear');
        }, 10);         
    }
});
</script>





<script type="text/javascript">
$(document).ready(function () {
    //从接口获取是否显示以及显示版本等信息
    $.ajax({
        url: '/NewFrameEntrance?r=ActiveUserHelper%2FGetActiveUserSetting&var_name=ad_xqyzygg',
        type: 'GET',
        dataType: 'JSON',
        data: {},
        success: function (json) {
            if (json && json.msg) {
                if (json.msg.var_value.split('|').length < 2) {
                    return false;
                }

                //var_value的3个数字分别为浏览深度事件深度的阀值以及延迟显示时间（这次不用这个参数）
                var dataList = json.msg.var_value.split('|'),
                    minCountView = dataList[0],
                    minCountEvent = dataList[1],
                    countView = parseInt($.cookie('countView')),
                    countEvent = parseInt($.cookie('countEvent')),//浏览深度和事件深度从cookie中获取
                    isDepthEnough = (countView >= minCountView || countEvent >= minCountEvent),
                    //判断是否为转盘抽奖的版本
                    isVersionB = (json.data.current_version && json.data.current_version == '2'),
                    // isVersionB = false,
                    _eventType = isVersionB ? '活跃用户_流量转盘' : '活跃用户_流量红包';

                //判断是否登录过后台，如果是则不显示并且保存一个长效cookie
                if ($.cookie('ECSCP_ID')) {
                    _ana.setCookie('isEcscp', 'true', 365);
                }

                //sendSmsPhone可以判断到用户是否通过其他渠道发送过短信，比如体验馆短信和抽奖，如果有则不显示
                if (!$.cookie('sendSmsPhone') && !$.cookie('isEcscp') && isDepthEnough) {
                    if (json.data && (json.data.can_pop == true)) {
                        _gaq.push(['_trackEvent', _eventType, '引入JS前', 'llhb_beforejs']);
                        //异步获取并执行相应的js文件
                        $.ajax({
                            url: 'http://image.meilele.com/js/plugin/hyyh_flux'+(isVersionB? '_b' : '')+'.min.js?1103',
                            type: 'GET',
                            dataType: 'script',
                            success: function () {
                                _gaq.push(['_trackEvent', _eventType, '引入JS后', 'llhb_afterjs']);

                                var hyyhFlux = new HyyhFlux();
                                /**
                                *   leftCount：从后台获取的剩余数量
                                *   bgImg：大背景图片的URL
                                *   bgColor：下方的背景颜色
                                *   iconImg：小图标的背景图片URL
                                *   hintString：首屏提示语
                                *   isAddCart：是否因为加入购物车动作触发
                                */
                                var config = {
                                    leftCount: json.data.left_count,
                                    bgImg: isVersionB ? 'images/201610/1477880982072795239.png' : 'images/201610/1477521228274725555.png',
                                    bgColor: 'bb131f',
                                    iconImg: isVersionB ? 'images/201610/1477881009454167840.gif' : 'images/201610/1477521388430383244.gif',
                                    countView: countView,
                                    countEvent: countEvent,
                                    hintString: json.data.text_string,
                                    isAddCart: isDepthEnough ? false : true
                                }
                                //isShowHyyhLL用于判断是否自动曝光，只自动曝光一次
                                if (!$.cookie('isShowHyyhLL')) {
                                    config.exposure = true;
                                } else {
                                    config.exposure = false;
                                }
                                hyyhFlux.init(config);
                            }
                        });
                    } else {
                        if (json.data.current_version && json.data.current_version == '2') {
                            _gaq.push(['_trackEvent', '活跃用户_流量转盘', '流量转盘_不弹框', 'llzp_btc']);
                            _ana.push(['trackEvent', '活跃用户_流量转盘', '流量转盘_不弹框', '', 'llzp_btc', '', '']);
                        } else {
                            _gaq.push(['_trackEvent', '活跃用户_流量红包', '流量红包_不弹框', 'llhb_btk']);
                            _ana.push(['trackEvent', '活跃用户_流量红包', '流量红包_不弹框', '', 'llhb_btk', '', '']);
                        }
                    }
                }
            }
        }
    });
})
</script>
</body>
</html>


<!--
dengyun*248504:2017-02-09 15:20:38
-->