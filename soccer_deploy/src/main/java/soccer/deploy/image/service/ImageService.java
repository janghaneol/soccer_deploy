package soccer.deploy.image.service;

import java.util.List;

import soccer.deploy.image.entity.Image;

public interface ImageService {
	
	public void RegImage(List<Image> image);
	
	public List<Image> findImgArticle(Long articleId);
}
