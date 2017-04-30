package audioshop.serviceImpl;

import audioshop.Dao.HeadphoneDao;
import audioshop.dto.filter.HeadphoneFilter;
import audioshop.dto.form.HeadphoneForm;
import audioshop.entity.Brands;
import audioshop.entity.Category;
import audioshop.entity.Connection;
import audioshop.entity.Headphone;
import audioshop.service.FileWriter;
import audioshop.service.HeadphoneService;
import audioshop.specification.HeadphoneSpecification;
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
public class HeadphoneServiceImpl implements HeadphoneService {


    @Autowired
    private HeadphoneDao headphoneDao;
    @Autowired
    private FileWriter fileWriter;
    @Override
    public HeadphoneForm findForm(int id) {
        HeadphoneForm form = new HeadphoneForm();
        Headphone entity = headphoneDao.findOne(id);
        form.setId(entity.getId());
        form.setProduct_name(entity.getProductName());
        form.setBrand(entity.getBrand());
        form.setConnection(entity.getConnection());


        form.setCategory(entity.getCategory());
        form.setCord_length(String.valueOf(entity.getCord_length()));
        form.setFrequency_range(String.valueOf(entity.getFrequency_range()));
        form.setResistance(String.valueOf(entity.getResistance()));
        form.setSensitivity(String.valueOf(entity.getSensitivity()));
        form.setHave_microphone(entity.isHave_microphone());
        form.setColor(entity.getColor());
        form.setPrice(String.valueOf(entity.getPrice()));
        form.setVersion(entity.getVersion());
        return form;
    }
    public void save(HeadphoneForm form) {
        Headphone entity = new Headphone();
        entity.setId(form.getId());
        entity.setProductName(form.getProduct_name());
        entity.setBrand(form.getBrand());
        entity.setConnection(form.getConnection());

        entity.setCategory(form.getCategory());
        entity.setCord_length(Integer.valueOf(form.getCord_length()));
        entity.setFrequency_range(form.getFrequency_range());
        entity.setResistance(Integer.valueOf(form.getResistance()));
        entity.setSensitivity(Integer.valueOf(form.getSensitivity()));
        entity.setHave_microphone(form.isHave_microphone());
        entity.setColor(form.getColor());
        entity.setPrice(Integer.valueOf(form.getPrice()));

        MultipartFile file = form.getFile();
        headphoneDao.saveAndFlush(entity);
        if(fileWriter.write(FileWriter.Folder.HEADPHONE, file, entity.getId())){
            entity.setVersion(entity.getVersion()+1);
            headphoneDao.save(entity);
    }

    }

    public List<Headphone> findAll() {
        return headphoneDao.findAll();
    }

    public Headphone findOne(int id) {
        return headphoneDao.findOne(id);
    }

    public void delete(int id) {
        headphoneDao.delete(id);
    }

    @Override
    public List<Headphone> findHeadphonesWithCategory(int category) {
        return headphoneDao.findHeadphonesWithCategory(category);
    }

    @Override
    public List<Brands> getBrandsFromHeadphones(int category) {
        return findHeadphonesWithCategory(category).stream().map(Headphone::getBrand).collect(Collectors.toList());
    }



    @Override
    public Headphone findUnique(String product_name, Brands brand, Connection connection, int resistance, int cordLength , int sensitivity, Category category, int price) {
        return headphoneDao.findUnique(product_name, brand.getId(),connection.getId(), resistance, cordLength , sensitivity,  category.getId(), price);
    }

    @Override
    public Page<Headphone> findAll(Pageable pageable) {
        return headphoneDao.findAll(pageable);
    }

    @Override
    public Page<Headphone> findAll(Pageable pageable, HeadphoneFilter filter) {
        return headphoneDao.findAll(new HeadphoneSpecification(filter),pageable);
    }
}

