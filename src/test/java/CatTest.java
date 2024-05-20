import com.example.Animal;
import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    private List<String> expectedFood;
    @Before
    public void setCat() {
        expectedFood = List.of("Мясо", "Птица", "Рыба");

    }
    @Mock
    private Feline feline;
    @Test
    //проверяю, что метод возвращает "Мяу"
    public void getSoundCat() {
        Cat cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound());
    }
    @Test
//Проверяю, что метод возвращает список пищи Cat
    public void getFoodForCat() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);
        Assert.assertEquals (expectedFood,cat.getFood());

    }

}
