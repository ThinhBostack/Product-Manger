/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBHelper.MyDB;
import DTO.ListProduct;
import DTO.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class ProductDAO {

    public static boolean addProduct(String ID, String name, int Quantity, int Price, String CategoryID) 
            throws ClassNotFoundException, SQLException {
        Connection cn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        //try {
            cn = MyDB.makeConnection();
            if (cn != null) {
                String sql = "Insert productDAO "
                        + "Values(?, ?, ?, ?, ?)";
                stm = cn.prepareStatement(sql);
                stm.setString(1, ID);
                stm.setString(2, name);
                stm.setInt(3, Quantity);
                stm.setInt(4, Price);                

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

    public static boolean deleteProduct(String ID) 
            throws ClassNotFoundException, SQLException {
        Connection cn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        //try {
            cn = MyDB.makeConnection();
            if (cn != null) {
                String sql = "Delete From productDAO "
                        + "Where ProductID = ? ";
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
    
    public static boolean deleteProductBYCategory(String CateID) 
            throws ClassNotFoundException, SQLException {
        Connection cn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        //try {
            cn = MyDB.makeConnection();
            if (cn != null) {
                String sql = "Delete From productDAO "
                        + "Where CategoryID = ? ";
                stm = cn.prepareStatement(sql);
                stm.setString(1, CateID);
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

    public static boolean saveProduct(String ID, String name, int quantity, int price) {
        Connection cn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            cn = MyDB.makeConnection();
            if (cn != null) {
                String sql = "Updates categoryDAO "
                        + "set CategoryName = ?, Quantity = ?, Price = ?"
                        + "Where CategoryID = ? ";
                stm = cn.prepareStatement(sql);
                stm.setString(1, name);
                stm.setInt(2, quantity);
                stm.setInt(3, price);
                stm.setString(4, ID);
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
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
        return false;
    }

    public static ListProduct getAllPro(String CateID) {
        Connection cn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        ListProduct list = new ListProduct();
        try {
            cn = MyDB.makeConnection();
            if (cn != null) {
                String sql = "Select ProductID, ProductName, Quantity, Price "
                        + "From productDAO "
                        + "Where CategoryID Like ? ";

                stm = cn.prepareStatement(sql);
                stm.setString(1, CateID);
                rs = stm.executeQuery();

                while (rs.next()) {
                    String ID = rs.getString("ProductID");
                    String name = rs.getString("ProductName");
                    int quantity = rs.getInt("Quantity");
                    int price = rs.getInt("Price");
                    Product x = new Product(ID, name, quantity, price);
                    list.addPro(x);
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
