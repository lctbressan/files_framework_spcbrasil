package com.br.spcbrasil.dto;

public class consultaProductDb {
    String ProductName;
    Integer NavId;
    Integer DefaultQty;
    Integer IncludedQty;
    Integer MinQty;

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public Integer getNavId() {
        return NavId;
    }

    public void setNavId(int navId) {
        NavId = navId;
    }


    public Integer getDefaultQty() {
        return DefaultQty;
    }

    public void setDefaultQty(Integer defaultQty) {
        DefaultQty = defaultQty;
    }

    public Integer getIncludedQty() {
        return IncludedQty;
    }

    public void setIncludedQty(Integer includedQty) {
        IncludedQty = includedQty;
    }

    public void setNavId(Integer navId) {
        NavId = navId;
    }

    public Integer getMinQty() {
        return MinQty;
    }

    public void setMinQty(Integer minQty) {
        MinQty = minQty;
    }
}
