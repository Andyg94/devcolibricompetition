package ua.com.prologistic.devcompetition.beans;

import java.util.Date;

/**
 * Created by Andrew on 23.10.2015.
 */
public class Book {

    String name;
    String authorName;
    Date publishDate;

    public Book() {
    }

    public Book(String name, String authorName, Date publishDate) {
        this.name = name;
        this.authorName = authorName;
        this.publishDate = publishDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "\nBook{" +
                "\nname='" + name + '\'' +
                ",\nauthorName='" + authorName + '\'' +
                ",\npublishDate=" + publishDate +
                "\n}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!getName().equals(book.getName())) return false;
        if (!getAuthorName().equals(book.getAuthorName())) return false;
        return getPublishDate().equals(book.getPublishDate());

    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getAuthorName().hashCode();
        result = 31 * result + getPublishDate().hashCode();
        return result;
    }
}
