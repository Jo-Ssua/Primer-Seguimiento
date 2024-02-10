package co.APO2.model;

import co.APO2.ui.Main;
import org.junit.*;
import co.APO2.model.InfrastructureDepartment;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InfraestructureDepartmentTest {

    public InfrastructureDepartment testID1;
    public InfrastructureDepartment testID2;


    @Before
    public void setUp(){
        {
            try {
                testID1 = new InfrastructureDepartment();
                //VallasPublicitarias\target\classes\Test.csv
                testID1.loadBillboard("Test.csv");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Before
    public void setUp2(){
        {
            try {
                testID2 = new InfrastructureDepartment();
                //VallasPublicitarias\target\classes\Test.csv
                testID2.loadBillboard("Test2.csv");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }






    @Test
    public void testCalculateAverageHeight() throws Exception {

        double heightTest = testID1.calculateAverageHeight();
        assertEquals(302.5, heightTest, 0.1);

        heightTest = testID2.calculateAverageHeight();
        assertEquals(2.5, heightTest, 0.1);


    }
    @Test
    public void testCalculateAverageWidht(){

        double widthTest = testID1.calculateAverageWidth();
        assertEquals(722, widthTest, 0.1);

        widthTest = testID2.calculateAverageWidth();
        assertEquals(2.5, widthTest, 0.1);



    }

    @Test
    public void testCalculateAverageArea(){

        double areaTest = testID1.calculateAverageArea();
        assertEquals(210601.5,areaTest,0.1);

        areaTest = testID2.calculateAverageArea();
        assertEquals(7.5,areaTest,0.1);
    }
    
    @Test
    public void testGetBillboardsPerBrand(){

        String messageTest = "BILLBOARDS PER BRAND\n";
        messageTest += "Auctor Quis Tristique Corp. #Billboards: 1\n";
        messageTest += "Hendrerit Institute #Billboards: 1\n";
        messageTest += "Risus Morbi LLC #Billboards: 2\n";

        String test = testID1.getBillboardsPerBrand();

        assertEquals(messageTest.trim(), test.trim());

        messageTest =  "BILLBOARDS PER BRAND\n";




    }

    @Test
    public void testGetActiveBillboards(){
        String requiredText = "ACTIVE BILLBOARDS\n" +
                "| W  |  H  |  inUse  |  Brand \n" +
                "955.0  300.0  true  Auctor Quis Tristique Corp.\n" +
                "937.0  234.0  true  Hendrerit Institute\n" +
                "498.0  338.0  true  Risus Morbi LLC";
        String obtainedText = testID1.getActivebillboards();
        assertEquals(requiredText.trim(), obtainedText.trim());

        requiredText = "No hay vallas activas";
        obtainedText = testID2.getActivebillboards();

        assertEquals(requiredText.trim(), obtainedText.trim());
    }

}
