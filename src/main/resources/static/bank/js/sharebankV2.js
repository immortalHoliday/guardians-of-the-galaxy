$(function(){

	var pager = $('#pagerFromMe').pagination({
        mode: 'fixed',
        pageIndex: 0, //当前页数
        totlePageCount: 16, //总页数
        maxBtnCount: 7 //按钮数量最多有
    });

	var pager = $('#pagerToMe').pagination({
        mode: 'fixed',
        pageIndex: 0, //当前页数
        totlePageCount: 16, //总页数
        maxBtnCount: 7 //按钮数量最多有
    });

	//设定每页显示的数量
    var pagesize = 2;

	// 其实已经显示了，但是为了开始这个环，还需要在加载一次
    loadPage(1);

	/*pno表示pagenumber，显示的是哪一页*/
	function loadPage(pnum){
		$.ajax({
			type:'get',
	        url:'/initPagination',
	        contentType:'application/json;charset=utf-8',
	        data:{
				"pageSize":pagesize,  //我把行数传回给服务器中
				"pageNum":pnum  //显示第几页的数据
			},
	        dataType:"text",    
	        success:function(data){

	        	// console.log("data:",data);
	        	var map = JSON.parse(data);
	        	console.log("map:",map);
	        	
				var toMeList = map.toMeList;
				console.log("toMeList:",toMeList);
				
				var fromMeList = map.fromMeList;
				console.log("fromMeList:",fromMeList);

				var fromMeMap = map.fromMeMap;
				var toMeMap = map.toMeMap;
				console.log("fromMeMap:",fromMeMap);
				console.log("toMeMap:",toMeMap);

				var fromMeItemList = map.fromMeItemList;
				var toMeItemList = map.toMeItemList;
				console.log("fromMeItemList:",fromMeItemList);
				console.log("toMeItemList:",toMeItemList);

				//获取总条数
				var toMeSumCount = toMeList.total;
				var fromMeSumCount = fromMeList.total;

				console.log("toMeSumCount:"+toMeSumCount+"  fromMeSumCount:"+fromMeSumCount);

				//获取返回的条数
				var toMeCount = toMeList.size;
				var frmoMeCount = fromMeList.size;

				console.log("toMeCount:"+toMeCount+"  frmoMeCount:"+frmoMeCount);
	        
				var toMe=Math.ceil(toMeSumCount/pagesize);
				var fromMe=Math.ceil(fromMeSumCount/pagesize);

				$("#fromMeBody").empty();
						
				for(var i=0; i<fromMeList.size; i++){
					var innerHtml = "<tr id="+fromMeItemList[i].toUser.id+"'_'"+fromMeItemList[i].toUser.id+">"; 
					innerHtml += "<th scope='row'><h3>"+fromMeItemList[i].bank.name+"</h3></th><td><h3>";
					if(1 == fromMeMap[fromMeItemList[i].toUser.id+'_'+fromMeItemList[i].bank.id+'_'+1]){
						innerHtml+="<label> 添加题目 </label>&nbsp";
					}
					if(1 == fromMeMap[fromMeItemList[i].toUser.id+'_'+fromMeItemList[i].bank.id+'_'+2]){
						innerHtml+="<label> 修改题目 </label>&nbsp";
					}
					if(1 == fromMeMap[fromMeItemList[i].toUser.id+'_'+fromMeItemList[i].bank.id+'_'+3]){
						innerHtml+="<label> 删除题目 </label>&nbsp";
					}
					if(0 == fromMeMap[fromMeItemList[i].toUser.id+'_'+fromMeItemList[i].bank.id+'_'+1] && 0 ==fromMeMap[fromMeItemList[i].toUser.id+'_'+fromMeItemList[i].bank.id+'_'+2] && 0 == fromMeMap[fromMeItemList[i].toUser.id+'_'+fromMeItemList[i].bank.id+'_'+3]){
						innerHtml+="<label> 未授予权限 </label>&nbsp";
					}
					innerHtml+="</h3></td><td><h3>"+fromMeItemList[i].toUser.name+"</h3></td><td>";

					innerHtml+="<button data-toggle='modal' data-target='#setShareModal' type='button' class='btn btn-info btn-sm setShreButton' data-placement='top' title='分享设置' data-thisBank-id="+fromMeItemList[i].bank.id+" data-thisUser-id="+fromMeItemList[i].toUser.id+"><i class='fa fa-cog fa-lg sharedBankSetting' aria-hidden='true'></i></button>";
					innerHtml+="<button data-toggle='modal' data-target='#cancelShareModal' type='button' class='btn btn-danger btn-sm cancelShare' data-placement='top' title='撤销分享' data-thisBank-id="+fromMeItemList[i].bank.id+" data-thisUser-id="+fromMeItemList[i].toUser.id+"><i class='fa fa-trash-o fa-lg' aria-hidden='true'></i></button>";
					innerHtml+="</td></tr>";
					$("#fromMeBody").append(innerHtml);
				}

				$("#toMeBody").empty();

				for(var i=0; i<toMeList.size; i++){
					var innerHtml = "<tr><th scope='row' ><h3>"+toMeItemList[i].bank.name+"</h3></th><td>"; 
					innerHtml +="<h3 data-bank-id="+toMeItemList[i].bank.id+">"
					if(1 == toMeMap[toMeItemList[i].fromUser.id+'_'+toMeItemList[i].bank.id+'_'+1]){
						innerHtml+="<label> 添加题目 </label>&nbsp";
					}
					if(1 == toMeMap[toMeItemList[i].fromUser.id+'_'+toMeItemList[i].bank.id+'_'+2]){
						innerHtml+="<label> 修改题目 </label>&nbsp";
					}
					if(1 == toMeMap[toMeItemList[i].fromUser.id+'_'+toMeItemList[i].bank.id+'_'+3]){
						innerHtml+="<label> 删除题目 </label>&nbsp";
					}
					if(0 == toMeMap[toMeItemList[i].fromUser.id+'_'+toMeItemList[i].bank.id+'_'+1] && 0 ==toMeMap[toMeItemList[i].fromUser.id+'_'+toMeItemList[i].bank.id+'_'+2] && 0 == toMeMap[toMeItemList[i].fromUser.id+'_'+toMeItemList[i].bank.id+'_'+3]){
						innerHtml+="<label> 未授予权限 </label>&nbsp";
					}
					innerHtml+="</h3></td><td><h3>"+toMeItemList[i].fromUser.name+"</h3></td>";
					if(2 == toMeItemList[i].operation){
						innerHtml+="<td><button type='button' class='btn btn-success btn-sm' data-toggle='tooltip' data-placement='top' title='已添加至题库'><i class='fa fa-check fa-lg bankConfirmed' aria-hidden='true'></i></button></td>";
					}else if(3 == toMeItemList[i].operation){
						innerHtml+="<td><button type='button' class='btn btn-info btn-sm addShareToBank' data-toggle='tooltip' data-placement='top' title='添加至题库' data-thisBank-id="+toMeItemList[i].bank.id+">";
						innerHtml+="<i class='fa fa-plus-square-o fa-lg bankUnconfirmed' aria-hidden='true'></i></button></td>";
					}
					innerHtml+="</tr>";
					$("#toMeBody").append(innerHtml);
				}

				$('#pagerFromMe').pagination({
					mode: 'fixed',
					pageCount:fromMe, //总页数
					current:map.pageNum,  //当前第几页
					callback:function(api){  //按钮、回调函数
						console.log("fromMeApi:",api);
						var cur = api.getCurrent();
						console.log("fromMeCur:",cur);
						loadPage(cur);
					}
				});

				$('#pagerToMe').pagination({
					mode: 'fixed',
					pageCount:toMe, //总页数 
					current:map.pageNum,  //当前第几页
					callback:function(api){  //按钮、回调函数
						console.log("toMeApi:",api);
					}
				});
	        },
	        error:function(){
	            alert('用户题库分享异步提交失败');
	        }
		});
	}

	/*将还未添加至题库的被分享题库添加至题库*/
	$("#toMeBody").on("click", ".addShareToBank",function(){
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
	$("#fromMeBody").on('click', ".setShreButton",function(){
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
	$("#fromMeBody").on('click', ".cancelShare",function(){
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

	
})