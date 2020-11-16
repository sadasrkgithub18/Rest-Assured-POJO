package com.qa.pack3;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pack2.payload;

import io.restassured.path.json.JsonPath;

public class GetName 
{
  String lName;
  @Test	
  public void getNameWithID()
  {
	  
	  JsonPath js= new JsonPath(payload.getName());
	  int count  =	js.getInt("data.size()");
	  //System.out.println(count);
	  for(int i=0;i<count;i++)
	  {
		 int id = js.getInt("data[" + i + "].id");
		 if(id == 11)
		 {
			 lName= js.get("data[" + i + "].last_name");
			 break;
				/*
				 * if(lName.equalsIgnoreCase("Howell")) {
				 * System.out.println("Last name is correct"); break; }
				 */
			 
			 
		 }
	  }
	  
	  Assert.assertEquals(lName, "Howell");	
  }
}
