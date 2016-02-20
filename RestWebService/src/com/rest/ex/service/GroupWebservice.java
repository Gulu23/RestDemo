package com.rest.ex.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.rest.ex.entity.BillAccount;
import com.rest.ex.entity.BillHistory;
import com.rest.ex.entity.Group;
import com.rest.ex.jaxb.BillAccountJaxb;
import com.rest.ex.jaxb.BillHistoryJaxb;
import com.rest.ex.jaxb.GroupJaxb;
import com.rest.ex.jaxb.Groups;
import com.rest.ex.model.GroupServiceImpl;
import com.rest.ex.model.IGroupService;

@Path("/GroupService")
public class GroupWebservice {

	@GET
	@Path("/getAllGroups/xml")
	@Produces(MediaType.TEXT_XML)
	public Response getAllGroupsXml() {

		// dao.insertData();
		IGroupService grService = new GroupServiceImpl();

		List<Group> grps = grService.retrieveAll();
		Groups groups = new Groups();
		List<GroupJaxb> grpsJaxbList = new ArrayList<>();
		for (Group grp : grps) {
			{
				GroupJaxb grpsJaxb = getJaxbGroups(grp);
				grpsJaxbList.add(grpsJaxb);
			}
			groups.setGroup(grpsJaxbList);

		}
		return Response.status(200).entity(groups).build();
	}

	@GET
	@Path("/getAllGroups/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllGroupsJson() {

		// dao.insertData();
		IGroupService grService = new GroupServiceImpl();

		List<Group> grps = grService.retrieveAll();
		Groups groups = new Groups();
		List<GroupJaxb> grpsJaxbList = new ArrayList<>();
		for (Group grp : grps) {
			{
				GroupJaxb grpsJaxb = getJaxbGroups(grp);
				grpsJaxbList.add(grpsJaxb);
			}
			groups.setGroup(grpsJaxbList);

		}
		return Response.status(200).entity(groups).build();
	}

	@GET
	@Path("/getGroup/xml")
	@Produces(MediaType.TEXT_XML)
	public Response getGroup(@Context UriInfo info) {
      int id=Integer.parseInt(info.getQueryParameters().getFirst("id"));
		// dao.insertData();
		IGroupService grService = new GroupServiceImpl();
		Groups groups = new Groups();
		Group grp = grService.retrieveData(id);
		List<GroupJaxb> grpsJaxbList = new ArrayList<>();
		GroupJaxb grpsJaxb = getJaxbGroups(grp);
		grpsJaxbList.add(grpsJaxb);
		groups.setGroup(grpsJaxbList);
		
		
		return Response.status(200).entity(groups).build();
	}
	
	
	
	@GET
	@Path("/getGroup/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGroupJson(@Context UriInfo info) {
int id=Integer.parseInt(info.getQueryParameters().getFirst("id"));
		// dao.insertData();
		IGroupService grService = new GroupServiceImpl();
		Groups groups = new Groups();
		Group grp = grService.retrieveData(id);
		List<GroupJaxb> grpsJaxbList = new ArrayList<>();
		GroupJaxb grpsJaxb = getJaxbGroups(grp);
		grpsJaxbList.add(grpsJaxb);
		groups.setGroup(grpsJaxbList);
		
		return Response.status(200).entity(groups).build();
	}

	@POST
	@Path("/addGroup")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateGroupInJSON() {

		IGroupService grService = new GroupServiceImpl();

		Group grp= grService.insertData(getGroup());
		return Response.status(201).entity(grp).build();

	}
	@DELETE
	@Path("/deleteGroup")
	public void deleteGroup() {
		IGroupService grService = new GroupServiceImpl();
		grService.deleteData(123);
	}
	@PUT
	@Path("/updateGroup")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addGroupInJSON(@Context UriInfo info) {
		int id=Integer.parseInt(info.getQueryParameters().getFirst("id"));

		IGroupService grService = new GroupServiceImpl();

		grService.updateData(id);
		return Response.status(204).entity("").build();

	}
	

