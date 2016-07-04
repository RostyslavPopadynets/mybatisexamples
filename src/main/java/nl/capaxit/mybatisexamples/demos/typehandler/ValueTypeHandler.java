package nl.capaxit.mybatisexamples.demos.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jamiecraane on 03/07/16.
 */
@MappedJdbcTypes(JdbcType.VARCHAR)
public class ValueTypeHandler extends BaseTypeHandler<Boolean> {
    @Override
    public void setNonNullParameter(final PreparedStatement ps, final int i, final Boolean parameter, final JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter ? "yes" : "no");
    }

    @Override
    public Boolean getNullableResult(final ResultSet rs, final String columnName) throws SQLException {
        return rs.getString(columnName) != null && "yes".equalsIgnoreCase(rs.getString(columnName));
    }

    @Override
    public Boolean getNullableResult(final ResultSet rs, final int columnIndex) throws SQLException {
        return rs.getString(columnIndex) != null && "yes".equalsIgnoreCase(rs.getString(columnIndex));
    }

    @Override
    public Boolean getNullableResult(final CallableStatement cs, final int columnIndex) throws SQLException {
        return cs.getString(columnIndex) != null && "yes".equalsIgnoreCase(cs.getString(columnIndex));
    }
}
