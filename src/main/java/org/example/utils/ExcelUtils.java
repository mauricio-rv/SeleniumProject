package org.example.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtils {
    public String[][] getCellData(String path, String sheetname) throws IOException {
        try{
            FileInputStream stream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(stream);
            Sheet sheet = workbook.getSheet(sheetname);
            int rowNum = sheet.getLastRowNum();
            int colNum = sheet.getRow(0).getLastCellNum();
            String[][] data = new String[rowNum][colNum];
            for (int i = 1; i <= rowNum; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < colNum; j++) {
                    Cell cell = row.getCell(j);
                    if (cell.getCellType() == CellType.STRING) {
                        data[i - 1][j] = cell.getStringCellValue();
                    }
                    else
                    {
                        data[i - 1][j] = String.valueOf(cell.getNumericCellValue());
                    }
                    System.out.println(data[i-1][j]);
                }
            }
            return data;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
