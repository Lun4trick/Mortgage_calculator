public class LoanDetails {
    private int principal;
    private float annualInterest;
    private byte years;
    public LoanDetails(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    // Getters and potentially setters for each field
    public int getPrincipal() {
        return principal;
    }

    public float getAnnualInterest() {
        return annualInterest;
    }

    public byte getYears() {
        return years;
    }

}
