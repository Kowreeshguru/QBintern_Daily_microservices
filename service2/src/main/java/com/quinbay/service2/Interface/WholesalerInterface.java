package com.quinbay.service2.Interface;

import com.quinbay.service2.model.Wholesaler;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface WholesalerInterface {
    ArrayList<Wholesaler> disp_wholesaler();
    Wholesaler add_wholesaler(Wholesaler wholesaler);
    Wholesaler get_wholesaler_byId(int id);
    //    void update_producr(int id,int val);
    String remove_wholesaler(int id);
}
