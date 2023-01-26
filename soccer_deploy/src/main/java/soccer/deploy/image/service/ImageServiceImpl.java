package soccer.deploy.image.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import soccer.deploy.image.entity.Image;
import soccer.deploy.image.repository.JpaImageRepository;

@Service
@Transactional
public class ImageServiceImpl implements ImageService {

	@Autowired
	private JpaImageRepository jpaImageRepository;
	
public void RegImage(List<Image> image) {
	jpaImageRepository.saveAll(image);
		
}

@Override
public List<Image> findImgArticle(Long articleId) {

	return jpaImageRepository.findByArticle(articleId);
}
}
