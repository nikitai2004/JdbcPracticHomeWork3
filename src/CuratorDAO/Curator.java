package CuratorDAO;

public class Curator {

    private Integer id;
    private String fio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    @Override
    public String toString() {
        return "Curator{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                '}';
    }
}