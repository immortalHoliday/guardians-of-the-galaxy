$(function(){

	console.log("outter");

    // 绑定编辑题库操作
	$("#bankContainer").on('click', ".editBank",function(){
		var bankId = $(this).attr('data-editBankId');
		// 解绑之前的事件
		$('#editBankBtn').unbind();
		// 绑定新的事件
		$('#editBankBtn').on('click',{bankId:bankId},function(){
			var newName = $('#newName').val();
			var newDescrription = $('#newDescription').val();

			var newBank = {'name':newName,'description':newDescrription,'id':bankId};

			$.ajax({
	        	type:'post',
		        url:'/bankEditHandler',
		        
		        contentType:'application/json;charset=utf-8',//请求的字符编码
		        data:JSON.stringify(newBank),
		        dataType:"text",    
		        success:function(data){
		        	// 传来的是json字符串，所以首先要把json字符串转为js对象
	                var jsonObj = JSON.parse(data);
		        	$('#newName').val('');
		        	$('#newDescription').val('');
		        	$('#newName').attr("placeholder","");
					$('#newDescription').attr("placeholder","");
					if(1 == jsonObj){
						$("h2[data-title-id*='"+bankId+"']").html(newName);
						$("p[data-body-id*='"+bankId+"']").html(newDescrription);
					}
		        },
		        error:function(){
		            alert('编辑题库异步提交失败');
		        }
	        });

		});
	});
	// 绑定编辑题库操作结束

	// 此方法无法为新生成的题库执行删除操作
	// $('.removeA').on('click',function(){
	// 	var id1 = $("#sureToDelete").attr("data-the-bank");
	// 	console.log("removeA id1:",id1);
	// 	var $bankdiv = $(this).parents("div[id*='bank']");
	// 	// 指定题库的id
	// 	var id2 = $bankdiv.attr('id').split("_")[1];
	// 	console.log("removeA id2:",id2);
	// 	$("#sureToDelete").attr("data-the-bank",id2);
	// });

	$("#bankContainer").on("click",".archiveA",function(){
		// console.log("bankContainer removeA:",$(this).length);
		var $bankdiv = $(this).parents("div[id*='bank']");
		var id2 = $bankdiv.attr('id').split("_")[1];
		// console.log("removeA id2:",id2);
		$("#sureToArchive").attr("data-the-bank",id2);
	});

	$("#bankContainer").on("click",".removeA",function(){
		// console.log("bankContainer removeA:",$(this).length);
		var $bankdiv = $(this).parents("div[id*='bank']");
		var id2 = $bankdiv.attr('id').split("_")[1];
		// console.log("removeA id2:",id2);
		$("#sureToDelete").attr("data-the-bank",id2);
	});


	$("#deleteCancel").on("click",function(){
		var id = $("#sureToDelete").attr("data-the-bank");
		console.log("deleteCancel id:",id);
	});

    // 绑定删除到回收站操作
	$(".recycleBank").on('click',function(){
		
		var bankid = $("#sureToDelete").attr("data-the-bank");
		console.log("recycleBank bankid:",bankid);
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

	$(".archiveBank").on('click',function(){
		var bankid = $("#sureToArchive").attr("data-the-bank");
		console.log("archiveBank bankid:",bankid);
		var u = {"bankId":bankid};

		$.ajax({
			type:'get',
	        url:'/bankArchive',
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
	            alert('归档操作异步提交失败');
	        }
		});
	});

 	// 添加新的题库
 	$('#newBankAddBtn').on('click',function(){
       var name = $('#name').val();
       var description = $('#description').val();
       var bank = {'name':name,'description':description};//包装成一个js对象

       console.log("JSON.stringify(bank):",JSON.stringify(bank));

        $.ajax({
        	type:'post',
	        url:'/addNewBank',
	        
	        contentType:'application/json;charset=utf-8',//请求的字符编码
	        data:JSON.stringify(bank),
	        dataType:"text",    
	        success:function(map){
	        	// 传来的是json字符串，所以首先要把json字符串转为js对象
                var jsonObj = JSON.parse(map);
	        	console.log(jsonObj.newBank);
	        	jsonObj = jsonObj.newBank;

	        	$('#name').val('');
	        	$('#description').val('');

	        	var newBankHtml = '<div class="col-sm-4" id="bank_'+jsonObj.id+'" data-bank-id='+jsonObj.id+'>';
	        	newBankHtml += '<div class="ibox float-e-margins" ><div class="ibox-title"><h5>';
	        	newBankHtml += '<small class="m-l-sm" >'+jsonObj.time+'</small>';
	        	newBankHtml += '</h5><div class="ibox-tools"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span></a><ul class="dropdown-menu dropdown-user" style="min-width:100px"><li><a class="shareBank" data-toggle="modal" data-target="#shareBankModal"><span class="glyphicon glyphicon-share" aria-hidden="true"></span>分享题库</a></li><li>';
	        	newBankHtml += '<a class="editBank" data-editBankId="'+jsonObj.id+'" data-toggle="modal" data-target="#editBankModal"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>编辑题库</a>'
	        	newBankHtml += '</li><li><a href="#"><span class="glyphicon glyphicon-search" aria-hidden="true"></span>题库查重</a></li><li role="separator" class="divider"></li><li><a href="#"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>移动到</a></li><li><a class="archiveA" data-toggle="modal" data-target="#sureToArchive"><span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>归档</a></li></ul><a class="removeA" data-delete="delete" data-toggle="modal" data-target="#sureToDelete"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></div></div><div class="ibox-content">';
	        	newBankHtml += '<a href="bankShowQuestionPage?thisId='+jsonObj.id+'"><h2 data-title-id="'+jsonObj.id+'" >'+jsonObj.name+'<br/></h2></a>'
	        	newBankHtml += '<p data-body-id="'+jsonObj.id+'" >'+jsonObj.description+'</p>';
	        	newBankHtml += '<h5 class="page-header"></h5><div class="row"><div class="col-sm-3 col-sm-offset-1"><h1 style="display: inline; color: #ED9121;">0</h1><small>道题</small></div><div class="col-sm-4 col-sm-offset-4"><a data-addbtn-id="'+jsonObj.id+'" data-toggle="modal" data-target="#chooseAddWay"	 class="btn btn-info btn-sm"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加试题</a></div></div>';
	        	newBankHtml += '</div></div></div>';

	        	$("#bankContainer").append(newBankHtml);
	        },
	        error:function(){
	            alert('创建新题库异步提交失败');
	        }
        });
    });
    // 添加新的题库结束

    // 分享题库开始
    // 点击分享题库，弹出模态框的有关操作（主要是绑定数据）
    $("#bankContainer").on("click", ".shareBank",function(){
    	var bankId = $(this).parents("div[id*='bank']").attr("data-bank-id");
    	console.log("share bankId:",bankId);
    	$("#shareBankModal").attr("data-the-bank",bankId);
    	var name = $("h2[data-title-id="+bankId+"]").html();
    	$("#modalLabel").html("分享题库—"+name);
    });

    //处理实时搜索用户的操作
    $("#userAccount").on("keyup",function(){
    	var userMail = $(this).val();
    	var bankId = $("#shareBankModal").attr("data-the-bank");
    	console.log("userMail:"+userMail+" bankId:"+bankId);
    	var u = {"bankId":bankId,"userMail":userMail};

		$.ajax({
			type:'get',
	        url:'/findUser',
	        contentType:'application/json;charset=utf-8',
	        data:u,
	        dataType:"text",    
	        success:function(map){
	        	
	        	console.log("origin map",map);
	        	map = JSON.parse(map);
	        	console.log("changed map",map);
	        	console.log("map.username",map.username);
	        	console.log("map.userId",map.userId);
	        	if(isEmpty(map.username)){
	        		$("#userName").val("没有相关用户");
	        		console.log("meiyouxiangguanyonghu");
	        		$("#shareConfirm").attr("disabled","disabled");
	        	}else if("exists" == map.state){
	        		$("#userName").val("您向该用户分享过该题库");
	        	}else{
	        		$("#userName").val(map.username);
	        		$("#shareBankModal").attr("data-the-userid",map.userId);
	        		$("#shareConfirm").removeAttr("disabled");
	        	}
	        },
	        error:function(){
	            alert('用户邮箱实时查询异步提交失败');
	        }
		});
    });
 	
    //点击确定分享之后的行为，获得用户，获得题库，获得权限
    $("#shareConfirm").on("click",function(){

    	var checkAccount = $("#userAccount").val();
    	var checkName = $("#userName").val();
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
    	console.log('auths:',auths);
    	console.log('array:',array);

    	if(isEmpty(checkAccount) || isEmpty(checkName)){
    		console.log("请输入用户邮箱或者电话");
    		return;
    	}

    	var bankId = $("#shareBankModal").attr("data-the-bank");
    	var userId = $("#shareBankModal").attr("data-the-userid");
    	console.log("确认分享"+bankId+"给用户"+userId);

    	var arrayJson = JSON.stringify(array);

    	var u = {"bankId":bankId,"userId":userId,"autArray":arrayJson};

		$.ajax({
			type:'get',
	        url:'/shareBankToUser',
	        contentType:'application/json;charset=utf-8',
	        data:u,
	        dataType:"text",    
	        success:function(data){
	        	console.log("data",data);
	        	if("error" == data){
	        		alert("不能给自己分享题库");
	        	}
	        },
	        error:function(){
	            alert('用户题库分享异步提交失败');
	        }
		});


		auths.each(function(){
    		$(this).children('span').children('i').attr("class","fa fa-square-o fa-lg");
    		$(this).attr("data-aut-selected",-1);
    	});
    	$("#userAccount").val("");
    	$("#userName").val("");
    });
    //分享题库结束

    /*test*/
    $("#shareCancel").on("click",function(){
    	$("#userAccount").val("");
    	$("#userName").val("");
    });

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

	$("#bankContainer").on('click','a[data-addbtn-id]',function(){
		var bankId = $(this).attr("data-addbtn-id");
		console.log("点击添加试题-bankId:",bankId);
		$("#chooseAddWay").attr("data-the-bank",bankId);
		$("#addByFromA").attr("href","bankAddQuestionPage?thisId="+bankId);

	});

	$("#importByExcel").on("click",function(){
		var bankId = $("#chooseAddWay").attr("data-the-bank");
		console.log("要使用excel导入的是题库：",bankId);
		$("#importByExcelForm").attr("action","/importexcel?thisBankId="+bankId)
	})


 });

// 判断字符串为空的方法
function isEmpty(obj){
    if(typeof obj == "undefined" || obj == null || obj == ""){
        return true;
    }else{
        return false;
    }
}