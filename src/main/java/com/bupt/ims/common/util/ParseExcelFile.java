package com.bupt.ims.common.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import com.alibaba.fastjson.JSONObject;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.*;

public class ParseExcelFile {
    private XSSFWorkbook xssfWorkbook;
    private XSSFSheet sheet;
    private int colNum;
    private int rowNum;
    private int offset;
    private ArrayList<String> header;

    public ParseExcelFile(String file) {
        try (FileInputStream fin = new FileInputStream(file)){
            this.xssfWorkbook = new XSSFWorkbook(fin);
            this.sheet = xssfWorkbook.getSheetAt(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.colNum = this.sheet.getRow(0).getPhysicalNumberOfCells();
        this.rowNum = this.sheet.getPhysicalNumberOfRows();
        this.offset = this.sheet.getFirstRowNum() + 1;
        this.header = getHeader();
    }

    private ArrayList<String> getHeader() {
        ArrayList<String> header = new ArrayList<>();
        for (int i = 0; i < this.colNum; i++) {
            this.sheet.getRow(0).getCell(i).setCellType(CellType.STRING);
            header.add(this.sheet.getRow(0).getCell(i).toString());
        }
        return header;
    }

    public boolean hasNext() {
        return this.offset < this.rowNum;
    }

    public JSONObject next() {
        JSONObject json = new JSONObject();
        for (int i = 0; i < this.colNum; i++) {
            json.put(this.header.get(i), getCellVal(this.sheet.getRow(offset).getCell(i)));
        }
        this.offset++;
        return json;
    }

    private String getCellVal(Cell cell) {
        String str = null;
        switch (cell.getCellType()) {
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) { // 日期格式

                    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                    str = fmt.format(cell.getStringCellValue());
                    str = "";
                } else { // 数字格式
                    DecimalFormat df = new DecimalFormat("0");
                    str = df.format(cell.getNumericCellValue());
                }
                break;
            case STRING:
                str = cell.getStringCellValue();
                break;
            default:
                str = cell.toString();
                break;
        }
        return str;
    }
}
