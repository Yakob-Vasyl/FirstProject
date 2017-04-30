package audioshop.service;

import audioshop.dto.filter.SimpleFilter;
import audioshop.entity.Format;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by vasya on 030 30 01 2017.
 */
public interface FormatService {
    void save(Format format);
    List<Format> findAll();
    Format findOne(int id);
    void delete(int id);
    Format fetchFormatWithPlayers(int id);
    Format findByFormat(String format);
    Page<Format> findAll(Pageable pageable, SimpleFilter filter);
}
