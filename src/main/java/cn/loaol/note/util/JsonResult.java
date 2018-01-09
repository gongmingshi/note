package cn.loaol.note.util;

import java.io.Serializable;

public class JsonResult implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final int SUCCESS=0;
	protected static final int ERROR=1;
	
	private int state;
	private String message;
	private Object data;
	
	public JsonResult() {
	}
	public JsonResult(Throwable e) {
		state=ERROR;
		message=e.getMessage();
		data=null;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public JsonResult(int state, String message) {
		this.state = state;
		this.message = message;
	}
	public JsonResult(Object data) {
		state=SUCCESS;
		message=null;
		this.data=data;
	}
	@Override
	public String toString() {
		return "JsonResult [state=" + state + ", message=" + message + "]";
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
