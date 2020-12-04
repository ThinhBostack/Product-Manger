/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBHelper.MyDB;
import DTO.Category;
import DTO.ListCategory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class CategoryDAO {

    public static boolean addCategory(String ID, String name)
            throws SQLException, ClassNotFoundException {
        Connection cn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        //try {
        cn = MyDB.makeConnection();
        if (cn != null) {
            String sql = "Insert categoryDAO "
                    + "Values(?, ?) ";
            stm = cn.prepareStatement(sql);
            stm.setString(1, ID);
            stm.setString(2, name);

            int row = stm.executeUpdate();
            if (row > 0) {
                return true;
            }
        }
        //} /*catch (ClassNotFoundException | SQLException ex) {                    
        /*} finally {
            try {
                if (cn != null) {
                    cn.close();
                }
                if (stm != null) {
                    stm.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {                
            }
        }*/
        return false;
    }

    public static boolean saveCategory(String ID, String name)
            throws ClassNotFoundException, SQLException {
        Connection cn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        //try {
        cn = MyDB.makeConnection();
        if (cn != null) {
            /*String sql = "Updates categoryDAO "
                    + "Set CategoryName = '?' "
                    + "Where CategoryID = ? ";*/
            String sql = "update categoryDAO "
                    + "set CategoryName = '?' "
                    + "where CategoryID = ? ";                
            stm = cn.prepareStatement(sql);
            stm.setString(1, name);
            stm.setString(2, ID);

            int row = stm.executeUpdate();
            if (row > 0) {
                return true;
            }
        }
        /*} catch (ClassNotFoundException | SQLException ex) {
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
                if (stm != null) {
                    stm.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
            }
        }*/
        return false;
    }

    public static boolean deleteCategory(String ID)
            throws ClassNotFoundException, SQLException {
        Connection cn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        //try {
        cn = MyDB.makeConnection();
        if (cn != null) {
            String sql = "Delete From categoryDAO "
                    + "Where CategoryID = ? ";
            stm = cn.prepareStatement(sql);
            stm.setString(1, ID);
            int row = stm.executeUpdate();
            if (row > 0) {
                return true;
            }
        }
        /*} catch (ClassNotFoundException | SQLException ex) {
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
                if (stm != null) {
                    stm.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
            }
        }*/
        return false;
    }

    public static ListCategory getAllCate() {
        Connection cn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        ListCategory list = new ListCategory();
        try {
            cn = MyDB.makeConnection();
            if (cn != null) {
                String sql = "Select CategoryID, CategoryName "
                        + "From categoryDAO ";
                stm = cn.prepareStatement(sql);
                rs = stm.executeQuery();

                while (rs.next()) {
                    String ID = rs.getString("CategoryID");
                    String name = rs.getString("CategoryName");
                    Category x = new Category(ID, name);
                    list.addCate(x);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
                if (stm != null) {
                    stm.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
            }
        }
        return list;
    }
}
