package com.br.spcbrasil.dao;

import com.br.spcbrasil.dto.Recipe;
import com.br.spcbrasil.dto.assembly;
import com.br.spcbrasil.dto.boh_item;

import java.io.IOException;
import java.util.Collection;

public interface bohDao {
    public Collection<boh_item> findItem()throws IOException, Exception;
    public Collection<assembly> findAssembly()throws IOException, Exception;
    public Collection<Recipe> findRecipe()throws IOException, Exception;
    public String SaveRecipe(String vlsql)throws IOException, Exception;

}
