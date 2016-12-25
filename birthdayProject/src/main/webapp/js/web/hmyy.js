var isBirthday=false;//是否过生日
var user="";//登录人姓名
var blePersonPnum="";//登录人手机号
app.controller("app",function($scope,$location,$http,$rootScope)
{
	$rootScope.check=function()
	{
		if(!isBirthday)
		{
			$location.path("/index");
			return false;
		}
		return true;
	}
	//修改密码接口
	var passChange="/birthday/user/editPass.do";
	$scope.moreMsgList={};
	$scope.next_Handler=function(url)
	{
		$('.in').remove();
		$location.path("/"+url);
	}
	$scope.login=function()
	{
		var userName=document.getElementById("userName").value;
		var pasword=document.getElementById("pasword").value;
		function login_back(data)
		{
			$scope.$apply(function(){
				if(data.result!='SUCCESS')
				{
					alert(data.info);
					return;
				}
				isBirthday=data.userinfo.isBirthday;
				user=data.userinfo.workName;
				blePersonPnum=data.userinfo.phoneNum;
				setCookie("userName",data.userinfo.workName);
				setCookie("isBirthday",isBirthday);
				setCookie("blePersonPnum",blePersonPnum);
				$("#login").modal("hide");
				if(data.userinfo.isfirstLogin=='01'||data.userinfo.isfirstLogin=='1')
				{
					document.getElementById("newPas").value="";
					document.getElementById("newPas1").value="";
					$("#firstChangePass").modal("toggle");
					return;
				}
				if(data.userinfo.isfirstLogin=='02'||data.userinfo.isfirstLogin=='2'){
					if(data.userinfo.isBirthday)
					{
						$('.in').remove();
						$("#lottery").modal("toggle");
					}else{
						$('.in').remove();
						$location.path("/companyBenediction");
						//angular.element(document.querySelector('[ng-controller=login]')).scope().cb_path();
					}
				}
			})
		}
		$.post("/birthday/user/login.do",{'userName':userName,'password':pasword},login_back,'json');
		//修改密码
		$scope.pasChange=function()
		{
			var newPas=document.getElementById("newPas").value;
			var newPas1=document.getElementById("newPas1").value;
			if(newPas==pasword)
			{
				alert("新密码不能与原密码相同");
				return;
			}
			if(newPas==="")
			{
				alert("新密码不能为空");
				return;
			}
			if(newPas!=newPas1)
			{
				alert("两次密码输入不同,请重新输入");
				return;
			}
			
			function bck(data)
			{
				if(data.result=="SUCCESS")
				{
					alert("密码修改成功,请重新登录");
					$("#firstChangePass").modal("hide");
				}else{
					alert(data.info);
				}
			}
			var par={"userName":userName,"oldPass":pasword,"newPass":newPas}
			$.post(passChange,par,bck,"json");
		}
	}
})
//首页登录
app.controller("login",function($scope,$location,$http,$rootScope)
{
	$scope.login_Handler=function()
	{
//		$location.path("/companyBenediction");
		document.getElementById("userName").value="";
		document.getElementById("pasword").value="";
		$("#login").modal("toggle");
	}
	$scope.cb_path=function()
	{
		$location.path("/companyBenediction");
	}
	$scope.birthday=function()
	{
		$("#lottery").modal("toggle");
	}
})

