package ru.netology.repository;

import ru.netology.domain.Product;
import ru.netology.exception.AlreadyExistsException;
import ru.netology.exception.NotFoundException;

import java.util.Arrays;

public class ProductRepository {
    private Product[] items = new Product[0];

    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];

        System.arraycopy(items, 0, tmp, 0, items.length);
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public Product[] findAll() {
        return items;
    }

    public void removeById(int id) throws NotFoundException {

        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + "not found");
        }

        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
            items = tmp;
        }
    }

    public Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "ProductRepository{" +
                "items=" + Arrays.toString(items) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRepository that = (ProductRepository) o;
        return Arrays.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(items);
    }
}
