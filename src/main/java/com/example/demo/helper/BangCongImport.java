package com.example.demo.helper;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.example.demo.model.BangCong;
import com.example.demo.model.NhanVien;

import lombok.ToString;

public class BangCongImport {
    Scanner sc = new Scanner(System.in);

    // check that file is of excel type or not
    public static boolean checkExcelFormat(MultipartFile file) {

        String contentType = file.getContentType();

        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return true;
        } else {
            return false;
        }

    }

    // convert excel to list of nhanvien
    public static List<BangCong> convertExcelToListOfProduct(InputStream is, List<NhanVien> ds) {
        List<BangCong> list = new ArrayList<>();
        Date gio;
        Time hour;

       
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(is);

            XSSFSheet sheet = workbook.getSheet("data");

            int rowNumber = 0;
            Iterator<Row> iterator = sheet.iterator();

            while (iterator.hasNext()) {
                Row row = iterator.next();

                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cells = row.iterator();

                int cid = 0;

                BangCong p = new BangCong();

                while (cells.hasNext()) {
                    Cell cell = cells.next();
                    switch (cid) {
                        case 0:
                            Long a = ((long) cell.getNumericCellValue());
                            for (NhanVien nhanVien : ds) {
                                if (nhanVien.getMaNV() == a) {
                                    p.setNhanVien(nhanVien);
                                    
                                }
                            }
                            break;
                        case 1:
                            p.setNgay(cell.getDateCellValue());
                            break;
                        case 2:
                            gio=cell.getDateCellValue();
                            hour=new Time(gio.getTime()); 
                            p.setGioVao(hour);
                            break;
                        case 3:
                            gio=cell.getDateCellValue();
                            hour=new Time(gio.getTime()); 
                            p.setGioRa(hour);
                            break;
                        case 4:
                            p.setMaLoaiCong(cell.getStringCellValue());
                            break;
                        case 5:
                            p.setTrangThaiCCNV(cell.getBooleanCellValue());
                            break;
                        default:
                            break;
                    }
                    cid++;
                }

                list.add(p);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
