package com.pla.planespring.pojo;

import java.util.List;

public class AirCalculator {


    static float hand_len = 55,hand_wid=40,hand_heg=20;    //随身行李最大长宽高

    static float free_weight = 0;


    public static float calculator(List<Luggage>luggs,boolean internal,String seatType,String trav_type,String flight){
        float totoalPrice = 0;
        int hand_takes=1;       //随身行李最大数量
        float hand_weight=5;    //随身行李最大重量
        int overtimes = 1;
        if(luggs==null)
            return -1;
        System.out.println(luggs);

        //免费普通托运次数
        int free_takes=1;

        if(seatType=="top")     //头等chang优惠
            hand_takes=2;
            hand_weight=8;

            /*初始化免费重量限制*/
        if(trav_type=="adult"||trav_type=="child"){
            //判断舱位
            if (flight=="top")
            {
                free_weight = 40;
            } else if (flight=="affair"){
                free_weight = 30;
            } else if ((flight=="economic"||flight=="super")) {
                free_weight = 20;
            }
        }
        else if(trav_type=="baby"){
            free_weight = 10;
        }
        else if(trav_type=="white-gold"){
            free_weight = 30;
            free_takes = 2;

        }
        else if(trav_type=="gold-sliver"){
            free_weight = 20;
            free_takes = 2;
        }
        else if(trav_type=="star"){
            free_weight = 20;
            free_takes = 2;
        }

        for(Luggage lug:luggs){
            //先检查是否为随身行李
            if(hand_takes>0&&checkLug(lug,0,hand_len,0,hand_wid,0,hand_heg,0,hand_weight)){
                hand_takes--;
            }
            else {
                //根据行李类型分支(不分国内外)
                switch (lug.getLugtype()){
                    case 10:
                        //一般托运行李
                        if(internal==true){
                            //国内
                            if(checkLug(lug,0,100,0,60,0,40,0,Float.MAX_VALUE)){
                                //符合尺寸,先看看能不能免费
                                //还有免费名额
                                float price = -1;
                                if(free_takes>0){
                                    if(checkLug(lug,0,1000,0,1000,0,1000,0,free_weight)){
                                        free_takes--;
                                        continue;
                                    }
                                    else {
                                        //超出重量或尺寸不能免费
                                        price = AirCalculator.getOverWeightOrSizeCost(lug,internal,flight);
                                        free_takes--;
                                        continue;
                                    }
                                }
                                //没有免费名额
                                else {
                                    price = AirCalculator.getOverNumCost(lug,seatType,flight,overtimes);
                                }
                                if(price==-1){
                                    System.out.println("error1");
                                    return -1;  //异常数据
                                }else {
                                    totoalPrice += price;
                                }
                                overtimes++;

                            }
                            else {
                                //不符合尺寸，直接打回
                                System.out.println("error2");
                                return -1;
                            }

                        }
                        else {
                            //国外
                            float price = AirCalculator.getOverWeightOrSizeCost(lug,internal,flight);
                            if(price==-1){
                                System.out.println("error3");
                                return -1;  //异常数据
                            }else {
                                totoalPrice += price;
                            }

                        }

                        break;
                    default:
                        //特殊行李计算
                        //因为有些行李还会调用一般行李计算，所以还要看看有没有免费名额
                        if (lug.getLugtype()==1) {
                            //免费的特殊行李
                            totoalPrice+=0;
                            continue;
                        }
                        if(free_takes>0){
                            //还有免费的
                            float price = AirCalculator.getSpecialCost(lug,internal,free_takes,free_takes,flight);
                            if(price==-1){
                                System.out.println("error4");
                                return -1;  //异常数据
                            } else if (price==0) {
                                free_takes--;   //免费次数减少
                            } else {
                                totoalPrice += price;
                            }
                        }else {
                            float price = AirCalculator.getSpecialCost(lug,internal,free_takes,free_takes,flight);
                            if(price==-1){
                                System.out.println("error5");
                                return -1;  //异常数据
                            }else {
                                totoalPrice += price;
                            }
                        }


                }
            }

        }

        return totoalPrice;
    }

