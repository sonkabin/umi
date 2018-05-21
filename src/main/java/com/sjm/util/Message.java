package com.sjm.util;

import java.util.HashMap;
import java.util.Map;

public class Message {

    private int code;
    private String msg;
    private Map<String,Object> extend = new HashMap<>();

    private Message(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public static Message success(){
        return new Message(100,"成功");
    }

    public static Message fail(){
        return new Message(200,"失败");
    }

    public Message add(String key,Object value){
        this.extend.put(key,value);
        return this;
    }

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getExtend() {
		return extend;
	}

	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}
    
    
}
