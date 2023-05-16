package com.br.spcbrasil.dao;

import com.br.spcbrasil.dto.devicefarm;
import com.br.spcbrasil.mapper.devicefarmMapper;
import com.br.spcbrasil.sqlite.sqliteDatasource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class devicefarmDaoImpl implements devicefarmDao{

    public Collection<devicefarm> getDevices() throws SQLException, IOException {
        JdbcTemplate jdbcTemplate = sqliteDatasource.getJdbc("BOH","10.10.0.7","SQLSERVER");
        String vlsql = "select * from DEVICE_FARM WHERE SIT = 'A'";
        List<devicefarm> df = jdbcTemplate.query(vlsql,new devicefarmMapper());
        return df;
    }

    public void setDeviceRunner(String DeviceName,String Target) throws IOException {
        JdbcTemplate jdbcTemplate = sqliteDatasource.getJdbc("BOH","10.10.0.7","SQLSERVER");
        String vlsql = "update DEVICE_FARM set TargetAutomation = '"+ Target+"' , Status = 'BUSY',creation_date =  convert(varchar(20),getdate(),105) +' '+ left(CONVERT (TIME, CURRENT_TIMESTAMP),8) where DeviceName = '" + DeviceName+ "'";
        jdbcTemplate.execute(vlsql);
    }

    public void setDeviceReady(String DeviceName) throws IOException {
        JdbcTemplate jdbcTemplate = sqliteDatasource.getJdbc("BOH","10.10.0.7","SQLSERVER");
        String vlsql = "update DEVICE_FARM set Status = 'READY',creation_date =  convert(varchar(20),getdate(),105) +' '+ left(CONVERT (TIME, CURRENT_TIMESTAMP),8) where DeviceName = '" + DeviceName+ "'";
        jdbcTemplate.execute(vlsql);
    }
}
