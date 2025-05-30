/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.db;
import dto.Book;
import interfaces.IBookDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class BookDAO implements IBookDAO {

    @Override
    public int addNewBook(Book book) {
        int result = 0;
        Connection cn = null;

        try {
            // connect with db
            cn = db.getConnection();
            if (cn != null) {
                String sql = "insert [dbo].[books]\n"
                        + "values (?, ?, ?, ?, ? ,? ,? ,?, ?)";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, Integer.toString(book.getId()));
                st.setString(2, book.getTitle());
                st.setString(3, book.getAuthor());
                st.setString(4, book.getIsbn());
                st.setString(5, book.getCategory());
                st.setString(6, Integer.toString(book.getPublished_year()));
                st.setString(7, Integer.toString(book.getTotal_copies()));
                st.setString(8, Integer.toString(book.getAvailable_copies()));
                st.setString(9, book.getStatus());
                st.setString(10, book.getUrl());

                result = st.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;

    }

    @Override
    public int updateBookInfo(Book book) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int hideBook(Book book) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int updateInventory(Book book) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Book> getListOverdueBook() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
