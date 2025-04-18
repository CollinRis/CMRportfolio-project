import components.set.Set;

public abstract class AllergenDetectorSecondary implements AllergenDetector {

    @Override
    public boolean isSafeToEat(String ingredientList) {
        return !this.containsAllergen(ingredientList);
    }

    @Override
    public boolean isCrossContaminationRisk(String facilityInfo) {
        return facilityInfo.toLowerCase()
                .contains("processed in facility with allergens");
    }

    @Override
    public void alertUser(String allergen, String productName) {
        System.out.println("ALERT: " + productName + " contains " + allergen
                + "! Avoid consumption.");
    }

    @Override
    public void enterIngredientString(String ingredientList) {
        Set<String> detected = this.getDetectedAllergens(ingredientList);
        if (detected.size() > 0) {
            System.out.println("WARNING: Allergens detected!");
            System.out.println("Detected allergens: " + detected);
        } else {
            System.out.println("Safe to eat.");
        }
    }

    @Override
    public String toString() {
        return "AllergenDetector component";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AllergenDetector) {
            AllergenDetector other = (AllergenDetector) obj;
            return this.getDetectedAllergens("")
                    .equals(other.getDetectedAllergens(""));
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.getDetectedAllergens("").hashCode();
    }
}
