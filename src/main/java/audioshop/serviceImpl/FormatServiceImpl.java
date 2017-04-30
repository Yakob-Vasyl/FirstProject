package audioshop.serviceImpl;

import audioshop.Dao.FormatDao;
import audioshop.dto.filter.SimpleFilter;
import audioshop.entity.Format;
import audioshop.service.FormatService;
import audioshop.specification.FormatSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vasya on 001 01 02 2017.
 */
@Service
public class FormatServiceImpl implements FormatService {


    @Autowired
    private FormatDao formatDao;
    @Override
    public Format fetchFormatWithPlayers(int id) {
        return formatDao.fetchFormatWithPlayers(id);
    }

    @Override
    public Format findByFormat(String format) {
        return formatDao.findByFormat(format);
    }

    @Override
    public Page<Format> findAll(Pageable pageable, SimpleFilter filter) {
        return formatDao.findAll(new FormatSpecification(filter),pageable);
    }

    public void save(Format format) {
        formatDao.save(format);
    }

    public List<Format> findAll() {
        return formatDao.findAll();
    }

    public Format findOne(int id) {
        return formatDao.findOne(id);
    }

    public void delete(int id) {
        formatDao.delete(id);
    }
}
