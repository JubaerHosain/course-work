class PlanFactory {
    public Plan getPlan(String planType, double rate) {
        if (planType == null) {
            return null;
        } else if (planType.equalsIgnoreCase("DOMESTICPLAN")) {
            return new DomesticPlan(rate);
        } else if (planType.equalsIgnoreCase("COMMERCIALPLAN")) {
            return new CommercialPlan(rate);
        } else if (planType.equalsIgnoreCase("INSTITUTIONALPLAN")) {
            return new InstitutionalPlan(rate);
        }
        return null;
    }
}