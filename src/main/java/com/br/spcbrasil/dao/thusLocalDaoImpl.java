package com.br.spcbrasil.dao;

import com.br.spcbrasil.dto.thusDbLocal;
import com.br.spcbrasil.mapper.ThUsDbLocalMapper;
import com.br.spcbrasil.sqlite.sqliteDatasource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class thusLocalDaoImpl implements thusLocalDao{

    public Collection<thusDbLocal> findLocalData(String Env, String Server) throws SQLException, IOException, IOException {
        JdbcTemplate jdbcTemplate = sqliteDatasource.getJdbc(Env,Server,"SQLLITE");
        String vlsql = "select a.Product as Produto, a.US_MI as Preco, a.TPN from PRICE_TABLE a order by 1";
        List<thusDbLocal> thusDbLocais =  jdbcTemplate.query(vlsql,new ThUsDbLocalMapper());
        return thusDbLocais;

    }


    public Collection<thusDbLocal> findEnvData(String Data, String Env,String Server) throws SQLException, IOException, IOException {
        JdbcTemplate jdbcTemplate = sqliteDatasource.getJdbc(Env,Server,"SQLLITE");
        String vlsql = "select a.ProductName , a.ProductCode  from Product  a order by 1";
        List<thusDbLocal> thusDbLocais =  jdbcTemplate.query(vlsql,new ThUsDbLocalMapper());
        return thusDbLocais;

    }

}
