package cvm.stars.dao;

import cvm.stars.entities.StarType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Created by cvm on 16.05.2017.
 */
public class StarTypeDAO {

    private static final StarType[] STAR_TYPES = new StarType[] {
            new StarType(1, "Blue", true),
            new StarType(2, "White-blue", true),
            new StarType(3, "White", true),
            new StarType(4, "Yellow-white", true),
            new StarType(5, "Yellow", false),
            new StarType(6, "Orange", true),
            new StarType(7, "Red", true)
    };

    public List<StarType> selectAll() {
        return Arrays.asList(STAR_TYPES);
    }

    public StarType selectById(int id) {
        for (StarType starType : STAR_TYPES) {
            if (starType.getId().equals(id)) {
                return starType;
            }
        }
        return null;
    }
}
