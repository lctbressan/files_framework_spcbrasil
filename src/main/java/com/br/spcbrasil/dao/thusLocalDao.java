package com.br.spcbrasil.dao;

import com.br.spcbrasil.dto.thusDbLocal;

import java.io.IOException;
import java.util.Collection;

public interface thusLocalDao {
    public Collection<thusDbLocal> findLocalData(String arg0, String Server)throws IOException, Exception;
}
