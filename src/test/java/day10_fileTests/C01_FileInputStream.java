package day10_fileTests;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class C01_FileInputStream {

    @Test
    public void test01() throws FileNotFoundException {
        String dosyaYolu= "C:\\Users\\nur\\Desktop\\MerhabaJava.docx";
        FileInputStream fis= new FileInputStream(dosyaYolu);

        System.out.println(System.getProperty("user.dir"));

        System.out.println(System.getProperty("user.home"));
        /*
         File testlerinde genellıkle dowloads'a indırılecek bır dosyanın ınırıldıgını test etmek veya
          bır dosyanın web'e yuklenebıldıgını test etmek ısterız
         Ancak herkesın bılgısayarının ısmı , kullanıcı ısımlerı gıbı farklılıklar olacagınsan testler
         tek bır bılgısayarda calısacak  gibi yazılmak zorunda kalırnır.
         Bu karışıklıgın önüne geçebilmek için Java iki basit kod blogu sunmuş:
         System.out.println(System.getProperty("user.dir"));  // o anca çalışan dosyanın (C01_FileInputStream) yolunu verir
         System.out.println(System.getProperty("user.home")); //Kullanıcının temel path'ini verir.
     */

       // String dosyaYolu= "C:\\Users\\nur\\Desktop\\MerhabaJava.docx";

        String dinamikDosyaYolu=System.getProperty("user.home")+"\\Desktop\\MerhabaJava.docx";
    }
}
