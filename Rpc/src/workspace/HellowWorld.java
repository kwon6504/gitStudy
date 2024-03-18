package workspace;

public class HellowWorld {
	 //1. 멤버 변수

	 //2. 멤버 함수

	public static void main(String[] args) { // main이 가장중요 흐름이 main아래부터		
		//콘솔창에 출력해주는 함수임. 매개변수에 출력할꺼 넣고					
		//얘도 에밋 기능 있음. sysout 치고 ctrl + space					
		//System.out.println('헬로 키티 월드');			// 문자열을 작은따옴표로 묶는거 안됨. 주의.		
		
		System.out.println("헬로 월드");			// 무조건 큰 따옴표임. 까다로움.		
							
		//실행은 ctrl + f11
		
		JavaTest man = new JavaTest();
		
		man.name = "디아블로";
		man.attack = 100;
		
		man.info();
	}						
}
//하나에 파일에 같은 이름으로(이름은 일치해야한다.) 첫글자는 대문자
