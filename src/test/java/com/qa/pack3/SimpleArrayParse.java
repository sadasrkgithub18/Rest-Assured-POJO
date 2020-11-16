package com.qa.pack3;

import org.testng.annotations.Test;

import com.qa.pack2.payload;

import io.restassured.path.json.JsonPath;

public class SimpleArrayParse 
{
  @Test	
  public void sampleArray()
  {
	  JsonPath js= new JsonPath(payload.simpleArray());
	  int count  =	js.getInt("data.size()");
	  System.out.println(count);
	  System.out.println("====================");
	  for(int i=0; i<count;i++)
	  {
		  System.out.println(js.get("data["+i+"]"));	  	  
	  }
	   
  }
}
