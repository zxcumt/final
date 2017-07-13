/**
 * 
 */
package Dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


/*
 * 重要知识点，动态修改表名应该是${}不是#{},这样没有'' 原创basedao方法，肯定有漏洞
 */
public interface BaseDao<T> {

	/**
	 * 根据ID查询实体 T
	 */
	@Select("select * from ${entityClazz} where id=#{id}")
	T queryById(@Param("entityClazz") String entityClazz, @Param("id") int id);

	/**
	 * 违背了面向对象的原则，不建议使用 动态插入，调用格式为
	 * .save("table","column1,column2","value1,value2") int
	 */
	@Insert("insert into ${entityClazz}(${key}) values (${value})")
	@Options(useGeneratedKeys=false )
	int save(@Param("entityClazz") String entityClazz, @Param("key") String key, @Param("value") String value);

	/**
	 * 更新，感觉没什么用，不好封装，毫无意义 int example:userDao.update("user", "password=8888",
	 * 43);
	 */
	@Update("update ${entityClazz} set ${setsql} where id=#{id}")
	int update(@Param("entityClazz") String entityClazz, @Param("setsql") String setsql, @Param("id") int id);

	/**
	 * 根据ID删除实体 void
	 * @return 
	 */
	@Delete("delete from ${entityClazz} where id=#{id}")
	public int delete(@Param("entityClazz") String entityClazz, @Param("id") int id);

	/**
	 * 获取表所有数据 List<T>
	 */
	@Select("select * from ${entityClazz}")
	List<T> findAll(@Param("entityClazz") String entityClazz);

	/**
	 * 删除表所有数据 int
	 */
	@Delete("delete from ${entityClazz}")
	int deleteAll(@Param("entityClazz") String entityClazz);

	/**
	 * 根据sql语句获取多个实体 List<T>
	 */
	@Select("${hql}")
	List<T> find(@Param("hql") String sql);

	/**
	 * 根据sql语句获取单个实体
	 */
	@Select("${hql}")
	T getOne(@Param("hql") String sql);

	/**
	 * 根据ID批量删除实体 void
	 */
	@Delete("delete from ${entityClazz} where id in (${ids})")
	int deletesById(@Param("entityClazz") String entityClazz, @Param("ids") String ids);
	
	/**
	 * 根据ids查询
	 * TODO
	 * List<T>
	 */
	@Select("select * from ${entityClazz} where id in (${ids})")
    List<T> queryByIds(@Param("entityClazz") String entityClazz, @Param("ids") String ids);	
	
	/**
	 * 获取实体总数TODO long
	 */
	@Select("select count(*) from ${entityClazz}")
	long findCount(@Param("entityClazz") String entityClazz);

	/**
	 * 分页查询
	 */
	@Select("${sql} limit ${(pageNo-1)*pageSize},${pageSize}")
	public List<T> findByPage(@Param("sql")String sql,  @Param("pageNo")int pageNo, @Param("pageSize") int pageSize);
	
	/**
	 * 根据sql查询总数
	 * TODO
	 * long
	 */
	@Select("select count(*) ${sql}")
	long findCountBySql(@Param("sql")String sql);
}
