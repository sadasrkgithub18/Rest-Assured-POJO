package com.qa.pack4;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pack2.ReUsableMethods;
import com.qa.pack2.payload;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DynamicJSONObj 
{
	@Test(dataProvider="BooksData")
	public void addBook(String isbn,String aisle)
	{
	RestAssured.baseURI="http://216.10.245.166";
	Response resp = given().

	header("Content-Type","application/json").

	body(payload.Addbook(isbn,aisle)).

	when().

	post("/Library/Addbook.php").

	then().assertThat().statusCode(200).

	extract().response();

	//JsonPath js= ReUsableMethods.rawToJson(resp);

	  // String id=js.get("ID");

	   //System.out.println(id);

	   

	   //deleteBOok

	}

	@DataProvider(name="BooksData")
	public Object[][]  getData()
	{
	//array=collection of elements
	//multidimensional array= collection of arrays
	return new Object[][] {{"ojfwty","9363"},{"cwetee","4253"},{"okmfet","533"}};
	}

}
