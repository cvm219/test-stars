package cvm.stars.entities;

import cvm.stars.dao.StarTypeDAO;

import javax.annotation.PostConstruct;

/**
 * Created by cvm on 17.05.2017.
 */
public class Star {

    private Integer id;

    private String name;

    private String coorX;

    private String coorY;

    private Integer typeId;

    private StarType type;

    private Discoverer discoverer;

    @PostConstruct
    private void bindStarType() {
        type = new StarTypeDAO().selectById(typeId);
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

    public String getCoorX() {
        return coorX;
    }

    public void setCoorX(String coorX) {
        this.coorX = coorX;
    }

    public String getCoorY() {
        return coorY;
    }

    public void setCoorY(String coorY) {
        this.coorY = coorY;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public StarType getType() {
        if (type == null) {
            type = new StarTypeDAO().selectById(typeId);
        }
        return type;
    }

    public void setType(StarType type) {
        this.type = type;
    }

    public Discoverer getDiscoverer() {
        return discoverer;
    }

    public void setDiscoverer(Discoverer discoverer) {
        this.discoverer = discoverer;
    }

    @Override
    public String toString() {
        return "Star{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coorX='" + coorX + '\'' +
                ", coorY='" + coorY + '\'' +
                ", type=" + type +
                ", discoverer=" + discoverer +
                '}';
    }
}
