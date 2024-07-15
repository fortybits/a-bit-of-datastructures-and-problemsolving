package org.one;

class MembershipStatistics {
    /*
        Class for returning the getMembershipStatistics result
    */
    public int total_members;
    public int total_paid_members;
    public double conversion_rate;

    public MembershipStatistics(int total_members, int total_paid_members, double conversion_rate) {
        this.total_members = total_members;
        this.total_paid_members = total_paid_members;
        this.conversion_rate = conversion_rate;
    }
}
