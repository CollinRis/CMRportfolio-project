import components.set.Set;
import components.set.Set1L;

public class AllergenDetector1L extends AllergenDetectorSecondary {

    private Set<String> trackedAllergens;

    public AllergenDetector1L() {
        this.trackedAllergens = new Set1L<>();
    }

    @Override
    public void addAllergen(String allergen) {
        assert allergen != null && !allergen.isEmpty();
        String lowered = allergen.toLowerCase();
        if (!this.trackedAllergens.contains(lowered)) {
            this.trackedAllergens.add(lowered);
        }
    }

    @Override
    public void removeAllergen(String allergen) {
        assert allergen != null && this.trackedAllergens.contains(allergen.toLowerCase());
        this.trackedAllergens.remove(allergen.toLowerCase());
    }

    @Override
    public boolean containsAllergen(String ingredientList) {
        assert ingredientList != null;
        for (String ingredient : ingredientList.toLowerCase().split(",")) {
            if (this.trackedAllergens.contains(ingredient.trim())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Set<String> getDetectedAllergens(String ingredientList) {
        assert ingredientList != null;
        Set<String> detected = new Set1L<>();
        for (String ingredient : ingredientList.toLowerCase().split(",")) {
            String clean = ingredient.trim();
            if (this.trackedAllergens.contains(clean)) {
                detected.add(clean);
            }
        }
        return detected;
    }

    @Override
    public AllergenDetector1L newInstance() {
        return new AllergenDetector1L();
    }

    @Override
    public void clear() {
        this.trackedAllergens.clear();
    }

    @Override
    public void transferFrom(AllergenDetectorKernel source) {
        assert source instanceof AllergenDetector1L;
        AllergenDetector1L local = (AllergenDetector1L) source;
        this.trackedAllergens = local.trackedAllergens;
        local.trackedAllergens = new Set1L<>();
    }
}
