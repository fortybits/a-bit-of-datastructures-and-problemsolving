package edu.bit.competitive.leet.weekly.mayone;

import edu.bit.problemsolving.competitive.leet.weekly.mayone.MaximumPopulationYear;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaximumPopulationYearTest {

    MaximumPopulationYear maximumPopulationYear = new MaximumPopulationYear();

    @Test
    void maximumPopulation() {
        Assertions.assertEquals(1960,
                maximumPopulationYear.maximumPopulation(new int[][]{{1950, 1961}, {1960, 1971}, {1970, 1981}}));

        Assertions.assertEquals(1993,
                maximumPopulationYear.maximumPopulation(new int[][]{{1993, 1999}, {2000, 2010}}));
    }
}