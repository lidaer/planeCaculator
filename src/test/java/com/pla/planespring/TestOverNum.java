package com.pla.planespring;

import com.pla.planespring.pojo.AirCalculator;
import com.pla.planespring.pojo.Luggage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestOverNum {

    /*(area1+area2+area3+area4+area5)*(legal*overNum==(1,2,3+)+unlegal*(top+affair+ecomomic+super)) = 35 */
    @Test
    void testArea1Legal(){
        int lugtype=10;
        float hight=20;
        float width=20;
        float length=20;
        float weight=32;
        String flight ="area1";
        String seatType = "top";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight);
        Assert.assertEquals(AirCalculator.getOverNumCost(lug,seatType,flight,1),1400,1e-9);
        Assert.assertEquals(AirCalculator.getOverNumCost(lug,seatType,flight,2),2000,1e-9);
        Assert.assertEquals(AirCalculator.getOverNumCost(lug,seatType,flight,3),3000,1e-9);

    }

    @Test
    void testArea1TopUnLegal(){
        int lugtype=10;
        float hight=20;
        float width=20;
        float length=20;
        float weight=33;  //超重量
        String flight ="area1";
        String seatType = "top";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight);
        Assert.assertEquals(AirCalculator.getOverNumCost(lug,seatType,flight,1),-1,1e-9);

    }

    @Test
    void testArea1AffairUnLegal(){
        int lugtype=10;
        float hight=20;
        float width=20;
        float length=20;
        float weight=33;  //超重量
        String flight ="area1";
        String seatType = "affair";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight)      ;
        Assert.assertEquals(AirCalculator.getOverNumCost(lug,seatType,flight,1),-1,1e-9);

    }

    @Test
    void testArea1EconomicUnLegal(){
        int lugtype=10;
        float hight=20;
        float width=20;
        float length=20;
        float weight=33;  //超重量
        String flight ="area1";
        String seatType = "economic";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight)      ;
        Assert.assertEquals(AirCalculator.getOverNumCost(lug,seatType,flight,1),-1,1e-9);

    }

    @Test
    void testArea1SuperUnLegal(){
        int lugtype=10;
        float hight=20;
        float width=20;
        float length=20;
        float weight=33;  //超重量
        String flight ="area1";
        String seatType = "super";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight)      ;
        Assert.assertEquals(AirCalculator.getOverNumCost(lug,seatType,flight,1),-1,1e-9);

    }

    @Test
    void testArea2Legal(){
        int lugtype=10;
        float hight=20;
        float width=20;
        float length=20;
        float weight=32;
        String flight ="area2";
        String seatType = "top";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight)      ;
        Assert.assertEquals(AirCalculator.getOverNumCost(lug,seatType,flight,1),1100,1e-9);
        Assert.assertEquals(AirCalculator.getOverNumCost(lug,seatType,flight,2),1100,1e-9);
        Assert.assertEquals(AirCalculator.getOverNumCost(lug,seatType,flight,3),1590,1e-9);

    }

    @Test
    void testArea2TopUnLegal(){
        int lugtype=10;
        float hight=20;
        float width=20;
        float length=20;
        float weight=33;  //超重量
        String flight ="area2";
        String seatType = "top";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight);
        Assert.assertEquals(AirCalculator.getOverNumCost(lug,seatType,flight,1),-1,1e-9);

    }

    @Test
    void testArea2AffairUnLegal(){
        int lugtype=10;
        float hight=20;
        float width=20;
        float length=20;
        float weight=33;  //超重量
        String flight ="area2";
        String seatType = "affair";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight)      ;
        Assert.assertEquals(AirCalculator.getOverNumCost(lug,seatType,flight,1),-1,1e-9);

    }

    @Test
    void testArea2EconomicUnLegal(){
        int lugtype=10;
        float hight=20;
        float width=20;
        float length=20;
        float weight=33;  //超重量
        String flight ="area2";
        String seatType = "economic";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight)      ;
        Assert.assertEquals(AirCalculator.getOverNumCost(lug,seatType,flight,1),-1,1e-9);

    }

    @Test
    void testArea2SuperUnLegal(){
        int lugtype=10;
        float hight=20;
        float width=20;
        float length=20;
        float weight=33;  //超重量
        String flight ="area2";
        String seatType = "super";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight)      ;
        Assert.assertEquals(AirCalculator.getOverNumCost(lug,seatType,flight,1),-1,1e-9);

    }

    @Test
    void testArea3Legal(){
        int lugtype=10;
        float hight=20;
        float width=20;
        float length=20;
        float weight=32;
        String flight ="area3";
        String seatType = "top";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight)      ;
        Assert.assertEquals(AirCalculator.getOverNumCost(lug,seatType,flight,1),1170,1e-9);
        Assert.assertEquals(AirCalculator.getOverNumCost(lug,seatType,flight,2),1170,1e-9);
        Assert.assertEquals(AirCalculator.getOverNumCost(lug,seatType,flight,3),1590,1e-9);

    }

    @Test
    void testArea3TopUnLegal(){
        int lugtype=10;
        float hight=20;
        float width=20;
        float length=20;
        float weight=33;  //超重量
        String flight ="area3";
        String seatType = "top";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight);
        Assert.assertEquals(AirCalculator.getOverNumCost(lug,seatType,flight,1),-1,1e-9);

    }

    @Test
    void testArea3AffairUnLegal(){
        int lugtype=10;
        float hight=20;
        float width=20;
        float length=20;
        float weight=33;  //超重量
        String flight ="area3";
        String seatType = "affair";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight)      ;
        Assert.assertEquals(AirCalculator.getOverNumCost(lug,seatType,flight,1),-1,1e-9);

    }

    @Test
    void testArea3EconomicUnLegal(){
        int lugtype=10;
        float hight=20;
        float width=20;
        float length=20;
        float weight=33;  //超重量
        String flight ="area3";
        String seatType = "economic";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight)      ;
        Assert.assertEquals(AirCalculator.getOverNumCost(lug,seatType,flight,1),-1,1e-9);

    }

    @Test
    void testArea3SuperUnLegal(){
        int lugtype=10;
        float hight=20;
        float width=20;
        float length=20;
        float weight=33;  //超重量
        String flight ="area3";
        String seatType = "super";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight)      ;
        Assert.assertEquals(AirCalculator.getOverNumCost(lug,seatType,flight,1),-1,1e-9);

    }

    @Test
    void testArea4Legal(){
        int lugtype=10;
        float hight=20;
        float width=20;
        float length=20;
        float weight=32;
        String flight ="area4";
        String seatType = "top";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight)      ;
        Assert.assertEquals(AirCalculator.getOverNumCost(lug,seatType,flight,1),1380,1e-9);
        Assert.assertEquals(AirCalculator.getOverNumCost(lug,seatType,flight,2),1380,1e-9);
        Assert.assertEquals(AirCalculator.getOverNumCost(lug,seatType,flight,3),1590,1e-9);

    }

    @Test
    void testArea4TopUnLegal(){
        int lugtype=10;
        float hight=20;
        float width=20;
        float length=20;
        float weight=33;  //超重量
        String flight ="area4";
        String seatType = "top";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight);
        Assert.assertEquals(AirCalculator.getOverNumCost(lug,seatType,flight,1),-1,1e-9);

    }

    @Test
    void testArea4AffairUnLegal(){
        int lugtype=10;
        float hight=20;
        float width=20;
        float length=20;
        float weight=33;  //超重量
        String flight ="area4";
        String seatType = "affair";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight)      ;
        Assert.assertEquals(AirCalculator.getOverNumCost(lug,seatType,flight,1),-1,1e-9);

    }

    @Test
    void testArea4EconomicUnLegal(){
        int lugtype=10;
        float hight=20;
        float width=20;
        float length=20;
        float weight=33;  //超重量
        String flight ="area4";
        String seatType = "economic";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight)      ;
        Assert.assertEquals(AirCalculator.getOverNumCost(lug,seatType,flight,1),-1,1e-9);

    }

    @Test
    void testArea4SuperUnLegal(){
        int lugtype=10;
        float hight=20;
        float width=20;
        float length=20;
        float weight=33;  //超重量
        String flight ="area4";
        String seatType = "super";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight)      ;
        Assert.assertEquals(AirCalculator.getOverNumCost(lug,seatType,flight,1),-1,1e-9);

    }

    @Test
    void testArea5Legal(){
        int lugtype=10;
        float hight=20;
        float width=20;
        float length=20;
        float weight=32;
        String flight ="area5";
        String seatType = "top";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight)      ;
        Assert.assertEquals(AirCalculator.getOverNumCost(lug,seatType,flight,1),830,1e-9);
        Assert.assertEquals(AirCalculator.getOverNumCost(lug,seatType,flight,2),1100,1e-9);
        Assert.assertEquals(AirCalculator.getOverNumCost(lug,seatType,flight,3),1590,1e-9);

    }

    @Test
    void testArea5TopUnLegal(){
        int lugtype=10;
        float hight=20;
        float width=20;
        float length=20;
        float weight=33;  //超重量
        String flight ="area5";
        String seatType = "top";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight);
        Assert.assertEquals(AirCalculator.getOverNumCost(lug,seatType,flight,1),-1,1e-9);

    }

    @Test
    void testArea5AffairUnLegal(){
        int lugtype=10;
        float hight=20;
        float width=20;
        float length=20;
        float weight=33;  //超重量
        String flight ="area5";
        String seatType = "affair";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight)      ;
        Assert.assertEquals(AirCalculator.getOverNumCost(lug,seatType,flight,1),-1,1e-9);

    }

    @Test
    void testArea5EconomicUnLegal(){
        int lugtype=10;
        float hight=20;
        float width=20;
        float length=20;
        float weight=33;  //超重量
        String flight ="area5";
        String seatType = "economic";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight)      ;
        Assert.assertEquals(AirCalculator.getOverNumCost(lug,seatType,flight,1),-1,1e-9);

    }

    @Test
    void testArea5SuperUnLegal(){
        int lugtype=10;
        float hight=20;
        float width=20;
        float length=20;
        float weight=33;  //超重量
        String flight ="area5";
        String seatType = "super";
        Luggage lug = new Luggage(lugtype,hight,width,length,weight)      ;
        Assert.assertEquals(AirCalculator.getOverNumCost(lug,seatType,flight,1),-1,1e-9);

    }


}
