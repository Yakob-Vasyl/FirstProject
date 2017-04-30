package audioshop.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by vasya on 011 11 03 2017.
 */
public interface FileWriter {
    enum Folder{
        PLAYER,SPEAKERS,HEADPHONE,CORD;
    }

    boolean write(Folder folder, MultipartFile file, Integer id);
}
