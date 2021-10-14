package cn.ws.jdk8.interfaceTest;

/**
 * @author shun
 * @date 2021-06-10 17:05
 */
public class Service {


	public AParm getA(){
		AParm aParm = new AParm();
		aParm.setA(111);
		return aParm;
	}


	public BParm getB(){

		BParm bParm = new BParm();
		bParm.setB(222);
		return bParm;
	}
}
