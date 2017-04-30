package audioshop.serviceImpl;

import audioshop.Dao.SpeakersDao;
import audioshop.dto.filter.SpeakersFilter;
import audioshop.dto.form.SpeakersForm;
import audioshop.entity.Brands;
import audioshop.entity.Category;
import audioshop.entity.Connection;
import audioshop.entity.Speakers;
import audioshop.service.FileWriter;
import audioshop.service.SpeakersService;
import audioshop.specification.SpeakersSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by vasya on 031 31 01 2017.
 */
@Service
public class SpeakersServiceImpl implements SpeakersService {
    @Autowired
    private SpeakersDao speakersDao;
    @Autowired
    private FileWriter fileWriter;

    public void save(SpeakersForm form) {
        Speakers entity = new Speakers();
        entity.setId(form.getId());
        entity.setProductName(form.getProduct_name());
        entity.setBrand(form.getBrand());
        entity.setConnection(form.getConnection());

        entity.setCategory(form.getCategory());
        entity.setFrequency_range(form.getFrequency_range());
        entity.setImpedance(Integer.valueOf(form.getImpedance()));
        entity.setSensitivity(Integer.valueOf(form.getSensitivity()));
        entity.setPower(Integer.valueOf(form.getPower()));
        entity.setColor(form.getColor());
        entity.setWeight(Integer.valueOf(form.getWeight()));
        entity.setPrice(Integer.valueOf(form.getPrice()));


        MultipartFile file = form.getFile();
        speakersDao.saveAndFlush(entity);
        if(fileWriter.write(FileWriter.Folder.SPEAKERS, file, entity.getId())){
            entity.setVersion(entity.getVersion()+1);
            speakersDao.save(entity);
        }

    }

    public List<Speakers> findAll() {
        return speakersDao.findAll();
    }

    public Speakers findOne(int id) {
        return speakersDao.findOne(id);
    }

    public void delete(int id) {
        speakersDao.delete(id);
    }

    @Override
    public List<Speakers> findSpeakersWithCategory(int category) {
        return speakersDao.findSpeakersWithCategory(category);
    }

    @Override
    public Page<Speakers> findAll(Pageable pageable, SpeakersFilter filter) {
        return speakersDao.findAll(new SpeakersSpecification(filter),pageable);
    }

    @Override
    public List<Brands> getBrandsFromSpeakers(int category) {
        return findSpeakersWithCategory(category).stream().map(Speakers::getBrand).collect(Collectors.toList());
    }

    @Override
    public SpeakersForm findForm(int id) {
        SpeakersForm form = new SpeakersForm();
        Speakers entity = speakersDao.findOne(id);
        form.setId(entity.getId());
        form.setProduct_name(entity.getProductName());
        form.setBrand(entity.getBrand());
        form.setConnection(entity.getConnection());

        form.setCategory(entity.getCategory());
        form.setSensitivity(String.valueOf(entity.getSensitivity()));
        form.setFrequency_range(entity.getFrequency_range());
        form.setImpedance(String.valueOf(entity.getImpedance()));
        form.setPower(String.valueOf(entity.getPower()));
        form.setColor(entity.getColor());
        form.setWeight(String.valueOf(entity.getWeight()));
        form.setPrice(String.valueOf(entity.getPrice()));
        form.setVersion(entity.getVersion());
        return form;
    }

    @Override
    public Speakers findUnique(String product_name, Brands brand, Connection connection, Category category, int impedance, int sensitivity, int power, String color) {
        return speakersDao.findUnique(product_name, brand.getId(),connection.getId(),category.getId(), impedance, sensitivity,power ,color );
    }

    @Override
    public Page<Speakers> findAll(Pageable pageable) {
        return speakersDao.findAll(pageable);
    }
}
