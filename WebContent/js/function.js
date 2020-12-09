function change(img) {
	CheckItem(img)
	img.src = "getCode?" + new Date().getTime();
}

var id_flag=true;
var pwd_flag=true;
var repwd_flag=true;
var code_flag=true;
function FocusItem(obj) {
	if ($(obj).attr('name') == 'code') {
		$(obj).next().next().html('').removeClass();
	} else {
		$(obj).next('span').html('').removeClass();

	}
}

function CheckItem(obj) {
	var msgBox = $(obj).next('span');
	switch ($(obj).attr('name')) {
	case "user_id":
		if (obj.value == "") {
			msgBox.html("用户名不能为空");
			msgBox.addClass('error')
			id_flag=false;
		} else {
			var url = "usernamecheck?name=" + encodeURI($(obj).val()) + "&"
					+ new Date().getTime();
			$.get(url, function(data) {
				if (data == "false") {
					msgBox.html('用户名已存在');
					msgBox.addClass('error');
					id_flag=false;
				} else if (data == "true") {
					msgBox.html('用户名可以使用');
//					numshow.removeClass('error');
					msgBox.addClass('ok');
					id_flag=true;
				} 
			});
		}
		break;
	case "password":
		if (obj.value == "") {
			msgBox.html('密码不能为空');
			msgBox.addClass('error');
			pwd_flag=false;
		} else if (obj.value.length < 8) {
			msgBox.html('密码至少8位');
			msgBox.addClass('error');
			pwd_flag=false;
		}else{
			msgBox.html('密码可用');
			msgBox.addClass('ok');
			pwd_flag=true;
		}
		break;
	case "repassword":
		if (obj.value == "") {
			msgBox.html('用户确认密码不能为空');
			msgBox.addClass('error');
			repwd_flag=false;
		} else if ($(obj).val() != $('input[name="password"]').val()) {
			msgBox.html('两次密码输入不一致');
			msgBox.addClass('error');
			repwd_flag=false;
		}else{
			msgBox.html('密码可用');
			msgBox.addClass('ok');
			repwd_flag=true;
		}
		break;
	case "code":
		var numshow = $(obj).next().next('span');
		if (obj.value == "") {
			numshow.html('验证码不能为空');
			numshow.addClass('error');
			code_flag=false;
		} else {
			var url = "checkusernum?num=" + encodeURI($(obj).val()) + "&"
					+ new Date().getTime();
			$.get(url, function(numdata) {
				if (numdata == "false") {
					numshow.html('验证码错误');
					numshow.addClass('error');
					code_flag=false;
				} else {
					numshow.html('验证码正确');
					numshow.addClass('ok');
//					numshow.html().removeClass('error');
					code_flag=true;
				}
			});
		}
		break;
	}
}
function CheckLoginItem(obj) {
	var msgBox = $(obj).next('span');
	switch ($(obj).attr('name')) {
	case "user_id":
		if (obj.value == "") {
			msgBox.html("用户名不能为空");
			msgBox.addClass('error')
			id_flag=false;
		} else{
			id_flag=true;
		}
		break;
	case "password":
		if (obj.value == "") {
			msgBox.html('密码不能为空');
			msgBox.addClass('error');
			pwd_flag=false;
		} else if (obj.value.length < 8) {
			msgBox.html('密码至少8位');
			msgBox.addClass('error');
			pwd_flag=false;
		}else{
			pwd_flag=true;
		}
		break;
	
	case "code":
		var numshow = $(obj).next().next('span');
		if (obj.value == "") {
			numshow.html('验证码不能为空');
			numshow.addClass('error');
			code_flag=false;
		} else {
			var url = "checkusernum?num=" + encodeURI($(obj).val()) + "&"
			+ new Date().getTime();
			$.get(url, function(numdata) {
				if (numdata == "false") {
					numshow.html('验证码错误');
					numshow.addClass('error');
					code_flag=false;
				} else {
					numshow.html('验证码正确');
					numshow.addClass('ok');
//					numshow.html().removeClass('error');
					code_flag=true;
				}
			});
		}
		break;
	}
}

function CheckForm1(obj){
	var els=obj.getElementsByTagName('input');
	
	for(var i=0;i<els.length;i++){
		if(els[i]!=null){
			if(els[i].getAttribute("onblur")){
				CheckLoginItem(els[i]);
			}
		}
	}
	return (id_flag&&pwd_flag&&code_flag);
}
function CheckForm(obj){
	var els=obj.getElementsByTagName('input');
	
	for(var i=0;i<els.length;i++){
		if(els[i]!=null){
			if(els[i].getAttribute("onblur")){
				CheckItem(els[i]);
			}
		}
	}
	return (id_flag&&pwd_flag&&repwd_flag&&code_flag);
}