//公司祝福
app.controller('companyBenediction',function($scope,$location)
{
	setBodyClass(["bckRed"]);
	if(user==""||blePersonPnum==""){
		$location.path("/index");
		return;
	}
})
//我想对他说
app.controller("iWantSay",function($scope,$location)
{
	if(user==""||blePersonPnum==""){
		$location.path("/index");
		return;
	}
	setBodyClass(["bck-yellow"]);
})
//本月寿星
app.controller("longevity",function($scope,$location,$rootScope)
{
	if(user==""||blePersonPnum==""){
		$location.path("/index");
		return;
	}
	//本月所有生日人相关信息及留言(2条)
	var allBirthday="/birthday/blessing/limit.do";
	$scope.birthlimits;
	setBodyClass(["longevity-back-img","longevity-back-set"]);
	function init(data)
	{
		$scope.$apply(function()
		{
			if(data.result!="SUCCESS")
			{
				alert(data.info);
				return;
			}
			for(var i=0;i<data.birthlimits.length;i++)
			{
				if(data.birthlimits[i].limit2Blessing.length==0)
				{
					data.birthlimits[i].more=false;
				}else{
					data.birthlimits[i].more=true;
				}
//				data.birthlimits[i].more=true;
			}
			$scope.birthlimits=data.birthlimits;
		})
		
	}
	var par={};
	$.post(allBirthday,par,init,"json");
	//点击更多按钮时处理函数
	$scope.moreMsg=function(x)
	{
		var s=angular.element(document.querySelector('[ng-controller=app]')).scope().moreMsgList=x;
		$location.path("/msg");
	}
	//点击信息框时处理函数
	$scope.lyMsg_Handler=function(x)
	{
		$scope.userMsg=x;
		$("#longevity").modal("toggle");
	}
	$scope.upMsg=function()
	{
		
		//留言接口
		var msgUrl="/birthday/blessing/add.do";
		var txt=$("#lvy-textarea").val();
		function bck(data)
		{
			$scope.$apply(function(){
			
				$scope.userMsg.limit2Blessing[1]=$scope.userMsg.limit2Blessing[0];
				var obj={'blePerson': getCookie("userName"),'bleContent': txt};
				$scope.userMsg.limit2Blessing[0]=obj;
			});
		}
		if(txt=="")
		{
			$("#longevity").modal("hide");
			return;
		}
//		console.log("$scope.userMsg==",$scope.userMsg);
		var par={birthPerson:$scope.userMsg.workName,birthPersonPnum:$scope.userMsg.phoneNum,blePerson:getCookie("userName"),bleContent:txt}
		$.post(msgUrl,par,bck,"json");
		$("#longevity").modal("hide");
		$("#lvy-textarea").val("");
	}
	
	//点击下一页按钮时处理函数
	$scope.gotoNext=function()
	{
		if(isBirthday)
		{
			$location.path("/lottery");
		}
	}
})
//留言板
app.controller('msg',function($scope,$location)
{
	if(user==""||blePersonPnum==""){
		$location.path("/index");
		return;
	}
//	console.log('moreMsgList==',$scope.moreMsgList)
	var p=$scope.moreMsgList.phoneNum;//过生日人的手机号
	$scope.msgBack=function()
	{
		$location.path("/longevity");
	}
	setBodyClass([]);
	function msg_Handler(data)
	{
		if(data.result!="SUCCESS")
		{
			alert(data.info);
			return;
		}
		$scope.$apply(function()
		{
			$scope.list=data.blessings;
		})
//		console.log(data)
	}
	var par={birthPersonPnum:p}//*******************************
	$.post("/birthday/blessing/all.do",par,msg_Handler,"json");
})
//活动说明
app.controller('explain',function($scope,$location,$rootScope)
{
	if(!$rootScope.check()||user==""){
		return;
	}
	$("body").addClass("bckRed");
	//获取用户是否点过赞(包含过生日形式满意度,奖品满意度)  及点赞数量
	function countBck(data)
	{
		$scope.$apply(function()
		{
			//生日形式赞同
			$scope.activeEndorse=data.praCount.activeEndorse;
			//生日形式不赞同
			$scope.activeOppose=data.praCount.activeOppose;
			
			//奖品赞同
			$scope.prizeEndorse=data.praCount.prizeEndorse;
			//奖品不赞同
			$scope.prizeOppose=data.praCount.prizeOppose;
		});
	}
	var countPar={userName:getCookie("blePersonPnum")};
	$.post("/birthday/praise/count.do",countPar,countBck,"json");
})
app.controller("lottery",function($scope,$location,$rootScope)
{
	if(!$rootScope.check()||user==""){
		return;
	}
	var turnplate={
					restaraunts:[],				//大转盘奖品名称
					colors:[],					//大转盘奖品区块对应背景颜色
					outsideRadius:192,			//大转盘外圆的半径
					textRadius:155,				//大转盘奖品位置距离圆心的距离
					insideRadius:68,			//大转盘内圆的半径
					startAngle:0,				//开始角度
					bRotate:false				//false:停止;ture:旋转
				};
	$scope.init=function(data)
	{
//		console.log(data);
		if(data.result!="SUCCESS")
		{
			alert(data.info);
			return;
		}
		var arr=[];
		var imgArr=["../../imgs/master/prize/projector.png","../../imgs/master/prize/bed.png","../../imgs/master/prize/humidifier.png","../../imgs/master/prize/cup.png","../../imgs/master/prize/liquor.png"];
		for(var i=0;i<data.prizes.length;i++)
		{
			arr.push(data.prizes[i].prizeName)
		}
		//动态添加大转盘的奖品与奖品区域背景颜色
		turnplate.restaraunts = arr;//["50M免费流量包", "10闪币", "谢谢参与", "5闪币", "10M免费流量包", "20M免费流量包", "20闪币 ", "30M免费流量包", "100M免费流量包", "2闪币"];
		turnplate.colors = ["#FFF4D6", "#FFFFFF", "#FFF4D6", "#FFFFFF","#FFF4D6", "#FFFFFF", "#FFF4D6", "#FFFFFF","#FFF4D6", "#FFFFFF"];
//		console.log(arr);
		var rotateTimeOut = function (){
			$('#wheelcanvas').rotate({
				angle:0,
				animateTo:2160,
				duration:8000,
				callback:function (){
					alert('网络超时，请检查您的网络设置！');
				}
			});
		};
	
		//旋转转盘 item:奖品位置; txt：提示语;
		var rotateFn = function (item, txt){
			var angles = item * (360 / turnplate.restaraunts.length) - (360 / (turnplate.restaraunts.length*2));
			if(angles<270){
				angles = 270 - angles; 
			}else{
				angles = 360 - angles + 270;
			}
			$('#wheelcanvas').stopRotate();
			$('#wheelcanvas').rotate({
				angle:0,
				animateTo:angles+1800,
				duration:8000,
				callback:function (){
					$("#lottery").modal("toggle");
//					alert(txt);
					turnplate.bRotate = !turnplate.bRotate;
				}
			});
		};
		$(".pointer").click(function(){
			if(turnplate.bRotate)return;
			var par={'phoneNum':getCookie("blePersonPnum"),'name':getCookie("userName")};
			$.post("/birthday/winPrize/lucky.do",par,bck,"json");
			
		})
		function bck(data)
		{
			if(data.result!="SUCCESS")
			{
				alert(data.info);
				return;
			}
			turnplate.bRotate = !turnplate.bRotate;
			//获取随机数(奖品个数范围内)
			var item = rnd(Number(data.prizeinfo.id),turnplate.restaraunts.length);
			//奖品数量等于10,指针落在对应奖品区域的中心角度[252, 216, 180, 144, 108, 72, 36, 360, 324, 288]
			rotateFn(Number(data.prizeinfo.id), turnplate.restaraunts[item]);
			$scope.$apply(function()
			{
				$scope.imgUrl=imgArr[Number(data.prizeinfo.id)-1];
				$scope.prizeMsg=arr[Number(data.prizeinfo.id)-1];
			})
			
//			console.log(item);
		}
		$scope.drawRouletteWheel();
	}
	function rnd(n, m){
		var random = Math.floor(Math.random()*(m-n+1)+n);
		return random;
	}
	
	$scope.drawRouletteWheel=function()
	{
	  var canvas = document.getElementById("wheelcanvas");    
	  if (canvas.getContext) {
		  //根据奖品个数计算圆周角度
		  var arc = Math.PI / (turnplate.restaraunts.length/2);
		  var ctx = canvas.getContext("2d");
		  //在给定矩形内清空一个矩形
		  ctx.clearRect(0,0,422,422);
		  //strokeStyle 属性设置或返回用于笔触的颜色、渐变或模式  
		  ctx.strokeStyle = "#FFBE04";
		  //font 属性设置或返回画布上文本内容的当前字体属性
		  ctx.font = '16px Microsoft YaHei';      
		  for(var i = 0; i < turnplate.restaraunts.length; i++) {       
			  var angle = turnplate.startAngle + i * arc;
			  ctx.fillStyle = turnplate.colors[i];
			  ctx.beginPath();
			  //arc(x,y,r,起始角,结束角,绘制方向) 方法创建弧/曲线（用于创建圆或部分圆）    
			  ctx.arc(211, 211, turnplate.outsideRadius, angle, angle + arc, false);    
			  ctx.arc(211, 211, turnplate.insideRadius, angle + arc, angle, true);
			  ctx.stroke();  
			  ctx.fill();
			  //锁画布(为了保存之前的画布状态)
			  ctx.save();   
			  
			  //----绘制奖品开始----
			  ctx.fillStyle = "#E5302F";
			  var text = turnplate.restaraunts[i];
			  var line_height = 17;
			  //translate方法重新映射画布上的 (0,0) 位置
			  ctx.translate(211 + Math.cos(angle + arc / 2) * turnplate.textRadius, 211 + Math.sin(angle + arc / 2) * turnplate.textRadius);
			  
			  //rotate方法旋转当前的绘图
			  ctx.rotate(angle + arc / 2 + Math.PI / 2);
			
			if(text.length>6&&text.length<=18){//奖品名称长度超过一定范围
				  text = text.substring(0,6)+"||"+text.substring(6);
				  var texts = text.split("||");
				  for(var j = 0; j<texts.length; j++){
					  ctx.fillText(texts[j], -ctx.measureText(texts[j]).width / 2, j * line_height);
				  }
			  }else if(text.length>18)
			  {
			  	text = text.substring(0,12)+"||"+text.substring(12);
				  var texts = text.split("||");
				  for(var j = 0; j<texts.length; j++){
					  ctx.fillText(texts[j], -ctx.measureText(texts[j]).width / 2, j * line_height);
				  }
			  }else {
				  //在画布上绘制填色的文本。文本的默认颜色是黑色
				  //measureText()方法返回包含一个对象，该对象包含以像素计的指定字体宽度
				  ctx.fillText(text, -ctx.measureText(text).width / 2, 0);
			  }
			  //把当前画布返回（调整）到上一个save()状态之前 
			  ctx.restore();
			  //----绘制奖品结束----
		  }     
	  } 
	}
	$.post("/birthday/winPrize/prizes.do","",$scope.init,"json");
//	$scope.init
//	$scope.drawRouletteWheel();
//	$("#lottery").modal("toggle");
	setBodyClass(["ly-bck"]);
	function monthBck(data)
	{
		$scope.$apply(function()
		{
			if(data.result!="SUCCESS")
			{
				alert(data.info);
				return;
			}
			$scope.monthList=data.winPrizes;
		})
	}
	//当月生日的所有用户抽奖中奖信息
	$.post("/birthday/winPrize/month.do","",monthBck,"json");
	
	
	//获取用户是否点过赞(包含过生日形式满意度,奖品满意度)  及点赞数量
	function countBck(data)
	{
		$scope.$apply(function()
		{
			//生日形式赞同
			$scope.activeEndorse=data.praCount.activeEndorse;
			//生日形式不赞同
			$scope.activeOppose=data.praCount.activeOppose;
			
			//奖品赞同
			$scope.prizeEndorse=data.praCount.prizeEndorse;
			//奖品不赞同
			$scope.prizeOppose=data.praCount.prizeOppose;
			
			//生日形式满意度是否点过赞
			$scope.isActivePra=data.isActivePra;
			//奖品满意度是否点过赞
			$scope.isPrizePra=data.isPrizePra;
			
			$scope.satisficing={};//点赞参数记录
			$scope.satisficing.activeState=$scope.isActivePra;
			$scope.satisficing.prizeState=$scope.isPrizePra;
		});
	}
	var countPar={userName:getCookie("blePersonPnum")};
	$.post("/birthday/praise/count.do",countPar,countBck,"json");
	
	//用户过奖形式点赞
	$scope.active=function(n)
	{
		if($scope.satisficing.activeState!=undefined&&$scope.satisficing.activeState)
		{
			alert("您已经参与过评价,不能再次评论");
			return;
		}
		if(n==0)
		{
			$scope.activeOppose=Number($scope.activeOppose)+1;
			$scope.satisficing.active="02";
		}else{
			$scope.activeEndorse=Number($scope.activeEndorse)+1;
			$scope.satisficing.active="01";
		}
		$scope.satisficing.activeState=true;
	}
	
	$scope.prize=function(n)
	{
		var par={};
		if($scope.satisficing.prizeState!=undefined&&$scope.satisficing.prizeState)
		{
			alert("您已经参与过评价,不能再次评论");
			return;
		}
		if(n==0)
		{
			$scope.prizeOppose=Number($scope.prizeOppose)+1;
			$scope.satisficing.prize="02";
		}else{
			$scope.prizeEndorse=Number($scope.prizeEndorse)+1;
			$scope.satisficing.prize="01";
		}
		$scope.satisficing.prizeState=true;
	}
	$scope.isEndorse=function()
	{
		if(!$scope.isActivePra)
		{
			activeRequest();
		}
		if(!$scope.isPrizePra)
		{
			prizeRequest();
		}
		$("#satisficing").modal("hide");
		$('.in').remove();
		$location.path("/explain");
	}
	function activeRequest()
	{
		function activeBck(data)
		{
//			console.log("activeBck===",data);
		}
		var par={};
		par.isEndorse=$scope.satisficing.active;
		par.userName=getCookie("blePersonPnum");
		//用户过奖形式点赞
		$.post("/birthday/praise/active/add.do",par,activeBck,"json");
	}
	function prizeRequest()
	{
		function activeBck(data)
		{
//			console.log("activeBck===",data);
		}
		var par={};
		par.isEndorse=$scope.satisficing.prize;
		par.userName=getCookie("blePersonPnum");
		//奖品满意度点赞接口
		$.post("/birthday/praise/prize/add.do",par,activeBck,"json");
	}
	//中奖弹窗点击确定按钮处理函数
	$scope.goSatisficing=function()
	{
		$("#lottery").modal("hide");
		$(".in").remove();
		$("#satisficing").modal("toggle");
	}
	
})


