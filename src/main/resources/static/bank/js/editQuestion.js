$(function(){

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


})

// 判断字符串为空的方法
function isEmpty(obj){
    if(typeof obj == "undefined" || obj == null || obj == ""){
        return true;
    }else{
        return false;
    }
}