package kurd.kurdestan.snappfood.category;

import kurd.kurdestan.snappfood.common.SearchCriteria;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class CategotyServiceImp implements ICategoryService {

    private CategoryRepository repository;

    @Override
    public Category save(Category category) {
        return repository.save(category);
    }

    @Override
    public Category update(Category category) {
        Category lastCategory = getById(category.getId());
        lastCategory.setTypeOfCategory(category.getTypeOfCategory());
        lastCategory.setImage(category.getImage());
        lastCategory.setTitle(category.getTitle());

        return repository.save(lastCategory);
    }

    @Override
    public Category getById(Long id) {

        Optional<Category> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new NotFoundException("Category Not Found ");
        }
        return optional.get();
    }

    @Override
    public Category getAllByTitle(String title) {
        Optional<Category> optional = repository.findByTitle(title);
        if (!optional.isPresent()) {
            throw new NotFoundException("Category Not Found");
        }

        return optional.get();
    }

    @Override
    public List<Category> getAll() {
        return (List<Category>) repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        getById(id);
        repository.deleteById(id);
    }

    public List<Category> search(List<SearchCriteria> searchCriteria) {
        CategorySpecifcation categorySpecifcation = new CategorySpecifcation();
        searchCriteria.forEach(criteria -> categorySpecifcation.add(criteria));
        return repository.findAll(categorySpecifcation);
    }

    @Override
    public Page<Category> paging(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page, size, Sort.by("id").descending()));
    }

    @Override
    public Page<Category> searchPaging(List<SearchCriteria> searchCriteria, Integer page, Integer size) {
        CategorySpecifcation categorySpecifcation = new CategorySpecifcation();
        searchCriteria.forEach(criteria -> categorySpecifcation.add(criteria));

        return repository.findAll(categorySpecifcation, PageRequest.of(page, size, Sort.by("id").descending()));
    }
}
