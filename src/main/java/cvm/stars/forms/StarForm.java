package cvm.stars.forms;

import cvm.stars.dao.DiscovererDAO;
import cvm.stars.dao.StarTypeDAO;
import cvm.stars.mybatis.MyBatisConnectionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cvm on 17.05.2017.
 */
public class StarForm {

    private Integer id;

    private String name;

    private String coorX;

    private String coorY;

    private Integer type;

    private Integer discoverer;

    private List<String> errors = new ArrayList<String>();

    public boolean validate() {
        errors.clear();
        if (name == null || name.equals("")) {
            errors.add("Field \"name\" cannot be empty");
        }
        if (coorX == null || coorX.equals("")) {
            errors.add("Field \"Coor 1\" cannot be empty");
        }
        if (coorY == null || coorY.equals("")) {
            errors.add("Field \"Coor 2\" cannot be empty");
        }
        StarTypeDAO starTypeDAO = new StarTypeDAO();
        if (type == null) {
            errors.add("Field \"Class\" must be selected");
        }
        if (type != null && starTypeDAO.selectById(type) == null) {
            errors.add("Unrecognized value of \"Class\" field");
        }
        DiscovererDAO discovererDAO = new DiscovererDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        if (discoverer == null) {
            errors.add("Field \"Discoverer\" must be selected");
        }
        if (discoverer != null && discovererDAO.selectById(discoverer) == null) {
            errors.add("Unrecognized value of \"Discoverer\" field");
        }
        return errors.isEmpty();
    }

    public void addError(String error) {
        errors.add(error);
    }

    public String errorsWithBr() {
        String res = "";
        for (String str : errors) {
            res += str + "<br/>";
        }
        return res;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getDiscoverer() {
        return discoverer;
    }

    public void setDiscoverer(Integer discoverer) {
        this.discoverer = discoverer;
    }

    @Override
    public String toString() {
        return "StarForm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coorX='" + coorX + '\'' +
                ", coorY='" + coorY + '\'' +
                ", type=" + type +
                ", discoverer='" + discoverer + '\'' +
                '}';
    }
}
