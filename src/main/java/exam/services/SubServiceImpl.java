package exam.services;

import exam.dto.SubDTO;
import exam.entities.Person;
import exam.entities.PersonExample;
import exam.entities.TiemChung;
import exam.mappers.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubServiceImpl implements ISubService {

    @Autowired
    private PersonMapper subMapper;


    /**
     * @param item
     * @author DuyNT58
     * @Author_birth_date: 1995-01-01
     * @TODO
     */
    @Override
    public void update(Person item) {
        subMapper.updateByPrimaryKey(item);
    }

    /**
     * @param item
     * @return
     * @author DuyNT58
     * @Author_birth_date: 1995-01-01
     * @TODO
     */
    @Override
    public void save(Person item) {
        subMapper.insert(item);
    }

    /**
     * @return
     * @author DuyNT58
     * @Author_birth_date: 1995-01-01
     * @TODO
     */
    @Override
    public List<Person> findAll() {
        return subMapper.selectByExample(new PersonExample());
    }

    @Override
    public List<SubDTO> findAllMapDTO() {
        return subMapper.findAllMapDTO();
    }


    /**
     * @param id
     * @return
     * @author DuyNT58
     * @Author_birth_date: 1995-01-01
     * @TODO
     */
    @Override
    public Person findById(String id) {
        return subMapper.selectByPrimaryKey(id);
    }

    /**
     * @param option1
     * @param option2
     * @return
     * @author DuyNT58
     * @Author_birth_date: 1995-01-01
     * @TODO
     */
    @Override
    public List<SubDTO> search(String option1) {
        return subMapper.search("%" + option1 + "%");
    }

    /**
     * @param lotrinh
     * @return
     * @author DuyNT58
     * @Author_birth_date: 1995-01-01
     * @TODO
     */
    @Override
    public Float tinhTongTien(TiemChung lotrinh, Integer soInteger) {
//        Float tongTien = lotrinh.getGiaVe() * soInteger;
//
//        if (soInteger > 3) {
//            return (float) (tongTien * 0.9);
//        }
        return 0.f;
    }




}
