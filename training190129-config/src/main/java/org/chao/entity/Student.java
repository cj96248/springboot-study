package org.chao.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class Student {

	private int id;
	private String name;
}
