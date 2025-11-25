package org.example.affablebeanfrontend.ds;

import java.util.ArrayList;
import java.util.List;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Category {
	private Integer id;
	private String name;

	private List<Product> products = new ArrayList<Product>();

	public void add(Product product) {
		this.products.add(product);
		product.setCategory(this);
	}

	public Category(String name) {
		super();
		this.name = name;
	}

}
