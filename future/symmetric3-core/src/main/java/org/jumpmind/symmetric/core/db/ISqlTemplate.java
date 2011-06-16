package org.jumpmind.symmetric.core.db;

import java.util.List;
import java.util.Map;

import org.jumpmind.symmetric.core.model.Table;


/**
 * This interface insulates the application from the data connection technology.
 */
public interface ISqlTemplate {

    public IDbDialect getDbDialect();

    public <T> T queryForObject(String sql, Class<T> clazz, Object... args);

    public int queryForInt(String sql);
    
    public <T> ISqlReadCursor<T> queryForCursor(Query query, ISqlRowMapper<T> mapper) ;

    public <T> ISqlReadCursor<T> queryForCursor(String sql, ISqlRowMapper<T> mapper,
            Object[] values, int[] types);

    public <T> ISqlReadCursor<T> queryForCursor(String sql, ISqlRowMapper<T> mapper);

    public List<Map<String, Object>> query(String sql);

    public List<Map<String, Object>> query(String sql, Object[] args, int[] types);

    public <T> List<T> query(String sql, ISqlRowMapper<T> mapper);
    
    public <T> List<T> query(String sql, ISqlRowMapper<T> mapper, Object... args);

    public <T> List<T> query(String sql, ISqlRowMapper<T> mapper, Object[] args, int[] types);
    
    public <T> List<T> query(Query query, ISqlRowMapper<T> mapper);
    
    public <T,W> Map<T,W> query(String sql, String keyCol, String valueCol, Object[] args, int[] types);

    public int update(String sql);

    public int update(String... sql);

    public int update(boolean autoCommit, boolean failOnError, int commitRate, String... sql);

    public int update(String sql, Object[] values, int[] types);
    
    public int update(Table table, Map<String,Object> args);
    
	public int insert(Table table, Map<String, Object> params);
	
	public int delete(Table table, Map<String, Object> params);
	
	public void save(Table table, Map<String, Object> params);
	
    public void testConnection();

    public SqlException translate(Exception ex);

    public ISqlTransaction startSqlTransaction();

}
