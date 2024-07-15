package org.one;

import java.util.ArrayList;
import java.util.List;

class Member {
    /* Data about a gym member.*/
    public int memberId;
    public String name;
    public MembershipStatus membershipStatus;
    public List<Workout> workouts;

    public Member(int memberId, String name, MembershipStatus membershipStatus, List<Workout> workouts) {
        this.memberId = memberId;
        this.name = name;
        this.membershipStatus = membershipStatus;
        this.workouts = workouts;
    }

    public Member(int memberId, String name, MembershipStatus membershipStatus) {
        this.memberId = memberId;
        this.name = name;
        this.membershipStatus = membershipStatus;
        this.workouts = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Member ID: " + memberId + ", Name: " + name + ", Membership Status: " + membershipStatus;
    }
}
