package com.tlswe.awsmock.ec2.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Class for mock flow log for AWS.
 *
 * @author mengjial
 */
public class MockFlowLog implements Serializable {
    /**
     * Default serial version ID for this class which implements
     * {@link Serializable}.
     *
     * @see Serializable
     */
    private static final long serialVersionUID = 1L;

    /**
     * The date and time the flow log was created.
     */
    private String creationTime = null;

    /**
     * Information about the error that occurred. Rate limited indicates that
     * CloudWatch logs throttling has been applied for one or more network
     * interfaces, or that you've reached the limit on the number of CloudWatch Logs
     * log groups that you can create. Access error indicates that the IAM role
     * associated with the flow log does not have sufficient permissions to publish
     * to CloudWatch Logs. Unknown error indicates an internal error.
     */
    private String deliverLogsErrorMessage = null;

    /**
     * The ARN of the IAM role that posts logs to CloudWatch Logs.
     */
    private String deliverLogsPermissionArn = null;

    /**
     * The status of the logs delivery (SUCCESS | FAILED).
     */
    private String deliverLogsStatus = null;

    /**
     * The flow log ID.
     */
    private String flowLogId = null;

    /**
     * The status of the flow log (ACTIVE).
     */
    private String flowLogStatus = null;

    /**
     * The name of the flow log group.
     */
    private String logGroupName = null;

    /**
     * The ID of the resource on which the flow log was created.
     */
    private String resourseId = null;

    /**
     * The type of traffic captured for the flow log. Valid Values: ACCEPT | REJECT
     * | ALL
     */
    private String trafficType = null;

    /**
     * Get serial version id.
     * @return long object.
     */
    public static final long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     * Get the creation time of log.
     * @return String object.
     */
    public final String getCreationTime() {
        return creationTime;
    }

    /**
     * Set the creation time for flow log.
     * @param value
     *          The time to be assigned.
     */
    public final void setCreationTime(final String value) {
        this.creationTime = value;
    }

    /**
     * Get the deliver log error message.
     * @return String object.
     */
    public final String getDeliverLogsErrorMessage() {
        return deliverLogsErrorMessage;
    }

    /**
     * Set deliver error message.
     * @param value
     *          The message to be assigned.
     */
    public final void setDeliverLogsErrorMessage(final String value) {
        this.deliverLogsErrorMessage = value;
    }

    /**
     * Get the deliver log permission ARN.
     * @return String object.
     */
    public final String getDeliverLogsPermissionArn() {
        return deliverLogsPermissionArn;
    }

    /**
     * Set the deliver log permission ARN.
     * @param value
     *          The deliver log permission ARN to be assigned.
     */
    public final void setDeliverLogsPermissionArn(final String value) {
        this.deliverLogsPermissionArn = value;
    }

    /**
     * Get the deliver log status.
     * @return String object.
     */
    public final String getDeliverLogsStatus() {
        return deliverLogsStatus;
    }

    /**
     * Set the deliver log status.
     * @param value
     *          The deliver log status to be assigned.
     */
    public final void setDeliverLogsStatus(final String value) {
        this.deliverLogsStatus = value;
    }

    /**
     * Get the flow log Id.
     * @return String obejct.
     */
    public final String getFlowLogId() {
        return flowLogId;
    }

    /**
     * Set the flow log Id.
     * @param value
     *          The Id to be assigned.
     */
    public final void setFlowLogId(final String value) {
        this.flowLogId = value;
    }

    /**
     * Get the flow log status.
     * @return String Object.
     */
    public final String getFlowLogStatus() {
        return flowLogStatus;
    }

    /**
     * Set the flow log status.
     * @param value
     *          The flow log status to be assigned.
     */
    public final void setFlowLogStatus(final String value) {
        this.flowLogStatus = value;
    }

    /**
     * Get the log group name.
     * @return String object.
     */
    public final String getLogGroupName() {
        return logGroupName;
    }

    /**
     * Set the log group name.
     * @param value
     *          The log group name to be assigned.
     */
    public final void setLogGroupName(final String value) {
        this.logGroupName = value;
    }

    /**
     * Get the resource Id.
     * @return String object.
     */
    public final String getResourseId() {
        return resourseId;
    }

    /**
     * Set the resource Id.
     * @param value
     *          The resouce Id to be assigned.
     */
    public final void setResourseId(final String value) {
        this.resourseId = value;
    }

    /**
     * Get the traffic type.
     * @return String object.
     */
    public final String getTrafficType() {
        return trafficType;
    }

    /**
     * Set the traffic type.
     * @param value
     *          The traffic type to be assigned.
     */
    public final void setTrafficType(final String value) {
        this.trafficType = value;
    }
}

