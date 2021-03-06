package animals;

public class Animal {
    protected static final String MALE_GENDER = "Male";
    protected static final String FEMALE_GENDER = "Female";
    private static final String SOUND = "Not implemented!";

    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public String produceSound() {
        return SOUND;
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessageConstants.INVALID_INPUT_MESSAGE);
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException(ErrorMessageConstants.INVALID_INPUT_MESSAGE);
        }
        this.age = age;
    }

    protected void setGender(String gender) {
        if (!gender.equals(MALE_GENDER) && !gender.equals(FEMALE_GENDER)) {
            throw new IllegalArgumentException(ErrorMessageConstants.INVALID_INPUT_MESSAGE);
        }
        this.gender = gender;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append(System.lineSeparator())
                .append(String.format("%s %d %s", this.name, this.age, this.gender)).append(System.lineSeparator())
                .append(this.produceSound());
        return sb.toString();
    }
}