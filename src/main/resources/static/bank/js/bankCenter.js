$(function(){

	console.log("outter");

    // 绑定编辑题库操作
	$(".editBank").on('click',function(){
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

	        	var newBankHtml = '<div class="col-sm-4" id="bank_'+jsonObj.id+'">';
	        	newBankHtml += '<div class="ibox float-e-margins" ><div class="ibox-title"><h5>';
	        	newBankHtml += '<small class="m-l-sm" >'+jsonObj.time+'</small>';
	        	newBankHtml += '</h5><div class="ibox-tools"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span></a><ul class="dropdown-menu dropdown-user" style="min-width:100px"><li><a href="#"><span class="glyphicon glyphicon-share" aria-hidden="true"></span>分享题库</a></li><li>';
	        	newBankHtml += '<a class="editBank" data-editBankId="'+jsonObj.id+'" data-toggle="modal" data-target="#editBankModal"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>编辑题库</a>'
	        	newBankHtml += '</li><li><a href="#"><span class="glyphicon glyphicon-search" aria-hidden="true"></span>题库查重</a></li><li role="separator" class="divider"></li><li><a href="#"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>移动到</a></li><li><a href="#"><span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>归档</a></li></ul><a class="removeA" data-delete="delete" data-toggle="modal" data-target="#sureToDelete"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></div></div><div class="ibox-content">';
	        	newBankHtml += '<a href="bankShowQuestionPage?thisId='+jsonObj.id+'"><h2 data-title-id="'+jsonObj.ids+'" >'+jsonObj.name+'<br/></h2></a>'
	        	newBankHtml += '<p data-body-id="'+jsonObj.id+'" >'+jsonObj.description+'</p>';
	        	newBankHtml += '<h5 class="page-header"></h5><a data-addbtn-id="'+jsonObj.id+'" style="margin-left:277px" href="bankAddQuestionPage?thisId='+jsonObj.id+'" class="btn btn-info btn-sm"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加试题</a>';
	        	newBankHtml += '</div></div></div>';

	        	$("#bankContainer").append(newBankHtml);
	        },
	        error:function(){
	            alert('创建新题库异步提交失败');
	        }
        });
    });
    // 添加新的题库结束

 });