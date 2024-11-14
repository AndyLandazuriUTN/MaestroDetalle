package com.example.maestrodetalle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText etAuthorId;
    private Button btnSearchAuthor;
    private RecyclerView rvBooks;
    private BookAdapter bookAdapter;

    private HashMap<String, Author> authorsDB = new HashMap<>();
    private HashMap<String, List<Book>> booksDB = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAuthorId = findViewById(R.id.etAuthorId);
        btnSearchAuthor = findViewById(R.id.btnSearchAuthor);
        rvBooks = findViewById(R.id.rvBooks);

        rvBooks.setLayoutManager(new LinearLayoutManager(this));

        // Simular algunos autores y libros
        loadSampleData();

        btnSearchAuthor.setOnClickListener(v -> {
            String authorId = etAuthorId.getText().toString();
            if (authorsDB.containsKey(authorId)) {
                List<Book> books = booksDB.get(authorId);
                if (books != null) {
                    bookAdapter = new BookAdapter(books);
                    rvBooks.setAdapter(bookAdapter);
                } else {
                    Toast.makeText(this, "Este autor no tiene libros.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Autor no encontrado.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadSampleData() {
        Author author1 = new Author("1", "Gabriel García Márquez");
        Author author2 = new Author("2", "Isabel Allende");

        authorsDB.put(author1.getId(), author1);
        authorsDB.put(author2.getId(), author2);

        List<Book> booksForAuthor1 = new ArrayList<>();
        booksForAuthor1.add(new Book("Cien años de soledad", "1"));
        booksForAuthor1.add(new Book("El coronel no tiene quien le escriba", "1"));

        List<Book> booksForAuthor2 = new ArrayList<>();
        booksForAuthor2.add(new Book("La casa de los espíritus", "2"));
        booksForAuthor2.add(new Book("Eva Luna", "2"));

        booksDB.put("1", booksForAuthor1);
        booksDB.put("2", booksForAuthor2);
    }
}
