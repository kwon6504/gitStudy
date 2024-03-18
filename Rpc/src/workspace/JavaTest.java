package workspace; //키보드로 하는거에 익숙해지기 (마우스 덜쓰기)
//ctrl+N 하고 class 찾는게 new하는것보다 빠르다.
public class JavaTest {
	public static void main(String[] args) {
		System.out.println("디아블로");
		
	}
	
	String name;
	int attack;
	
	void info() {
		String s = "악마의 이름은 " + name + "이고 공격력은 " + attack + " 이다.";
		System.out.println(s);
	}
}
