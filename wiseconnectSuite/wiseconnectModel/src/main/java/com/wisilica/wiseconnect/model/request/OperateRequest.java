package com.wisilica.wiseconnect.model.request;

public class OperateRequest {
	
	private String grpDvc;
	
    private String grpDvcId;
    
    private String rgb;
    
    private String cool;
    
    private String intensity;
    
    private String operationId;
    
    private String organizationId;
    
    private String serverOperationKey; // TBC

	public String getGrpDvc() {
		return grpDvc;
	}

	public void setGrpDvc(String grpDvc) {
		this.grpDvc = grpDvc;
	}

	public String getGrpDvcId() {
		return grpDvcId;
	}

	public void setGrpDvcId(String grpDvcId) {
		this.grpDvcId = grpDvcId;
	}

	public String getRgb() {
		return rgb;
	}

	public void setRgb(String rgb) {
		this.rgb = rgb;
	}

	public String getCool() {
		return cool;
	}

	public void setCool(String cool) {
		this.cool = cool;
	}

	public String getIntensity() {
		return intensity;
	}

	public void setIntensity(String intensity) {
		this.intensity = intensity;
	}

	public String getOperationId() {
		return operationId;
	}

	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public String getServerOperationKey() {
		return serverOperationKey;
	}

	public void setServerOperationKey(String serverOperationKey) {
		this.serverOperationKey = serverOperationKey;
	}
}
