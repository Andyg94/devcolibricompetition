package ua.com.prologistic.devcompetition;

import ua.com.prologistic.devcompetition.beans.Book;
import ua.com.prologistic.devcompetition.utils.BookComparator;
import ua.com.prologistic.devcompetition.utils.DateGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrew on 23.10.2015.
 */
public class Main {
    public static void main(String[] args) {

        // экземпляр класса генерации рандомных дат
        DateGenerator date = new DateGenerator();

        // создаем список книг
        List<Book> books = new ArrayList<>();

        // создаем наши книги
        Book book1 = new Book("Java SE 8", "Key Horstmann", date.getRandomDate());
        Book book2 = new Book("The Object-Oriented Thought Process", "Mat Vaysfeld", date.getRandomDate());
        Book book3 = new Book("Java EE 7 Essentials", "Arun Gunta", date.getRandomDate());

        // заполняем список нашими книгами
        books.add(book1);
        books.add(book2);
        books.add(book3);

        System.out.println("Книги перед сортировкой");

        // распечатаем наши книги перед сортировкой
        for (Book b : books){
            System.out.println(b.toString());
        }

        System.out.println("Отсортированные книги: ");

        // сортируем книги
        // мы можем вставить любой и определенных ранее компараторов
        // в классе BookComparator вызовом
        // по дате:         getDateComparator()
        // по имени автора: getAuthorNameComparator()
        // по названию:     getNameComparator()
        BookComparator.sortBooks(books, BookComparator.getDateComparator());

        // распечатаем книги перед сортировкой
        for (Book b : books){
            System.out.println(b.toString());
        }
    }
}
