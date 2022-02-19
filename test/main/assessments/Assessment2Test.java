package main.assessments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Assessment2Test {

    @Test
    void customSortString() {
        System.out.println(new Assessment2().customSortString("abc", "cbad"));
    }
}