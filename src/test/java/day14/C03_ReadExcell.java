package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcell {
    @Test
    public void readExcellTest1() throws IOException {
        /*
        Belirtilen satır no ve sutun no degerlerini, parametre olarak alip o cell'deki
        datayi konsola yazdıralım
        Sonra sonucun konsolda yazanla aynı olduğunu doğrulayalım
         */
        int satir=12;
        int sutun=2;

        String dosyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        String actualData = workbook
                .getSheet("Sayfa1")
                .getRow(satir-1)
                .getCell(sutun-1)
                .toString();
        // index "0"'dan basladigi icin bizden istenen satira ulasabilmek icin "index-1" olarak aldık.
        System.out.println(actualData);
        Assert.assertEquals(actualData,"Baku");

    }
}
