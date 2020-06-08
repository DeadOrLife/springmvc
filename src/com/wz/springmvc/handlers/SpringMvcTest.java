package com.wz.springmvc.handlers;

import com.wz.springmvc.entites.User;
import javafx.scene.chart.ValueAxis;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * @DESCRIPTION new class
 * @AUTHOR: jamesbean
 * @DATE: 2020/5/21 12:38 上午
 */
@SessionAttributes(value = {"user"},types = {String.class})
@Controller
@RequestMapping("/springmvc")
public class SpringMvcTest {

    private static final String SUCCESS="success";

    /**
     * 重定向
     * @return
     */
    @RequestMapping(value = "testRedirect")
    public String testRedirect(){
        System.out.println("testRedirect");
        return "redirect:/index.jsp";
    }

    @RequestMapping("/testView")
    public String testView(){
        System.out.println("testView");
        return "helloView";
    }


    @RequestMapping(value = "/testViewAndViewResolver")
    public String testViewAndViewResolver(){
        System.out.println("testViewAndViewResolver");
        return SUCCESS;
    }

    /**
     * @ModelAttribute 会在每个目标方法之前执行
     * 将map中的值会重新绑定到请求方法中的对应参数的值中
     * 简单的理解类似于拦截器
     * @param id
     * @param map
     */
    @ModelAttribute
    public void getUser(@RequestParam(value="id",required=false) Integer id,
                        Map<String, Object> map){
        System.out.println("modelAttribute method");
        if(id != null){
            User user = new User(1, "Tom", "123456", "tom@atguigu.com", 12);
            System.out.println("数据库的值:" + user);

            map.put("abc", user);
        }
    }

    @RequestMapping(value = "/testModelAttributes")
    public String testModelAttributes(@ModelAttribute(value = "abc") User user){
        System.out.println("testModelAttributes：："+user);
        return SUCCESS;
    }


    /**
     * @SessionAttributes 除了可以通过属性名指定需要放到会话中的属性外 实际上用得是value的值
     * 还可以通过模型属性的对象类型指定哪些模型属性需要放到会话中  实际上使用的是types 属性值
     *
     * @param map
     * @return
     */
    @RequestMapping(value ="/testSessionAttributes")
    public String testSessionAttributes(Map<String,Object> map){
        User user = new User();
        user.setAge(10);
        map.put("user",user);
        map.put("school","wz");
        return SUCCESS;
    }




    /**
     * 目标方法可以添加 Map 类型的参数
     *
     * 实际上 也可以是 Model类型 或者 ModelMap类型
     * @param map
     * @return
     */
    @RequestMapping(value = "testMap")
    public String testMap(Map<String,Object> map){
        map.put("name", Arrays.asList("TOM","JERRY"));
        return SUCCESS;
    }


    /**
     * 目标方法的返回值可以使 ModelAndView 类型
     * 其中可以包含视图和模型信息
     *
     * Spring MVC 会把ModelAndView 的model 中的数据放入到request 域对象
     *
     * @return
     */
    @RequestMapping(value = "testModelAndView")
    public ModelAndView testModelAndView(){
        String viewName = SUCCESS;
        ModelAndView modelAndView = new ModelAndView(viewName);

        //添加模型数据到ModelAndView中
        modelAndView.addObject("time",new Date());

        return modelAndView;
    }

    /**
     * 测试Writer
     * @param out
     * @throws IOException
     */
    @RequestMapping(value = "/testServletAPIWriter")
    public void testServletAPIWriter(Writer out) throws IOException {
        out.write("hello world out");

    }

    /**
     * Spring MVC的Handler 方法可以接受 ServletAPI的哪些参数
     *
     * 原生API作为目标方法的参数
     *
     * 9种
     *
     * HttpServletRequest
     * HttpServletResponse
     * HttpSession
     * java.security.Principal
     * Locale
     * InputStream
     * OutputStream
     * Reader
     * Writer
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/testServletAPI")
    public String testServletAPI(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request+"%%%%"+response);
        return SUCCESS;
    }



    /**
     * pojo 参数 支持级联
     *
     * Spring MVC 会按请求参数名和pojo属性名进行自动匹配
     * 自动为该对象填充属性值，支持级联属性 如 dept.deptId、dept.address.tel等
     * @param user
     * @return
     */
    @RequestMapping(value = "/testPojo",method = RequestMethod.POST)
    public String testPojo(User user){
        System.out.println(user);
        return SUCCESS;
    }

