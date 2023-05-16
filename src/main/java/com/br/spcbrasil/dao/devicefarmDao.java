package com.br.spcbrasil.dao;

import com.br.spcbrasil.dto.boh_item;
import com.br.spcbrasil.dto.devicefarm;

import java.io.IOException;
import java.util.Collection;

public interface devicefarmDao  {
    public Collection<devicefarm> getDevices()throws IOException, Exception;
    public void setDeviceRunner(String DeviceName,String Target)throws IOException, Exception;
    public void setDeviceReady(String DeviceName)throws IOException, Exception;

}
