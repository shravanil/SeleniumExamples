package FrameworkLibrary;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExcelLibrary 
{
	public static HashMap<String,String> CurrentTestData;
	
	public static String getdata(String FieldName)
	{
		if (CurrentTestData.containsKey(FieldName)) 
		{
			return CurrentTestData.get(FieldName);
		} else 
		{
			System.out.println("Data Not Found For '" + FieldName + "' Field");
			return null;
		}
	}
	
	public static void putdata(String FieldName,String FieldValue)
	{
		if (CurrentTestData.containsKey(FieldName)) 
		{
			CurrentTestData.put(FieldName, FieldValue);
		} 
		else 
		{
			System.out.println(FieldName + "' Field is not found in Excel");
		}
	}
	
	public static HashMap<String, String> loadDataFromExceltoHashMap(String TestCaseName, String ModuleName) 
	{
		HashMap<String, String> TestData = new HashMap<String, String>();
		try {
			String FilePath = BaseClass.DataFilesPath + "\\" + ModuleName + ".xlsx";
			File f1 = new File(FilePath);
			FileInputStream fis = new FileInputStream(f1);
			XSSFWorkbook wb1 = new XSSFWorkbook(fis);

			XSSFSheet ws1 = wb1.getSheet("TestData");

			int rowcount = ws1.getLastRowNum();
			for (int r = 0; r <= rowcount; r++) {
				if (ws1.getRow(r).getCell(0) != null) {
					String Excel_TestCaseName = ws1.getRow(r).getCell(0).getStringCellValue();
					if (Excel_TestCaseName.equalsIgnoreCase(TestCaseName)) {
						int datarow = r;
						int valuerow = r + 1;
						int cellcount = ws1.getRow(datarow).getLastCellNum();
						for (int c = 1; c < cellcount; c++) {
							String ExcelFieldName = "";
							String ExcelFieldValue = "";
							if (ws1.getRow(datarow).getCell(c) != null)
								ExcelFieldName = ws1.getRow(datarow).getCell(c).getStringCellValue();
							if (ws1.getRow(valuerow).getCell(c) != null)
								ExcelFieldValue = ws1.getRow(valuerow).getCell(c).getStringCellValue();
							if (ExcelFieldName.length() > 1)
								TestData.put(ExcelFieldName, ExcelFieldValue);
						}
						break;
					}
				}
			}
			fis.close();
			wb1.close();
		} catch (Exception e) {
			System.out.println("Exception occured while reading data of '" + TestCaseName + "'  TestCase and '"
					+ ModuleName + "' Module");
		}
		return TestData;
	}
	
	public static void loadDataFromJsontoHashMap()
	{
		ObjectMapper mapper = new ObjectMapper();

		try
		{
			Map<? extends String, ? extends String> map = mapper.readValue(
					new File("DataFiles\\GlobalData.json"), 
					new TypeReference<Map<String, Object>>() {
			});
			CurrentTestData.putAll(map);
		}
		catch(Exception e)
		{
			System.out.println("Unable to read data from json file");
		}
	}
	
	
	public static void loadDataFromHashMaptoExcel(String TestCaseName, String ModuleName) 
	{
		HashMap<String, String> TestData = CurrentTestData;
		try 
		{
			String FilePath = BaseClass.DataFilesPath + "\\" + ModuleName + ".xlsx";
			File f1 = new File(FilePath);
			FileInputStream fis = new FileInputStream(f1);
			XSSFWorkbook wb1 = new XSSFWorkbook(fis);

			XSSFSheet ws1 = wb1.getSheet("TestData");

			int rowcount = ws1.getLastRowNum();
			for (int r = 0; r <= rowcount; r++) 
			{
				if (ws1.getRow(r).getCell(0) != null)
				{
					String Excel_TestCaseName = ws1.getRow(r).getCell(0).getStringCellValue();
					if (Excel_TestCaseName.equalsIgnoreCase(TestCaseName)) 
					{
						int datarow = r ;
						int valuerow = r + 1;
						int cellcount = ws1.getRow(datarow).getLastCellNum();
						for (int c = 1; c < cellcount; c++) 
						{
							String ExcelFieldName = "";
							if (ws1.getRow(datarow).getCell(c) != null)
							{
								ExcelFieldName = ws1.getRow(datarow).getCell(c).getStringCellValue();
								if(TestData.containsKey(ExcelFieldName))
								{
									if (ws1.getRow(valuerow).getCell(c) == null)
									{
										ws1.getRow(valuerow).createCell(c);
									}
									ws1.getRow(valuerow).getCell(c).setCellValue(TestData.get(ExcelFieldName));
								}
							}
						}
						break;
					}
				}
			}
			fis.close();
			FileOutputStream fos = new FileOutputStream(f1);
			wb1.write(fos);
			fos.close();
			wb1.close();
		} catch (Exception e) 
		{
			System.out.println("Exception occured while writing data of '" + TestCaseName + "'  TestCase and '"
					+ ModuleName + "' Module");
		}
	}
}
