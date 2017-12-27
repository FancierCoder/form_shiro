import com.forumShiro.shiro.ShiroUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;

public class Test2 {
    @Test
    public void test2() {
        String random = RandomStringUtils.randomAlphanumeric(25);
        String s = ShiroUtils.sha256("admin", random);
        System.out.println(random+","+s);
    }
}
