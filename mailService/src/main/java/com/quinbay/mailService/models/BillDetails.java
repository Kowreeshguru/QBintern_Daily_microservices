package com.quinbay.mailService.models;

public class BillDetails {
    String clientName;
    int p_id;
    String p_name;
    int p_price;
    int aft_dis;
    int gst;
    int aft_gst;

    public BillDetails() {

    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getAft_gst() {
        return aft_gst;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public int getP_price() {
        return p_price;
    }

    public void setP_price(int p_price) {
        this.p_price = p_price;
    }

    public int getAft_dis() {
        return aft_dis;
    }

    public void setAft_dis(int aft_dis) {
        this.aft_dis = aft_dis;
    }

    public int getGst() {
        return gst;
    }

    public void setGst(int gst) {
        this.gst = gst;
    }

    public void setAft_gst(int aft_gst) {

        this.aft_gst = aft_gst;
    }

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
