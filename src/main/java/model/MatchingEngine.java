package model;

import java.util.List;

public class MatchingEngine {

    public Mentor assignBestMentor(Student student, List<Mentor> mentors) {

        if (student == null || mentors == null || mentors.isEmpty()) {
            return null;
        }

        Mentor bestMentor = null;
        int bestScore = -1;

        for (Mentor mentor : mentors) {

            int score = 0;

            // Industry match 
            if (mentor.getIndustry().equalsIgnoreCase(student.getIndustryPreference())) {
                score += 2;
            }

            // Skill overlap
            for (String skill : student.getSkills()) {
                for (String mSkill : mentor.getSkills()) {
                    if (skill.equalsIgnoreCase(mSkill)) {
                        score += 5;
                    }
                }
            }

            if (score > bestScore) {
                bestScore = score;
                bestMentor = mentor;
            }
        }

        return bestMentor;
    }
}