import com.example.Animal;
import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
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
    private Lion lion;
    @Mock

    private Feline feline;

    @Before
    public void setLion() throws Exception {
        lion = new Lion("Самец", feline);
    }


    @Test
    public void doesHaveManeTest() {
        assertTrue(lion.doesHaveMane());
    }

        @Test
        //метод ожидает появление исключения с помощью assertThrows
        public void doesHaveManeExceptionTest () {
            Exception exception = assertThrows(Exception.class, () -> new Lion("Абра-кадабра", feline));
            assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());

        }

    @Test
    //вызова метода getKittens() один раз
    public void getKittensMethodTest() {
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }
    @Test
    //тест вызовает метода getFood() один раз, с любым аргументом типа String
    public void getFoodMethodWithAnyArgument() throws Exception {
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood(Mockito.anyString());
    }
}

