package exam.services;


import exam.dto.SubDTO;
import exam.entities.Person;
import exam.entities.TiemChung;

import java.util.List;


public interface ISubService {
    void update(Person item);

    Boolean modify(String id, Integer status);

    void save(Person item);

    List<Person> findAll();

    List<SubDTO> findAllMapDTO();

    Person findById(String id);

    List<SubDTO> search(String option1, String option2);

    Float tinhTongTien(TiemChung lotrinh, Integer soluongVe);


}
