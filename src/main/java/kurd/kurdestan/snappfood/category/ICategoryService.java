package kurd.kurdestan.snappfood.category;


import kurd.kurdestan.snappfood.common.SearchCriteria;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICategoryService {

    Category save(Category category);
    Category update(Category category);
    Category getById(Long id);
    Category getAllByTitle(String title);
    List<Category> getAll();
    void deleteById(Long id);

    List<Category> search(List<SearchCriteria> searchCriteria);

    Page<Category> searchPaging(List<SearchCriteria> searchCriteria, Integer page, Integer size);





}
