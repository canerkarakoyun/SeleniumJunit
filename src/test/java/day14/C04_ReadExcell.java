package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_ReadExcell {
    @Test
    public void readExcellTest1() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        //-Turkce baskentler sutununu yazdiralim
        String dosyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        int sonSatir=workbook.getSheet("Sayfa1").getLastRowNum();
        //bu sekilde Sayfa1'de kaç satır veri olduğunu tespit ettik.
        System.out.println(sonSatir);
        String turkceBaskentler=""; //
        for (int i = 0; i < sonSatir; i++) {
            turkceBaskentler=workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            System.out.println(turkceBaskentler);

        }
    }
}