    /**
     * 了解：
     * @CookieValue 映射一个cookie值 属性同@RequestParam
     * @param cookie
     * @return
     */
    @RequestMapping(value = "testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String cookie){
        System.out.println(cookie);
        System.out.println("CookieValue");
        return SUCCESS;
    }

    /**
     * 映射请求头信息
     * 用法同@RequestParam
     * @param header
     * @return
     */
    @RequestMapping(value = "/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept-Language") String header){
        System.out.println(header);
        System.out.println("testRequestHeader");
        return SUCCESS;
    }

    /**
     * @RequestParam 来映射请求的参数
     * value 值即请求参数的参数名
     * required 该参数是否是必须的 默认为true 如果不传则会报错
     *
     *
     * @param username
     * @param age
     * @return
     */
    @RequestMapping("testRequestParam")
    public String testRequestParam(@RequestParam(value = "username",required = false) String username,
                                   @RequestParam(value = "age",required = false,defaultValue = "0") Integer age){
        System.out.println(username+":"+age);
        System.out.println("testRequestParam");
        return SUCCESS;
    }


    /**
     * Rest风格的url
     * 以CRUD为例
     *
     * 新增 /order POST
     * 修改 /order/1 PUT      update?id=1
     * 获取 /order/1 GET      get?id=1
     * 删除 /order/1 DELETE   delete?id=1
     *
     * 如果发生put与delete请求呢
     * 1.需要配置HiddenHttpMethodFilter
     * 2.需要发生post请求
     * 3.需要在发生post请求时携带一个 name="_method" 的隐藏域  值为DELETE 或 PUT
     *
     * 在springMVC的目标方法中 如何得到id呢
     * 使用@PathVariable 注解
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.DELETE)
    public String testRestDelete(@PathVariable("id") Integer id){
        System.out.println("DELETE:"+id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.PUT)
    public String testRestPut(@PathVariable("id") Integer id){
        System.out.println("PUT:"+id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.POST)
    public String testRestPost(@PathVariable("id") Integer id){
        System.out.println("POST:"+id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.GET)
    public String testRestGet(@PathVariable("id") Integer id){
        System.out.println("GET:"+id);
        return SUCCESS;
    }

    /**
     * spring 3.0加的功能
     *
     * rest 资源变现层转化
     *
     * 将占位符参数绑定控制器处理方法的入参中
     * @return
     */
    @RequestMapping(value = "testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") Integer id){
        System.out.println(id);
        System.out.println("testPathVariable");
        return SUCCESS;
    }


    /**
     * Ant表达式
     * ？匹配文件名中的一个字符
     * * 匹配文件名中的任意字符
     * ** 匹配多层路径
     * @return
     */
    @RequestMapping(value = "/testAntPath/*/abc")
    public String testAntPath(){
        System.out.println("testAntPath");
        return SUCCESS;
    }

    /**
     * 了解:可以使用params与headers来更加精确的映射球请求， params和headers支持简单的 表达式
     * @return
     */
    @RequestMapping(value = "testParamsAndHeaders",
            params = {"username","age!=10"},headers = {"Accept-Language=zh-cn"})
    public String testParamsAndHeaders(){
        System.out.println("testParamsAndHeaders");
        return SUCCESS;
    }


    /**
     * 常用：使用method属性来指定请求方式
     * @return
     */
    @RequestMapping(value = "/getOrPost",method = RequestMethod.GET)
    public String requestMappingGet(){
        System.out.println("requestMappingGET");
        return SUCCESS;
    }
    @RequestMapping(value = "/getOrPost",method = RequestMethod.POST)
    public String requestMappingPost(){
        System.out.println("requestMappingPOST");
        return SUCCESS;
    }


    /**
     * @RequestMapping 可以作用在类上面也可以作用在方法上面
     * @return
     */
    @RequestMapping("/requestMapping")
    public String requestMapping(){
        System.out.println("requestMapping");
        return SUCCESS;
    }

}
