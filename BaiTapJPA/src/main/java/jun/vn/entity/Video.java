package jun.vn.entity;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name="videos")
@NamedQuery(name = "Video.findAll", query = "SELECT v FROM Video v")
public class Video implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="VideoId")
	private String videoId;
	
	@Column(name="Active")
	private boolean active;
	
	@Column(name="Decription", columnDefinition = "NVARCHAR(MAX)")
	private String decription;
	
	@Column(name="Poster")
	private String poster;
	
	@Column(name="Title", columnDefinition = "NVARCHAR(MAX)")
	private String title;
	
	@Column(name="Views")
	private String views;
	
	@ManyToOne
	@JoinColumn(name="CategoryId")
	private Category category;

	public Video() {
	}

	public Video(String videoId, boolean active, String decription, String title, String views, Category category) {
		super();
		this.videoId = videoId;
		this.active = active;
		this.decription = decription;
		this.title = title;
		this.views = views;
		this.category = category;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getViews() {
		return views;
	}

	public void setViews(String views) {
		this.views = views;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
