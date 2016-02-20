package com.rest.ex.dao;

import java.util.List;

import com.rest.ex.entity.Group;

public interface DataOperationsService {
	public Group insertData(Group group);
	public Group retrieveData(int grp);
	public Group updateData(int grpNO);
	public void deleteData(int grpNO);
	public List<Group> retrieveAll();
	
	
}
