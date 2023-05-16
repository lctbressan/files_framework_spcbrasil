package com.br.spcbrasil.mapper;

import com.br.spcbrasil.dto.pmix;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class pmixMapper implements RowMapper<pmix> {
    public pmix mapRow(ResultSet rs, int rowNum) throws SQLException {
        pmix Pmix = new pmix();
        Pmix.setData(rs.getString("Data"));
        Pmix.setErrorCode(rs.getString("ErrorCode"));
        Pmix.setResponse(rs.getString("Response"));
        Pmix.setSent(rs.getString("Sent"));
        Pmix.setStatusCode(rs.getString("StatusCode"));
        return Pmix;

    }

}
