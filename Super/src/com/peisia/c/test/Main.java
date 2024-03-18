package com.peisia.c.test;

import java.util.ArrayList;

import com.peisia.c.util.Color;
import com.peisia.c.util.Cw;

public class Main {

	public static void main(String[] args) {
		// 게임 오브젝트들 로딩
		Character c = new Character("고양이",3,100);
		
		//형(type) 변환
		//Character 클래스가 GameObj 로 바꼈다.
		GameObj go = new Character("고양이",3,100);
		GameObj g = c;
		// g = c;가 된다. 자동형변환, 묵시적 타입 변환. 반대는 성립 못한다.
		//1.아버지 양복 훔쳐입어서 아버지 객체로 취급이됨.
		//2.아버지로 변신했기 때문에 자기 자신의 행동을 못함
		//ex)go.hp로 사용불가
//		System.out.println(go.hp); 에러
		//3.자기꺼를 하려면 다시 변신을 풀어야함.
		Character cc = (Character)go; //이렇게 자기 형으로 형변환해서 돌아가야됨
		// 괄호 + 클래스명 + 괄호 + 변수 
		System.out.println(cc.hp); //돌아가고 난 다음엔 자기꺼 쓸 수 있게됨
		
		Sword s = new Sword("단검",2,100,50,70);
		Sword l = new Sword("장검",3,150,100,70);

		//할아버지형 리스트에 손자,아들,본인 다 넣을수 있음. (상속의 중요 특성)
		ArrayList<GameObj> gs = new ArrayList<>(); //<>안에 GameObj가 들어간다.
		gs.add(c); //자동 형변환이 일어남. 원래는 불가능하나 가족관계(상속)증명되면 가능하다.
		gs.add(go); //단 부모형태로 자동 형변환하여.
		gs.add(s);
		gs.add(l);
		for(GameObj o : gs) {
//			Cw.wn(o.name);
			Color.red(o.name);
//			Cw,wn(o.attack);는 불가능 부모의 형태가 아니기때문
		}
	}
	
}



