package JUnit;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import MorseCodeConverter.MorseCodeConverter;

public class MorseCodeConverterTest {

    @Test
    public void testConvertToMorse() {
        assertEquals("*** **** *- **** *** * * -*", MorseCodeConverter.convertToMorse("Shahreen"));
    }

    @Test
    public void testConvertToEnglish() {
        assertEquals("JAHAN", MorseCodeConverter.convertToEnglish("*--- ** **** *- -*"));
    }

    @Test
    public void testConvertToMorseAndBack() {
        String input = "SHAHREEN";
        String morseCode = MorseCodeConverter.convertToMorse(input);
        String convertedBack = MorseCodeConverter.convertToEnglish(morseCode);
        assertEquals(input, convertedBack);
    }
}
