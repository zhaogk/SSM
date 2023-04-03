import com.atguigu.mybatis.mapper.CacheMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CacheMapperTest {
    @Test
    public void testGetEmpById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp rmp = mapper.getRmpById(1);
        System.out.println(rmp);
        sqlSession.clearCache();
        Emp rmp1 = mapper.getRmpById(1);
        System.out.println(rmp1);

        mapper.insertEmp(new Emp(null,"小明",29,"女"));
        SqlSession sqlSession1 = SqlSessionUtils.getSqlSession();
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp rmp2 = mapper1.getRmpById(1);
        System.out.println(rmp2);
    }

    @Test
    public void testCache() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        CacheMapper mapper = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = mapper.getRmpById(1);
        System.out.println(emp1);
        sqlSession1.close();

        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp2 = mapper2.getRmpById(1);
        System.out.println(emp2);
        sqlSession1.close();

    }


}