package cn.ws.jdk8.defaultMethod;

public class Car implements Vehicle, FourWheeler {

	public void print(){
		Vehicle.super.print();
		FourWheeler.super.print();
		Vehicle.blowHorn();
		System.out.println("我是一辆汽车!");
	}
}