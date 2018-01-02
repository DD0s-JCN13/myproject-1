package com.vendermachine;

public class Drink {
	 int price;
	static String name;
	int coin;

	public Drink() {
	}

	public Drink(int price, String name,int coin) {
		this.price = price;
		this.name = name;
		this.coin = coin;
	}
	public Drink(int price, String name){
		this.price = price;
		this.name = name;
	}

	public Drink(int coin){
		this.coin = coin;
	}
	public Drink(String name){
		this.name = name;
	}
	public int getCoin() {
		return (coin);
	}

	public static String getName(){
			return(name);
		}
	public void showMoney() {
		System.out.println("�{�b�l�B: " + coin);
	}
	public void showName(){
		System.out.println("���" + name + "����");
	}
	public void showLastMoney(){
		int a = price - coin;
		System.out.println(a);
	}
}
