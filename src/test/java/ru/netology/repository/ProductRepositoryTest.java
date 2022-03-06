package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();
    ProductManager productManager = new ProductManager(repository);
    Book howLongMyLife = new Book(10, "How long my life?", 0, "Me");
    Book markul = new Book(11, "Track list", 7777, "Mark Markul");
    Book harryPotter = new Book(12, "Гарри Поттер и Узник Аскобана", 1500, "Д.Роулинг");
    Book farytale = new Book();
    Smartphone alcatel = new Smartphone();
    Smartphone nokia = new Smartphone(1, "Nokia 2220", 24000, "Germany");
    Smartphone iPhone = new Smartphone(22, "IPhone XR", 50000, "China");
    Smartphone xiaomi = new Smartphone(3, "Xiaomi RedMi 5", 18800, "China");
    Smartphone honor = new Smartphone(4, "Honor 1", 9000, "Russia");



    @Test
    void shouldTestSaveBooks() {

        repository.save(howLongMyLife);
        repository.save(markul);
        Product[] expected = new Book[]{howLongMyLife, markul};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldTestSaveSmartphones() {

        repository.save(iPhone);
        repository.save(nokia);
        repository.save(nokia);
        repository.save(xiaomi);
        Product[] expected = new Smartphone[]{iPhone, nokia, nokia, xiaomi};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldTestSaveBooksAndSmartphones() {
        repository.save(harryPotter);
        repository.save(honor);
        repository.save(farytale);
        repository.save(xiaomi);

        Product[] expected = new Product[]{harryPotter, honor, farytale, xiaomi};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldRemoveByIdSmartphones() {

        repository.save(nokia);
        repository.save(iPhone);
        repository.save(xiaomi);
        repository.save(honor);

        repository.removeById(22);

        Product[] expected = new Product[]{nokia, xiaomi, honor};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldRemoveByIdBooks () {

        repository.save(howLongMyLife);
        repository.save(harryPotter);

        repository.removeById(12);

        Product[] expected = new Product[] {howLongMyLife};
        Product[] actual = repository.findAll();
    }

    @Test
    void shouldRemoveByIdBooksAndSmartphones () {

        repository.save(howLongMyLife);
        repository.save(harryPotter);
        repository.save(xiaomi);
        repository.save(honor);

        repository.removeById(10);
        repository.removeById(3);

        Product[] expected = new Product[] {harryPotter, honor};
        Product[] actual = repository.findAll();
    }

}