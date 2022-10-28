package com.pla.planespring.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class Travaler {

    private String lugtypes;
    private String lengths;
    private String widths;
    private String hights;
    private String weights;
    private boolean internal;         //是否在国内
    private String seatType;
    private String trav_type;
    private String flight;

    public List<Luggage> getListLugs(){

        List<Luggage>luggs=new ArrayList<>();
        //将原始数据用空格分割
        String []lengths=this.lengths.split(" ");
        String []widths=this.widths.split(" ");
        String []heights=this.hights.split(" ");
        String []types=this.lugtypes.split(" ");
        String []weights=this.weights.split(" ");

        int L = lengths.length;

        //判断他们数据长度是否相等
        if(!(widths.length==L&&heights.length==L&&types.length==L&&weights.length==L))
            return null;
        int type;
        float len,wid,heg,weg;
        //将数据从String转为int或float存到luggages内
        for(int i=0;i<L;i++){
            //是否全部合法数据
            if(islegaltype(types[i])&&islegalnum(lengths[i])&&islegalnum(widths[i])
                &&islegalnum(heights[i])&&islegalnum(weights[i])){
                type = Integer.parseInt(types[i]);
                len = Float.parseFloat(lengths[i]);
                wid = Float.parseFloat(widths[i]);
                heg = Float.parseFloat(heights[i]);
                weg = Float.parseFloat(weights[i]);
                luggs.add(new Luggage(type,len,wid,heg,weg));
            }
            else return null;

        }
        return luggs;
    }

    private boolean islegaltype(String type){
        String regX = "10|[1-9]";   //10必须在前面

        return Pattern.matches(regX,type);
    }

    private boolean islegalnum(String num){
        String regX =  "\\d+(.\\d+)?";                 //"[1-8],\\d+(.\\d+)?,\\d+(.\\d+)?";

        return Pattern.matches(regX,num);
    }

    public Travaler() {
    }

    public Travaler(String lugtypes, String lengths, String widths, String hights, String weights, boolean internal, String seatType, String trav_type, String flight) {
        this.lugtypes = lugtypes;
        this.lengths = lengths;
        this.widths = widths;
        this.hights = hights;
        this.weights = weights;
        this.internal = internal;
        this.seatType = seatType;
        this.trav_type = trav_type;
        this.flight = flight;
    }

    public boolean isInternal() {
        return internal;
    }

    public void setInternal(boolean internal) {
        this.internal = internal;
    }

    public String getLugtypes() {
        return lugtypes;
    }

    public void setLugtypes(String lugtypes) {
        this.lugtypes = lugtypes;
    }

    public String getLengths() {
        return lengths;
    }

    public void setLengths(String lengths) {
        this.lengths = lengths;
    }

    public String getWidths() {
        return widths;
    }

    public void setWidths(String widths) {
        this.widths = widths;
    }

    public String getHights() {
        return hights;
    }

    public void setHights(String hights) {
        this.hights = hights;
    }

    public String getWeights() {
        return weights;
    }

    public void setWeights(String weights) {
        this.weights = weights;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public String getTrav_type() {
        return trav_type;
    }

    public void setTrav_type(String trav_type) {
        this.trav_type = trav_type;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "Travaler{" +
                "lugtypes='" + lugtypes + '\'' +
                ", lengths='" + lengths + '\'' +
                ", widths='" + widths + '\'' +
                ", hights='" + hights + '\'' +
                ", weights='" + weights + '\'' +
                ", seatType='" + seatType + '\'' +
                ", trav_type='" + trav_type + '\'' +
                ", flight='" + flight + '\'' +
                '}';
    }
}
