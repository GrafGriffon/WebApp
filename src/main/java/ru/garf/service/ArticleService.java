package ru.garf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.garf.dao.ArtRepository;
import ru.garf.model.Art;

import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ArticleService {
    @Autowired
    private ArtRepository repository;

    public void save(Art article) {
        Art savedArticle = repository.save(article);
        System.out.println(savedArticle.getId());
    }

    public List<Art> getAll() {
        return StreamSupport
                .stream(
                        Spliterators.spliteratorUnknownSize(repository.findAll().iterator(), Spliterator.NONNULL),
                        false)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public Art getElement(Integer articleId) {
    return repository.findOne(articleId);
    }

    public void delete(Integer articleId) {
        repository.delete(articleId);
    }
}
