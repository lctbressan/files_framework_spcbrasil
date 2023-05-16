package com.br.spcbrasil.mapper;

import com.br.spcbrasil.dto.Recipe;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;



public class recipeMapper  implements RowMapper<Recipe> {
    public Recipe mapRow(ResultSet rs, int rowNum) throws SQLException {
        Recipe rec = new Recipe();
        rec.setMenuItem1(rs.getString("MenuItem1"));
        rec.setREC_ID(rs.getString("REC_ID"));
        return rec;
    }
}