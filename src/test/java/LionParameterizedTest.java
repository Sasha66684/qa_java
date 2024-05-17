import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {
    private final String sex;
    private final boolean hasMane;
    public LionParameterizedTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }
    @Parameterized.Parameters(name = "Пол: {0}, признак hasMane: {1}")
    public static Object[][] data() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}};
    }
    @Test
    //тест наличия,отсутствия гривы
    public void doesHaveManePositiveTest() throws Exception {
        Lion lion = new Lion(sex, new Feline());
        boolean actual = lion.doesHaveMane();
        assertEquals(hasMane, actual);
    }
}