public class Main {
    public static void main(String[] args) {
        Orm orm = new Orm();
        orm.addArtist(new Artist(0L, "Jack", 20, "Fantasy Artist"));
        orm.addArtist(new Artist(1L, "Peter", 30, "Human artist"));
//        orm.clearTable("artists");
        orm.findById("artists", 1l);
        orm.findById("artists", 2l);
    }
}
