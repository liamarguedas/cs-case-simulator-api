package com.sode.domain;

import java.io.Serializable;
import java.util.Objects;

public class Category implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String namePrintable;

	public Category() {}

	public Category(String id, String name, String namePrintable) {
		this.id = id;
		this.name= name;
		this.namePrintable = namePrintable;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNamePrintable() {
		return namePrintable;
	}

	public void setNamePrintable(String namePrintable) {
		this.namePrintable = namePrintable;
	}

}
