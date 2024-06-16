package com.yasarchavez.literalura.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.yasarchavez.literalura.model.Author;
import com.yasarchavez.literalura.model.AuthorRec;
import com.yasarchavez.literalura.model.Book;
import com.yasarchavez.literalura.model.BookRec;
import com.yasarchavez.literalura.model.DatosRec;
import com.yasarchavez.literalura.repository.AuthorRepository;
import com.yasarchavez.literalura.repository.BookRepository;
import com.yasarchavez.literalura.utils.ConsumoApi;
import com.yasarchavez.literalura.utils.ConvierteDatos;

@Service
public class Principal {
    private AuthorRepository autorRepository;
    private BookRepository bookRepository;
    // private static final String URL_BASE = "https://gutendex.com/books/";
    private static final String URL_BASE = "https://gutendex.com/books/?search=";
    // private static final String URL_BASE =
    // "https://gutendex.com/books/?search=Cthulhu";
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConvierteDatos conversor = new ConvierteDatos();
    private Scanner teclado = new Scanner(System.in);

    public Principal(AuthorRepository autorRepository, BookRepository bookRepository) {
        this.autorRepository = autorRepository;
        this.bookRepository = bookRepository;
    }

    public void MuestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    Seleccione una opción:
                    1 - Consulta por título del libro
                    2 - Mostrar libros
                    3 - Buscar un libro / autor
                    4 - Buscar un autor
                    5 - Buscar un libro por autor
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
                case 1:
                    consultaPorTituloDelLibro();
                    break;
                case 2:
                    mostrarLibros();
                    break;
                case 3:
                    buscarLibro();
                    break;
                case 4:
                    mostrarAutores();
                    break;
                case 5:
                    buscarLibroPorAutor();
                    break;
                case 0:
                    System.out.println("Gracias por usar el sistema");
                    break;
                default:
                    break;
            }

        }

        // var json = consumoApi.obtenerDatos(URL_BASE);
        // var json = consumoApi.obtenerDatos(URL_BASE + busqueda.replace(" ",
        // "%20").toLowerCase());
        // System.out.println(json);
        // var datos = conversor.obtenerDatos(json, DatosRec.class);
        // guardarAuthor(datos);
        // datos.results().forEach(System.out::println);
        // System.out.println(datos);
        // AuthorRec autor = datos.results().get(0).authors().get(0);

        // System.out.println(autor);
        // Author autorEntidad = new Author(autor.name(), autor.birthYear(),
        // autor.deathYear());

        // autorRepository.save(autorEntidad);
        // System.out.println(autorEntity);
        // autorRepository.save(autorEntity);
        // Convertir esos datos a libros y autores

    }

    private void buscarLibroPorAutor() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarLibroPorAutor'");
    }

    private void consultaPorTituloDelLibro() {
        /**
         * Título;
         * Autor;
         * Idiomas;
         * Número de Descargas.
         */
        System.out.println("Ingrese el titulo a buscar:");
        var busqueda = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + busqueda.replace(" ", "%20").toLowerCase());
        var datos = conversor.obtenerDatos(json, DatosRec.class);
        System.out.println("");
        System.out.println("Titulo: " + datos.results().get(0).title());
        System.out.println("Autor: " + datos.results().get(0).authors().get(0).name());
        System.out.println("Idiomas: " + datos.results().get(0).languages().get(0));
        System.out.println("Cantidad de descargas: " + datos.results().get(0).downloadCount());
        System.out.println("");

        System.out.println("Desea agregar el autor a la base de datos? s/n");
        var respuesta = teclado.nextLine();
        if (respuesta.equalsIgnoreCase("s")) {
            // AuthorRec autor = datos.results().get(0).authors().get(0);
            // Author autorEntidad = new Author(autor.name(), autor.birthYear(),
            // autor.deathYear());
            // autorRepository.save(autorEntidad);
            guardarAuthor(datos);
            System.out.println("Se agrego el autor");
        } else {
            System.out.println("No se agrego el autor");
        }
        System.out.println("Desea guardar el libro en la base de datos? s/n");
        respuesta = teclado.nextLine();
        if (respuesta.equalsIgnoreCase("s")) {
            guardarLibro(datos);
            System.out.println("Se agrego el libro");
        } else {
            System.out.println("No se agrego el libro");
        }

    }

    private void buscarLibro() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarLibro'");
    }

    private void mostrarLibros() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrarLibros'");
    }

    // public void guardarAuthor(DatosRec datos) {
    // List<Author> authors = new ArrayList<>();
    // datos.results().forEach(book -> book.authors().forEach(authorRec -> {
    // Author author = new Author(authorRec.name(), authorRec.birthYear(),
    // authorRec.deathYear());
    // authors.add(author);
    // }));
    // autorRepository.saveAll(authors);
    // }
    public void guardarAuthor(DatosRec datos) {
        AuthorRec autor = datos.results().get(0).authors().get(0);
        Author autorEntidad = new Author(autor.name(), autor.birthYear(), autor.deathYear());
        autorRepository.findByName(autor.name()).ifPresentOrElse(System.out::println, () -> {
            autorRepository.save(autorEntidad);
        });
    }

    public void guardarLibro(DatosRec datos) {
        BookRec book = datos.results().get(0);
        Book bookEntity = new Book(book);
        if (book.authors()!=null) {
            bookRepository.save(bookEntity);
            System.out.println(book);
        }else{
            System.out.println(book);
        }
    }

    public void mostrarAutores() {
        List<Author> autores = autorRepository.findAll();
        autores.forEach(System.out::println);
    }

}
