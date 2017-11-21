package cn.itlaobing.lang3test;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by Administrator on 2017/11/21 0021.
 */
public class StringUtilsTest {

    @Test
    public void test(){
        String str="aaa_abc";
        System.out.println(StringUtils.capitalize(str));

        StringUtils.isBlank(str);
        StringUtils.isNotBlank(str);
        StringUtils.isEmpty(str);
        StringUtils.isNotEmpty(str);


        int[] array={2432,324345,32432,13213,123123,243};

        Objects.requireNonNull(array);
        System.out.println(ArrayUtils.contains(array,2403));

        List<String> list1= Arrays.asList("aa","bb","cc","dd");
        List<String> list2= Arrays.asList("cc","dd","ee");

        System.out.println(CollectionUtils.subtract(list1,list2));

        System.out.println(CollectionUtils.intersection(list1,list2));



    }


}
