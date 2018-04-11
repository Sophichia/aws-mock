package com.tlswe.awsmock.ec2.control;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import com.tlswe.awsmock.ec2.model.MockFlowLog;

/**
 * Factory class providing static methods for managing life cycle of mock Flow
 * logs. can:
 * <ul>
 * <li>create</li>
 * <li>delete</li>
 * <li>describe</li>
 * </ul>
 * mock Flow Log. <br>
 *
 * @author mengjial
 */
public final class MockFlowLogController {

    /**
     * Singleton instance of MockFlowLogController.
     */
    private static MockFlowLogController singletonMockFlowLogController = null;

    /**
     * Length of generated postfix of flow log ID.
     */
    protected static final short FLOWLOG_ID_POSTFIX_LENGTH = 8;

    /**
     * A map of all mock FlowLog, id as key and {@link MockFlowLog}} as value.
     */
    private final Map<String, MockFlowLog> allMockFlowLogs = new ConcurrentHashMap<String, MockFlowLog>();

    /**
     * Constructor of MockFlowLogController is made private and only called once by
     * {@link #getInstance()}.
     */
    private MockFlowLogController() {

    }

    /**
     * @return singleton instance of {@link MockFlowLogController}
     */
    public static MockFlowLogController getInstance() {
        if (null == singletonMockFlowLogController) {
            // "double lock lazy loading" for singleton instance loading on first time usage
            synchronized (MockFlowLogController.class) {
                if (null == singletonMockFlowLogController) {
                    singletonMockFlowLogController = new MockFlowLogController();
                }
            }
        }
        return singletonMockFlowLogController;
    }

    /**
     * List mock FlowLog instances in current aws-mock.
     *
     * @return a collection of all {@link MockFlowLog}
     */
    public Collection<MockFlowLog> getAllFlowLogs() {
        return allMockFlowLogs.values();
    }

    /**
     * Create a flow log instance.
     * @param deliverLogsPermissionArn
     *          The ARN of the IAM role that posts logs to CloudWatch Logs.
     * @param logGroupName
     *          The name of the flow log group.
     * @param resourceId
     *          Resource Id.
     * @param resourceType
     *          Resource Type.
     * @param trafficType
     *          The type of traffic captured for the flow log.
     * @return MockFlowLog object.
     */
    public MockFlowLog createFlowLog(final String deliverLogsPermissionArn,
            final String logGroupName, final String resourceId,
            final String resourceType, final String trafficType) {

        MockFlowLog ret = new MockFlowLog();
        ret.setCreationTime(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").format(new Date()));
        ret.setFlowLogId("fl-" + UUID.randomUUID().toString().substring(0, FLOWLOG_ID_POSTFIX_LENGTH));
        ret.setDeliverLogsPermissionArn(deliverLogsPermissionArn);
        ret.setLogGroupName(logGroupName);
        ret.setResourseId(resourceId);
        ret.setTrafficType(trafficType);

        allMockFlowLogs.put(ret.getFlowLogId(), ret);
        return ret;
    }

    /**
     * Delete Flow Log.
     *
     * @param flowLogId
     *            specified ID of flow log to be deleted
     * @return Mock FlowLog
     */
    public MockFlowLog deleteFlowLog(final String flowLogId) {
        if (flowLogId != null && allMockFlowLogs.containsKey(flowLogId)) {
            return allMockFlowLogs.remove(flowLogId);
        }

        return null;
    }

    /**
     * List mock Flow Logs in current aws-mock.
     *
     * @param flowLogIDs
     *            a filter of specified flow log IDs for the target log to describe
     * @return a collection of IDs with specified log IDs, or all of the mock flow
     *         logs if not filtered.
     */
    public List<String> listFlowLogIDs(final Set<String> flowLogIDs) {
        Set<String> allFlowLogIDs = allMockFlowLogs.keySet();
        if (null == flowLogIDs || flowLogIDs.size() == 0) {
            return new ArrayList<String>(allFlowLogIDs);
        } else {
            List<String> filteredFlowLogIDs = new ArrayList<String>();
            for (String id : allFlowLogIDs) {
                if (null != id && flowLogIDs.contains(id)) {
                    filteredFlowLogIDs.add(id);
                }
            }
            return filteredFlowLogIDs;
        }
    }

    /**
     * get flow log by given log ID.
     *
     * @param id
     *            ID for the flow log to get
     * @return the mock flow log object
     */
    public MockFlowLog getMockFlowLog(final String id) {
        return allMockFlowLogs.get(id);
    }
}

