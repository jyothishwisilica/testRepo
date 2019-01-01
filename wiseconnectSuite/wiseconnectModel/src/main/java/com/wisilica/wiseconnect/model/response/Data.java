package com.wisilica.wiseconnect.model.response;

public class Data {
	
	private String operateLogId;
	
    private String apiToSocketTime;
    
    private String totalExecTime;

	public String getOperateLogId() {
		return operateLogId;
	}

	public void setOperateLogId(String operateLogId) {
		this.operateLogId = operateLogId;
	}

	public String getApiToSocketTime() {
		return apiToSocketTime;
	}

	public void setApiToSocketTime(String apiToSocketTime) {
		this.apiToSocketTime = apiToSocketTime;
	}

	public String getTotalExecTime() {
		return totalExecTime;
	}

	public void setTotalExecTime(String totalExecTime) {
		this.totalExecTime = totalExecTime;
	}
}
