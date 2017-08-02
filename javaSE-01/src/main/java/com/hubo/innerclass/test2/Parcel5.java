package com.hubo.innerclass.test2;

/**
 * 局部内部类
 * @author hubo
 *
 */
public class Parcel5 {
	public Destionation destionation(String str){
		class PDestionation implements Destionation{
			private String label;
			private PDestionation(String whereTo){
				label=whereTo;
			}
			public String readLabel() {
				// TODO Auto-generated method stub
				return label;
			}
			
		}
		
		return new PDestionation(str);
	}
	
	public static void main(String[] args) {
		Parcel5 parcel5=new Parcel5();
		Destionation d=parcel5.destionation("tom");
		System.out.println(d);
		System.out.println(d.readLabel());
	}
}
