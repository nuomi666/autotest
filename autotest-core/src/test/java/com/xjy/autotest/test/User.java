package com.xjy.autotest.test;


import com.xyb.adk.common.util.money.Money;

/**
 * @author huairen
 * Created on 18/3/29.
 */
public class User {

	private String name;

	private int id;

	private int age;

	private Money money;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Money getMoney() {
		return money;
	}

	public void setMoney(Money money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", id=" + id +
				", age=" + age +
				", money=" + money +
				'}';
	}
}
