package model;

import java.util.List;

public class Mentor {
    private String name;
    private List<String> skills;
    private String industry;

    public Mentor(String name, List<String> skills, String industry) {
        this.name = name;
        this.skills = skills;
        this.industry = industry;
    }

    public String getName() {
        return name;
    }

    public List<String> getSkills() {
        return skills;
    }

    public String getIndustry() {
        return industry;
    }
}
