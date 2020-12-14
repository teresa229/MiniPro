package com.javaex.ex01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.Scanner;

import com.javaex.ex04.Person;

public class PersonApp {

	public static void main(String[] args) throws Exception {
		
	
		//스캐너
		Scanner sc = new Scanner(System.in);
		
		//입력
		Reader fr = new FileReader("C:\\Javastudy\\수업자료\\02.Java_Programming\\미니프로젝트\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);
		
		//

		
		//시작화면
		while(run) {	
		System.out.println("");
		System.out.println("*************************************");
		System.out.println("*         전화번호 관리 프로그램         *");
		System.out.println("*************************************");
		System.out.println("1.리스트    2.등록    3.삭제    4.검색    5.종료");
		System.out.println("-----------------------------------");
		
		//출력
		Writer fw = new FileWriter("C:\\Javastudy\\수업자료\\02.Java_Programming\\미니프로젝트\\PhoneDB.txt");
		BufferedWriter fr = new BufferedWriter(fw);
		
		System.out.println(">메뉴번호:");
		int menuNo = sc.nextInt();
		
		switch(menuNo) {
			
			case 1:
				System.out.println("<1.리스트>");
				
				while(true) {
					line = br.readLine();
					if(line == null) {
						break;
					}
					String[] personInfo = line.split(",");
					Person person = new Person(personInfo[0],personInfo[1],personInfo[2]);
					list.add(person);
				}
				break;
		
			case 2:
				System.out.println("<2.등록>");
				System.out.println(">이름:");
				sc.nextLine();
				name = sc.nextLine();
				System.out.println(">휴대전화:");
				hp = sc.nextLine();
				System.out.println(">회사전화:");
				company = sc.nextLine();
				
				
			case 3:	
				System.out.println("<3.삭제>");
				System.out.println(">번호:");
				num = sc.nextInt();
				
				break;
				
			case 4:
				System.out.println("<4.검색>");
				
			case 5:
				System.out.println("*************************************");
				System.out.println("*         감사합니다               *");
				System.out.println("*************************************");
				a = false;
				break;
				
			default;
				System.out.println("다시 입력해 주세요.");
				break;
			
		}		
		br.close();
		sc.close();
		}
	}
}
