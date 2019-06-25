$(function(){

    // 绑定切换题目类型事件
    $("#questionSececter").on('change',function(){
        var checkValue=$("#questionSececter").val(); 
        
        var $shown = $("div[data-onshow=1]");
        // 清空已有输入
        $("div[data-question-type='singlechoice'] input").val("");
        $("div[data-question-type='mutliplechoice'] input").val("");
        $("div[data-question-type='shortquestion'] textarea").val("");
        $("label[data-chosen-option=1]").children("i").attr("class","fa fa-circle-o fa-2x");
        
        var singleCount = $("div[data-question-type='singlechoice'] input");
        // console.log("singleCount:",singleCount);
        // 此方法是从前向删除
        // $("div[data-question-type='singlechoice'] input").each(function(){
        //     // if(!isEmpty($(this).val())){
        //     //     answerArray.push($(this).val());
        //     // }
        //     if(4 < singleCount--){
        //        $(this).parents(".mutlipleChoiceOption").remove(); 
        //     }
        // });

        // 此方法是从后向前删除
        for(var temp1=singleCount.length-1; temp1>3; temp1--){  
            $(singleCount[temp1]).parents(".singleChoiceOption").remove();
        }

        var mutlipleCount = $("div[data-question-type='mutliplechoice'] input");
        // console.log("mutlipleCountmutlipleCount :",mutlipleCount );

        // 此方法是从后向前删除
        for(var temp2=mutlipleCount.length-1; temp2>3; temp2--){
            $(mutlipleCount[temp2]).parents(".mutlipleChoiceOption").remove();
        }
        
        console.log("checkValue",checkValue);
        if(0 == checkValue){
            console.log("选择了单选题");
            var $question = $("div[data-question-type='singlechoice']");
            
        }else if(1 == checkValue){
            console.log("选择了多选题");
            var $question = $("div[data-question-type='mutliplechoice']");
        }else if(2 == checkValue){
            console.log("选择了简答题");
            var $question = $("div[data-question-type='shortquestion']");
        }

        $shown.attr('data-onshow',0);
        $shown.attr('style','display:none');
        $question.attr('data-onshow',1);
        $question.removeAttr('style');
    });
    
    // 绑定选择题目难度的事件
    $("label[data-difflevel]").on('click',function(){
        var $old = $("label[data-difflevel-choiced=1]");
        var $new = $(this);
        $old.attr('data-difflevel-choiced',0);
        $new.attr('data-difflevel-choiced',1);
        $old.children("i").attr('class','fa fa-circle-o fa-2x');
        $new.children("i").attr('class','fa fa-dot-circle-o fa-2x');
    });


    /* 单选相关事件 */
    // 绑定添加单选选项事件
    $("#addSingleChoiceButton").on('click',function(){
        
        console.log("添加单选选项");
        var $choiceCount = $('.singleChoiceOption').length;
        console.log("$choiceCount-添加前选项个数",$choiceCount);
        if(7 <= $choiceCount){
            alert("我暂时设定只能有7个选项");
            return;
        }
        
        var newChoiceHtml = '<div  class="col-sm-12 form-group  singleChoiceOption"><label class="col-sm-1 control-label text-right "  style="margin-top: 4.5px" data-chosen-option=0>';
        newChoiceHtml += '<i class="fa fa-circle-o fa-2x" aria-hidden="true"></i></label><div class="col-sm-10"><input type="text" class="form-control singleChoiceOptionValue" name="singleChoiceOptionValue" placeholder="输入选项内容"></div>';
        newChoiceHtml += '<label class="col-sm-1 control-label removeSingleOption"  style="margin-top: 3px"><i class="fa fa-times fa-2x" aria-hidden="true"></i></label></div>';
        var result = $('.singleChoiceBodyArea').append(newChoiceHtml);
        // $(newChoiceHtml).rules("add",{required:true});
    });

    // 绑定删除单选选项事件
    // div[data-question-type='mutliplechoice']
    $("div[data-question-type='singlechoice']").on("click",".removeSingleOption", function() {
        console.log("删除一个单选选项");
        var optionCount = $('.singleChoiceOption').length;
        console.log("optionCount-删除前选项个数",optionCount);
        if(2 >= optionCount){
            alert("题目数量不可以少于2");
            return;
        }
        var $father = $(this).parents(".singleChoiceOption");
        $father.remove();
    });


    // 绑定单选题答案选项改变的事件
    $("div[data-question-type='singlechoice']").on("click","label[data-chosen-option]", function() {
        console.log("单选答案选项改变");
        var $old = $('label[data-chosen-option=1]');
        var $new = $(this);

        if(1 == $new.attr("data-chosen-option")){
            $new.attr('data-chosen-option',0);
            $new.children('i').attr('class','fa fa-circle-o fa-2x');
            return;
        }

        $old.attr('data-chosen-option',0);
        $new.attr('data-chosen-option',1);

        $old.children('i').attr('class','fa fa-circle-o fa-2x');
        $new.children('i').attr('class','fa fa-dot-circle-o fa-2x');
    });
    /* 单选相关事件结束 */


    /* 多选相关事件 */
    // 绑定添加多选选项事件
    $("#addMutlipleChoiceButton").on('click',function(){
        
        console.log("添加多选选项");
        var $choiceCount = $('.mutlipleChoiceOption').length;
        console.log("$MutlipleChoiceCount-添加前选项个数",$choiceCount);
        if(7 <= $choiceCount){
            alert("我暂时设定只能有7个选项");
            return;
        }
        
        var newChoiceHtml = '<div  class="col-sm-12 form-group mutlipleChoiceOption"><label class="col-sm-1 control-label text-right" style="margin-top: 4.5px" data-chosen-option=0><i class="fa fa-circle-o fa-2x" aria-hidden="true"></i></label><div class="col-sm-10"><input type="text" class="form-control mutlipleChoiceOptionValue" name="mutlipleChoiceOptionValue" placeholder="输入选项内容"></div><label class="col-sm-1 control-label removemutlipleOption" style="margin-top: 3px"><i class="fa fa-times fa-2x" aria-hidden="true"></i></label></div>';
        var result = $('.mutlipleChoiceBodyArea').append(newChoiceHtml);
        // $(newChoiceHtml).rules("add",{required:true});
    });

    // 绑定删除多选选项事件
    $("div[data-question-type='mutliplechoice']").on("click",".removemutlipleOption", function() {
        console.log("删除一个多选选项");
        var optionCount = $('.mutlipleChoiceOption').length;
        console.log("mulitpleOptionCount-删除前选项个数",optionCount);
        if(3 >= optionCount){
            alert("题目数量不可以少于3");
            return;
        }
        var $father = $(this).parents(".mutlipleChoiceOption");
        $father.remove();
    });

    // 绑定多选题答案选项改变的事件
    $("div[data-question-type='mutliplechoice']").on("click","label[data-chosen-option]", function() {
        console.log("多选答案选项改变");
        var $new = $(this);

        if(1 == $new.attr("data-chosen-option")){
            $new.attr('data-chosen-option',0);
            $new.children('i').attr('class','fa fa-circle-o fa-2x');
            return;
        }
        $new.attr('data-chosen-option',1);

        $new.children('i').attr('class','fa fa-dot-circle-o fa-2x');
    });
    /* 多选相关事件结束 */


    // !!!!!!!!!!!!!!!!把这部分移动到了html里
    // 题目确认添加按钮
    // $('#confirmAddQuestion').on('click',function(){
    //     console.log("点击添加按钮---------------->");
    //     // 题干
    //     var questionBody = $("#questionBody").val();
    //     console.log("题干:",questionBody);

    //     // 题目难度
    //     var diffLevel = $("label[data-difflevel-choiced=1]").attr('data-difflevel');
    //     console.log("题目难度diffLevel:",diffLevel);

    //     // 题目方向
    //     var labelText = $('#editable-select_sele').val();
    //     // labelId=-1 表示这个知识点是新知识点
    //     var labelId = $('#editable-select').val();
    //     if(isEmpty(labelId)){
    //         labelId = -2;   
    //     }
    //     console.log("题目方向文本labelText:",labelText);
    //     console.log("题目方向id labelId:",labelId);

    //     // 答案.parent('.singleChoiceOption').val()
    //     var answer = $('label[data-chosen-option=1]').parent('.singleChoiceOption').children("div").children('input').val();
    //     console.log("单选题答案:",answer);

    //     // 非答案选项
    //     var answerArray = new Array();
    //     $('label[data-chosen-option=0]').parent('.singleChoiceOption').children("div").children('input').each(function(){
    //         if(!isEmpty($(this).val())){
    //             answerArray.push($(this).val());
    //         }
            
    //     });
    //     answerArray = JSON.stringify(answerArray);
    //     console.log("非答案选项answerArray",answerArray);

    //     // 题型
    //     var questionType = $("#questionSececter").val(); 
    //     var questionTypeText = $("#questionSececter").find("option:selected").text();
    //     console.log("题型questionType:",questionType);
    //     console.log("题型questionTypeText:",questionTypeText);

    //     // 题目解析
    //     var analysisTextArea = $('#analysisTextArea').val();
    //     console.log("题目解析analysisTextAreaanalysisTextArea:",analysisTextArea);

    //     // 所属题库
    //     console.log("所属题库:","考虑从session中获取，或者直接在后台使用");

    //     console.log("点击添加按钮---------------->");

    //     // var str = {'typeid':questionType,'difflevel':diffLevel,'labelid':labelId,'labeltext':labelText,'answer':answer,'description':questionBody,'answerArray':answerArray,'analysis':analysisTextArea};
    //     // $.ajax({
    //     //     type:'get',
    //     //      url:'/bankAddSingleChoice',
    //     //     contentType:'application/json;charset=utf-8',
    //     //     data:str,
    //     //     dataType:"text",    
    //     //     success:function(data){
    //     //         if(data == "ok"){
    //     //             alert("添加题目成功");
    //     //         }
    //     //     },
    //     //     error:function(){
    //     //         alert('添加题目异步提交失败');
    //     //     }
    //     // });
    //     var data = {};
    //     data.typeid = questionType;
    //     data.difflevel = diffLevel;
    //     data.labelid = labelId;
    //     data.labeltext = labelText;
    //     data.answer = answer;
    //     data.description = questionBody;
    //     data.answerArray = answerArray;
    //     data.analysis = analysisTextArea;

    //     console.log("data:",data);
    //     data = JSON.stringify(data);
    //     console.log("data-json:",data);
        

    //     $.ajax({
    //     url: "/addSingleQuestionByJson",
    //     data: data,
    //     //type、contentType必填,指明传参方式
    //     type: "POST",
    //     contentType: "application/json;charset=utf-8",
    //     success: function(response){
    //     //前端调用成功后，可以处理后端传回的json格式数据。
    //     if(response.success){
    //         alert(response.message);
    //         }
    //     }
    //     });

    // // });

    // $('#confirmAddQuestion').on('click',function(){
    //     console.log("点击事件");
    // });
        
});

// 判断字符串为空的方法
function isEmpty(obj){
    if(typeof obj == "undefined" || obj == null || obj == ""){
        return true;
    }else{
        return false;
    }
}