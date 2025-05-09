package com.sode.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.sode.domain.enums.SkinCategory;

@Document
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private SkinCategory category;
	private String printable;

	public Category() {
	}

	public Category(String id, SkinCategory category) {
		this.id = id;
		this.category = category;
		this.printable = generatePrintable();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public SkinCategory getCategory() {
		return category;
	}

	public void setCategory(SkinCategory category) {
		this.category = category;
	}

	public String getPrintable() {
		return printable;
	}

	public void setPrintable(String printable) {
		this.printable = printable;
	}

	private String generatePrintable() {

		String prefix = switch (category.getValue()) {
		case 2 -> "StatTrak™";
		case 3, 4 -> "★";
		default -> "";
		};

		return prefix;
	}

}
