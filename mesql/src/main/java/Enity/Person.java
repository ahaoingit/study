package Enity;
public class Person {
	String uname;
	String age;
	public Person (String uname, String age ) {
		this.uname=uname;
		this.age=age;
	
	}
	public String getuname(){
     return this.uname;
	}
	public void setuname(String uname) {
	this.uname=uname;
	}
	public String getage(){
     return this.age;
	}
	public void setage(String age) {
	this.age=age;
	}
}