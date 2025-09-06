package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);

/**
 * 向employee表中插入一条员工记录
 * @param employee 包含员工完整信息的实体对象，包含以下字段：
 *                 - name: 员工姓名
 *                 - username: 员工用户名
 *                 - password: 员工密码
 *                 - phone: 员工电话号码
 *                 - sex: 员工性别
 *                 - idNumber: 员工身份证号
 *                 - status: 员工状态
 *                 - createTime: 创建时间
 *                 - updateTime: 更新时间
 *                 - createUser: 创建人
 *                 - updateUser: 更新人
 */
    @Insert("insert into employee (name, username, password, phone, sex, id_number, status, create_time, update_time, create_user, update_user) " +
            "values " +
            "(#{name}, #{username}, #{password}, #{phone}, #{sex}, #{idNumber}, #{status}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser})")
    @AutoFill(value = OperationType.INSERT)
    void insert(Employee employee);


/**
 * 分页查询员工信息
 * 该方法用于根据查询条件进行分页查询，返回一个包含员工信息的Page对象
 *
 * @param employeePageQueryDTO 员工分页查询条件数据传输对象，包含分页信息和查询条件
 * @return Page<Employee> 返回一个分页对象，包含员工数据列表和分页信息
 */
    Page<Employee> pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    @AutoFill(value = OperationType.UPDATE)
    void update(Employee employee);

    @Select("select * from employee where id = #{id}")
    Employee getById(Long id);
}
