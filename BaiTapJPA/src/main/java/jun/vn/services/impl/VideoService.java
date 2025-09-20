package jun.vn.services.impl;

import java.util.List;

import jun.vn.dao.IVideoDao;
import jun.vn.dao.impl.VideoDao;
import jun.vn.entity.Video;
import jun.vn.services.IVideoService;

public class VideoService implements IVideoService {
	private IVideoDao videoDao = new VideoDao();

	@Override
	public List<Video> findByTitle(String keyword) {
		return videoDao.findByTitle(keyword);
	}

	@Override
	public List<Video> findAll() {
		return videoDao.findAll();
	}

	@Override
	public Video findById(String videoId) {
		return videoDao.findById(videoId);
	}

	@Override
	public void delete(String videoId) {
		videoDao.delete(videoId);
	}

	@Override
	public void update(Video video) {
		videoDao.update(video);
	}

	@Override
	public void insert(Video video) {
		videoDao.insert(video);
	}

}
