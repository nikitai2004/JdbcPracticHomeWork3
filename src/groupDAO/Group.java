package groupDAO;

public class Group {

    private Integer id;
    private String name;
    private Integer id_curator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String fio) {
        this.name = fio;
    }

    public Integer getId_curator() {
        return id_curator;
    }

    public void setId_curator(Integer id_group) {
        this.id_curator = id_group;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", id_curator=" + id_curator +
                '}';
    }
}