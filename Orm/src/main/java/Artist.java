public class Artist {
    static long id;
    static String name;
    static int age;
    static String type;

    public Artist(long id, String name, int age, String type) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public static long getId() {
        return id;
    }

    public static String getName() {
        return name;
    }

    public static int getAge() {
        return age;
    }

    public static String getType() {
        return type;
    }

    public static void setId(long id) {
        Artist.id = id;
    }

    public static void setName(String name) {
        Artist.name = name;
    }

    public static void setAge(int age) {
        Artist.age = age;
    }

    public static void setType(String type) {
        Artist.type = type;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", type='" + type + '\'' +
                '}';
    }
}
