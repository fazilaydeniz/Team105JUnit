package day05_junitFramework;

import org.junit.Ignore;
import org.junit.Test;

public class C01_ElvedaMainMathod {
    @Test
    public void test01(){
        System.out.println("Test01 çalıştı");
        //@Test notasyonu sayesinde her bir test method'u bağımsız olarak çalışabilir.
        // Eğer testin içerisinde bir assertion yoksa
        // kod problem yaşanmadan çalışıp bittiğinde
        // JUnit test passed olarak raporlar.
    }
    @Test @Ignore
    public void test02(){
        System.out.println("Test02 çalıştı");
        //@Ignore notasyonu yazıldığı test methosunun çalıştırılmamasını sağlar.
    }
    @Test
    public void test03(){
        System.out.println("Test03 çalıştı");
    }

}
