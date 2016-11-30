package dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.model.Debt;

public class DebtMapper implements IMapResultSetIntoEntity<Debt> {

	public Debt map(ResultSet rs) throws SQLException {
		Debt debt = new Debt();
		debt.setId(rs.getInt("id"));
		debt.setUserId(rs.getInt("userId"));
		debt.setPayment(rs.getBigDecimal("payment"));
		return debt;
	}
}
