package jun.vn.services;

import java.util.List;

import jun.vn.entity.Video;

public interface IVideoService {
	List<Video> findByTitle(String keyword);

	List<Video> findAll();

	Video findById(String videoId);

	void delete(String videoId);

	void update(Video video);

	void insert(Video video);
}
