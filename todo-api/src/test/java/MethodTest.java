/**
 * @author pi
 * @since 2021/11/19 10:54 PM
 **/
public class MethodTest {
    public static void main(String[] args) {

        System.out.println(a());
    }

    private static String a(){
        String result = "aaa";

        b();
        result = "ccc";

        return result;
    }

    private static String b(){

            return "bbb";
    }

}
