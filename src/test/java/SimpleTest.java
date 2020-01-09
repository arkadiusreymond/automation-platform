import org.testng.annotations.Test;
public class SimpleTest extends TestInstrument {

    @Test()
    public void simpleTest() throws InterruptedException {
        System.out.println("Success launch app");
        Thread.sleep(10000);
    }
}
