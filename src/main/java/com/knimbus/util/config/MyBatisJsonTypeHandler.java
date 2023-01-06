package com.knimbus.util.config;

import com.knimbus.model.Options;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.google.common.collect.Lists;

@MappedJdbcTypes(JdbcType.VARCHAR)
public class MyBatisJsonTypeHandler extends BaseTypeHandler<List<Options>> {

	@Override
	  public void setNonNullParameter(PreparedStatement ps, int i, List<Options> parameter, JdbcType jdbcType) throws SQLException {
	    Array array = ps.getConnection().createArrayOf("text", parameter.toArray());
	    ps.setArray(i, array);
	  }

	  @Override
	  public List<Options> getNullableResult(ResultSet rs, String columnName) throws SQLException {
	    return toList(rs.getArray(columnName));
	  }

	  @Override
	  public List<Options> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
	    return toList(rs.getArray(columnIndex));
	  }

	  @Override
	  public List<Options> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
	    return toList(cs.getArray(columnIndex));
	  }

	  private List<Options> toList(Array pgArray) throws SQLException {
		    if (pgArray == null) return Lists.newArrayList();

		    Options[] options = (Options[]) pgArray.getArray();
		    return containsOnlyNulls(options) ? Lists.<Options>newArrayList() : Lists.newArrayList(options);
    }


	  private boolean containsOnlyNulls(Options[] options) {
	    for (Options ops : options) {
	      if (ops != null) {
	        return false;
	      }
	    }
	    return true;
	  }}