    /**
     * 检测这个行李的长宽高重量
     * @return
     */
    private static boolean checkLug(Luggage lug,float l_len,float r_len,float l_wid,float r_wid,float l_heg,float r_heg,float l_weg,float r_weg){
        float len = lug.getLength(),wid=lug.getWeight(),heg=lug.getHight(),weg=lug.getWeight();
        return (l_len<=len&&len<=r_len)&&(l_wid<=wid&&wid<=r_wid)&&
                (l_heg<=heg&&heg<=r_heg)&&(l_weg<=weg&&weg<=r_weg);

    }

    /**
     *
     * @param lug
     * @param internal
     * @param flight
     * @return -1(error data) or price
     */
    public static float getOverWeightOrSizeCost(Luggage lug,boolean internal,String flight){
        float result = 0;
        float weight = lug.getWeight();
        float totoalSize = lug.getHight()+lug.getWeight()+lug.getLength();
        //先判定国内外
        if(internal==true){
            //国内
            //float price = 2000;     //默认20000元票价
            result = (lug.getWeight())*2000*15/1000;
        }
        else {
            //国外
            switch (flight){
                //区域1
                case "area1":
                    //超重量但不超尺寸
                    //23KG<W≤28KG;60CM≤S≤158CM
                    if(23<weight&&weight<=28&&60<=totoalSize&&totoalSize<=158){
                        result = 380;
                    }
                    //超重量但不超尺寸
                    //28KG<W≤32KG; 60CM≤S≤158CM
                    else if (28<weight&&weight<=32&&60<=totoalSize&&totoalSize<=158) {
                        result = 980;
                    }
                    //不超重量但超尺寸
                    //2KG≤W≤23KG; 158CM<S≤203CM
                    else if (2<weight&&weight<=23&&158<totoalSize&&totoalSize<=203) {
                        result = 980;
                    }
                    //超重量且超尺寸
                    //23KG<W≤32KG; 158CM<S≤203CM
                    else if (23<weight&&weight<=32&&158<totoalSize&&totoalSize<=203) {
                        result = 1400;
                    }
                    else result = 0;
                    break;
                //区域2
                case "area2":
                    //超重量但不超尺寸
                    //23KG<W≤28KG;60CM≤S≤158CM
                    if(23<weight&&weight<=28&&60<=totoalSize&&totoalSize<=158){
                        result = 280;
                    }
                    //超重量但不超尺寸
                    //28KG<W≤32KG; 60CM≤S≤158CM
                    //不超重量但超尺寸
                    //2KG≤W≤23KG; 158CM<S≤203CM
                    else if (28<weight&&weight<=32&&60<=totoalSize&&totoalSize<=158||
                            2<weight&&weight<=23&&158<totoalSize&&totoalSize<=203) {
                        result = 690;
                    }
                    //超重量且超尺寸
                    //23KG<W≤32KG; 158CM<S≤203CM
                    else if (23<weight&&weight<=32&&158<totoalSize&&totoalSize<=203) {
                        result = 1100;
                    }
                    else result = 0;

                    break;
                //区域3
                case "area3":
                    //超重量或超尺寸
                    //23KG<W≤32KG;或 158CM≤S≤203CM
                    if(23<weight&&weight<=32||158<=totoalSize&&totoalSize<=203){
                        result = 520;
                    }
                    else result=0;
                    break;
                //区域4
                case "area4":
                    //超重量但不超尺寸
                    //23KG<W≤28KG;60CM≤S≤158CM
                    if(23<weight&&weight<=28&&60<=totoalSize&&totoalSize<=158){
                        result = 690;
                    }
                    //超重量但不超尺寸
                    //28KG<W≤32KG; 60CM≤S≤158CM
                    //不超重量但超尺寸
                    //2KG≤W≤23KG; 158CM<S≤203CM
                    else if (28<weight&&weight<=32&&60<=totoalSize&&totoalSize<=158||
                            2<weight&&weight<=23&&158<totoalSize&&totoalSize<=203) {
                        result = 1040;
                    }
                    //超重量且超尺寸
                    //23KG<W≤32KG; 158CM<S≤203CM
                    else if (23<weight&&weight<=32&&158<totoalSize&&totoalSize<=203) {
                        result = 2050;
                    }
                    else result = 0;

                    break;
                //区域5
                case "area5":
                    //超重量但不超尺寸
                    //23KG<W≤28KG;60CM≤S≤158CM
                    if(23<weight&&weight<=28&&60<=totoalSize&&totoalSize<=158){
                        result = 210;
                    }
                    //超重量但不超尺寸
                    //28KG<W≤32KG; 60CM≤S≤158CM
                    //不超重量但超尺寸
                    //2KG≤W≤23KG; 158CM<S≤203CM
                    else if (28<weight&&weight<=32&&60<=totoalSize&&totoalSize<=158||
                            2<weight&&weight<=23&&158<totoalSize&&totoalSize<=203) {
                        result = 520;
                    }
                    //超重量且超尺寸
                    //23KG<W≤32KG; 158CM<S≤203CM
                    else if (23<weight&&weight<=32&&158<totoalSize&&totoalSize<=203) {
                        result = 830;
                    }
                    else result = 0;

                    break;
            }

        }
        //
        return result;
    }

