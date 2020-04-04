package br.com.myrecipemanager.models;

import java.io.Serializable;

public class PrepareType implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer code;
	private String prepareType;
	
	public PrepareType () {
	}

	public PrepareType(Integer code, String prepareType) {
		super();
		this.code = code;
		this.prepareType = prepareType;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getPrepareType() {
		return prepareType;
	}

	public void setPrepareType(String prepareType) {
		this.prepareType = prepareType;
	}

	@Override
	public String toString() {
		return "TipoPreparo [" + (code != null ? "code=" + code + ", " : "")
				+ (prepareType != null ? "prepareType=" + prepareType : "") + "]";
	}
	
}
