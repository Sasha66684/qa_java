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
    @Spy
    private Feline feline;

    @Mock
    private Animal animal;
    @Test
    //проверяю, что метод возвращает "Мяу"
    public void getSoundCat() {
        Cat cat = new Cat(feline);
        String actual = cat.getSound();
        assertEquals("Мяу", actual);
    }
    @Test
///Проверяю, что метод возвращает список пищи кошки и то что он "Хищник"
    public void getFoodForCat() throws Exception {
        Cat cat = new Cat(feline);
        List<String> actual = cat.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
        Mockito.when(animal.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(animal.getFood("Хищник"), actual);
    }
}
