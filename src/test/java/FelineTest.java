import com.example.Animal;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class FelineTest {

    Feline feline;

    @Before
    public void init() {
        feline = new Feline();
    }

    @Test
    //метод выводит нужный список еды
    public void eatMeatTest() throws Exception {
        List<String> foodFofFeline = List.of("Животные", "Птицы", "Рыба");
        assertEquals(foodFofFeline, feline.eatMeat());
    }

    @Test
    //проверка что Feline семейства Кошачьих
    public void getFamilyTest() {
        String family = "Кошачьи";
        assertEquals(family, feline.getFamily());
    }

    @Test
    // возвращает 1 котенка
    public void getReturnOneKittenTest() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    //тест с определенным кол-вом котят
    public void getKittensWithParametersTest() {
        assertEquals(5, feline.getKittens(5));
    }

}

