package com.rest.ex.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Groups {
	private List<GroupJaxb> Group;

	public List<GroupJaxb> getGroup() {
		return Group;
	}

	public void setGroup(List<GroupJaxb> group) {
		Group = group;
	}

	
}
