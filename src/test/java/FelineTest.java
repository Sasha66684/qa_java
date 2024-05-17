import com.example.Animal;
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
public class FelineTest {
    @Spy
    private Feline feline;
    @Mock
    private Animal animal;
    @Test
    //проверка что Feline семейства Кошачьих
    public void getFamilyTest() {
        String actual = feline.getFamily();
        assertEquals("Кошачьи", actual);
    }
    @Test
    // возвращает 1 котенка
    public void getReturnOneKittenTest() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }
    @Test
    //тест с определенным кол-вом котят
    public void getKittensWithParametersTest() {
        int actual = feline.getKittens(5);
        assertEquals(5, actual);
    }

    @Test
    //метод выводит нужный список еды
    public void eatMeatTest() throws Exception {
        List<String> actual = feline.eatMeat();
        Mockito.when(animal.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(animal.getFood("Хищник"), actual);
    }
}

