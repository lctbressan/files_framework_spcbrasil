package com.br.spcbrasil.dao;

import com.br.spcbrasil.dto.pmix;
import com.br.spcbrasil.mapper.pmixMapper;
import com.br.spcbrasil.sqlite.sqliteDatasource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class pmixDaoImpl implements pmixDao {

    public Collection<pmix> findPmix(String OrderId, String Env, String Server) throws SQLException, IOException {
        JdbcTemplate jdbcTemplate = sqliteDatasource.getJdbc(Env,Server,"SQLLITE");
        String vlsql = " Select * from Requests r where r.Data like '%" + OrderId + "%'";
        List<pmix> pmixes = jdbcTemplate.query(vlsql, new pmixMapper());
        return pmixes;
    }


}
