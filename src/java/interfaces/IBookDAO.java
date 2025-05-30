/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.Book;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public interface IBookDAO {
    public int addNewBook(Book book);
    public int updateBookInfo(Book book);
    public int hideBook(Book book);
    public int updateInventory(Book book);
    public ArrayList<Book> getListOverdueBook();
}
