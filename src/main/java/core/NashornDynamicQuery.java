package core;

import javax.script.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class NashornDynamicQuery {
    public static void main(String[] args) throws ScriptException, NoSuchMethodException {

        final ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        final String selector = "pojo.a == \"abc\" && pojo.b == 1";
        ((Compilable)engine).compile(String.format(Locale.ENGLISH,
                "var filter = function(pojo) {\n" +
                "    return %s;" +
                "};", selector));

        Invocable invocable = (Invocable) engine;

        new ArrayList<>(Arrays.asList(
            new Pojo("abc", 2),
            new Pojo("abc2", 2),
            new Pojo("abc", 1))).

                stream().
                filter(pojo -> {
                    try {
                        return Boolean.class.cast(invocable.invokeFunction("filter", pojo));
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }
                }).
                forEach(System.out::println);
    }

}