function setBodyClass(cls)
{
	$("body").removeClass();
	for(var i=0;i<cls.length;i++)
	{
		$("body").addClass(cls[i]);
	}
}
function getCookie(key)
{
	var arr=document.cookie.split(",");
	var tempArr=[];
	var str="";
	for(var i=0;i<arr.length;i++)
	{
		tempArr=arr[i].split(':');
		if(tempArr[0]==key)
		{
			str=tempArr[1];
		}
	}
	return str;
}
function setCookie(key,val)
{
	var coo=document.cookie;
	var arr=coo.split(",");
	var tempArr=[];
	var state=false;
	
	a:for(var i=0;i<arr.length;i++)
	{
		tempArr=arr[i].split(":");
		if(tempArr[0]==key)
		{
			tempArr[1]=val;
			state=true;
			arr[i]=tempArr[0]+":"+tempArr[1];
			document.cookie=arr.join(",");
			break a;
		}
	}
	if(!state)
	{
		var value=key+":"+val+",";
		coo+=value;
		document.cookie=coo;
	}
}
function check()
{
//	console.log(getCookie("userName"));
	var d=new Date();
	d=d.getTime();
	var ct=Number(getCookie("timestamp"));
	var c=d-ct;
	c=c/1000/60;
	console.log("c==",c);
	if(c>=30)
	{
		
	}
	var flag=false;
	if(getCookie("isBirthday")=="true")
	{
		flag=true;
	}else{
		flag=false;
	}
	return flag;
}
