package com.br.spcbrasil.dto;

import java.util.Date;

public class devicefarm {

    String PlatFormPort;
    String  PlatFormServer;
    String  DeviceName;
    String  UDID;
    String  STATUS;
    String creation_date;


    public String getPlatFormPort() {
        return PlatFormPort;
    }

    public void setPlatFormPort(String platFormPort) {
        PlatFormPort = platFormPort;
    }

    public String getPlatFormServer() {
        return PlatFormServer;
    }

    public void setPlatFormServer(String platFormServer) {
        PlatFormServer = platFormServer;
    }

    public String getDeviceName() {
        return DeviceName;
    }

    public void setDeviceName(String deviceName) {
        DeviceName = deviceName;
    }

    public String getUDID() {
        return UDID;
    }

    public void setUDID(String UDID) {
        this.UDID = UDID;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }
}
