
import java.util.List;
import java.util.UUID;

import com.alex.ssm.bean.Dept;
import com.alex.ssm.bean.Emp;
import com.alex.ssm.mapper.DeptMapper;
import com.alex.ssm.mapper.EmpMapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * 测试dao层工作
 * 推荐Spring项目就可以使用Spring的单元测试，可以自动注入我们需要的组件
 * 1. 导入SpringTest模块
 * 2. @ContextConfiguration指定Spring配置文件的位置
 * 3. 直接autowired要使用的组件即可
 */

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration({"classpath:applicationContext.xml" })  
public class TestMapper {
  
  @Autowired
  DeptMapper deptMapper;

  @Autowired
  EmpMapper empMapper;

  @Autowired
  SqlSession sqlSession;

  /**
   * 测试DeptMapper
   */
  @Test
  public void  testCRUD(){
    // System.out.println(deptMapper);

    //1. 插入几个部门
    // deptMapper.insertSelective(new Dept(null, "开发部"));
    // deptMapper.insertSelective(new Dept(null, "测试部"));

    List<Dept> depts = deptMapper.selectByExample(null);
    depts.forEach(System.out::println);

    // 2。生成员工数据，测试员工确认
    long result = empMapper.insertSelective(new Emp(null, "a1a1", "M", "a1a1@alex.com", 1));
    System.out.println(result);
    //3. 批量插入员工, 批量，使用可以执行批量操作的sqlSession
    // for(){
    //   empMapper.insertSelective(new Emp(null, "Jerry", "M", "
    // }
    /**批量操作 */
    // EmpMapper mapper =  sqlSession.getMapper(EmpMapper.class);
    // for(int i = 0; i < 1000; ++i){
    //   String uid = UUID.randomUUID().toString().substring(0,5) + i;
    //   mapper.insertSelective(new Emp(null, uid, "M", uid+"@alex.com", 1));
    // }
    // System.out.println("批量完成");
  }

}
