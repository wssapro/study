package cn.ws.jdk8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author shun
 * @date 2021-01-26 14:28
 */
public class FlatMap {

	public static void main(String[] args) {
		List<User> uList = new ArrayList<>();
		User u1 = new User();
		u1.setAddr("a1;a2;a3;a4;a5");

		User u2 = new User();
		u2.setAddr("b1;b2;b3;b4;b5");

		uList.add(u1);
		uList.add(u2);

		List<String> addrList = uList.stream().map(x -> x.getAddr()).flatMap(x -> Arrays.stream(x.split(";"))).collect(Collectors.toList());
		//或者
		List<String> ridStrList = uList.stream().map(x -> x.getAddr()).map(x -> x.split(";")).flatMap(Arrays::stream).collect(Collectors.toList());

		String[] words = new String[]{"Hello", "World"};
		/*List<String[]> a = Arrays.stream(words)
				.map(word -> word.split(""))
				.distinct()
				.collect(toList());
		a.forEach(System.out::print);*/


		Stream<String[]> stream = Arrays.stream(words).map(word -> word.split(""));
		List<String[]> collect = stream.distinct().collect(Collectors.toList());

		Stream<String[]> stream1 = Arrays.stream(words).map(word -> word.split(""));
		Stream<String> stringStream = stream1.flatMap(Arrays::stream);
		List<String> collect1 = stringStream.distinct().collect(Collectors.toList());
		/*List<String> a1 = Arrays.stream(words)
				.map(word -> word.split(""))
				.flatMap(Arrays::stream)
				.distinct()
				.collect(toList());
		a.forEach(System.out::print);*/
		System.out.println("a");
	}

}

class User {

	private String addr;

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
}

// List<SmtkCodeDetail> resultList = codeSucList.
// stream().flatMap(x ->
// TotalReqList.stream().filter(y -> {
// //此处是两个list相同的属性值
// int codeSucTime = SmtkDateUtils.DateToInt(x.getCreateTime());
// int totalTime = SmtkDateUtils.DateToInt(y.getCreateTime());
// return codeSucTime == totalTime
// &&x.getAdvertiseId().equals(y.getAdvertiseId())
// && x.getProductId().equals(y.getProductId()) ? true : false;
// }
// ).map(z -> SmtkCodeDetail.
// builder()
// .advertiseId(z.getAdvertiseId())
// .productId(z.getProductId())
// .codeTaskId(x.getCodeTaskId())
// .reqCount(z.getReqCount())
// .advertiseReq(z.getAdvertiseReq())
// .rpsPhoneSuccess(x.getRpsPhoneSuccess())
// .sendCode(x.getSendCode())
// .sendCodeSuccess(x.getSendCodeSuccess())
// .createTime(z.getCreateTime()).build()))
// .collect(Collectors.toList());