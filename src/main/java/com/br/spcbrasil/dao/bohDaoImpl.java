package com.br.spcbrasil.dao;

import com.br.spcbrasil.dto.Recipe;
import com.br.spcbrasil.dto.assembly;
import com.br.spcbrasil.dto.boh_item;
import com.br.spcbrasil.mapper.assemblyMapper;
import com.br.spcbrasil.mapper.bohMapper;
import com.br.spcbrasil.mapper.recipeMapper;
import com.br.spcbrasil.sqlite.sqliteDatasource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public  class bohDaoImpl implements bohDao {

    public Collection<boh_item> findItem() throws SQLException, IOException {
        JdbcTemplate jdbcTemplate = sqliteDatasource.getJdbc("BOH","10.10.0.7","SQLLITE");
        String vlsql = "select SKU,item_desc  from item ";

        List<boh_item>  boh_items = jdbcTemplate.query(vlsql,new bohMapper());
        return boh_items;
    }

    public Collection<assembly> findAssembly() throws SQLException, IOException {
        JdbcTemplate jdbcTemplate = sqliteDatasource.getJdbc("BOH","10.10.0.7","SQLLITE");
        String vlsql = "Select Original from assembly";

        List<assembly>  assemblyList = jdbcTemplate.query(vlsql,new assemblyMapper());
        return assemblyList;
    }

    public Collection<Recipe> findRecipe() throws SQLException, IOException {
        JdbcTemplate jdbcTemplate = sqliteDatasource.getJdbc("BOH","10.10.0.7","SQLLITE");
        String vlsql = "Select MenuItem1,REC_ID from Recipe";

        List<Recipe> recipeList = jdbcTemplate.query(vlsql,new recipeMapper());
        return recipeList;
    }

    public String SaveRecipe(String vlsql) throws SQLException, IOException {
        JdbcTemplate jdbcTemplate = sqliteDatasource.getJdbc("BOH","10.10.0.7","SQLLITE");
        jdbcTemplate.execute(vlsql);
        return "1";
    }


}
