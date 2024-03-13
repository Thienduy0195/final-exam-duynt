package exam.services;
import exam.entities.Person;
import exam.entities.TiemChung;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IMainService {

  void update(TiemChung item);

  void save(TiemChung item);

  List<TiemChung> findAll();

  Optional<TiemChung> findById(Integer id);

  Long countSL(String cccd);

}
