package com.dong;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dong.entity.Student;
import com.dong.service.StudentService;
import com.dong.util.MailUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisPlusTestApplicationTests {

	@Autowired
	private StudentService studentService;
	@Test
	void contextLoads() {
		MailUtil.send("dsc036@163.com", "12131");
	}

	@Test
	void  pageHelp() throws ClassNotFoundException, NoSuchFieldException {
		// Step1：创建一个 Page 对象
		Page<Student> page = new Page<>(1,5);
		// Page<User> page = new Page<>(2, 5);
		// Step2：调用 mybatis-plus 提供的分页查询方法
		List<Student> studentList = studentService.page(page, null).getRecords();

		// Step3：获取分页数据
		//  System.out.println(page.getCurrent()); // 获取当前页
		// System.out.println(page.getTotal()); // 获取总记录数
		// System.out.println(page.getSize()); // 获取每页的条数
		// System.out.println(page.getRecords()); // 获取每页数据的集合
		//System.out.println(page.getPages()); // 获取总页数
		// System.out.println(page.hasNext()); // 是否存在下一页
		// System.out.println(page.hasPrevious()); // 是否存在上一页
	}
}
