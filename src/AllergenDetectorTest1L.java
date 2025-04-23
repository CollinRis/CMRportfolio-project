import static org.junit.Assert.*;

import org.junit.Test;
import components.set.Set;
import components.set.Set1L;

public class AllergenDetectorTest1L {

        private AllergenDetector1L createDetector() {
                return new AllergenDetector1L();
        }

    @Test
    public void testAddAndContainsAllergen() {
        AllergenDetector1L detector = this.createDetector();
        detector.addAllergen("peanuts");
        assertTrue(detector.containsAllergen("milk, peanuts, sugar"));
    }

    @Test
    public void testRemoveAllergen() {
        AllergenDetector1L detector = this.createDetector();
        detector.addAllergen("peanuts");
        detector.removeAllergen("peanuts");
        assertFalse(detector.containsAllergen("milk, peanuts"));
    }

    @Test
    public void testCaseInsensitiveAdd() {
        AllergenDetector1L detector = this.createDetector();
        detector.addAllergen("MILK");
        assertTrue(detector.containsAllergen("milk, eggs"));
    }

    @Test
    public void testGetDetectedAllergens() {
        AllergenDetector1L detector = this.createDetector();
        detector.addAllergen("milk");
        detector.addAllergen("soy");
        Set<String> expected = new Set1L<>();
        expected.add("milk");
        expected.add("soy");
        Set<String> actual = detector.getDetectedAllergens("milk, soy, wheat");
        assertEquals(expected, actual);
    }

    @Test
    public void testIsSafeToEat() {
        AllergenDetector1L detector = this.createDetector();
        detector.addAllergen("milk");
        assertTrue(detector.isSafeToEat("flour, sugar"));
        assertFalse(detector.isSafeToEat("milk, chocolate"));
    }

    @Test
    public void testIsCrossContaminationRisk() {
        AllergenDetector1L detector = this.createDetector();
        assertTrue(detector.isCrossContaminationRisk("Processed in facility with allergens"));
        assertFalse(detector.isCrossContaminationRisk("Gluten-free certified facility"));
    }

    @Test
    public void testClear() {
        AllergenDetector1L detector = this.createDetector();
        detector.addAllergen("milk");
        detector.clear();
        assertFalse(detector.containsAllergen("milk"));
    }

    @Test
    public void testTransferFrom() {
        AllergenDetector1L source = new AllergenDetector1L();
        source.addAllergen("soy");
        AllergenDetector1L target = new AllergenDetector1L();
        target.transferFrom(source);

        assertTrue(target.containsAllergen("soy"));
        assertFalse(source.containsAllergen("soy"));
    }

    @Test
    public void testAddDuplicateAllergens() {
        AllergenDetector1L detector = this.createDetector();
        detector.addAllergen("milk");
        detector.addAllergen("Milk");
        Set<String> result = detector.getDetectedAllergens("milk, soy");
        Set<String> expected = new Set1L<>();
        expected.add("milk");
        assertEquals(expected, result);
    }

    @Test
    public void testContainsAllergenSpacing() {
        AllergenDetector1L detector = this.createDetector();
        detector.addAllergen("soy");
        assertTrue(detector.containsAllergen("milk, SOY, eggs"));
        assertFalse(detector.containsAllergen("flour, sugar"));
    }

    @Test
    public void testEmptyDetectedAllergens() {
        AllergenDetector1L detector = this.createDetector();
        detector.addAllergen("milk");
        Set<String> result = detector.getDetectedAllergens("rice, beans");
        Set<String> expected = new Set1L<>();
        assertEquals(expected, result);
    }


    @Test
    public void testToString() {
        AllergenDetector1L detector = this.createDetector();
        assertEquals("AllergenDetector component", detector.toString());
    }

    @Test
    public void testEnterIngredientStringVisual() {
        AllergenDetector1L detector = this.createDetector();
        detector.addAllergen("milk");
        // This test is visual; nothing to assert
        detector.enterIngredientString("milk, water");
        detector.enterIngredientString("salt, vinegar");
    }

    @Test
    public void testAlertUserVisual() {
        AllergenDetector1L detector = this.createDetector();
        // This test is visual; nothing to assert
        detector.alertUser("soy", "Protein Bar");
    }
}
