package com.quinbay.service2.model;

public class BillDetails {
    String clientName;
    int p_id;
    String p_name;
    int p_price;
    int aft_dis;
    int gst;
    int aft_gst;

    public BillDetails(String clientName, int p_id, String p_name, int p_price, int aft_dis, int gst, int aft_gst){
        this.clientName=clientName;
        this.p_id=p_id;
        this.p_name=p_name;
        this.p_price=p_price;
        this.aft_dis=aft_dis;
        this.gst=gst;
        this.aft_gst=aft_gst;
    }

}
