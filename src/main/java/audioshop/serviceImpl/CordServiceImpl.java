package audioshop.serviceImpl;

import audioshop.Dao.CordDao;
import audioshop.dto.filter.CordFilter;
import audioshop.dto.form.CordForm;
import audioshop.entity.Brands;
import audioshop.entity.Category;
import audioshop.entity.Connection;
import audioshop.entity.Cord;
import audioshop.service.CordService;
import audioshop.service.FileWriter;
import audioshop.specification.CordSpecification;
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
public class CordServiceImpl implements CordService {

    @Autowired
    private CordDao cordDao;

    @Autowired
    private FileWriter fileWriter;

    @Override
    public void save(CordForm form) {


        Cord entity = new Cord();
        entity.setId(form.getId());
        entity.setProductName(form.getProduct_name());
        entity.setBrand(form.getBrand());
        entity.setConnection(form.getConnection());


        entity.setLength(Integer.valueOf(form.getLength()));
        entity.setPrice(Integer.valueOf(form.getPrice()));
        entity.setCategory(form.getCategory());
        entity.setMaterial(form.getMaterial());

        MultipartFile file = form.getFile();
        cordDao.saveAndFlush(entity);
        if(fileWriter.write(FileWriter.Folder.CORD, file, entity.getId())){
           entity.setVersion(entity.getVersion()+1);
           cordDao.save(entity);
        }

    }

    public List<Cord> findAll() {
        return cordDao.findAll();
    }

    @Override
    public Page<Cord> findAll(Pageable pageable, CordFilter filter) {
        return cordDao.findAll(new CordSpecification(filter),pageable);
    }

    public Cord findOne(int id) {
        return cordDao.findOne(id);
    }

    public void delete(int id) {
        cordDao.delete(id);
    }

    @Override
    public Cord findUnique(String product_name, Brands brand, Connection connection, int length, int price , Category category) {
        return cordDao.findUnique(product_name, brand.getId(), connection.getId(), length, price,category.getId() );
    }

    @Override
    public CordForm findForm(int id) {
        CordForm cordForm = new CordForm();
        Cord entity = cordDao.findOne(id);
        cordForm.setId(entity.getId());
        cordForm.setProduct_name(entity.getProductName());
        cordForm.setBrand(entity.getBrand());
        cordForm.setConnection(entity.getConnection());

        cordForm.setLength(String.valueOf(entity.getLength()));
        cordForm.setPrice(String.valueOf(entity.getPrice()));
        cordForm.setCategory(entity.getCategory());
        cordForm.setMaterial(entity.getMaterial());
        cordForm.setVersion(entity.getVersion());
        return cordForm;
    }

    @Override
    public List<Cord> findCordsWithCategory(int category) {
        return cordDao.findCordsWithCategory(category);
    }

    @Override
    public List<Brands> getBrandsFromCord(int category) {
        return findCordsWithCategory(category).stream().map(Cord::getBrand).collect(Collectors.toList());
    }

    @Override
    public Page<Cord> findAll(Pageable pageable) {
        return cordDao.findAll(pageable);
    }

}
