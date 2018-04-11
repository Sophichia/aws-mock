package com.tlswe.awsmock.ec2.control;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.tlswe.awsmock.ec2.model.MockFlowLog;

@RunWith(PowerMockRunner.class)
@PrepareForTest( {MockFlowLogController.class} )
public class MockFlowLogControllerTest {

    @Test
    public void Test_getInstance() {

        MockFlowLogController instance = MockFlowLogController.getInstance();
        Assert.assertNotNull(instance);
    }

    @Test
    public void Test_getAllFlowLogs() {

        Collection<MockFlowLog> allFlowLogs = MockFlowLogController.getInstance().getAllFlowLogs();
        Assert.assertNotNull(allFlowLogs);
    }

    @Test
    public void Test_createFlowLog() {

        MockFlowLog flowLog = MockFlowLogController.getInstance()
                .createFlowLog("arn:aws:iam::123456789101:role/publishFlowLogs",
                        "my-flow-logs", "vpc12345678", "VPC", "ACCEPT");
        Assert.assertNotNull(flowLog);
        Assert.assertNotNull(flowLog.getFlowLogId());
        Assert.assertTrue(MockFlowLogController.getInstance().getAllFlowLogs().size() == 1);
    }

    @Test
    public void Test_deleteFlowLog() {

        MockFlowLog flowLog = MockFlowLogController.getInstance()
                .createFlowLog("arn:aws:iam::123456789101:role/publishFlowLogs",
                        "my-flow-logs", "vpc12345678", "VPC", "ACCEPT");
        
        MockFlowLog flowLogDeleted = MockFlowLogController.getInstance()
                .deleteFlowLog(flowLog.getFlowLogId());

        Assert.assertNotNull(flowLogDeleted);
        Assert.assertNotNull(flowLogDeleted.getFlowLogId());
        Assert.assertTrue(MockFlowLogController.getInstance().getAllFlowLogs().size() == 0);
    }

    @Test
    public void Test_listFlowLogIDs() {

        List<String> emptyList = MockFlowLogController.getInstance().listFlowLogIDs(null);
        Assert.assertTrue(emptyList.size() == 0);

        MockFlowLog flowLog = MockFlowLogController.getInstance()
                .createFlowLog("arn:aws:iam::123456789101:role/publishFlowLogs",
                        "my-flow-logs", "vpc12345678", "VPC", "ACCEPT");
        Set<String> flowLogIds = new TreeSet<String>();
        flowLogIds.add(flowLog.getFlowLogId());
        flowLogIds.add("23333333"); // Wrong ID
        List<String> idList = MockFlowLogController.getInstance().listFlowLogIDs(flowLogIds);

        Assert.assertTrue(idList.size() == 1); // Filtered the wrong ID.
        Assert.assertTrue(idList.get(0).equals(flowLog.getFlowLogId()));
    }

    @Test
    public void Test_getMockFlowLog() {

        MockFlowLog nullInstance = MockFlowLogController.getInstance().getMockFlowLog("233333");
        Assert.assertNull(nullInstance);

        MockFlowLog flowLog = MockFlowLogController.getInstance()
                .createFlowLog("arn:aws:iam::123456789101:role/publishFlowLogs",
                        "my-flow-logs", "vpc12345678", "VPC", "ACCEPT");
        MockFlowLog targetInstance = MockFlowLogController.getInstance().getMockFlowLog(flowLog.getFlowLogId());
        Assert.assertNotNull(targetInstance);
    }
}

