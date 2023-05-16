package com.br.spcbrasil.pmixJsonDto;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Params {

    @SerializedName("tlogs")
    @Expose
    private List<Tlog> tlogs = null;
    @SerializedName("restaurant_id")
    @Expose
    private String restaurant_id;

    public List<Tlog> getTlogs() {
        return tlogs;
    }

    public void setTlogs(List<Tlog> tlogs) {
        this.tlogs = tlogs;
    }

    public String getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(String restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public Params(){
        super();
    }
    public Params(List<Tlog> tlogs, String restaurant_id) {
        this.tlogs = tlogs;
        this.restaurant_id = restaurant_id;
    }


    @Override
    public String toString() {
        return "ParamsDto [tlogs=" + tlogs + ", restaurant_id=" + restaurant_id + "]";
    }
}
