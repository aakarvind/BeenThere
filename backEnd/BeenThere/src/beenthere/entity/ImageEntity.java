package beenthere.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import beenthere.model.Image;

@Entity
@Table(name = "ImageTable")
@GenericGenerator(name = "imageIdGen", strategy = "increment")
public class ImageEntity 
{
	@Id
	@GeneratedValue(generator = "imageIdGen")
	private Integer imageId;
	
	private String imageStr;
	
	public ImageEntity() {}
	
	public ImageEntity(Image image){
		setImageStr(image.getImageBase64Str());
	}
	
	public Integer getImageId() {
		return imageId;
	}
	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}
	public String getImageStr() {
		return imageStr;
	}
	public void setImageStr(String imageStr) {
		this.imageStr = imageStr;
	}
	
}
