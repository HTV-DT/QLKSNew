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
import java.util.Set;

import com.example.demo.model.CTBangCong;
import com.example.demo.model.NhanVien;
import com.example.demo.repository.CTBangCongRepository;

import lombok.ToString;

public class BangCongImport {
    Scanner sc = new Scanner(System.in);
    
    static List<CTBangCong> listBC = new ArrayList<>();

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
    public static List<CTBangCong> convertExcelToListOfProduct(InputStream is, List<NhanVien> ds) {
        List<CTBangCong> list = new ArrayList<>();
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
                CTBangCong ctBangCong = new CTBangCong();
               

                while (cells.hasNext()) {
                    Cell cell = cells.next();
                    switch (cid) {
                        case 0:
                            Long a = ((long) cell.getNumericCellValue());
                            for (NhanVien nhanVien : ds) {
                                if (nhanVien.getMaNV() == a) {
                                    ctBangCong.setNv(Set.of(nhanVien));
                                }
                            }
                            break;
                        case 1:
                            ctBangCong.setNgay(cell.getDateCellValue());
                            break;
                        case 2:
                            gio=cell.getDateCellValue();
                            hour=new Time(gio.getTime()); 
                            ctBangCong.setGioVao(hour);
                            break;
                        case 3:
                            gio=cell.getDateCellValue();
                            hour=new Time(gio.getTime()); 
                            ctBangCong.setGioRa(hour);
                            break;
                        case 4:
                            ctBangCong.setMaLoaiCong(cell.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                    cid++;
                }
                list.add(ctBangCong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<CTBangCong> dsBangCong(){
        return listBC;
    }
}
