
package model;
import java.util.List;

public class Student {
    private String name;
    private List<String> skills;
    private String industryPreference;

    public Student(String name, List<String> skills, String industryPreference) {
        this.name = name;
        this.skills = skills;
        this.industryPreference = industryPreference;
    }

    public String getName() {
        return name;
    }

    public List<String> getSkills() {
        return skills;
    }

    public String getIndustryPreference() {
        return industryPreference;
    }
}
