package com.knimbus.model;

public class Options {
	 private String optionCode;
	 private String optionName;
	 private int order;
      public Options() {}
	public String getOptionCode() {
		return optionCode;
	}
	public void setOptionCode(String optionCode) {
		this.optionCode = optionCode;
	}
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "Options [optionCode=" + optionCode + ", optionName=" + optionName + ", order=" + order + "]";
	}
	
	
}
