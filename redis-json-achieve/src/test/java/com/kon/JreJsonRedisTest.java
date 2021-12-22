package com.kon;

import com.redislabs.modules.rejson.JReJSON;
import com.redislabs.modules.rejson.Path;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * note
 *
 * @author kon, created on 2021/12/21T15:34.
 * @version 1.0.0-SNAPSHOT
 */
@SpringBootTest
public class JreJsonRedisTest {

    @Autowired
    private JReJSON jReJson;

    @Test
    @Disabled
    public void test0() {
        jReJson.set("foo", "kon");
        Assertions.assertEquals("kon", jReJson.get("foo"));
        Assertions.assertEquals("kon", jReJson.get("foo", String.class, new Path(".")));
        Assertions.assertEquals("kon", jReJson.get("foo", String.class, Path.ROOT_PATH));
    }

    @Test
    public void test1() {
        jReJson.set("object", new Demo("kon", 13));
        jReJson.set("object", null, new Path(".zilch"));

        Path p = new Path(".whatevs");
        jReJson.set("object", true, p);
        jReJson.set("object", 43, new Path(".ens"));
        jReJson.set("object", new Demo("KKK", 18), new Path(".val"));

        Object o = jReJson.get("object");
        // {name=kon, age=13.0, zilch=null, whatevs=true, ens=43.0, val={name=KKK, age=18.0}}
        System.out.println(o);

//        jReJson.del("object");
    }

    @Data
    @AllArgsConstructor
    static class Demo {
        String name;

        Integer age;
    }

}
