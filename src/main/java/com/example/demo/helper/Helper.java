package com.example.demo.helper;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.ChucVu;
import com.example.demo.model.NhanVien;
import com.example.demo.model.PhongBan;


import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

public class Helper {

    //check that file is of excel type or not
    public static boolean checkExcelFormat(MultipartFile file) {

        String contentType = file.getContentType();

        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return true;
        } else {
            return false;
        }

    }


    //convert excel to list of nhanvien

    public static List<NhanVien> convertExcelToList(InputStream is, List<PhongBan> pb,List<ChucVu> cv) {
        List<NhanVien> list = new ArrayList<>();
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
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

                NhanVien p = new NhanVien();

                while (cells.hasNext()) {
                    Cell cell = cells.next();
                    switch (cid) {
                        case 0:
                            p.setTenNhanSu(cell.getStringCellValue());
                            break;
                        case 1:
                            p.setCCCD(cell.getStringCellValue());
                            break;
                        case 2:
                            p.setEmail(cell.getStringCellValue());
                            break;
                        case 3:
                            p.setNgaySinh(formatter.format(cell.getDateCellValue()));
                            break;
                        case 4:
                            p.setHinhAnh(cell.getStringCellValue());
                            break;
                        case 5:
                            p.setDanToc(cell.getStringCellValue());
                            break;
                        case 6:
                            p.setQuocTich(cell.getStringCellValue());
                            break;
                        case 7:
                            p.setNgayKyHopDong(formatter.format(cell.getDateCellValue()));
                            break;
                        case 8:
                            p.setSoTK(String.valueOf(cell.getNumericCellValue()));
                            break;
                        case 9:
                            p.setSDT(String.valueOf(cell.getNumericCellValue()));
                            break;
                       
                        default:
                            break;
                    }
                    cid++;
                }
                byte[] qrCode =BarCode.getQRCodeImage(p.toString(), 200, 200);
                String s = Base64.getEncoder().encodeToString(qrCode);
                p.setQrCode(s);
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
