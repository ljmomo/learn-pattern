package com.junli.jdbc.dao;

import java.sql.ResultSet;

/**
 * @author lijun
 * @since 2018-03-19 15:35
 */
public interface RowMapper<T> {

    public T mapRow(ResultSet rs, int rowNum) throws Exception;

}
