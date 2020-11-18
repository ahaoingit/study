package Enity;
public class Teacher {
	String tid;
	String name;
	public Teacher (String tid, String name ) {
		this.tid=tid;
		this.name=name;
	
	}
	public String gettid(){
     return this.tid;
	}
	public void settid(String tid) {
	this.tid=tid;
	}
	public String getname(){
     return this.name;
	}
	public void setname(String name) {
	this.name=name;
	}
}