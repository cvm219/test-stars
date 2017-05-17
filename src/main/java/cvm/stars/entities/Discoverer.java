package cvm.stars.entities;

/**
 * Created by cvm on 17.05.2017.
 */
public class Discoverer {

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Discoverer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
