package q23_v9_kiosk;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuInfo{
	
	// 배열 추가는 public static void 쓰는 main 에서만 가능
//	boolean a = true;
	public static int sum_dr = 0;
	public static int sum_ds = 0;
	public static int sum_de = 0;
	public static int sum_all = 0;
	
	public static ArrayList<Product> drink = new ArrayList<Product>();
	public static ArrayList<Product> drink_T = new ArrayList<Product>();
	public static ArrayList<Product> drinksize = new ArrayList<Product>();
	public static ArrayList<Product> dessert= new ArrayList<Product>();
	public static ArrayList<Product> drdeds_T= new ArrayList<Product>();
	public static ArrayList<Product> LastOrder= new ArrayList<Product>();
	
	public static Scanner sc = new Scanner(System.in);
	public static String cmd;
	
	//음료수
	public static Product dr1 = new Product("뜨거운커피",2000,"1");
	public static Product dr2 = new Product("아이스아메리카노",2500,"2");
	public static Product dr3 = new Product("딸기스무디",4000,"3");
	public static Product dr4 = new Product("복숭아스무디",4000,"4");
	
	//디저트
	public static Product de1 = new Product("케이크",5000,"1");
	public static Product de2 = new Product("마카롱",3000,"2");
	public static Product de3 = new Product("샌드위치",4000,"3");
	
	//사이즈 업
	public static Product si1 = new Product("톨(기본)",0,"1");
	public static Product si2 = new Product("그란데",2000,"2");
	public static Product si3 = new Product("벤티",4000,"3");
	public static Product si4 = new Product("트렌타",6000,"4");
	
}
