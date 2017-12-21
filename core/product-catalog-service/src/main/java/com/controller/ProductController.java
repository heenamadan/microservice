package com.controller;

import com.controller.exception.RecordNotFoundException;
import com.model.ProductModel;
import com.service.ProductService;
import com.service.exception.RecordDoesNotExistException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Api(value="product-catalog-service")
@RequestMapping(value = "products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

	/**
     * Service instance
     * 
     */
    private ProductService productService;

    @Autowired
    public ProductController(ProductService service) {
        this.productService = service;
    }

    /**
     * Add Product on in format of productmodel json object
     * 
     */
    @ApiOperation(value = "Creates a new product definition", response = ProductModel.class)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProductModel add(@RequestBody final ProductModel product)
    {
        return productService.add(product);
    }


    /**
     * Get all Products
     * 
     */
    @ApiOperation(value = "Gets all the products in the catalog as a list", response = List.class)
    @GetMapping
    public List<ProductModel> getProducts()
    {
        try {
            return productService.getProducts();

        } catch(RecordDoesNotExistException ex) {
            throw new RecordNotFoundException(ex);
        }
    }

    /**
     * Get Product on basis of type for search criteria
     * 
     */
    @ApiOperation(value = "Gets the products in the catalog with a given type as a list", response = List.class)
    @GetMapping("/type/{type}")
    public List<ProductModel> getProductsByType(@PathVariable final String type)
    {
        try {
            return productService.getProductsByType(type);

        } catch(RecordDoesNotExistException ex) {
            throw new RecordNotFoundException(ex);
        }
    }

    
    /**
     * Get Product on basis of name and type for search criteria
     * 
     */
    @ApiOperation(value = "Gets the products in the catalog with a given name and type as a list", response = List.class)
    @GetMapping("/name/{name}/type/{type}")
    public List<ProductModel> getProductsByNameAndType(@PathVariable final String name,
                                                       @PathVariable final String type)
    {
        try {
            return productService.getProductsByNameAndType(name, type);

        } catch(RecordDoesNotExistException ex) {
            throw new RecordNotFoundException(ex);
        }
    }

    /**
     * Delete product on basis of product id.
     * */
    @ApiOperation(value = "Deletes a product definition with the given id", response = Void.class)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable final Long id)
    {
        try {
        	productService.delete(id);

        } catch(RecordDoesNotExistException ex) {
            throw new RecordNotFoundException(ex);
        }
    }
}
