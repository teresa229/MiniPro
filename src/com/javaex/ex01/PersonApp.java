package com.javaex.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonApp {

	public static void main(String[] args) throws IOException {
		
		//스캐너
		Scanner sc = new Scanner(System.in);
		
		System.out.println("*************************************");
		System.out.println("*          전화번호 관리 프로그램                    *");
		System.out.println("*************************************");
		ArrayList<Person> pList = new ArrayList<Person>();
		
		pList.clear();
		
		//입력
		Reader fr = new FileReader("C:\\Javastudy\\수업자료\\02.Java_Programming\\미니프로젝트\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);

		
		//시작화면
		while(true) {
			String str = br.readLine();
			
			if(str == null) {
				break;
			}
		
			String[] Personarr = str.split(",");
			Person p01 = new Person(Personarr[0],Personarr[1],Personarr[2]);
			pList.add(p01);
		}
		
		while(true) {
			System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
			System.out.println("-----------------------------------");
			System.out.println(">>메뉴번호:");
		
			//메뉴 번호 입력
			int num = sc.nextInt();
			
			//5번 출력하면 프로그램 종료
			if(num == 5) {
				System.out.println("*************************************");
				System.out.println("*               감사합니다                          *");
				System.out.println("*************************************");
				break;		
			}
			
			//1번 리스트
			if(num == 1) {
				System.out.println("<1.리스트>");
				
				for(int i = 0; i<pList.size(); i++) {
					System.out.println((i+1)+".\t"+pList.get(i).getName()+"\t"+pList.get(i).getHp()+"\t"+pList.get(i).getCompany());
				}
				
			}else if(num==2) {
				System.out.println("<2.등록>");
				
				Writer fw = new FileWriter("C:\\Javastudy\\수업자료\\02.Java_Programming\\미니프로젝트\\PhoneDB.txt");
				BufferedWriter bw = new BufferedWriter(fw);
				
				System.out.println(">이름:");
				String name = sc.next();
				System.out.println(">휴대전화:");
				String hp = sc.next();
				System.out.println(">회사전화:");
				String company = sc.next();
				
				Person p02 = new Person(name,hp,company);
				pList.add(p02);
				
				for(int i=0;i<pList.size(); i++) {
					bw.write(pList.get(i).getName()+","+pList.get(i).getHp()+","+pList.get(i).getCompany());
					bw.newLine();
				}
				
			}else if(num==3) {
				
				System.out.println(">번호:");
				int number = sc.nextInt();
				
				for(int i = 0; i<pList.size(); i++) {
					if((number-1)==i){
						pList.remove(i);
					}
				}
				Writer fw = new FileWriter("C:\\Javastudy\\수업자료\\02.Java_Programming\\미니프로젝트\\PhoneDB.txt");
				BufferedWriter bw = new BufferedWriter(fw);
				
				for(int i=0;i<pList.size(); i++) {
					bw.write(pList.get(i).getName()+","+pList.get(i).getHp()+","+pList.get(i).getCompany());
					bw.newLine();
				}
				System.out.println("삭제되었습니다.");
				System.out.println("");
				
				bw.close();
				fw.close();

			}else if(num==4) {	
				System.out.println("<4.검색>");
				System.out.println(">>이름: ");
				String str = sc.next();
				
				for(int i=0;i<pList.size(); i++) {
					if(pList.get(i).getName().indexOf(str) != -1) {
					System.out.println((i+1)+".\t"+pList.get(i).getName()+"\t"+pList.get(i).getHp()+"\t"+pList.get(i).getCompany());
					}
				}
				fr.close();
			}else {
				System.out.println("[다시 입력해 주세요.]");
				System.out.println("");
		
			}
		}		

		sc.close();
	}
	
}
