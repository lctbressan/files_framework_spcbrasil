package com.br.spcbrasil.dao;

import com.br.spcbrasil.dto.pmix;

import java.io.IOException;
import java.util.Collection;

public interface pmixDao {
    public Collection<pmix> findPmix(String OrderID,String Env,String Server)throws IOException, Exception;
}
