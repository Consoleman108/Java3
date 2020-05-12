package homework6;
import org.hamcrest.Matcher;
import org.hamcrest.core.Is;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class MainClassTest {
    private static MainClass mainClass = null;
    private int[] inputArray;
    private int[] outputArray;
    private Class<? extends Exception>  exception;
    private boolean outputCheck;

    @Parameters
    public static Collection<Object[]> testCollection() {
        return Arrays.asList(new Object[][]{
                {new int[] {1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[] {1,7}, null, true},
                {new int[] {1, 2, 7, 6, 2, 3, 5, 1, 4}, new int[] {}, null, true},
                {new int[] {1, 2, 7, 6, 2, 3, 5, 1, 7}, null, RuntimeException.class, true},
                {new int[] {3, 2, 7, 6, 2, 3, 5, 8, 7}, null, RuntimeException.class, false},
        });
    }

    public MainClassTest(int[] inputArray, int[] outputArray, Class<? extends Exception> exception, boolean outputCheck) {
        this.inputArray = inputArray;
        this.outputArray = outputArray;
        this.exception = exception;
        this.outputCheck = outputCheck;
    }


    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test_subArray() throws RuntimeException {
        if (exception != null) {
            thrown.expect(exception);
        }
                Assert.assertArrayEquals(outputArray, mainClass.subArray(inputArray)); //(outputArray, Is.is(mainClass.subArray(inputArray)));
    }

    @Test
    public void test_checkArray(){
        Assert.assertThat(mainClass.checkArray(inputArray), Is.is(outputCheck));
    }

    @Before
    public void init() {
        mainClass = new MainClass();
    }

    @After
    public void tearDown() {
        mainClass = null;
    }
}
