package com.tlswe.awsmock.ec2.cxf;

/**
 * A subset of DescribeFlowLogs API's response type.
 * Sync up with AWS EC2 official documentation.
 * 
 * @author mengjial
 *
 */
public class DescribeFlowLogsResponseType {
	protected String requestId;
	protected String nextToken;
	protected FlowLogSetType flowLogSet;
	
	/**
	 * Gets the value of the requestId property
	 */
	public String getRequestId() {
		return requestId;
	}
	
	/**
	 * Sets the value of the requestId property
	 */
	public void setRequestId(String value) {
		this.requestId = value;
	}
	
	/**
	 * Gets the value of the flowLogSet property
	 */
	public FlowLogSetType getFlowLogSet() {
		return flowLogSet;
	}
	
	/**
	 * Sets the value of the flowLogSet property
	 */
	public void setFlowLogSet(FlowLogSetType value) {
		this.flowLogSet = value;
	}
	
	/**
	 * Gets the value of the nextToken property
	 */
	public String getNextToken() {
		return nextToken;
	}
	
	/**
	 * Sets the value of the nextToken property
	 */
	public void setNextToken(String value) {
		this.nextToken = value;
	}
 }
