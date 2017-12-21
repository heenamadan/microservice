package com.service;

import java.util.List;

import com.model.ProductModel;

public interface ProductService {

	ProductModel add(ProductModel product);

    List<ProductModel> getProducts();

    List<ProductModel> getProductsByNameAndType(final String name,final String type);

    List<ProductModel> getProductsByType(final String type);

    void delete(final Long id);
}
