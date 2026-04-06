
package model;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class MatchingEngineTest {

    Student student;
    Mentor mentor1;
    Mentor mentor2;
    MatchingEngine engine;

    @BeforeEach
    void setUp() {
        student = new Student("Asha", List.of("Java"), "Software");
        mentor1 = new Mentor("Raj", List.of("Java"), "Software");
        mentor2 = new Mentor("Neha", List.of("Python"), "Finance");
        engine = new MatchingEngine();
    }

    @Test
    void exactMatchTest() {
        System.out.println("Running exactMatchTest");
        Mentor result = engine.assignBestMentor(student, List.of(mentor1, mentor2));
        System.out.println("Expected: Raj");
        System.out.println("Actual: " + result.getName());
        assertEquals("Raj", result.getName());
    }

    @Test
    void assertNotEqualsTest() {
        System.out.println("Running assertNotEqualsTest");
        Mentor result = engine.assignBestMentor(student, List.of(mentor1, mentor2));
        System.out.println("Expected: Not Neha");
        System.out.println("Actual: " + result.getName());
        assertNotEquals("Neha", result.getName());
    }

    @Test
    void assertTrueTest() {
        System.out.println("Running assertTrueTest");
        Mentor result = engine.assignBestMentor(student, List.of(mentor1, mentor2));
        System.out.println("Industry: " + result.getIndustry());
        assertTrue(result.getIndustry().equalsIgnoreCase("Software"));
    }

    @Test
    void assertFalseTest() {
        System.out.println("Running assertFalseTest");
        Mentor result = engine.assignBestMentor(student, List.of(mentor1, mentor2));
        System.out.println("Industry: " + result.getIndustry());
        assertFalse(result.getIndustry().equalsIgnoreCase("Finance"));
    }

    @Test
    void assertNotNullTest() {
        System.out.println("Running assertNotNullTest");
        Mentor result = engine.assignBestMentor(student, List.of(mentor1, mentor2));
        System.out.println("Result object: " + result.getName());
        assertNotNull(result);
    }

    @Test
    void assertNullTest() {
        System.out.println("Running assertNullTest");
        Mentor result = engine.assignBestMentor(student, List.of());
        System.out.println("Result should be null");
        assertNull(result);
    }

    @Test
    void multipleSkillTest() {
        System.out.println("Running multipleSkillTest");
        Student s = new Student("Asha", List.of("Java", "Spring", "SQL"), "Software");
        Mentor m1 = new Mentor("Raj", List.of("Java"), "Software");
        Mentor m2 = new Mentor("Neha", List.of("Java", "Spring"), "Software");
        Mentor result = engine.assignBestMentor(s, List.of(m1, m2));
        System.out.println("Expected: Neha");
        System.out.println("Actual: " + result.getName());
        assertEquals("Neha", result.getName());
    }

    @Test
    void caseInsensitiveTest() {
        System.out.println("Running caseInsensitiveTest");
        Student s = new Student("Asha", List.of("java"), "software");
        Mentor m1 = new Mentor("Raj", List.of("JAVA"), "SOFTWARE");
        Mentor result = engine.assignBestMentor(s, List.of(m1));
        System.out.println("Expected: Raj");
        System.out.println("Actual: " + result.getName());
        assertEquals("Raj", result.getName());
    }

    @Test
    void tieScoreTest() {
        System.out.println("Running tieScoreTest");
        Student s = new Student("Asha", List.of("Java"), "Software");
        Mentor m1 = new Mentor("Raj", List.of("Java"), "Software");
        Mentor m2 = new Mentor("Neha", List.of("Java"), "Software");
        Mentor result = engine.assignBestMentor(s, List.of(m1, m2));
        System.out.println("Expected: Raj");
        System.out.println("Actual: " + result.getName());
        assertEquals("Raj", result.getName());
    }
}