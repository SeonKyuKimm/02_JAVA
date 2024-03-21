	package edu.kh.oop.practice.model.service;

import edu.kh.oop.practice.model.vo.Hero;

public class HeroService {
	
	public void ex1() {
		
		// 객체 1
		Hero hero = new Hero();
		
		hero.setNickName("히어로");
		hero.setJob("전사");
		hero.setHp(200);
		hero.setMp(20);
		hero.setLevel(1);
		hero.setExp(100);
		
		System.out.printf("%s 직업으로 '%s' 님이 생성되었습니다. 현재 레벨 : %d \n", 
						hero.getJob(), hero.getNickName(), hero.getLevel()	
						);
		
		
		hero.magicJump();
		hero.magicJump();
		hero.magicJump();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		// 객체 2	
		Hero hero1 = new Hero();
		
		hero1.setNickName("히어로1");
		hero1.setJob("마법사");
		hero1.setHp(100);
		hero1.setMp(100);
		hero1.setLevel(1);
		hero1.setExp(100);
		
		System.out.printf("%s 직업으로 '%s' 님이 생성되었습니다. 현재 레벨 : %d \n", 
				hero1.getJob(), hero1.getNickName(), hero1.getLevel()	
				);
		
		System.out.println("======================");
		
		hero1.attack(100);
		hero1.attack(100);

		System.out.println("======================");
		
		hero1.attack(500);
		
		hero1.magicJump();
		
		
	}
	
	
}
