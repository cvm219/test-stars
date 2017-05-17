package cvm.stars.entities;

/**
 * Created by cvm on 16.05.2017.
 */
public class StarType {

    private Integer id;

    private String name;

    private Boolean removable;

    public StarType(Integer id, String name, Boolean removable) {
        this.id = id;
        this.name = name;
        this.removable = removable;
    }

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

    public Boolean getRemovable() {
        return removable;
    }

    public void setRemovable(Boolean removable) {
        this.removable = removable;
    }

    @Override
    public String toString() {
        return "StarType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", removable=" + removable +
                '}';
    }
}
