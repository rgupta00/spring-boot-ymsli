package com.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;

public class Library {
    
    ArrayList<Book> books = new ArrayList<Book>();

    public Library() {
    }
    
    public void saveToJsonFile(String filename) throws IOException{
        File f = new File (filename);
        FileWriter fw  =new FileWriter(f);
        
        Gson gson = new Gson();
        for (Book book : books){
            String jsonLine = gson.toJson(book)+"\n";
            fw.append(jsonLine);
        }
        fw.close();
    }
    
    public void loadFromFile(String filename) throws FileNotFoundException {
        File f = new File (filename);
        Scanner fileInput = new Scanner(f);
        Gson gson = new Gson();
        while (fileInput.hasNextLine()){
            String jsonLine = fileInput.nextLine();
            Book book = gson.fromJson(jsonLine, Book.class);
            books.add(book);
        }
        fileInput.close();     
        
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> book) {
        this.books = book;
    }

      
    
}
