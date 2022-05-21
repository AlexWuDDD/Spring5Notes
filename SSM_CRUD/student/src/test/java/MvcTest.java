import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import com.alex.ssm.bean.Emp;
import com.github.pagehelper.PageInfo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * 使用Spring测试模块提供的测试请求功能，测试curd请求的正确性
 */

@RunWith(SpringJUnit4ClassRunner.class) 
@WebAppConfiguration
@ContextConfiguration({"classpath*:/applicationContext.xml", "classpath*:/springMVC.xml"})
public class MvcTest {
  //传入Springmvc的ioc
  @Autowired
  WebApplicationContext context;
  // 虚拟mvc请求，获取到处理结果
  MockMvc mockMvc;
  
  @Before
  public void initMockMvc(){
    mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
  }

  @Test
  public void testPage(){
    try {
      //模拟请求拿到返回值
      MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "5")).andReturn();
      
      assertNotEquals(result, null);

      //请求成功后，请求域中会有pageInfo，我们可以取出pageInfo进行验证
      MockHttpServletRequest request = result.getRequest();
      assertNotEquals(request, null);
      PageInfo<Emp> pageInfo = (PageInfo)request.getAttribute("pageInfo");
      assertNotEquals(pageInfo, null);
      System.out.println("当前页码：" + pageInfo.getPageNum());
      System.out.println("总页码" + pageInfo.getPages());
      System.out.println("总记录数" + pageInfo.getTotal());
      System.out.println("在页面需要连续显示的页码");
      int[] nums = pageInfo.getNavigatepageNums();
      for (int i : nums) {
        System.out.print(" " + i);
      }
      System.out.println();
      //获取员工数据
      List<Emp> emps = pageInfo.getList();
      emps.forEach(System.out::println);


    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
}
