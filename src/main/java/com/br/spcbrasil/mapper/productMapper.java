package com.br.spcbrasil.mapper;

import com.br.spcbrasil.dto.product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;



public class productMapper  implements RowMapper<product> {
    public product mapRow(ResultSet rs, int rowNum) throws SQLException {

        product pro = new product();

        pro.setProductName(rs.getString("ProductName"));
        pro.setProductCode(rs.getString("ProductCode"));

        return pro;

    }
}