/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ListProduct {

    ArrayList<Product> list;

    public ListProduct() {
        list = new ArrayList<>();
    }

    public int Count() {
        return list.size();
    }

    public boolean isEmpty() {
        if (list.isEmpty()) {
            return true;
        }
        return false;
    }

    public ArrayList<Product> getList() {
        return list;
    }

    public void addPro(Product x) {
        list.add(x);
    }

    public void deleteCate(String ID) {

    }

    public void printList() {
        for (Product product : list) {
            System.out.println(product);
        }
    }
}
