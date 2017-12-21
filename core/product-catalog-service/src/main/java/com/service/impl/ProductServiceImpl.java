package com.service.impl;

import com.domain.entity.Product;
import com.domain.repository.ProductRepository;
import com.mapper.ObjectMapperBinding;
import com.model.ProductModel;
import com.service.ProductService;
import com.service.exception.RecordDoesNotExistException;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
final class ProductServiceImpl implements ProductService {

    private ProductRepository repository;
    private ObjectMapperBinding mapper;


	/**
     * ProductServiceImpl constructor
     * 
     */
    public ProductServiceImpl(ProductRepository repository, ObjectMapperBinding mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Add product
     * 
     */
    @Override
    public ProductModel add(final ProductModel product)
    {
        Product entity = mapper.map(product, Product.class);
        entity = repository.save(entity);
        return mapper.map(entity, ProductModel.class);
    }


    /**
     * Get all products from db
     * 
     */
    @Override
    public List<ProductModel> getProducts()
    {
        List<Product> entities = (List<Product>) repository.findAll();
        if (entities.size() < 1)
            throw new RecordDoesNotExistException();
        return mapper.mapList(entities, ProductModel.class);
    }


    /**
     * Get all products by type from db
     * 
     */
    @Override
    public List<ProductModel> getProductsByType(final String type)
    {
    	final List<Product> entities = repository.findByType(type);
        if (entities.size() < 1){
            throw new RecordDoesNotExistException();
        }
        return mapper.mapList(entities, ProductModel.class);
    }


    /**
     * Get all products by type and name from db
     * 
     */
    @Override
    public List<ProductModel> getProductsByNameAndType(final String name, final String type)
    {
        final List<Product> entities = repository.findByNameAndType(name, type);
        if (entities.size() < 1)
            throw new RecordDoesNotExistException();
        return mapper.mapList(entities, ProductModel.class);
    }


    /**
     * Delete product by id.
     * 
     */
    @Override
    public void delete(final Long id)
    {
        Product product = repository.findOne(id);
        if (product == null)
            throw new RecordDoesNotExistException();
        repository.delete(product);
    }

	
}
