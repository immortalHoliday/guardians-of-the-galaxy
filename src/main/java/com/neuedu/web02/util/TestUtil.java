package com.neuedu.web02.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class TestUtil {


	
	public static void main(String[] args) {
//		String test = "[{\"userid\":1},{\"question_id\":2,\"user_answer\":\"1\"},{\"question_id\":3,\"user_answer\":\"6\"},{\"question_id\":4},{\"question_id\":5},{\"question_id\":6,\"user_answer\":\"哦呵呵\"}]";
//
//		JSONArray tableData = JSONArray.parseArray(test);
//		System.out.println("tabledata:"+tableData);
//		
//		JSONObject rowData = new JSONObject();
//		for(int i=0;i<tableData.size();i++){
//		    rowData = tableData.getJSONObject(i);
//		    System.out.println("rowData:"+rowData);
//		    if(0 == i) {
//		    	Integer userid = rowData.getInteger("userid");
//		    	System.out.println("userid"+userid);
//		    }else {
//		    	Integer question_id = rowData.getInteger("question_id");
//		    	String user_answer = rowData.getString("user_answer");
//		    	
//		    	System.out.println("question_id:"+question_id);
//		    	System.out.println("user_answer:"+user_answer);
//		    }
//		}
		
		String str = "35_33_";
		System.out.println(str.split("_").length);
		for(int i=0; i<str.split("_").length; i++) {
			System.out.println(str.split("_")[i]);
		}
	}
}