	private String convertDatetoString(Date date) {
		String DATE_FORMAT_NOW = "yyyy-MM-dd";

		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		String stringDate = sdf.format(date);
		try {
			Date date2 = sdf.parse(stringDate);
		} catch (ParseException e) {
			// Exception handling
		} catch (Exception e) {
			// handle exception
		}
		return stringDate;
	}
	

	private Date CovertStringToDate(String dateInString) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		// String dateInString = "7-Jun-2013";

		try {

			Date date = formatter.parse(dateInString);
			System.out.println(date);
			System.out.println(formatter.format(date));
			return date;

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	private GroupJaxb getJaxbGroups(Group grp) {

		// Group grp =grps.
		GroupJaxb gr = new GroupJaxb();
		gr.setBpa_id(grp.getBpa_id());
		gr.setGroup_Number(grp.getGroup_Number());
		gr.setBpa_effect_frm_dt(gr.getBpa_effect_frm_dt());
		gr.setBpa_effect_to_dt(gr.getBpa_effect_to_dt());

		List<BillAccountJaxb> billJaxbList = new ArrayList<>();

		for (BillAccount blla : grp.getBillaccountList()) {
			BillAccountJaxb billJaxb = new BillAccountJaxb();
			billJaxb.setBlla_id(blla.getBlla_id());
			billJaxb.setName(blla.getName());
			billJaxb.setBlla_effct_frm_dt(blla.getBlla_effct_frm_dt());
			billJaxb.setBlla_effct_to_dt(blla.getBlla_effct_to_dt());
			List<BillHistoryJaxb> bhiJaxbList = new ArrayList<>();

			for (BillHistory bhi : blla.getBillHistoryList()) {
				BillHistoryJaxb bhiJaxb = new BillHistoryJaxb();
				bhiJaxb.setBhi_id(bhi.getBhi_id());
				bhiJaxb.setBlla_id(bhi.getBlla_id());
				bhiJaxb.setBhi_effct_frm_dt(bhi.getBhi_effct_frm_dt());
				bhiJaxb.setBhi_effct_to_dt(bhi.getBhi_effct_to_dt());
				bhiJaxbList.add(bhiJaxb);
			}
			billJaxb.setBillHistoryList(bhiJaxbList);
			billJaxbList.add(billJaxb);
		}
		gr.setBillaccountList(billJaxbList);
		return gr;
	}
	
	private GroupJaxb  getGroup(){
	 GroupJaxb grp1 = new GroupJaxb();
	 grp1.setBpa_id(555);
        grp1.setBpa_effect_frm_dt(new Date("01-Jan-2015"));
        grp1.setBpa_effect_to_dt(new Date("31-Dec-2015"));
        grp1.setGroup_Number(1720L);
        
        BillAccountJaxb blla3 = new BillAccountJaxb();
        
        blla3.setBlla_id(1111);
        blla3.setBlla_effct_frm_dt(new Date("01-Jan-2015"));
        blla3.setBlla_effct_to_dt(new Date("31-Dec-2015"));
       blla3.setBpa_id(555);
        blla3.setName("Vinay");
        
        BillHistoryJaxb bhi3 = new BillHistoryJaxb();
        
    bhi3.setBhi_id(22222);
        bhi3.setBhi_effct_frm_dt(new Date("01-Jan-2015"));
        bhi3.setBhi_effct_to_dt(new Date("31-Jan-2015"));
        bhi3.setBlla_id(1111);
        
        List<BillHistoryJaxb> billHistroyList3 = new ArrayList<>();
        billHistroyList3.add(bhi3);
        blla3.setBillHistoryList(billHistroyList3);
        
       
        List<BillAccountJaxb> billaccountList2 = new ArrayList<>(); 
        billaccountList2.add(blla3);
        
        grp1.setBillaccountList(billaccountList2);
		return grp1;
	}
}
