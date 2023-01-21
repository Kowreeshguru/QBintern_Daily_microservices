package com.quinbay.service3.Interface;

import com.quinbay.service3.model.Retailer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface RetailerInterface {
    ArrayList<Retailer> disp_retail();
    Retailer add_retail(Retailer retail);
    Retailer get_retail_byId(int id);
    //    void update_producr(int id,int val);
    String remove_retail(int id);
}
