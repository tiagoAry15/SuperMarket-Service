package com.spring.market.model;

import java.util.List;

import jakarta.persistence.*;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;


@Entity
@Table(name = "shopping_carts")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
	
	@OneToMany(mappedBy = "carrinho")
    private List<ItemCart> items;
	
	
}
