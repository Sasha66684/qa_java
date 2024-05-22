import com.example.Animal;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class AnimalTest {
    private final Animal animal = new Animal();
    //тест на определение семейст животного
    @Test
    public void getFamilyTest() {
        String actual = animal.getFamily();
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи",
                actual);
    }
    // тест на неизвестный вид живодного
    @Test
    //метод ожидает появление исключения с помощью assertThrows
    public void expectedExceptionTest() {
        Animal animal = new Animal();
        Exception exception = assertThrows(Exception.class, () -> animal.getFood("Абра-кадабра"));
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
        }

    }


