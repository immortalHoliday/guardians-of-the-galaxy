$(function(){

	// 处理彻底删除事件
	$(".destoryA").on('click',function(){
		var bankId = $(this).parents("div[id*='bank']").attr("data-bank-id");
		console.log("destortA bankId:",bankId);
		$("#sureToDelete").attr("data-the-bank",bankId);
	});

	/*此方法回收站中的题库和归档站中的题库都可以使用，都可以用此方法彻底删除*/
	$("#destoryButton").on('click',function(){
		var bankId = $("#sureToDelete").attr("data-the-bank");
		console.log("destoryButton bankId:",bankId);

		var u = {"bankId":bankId};

		$.ajax({
			type:'get',
	        url:'/bankDestoryById',
	        contentType:'application/json;charset=utf-8',
	        data:u,
	        dataType:"text",    
	        success:function(data){
	        	if(data == "ok"){
	        		// 在页面中删除当前题库
	        		$("#bank_"+bankId).remove();
	        	}
	        },
	        error:function(){
	            alert('彻底删除题库异步提交失败');
	        }
		});
	});
	// 处理彻底删除事件结束

	// 处理恢复题库事件
	$(".recoverA").on('click',function(){
		var bankId = $(this).parents("div[id*='bank']").attr("data-bank-id");
		console.log("recoverA bankId:",bankId);
		$("#sureToRecover").attr("data-the-bank",bankId);
	});


	/*此方法-回收站和归档站都可以使用，都可以通过此方法恢复题库*/
	$("#recoverButton").on('click',function(){
		var bankId = $("#sureToRecover").attr("data-the-bank");
		console.log("recoverButton bankId:",bankId);

		var u = {"bankId":bankId};

		$.ajax({
			type:'get',
	        url:'/bankRecoverById',
	        contentType:'application/json;charset=utf-8',
	        data:u,
	        dataType:"text",    
	        success:function(data){
	        	if(data == "ok"){
	        		// 在页面中删除当前题库
	        		$("#bank_"+bankId).remove();
	        	}
	        },
	        error:function(){
	            alert('恢复题库异步提交失败');
	        }
		});
	});
	// 处理恢复题库事件结束

	// 处理清空回收站事件
	$("#clearRecycleButton").on("click",function(){
		console.log("清空回收站，你真是个狼灭");

		$.ajax({
			type:'get',
	        url:'/recycleClear',   
	        success:function(data){
	        	if(data == "ok"){
	        		// 在页面中删除当前题库
	        		$("#bankContainer").empty();
	        	}else{
	        		alert("回收站为空");
	        	}
	        },
	        error:function(){
	            alert('清空回收站异步提交失败');
	        }
		});

	});
	// 处理清空回收站事件结束

	// 处理恢复全部题库操作
	$("#recoverAllButton").on("click",function(){
		console.log("恢复所有题库，你也还是个狼灭");

		$.ajax({
			type:'get',
	        url:'/recycleRecoverAll',   
	        success:function(data){
	        	if(data == "ok"){
	        		// 在页面中删除当前题库
	        		$("#bankContainer").empty();
	        	}else{
	        		alert("回收站为空，没有可以恢复的题库");
	        	}
	        },
	        error:function(){
	            alert('恢复所有题库异步提交失败');
	        }
		});

	});
	// 处理恢复全部题库操作结束


	/*以下处理从归档题库删除题库到回收站中*/
	$(".recycleA").on("click",function(){
		// console.log("bankContainer removeA:",$(this).length);
		var $bankdiv = $(this).parents("div[id*='bank']");
		var id2 = $bankdiv.attr('id').split("_")[1];
		// console.log("removeA id2:",id2);
		console.log("在归档题库删除题库",id2);
		$("#sureToRecycle").attr("data-the-bank",id2);
	});

	// 绑定删除到回收站操作
	$("#recycleButton").on('click',function(){
		
		var bankid = $("#sureToRecycle").attr("data-the-bank");
		console.log("归档站 recycleBank bankid:",bankid);
		var u = {"bankId":bankid};

		$.ajax({
			type:'get',
	        url:'/bankIntoRecycle',
	        contentType:'application/json;charset=utf-8',
	        data:u,
	        dataType:"text",    
	        success:function(data){
	        	if(data == "ok"){
	        		// 在页面中删除当前题库
	        		$("#bank_"+bankid).remove();
	        	}
	        },
	        error:function(){
	            alert('删除到回收站异步提交失败');
	        }
		});
	});
})