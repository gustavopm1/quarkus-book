package org.gustavo.quarkus.starting;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.PathParam;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

    public List<Book> getAllBooks() {
        return List.of(
                new Book(1, "Crime and Punishment", "Fyodor Dostoevsky", 1886, "Literary Fiction"),
                new Book(1, "David Copperfield", "Charles Dickens", 1850, "Bildungsroman"),
                new Book(1, "The Hunchback of Notre-Dame", "Victor Hugo", 1831, "Gothic"),
                new Book(1, "The Posthumous Memoirs of Brás Cubas", "Machado de Assis", 1881, "Novel")
        );
    }

    public Optional<Book> getBook(int id) {
        return getAllBooks().stream().filter(book -> book.id == id).findFirst();
    }

}
