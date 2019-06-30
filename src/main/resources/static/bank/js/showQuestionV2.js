$(function(){


	$(".recycleQuestion").on('click',function(){
		var questionId = $(this).parents("div[data-question-id]").attr("data-question-id");
		console.log("questionId:",questionId);
		$("#sureToDelete").attr("data-the-question",questionId);
	});

	$("#deleteButton").on('click',function(){
		var questionId = $("#sureToDelete").attr("data-the-question");
		var u = {"questionId":questionId};
		// u = JSON.stringify(u);
		console.log("确认删除");
		console.log("u",u);
		$.ajax({
            url:"/deleteAQuestion",
            data: u,
            //type、contentType必填,指明传参方式
            type: "get",
            contentType: "application/json;charset=utf-8",
            success: function(response){
            //前端调用成功后，可以处理后端传回的json格式数据。
                    console.log("response:",response);
                    $('div[data-question-id='+questionId+']').remove();
                }
            });
		
	})
})