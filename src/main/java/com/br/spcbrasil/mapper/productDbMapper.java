package com.br.spcbrasil.mapper;

import com.br.spcbrasil.dto.consultaProductDb;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class productDbMapper  implements RowMapper<consultaProductDb> {
    public consultaProductDb mapRow(ResultSet rs, int rowNum) throws SQLException {

        consultaProductDb cpdb = new consultaProductDb();

        cpdb.setProductName(rs.getString("ProductName"));
        //cpdb.setDefaultQty(rs.getInt("DefaultQty"));
        //cpdb.setIncludedQty(rs.getInt("IncludedQty"));
       // cpdb.setMinQty(rs.getInt("MinQty"));
        return cpdb;

    }
}
