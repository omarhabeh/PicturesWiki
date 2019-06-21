package hibernate;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="PICTURE")
public class Pics {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int id;
	private int picId;
	private String name;
	private String description;
	@Lob
	private byte[] pic;
	private String previewUrl ;
	
	 public Pics(){}
	public Pics(int picId,String name,String desc,byte[] p){
		this.name=name;
		this.picId=picId;
		this.description=desc;
		this.pic=p;
	}
	
	public String getPreviewUrl() throws UnsupportedEncodingException {
		byte[] encodeBase64 = Base64.getEncoder().encode(getPic());
	    String base64Encoded = new String(encodeBase64, "UTF-8");
        setPreviewUrl(base64Encoded);
		return previewUrl;
	}
	public void setPreviewUrl(String previewUrl) {
		this.previewUrl = previewUrl;
	}
	public byte[] getPic() {
		return pic;
	}
	public void setPic(byte[] pic) {
		this.pic = pic;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getPicId() {
		return picId;
	}
	public void setPicId(int picId) {
		this.picId = picId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Pics [id=" + id + ", Name=" + name + ", picId=" + picId + ", description=" + description + "]";
	}

}
