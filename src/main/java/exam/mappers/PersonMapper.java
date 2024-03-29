package exam.mappers;

import exam.dto.SubDTO;
import exam.entities.Person;
import exam.entities.PersonExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PersonMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Person
     *
     * @mbg.generated Tue Mar 12 13:50:13 ICT 2024
     */
    long countByExample(PersonExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Person
     *
     * @mbg.generated Tue Mar 12 13:50:13 ICT 2024
     */
    int deleteByExample(PersonExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Person
     *
     * @mbg.generated Tue Mar 12 13:50:13 ICT 2024
     */
    int deleteByPrimaryKey(String cccd);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Person
     *
     * @mbg.generated Tue Mar 12 13:50:13 ICT 2024
     */
    int insert(Person row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Person
     *
     * @mbg.generated Tue Mar 12 13:50:13 ICT 2024
     */
    int insertSelective(Person row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Person
     *
     * @mbg.generated Tue Mar 12 13:50:13 ICT 2024
     */
    List<Person> selectByExample(PersonExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Person
     *
     * @mbg.generated Tue Mar 12 13:50:13 ICT 2024
     */
    Person selectByPrimaryKey(String cccd);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Person
     *
     * @mbg.generated Tue Mar 12 13:50:13 ICT 2024
     */
    int updateByExampleSelective(@Param("row") Person row, @Param("example") PersonExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Person
     *
     * @mbg.generated Tue Mar 12 13:50:13 ICT 2024
     */
    int updateByExample(@Param("row") Person row, @Param("example") PersonExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Person
     *
     * @mbg.generated Tue Mar 12 13:50:13 ICT 2024
     */
    int updateByPrimaryKeySelective(Person row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Person
     *
     * @mbg.generated Tue Mar 12 13:50:13 ICT 2024
     */
    int updateByPrimaryKey(Person row);


    List<SubDTO> findAllMapDTO();

    List<SubDTO> search(String searchName, String count);

    void modify(String id, Integer status);
}