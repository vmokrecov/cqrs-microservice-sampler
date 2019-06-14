package com.soagrowers.productquery.repository;


import com.soagrowers.productquery.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

/**
 * Created by ben on 07/10/15.
 */
@Repository
public interface ReadOnlyPagingAndSortingRepository extends MongoRepository<Product, String> {

    @Override
    @SuppressWarnings("unchecked")
    @RestResource(exported = false)//true means the capability will be offered
    Product save(Product entity);

    @Override
    @RestResource(exported = false)//false restricts the capability
    void delete(String aLong);

    @Override
    @RestResource(exported = false)
    void delete(Product entity);
}
