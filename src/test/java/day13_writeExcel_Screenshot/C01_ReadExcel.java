package day13_writeExcel_Screenshot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void test01() throws IOException {
        // Excel dosyaları bilgisarımızda olduğu için
        // Javadan FileInputStream classı yardımıyla ulaşacağız

        String dosyaYolu="src/test/java/day12_webtables_excel/ulkeler.xlsx";

        FileInputStream fis= new FileInputStream(dosyaYolu);

        Workbook workbook= WorkbookFactory.create(fis);

        System.out.println(workbook.getSheet("Sayfa1").getRow(3).getCell(1));
        // Böylece workbooka yüklediğimiz ülkeler dosyasının 1. sayfasının 4. satırının 1. datasını yazdırırız.

        // Satır ve sütun  bilgisini parametre olarak alıp
        // o hücredeki bilgiyi yazdıran bir method oluşturun.
        dataYazdir(25,2); // Brunei
        dataYazdir(14,3); // Dakka

    }
    private  void dataYazdir(int satir, int sutun) throws IOException {
        String dosyaYolu="src/test/java/day12_webtables_excel/ulkeler.xlsx";

        FileInputStream fis= new FileInputStream(dosyaYolu);

        Workbook workbook= WorkbookFactory.create(fis);

        System.out.println(workbook.getSheet("Sayfa1").getRow(satir).getCell(sutun));

    }

}
