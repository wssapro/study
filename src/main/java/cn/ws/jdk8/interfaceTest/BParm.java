package cn.ws.jdk8.interfaceTest;

/**
 * @author shun
 * @date 2021-06-10 17:05
 */
public class BParm implements Base{


	private Integer b;

	public Integer getB() {
		return b;
	}

	public void setB(Integer b) {
		this.b = b;
	}

	@Override
	public String toString() {
		return "BParm{" +
				"b=" + b +
				'}';
	}
}
