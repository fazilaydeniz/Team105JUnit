package day12_webtables_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {

    @Test
    public void test01() throws IOException {
        String dosyaYolu="src/test/java/day12_webtables_excel/ulkeler.xlsx";
        FileInputStream fis= new FileInputStream(dosyaYolu);

        Workbook workbook= WorkbookFactory.create(fis);

        Sheet sheet= workbook.getSheet("Sayfa1");

        Row row = sheet.getRow(5);

        Cell cell= row.getCell(2);
        System.out.println(cell);


    }
}
