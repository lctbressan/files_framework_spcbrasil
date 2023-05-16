package com.br.spcbrasil.pmixJsonDto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Valuemeal {

    @SerializedName("count")
    @Expose
    private String count;
    @SerializedName("valuemeal_id")
    @Expose
    private String valuemeal_id;
    @SerializedName("valuemeal_products")
    @Expose
    private List<ValuemealProduct> valuemeal_products = null;
    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("savings")
    @Expose
    private String savings;
    @SerializedName("third_party_id")
    @Expose
    private String third_party_id;
    @SerializedName("mode")
    @Expose
    private String mode;
    @SerializedName("valuemeal_name")
    @Expose
    private String valuemeal_name;
    @SerializedName("valuemeal_discounts")
    @Expose
    private List<Object> valuemeal_discounts = null;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }



    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSavings() {
        return savings;
    }

    public void setSavings(String savings) {
        this.savings = savings;
    }



    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getValuemeal_id() {
        return valuemeal_id;
    }

    public void setValuemeal_id(String valuemeal_id) {
        this.valuemeal_id = valuemeal_id;
    }

    public List<ValuemealProduct> getValuemeal_products() {
        return valuemeal_products;
    }

    public void setValuemeal_products(List<ValuemealProduct> valuemeal_products) {
        this.valuemeal_products = valuemeal_products;
    }

    public String getThird_party_id() {
        return third_party_id;
    }

    public void setThird_party_id(String third_party_id) {
        this.third_party_id = third_party_id;
    }

    public String getValuemeal_name() {
        return valuemeal_name;
    }

    public void setValuemeal_name(String valuemeal_name) {
        this.valuemeal_name = valuemeal_name;
    }

    public List<Object> getValuemeal_discounts() {
        return valuemeal_discounts;
    }

    public void setValuemeal_discounts(List<Object> valuemeal_discounts) {
        this.valuemeal_discounts = valuemeal_discounts;
    }

    public Valuemeal(){
        super();
    }

    public Valuemeal(String count, String valuemeal_id, List<ValuemealProduct> valuemeal_products, String amount, String savings, String third_party_id, String mode, String valuemeal_name, List<Object> valuemeal_discounts) {
        this.count = count;
        this.valuemeal_id = valuemeal_id;
        this.valuemeal_products = valuemeal_products;
        this.amount = amount;
        this.savings = savings;
        this.third_party_id = third_party_id;
        this.mode = mode;
        this.valuemeal_name = valuemeal_name;
        this.valuemeal_discounts = valuemeal_discounts;
    }

    public String toString() {
        return "ValuemealDto [count=" + count + ", valuemeal_id=" + valuemeal_id + ", valuemeal_products="+ valuemeal_products + ",amount="+ amount + ",savings=" + savings
                + ",third_party_id=" + third_party_id  + ",mode="+ mode  + ",valuemeal_name="+ valuemeal_name + ",valuemeal_discounts=" + valuemeal_discounts
                + " ]";
    }
}