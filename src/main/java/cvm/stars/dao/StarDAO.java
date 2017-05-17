package cvm.stars.dao;

import cvm.stars.entities.Star;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created by cvm on 17.05.2017.
 */
public class StarDAO {

    private SqlSessionFactory sqlSessionFactory;

    public StarDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<Star> selectAll() {
        List<Star> result = null;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            result = sqlSession.selectList("Star.selectAll");
        } finally {
            sqlSession.close();
        }
        return result;
    }

    public Star selectById(int id) {
        Star result = null;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            result = sqlSession.selectOne("Star.selectById", id);
        } finally {
            sqlSession.close();
        }
        return result;
    }

    public void insert(Star star) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("Star.insert", star);
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    public void update(Star star) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.update("Star.update", star);
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    public void delete(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.delete("Star.delete", id);
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }
}
