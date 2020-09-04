package com.rlsp.resources;

import com.rlsp.dto.ProductDTO;
import com.rlsp.models.Product;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    @GET
    public List<Product> getAllProducts(){
        return Product.listAll();
    }

    @POST
    @Transactional
    public void buscarTodosProdutos(ProductDTO dto) {
        Product p = new Product();
        p.name = dto.name;
        p.value = dto.value;
        p.persist();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public void modifyProductsById(@PathParam("id") Long id, ProductDTO dto) {

        Optional<Product> productOptional = Product.findByIdOptional(id);

        if (productOptional.isPresent()) {
            Product produto = productOptional.get();
            produto.name = dto.name;
            produto.value = dto.value;
            produto.persist();
        } else {
            throw new NotFoundException();
        }

    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void getAllProductsById(@PathParam("id") Long id) {

        Optional<Product> productOptional = Product.findByIdOptional(id);

        productOptional.ifPresentOrElse(Product::delete, () -> {
            throw new NotFoundException();
        });

    }

}
