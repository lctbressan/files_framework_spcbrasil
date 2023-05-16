package com.br.spcbrasil.dao;

import com.br.spcbrasil.dto.consultaProductDb;
import com.br.spcbrasil.dto.product;

import java.io.IOException;
import java.util.Collection;

public interface  lunchDinnerDao {

    public Collection<consultaProductDb> findAllProducts(String arg0, String arg1, String arg2, String Server)throws IOException, Exception;
    public Collection<product> findProduct(String arg0, String arg2, String Server)throws IOException, Exception;

}
