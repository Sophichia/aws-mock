package com.tlswe.awsmock.ec2.cxf;

import software.amazon.ion.Timestamp;

public class FlowLogInfoType {
	/**
	 * The date and time the flow log was created.
	 */
	protected Timestamp creationtime;
	
	/**
	 * Information about the error that occurred. 
	 * Rate limited indicates that CloudWatch logs throttling has been applied for one or more network interfaces, 
	 * or that you've reached the limit on the number of CloudWatch Logs log groups that you can create. 
	 * Access error indicates that the IAM role associated with the flow log does not 
	 * have sufficient permissions to publish to CloudWatch Logs. Unknown error indicates an internal error.
	 */
	protected String deliverLogsErrorMessage;
	
	/**
	 * The ARN of the IAM role that posts logs to CloudWatch Logs.
	 */
	protected String deliverLogsPermissionArn;
	
	/**
	 * The status of the logs delivery (SUCCESS | FAILED).
	 */
	protected String deliverLogsStatus;
	
	/**
	 * The flow log ID.
	 */
	protected String flowLogId;
	
	/**
	 * The status of the flow log (ACTIVE).
	 */
	protected String flowLogStatus;
	
	/**
	 * The name of the flow log group.
	 */
	protected String logGroupName;
	
	/**
	 * The ID of the resource on which the flow log was created.
	 */
	protected String resourseId;
	
	/**
	 * The type of traffic captured for the flow log.
	 * Valid Values: ACCEPT | REJECT | ALL
	 */
	protected String trafficType;

	public Timestamp getCreationtime() {
		return creationtime;
	}

	public void setCreationtime(Timestamp creationtime) {
		this.creationtime = creationtime;
	}

	public String getDeliverLogsErrorMessage() {
		return deliverLogsErrorMessage;
	}

	public void setDeliverLogsErrorMessage(String deliverLogsErrorMessage) {
		this.deliverLogsErrorMessage = deliverLogsErrorMessage;
	}

	public String getDeliverLogsPermissionArn() {
		return deliverLogsPermissionArn;
	}

	public void setDeliverLogsPermissionArn(String deliverLogsPermissionArn) {
		this.deliverLogsPermissionArn = deliverLogsPermissionArn;
	}

	public String getDeliverLogsStatus() {
		return deliverLogsStatus;
	}

	public void setDeliverLogsStatus(String deliverLogsStatus) {
		this.deliverLogsStatus = deliverLogsStatus;
	}

	public String getFlowLogId() {
		return flowLogId;
	}

	public void setFlowLogId(String flowLogId) {
		this.flowLogId = flowLogId;
	}

	public String getFlowLogStatus() {
		return flowLogStatus;
	}

	public void setFlowLogStatus(String flowLogStatus) {
		this.flowLogStatus = flowLogStatus;
	}

	public String getLogGroupName() {
		return logGroupName;
	}

	public void setLogGroupName(String logGroupName) {
		this.logGroupName = logGroupName;
	}

	public String getResourseId() {
		return resourseId;
	}

	public void setResourseId(String resourseId) {
		this.resourseId = resourseId;
	}

	public String getTrafficType() {
		return trafficType;
	}

	public void setTrafficType(String trafficType) {
		this.trafficType = trafficType;
	}
	
	
}
