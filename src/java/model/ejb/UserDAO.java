/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ejb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.sql.DataSource;
import model.User;

/**
 *
 * @author TRJ
 */
@Stateless
@LocalBean
public class UserDAO {
    @Resource(name="jdbc/userdb")
    private DataSource ds;
    
    
    public void addUser(User user) {
        String sql = "INSERT INTO user VALUES ('" + user.getUserID() + "', '" + user.getName() + "', '" + user.getAddress() + "'";
        executedModifyQuery(sql);
    }
    
    public void editUser(User user) {
        String sql = "UPDATE user SET NAME = '" + user.getName() + "', ADDRESS = '" + user.getAddress() + "' WHERE USERID = '" + user.getUserID() + "'";
        executedModifyQuery(sql);
    }
    
    public void deleteUser(User user) {
        String sql = "DELETE FROM user WHERE USERID = '" + user.getUserID() + "'";
        executedModifyQuery(sql);
    }
    
    public User getUser(String id) {
        User user = new User();
        String sql = "SELECT * FROM user WHERE USERID = '" + id + "'";
        System.out.println(sql);
        ResultSet rs = executedFetchQuery(sql);
        try {
            if (rs.next()) {
               user.setUserID(rs.getString("USERID"));
               user.setName(rs.getString("NAME"));
               user.setAddress(rs.getString("ADDRESS"));
            }
        } catch (Exception ex) {
            System.out.println("GS" + ex.getMessage());
        }
        return user;
    }
    
    public ArrayList<User> getAllUser() {
        ArrayList<User> list = new ArrayList<User>();
        String sql = "SELECT * FROM user";
        ResultSet rs = executedFetchQuery(sql);
        
        try {
            while(rs.next()) {
                User user = new User();
                user.setUserID(rs.getString("USERID"));
                user.setName(rs.getString("NAME"));
                user.setAddress(rs.getString("ADDRESS"));
                list.add(user);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }
    
    public void executedModifyQuery(String sql) {
        try {
            Connection con = ds.getConnection();
            con.createStatement().execute(sql);
            con.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public ResultSet executedFetchQuery(String sql) {
        ResultSet rs = null;
        try {
            Connection con = ds.getConnection();
            rs = con.createStatement().executeQuery(sql);
            con.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return rs;
    }

}
