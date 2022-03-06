package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
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
    void shouldTestAddManager() {
        productManager.add(howLongMyLife);
        productManager.add(nokia);
        productManager.add(alcatel);
        productManager.add(farytale);

        Product[] expected = new Product[]{howLongMyLife, nokia, alcatel, farytale};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldTestAddManagerOneThing() {
        productManager.add(iPhone);

        Product[] expected = new Product[]{iPhone};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);

    }

    @Test
    void searchByBook() {
        productManager.add(markul);

        Product[] expected = new Product[]{markul};
        Product[] actual = productManager.searchBy("Track list");

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBySmartphone() {
        productManager.add(honor);

        Product[] expected = new Product[]{honor};
        Product[] actual = productManager.searchBy("Honor 1");

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByNameWithoutAdd() {

        Product[] expected = new Product[]{};
        Product[] actual = productManager.searchBy("Гарри Поттер и Узник Аскобана");

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByManufactureWithoutAdd() {

        Product[] expected = new Product[]{};
        Product[] actual = productManager.searchBy("Germany");

        assertArrayEquals(expected, actual);
    }

//    @Test
//    void searchByBooks() {
//        productManager.add(markul);
//        productManager.add(harryPotter);
//
//        Product[] expected = new Product[]{markul, harryPotter};
//        Product[] actual = productManager.searchBy("Track list" + "Гарри Поттер и Узник Аскобана");
//
//        assertArrayEquals(expected, actual);
//    }

//    @Test
//    void matches() {
//        productManager.matches(markul, "Track list");
//
//        Product[] expected = new Product[]{markul};
//        Product[] actual = productManager.searchBy("Track list");
//
//        assertEquals(expected, actual);
//    }
}