    /**
     * 获取特殊行李费用
     * @param lug
     * @param internal
     * @param free_takes
     * @param free_weight
     * @param flight
     * @return  -1(error data) or price
     */
    public static float getSpecialCost(Luggage lug,boolean internal,int free_takes,float free_weight,String flight){
        float result = 0;
        float weight = lug.getWeight();
        switch (lug.getLugtype()){
            case 2:
                //免费情况
                if(free_takes==0||lug.getWeight()>free_weight){
                    //超出了或者超重了
                    result = getOverWeightOrSizeCost(lug,internal,flight);
                }
                else result = 0;    //免费

                break;
            case 3:
                if(2<=weight&&weight<=23){
                    result = 2600;
                } else if (23<weight&&weight<=32) {
                    result = 3900;
                } else if(32<weight&&weight<=45)  {
                    result = 5200;
                } else result = -1;
                break;
            case 4:
                if(2<=weight&&weight<=23){
                    result = 1300;
                } else if (23<weight&&weight<=32) {
                    result = 2600;
                } else if(32<weight&&weight<=45){
                    result = 3900;
                } else result = -1;
                break;
            case 5:
                //免费情况
                if(free_takes==0||lug.getWeight()>free_weight){
                    //超出了或者超重了
                    result = getOverWeightOrSizeCost(lug,internal,flight);
                }
                else result = 0;    //免费

                break;
            case 6:
                if(2<=weight&&weight<=23){
                    result = 490;
                } else if (23<weight&&weight<=32) {
                    result = 3900;
                } else result = -1;

                break;
            case 7:
                if(2<=weight&&weight<=23){
                    result = 1300;
                } else if (23<weight&&weight<=32) {
                    result = 3900;
                } else result = -1;

                break;
            case 8:
                if(2<=weight&&weight<=5){
                    result = 1300;
                } else result = -1;

                break;
            case 9:
                if(2<=weight&&weight<=8){
                    result = 1300;
                } else if (8<weight&&weight<=23) {
                    result = 2600;
                } else if (23<weight&&weight<=32) {
                    result = 3900;
                } else result = -1;

                break;
        }
        return result;
    }

