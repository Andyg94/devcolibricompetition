package ua.com.prologistic.devcompetition.utils;

import ua.com.prologistic.devcompetition.beans.Book;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Andrew on 23.10.2015.
 */

// Класс сотировки для объектов Book
// Если нам понадобиться в дальнейшем отсортировать книги по другим полям,
// то мы с легкостью сможем это сделать всего-лишь создав класс,
// реализующий компаратор по необходимому полю
public class BookComparator {

    private static DateComparator dateComparator;
    private static NameComparator nameComparator;
    private static AuthorNameComparator authorNameComparator;

    // получаем компаратор по дате
    public static Comparator<Book> getDateComparator() {
        if (dateComparator == null) {
            dateComparator = new DateComparator();
        }
        return dateComparator;
    }

    // получаем компаратор по названию
    public static Comparator<Book> getNameComparator() {
        if (nameComparator == null) {
            nameComparator = new NameComparator();
        }
        return nameComparator;
    }

    // получаем компаратор по имени автора
    public static Comparator<Book> getAuthorNameComparator() {
        if (authorNameComparator == null) {
            authorNameComparator = new AuthorNameComparator();
        }
        return authorNameComparator;
    }

    // определяем компаратор для сортировки книг
    // в данном случае мы определяем класс для сортировки по дате
    private static class DateComparator implements Comparator<Book> {
        @Override
        public int compare(Book lb, Book rb) {
            return lb.getPublishDate().compareTo(rb.getPublishDate());
        }
    }

    // определяем класс для сортировки по названию книги
    private static class NameComparator implements Comparator<Book> {
        @Override
        public int compare(Book lb, Book rb) {
            return lb.getName().compareTo(rb.getName());
        }
    }

    // определяем класс для сортировки по имени автора
    private static class AuthorNameComparator implements Comparator<Book> {
        @Override
        public int compare(Book lb, Book rb) {
            return lb.getAuthorName().compareTo(rb.getAuthorName());
        }
    }

    // сортирует список книг для сортировки с помощью нужного компаратора
    public static void sortBooks(List<Book> books, Comparator<Book> comparator) {
        int size = books.size();
        for (int i = 1; i < size; ++i) {
            for (int j = 0; j < (size - i); ++j) {
                int right = j + 1;
                if (comparator.compare(books.get(j), books.get(right)) > 0)
                    swapBooks(books, j, right);
            }
        }
    }

    // меняем элементы списка книг
    private static void swapBooks(List<Book> books, int left, int right) {
        Book temp = books.get(left);
        books.set(left, books.get(right));
        books.set(right, temp);
    }
}
