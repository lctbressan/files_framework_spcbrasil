package com.br.spcbrasil.mapper;

import com.br.spcbrasil.dto.assembly;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class assemblyMapper  implements RowMapper<assembly> {
    public assembly mapRow(ResultSet rs, int rowNum) throws SQLException {
        assembly ass = new assembly();
        ass.setOriginal(rs.getString("Original"));
        return ass;
    }
}