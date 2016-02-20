package com.rest.ex.model;

import java.util.List;

import com.rest.ex.entity.Group;
import com.rest.ex.jaxb.GroupJaxb;

public interface IGroupService {
	public Group insertData(GroupJaxb grpjaxb);
	public Group retrieveData(int grp);
	public List<Group> retrieveAll();
	public Group updateData(int grp);
	public void deleteData(int grpNo);
	
	
}
