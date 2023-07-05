package com.spring.market.model;

import jakarta.persistence.*;

@Entity
@Table(name = "item_carts")
public class ItemCart {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Product produto;

    @ManyToOne
    @JoinColumn(name = "carrinho_id")
    private ShoppingCart carrinho;

    private int quantidade;

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
