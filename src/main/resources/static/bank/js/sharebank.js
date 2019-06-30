$(function(){

	/*将还未添加至题库的被分享题库添加至题库*/
	$(".addShareToBank").on("click",function(){
		console.log("我要添加至题库");
		var bankId = $(this).attr("data-thisBank-id");
		console.log("而我要添加的是",bankId);
		var that = $(this);

    	var u = {"bankId":bankId};

		$.ajax({
			type:'get',
	        url:'/addShareToBank',
	        contentType:'application/json;charset=utf-8',
	        data:u,
	        dataType:"text",    
	        success:function(data){
	        	console.log("将分享添加到题库",data);
	        	if(1 == data){
	        		that.attr("class","btn btn-success btn-sm");
	        		that.children("i").attr("class","fa fa-check fa-2x bankConfirmed");
	        		that.children("i").attr("title","已添加至题库");
	        	}
	        },
	        error:function(){
	            alert('用户题库分享异步提交失败');
	        }
		});
	});
	/*将还未添加至题库的被分享题库添加至题库结束*/

	/*处理点击修改权限按钮之后，获取展示模态框时需要的信息，并为模态框绑定数据*/
	$(".setShreButton").on('click',function(){
		var bankId = $(this).attr("data-thisBank-id");
		var userId = $(this).attr("data-thisUser-id");
		$("#setShareModal").attr("data-the-bank",bankId);
    	$("#setShareModal").attr("data-the-userid",userId );
		console.log("分享给用户"+userId+"的题库"+bankId+"绑到模态框上");
		
		var u = {"bankId":bankId,"userId":userId};

		$.ajax({
			type:'get',
	        url:'/getInfoForModal',
	        contentType:'application/json;charset=utf-8',
	        data:u,
	        dataType:"text",    
	        success:function(data){
	        	var map = JSON.parse(data);
	        	console.log("获取模态框中要求的数据-json:",map);
	        	var namePart = map.user.name+'（'+map.user.mail+'）';
	        	var auts = map.auts;
	        	console.log("auts:",auts);
	        	$("#shareToUser").html(namePart);
	        	$("#sharedBankName").html(map.bank.name);
	        	var count=0;
	        	$("div[data-aut-selected]").each(function(){
	        		var aut = auts[count];
	        		var that = $(this);
	        		if(1 == aut){
	        			var i = that.children('span').children('i');
						console.log("i",i);
						i.attr("class","fa fa-check-square-o fa-lg");
						that.attr("data-aut-selected",1);
	        		}
	        		console.log("times:",count);
	        		count++;

	        	});
	        },
	        error:function(){
	            alert('用户题库分享异步提交失败');
	        }
		});
	});
	/*处理点击修改权限按钮之后，获取展示模态框时需要的信息，并为模态框绑定数据结束*/

	/*处理权限标签更改事件*/
	$("div[data-aut-selected]").on("click",function(){
		var that = $(this);
		var label = that.attr("data-aut-selected");
		console.log("点击权限选项div,label:",label);
		
		if(-1 == label){
			// .attr('class',"fa fa-check-square-o fa-lg") .fa fa-square-o fa-lg
			var i = that.children('span').children('i');
			console.log("i",i);
			i.attr("class","fa fa-check-square-o fa-lg");
			that.attr("data-aut-selected",1);
		}else{
			var i = that.children('span').children('i');
			console.log("i",i);
			i.attr("class","fa fa-square-o fa-lg");
			that.attr("data-aut-selected",-1);
		}	
	});
	/*处理权限标签更改事件结束*/

	/*处理权限更改事件*/
	$("#settingConfirm").on('click',function(){
		var bankId = $("#setShareModal").attr("data-the-bank");
    	var userId = $("#setShareModal").attr("data-the-userid");
		var auths = $("div[data-aut-selected]");
    	var array = new Array();
    	auths.each(function(){
    		// console.log("this:",this)
    		if(1 == $(this).attr("data-aut-selected")){
    			array.push(1);
    		}else{
    			array.push(0);
    		}
    	});
    	var arrayJson = JSON.stringify(array);



    	var u = {"bankId":bankId,"userId":userId,"arrayJson":arrayJson};

		$.ajax({
			type:'get',
	        url:'/setShareAut',
	        contentType:'application/json;charset=utf-8',
	        data:u,
	        dataType:"text",    
	        success:function(data){
	        	
	        },
	        error:function(){
	            alert('用户题库分享异步提交失败');
	        }
		});


		// var h3 = $("h3[data-bank-id="+bankId+"]");
		// console.log("h3:",h3);
		// h3.html("<label>权限更新中...</label>");

    	console.log("设置用户"+userId+"的被分享的题库"+bankId+"的权限为"+arrayJson);
    	/*清空处理*/
    	auths.each(function(){
    		$(this).children('span').children('i').attr("class","fa fa-square-o fa-lg");
    		$(this).attr("data-aut-selected",-1);
    	});
	});

	$("#settingCancel").on("click",function(){
		var i = $("div[data-aut-selected]").children("span").children('i');
		i.attr('class',"fa fa-square-o fa-lg");
	})
	/*处理权限更改事件结束*/

	/*处理取消分享操作*/
	$(".cancelShare").on('click',function(){
		$("#cancelShareModal").attr("data-the-bank",$(this).attr("data-thisBank-id"));
		$("#cancelShareModal").attr("data-the-userid",$(this).attr("data-thisUser-id"));
	});

	$("#confirmCancelShare").on("click",function(){
		var bankId = $("#cancelShareModal").attr("data-the-bank");
		var userId = $("#cancelShareModal").attr("data-the-userid");

		var u = {"bankId":bankId,"userId":userId};

		$.ajax({
			type:'get',
	        url:'/cancelShare',
	        contentType:'application/json;charset=utf-8',
	        data:u,
	        dataType:"text",    
	        success:function(data){
	        	console.log("cancelShare data:",data);
	        	if("ok"==data){
	        		$("#"+userId+"_"+bankId).remove();
	        	}
	        },
	        error:function(){
	            alert('用户题库分享异步提交失败');
	        }
		});

		console.log("取消对用户"+userId+"的对于题库"+bankId+"的分享");
	});
	/*处理取消分享操作结束*/

	var pager = $('#pager').pagination({
        mode: 'fixed',
        pageIndex: 0, //当前页数
        totlePageCount: 16, //总页数
        maxBtnCount: 7 //按钮数量最多有
    });
})