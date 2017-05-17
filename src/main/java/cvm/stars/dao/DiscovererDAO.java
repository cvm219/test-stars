package cvm.stars.dao;

import cvm.stars.entities.Discoverer;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created by cvm on 17.05.2017.
 */
public class DiscovererDAO {

    private SqlSessionFactory sqlSessionFactory;

    public DiscovererDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<Discoverer> selectAll() {
        List<Discoverer> result = null;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            result = sqlSession.selectList("Discoverer.selectAll");
        } finally {
            sqlSession.close();
        }
        return result;
    }

    public Discoverer selectById(int id) {
        Discoverer result = null;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            result = sqlSession.selectOne("Discoverer.selectById", id);
        } finally {
            sqlSession.close();
        }
        return result;
    }

    public Discoverer selectByName(String name) {
        Discoverer result = null;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            result = sqlSession.selectOne("Discoverer.selectByName", name);
        } finally {
            sqlSession.close();
        }
        return result;
    }

    public void insert(Discoverer discoverer) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("Discoverer.insert", discoverer);
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }
}
