import components.set.Set;

public final class AllergenDetectorTest1L {

    public static void main(String[] args) {
        AllergenDetector1L detector = new AllergenDetector1L();

        System.out.println("=== AllergenDetector1L Console Test ===");

        // Test 1: Add allergen and detect
        detector.addAllergen("peanuts");
        boolean containsPeanuts = detector.containsAllergen("milk, peanuts, sugar");
        System.out.println("Test 1 - Contains peanuts: " + containsPeanuts); // expected: true

        // Test 2: Remove allergen
        detector.removeAllergen("peanuts");
        boolean stillContainsPeanuts = detector.containsAllergen("milk, peanuts");
        System.out.println("Test 2 - After removal: " + stillContainsPeanuts); // expected: false

        // Test 3: Case insensitivity
        detector.addAllergen("MILK");
        boolean milkDetected = detector.containsAllergen("milk, eggs");
        System.out.println("Test 3 - Case insensitive add: " + milkDetected); // expected: true

        // Test 4: getDetectedAllergens
        detector.addAllergen("soy");
        Set<String> found = detector.getDetectedAllergens("milk, soy, wheat");
        System.out.println("Test 4 - Detected allergens: " + found); // expected: {milk, soy}

        // Test 5: isSafeToEat
        boolean safe1 = detector.isSafeToEat("flour, sugar");
        boolean safe2 = detector.isSafeToEat("milk, chocolate");
        System.out.println("Test 5 - Safe to eat (no allergens): " + safe1); // expected: true
        System.out.println("Test 5 - Safe to eat (has allergens): " + safe2); // expected: false

        // Test 6: isCrossContaminationRisk
        String facility1 = "Processed in facility with allergens";
        String facility2 = "Gluten-free certified facility";
        System.out.println("Test 6 - Cross contamination 1: " + detector.isCrossContaminationRisk(facility1)); // true
        System.out.println("Test 6 - Cross contamination 2: " + detector.isCrossContaminationRisk(facility2)); // false

        // Test 7: clear()
        detector.clear();
        System.out.println("Test 7 - After clear: " + detector.containsAllergen("milk")); // expected: false

        // Test 8: transferFrom()
        AllergenDetector1L original = new AllergenDetector1L();
        original.addAllergen("soy");
        AllergenDetector1L target = new AllergenDetector1L();
        target.transferFrom(original);
        System.out.println("Test 8 - Target contains soy: " + target.containsAllergen("soy")); // expected: true
        System.out.println("Test 8 - Original is cleared: " + original.containsAllergen("soy")); // expected: false

        // Test 9: alertUser (visual)
        target.alertUser("soy", "Protein Bar"); // expected: ALERT message


                // Test: addAllergen (normal + duplicate + case insensitivity)
        detector.addAllergen("Peanuts");
        detector.addAllergen("Milk");
        detector.addAllergen("milk"); // Should not add duplicate

        System.out.println("Tracked allergens after add: " +
                detector.getDetectedAllergens("peanuts, milk, soy")); // expected: {peanuts, milk}

        // Test: removeAllergen (normal)
        detector.removeAllergen("peanuts");
        System.out.println("Tracked allergens after remove: " +
                detector.getDetectedAllergens("peanuts, milk")); // expected: {milk}

        // Test: containsAllergen (true/false, spacing, case)
        detector.addAllergen("soy");
        boolean result1 = detector.containsAllergen("milk, SOY, eggs"); // true
        boolean result2 = detector.containsAllergen("flour, sugar");    // false
        System.out.println("Test containsAllergen (match): " + result1); // expected: true
        System.out.println("Test containsAllergen (no match): " + result2); // expected: false

        // Test: getDetectedAllergens (empty list, partial match)
        Set<String> detected = detector.getDetectedAllergens("milk, peanuts, soy");
        System.out.println("Test getDetectedAllergens: " + detected); // expected: {milk, soy}
        Set<String> emptyResult = detector.getDetectedAllergens("rice, beans");
        System.out.println("Test getDetectedAllergens (none): " + emptyResult); // expected: {}

        // === Secondary Method Tests ===

        // Test: isSafeToEat
        System.out.println("Test isSafeToEat (safe): " + detector.isSafeToEat("lettuce, tomato")); // true
        System.out.println("Test isSafeToEat (unsafe): " + detector.isSafeToEat("soy, flour")); // false

        // Test: isCrossContaminationRisk
        String facility3 = "Processed in facility with allergens";
        String facility4 = "Made in nut-free factory";
        System.out.println("Test isCrossContaminationRisk (risk): " + detector.isCrossContaminationRisk(facility3)); // true
        System.out.println("Test isCrossContaminationRisk (no risk): " + detector.isCrossContaminationRisk(facility4)); // false

        // Test: alertUser
        System.out.print("Test alertUser (visual): ");
        detector.alertUser("milk", "Granola Bar"); // prints to console

        // Test: enterIngredientString (match and no match)
        System.out.println("Test enterIngredientString (with allergen):");
        detector.enterIngredientString("milk, water");

        System.out.println("Test enterIngredientString (no allergen):");
        detector.enterIngredientString("salt, vinegar");

        // Test: clear
        detector.clear();
        boolean emptyAfterClear = detector.containsAllergen("milk");
        System.out.println("Test clear(): " + emptyAfterClear); // expected: false

        // Test: transferFrom
        AllergenDetector1L source = new AllergenDetector1L();
        source.addAllergen("gluten");
        AllergenDetector1L targetTransfer = new AllergenDetector1L();
        targetTransfer.transferFrom(source);

        System.out.println("Test transferFrom - target should have 'gluten': " +
                targetTransfer.containsAllergen("gluten")); // true
        System.out.println("Test transferFrom - source should be empty: " +
                source.containsAllergen("gluten")); // false

        // Test: equals + hashCode
        AllergenDetector1L det1 = new AllergenDetector1L();
        AllergenDetector1L det2 = new AllergenDetector1L();
        det1.addAllergen("milk");
        det2.addAllergen("milk");

        System.out.println("Test equals (should be true): " + det1.equals(det2)); // true
        System.out.println("Test hashCode equality: " + (det1.hashCode() == det2.hashCode())); // true

        det2.addAllergen("soy");
        System.out.println("Test equals (should be false): " + det1.equals(det2)); // false

        // Test: toString (basic override call)
        System.out.println("Test toString(): " + detector.toString()); // Just returns fixed string
    }
}
