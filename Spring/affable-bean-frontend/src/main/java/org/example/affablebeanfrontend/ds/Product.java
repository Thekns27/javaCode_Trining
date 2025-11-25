package org.example.affablebeanfrontend.ds;

import java.time.LocalDate;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class Product {

	private Integer id;
	private String name;
	private Double price;
	private String description;
	private LocalDate last_update;
	private Category category;

	public Product(String name, Double price, String description, LocalDate last_update, Category category) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.last_update = last_update;
		this.category = category;
	}

}
