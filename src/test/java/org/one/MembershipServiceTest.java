package org.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MembershipServiceTest {

    @Test
    void testMember() {
        System.out.println("Running testMember");
        Member testMember = new Member(1, "John Doe", MembershipStatus.BASIC);
        Assertions.assertEquals(1, testMember.memberId);
        Assertions.assertEquals("John Doe", testMember.name);
        Assertions.assertEquals(MembershipStatus.BASIC, testMember.membershipStatus);
    }

    @Test
    void testMembership() {
        System.out.println("Running testMembership");
        Member testMember = new Member(1, "John Doe", MembershipStatus.BASIC);
        MembershipService testMembershipService = new MembershipService();
        testMembershipService.addMember(testMember);
        Assertions.assertEquals(1, testMembershipService.members.size());
        Assertions.assertEquals(testMember, testMembershipService.members.getFirst());

        testMembershipService.updateMembership(1, MembershipStatus.PRO);
        Assertions.assertEquals(MembershipStatus.PRO, testMembershipService.members.getFirst().membershipStatus);

        Member testMember2 = new Member(2, "Alex C", MembershipStatus.BASIC);
        testMembershipService.addMember(testMember2);

        Member testMember3 = new Member(3, "Marie C", MembershipStatus.ELITE);
        testMembershipService.addMember(testMember3);

        MembershipStatistics attendanceStats = testMembershipService.getMembershipStatistics();
        Assertions.assertEquals(3, attendanceStats.total_members);
        Assertions.assertEquals(2, attendanceStats.total_paid_members);
        Assertions.assertTrue(Math.abs(attendanceStats.conversion_rate - 66.66) < 0.1);
    }

    @Test
    void testGetAverageWorkoutDurations() {
        System.out.println("Running testGetAverageWorkoutDurations");
        Member testMember1 = new Member(1, "John Doe", MembershipStatus.PRO);
        MembershipService testMembershipService = new MembershipService();
        testMembershipService.addMember(testMember1);

        Member testMember2 = new Member(2, "Alex C", MembershipStatus.BASIC);
        testMembershipService.addMember(testMember2);

        Member testMember3 = new Member(3, "Marie C", MembershipStatus.ELITE);
        testMembershipService.addMember(testMember3);

        Workout testWorkout1 = new Workout(1, 10, 20); // 10
        Workout testWorkout2 = new Workout(2, 15, 35); // 20
        Workout testWorkout3 = new Workout(3, 50, 90); // 40
        Workout testWorkout4 = new Workout(4, 100, 155); // 55
        Workout testWorkout5 = new Workout(5, 120, 200); // 80
        Workout testWorkout6 = new Workout(6, 300, 400); // 100
        Workout testWorkout7 = new Workout(7, 2000, 2010);// 10

        testMembershipService.addWorkout(1, testWorkout1);
        testMembershipService.addWorkout(2, testWorkout2);
        testMembershipService.addWorkout(3, testWorkout3);
        testMembershipService.addWorkout(1, testWorkout4);
        testMembershipService.addWorkout(2, testWorkout5);
        testMembershipService.addWorkout(3, testWorkout6);
        testMembershipService.addWorkout(1, testWorkout7);

        Map<Integer, Integer> averageDurations = testMembershipService.getAverageWorkoutDurations();
        Assertions.assertTrue(Math.abs(averageDurations.get(1) - 25.0) < 0.1);
        Assertions.assertTrue(Math.abs(averageDurations.get(2) - 50.0) < 0.1);
        Assertions.assertTrue(Math.abs(averageDurations.get(3) - 70.0) < 0.1);
    }

    @Test
    void testGetDuePayments() {
        System.out.println("Running testGetDuePayments");
        // Test get_due_payments function
        MembershipService testMembershipService = new MembershipService();
        testMembershipService.addMember(new Member(1, "John Doe", MembershipStatus.BASIC));
        testMembershipService.addMember(new Member(2, "Alex C", MembershipStatus.PRO));
        testMembershipService.addMember(new Member(3, "Marie C", MembershipStatus.ELITE));

        // Add workouts for members
        Map<Integer, List<Workout>> memberWorkouts = new HashMap<>();
        memberWorkouts.put(1, Arrays.asList(
                new Workout(12, 500, 700), new Workout(10, 300, 350), new Workout(1, 10, 20),
                new Workout(3, 50, 90), new Workout(6, 130, 150), new Workout(15, 900, 920)
        ));
        memberWorkouts.put(2, Arrays.asList(
                new Workout(13, 510, 540), new Workout(14, 600, 700), new Workout(2, 15, 35),
                new Workout(4, 100, 155), new Workout(8, 200, 225), new Workout(18, 1050, 1155)
        ));
        memberWorkouts.put(3, Arrays.asList(
                new Workout(5, 120, 135), new Workout(7, 140, 190), new Workout(9, 210, 255),
                new Workout(11, 400, 450), new Workout(16, 910, 940), new Workout(17, 1000, 1100)
        ));

        for (Map.Entry<Integer, List<Workout>> entry : memberWorkouts.entrySet()) {
            int memberId = entry.getKey();
            List<Workout> workoutList = entry.getValue();
            for (Workout workout : workoutList) {
                testMembershipService.addWorkout(memberId, workout);
            }
        }

        Map<Integer, Integer> duePayments = testMembershipService.getDuePayments();
        Assertions.assertTrue(Math.abs(duePayments.get(1) - 80.0) < 0.1);
        Assertions.assertTrue(Math.abs(duePayments.get(2) - 40.0) < 0.1);
        Assertions.assertTrue(Math.abs(duePayments.get(3) - 12.0) < 0.1);
    }

}