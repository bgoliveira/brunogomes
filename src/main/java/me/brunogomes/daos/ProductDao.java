package me.brunogomes.daos;

import org.springframework.data.repository.CrudRepository;

import me.brunogomes.models.Product;

public interface ProductDao extends CrudRepository<Product, Integer> {

}
