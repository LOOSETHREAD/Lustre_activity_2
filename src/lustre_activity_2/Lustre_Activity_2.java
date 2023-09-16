/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lustre_activity_2;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author User
 */
class Bookmenu{
    private String title;
    private String author;
    private String isbn;
    
    public Bookmenu(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
    public String title() {
        return title;
        
    }
    public String author() {
        return author;
    }
    public String isbn() {
        return isbn;
    }
    public String toString() {
        return "Title: " + title + "\nAuthor: " + author + "\nISBN: " + isbn;
        
    }
}
public class Lustre_Activity_2 {
    private LinkedList<Bookmenu> books = new LinkedList<>();
    
    public void insertBookMenu(String title, String author, String isbn) {
        Bookmenu addBook = new Bookmenu(title, author, isbn);
        books.add(addBook);
        System.out.println("\nBook Added: " + title + " " + author + " " + isbn + "\n");
        }
    public void deleteBook(String isbn) {
        for(int i = 0; i < books.size(); i++){
            Bookmenu book = books.get(i);
            if(book.isbn() .equals(isbn)){
                books.remove(i);
                System.out.println("The Book with the isbn " + isbn + "is deleted");
                
            }else{
                System.out.println("Book not found");
            }
            
        }
    }
    public void search(String isbn) {
        for(Bookmenu book : books) {
            if(book.isbn() . equals(isbn)){
                System.out.println(book);
                return;
            }else{
                System.out.println("Book not found");
            }
        }
    }
    public void sortBook(){
        for(int i = 0; i < books.size(); i++){
            int minIndex = i;
            for(int j = i + 1; j < books.size(); j++){
                if(books.get(j).isbn().compareTo(books.get(minIndex).isbn())< 0){
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                Bookmenu book = books.get(i);
                books.set(i,books.get(minIndex));
                books.set(minIndex, book);
            }
        }
    }
    public void display(){
        for(Bookmenu book : books){
            System.out.println(book + "\n");
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Lustre_Activity_2 Library = new Lustre_Activity_2();
        Scanner scn = new Scanner(System.in);
        
        while(true) {
            System.out.println("Book Menu");
            System.out.println("[1] Add a Book");
            System.out.println("[2] Search a Book");
            System.out.println("[3] Display Book List");
            System.out.println("[4] Delete A Book");
            System.out.println("[5] Exit");
            System.out.println("Input Number: ");
            int input = scn.nextInt();
            scn.nextLine();
            
            
            if(input == 1){
                System.out.println("Enter Title: ");
                String title = scn.nextLine();
                System.out.println("Enter Author: ");
                String author = scn.nextLine();
                System.out.println("Enter ISBN: ");
                String isbn = scn.nextLine();
                
                Library.insertBookMenu(title, author, isbn);
            }
            else if(input == 2){
                System.out.println("Enter ISBN: ");
                String isbn = scn.nextLine();
                
                Library.search(isbn);
                
            }
            else if(input == 3){
                System.out.println("Book List");
                Library.display();
                        
            }
            else if(input == 4){
                System.out.println("Enter ISBN of the Book: ");
                String isbn = scn.nextLine();
                Library.deleteBook(isbn);
            }
            else if(input == 5){
                System.out.println("Bye!");
                scn.close();
                System.exit(0);
            }
            else{
                System.out.println("Invalid Input!");
            }
        }
    }
    
}
