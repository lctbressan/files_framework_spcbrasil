package com.br.spcbrasil.mapper;

import com.br.spcbrasil.dto.assembly;
import com.br.spcbrasil.dto.devicefarm;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;



public class devicefarmMapper  implements RowMapper<devicefarm> {
    public devicefarm mapRow(ResultSet rs, int rowNum) throws SQLException {
        devicefarm  df = new devicefarm();
        df.setDeviceName(rs.getString("DeviceName"));
        df.setPlatFormPort(rs.getString("PlatformPort"));
        df.setPlatFormServer(rs.getString("PlatformServer"));
        df.setSTATUS(rs.getString("STATUS"));
        df.setUDID(rs.getString("UDID"));
        df.setCreation_date(rs.getString("creation_date"));
        return df;
    }
}