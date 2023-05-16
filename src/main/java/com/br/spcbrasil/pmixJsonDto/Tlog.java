package com.br.spcbrasil.pmixJsonDto;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


import java.util.List;


    public class Tlog {

        @SerializedName("is_overring")
        @Expose
        private String is_overring;

        @SerializedName("valuemeals")
        @Expose
        private List<Valuemeal> valuemeals = null;

        @SerializedName("destination")
        @Expose
        private String destination;

        @SerializedName("sale_id")
        @Expose
        private String sale_id;

        @SerializedName("tenders")
        @Expose
        private List<Tender> tenders = null;
        @SerializedName("transaction_end_datetime")
        @Expose
        private String transaction_end_datetime;
        @SerializedName("date")
        @Expose
        private String date;
        @SerializedName("deleted_items")
        @Expose
        private String deleted_items;

        @SerializedName("order_number")
        @Expose
        private String order_number;

        @SerializedName("transaction_start_datetime")
        @Expose
        private String transaction_start_datetime;

        @SerializedName("order_sub_total")
        @Expose
        private String order_sub_total;

        public String getIs_overring() {
            return is_overring;
        }

        public void setIs_overring(String is_overring) {
            this.is_overring = is_overring;
        }

        public List<Valuemeal> getValuemeals() {
            return valuemeals;
        }

        public void setValuemeals(List<Valuemeal> valuemeals) {
            this.valuemeals = valuemeals;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }



        public List<Tender> getTenders() {
            return tenders;
        }

        public void setTenders(List<Tender> tenders) {
            this.tenders = tenders;
        }



        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getSale_id() {
            return sale_id;
        }

        public void setSale_id(String sale_id) {
            this.sale_id = sale_id;
        }

        public String getTransaction_end_datetime() {
            return transaction_end_datetime;
        }

        public void setTransaction_end_datetime(String transaction_end_datetime) {
            this.transaction_end_datetime = transaction_end_datetime;
        }

        public String getDeleted_items() {
            return deleted_items;
        }

        public void setDeleted_items(String deleted_items) {
            this.deleted_items = deleted_items;
        }

        public String getOrder_number() {
            return order_number;
        }

        public void setOrder_number(String order_number) {
            this.order_number = order_number;
        }

        public String getTransaction_start_datetime() {
            return transaction_start_datetime;
        }

        public void setTransaction_start_datetime(String transaction_start_datetime) {
            this.transaction_start_datetime = transaction_start_datetime;
        }

        public String getOrder_sub_total() {
            return order_sub_total;
        }

        public void setOrder_sub_total(String order_sub_total) {
            this.order_sub_total = order_sub_total;
        }

        public Tlog(){
            super();
        }

        public Tlog(String is_overring, List<Valuemeal> valuemeals, String destination, String sale_id, List<Tender> tenders, String transaction_end_datetime, String date, String deleted_items, String order_number, String transaction_start_datetime, String order_sub_total) {
            this.is_overring = is_overring;
            this.valuemeals = valuemeals;
            this.destination = destination;
            this.sale_id = sale_id;
            this.tenders = tenders;
            this.transaction_end_datetime = transaction_end_datetime;
            this.date = date;
            this.deleted_items = deleted_items;
            this.order_number = order_number;
            this.transaction_start_datetime = transaction_start_datetime;
            this.order_sub_total = order_sub_total;
        }

        public String toString() {
            return "TlogDto [is_overring=" + is_overring + ", valuemeals=" + valuemeals + ", destination="+ destination + ",sale_id="+ sale_id+ ",tenders=" + tenders
                    + ",transaction_end_datetime=" + transaction_end_datetime  + ",date="+ date  + ",deleted_items="+ deleted_items + ",order_number=" + order_number
                    + "transaction_start_datetime=" + transaction_start_datetime + ",order_sub_total=" +  order_sub_total
                    + " ]";
        }
    }

