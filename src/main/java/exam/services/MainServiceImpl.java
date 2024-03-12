package exam.services;


import exam.entities.Person;
import exam.entities.TiemChung;
import exam.entities.TiemChungExample;
import exam.mappers.TiemChungMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MainServiceImpl implements IMainService {

    @Autowired
    private TiemChungMapper mainMapper;

    /**
     * @param item
     * @author DuyNT58
     * @Author_birth_date: 1995-01-01
     * @TODO
     */
    @Override
    public void update(TiemChung item) {
        mainMapper.updateByPrimaryKey(item);
    }

    @Override
    public void save(TiemChung item) {
        mainMapper.insert(item);
    }

    /**
     * @return
     * @author DuyNT58
     * @Author_birth_date: 1995-01-01
     * @TODO
     */
    @Override
    public List<TiemChung> findAll() {
        return mainMapper.selectByExample(new TiemChungExample());
    }

    @Override
    public Optional<TiemChung> findById(Integer id) {
        // TODO Auto-generated method stub
        return Optional.ofNullable(mainMapper.selectByPrimaryKey(id));
    }

    @Override
    public Long countSL(Person sub) {
        return mainMapper.countSL(sub.getCccd());
    }

}
