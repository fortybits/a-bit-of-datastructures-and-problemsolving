package org.one;

import java.util.*;

/*
We are building a program to manage a gym's membership. The gym has multiple members, each with a unique ID, name, and membership status. The program allows gym staff to add new members, update members status, and get membership statistics.

Definitions:
* A "member" is an object that represents a gym member. It has properties for the ID, name, and membership status.
* A "membership" is a class which is used for managing members in the gym.

To begin with, we present you with two tasks:
1-1) Read through and understand the code below. Please take as much time as necessary, and feel free to run the code.
1-2) The test for Membership is not passing due to a bug in the code. Make the necessary changes to Membership to fix the bug.
*/

/*
We are currently updating our system to include information about workouts for our members. As part of this update, we have introduced the Workout class, which represents a single workout session for a member. Each object of the Workout class has a unique ID, as well as a start time and end time that are represented in the number of minutes spent from the start of the day. You can assume that all the Workouts are from the same day.

List<Workout> workouts;

To implement these changes, we need to add two functions to the Membership class:

2.1) The `addWorkout` function should be used to add a workout session for a member. If the given member does not exist while calling this function, the workout can be ignored.

2.2) The `getAverageWorkoutDurations` function should calculate the average duration of workouts for each member in minutes and return the results as a map.

To assist you in testing these new functions, we have provided the testGetAverageWorkoutDurations function.
*/

/*
We are developing a payment calculation system for our members. The payment amount is determined as follows:

- For members with BASIC Membership:
  - The first workout is free.
  - From the second workout onwards, each hour costs $10.

- For members with PRO Membership:
  - The first three workouts are free.
  - From the fourth workout onwards, each hour costs $8.

- For members with ELITE Membership:
  - The first five workouts are free.
  - From the sixth workout onwards, each hour costs $6.

The duration of each workout is always rounded up to the nearest hour. For example, if a person spent 80 minutes in a workout, they would be charged for 2 hours.

3) Implement a `getDuePayments` function, which returns a dictionary associating each member ID with their due payment.

To help you understand the requirements and test this new function, we have provided the `testGetDuePayments` function.
*/


class MembershipService {
    /*
        Data for managing a gym membership, and methods which staff can
        use to perform any queries or updates.
    */
    public List<Member> members;

    public MembershipService() {
        members = new ArrayList<>();
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void updateMembership(int memberId, MembershipStatus membershipStatus) {
        for (Member member : members) {
            if (member.memberId == memberId) {
                member.membershipStatus = membershipStatus;
                break;
            }
        }
    }

    public MembershipStatistics getMembershipStatistics() {
        int totalMembers = members.size();
        int totalPaidMembers = 0;
        for (Member member : members) {
            if (member.membershipStatus == MembershipStatus.PRO || member.membershipStatus == MembershipStatus.ELITE) { // ELITE was not handled
                totalPaidMembers++;
            }
        }
        double conversionRate = (totalPaidMembers / (double) totalMembers) * 100.0;
        return new MembershipStatistics(totalMembers, totalPaidMembers, conversionRate);
    }

    void addWorkout(int memberId, Workout workout) {
        for (Member member : members) {
            if (member.memberId == memberId) {
                member.workouts.add(workout);
                break;
            }
        }
    }

    Map<Integer, Integer> getAverageWorkoutDurations() {
        Map<Integer, Integer> membersToWorkoutAvg = new HashMap<>();
        for (Member member : members) {
            List<Workout> memberWorkouts = member.workouts;
            Integer averageWorkDuration = averageDuration(memberWorkouts);
            membersToWorkoutAvg.put(member.memberId, averageWorkDuration);
        }
        return membersToWorkoutAvg;
    }

    private Integer averageDuration(List<Workout> memberWorkouts) {
        if (memberWorkouts.isEmpty()) return 0;
        int workoutCount = memberWorkouts.size();
        int totalWorkout = 0;
        for (Workout workout : memberWorkouts) {
            totalWorkout += (workout.endTime - workout.startTime);
        }
        return totalWorkout / workoutCount;
    }

    /*
    - For members with BASIC Membership:
  - The first workout is free.
  - From the second workout onwards, each hour costs $10.

- For members with PRO Membership:
  - The first three workouts are free.
  - From the fourth workout onwards, each hour costs $8.

- For members with ELITE Membership:
  - The first five workouts are free.
  - From the sixth workout onwards, each hour costs $6.
    */
    Map<Integer, Integer> getDuePayments() {
        Map<Integer, Integer> membersToWorkoutAvg = new HashMap<>();
        for (Member member : members) {
            List<Workout> memberWorkouts = member.workouts;
            Integer averageWorkDuration = duePayment(member.membershipStatus, memberWorkouts);
            membersToWorkoutAvg.put(member.memberId, averageWorkDuration);
        }
        return membersToWorkoutAvg;
    }

    private Integer duePayment(MembershipStatus membershipStatus, List<Workout> memberWorkouts) {
        int freeWorkouts = freeWorkoutsForMembership(membershipStatus);
        List<Workout> chargeableWorkouts = memberWorkouts.stream().sorted(Comparator.comparingInt(o -> o.startTime)).skip(freeWorkouts).toList();

        if (chargeableWorkouts.isEmpty()) return 0;

        int memberShipCharge = chargeForMembership(membershipStatus);

        int payment = 0;
        for (Workout workout : chargeableWorkouts) {
            int duration = workout.endTime - workout.startTime;
            payment += (int) (Math.ceil(duration / 60.0) * memberShipCharge);

        }
        return payment;
    }

    private int chargeForMembership(MembershipStatus membershipStatus) {
        return switch (membershipStatus) {
            case BASIC -> 10;
            case PRO -> 8;
            case ELITE -> 6;
        };
    }

    private int freeWorkoutsForMembership(MembershipStatus membershipStatus) {
        return switch (membershipStatus) {
            case BASIC -> 1;
            case PRO -> 3;
            case ELITE -> 5;
        };
    }
}