package CRUD;

import CRUD.entity.Crm;
import Utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author ahao 2020-08-31
 */
public class CRMCRUD {
    Connection connection = JDBCUtils.getConnection();

    public CRMCRUD() throws SQLException {
    }

    @Test
    public void findAll() throws SQLException {
        List<Crm> crms = new ArrayList<>();
        String sql = "select * from crm limit 9";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
    }
    public List<Crm> getResult(ResultSet rs) throws SQLException {
        List<Crm> crms = new ArrayList<>();
        Crm crm = new Crm();
        while (rs.next()) {
            crm.setId(rs.getString(1));
            crm.setInitiativePhone(rs.getString(2));
            crm.setPassivityPhone(rs.getString(3));
            crm.setCustomerId(rs.getString(4));
            crm.setCallTime(rs.getString(5));
            crm.setSumTime(rs.getString(6));
            crm.setWaiterId(rs.getString(7));
            crm.setCallResult(rs.getString(8));
            crms.add(crm);
        }
        return crms;
    }



    public List<Crm> getResultFromView(ResultSet rs) throws SQLException {
        List<Crm> crms = new ArrayList<>();
        Crm crm = new Crm();
        while (rs.next()) {
            crm.setId(rs.getString(1));
//            crm.setInitiativePhone(rs.getString(2));
//            crm.setPassivityPhone(rs.getString(3));
            crm.setCustomerId(rs.getString(2));
            crm.setCallTime(rs.getString(3));
            crm.setSumTime(rs.getString(4));
            crm.setWaiterId(rs.getString(5));
            crm.setCallResult(rs.getString(6));
            crms.add(crm);
        }
        return crms;
    }
    @Test
    public void findAllFromView() throws SQLException {
        String sql = "select * from v_crm limit 2";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Crm> resultFromView = getResultFromView(resultSet);
        System.out.println(resultFromView);
    }
    @Test
    public void deleteOne() throws SQLException {
        String sql = "delete from crm where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,"1065");
        int i = preparedStatement.executeUpdate();
        System.out.println(i);
    }
    @Test
    public void callProcedure() throws SQLException {
        String sql = "call delete_one(?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,"1061");
        int i = preparedStatement.executeUpdate();
        System.out.println(i);
    }
}
