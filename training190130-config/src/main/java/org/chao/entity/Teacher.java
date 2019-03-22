package org.chao.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class Teacher {

	private int id;
	private String name;
}
