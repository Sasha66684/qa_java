import com.example.Animal;
import com.example.Cat;
import com.example.Feline;
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
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood());
    }
    @Test
    public void prepareCatFoodReturnsTwiceTest() throws Exception {
        Cat cat = new Cat(feline);
        cat.getFood();
        cat.getFood();
        Mockito.verify(feline, Mockito.times(2)).eatMeat();
    }
}
