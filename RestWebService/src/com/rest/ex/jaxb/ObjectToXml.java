package com.rest.ex.jaxb;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;  
import javax.xml.bind.Marshaller;  
  
  
public class ObjectToXml {  
public static void main(String[] args) throws Exception{  
    JAXBContext contextObj = JAXBContext.newInstance(GroupJaxb.class);  
  
    Marshaller marshallerObj = contextObj.createMarshaller();  
    marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
  
    GroupJaxb gr=new GroupJaxb();
    gr.setBpa_id(12);
    gr.setGroup_Number(1234);
    gr.setBpa_effect_frm_dt(new Date());
    gr.setBpa_effect_to_dt(new Date());
    List<BillAccountJaxb> billaccountList=new ArrayList<>();
    BillAccountJaxb blla=new BillAccountJaxb();
    blla.setBlla_id(123);
    blla.setBpa_id(22);
   blla.setBlla_effct_frm_dt(new Date());
   blla.setBlla_effct_to_dt(new Date());
    billaccountList.add(blla);
    gr.setBillaccountList(billaccountList);
    
    marshallerObj.marshal(gr, new FileOutputStream("question.xml"));  
       
}  
}  