    /**
     *  一般行李超出数量的费用
     * @param lug
     * @param seatType
     * @param flight
     * @param overtimes
     * @return -1(error data) or price
     */
    public static float getOverNumCost(Luggage lug,String seatType,String flight,int overtimes){
        float result = 0;
        float weight = lug.getWeight();
        float totoalSize = lug.getHight()+lug.getWeight()+lug.getLength();
        boolean islegal=true;
        switch (flight){

            //区域1
            case "area1":
                //额外行李收费
                //重量：头等舱/公务舱≤32KG
                //悦享经济舱/超级经济舱/经济舱≤23KG
                //尺寸：60CM≤S≤158CM
                //(超尺寸或超重量需另行支付并叠加计算
                //费用)
                switch (seatType){
                    case "top":
                        if(!(weight<=32&&60<=totoalSize&&totoalSize<=158)){
                            islegal = false;
                        }
                        break;
                    case "affair":
                        if(!(weight<=32&&60<=totoalSize&&totoalSize<=158)){
                            islegal = false;
                        }
                        break;
                    case "super":
                        if(!(weight<=32&&60<=totoalSize&&totoalSize<=158)){
                            islegal = false;
                        }
                        break;

                    case "economic":
                        if(!(weight<=32&&60<=totoalSize&&totoalSize<=158)){
                            islegal = false;
                        }
                        break;
                }
                if(islegal){
                    if(overtimes==1){
                        result = 1400;
                    } else if (overtimes == 2) {
                        result = 2000;
                    } else {
                        result = 3000;
                    }
                }else result = -1;

                break;
            //区域2
            case "area2":

                switch (seatType){
                    case "top":
                        if(!(weight<=32&&60<=totoalSize&&totoalSize<=158)){
                            islegal = false;
                        }
                        break;
                    case "affair":
                        if(!(weight<=32&&60<=totoalSize&&totoalSize<=158)){
                            islegal = false;
                        }
                        break;
                    case "super":
                        if(!(weight<=32&&60<=totoalSize&&totoalSize<=158)){
                            islegal = false;
                        }
                        break;

                    case "economic":
                        if(!(weight<=32&&60<=totoalSize&&totoalSize<=158)){
                            islegal = false;
                        }
                        break;
                }
                if(islegal){
                    if(overtimes==1){
                        result = 1100;
                    } else if (overtimes == 2) {
                        result = 1100;
                    } else {
                        result = 1590;
                    }
                }else result = -1;

                break;
            //区域3
            case "area3":

                switch (seatType){
                    case "top":
                        if(!(weight<=32&&60<=totoalSize&&totoalSize<=158)){
                            islegal = false;
                        }
                        break;
                    case "affair":
                        if(!(weight<=32&&60<=totoalSize&&totoalSize<=158)){
                            islegal = false;
                        }
                        break;
                    case "super":
                        if(!(weight<=32&&60<=totoalSize&&totoalSize<=158)){
                            islegal = false;
                        }
                        break;

                    case "economic":
                        if(!(weight<=32&&60<=totoalSize&&totoalSize<=158)){
                            islegal = false;
                        }
                        break;
                }
                if(islegal){
                    if(overtimes==1){
                        result = 1170;
                    } else if (overtimes == 2) {
                        result = 1170;
                    } else {
                        result = 1590;
                    }
                }else result = -1;

                break;
            //区域4
            case "area4":

                switch (seatType){
                    case "top":
                        if(!(weight<=32&&60<=totoalSize&&totoalSize<=158)){
                            islegal = false;
                        }
                        break;
                    case "affair":
                        if(!(weight<=32&&60<=totoalSize&&totoalSize<=158)){
                            islegal = false;
                        }
                        break;
                    case "super":
                        if(!(weight<=32&&60<=totoalSize&&totoalSize<=158)){
                            islegal = false;
                        }
                        break;

                    case "economic":
                        if(!(weight<=32&&60<=totoalSize&&totoalSize<=158)){
                            islegal = false;
                        }
                        break;
                }
                if(islegal){
                    if(overtimes==1){
                        result = 1380;
                    } else if (overtimes == 2) {
                        result = 1380;
                    } else {
                        result = 1590;
                    }
                }else result = -1;

                break;
            //区域5
            case "area5":

                switch (seatType){
                    case "top":
                        if(!(weight<=32&&60<=totoalSize&&totoalSize<=158)){
                            islegal = false;
                        }
                        break;
                    case "affair":
                        if(!(weight<=32&&60<=totoalSize&&totoalSize<=158)){
                            islegal = false;
                        }
                        break;
                    case "super":
                        if(!(weight<=32&&60<=totoalSize&&totoalSize<=158)){
                            islegal = false;
                        }
                        break;

                    case "economic":
                        if(!(weight<=32&&60<=totoalSize&&totoalSize<=158)){
                            islegal = false;
                        }
                        break;
                }
                if(islegal){
                    if(overtimes==1){
                        result = 830;
                    } else if (overtimes == 2) {
                        result = 1100;
                    } else {
                        result = 1590;
                    }
                }else result = -1;
                break;
        }

        return result;
    }

}
