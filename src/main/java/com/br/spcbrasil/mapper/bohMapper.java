package com.br.spcbrasil.mapper;

import com.br.spcbrasil.dto.boh_item;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class bohMapper  implements RowMapper<boh_item> {
    public boh_item mapRow(ResultSet rs, int rowNum) throws SQLException {

        boh_item bohi = new boh_item();

        bohi.setItem_desc(rs.getString("item_desc"));
        bohi.setSku(rs.getBigDecimal("Sku"));
        return bohi;

    }
}
