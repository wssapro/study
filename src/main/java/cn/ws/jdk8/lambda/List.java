package cn.ws.jdk8.lambda;

import java.util.Date;
import java.util.Map;
import java.util.Vector;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @description:
 * @Author wangshun
 * @create: 2019-12-09 19:19
 */
public class List {
    public static void main(String[] args) {
        Vector<String> list = new Vector<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        for (int i = 0; i < 1000; i++) {
            list.add("sdfsfgjhesf");
        }
        System.out.println(new Date().getTime());
        StringBuffer s = new StringBuffer("and id in (");
        list.forEach(str->s.append(str+","));
        s.append(")");
        System.out.println(new Date().getTime());



        Map<String, Object> map = list.stream().collect(Collectors.toMap(String::toString, countryImsi -> countryImsi));
        Map<String, String> collect = list.stream().collect(Collectors.toMap(String::toString, Function.identity()));
        System.out.println("1");
        //
        //List<String> resultList = codeSucList.
        //        stream().flatMap(x ->
        //        TotalReqList.stream().filter(y -> {
        //                    //此处是两个list相同的属性值
        //                    int codeSucTime = SmtkDateUtils.DateToInt(x.getCreateTime());
        //                    int totalTime = SmtkDateUtils.DateToInt(y.getCreateTime());
        //                    return codeSucTime == totalTime
        //                            && x.getAdvertiseId().equals(y.getAdvertiseId())
        //                            && x.getProductId().equals(y.getProductId()) ? true : false;
        //                }
        //        ).map(z -> SmtkCodeDetail.
        //                builder()
        //                .advertiseId(z.getAdvertiseId())
        //                .productId(z.getProductId())
        //                .codeTaskId(x.getCodeTaskId())
        //                .reqCount(z.getReqCount())
        //                .advertiseReq(z.getAdvertiseReq())
        //                .rpsPhoneSuccess(x.getRpsPhoneSuccess())
        //                .sendCode(x.getSendCode())
        //                .sendCodeSuccess(x.getSendCodeSuccess())
        //                .createTime(z.getCreateTime()).build()))
        //        .collect(Collectors.toList());
    }
}
