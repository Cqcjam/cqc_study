/**
 * @author wb.ruiyuejian
 * @date 2019/12/9 10:58
 */

package com.cqc.learning.spring.config;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * mysql数据源数据类型处理 string转list数据结果
 */

@MappedTypes({List.class, ArrayList.class, LinkedList.class, Vector.class})
public class ListTypeHandler implements TypeHandler<List> {
    
    @Override
    public void setParameter(PreparedStatement ps, int i, List parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, JSON.toJSONString(parameter));
    }

    @Override
    public List getResult(ResultSet rs, String columnName) throws SQLException {
        return JSON.parseArray(rs.getString(columnName));
    }

    @Override
    public List getResult(ResultSet rs, int columnIndex) throws SQLException {
        return JSON.parseArray(rs.getString(columnIndex));
    }

    @Override
    public List getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return JSON.parseArray(cs.getString(columnIndex));
    }
}
