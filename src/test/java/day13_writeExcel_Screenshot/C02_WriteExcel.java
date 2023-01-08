package day13_writeExcel_Screenshot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {
    @Test
    public void test01() throws IOException {
        //Excel dosyasından kopyaladığımız workbook objesi üzerinde değişiklik yapabiliriz.
        // bunun için öncelikle excelin kopyası olan workbooku oluşturalım.

        String dosyaYolu="src/test/java/day12_webtables_excel/ulkeler.xlsx";
        FileInputStream fis= new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        // Şimdi bu workbook objesi üzerinde değişiklikler yapalım.
        //5. Sütun olarak nüfus başlığı ile bie sütun oluşturalım.
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nüfus");

        //3. satırdaki Nüfus bilgisini 1500000 yapalım
        workbook.getSheet("Sayfa1").getRow(2).createCell(4).setCellValue("1500000");

        //7. Satırdaki nüfus bilgisini 3000000 yapalım
        workbook.getSheet("Sayfa1").getRow(6).createCell(4).setCellValue("3000000");

        // yaptığımız değişiklikler kopya workbook üzerinde. Bu değişiklikleri Excel dosyasına kaydetmek için
        //bunun için FileOutputStream classını kullanmalıyız

        FileOutputStream fos=new FileOutputStream(dosyaYolu);
        workbook.write(fos);

        workbook.close();
        fis.close();
        fos.close();
    }
}
