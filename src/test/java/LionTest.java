import com.example.Animal;
import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    private Feline feline;

    @Test
    //тест ловит недействительный пол
    public void doesHaveManeInvalidAnimal() {
        try {
            Feline feline = new Feline();
            Lion lion = new Lion("Абра-кадабра", feline);
            assertTrue(lion.doesHaveMane());
        } catch (Exception exception) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
        }
    }
        @Test
        //метод ожидает появление исключения с помощью assertThrows
        public void doesHaveManeExceptionTest () {
            Feline feline = new Feline();
            Exception exception = assertThrows(Exception.class, () -> new Lion("Абра-кадабра", feline));
            assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());

        }

    @Test
    //вызова метода getKittens() один раз
    public void getKittensMethodTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }
    @Test
    //тест вызовает метода getFood() один раз, с любым аргументом типа String
    public void getFoodMethodWithAnyArgument() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood(Mockito.anyString());
    }
}

