package cn.ws.jdk8.interfaceTest;

/**
 * @author shun
 * @date 2021-06-10 17:05
 */
public class AParm  implements Base{

	private Integer a;

	public Integer getA() {
		return a;
	}

	public void setA(Integer a) {
		this.a = a;
	}

	@Override
	public String toString() {
		return "AParm{" +
				"a=" + a +
				'}';
	}
}
