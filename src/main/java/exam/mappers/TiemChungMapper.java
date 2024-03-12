package exam.mappers;

import exam.entities.TiemChung;
import exam.entities.TiemChungExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TiemChungMapper {

    long countByExample(TiemChungExample example);

    int deleteByExample(TiemChungExample example);

    int deleteByPrimaryKey(Integer maTc);

    int insert(TiemChung row);

    int insertSelective(TiemChung row);

    List<TiemChung> selectByExample(TiemChungExample example);

    TiemChung selectByPrimaryKey(Integer maTc);

    int updateByExampleSelective(@Param("row") TiemChung row, @Param("example") TiemChungExample example);

    int updateByExample(@Param("row") TiemChung row, @Param("example") TiemChungExample example);

    int updateByPrimaryKeySelective(TiemChung row);

    int updateByPrimaryKey(TiemChung row);

    Long countSL(String cccd);
}