package com.deploysoft.meli.repository;

import com.deploysoft.meli.domain.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : J. Andrés Boyacá Silva
 * @since : 8/11/2020, Tue
 **/
@Repository
public interface ItemRepository extends JpaRepository<Item, String> {
}
