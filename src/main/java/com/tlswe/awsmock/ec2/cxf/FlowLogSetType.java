package com.tlswe.awsmock.ec2.cxf;

import java.util.ArrayList;
import java.util.List;

public class FlowLogSetType {
	protected List<FlowLogInfoType> item;
	
	public List<FlowLogInfoType> getItem() {
		if (item == null) {
			item = new ArrayList<FlowLogInfoType>();
		}
		return this.item;
	}
}
