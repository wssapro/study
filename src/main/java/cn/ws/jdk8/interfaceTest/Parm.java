package cn.ws.jdk8.interfaceTest;

/**
 * @author shun
 * @date 2021-06-10 17:05
 */
public class Parm implements Base{

	private String name;

	private Base base;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Base getBase() {
		return base;
	}

	public void setBase(Base base) {
		this.base = base;
	}

	@Override
	public String toString() {
		return "Parm{" +
				"name='" + name + '\'' +
				", base=" + base +
				'}';
	}
}
