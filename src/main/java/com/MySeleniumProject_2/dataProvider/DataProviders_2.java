package com.MySeleniumProject_2.dataProvider;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.testng.annotations.DataProvider;
import com.MySeleniumProject_2.utility.NewExcelLibrary_2;

public class DataProviders_2 {
	NewExcelLibrary_2 obj = new NewExcelLibrary_2("C:\\Users\\ravindrs\\Desktop\\SELEMIUM_PROJECT_2\\TestData\\UserData.xlsx");
	
	@DataProvider(name ="Login") // Data provider name
	public Object[][] getCredentials(){
		int rows = obj.getRowCount("login"); //sheet name
		int column = obj.getColumnCount("login");
		int actRows=rows-1;
		
		Object[][] data = new Object[actRows][column];
		for (int i = 0; i< actRows; i++) {
			 for (int j = 0;j < column; j++) {
				 data[i][j] = obj.getCellData("login", j, i+1); //getCellData(Sheet-name, column, row)
			 }
		}
		return data;
	}
	
	@DataProvider(name = "User_Details")
	public Object[][] getEmail() {
		// Totals rows count
		int rows = obj.getRowCount("userdetails");
		// Total Columns
		int column = obj.getColumnCount("userdetails");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j =  0; j < column; j++) {
				data[i][j] = obj.getCellData("userdetails", j, i + 1);
			}
		}
		return data;
	}

//Class --> AddToCartPageTest, EndToEndTest,  Test Case--> addToCartTest, endToEndTest	
	@DataProvider(name = "getProduct")
	public Object[][] getProduct() {
		// Totals rows count
		int rows = obj.getRowCount("ProductDetails");
		// Total Columns
		int column = obj.getColumnCount("ProductDetails");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("ProductDetails", j, i + 2);
			}
		}
		return data;
	}

	// Class --> SearchResultPageTest, Test Case--> productAvailabilityTest
	@DataProvider(name = "searchProduct")
	public Object[][] getProductPrice() {
		// Totals rows count
		int rows = obj.getRowCount("SearchProduct");
		// Total Columns
		int column = obj.getColumnCount("SearchProduct");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("SearchProduct", j, i + 2);
			}
		}
		return data;
	}
	
	@DataProvider(name = "newAcountDetailsData")
	public Object[][] accountCreation() {
		int rows = obj.getRowCount("AccountCreationData");
		// Total Columns
		int column = obj.getColumnCount("AccountCreationData");
		int actRows = rows - 1;
		//Created an object of array to store data
		Object[][] data = new Object[actRows][1];
		
		for (int i = 0; i < actRows; i++) {
			Map<String, String> hashMap = new HashMap<>();
			for (int j = 0; j < column; j++) {
				hashMap.put(obj.getCellData("AccountCreationData", j, 1),
						obj.getCellData("AccountCreationData", j, i + 2));
			}
			data[i][0]=hashMap;
		}
		return data;
	}
	

}	

