package com.pla.planespring;


import com.pla.planespring.pojo.AirCalculator;
import com.pla.planespring.pojo.Luggage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestOverWegOrSiz {
    /*国内+国外*(area1*5+area2*5+area3*2+area4*5+area5*5)=23 */
    @Test
    void testInternal(){
        int lugtype=10;
        float hight=1;
        float width=1;
        float length=1;
        float weight=10;
        String flight ="area1";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight)      ;
        //expect 10*2000*0.005
        Assert.assertEquals(AirCalculator.getOverWeightOrSizeCost(lug,true,flight),weight*2000*15/1000,1e-9);
    }

    @Test
    void testForeignArea1P1(){
        int lugtype=10;
        float hight=20;
        float width=20;
        float length=20;
        float weight=28;
        String flight ="area1";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight)      ;
        //expect 10*2000*0.005
        Assert.assertEquals(AirCalculator.getOverWeightOrSizeCost(lug,false,flight),380,1e-9);
    }

    @Test
    void testForeignArea1P2(){
        int lugtype=10;
        float hight=20;
        float width=20;
        float length=20;
        float weight=32;
        String flight ="area1";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight)      ;
        //expect 10*2000*0.005
        Assert.assertEquals(AirCalculator.getOverWeightOrSizeCost(lug,false,flight),980,1e-9);
    }

    @Test
    void testForeignArea1P3(){
        int lugtype=10;
        float hight=120;
        float width=20;
        float length=20;
        float weight=23;
        String flight ="area1";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight)      ;
        //expect 10*2000*0.005
        Assert.assertEquals(AirCalculator.getOverWeightOrSizeCost(lug,false,flight),980,1e-9);
    }

    @Test
    void testForeignArea1P4(){
        int lugtype=10;
        float hight=120;
        float width=20;
        float length=20;
        float weight=32;
        String flight ="area1";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight)      ;
        //expect 10*2000*0.005
        Assert.assertEquals(AirCalculator.getOverWeightOrSizeCost(lug,false,flight),1400,1e-9);
    }

    @Test
    void testForeignArea1P5(){
        int lugtype=10;
        float hight=19;
        float width=20;
        float length=20;
        float weight=23;
        String flight ="area1";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight)      ;
        //expect 10*2000*0.005
        Assert.assertEquals(AirCalculator.getOverWeightOrSizeCost(lug,false,flight),0,1e-9);
    }

    @Test
    void testForeignArea2P1(){
        int lugtype=10;
        float hight=20;
        float width=20;
        float length=20;
        float weight=28;
        String flight ="area2";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight)      ;
        Assert.assertEquals(AirCalculator.getOverWeightOrSizeCost(lug,false,flight),280,1e-9);
    }

    @Test
    void testForeignArea2P2(){
        int lugtype=10;
        float hight=20;
        float width=20;
        float length=20;
        float weight=32;
        String flight ="area2";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight)      ;
        Assert.assertEquals(AirCalculator.getOverWeightOrSizeCost(lug,false,flight),690,1e-9);
    }

    @Test
    void testForeignArea2P3(){
        int lugtype=10;
        float hight=120;
        float width=20;
        float length=20;
        float weight=23;
        String flight ="area2";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight)      ;
        Assert.assertEquals(AirCalculator.getOverWeightOrSizeCost(lug,false,flight),690,1e-9);
    }

    @Test
    void testForeignArea2P4(){
        int lugtype=10;
        float hight=120;
        float width=20;
        float length=20;
        float weight=32;
        String flight ="area2";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight)      ;
        Assert.assertEquals(AirCalculator.getOverWeightOrSizeCost(lug,false,flight),1100,1e-9);
    }

    @Test
    void testForeignArea2P5(){
        int lugtype=10;
        float hight=19;
        float width=20;
        float length=20;
        float weight=23;
        String flight ="area2";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight);
        Assert.assertEquals(AirCalculator.getOverWeightOrSizeCost(lug,false,flight),0,1e-9);
    }

    @Test
    void testForeignArea3P1(){
        int lugtype=10;
        float hight=20;
        float width=20;
        float length=20;
        float weight=28;
        String flight ="area3";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight)      ;
        Assert.assertEquals(AirCalculator.getOverWeightOrSizeCost(lug,false,flight),520,1e-9);
    }

    @Test
    void testForeignArea3P2(){
        int lugtype=10;
        float hight=120;
        float width=20;
        float length=20;
        float weight=33;
        String flight ="area3";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight)      ;
        Assert.assertEquals(AirCalculator.getOverWeightOrSizeCost(lug,false,flight),520,1e-9);
    }

    @Test
    void testForeignArea3P3(){
        int lugtype=10;
        float hight=120;
        float width=120;
        float length=20;
        float weight=231;
        String flight ="area3";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight)      ;
        Assert.assertEquals(AirCalculator.getOverWeightOrSizeCost(lug,false,flight),0,1e-9);
    }

    @Test
    void testForeignArea4P1(){
        int lugtype=10;
        float hight=20;
        float width=20;
        float length=20;
        float weight=28;
        String flight ="area4";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight)      ;
        Assert.assertEquals(AirCalculator.getOverWeightOrSizeCost(lug,false,flight),690,1e-9);
    }

    @Test
    void testForeignArea4P2(){
        int lugtype=10;
        float hight=20;
        float width=20;
        float length=20;
        float weight=32;
        String flight ="area4";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight)      ;
        Assert.assertEquals(AirCalculator.getOverWeightOrSizeCost(lug,false,flight),1040,1e-9);
    }

    @Test
    void testForeignArea4P3(){
        int lugtype=10;
        float hight=120;
        float width=20;
        float length=20;
        float weight=23;
        String flight ="area4";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight)      ;
        Assert.assertEquals(AirCalculator.getOverWeightOrSizeCost(lug,false,flight),1040,1e-9);
    }

    @Test
    void testForeignArea4P4(){
        int lugtype=10;
        float hight=120;
        float width=20;
        float length=20;
        float weight=32;
        String flight ="area4";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight)      ;
        Assert.assertEquals(AirCalculator.getOverWeightOrSizeCost(lug,false,flight),2050,1e-9);
    }

    @Test
    void testForeignArea4P5(){
        int lugtype=10;
        float hight=19;
        float width=20;
        float length=20;
        float weight=23;
        String flight ="area4";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight);
        Assert.assertEquals(AirCalculator.getOverWeightOrSizeCost(lug,false,flight),0,1e-9);
    }

    @Test
    void testForeignArea5P1(){
        int lugtype=10;
        float hight=20;
        float width=20;
        float length=20;
        float weight=28;
        String flight ="area5";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight)      ;
        Assert.assertEquals(AirCalculator.getOverWeightOrSizeCost(lug,false,flight),210,1e-9);
    }

    @Test
    void testForeignArea5P2(){
        int lugtype=10;
        float hight=20;
        float width=20;
        float length=20;
        float weight=32;
        String flight ="area5";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight)      ;
        Assert.assertEquals(AirCalculator.getOverWeightOrSizeCost(lug,false,flight),520,1e-9);
    }

    @Test
    void testForeignArea5P3(){
        int lugtype=10;
        float hight=120;
        float width=20;
        float length=20;
        float weight=23;
        String flight ="area5";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight)      ;
        Assert.assertEquals(AirCalculator.getOverWeightOrSizeCost(lug,false,flight),520,1e-9);
    }

    @Test
    void testForeignArea5P4(){
        int lugtype=10;
        float hight=120;
        float width=20;
        float length=20;
        float weight=32;
        String flight ="area5";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight)      ;
        Assert.assertEquals(AirCalculator.getOverWeightOrSizeCost(lug,false,flight),830,1e-9);
    }

    @Test
    void testForeignArea5P5(){
        int lugtype=10;
        float hight=19;
        float width=20;
        float length=20;
        float weight=23;
        String flight ="area5";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight);
        Assert.assertEquals(AirCalculator.getOverWeightOrSizeCost(lug,false,flight),0.0,1e-9);

    }

}
