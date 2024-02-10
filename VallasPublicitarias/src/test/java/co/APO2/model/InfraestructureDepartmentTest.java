package co.APO2.model;

import co.APO2.ui.Main;
import org.junit.*;
import co.APO2.model.InfrastructureDepartment;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InfraestructureDepartmentTest {


    public InfrastructureDepartment testID;

    {
        try {
            testID = new InfrastructureDepartment();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }





    @Test
    public void testCalculateAverageHeight() throws Exception {

        double heightTest = testID.calculateAverageHeight();
        assertEquals(302.5, heightTest, 0.1);



        //302,5
    }
    @Test
    public void testCalculateAverageWidht(){

        double widthTest = testID.calculateAverageWidth();
        assertEquals(722, widthTest, 0.1);


        //722
    }

    @Test
    public void testCalculateAverageArea(){

        double areaTest = testID.calculateAverageArea();
        assertEquals(210601.5,areaTest,0.1);
    }
    
    @Test
    public void testGetBillboardsPerBrand(){

        String messageTest = "BILLBOARDS PER BRAND\n";
        messageTest += "Auctor Quis Tristique Corp. #Billboards: 1\n";
        messageTest += "Hendrerit Institute #Billboards: 1\n";
        messageTest += "Risus Morbi LLC #Billboards: 2\n";

        String test = testID.getBillboardsPerBrand();

        assertEquals(messageTest.trim(), test.trim());
    }

    @Test
    public void testGetActiveBillboards(){
        String requiredText = "ACTIVE BILLBOARDS\n" +
                "| W  |  H  |  inUse  |  Brand \n" +
                "955.0  300.0  true  Auctor Quis Tristique Corp.\n" +
                "937.0  234.0  true  Hendrerit Institute\n" +
                "498.0  338.0  true  Risus Morbi LLC";
        String obtainedText = testID.getActivebillboards();
        assertEquals(requiredText.trim(), obtainedText.trim());
    }

}
