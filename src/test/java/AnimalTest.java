import com.example.Animal;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
    public void unknownSpeciesTest() {
        try {
            animal.getFood("Абра-кадабра");
        } catch (Exception exception) {
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
        }

    }
}

