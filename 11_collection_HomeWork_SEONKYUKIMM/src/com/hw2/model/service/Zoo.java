package com.hw2.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hw2.model.dto.Animal;
import com.hw2.model.dto.Tiger;

public class Zoo {
	
	
	
	private List<Animal> animals;
	
	

	public Zoo() {
		animals = new ArrayList<Animal>();
	}
	
	public void addAnimal(Animal animal) {
		// 단순히 전달받은 animal 을 배열에 넣어주는?
		animals.add(animal);
		// 업캐스팅 상태 (Run.20 ,Run.21)
	}
	
	public void showAnimals() {
		System.out.println("동물들의 울음소리를 들어보세요");
		for (Animal animal : animals ) {
			animal.sound();
		}
	}
	
	public void displayMenu() {
		Scanner sc = new Scanner(System.in);
		
		int menuNum = 0;
		
		do {
			
			System.out.println("****** KH 동물원 ******");
		
			System.out.println("원하는 작업을 선택하세요 : ");
			System.out.println("1 . 동물들의 울음소리 듣기");
			System.out.println("2 . 종료");
			System.out.print("선택 : ");
			
			menuNum = sc.nextInt();
			 
			 switch (menuNum) {
				 case 1 : showAnimals(); break;
				 case 2 : System.out.println("프로그램 종료합니다"); break;
				 default : System.out.println("잘못된 선택입니다. 다시 선택해 주세요");
			 }
			
			 
		}while (menuNum != 2);
		
		
	}
}
