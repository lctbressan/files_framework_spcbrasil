package com.br.spcbrasil.pmixJsonDto;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tender {

    @SerializedName("count")
    @Expose
    private String count;

    @SerializedName("tender_name")
    @Expose
    private String tender_name;

    @SerializedName("amount")
    @Expose
    private String amount;


    @SerializedName("third_party_id")
    @Expose
    private String third_party_id;

    @SerializedName("mode")
    @Expose
    private String mode;
    @SerializedName("is_change")
    @Expose
    private String is_change;

    @SerializedName("tender_id")
    @Expose
    private String tender_id;

    @SerializedName("cc_token")
    @Expose
    private String cc_token;
    @SerializedName("card_holder")
    @Expose
    private String card_holder;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getTender_name() {
        return tender_name;
    }

    public void setTender_name(String tender_name) {
        this.tender_name = tender_name;
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

    public String getIs_change() {
        return is_change;
    }

    public void setIs_change(String is_change) {
        this.is_change = is_change;
    }

    public String getTender_id() {
        return tender_id;
    }

    public void setTender_id(String tender_id) {
        this.tender_id = tender_id;
    }

    public String getCc_token() {
        return cc_token;
    }

    public void setCc_token(String cc_token) {
        this.cc_token = cc_token;
    }

    public String getCard_holder() {
        return card_holder;
    }

    public void setCard_holder(String card_holder) {
        this.card_holder = card_holder;
    }

    public Tender(){
        super();
    }

    public Tender(String count, String tender_name, String amount, String third_party_id, String mode, String is_change, String tender_id, String cc_token, String card_holder) {
        this.count = count;
        this.tender_name = tender_name;
        this.amount = amount;
        this.third_party_id = third_party_id;
        this.mode = mode;
        this.is_change = is_change;
        this.tender_id = tender_id;
        this.cc_token = cc_token;
        this.card_holder = card_holder;
    }

    public String toString() {
        return "TenderDto [count=" + count + ", tender_name=" + tender_name + ", amount="+ amount + ",third_party_id="+ third_party_id+ ",mode=" + mode
                + ",is_change=" + is_change  + ",tender_id="+ tender_id  + ",cc_token="+ cc_token + ",card_holder=" + card_holder
                + " ]";
    }
}