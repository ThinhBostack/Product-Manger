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
public class ListCategory {

    ArrayList<Category> list;

    public ListCategory() {
        list = new ArrayList<>();
    }

    public ArrayList<Category> getList() {
        return list;
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

    public void addCate(Category x) {
        list.add(x);
    }

    public void deleteCate(String ID) {

    }

    public void printList() {
        for (Category category : list) {
            System.out.println(category);
        }
    }

}
