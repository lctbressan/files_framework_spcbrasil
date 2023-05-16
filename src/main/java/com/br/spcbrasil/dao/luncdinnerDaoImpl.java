package com.br.spcbrasil.dao;

import com.br.spcbrasil.dto.consultaProductDb;
import com.br.spcbrasil.dto.product;
import com.br.spcbrasil.mapper.productDbMapper;
import com.br.spcbrasil.mapper.productMapper;
import com.br.spcbrasil.sqlite.sqliteDatasource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class luncdinnerDaoImpl implements lunchDinnerDao{


      public Collection<product> findProduct(String Product, String Env, String Server) throws SQLException, IOException {
            JdbcTemplate jdbcTemplate = sqliteDatasource.getJdbc(Env,Server,"SQLLITE");
            String vlsql = "SELECT DISTINCT P.ProductName ,P.ProductCode  from ProductNavigation pn" ;
            vlsql = vlsql + " inner join Navigation n on pn.NavId = n.NavId";
            vlsql = vlsql + " inner join Product p on pn.ProductCode = p.ProductCode";
            vlsql = vlsql + " left join ProductPart pp on pp.ProductCode = p.ProductCode";
            vlsql = vlsql + "  where  p.ProductName LIKE '%"+ Product +"%'";
            List<product> consultaProduc =  jdbcTemplate.query(vlsql,new productMapper());
            return consultaProduc;

      }

  public Collection<consultaProductDb> findAllProducts(String SubItens,String Exclude,String Env,String Server) throws SQLException, IOException {
        JdbcTemplate jdbcTemplate = sqliteDatasource.getJdbc(Env,Server,"SQLLITE");

        String vlsql = "SELECT DISTINCT";
        vlsql = vlsql + " p.ProductName";
        //vlsql = vlsql + ",pp.DefaultQty ";
        //vlsql = vlsql + ",pp.IncludedQty";
        //vlsql = vlsql + ",pp.MinQty";
        vlsql = vlsql + " from ProductNavigation pn ";
        vlsql = vlsql + " inner join Navigation n on pn.NavId = n.NavId";
        vlsql = vlsql + " inner join Product p on pn.ProductCode = p.ProductCode ";
        vlsql = vlsql + " left join ProductPart pp on pp.ProductCode = p.ProductCode";
        vlsql = vlsql + " where n.Name in("+ SubItens +")";
        vlsql = vlsql + " and  p.ProductName not in ("+ Exclude +")";
        vlsql = vlsql + " order by n.Name , p.ProductName";

        List<consultaProductDb> consultaProductDbs =  jdbcTemplate.query(vlsql,new productDbMapper());
        return consultaProductDbs;

    }
}
