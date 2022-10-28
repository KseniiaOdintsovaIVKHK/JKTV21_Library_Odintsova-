/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Book;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pupil
 */
public class DataManager {
    private final String  FILENAME_BOOKS = "files/MyBooks";
    private final File file;
    public DataManager() {
        file =new File("files");
        file.mkdirs();
    
    
    
    }
    
    public void saveBooksToFile(Book[] books){
        try {
            
             FileOutputStream fileOutputStream = new FileOutputStream(FILENAME_BOOKS);
               ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
               objectOutputStream.writeObject(books);
            } catch (FileNotFoundException ex) {
                    Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Нет такого файла", ex);
            } catch (IOException ex) {
                    Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Ошибка ввода / вывода", ex);
            }
        
    }
    
   public Book[] loadBooksFromFile() {
       Book[] books = new Book[0];
       
        try{
            FileInputStream fileInputStream = new FileInputStream("MyBooks");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            books = (Book[]) objectInputStream.readObject();
            
        } catch (FileNotFoundException | ClassNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Нет такого файла", ex);
        } catch (IOException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Ошибка ввода / вывода", ex);
        }
        return books;
    }
    
}
