package FactoryMethodPattern;

class PlanFactory {
    public Plan getPlan(String planType) {
        if (planType == null) {
            return null;
        } else if (planType.equalsIgnoreCase("DOMESTICPLAN")) {
            return new DomesticPlan();
        } else if (planType.equalsIgnoreCase("COMMERCIALPLAN")) {
            return new CommercialPlan();
        } else if (planType.equalsIgnoreCase("INSTITUTIONALPLAN")) {
            return new InstitutionalPlan();
        }
        return null;
    }
}