package com.br.spcbrasil.pmixJsonDto;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("count")
    @Expose
    private String count;
    @SerializedName("product_id")
    @Expose
    private String product_id;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("third_party_id")
    @Expose
    private String third_party_id;
    @SerializedName("a_la_carte_price")
    @Expose
    private String a_la_carte_price;
    @SerializedName("product_name")
    @Expose
    private String product_name;
    @SerializedName("mode")
    @Expose
    private String mode;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getThird_party_id() {
        return third_party_id;
    }

    public void setThird_party_id(String third_party_id) {
        this.third_party_id = third_party_id;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }


    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getA_la_carte_price() {
        return a_la_carte_price;
    }

    public void setA_la_carte_price(String a_la_carte_price) {
        this.a_la_carte_price = a_la_carte_price;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Product(){
        super();
    }

    public Product(String count, String product_id, String price, String amount, String third_party_id, String a_la_carte_price, String product_name, String mode) {
        this.count = count;
        this.product_id = product_id;
        this.price = price;
        this.amount = amount;
        this.third_party_id = third_party_id;
        this.a_la_carte_price = a_la_carte_price;
        this.product_name = product_name;
        this.mode = mode;
    }

    @Override
    public String toString() {
        return "ProductDto [count=" + count + ", product_id=" + product_id + ", price="+ price + ",amount="+ amount+ ",third_party_id=" + third_party_id
                + ",a_la_carte_price=" + a_la_carte_price  + ",product_name="+ product_name  + ",mode="+ mode
                + " ]";
    }
}
