package day14;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcell {
    @Test
    public void readExcellTest1() throws IOException {
        //- Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";

        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu); //olusturmus oldugumuz dosyayı sistemde isleme alir.

        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //- WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis); //workbook objesi üzerinden fis objesi ile akışa aldığımız
                                                        //dosyamıza bir excell dosyası creat ettik.

        //- Sheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet= workbook.getSheet("Sayfa1"); // Excell dosyasında calışmak istedigimiz sayfayi bu sekilde seceriz

        //- Row objesi olusturun sheet.getRow(index)
        Row row= sheet.getRow(3); // Satıra bu sekilde gideriz

        //- Cell objesi olusturun row.getCell(index)
        Cell cell= row.getCell(2);
        System.out.println(cell);
        //- 3. index'deki satirin 3. index'indeki datanin Cezayir oldugunu test edin
        String actualData= cell.getStringCellValue();
        String expectedData="Cezayir";
        Assert.assertEquals(actualData,expectedData);
    }
}
