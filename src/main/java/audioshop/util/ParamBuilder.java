package audioshop.util;

import audioshop.dto.filter.SimpleFilter;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * Created by vasya on 006 06 03 2017.
 */
public class    ParamBuilder {
    public static String getParams(Pageable pageable){
        StringBuilder buffer = new StringBuilder();
        buffer.append("?page=");
        buffer.append(String.valueOf(pageable.getPageNumber()+1));
        buffer.append("&size=");
        buffer.append(String.valueOf(pageable.getPageSize()));
        if(pageable.getSort()!=null){
            buffer.append("&sort=");
            Sort sort = pageable.getSort();
            sort.forEach((order)->{
                buffer.append(order.getProperty());
                if(order.getDirection()!= Sort.Direction.ASC)
                    buffer.append(",desc");
            });
        }

        return buffer.toString();
    }

    public static String getParams(Pageable pageable, SimpleFilter filter){
        StringBuilder buffer = new StringBuilder();
        buffer.append("?page=");
        buffer.append(String.valueOf(pageable.getPageNumber()+1));
        buffer.append("&size=");
        buffer.append(String.valueOf(pageable.getPageSize()));
        if(pageable.getSort()!=null){
            buffer.append("&sort=");
            Sort sort = pageable.getSort();
            sort.forEach((order)->{
                buffer.append(order.getProperty());
                if(order.getDirection()!= Sort.Direction.ASC)
                    buffer.append(",desc");
            });
        }
        if(!filter.getSearch().isEmpty()){
            buffer.append("&search=");
            buffer.append(filter.getSearch());
        }
        return buffer.toString();
    }
}
