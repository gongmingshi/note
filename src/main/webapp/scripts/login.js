$(function(){
	$('#login').click(loginAction);
	$('#count').blur(checkname);
	$('#password').blur(checkpwd);
});
function checkname(){
	var name=$('#count').val();
	var rule=/^\w{4,10}$/;
	if(!rule.test(name)){
		$('#count').next().html('4~10个字符！');
		return false;
	}
	$('#count').next().empty();
	return true;
}

function checkpwd(){
	var name=$('#password').val();
	var rule=/^\w{4,10}$/;
	if(!rule.test(name)){
		$('#password').next().html('4~10个字符！');
		return false;
	}
	$('#password').next().empty();
	return true;
}

function loginAction(){
	var name=$('#count').val();
	var password=$('#password').val();
	var n=checkname()+checkpwd();
	if(n!=2){
		return;
	}
	console.log(name+password);
	var data={"name":name,"password":password}
	$.ajax({
		url:'user/login.do',
		type:'post',
		data:data,
		dataType:'json',
		success:function(data){
			console.log(data)
			if(data.state==0){
				console.log(data.data);
				$('#msg').html("登陆成功！");
				location.href="edit.html"; 
			}else{
				$('#msg').html(data.message);
			}
		},
		error:function(e){
			alert("通信失败！");
		}
	});	
}