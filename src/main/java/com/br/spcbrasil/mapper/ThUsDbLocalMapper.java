package com.br.spcbrasil.mapper;

import com.br.spcbrasil.dto.thusDbLocal;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ThUsDbLocalMapper  implements RowMapper<thusDbLocal> {

    public thusDbLocal mapRow(ResultSet rs, int rowNum) throws SQLException {
        thusDbLocal thusdbl = new thusDbLocal();

        thusdbl.setPreco(rs.getDouble("Preco"));
        thusdbl.setProduto(rs.getString("produto"));
        thusdbl.setTPN(rs.getString("TPN"));
        return thusdbl;
    }

}
