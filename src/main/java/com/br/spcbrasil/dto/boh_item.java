package com.br.spcbrasil.dto;

import java.math.BigDecimal;

public class boh_item {

    BigDecimal Sku;
    String item_desc;

    public BigDecimal getSku() {
        return Sku;
    }

    public void setSku(BigDecimal sku) {
        Sku = sku;
    }

    public String getItem_desc() {
        return item_desc;
    }

    public void setItem_desc(String item_desc) {
        this.item_desc = item_desc;
    }
}
