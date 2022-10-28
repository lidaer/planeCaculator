package com.pla.planespring;


import com.pla.planespring.pojo.AirCalculator;
import com.pla.planespring.pojo.Luggage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSpecialCost {
    /* type2*2+type3*3+type4*3+type5*2+type6*3+type7*3+type8*3+type9*3 = 22 */

    @Test
    void testType2UnFree(){
        int lugtype=2;
        float hight=20,width=20,length=20;
        float weight=32;
        String flight ="area1";
        int free_takes = 0;
        float free_weight = 0;
        Luggage lug = new Luggage(lugtype,hight,width,length,weight);
        float expected = AirCalculator.getOverWeightOrSizeCost(lug,false,flight);
        Assert.assertEquals(AirCalculator.getSpecialCost(lug,false,free_takes,free_weight,flight),
        expected,1e-9);
    }

    @Test
    void testType2Free(){
        int lugtype=2;
        float hight=20,width=20,length=20;
        float weight=24;
        String flight ="area2";
        int free_takes = 1;
        float free_weight = 30;
        Luggage lug = new Luggage(lugtype,hight,width,length,weight);
        float expected = 0;
        Assert.assertEquals(AirCalculator.getSpecialCost(lug,false,free_takes,free_weight,flight),
                expected,1e-9);
    }

    @Test
    void testType3W1(){
        int lugtype=3;
        float hight=20,width=20,length=20;
        float weight=2;
        String flight ="area3";
        int free_takes = 0;
        float free_weight = 0;
        Luggage lug = new Luggage(lugtype,hight,width,length,weight);
        float expected = 2600;
        Assert.assertEquals(AirCalculator.getSpecialCost(lug,false,free_takes,free_weight,flight),
                expected,1e-9);
    }

    @Test
    void testType3W2(){
        int lugtype=3;
        float hight=20,width=20,length=20;
        float weight=32;
        String flight ="area3";
        int free_takes = 0;
        float free_weight = 0;
        Luggage lug = new Luggage(lugtype,hight,width,length,weight);
        float expected = 3900;
        Assert.assertEquals(AirCalculator.getSpecialCost(lug,false,free_takes,free_weight,flight),
                expected,1e-9);
    }

    @Test
    void testType3W3(){
        int lugtype=3;
        float hight=20,width=20,length=20;
        float weight=33;
        String flight ="area3";
        int free_takes = 0;
        float free_weight = 0;
        Luggage lug = new Luggage(lugtype,hight,width,length,weight);
        float expected = 5200;
        Assert.assertEquals(AirCalculator.getSpecialCost(lug,false,free_takes,free_weight,flight),
                expected,1e-9);
    }

    @Test
    void testType3W4(){
        int lugtype=3;
        float hight=20,width=20,length=20;
        float weight=46;
        String flight ="area3";
        int free_takes = 0;
        float free_weight = 0;
        Luggage lug = new Luggage(lugtype,hight,width,length,weight);
        float expected = -1;
        Assert.assertEquals(AirCalculator.getSpecialCost(lug,false,free_takes,free_weight,flight),
                expected,1e-9);
    }

    @Test
    void testType4W1(){
        int lugtype=4;
        float hight=20,width=20,length=20;
        float weight=2;
        String flight ="area4";
        int free_takes = 0;
        float free_weight = 0;
        Luggage lug = new Luggage(lugtype,hight,width,length,weight);
        float expected = 1300;
        Assert.assertEquals(AirCalculator.getSpecialCost(lug,false,free_takes,free_weight,flight),
                expected,1e-9);
    }

    @Test
    void testType4W2(){
        int lugtype=4;
        float hight=20,width=20,length=20;
        float weight=32;
        String flight ="area4";
        int free_takes = 0;
        float free_weight = 0;
        Luggage lug = new Luggage(lugtype,hight,width,length,weight);
        float expected = 2600;
        Assert.assertEquals(AirCalculator.getSpecialCost(lug,false,free_takes,free_weight,flight),
                expected,1e-9);
    }

    @Test
    void testType4W3(){
        int lugtype=4;
        float hight=20,width=20,length=20;
        float weight=33;
        String flight ="area4";
        int free_takes = 0;
        float free_weight = 0;
        Luggage lug = new Luggage(lugtype,hight,width,length,weight);
        float expected = 3900;
        Assert.assertEquals(AirCalculator.getSpecialCost(lug,false,free_takes,free_weight,flight),
                expected,1e-9);
    }

    @Test
    void testType4W4(){
        int lugtype=4;
        float hight=20,width=20,length=20;
        float weight=46;
        String flight ="area4";
        int free_takes = 0;
        float free_weight = 0;
        Luggage lug = new Luggage(lugtype,hight,width,length,weight);
        float expected = -1;
        Assert.assertEquals(AirCalculator.getSpecialCost(lug,false,free_takes,free_weight,flight),
                expected,1e-9);
    }

    @Test
    void testType5UnFree(){
        int lugtype=5;
        float hight=20,width=20,length=20;
        float weight=32;
        String flight ="area5";
        int free_takes = 0;
        float free_weight = 0;
        Luggage lug = new Luggage(lugtype,hight,width,length,weight);
        float expected = AirCalculator.getOverWeightOrSizeCost(lug,false,flight);
        Assert.assertEquals(AirCalculator.getSpecialCost(lug,false,free_takes,free_weight,flight),
                expected,1e-9);
    }

    @Test
    void testType5Free(){
        int lugtype=5;
        float hight=20,width=20,length=20;
        float weight=24;
        String flight ="area5";
        int free_takes = 1;
        float free_weight = 30;
        Luggage lug = new Luggage(lugtype,hight,width,length,weight);
        float expected = 0;
        Assert.assertEquals(AirCalculator.getSpecialCost(lug,false,free_takes,free_weight,flight),
                expected,1e-9);
    }

    @Test
    void testType6W1(){
        int lugtype=6;
        float hight=20,width=20,length=20;
        float weight=2;
        String flight ="area1";
        int free_takes = 0;
        float free_weight = 0;
        Luggage lug = new Luggage(lugtype,hight,width,length,weight);
        float expected = 490;
        Assert.assertEquals(AirCalculator.getSpecialCost(lug,false,free_takes,free_weight,flight),
                expected,1e-9);
    }

    @Test
    void testType6W2(){
        int lugtype=6;
        float hight=20,width=20,length=20;
        float weight=32;
        String flight ="area1";
        int free_takes = 0;
        float free_weight = 0;
        Luggage lug = new Luggage(lugtype,hight,width,length,weight);
        float expected = 3900;
        Assert.assertEquals(AirCalculator.getSpecialCost(lug,false,free_takes,free_weight,flight),
                expected,1e-9);
    }

    @Test
    void testType6W3(){
        int lugtype=6;
        float hight=20,width=20,length=20;
        float weight=33;
        String flight ="area1";
        int free_takes = 0;
        float free_weight = 0;
        Luggage lug = new Luggage(lugtype,hight,width,length,weight);
        float expected = -1;
        Assert.assertEquals(AirCalculator.getSpecialCost(lug,false,free_takes,free_weight,flight),
                expected,1e-9);
    }

    @Test
    void testType6W4(){
        int lugtype=6;
        float hight=20,width=20,length=20;
        float weight=46;
        String flight ="area3";
        int free_takes = 0;
        float free_weight = 0;
        Luggage lug = new Luggage(lugtype,hight,width,length,weight);
        float expected = -1;
        Assert.assertEquals(AirCalculator.getSpecialCost(lug,false,free_takes,free_weight,flight),
                expected,1e-9);
    }

    @Test
    void testType7W1(){
        int lugtype=7;
        float hight=20,width=20,length=20;
        float weight=2;
        String flight ="area1";
        int free_takes = 0;
        float free_weight = 0;
        Luggage lug = new Luggage(lugtype,hight,width,length,weight);
        float expected = 1300;
        Assert.assertEquals(AirCalculator.getSpecialCost(lug,false,free_takes,free_weight,flight),
                expected,1e-9);
    }

    @Test
    void testType7W2(){
        int lugtype=7;
        float hight=20,width=20,length=20;
        float weight=32;
        String flight ="area1";
        int free_takes = 0;
        float free_weight = 0;
        Luggage lug = new Luggage(lugtype,hight,width,length,weight);
        float expected = 3900;
        Assert.assertEquals(AirCalculator.getSpecialCost(lug,false,free_takes,free_weight,flight),
                expected,1e-9);
    }

    @Test
    void testType7W3(){
        int lugtype=7;
        float hight=20,width=20,length=20;
        float weight=46;
        String flight ="area1";
        int free_takes = 0;
        float free_weight = 0;
        Luggage lug = new Luggage(lugtype,hight,width,length,weight);
        float expected = -1;
        Assert.assertEquals(AirCalculator.getSpecialCost(lug,false,free_takes,free_weight,flight),
                expected,1e-9);
    }

    @Test
    void testType8W1(){
        int lugtype=8;
        float hight=20,width=20,length=20;
        float weight=2;
        String flight ="area1";
        int free_takes = 0;
        float free_weight = 0;
        Luggage lug = new Luggage(lugtype,hight,width,length,weight);
        float expected = 1300;
        Assert.assertEquals(AirCalculator.getSpecialCost(lug,false,free_takes,free_weight,flight),
                expected,1e-9);
    }

    @Test
    void testType8W2(){
        int lugtype=8;
        float hight=20,width=20,length=20;
        float weight=32;
        String flight ="area1";
        int free_takes = 0;
        float free_weight = 0;
        Luggage lug = new Luggage(lugtype,hight,width,length,weight);
        float expected = -1;
        Assert.assertEquals(AirCalculator.getSpecialCost(lug,false,free_takes,free_weight,flight),
                expected,1e-9);
    }

    @Test
    void testType9W1(){
        int lugtype=9;
        float hight=20,width=20,length=20;
        float weight=2;
        String flight ="area1";
        int free_takes = 0;
        float free_weight = 0;
        Luggage lug = new Luggage(lugtype,hight,width,length,weight);
        float expected = 1300;
        Assert.assertEquals(AirCalculator.getSpecialCost(lug,false,free_takes,free_weight,flight),
                expected,1e-9);
    }

    @Test
    void testType9W2(){
        int lugtype=9;
        float hight=20,width=20,length=20;
        float weight=23;
        String flight ="area1";
        int free_takes = 0;
        float free_weight = 0;
        Luggage lug = new Luggage(lugtype,hight,width,length,weight);
        float expected = 2600;
        Assert.assertEquals(AirCalculator.getSpecialCost(lug,false,free_takes,free_weight,flight),
                expected,1e-9);
    }

    @Test
    void testType9W3(){
        int lugtype=9;
        float hight=20,width=20,length=20;
        float weight=32;
        String flight ="area1";
        int free_takes = 0;
        float free_weight = 0;
        Luggage lug = new Luggage(lugtype,hight,width,length,weight);
        float expected = 3900;
        Assert.assertEquals(AirCalculator.getSpecialCost(lug,false,free_takes,free_weight,flight),
                expected,1e-9);
    }

    @Test
    void testType9W4(){
        int lugtype=9;
        float hight=20,width=20,length=20;
        float weight=33;
        String flight ="area3";
        int free_takes = 0;
        float free_weight = 0;
        Luggage lug = new Luggage(lugtype,hight,width,length,weight);
        float expected = -1;
        Assert.assertEquals(AirCalculator.getSpecialCost(lug,false,free_takes,free_weight,flight),
                expected,1e-9);
    }

}
