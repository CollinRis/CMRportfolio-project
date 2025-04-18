import components.set.Set;

public interface AllergenDetector extends AllergenDetectorKernel {

    boolean isSafeToEat(String ingredientList);

    boolean isCrossContaminationRisk(String facilityInfo);

    void alertUser(String allergen, String productName);

    void enterIngredientString(String ingredientList);
}
