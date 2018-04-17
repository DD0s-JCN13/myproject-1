package com.java2.object;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;

import sogo.Customer;
import sogo.GoldCustomer;
import sogo.SliverCustomer;

public class Sogo {
	Scanner sc1 = new Scanner(System.in);

	public void Sogo() {

	}

	public void start() {
		int function = 0;
		while (function != 3) {
			showFunctions();
			function = sc1.nextInt();
			switch (function) {
			case 1:
				inputSaleData();
				break;
			case 2:
				List<Sales> list = new ArrayList<>();
				try {
					FileInputStream fis = new FileInputStream("sales.txt");
					InputStreamReader isr = new InputStreamReader(fis);
					BufferedReader in = new BufferedReader(isr);
					String line = in.readLine();
					while (line != null) {
						String[] token = line.split("\t");
						try {
							int type = Integer.parseInt(token[0]);
							int amount = Integer.parseInt(token[1]);
							Sales sales = new Sales(type, amount);
							list.add(sales);
						} catch (NumberFormatException e) {
							System.out.println("��Ʈ榡���~");
							return;
						}
						line = in.readLine();
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// report
				for (Sales sales: list){
					Customer customer = null;
					switch(sales.type){
					case 1: 
						customer = new Customer(sales.getAmount());
						break;
					case 2:
						customer = new SliverCustomer(sales.getAmount());
						break;
					case 3:
						customer = new GoldCustomer(sales.getAmount());
						break;
					}
					customer.count();
				}
				
				
				break;
			case 3:
				return;
			}
		}
	}
	public void inputSaleData() {
		try {
			FileOutputStream fos = new FileOutputStream("sales.txt", true);
			PrintStream out = new PrintStream(fos);
			System.out.print("�п�J�|������:");
			int type = sc1.nextInt();
			System.out.print("�п�J�P����B:");
			int amount = sc1.nextInt();
			out.println(type + "\t" + amount);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void showFunctions() {
		System.out.println("�п�J�\��(1~3):");
		System.out.println("1) ��J�P��O��");
		System.out.println("2) �L�X�P�����");
		System.out.println("3) �����{��");
	}

	public static void main(String[] args) {
		Sogo sogo = new Sogo();
		sogo.start();
	}
}
